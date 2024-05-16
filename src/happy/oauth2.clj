(ns happy.oauth2
  "Helpers for getting an OAuth 2.0 token.
  See https://developers.google.com/identity/protocols/OAuth2WebServer"
  (:require [clj-http.client :as http]
            [clojure.string :as str]
            [clojure.set :as set]
            [buddy.sign.jwt :as jwt]
            [buddy.core.keys :as keys])
  (:import (java.util Date)
           (java.net URLEncoder)))

(set! *warn-on-reflection* true)

(defn url-encode [^String s]
  (URLEncoder/encode s "UTF-8"))

(defn query-string
  "If you have clj-http as a dependency, prefer http.client/generate-query-string instead."
  [query-params]
  (str/join "&" (for [[k v] query-params]
                  (str (url-encode (name k)) "=" (url-encode (str v))))))

(defn provider-login-url
  "Step 1: Set authorization parameters.
  Builds the URL to send the user to for them to authorize your app.
  For local testing you can paste this URL into your browser,
  or call (clojure.java.browse/browse-url (redirect-to-google my-config)).
  In your app you need to send your user to this URL, usually with a redirect response."
  [{:as config :keys [auth_uri client_id redirect_uri redirect_uris]} scopes {:as optional :keys [state login_hint]}]
  {:pre [auth_uri client_id (or redirect_uri redirect_uris) scopes]}
  (str auth_uri "?"
       (query-string (merge {:client_id     client_id
                             :response_type "code"
                             :redirect_uri  (or redirect_uri (last redirect_uris))
                             :access_type   "offline"
                             :scope         (str/join " " scopes)}
                            optional))))

;; Step 2: Redirect to Google's OAuth 2.0 server.

;; Step 3: Google prompts user for consent.
;; Sit back and wait.
;; There should be a route in your app to handle the redirect from Google (see step 4).
;; happy.oauth2-capture-redirect shows how you could do this,
;; and is useful if you don't want to run a server.

;; Step 4: Handle the OAuth 2.0 server response

(defn with-timestamp
  "Google won't give us the time of day, so let's check our clock."
  [{:as credentials :keys [expires_in]}]
  {:pre [(int? expires_in)]}
  (assoc credentials
    :expires_at (Date. ^long (+ (* expires_in 1000) (System/currentTimeMillis)))))

(defn exchange-code
  "Step 5: Exchange authorization code for refresh and access tokens.
  When the user is redirected back to your app from Google with a short-lived code,
  exchange the code for a long-lived access token."
  [{:keys [token_uri client_id client_secret redirect_uri redirect_uris refresh_token]} code]
  {:pre [token_uri client_id client_secret (or redirect_uri redirect_uris) code]}
  (with-timestamp
    (:body (http/post token_uri
                      {:form-params {:client_id     client_id
                                     :client_secret client_secret
                                     :code          code
                                     :grant_type    "authorization_code"
                                     :redirect_uri  (or redirect_uri (last redirect_uris))}
                       :accept      :json
                       :as          :json}))))

(defn refresh-credentials
  "Given a config map, and a credentials map containing either a refresh_token or private_key,
  fetches a new access token.
  Returns the response if successful, which is a map of credentials containing an access token.
  Refresh tokens eventually expire, and attempts to refresh will fail with 401.
  Therefore, calls that could cause a refresh should catch 401 exceptions,
  call set-authorization-parameters and redirect."
  [{:as config :keys [token_uri client_id client_secret client_email private_key]} scopes {:as credentials :keys [refresh_token]}]
  {:pre [token_uri
         (or (and client_id client_secret refresh_token)
             (and client_email private_key))]}
  (let [now (quot (.getTime (Date.)) 1000)
        params (cond private_key
                     {:grant_type "urn:ietf:params:oauth:grant-type:jwt-bearer"
                      :assertion  (jwt/sign
                                    {:iss   client_email,
                                     :scope (str/join " " scopes),
                                     :aud   token_uri
                                     :exp   (+ now 3600)
                                     :iat   now}
                                    (keys/str->private-key private_key)
                                    {:alg    :rs256
                                     :header {:alg "RS256"
                                              :typ "JWT"}})}

                     refresh_token
                     {:client_id     client_id
                      :client_secret client_secret
                      :grant_type    "refresh_token"
                      :refresh_token refresh_token})
        resp (http/post token_uri
                        {:form-params      params
                         :accept           :json
                         :as               :json
                         :throw-exceptions false})]
    (when (http/success? resp)
      (with-timestamp (:body resp)))))

(defn revoke-token
  "Given a credentials map containing either an access token or refresh token, revokes them."
  [{:keys [access_token refresh_token]}]
  {:pre [(or access_token refresh_token)]}
  (http/post "https://oauth2.googleapis.com/revoke"
             {:accept      :json
              :as          :json
              :form-params {"token" (or access_token refresh_token)}}))

(defn valid? [{:as credentials :keys [expires_at access_token]}]
  (boolean
    (and expires_at access_token
         (neg? (.compareTo (Date.) expires_at)))))

(defn refreshable? [{:as config :keys [private_key]} {:as credentials :keys [refresh_token]}]
  (boolean (or refresh_token private_key)))

(defn credential-scopes [credentials]
  (set (some-> (:scope credentials) (str/split #" "))))

(defn has-scopes? [credentials scopes]
  ;; TODO: scopes have a hierarchy
  (set/subset? (set scopes) (credential-scopes credentials)))

(defn auth-header
  "Given credentials, returns request header suitable for merging into a request."
  [{:as credentials :keys [access_token]}]
  {:pre [access_token]}
  {:headers {"Authorization" (str "Bearer " access_token)}})
