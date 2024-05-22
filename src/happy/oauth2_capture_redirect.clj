(ns happy.oauth2-capture-redirect
  "Reference for receiving a token in a redirect from the oauth provider.
  If you are making a web app, implement a route in your app that captures the code parameter.
  If you use this namespace, add ring as a dependency in your project."
  (:require [clojure.java.browse :as browse]
            [clojure.set :as set]
            [happy.oauth2 :as oauth2]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.params :as params])
  (:import (org.eclipse.jetty.server NetworkConnector Server)))

(set! *warn-on-reflection* true)

(defn get-port [^Server server]
  (-> server .getConnectors ^NetworkConnector first .getLocalPort))

(def login-timeout
  "If the user doesn't log in after 2 minutes, stop waiting."
  (* 2 60 1000))

(defn browse-to-provider [config scopes optional]
  (-> (oauth2/provider-login-url config scopes optional)
      (browse/browse-url)))

(defn fresh-credentials
  "Opens a browser to authenticate, waits for a redirect, and returns a code.
  Defaults access_type to offline,
  state to a random uuid which is checked when redirected back,
  and include_granted_scopes true."
  [{:as config :keys [redirect_uri redirect_uris]} scopes optional]
  {:pre [(or redirect_uri redirect_uris)]}
  (let [p (promise)
        uri (or redirect_uri (last redirect_uris))
        [match protocol host _ port path] (re-find #"^(http://)(localhost|127.0.0.1)(:(\d+))?(/.*)?$" uri)
        _ (or match
              (throw (ex-info "redirect_uri should be http://localhost"
                              {:id     ::bad-redirect-uri
                               :config config})))
        port (if port
               (Integer/parseInt port)
               0)
        http-redirect-handler (fn [request]
                                {:status 200
                                 :body   (if (get @(deliver p (get request :params)) "code")
                                           "Code received, authentication successful."
                                           "No code in response")})
        server (jetty/run-jetty (params/wrap-params http-redirect-handler)
                                {:port port :join? false})
        port (get-port server)
        config (assoc config :redirect_uri (str protocol host ":" port path))
        optional (merge {:access_type            "offline"
                         :state                  (str (random-uuid))
                         :include_granted_scopes true}
                        optional)
        ;; send the user to the provider to authenticate and authorize.
        ;; this url includes the redirect_uri as a query param,
        ;; so we must provide port chosen by our local server
        _ (browse-to-provider config scopes optional)
        ;; wait for the user to get redirected to localhost with a code
        {:strs [code state] :as return-params} (deref p login-timeout nil)]
    ;; allow a bit of time to deliver the response before shutting down the server
    (.setStopTimeout server 1000)
    (.stop server)

    (or (= (:state optional) state)
        (throw (ex-info "Return state does not match redirect state"
                        {:id            ::state-mismatch
                         :optional      optional
                         :return-params return-params})))
    (if code
      ;; exchange the code with the provider for credentials
      ;; (must have the same config as browse, the redirect_uri needs the correct port)
      (oauth2/exchange-code config code)
      (throw (ex-info "Login timeout, no code received."
                      {:id ::login-timeout})))))

(defn update-credentials
  "Use credentials if valid, refresh if necessary, or get new credentials.
  For valid optional params, see https://developers.google.com/identity/protocols/oauth2/web-server#httprest_1"
  ([config credentials scopes] (update-credentials config credentials scopes nil))
  ([config credentials scopes optional]
   ;; scopes can grow
   (let [scopes (set/union (oauth2/credential-scopes credentials) (set scopes))]
     ;; merge to retain refresh token
     (merge credentials
            (or
              ;; already have valid credentials
              (and (oauth2/valid? credentials)
                   (oauth2/has-scopes? credentials scopes)
                   credentials)
              ;; try to refresh existing credentials
              (and (oauth2/refreshable? config credentials)
                   (oauth2/has-scopes? credentials scopes)
                   (oauth2/refresh-credentials config scopes credentials))
              ;; new credentials required
              (fresh-credentials config scopes optional))))))
