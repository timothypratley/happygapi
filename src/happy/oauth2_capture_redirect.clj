(ns happy.oauth2-capture-redirect
  "Receive a token in a redirect from the oauth provider.
  Generally you'd want to implement a route in your app
  that capture the code parameter.
  This namespace requires ring as a dependency in your project."
  (:require [ring.adapter.jetty :as jetty]
            [clojure.string :as str]))

(defn wait-for-redirect [config]
  (let [code (promise)
        server (jetty/run-jetty
                 (fn [request]
                   (deliver code (some-> request :query-string (str/split #"=") second))
                   {:status 200
                    :body   "ok"})
                 (merge {:port 8888 :join? false} config))]
    @code
    (.stop server)
    @code))
