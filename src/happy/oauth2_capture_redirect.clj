(ns happy.oauth2-capture-redirect
  "Reference for receiving a token in a redirect from the oauth provider.
  If you are making a web app, implement a route in your app that captures the code parameter.
  If you use this namespace, add ring as a dependency in your project."
  (:require [clojure.java.browse :as browse]
            [clojure.set :as set]
            [clojure.string :as str]
            [happy.oauth2 :as oauth2]
            [ring.adapter.jetty :as jetty]))

(defn maybe-parse-int [s]
  (try
    (Integer/parseInt s)
    (catch Exception _
      nil)))

(defn wait-for-redirect [{:as config :keys [redirect_uri redirect_uris]}]
  (let [code (promise)
        port (or (some-> (or redirect_uri (last redirect_uris))
                         (str/split #":")
                         (last)
                         (maybe-parse-int))
                 80)
        server (jetty/run-jetty
                 (fn [request]
                   (deliver code (some-> request :query-string (str/split #"=") second))
                   {:status 200
                    :body   "ok"})
                 (merge {:port port :join? false} config))]
    (-> (fn []
          (Thread/sleep 20000)
          (deliver code nil))
        (Thread. "wait for user timeout")
        (.start))
    (try
      @code
      (finally
        (.stop server)))))

(defn request-code [config scopes optional]
  (-> (oauth2/set-authorization-parameters config scopes optional)
      (browse/browse-url))
  (wait-for-redirect config))

(defn update-credentials [config credentials scopes optional]
  ;; scopes can grow
  (let [scopes (set/union (set (:scopes credentials)) (set scopes))]
    ;; merge to retain refresh token
    (merge credentials
           (cond
             (and (oauth2/valid? credentials)
                  (oauth2/has-scopes? credentials scopes))
             credentials

             (and (oauth2/refreshable? config credentials)
                  (oauth2/has-scopes? credentials scopes))
             (oauth2/refresh-credentials config scopes credentials)

             :else
             (oauth2/exchange-code config (request-code config scopes optional))))))
