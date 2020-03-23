(ns happy.oauth2
  "Helpers for getting an OAuth 2.0 token.
  See https://developers.google.com/identity/protocols/OAuth2WebServer"
  (:require [clj-http.client :as http]
            [clojure.string :as str]
            [clojure.set :as set])
  (:import (java.util Date)))

(defn- redirect-to-google
  "Step 2: Redirect to Google's OAuth 2.0 server.
  Builds the URL to send the user to for them to authorize your app.
  Do not call this function directly, it is called from set-authorization-parameters (step 1).
  For local testing you can paste this URL into your browser,
  or call (clojure.java.browse/browse-url (redirect-to-google my-config)).
  In your app you need to send your user to this URL, usually with a redirect response."
  [{:as config :keys [client_id redirect_uri]} scopes {:as optional :keys [state login_hint]}]
  (str "https://accounts.google.com/o/oauth2/v2/auth"
       "?client_id=" client_id
       "&redirect_uri=" redirect_uri
       "&scope=" (str/join " " scopes)
       "&state=" state
       "&response_type=code"
       "&access_type=offline"))

(defn set-authorization-parameters
  "Step 1: Set authorization parameters.
  We tell Google to expect a visit from our user.
  Returns the URL to redirect the user to."
  ([config scopes] (set-authorization-parameters config scopes nil))
  ([{:as config :keys [client_id redirect_uri]} scopes {:as optional :keys [state login_hint]}]
   (http/get "https://accounts.google.com/o/oauth2/v2/auth"
             {:query-params (merge {:client_id     client_id
                                    :redirect_uri  redirect_uri
                                    :response_type "code"
                                    :scope         (str/join " " scopes)}
                                   optional)})
   (redirect-to-google config scopes optional)))

(defn with-timestamp
  "Google won't give us the time of day, so let's check our clock."
  [{:as credentials :keys [expires_in]}]
  (assoc credentials
    :expires-at (Date. ^long (+ (* expires_in 1000) (System/currentTimeMillis)))))

;; Step 3: Google prompts user for consent.
;; Sit back and wait.
;; There should be a route in your app to handle the redirect from Google (see step 4).
;; happy.oauth2-capture-redirect shows how you could do this,
;; and is useful if you don't want to run a server.

(defn exchange-code
  "Step 5: Exchange authorization code for refresh and access tokens.
  When the user is redirected back to your app from Google with a short lived code,
  exchange the code for a long lived access token."
  [{:keys [client_id client_secret redirect_uri]} code]
  (with-timestamp
    (:body (http/post "https://oauth2.googleapis.com/token"
                      {:form-params {:client_id     client_id
                                     :client_secret client_secret
                                     :code          code
                                     :grant_type    "authorization_code"
                                     :redirect_uri  redirect_uri}
                       :accept      :json
                       :as          :json}))))

(defn redirect-from-google
  "Step 4: Handle the OAuth 2.0 server response.
  In your app server, create a route `:redirect-uri` receives the `code` parameter."
  [config {{:keys [code]} :params}]
  (exchange-code config code))

(defn maybe-grow-scopes
  "Incremental authorization.
  Given a credentials map, re-authorizes with additional scopes.
  Include previous scopes when asking for new scopes.
  Scopes are a vector of urls.
  Credentials contain tokens and scopes.
  Returns the URL to redirect the user to,
  or nil if the scopes are already authorized."
  [config {:as credentials :keys [scopes]} new-scopes optional]
  (let [scopes (set scopes)]
    (when-not (set/subset? (set new-scopes) (set scopes))
      (set-authorization-parameters config scopes optional))))

(defn refresh-token
  "Given a config map, and a credentials map containing a refresh_token,
  fetches a new access token.
  Returns the response if successful, which is a map of credentials containing an access token.
  Refresh tokens eventually expire, and attempts to refresh will fail with 401.
  Therefore, calls that could cause a refresh should catch 401 exceptions,
  call set-authorization-parameters and redirect."
  [{:as config :keys [client_id client_secret]} {:as credentials :keys [refresh_token]}]
  (with-timestamp
    (merge credentials
           (:body (http/post "https://oauth2.googleapis.com/token"
                             {:form-params {:client_id     client_id
                                            :client_secret client_secret
                                            :grant_type    "refresh_token"
                                            :refresh_token refresh_token}
                              :accept      :json
                              :as          :json})))))

(defn revoke-token
  "Given a credentials map containing either an access token or refresh token, revokes them."
  [{:keys [access_token refresh_token]}]
  (http/post "https://oauth2.googleapis.com/revoke"
             {:accept :json
              :as :json
              :form-params {"token" (or access_token refresh_token)}}))
