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

(defn fresh-credentials
  "Opens a browser to authenticate, waits for a redirect, and returns a code."
  [{:as config :keys [redirect_uri redirect_uris]} scopes optional]
  {:pre [(or redirect_uri redirect_uris)]}
  (let [p (promise)
        uri (or redirect_uri (last redirect_uris))
        [match protocol host _ port path] (re-find #"^(http://)(localhost|127.0.0.1)(:(\d+))?(/.*)?$" uri)
        _ (assert match "redirect_uri should be http://localhost/redirect")
        port (if port
               (Integer/parseInt port)
               0)
        http-redirect-handler (fn [request]
                                {:status 200
                                 :body   (if @(deliver p (get-in request [:params "code"]))
                                           "Code received, authentication successful."
                                           "No code in response")})
        server (jetty/run-jetty (params/wrap-params http-redirect-handler)
                                {:port port :join? false})
        port (get-port server)
        config (assoc config :redirect_uri (str protocol host ":" port path))]
    (try
      (-> (oauth2/provider-login-url config scopes optional)
          ;; send the user to the provider to login
          (browse/browse-url))
      ;; when the user is redirected to our local service, which receives a code,
      ;; we now exchange that code with the provider for credentials
      (if-let [code (deref p login-timeout nil)]
        (oauth2/exchange-code config code)
        (throw (ex-info "Login timeout, no code received."
                        {:id ::login-timeout})))
      (finally
        (.stop server)))))

(defn update-credentials [config credentials scopes optional]
  ;; scopes can grow
  (let [scopes (set/union (oauth2/credential-scopes credentials) (set scopes))]
    ;; merge to retain refresh token
    (merge credentials
           (cond
             ;; already have valid credentials
             (and (oauth2/valid? credentials)
                  (oauth2/has-scopes? credentials scopes))
             ;>
             credentials

             ;; try to refresh existing credentials
             (and (oauth2/refreshable? config credentials)
                  (oauth2/has-scopes? credentials scopes))
             ;>
             (or (oauth2/refresh-credentials config scopes credentials)
                 (fresh-credentials config scopes optional))

             :else
             ;>
             (fresh-credentials config scopes optional)))))
