(ns happy.oauth2-capture-redirect
  "Reference for receiving a token in a redirect from the oauth provider.
  If you are making a web app, implement a route in your app that captures the code parameter.
  If you use this namespace, add ring as a dependency in your project."
  (:require [clojure.java.browse :as browse]
            [clojure.set :as set]
            [clojure.string :as str]
            [happy.oauth2 :as oauth2]
            [ring.adapter.jetty :as jetty]))

(defn wait-for-redirect [{:as config :keys [redirect_uri redirect_uris]}]
  (let [code (promise)
        port (or (some-> (or redirect_uri (last redirect_uris))
                         (str/split #":")
                         (last)
                         (Integer/parseInt))
                 80)
        server (jetty/run-jetty
                 (fn [request]
                   (deliver code (some-> request :query-string (str/split #"=") second))
                   {:status 200
                    :body   "ok"})
                 (merge {:port port :join? false} config))]
    (try
      @code
      (finally
        (.stop server)))))

(defn request-code [config scopes optional]
  (-> (oauth2/set-authorization-parameters config scopes optional)
      (browse/browse-url))
  (wait-for-redirect config))

(defn grow-scopes
  "Incremental authorization.
  Given a credentials map, re-authorizes with additional scopes.
  Include previous scopes when asking for new scopes.
  Scopes are a vector of urls.
  Credentials contain tokens and scopes.
  Returns the URL to redirect the user to,
  or nil if the scopes are already authorized."
  [config {:as credentials :keys [scopes]} new-scopes optional]
  (let [scopes (set/union (set scopes) (set new-scopes))]
    (oauth2/exchange-code config (request-code config scopes optional))))

(defn update-credentials [config credentials scopes optional]
  (cond
    (not (oauth2/has-scopes? credentials scopes))
    (grow-scopes config credentials scopes optional)

    (oauth2/valid? credentials)
    credentials

    (oauth2/refreshable? config credentials)
    (oauth2/refresh-credentials config scopes credentials)

    :else
    (oauth2/exchange-code config (request-code config scopes optional))))
