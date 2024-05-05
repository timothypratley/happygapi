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

(defn redirect-uri->port
  "Opening a browser and redirecting to a local server
  only makes sense for localhost redirect-uris.

  Known limitation: Google does not support no ipv6 [::1] with random ports"
  [uri]
  (let [[match protocol host _ port path] (re-find #"^(http://)(localhost|127.0.0.1)(:(\d+))?(/.*)?$" uri)
        port (maybe-parse-int port)]
    (if (not match)
      (throw (RuntimeException. "URI doesn't match pattern"))
      (or port
          0)))) ;; Jetty's magic value 0 = random port

(defn add-port
  [uri random-port]
  (let [[match protocol host _ port path] (re-find #"^(http://)(localhost|127.0.0.1)(:(\d+))?(/.*)?$" uri)]
    (if (not match)
      (throw (RuntimeException. "URI doesn't match pattern"))
      (str protocol host ":" random-port path))))

(defn query-string->params
  "Converts an URI query-string a=b&c=d&e=f&...
  into a param map {:a \"b\" :c \"d\" :e \"f\"}."
  [q]
  (let [split-by-& #(str/split % #"&")
        split-by-= #(str/split % #"=")
        pairs (map split-by-= (split-by-& q))
        parameters (into {} (for [[k v] pairs]
                              [(keyword k) v]))]
    parameters))

(defn wait-for-redirect
  "wait-for-redirect takes a callback function and a Google client
  config. The callback function will be called, when the jetty server
  has been started. It receives a single argument with the effective
  URI, i.e. the URI with the correct (maybe random) port."
  [on-server-started-callback
   {:as config :keys [redirect_uri redirect_uris]}]
  (let [code (promise)
        uri (or redirect_uri (last redirect_uris))
        port (redirect-uri->port uri)
        http-redirect-handler (fn [request]
                                (deliver code (some-> request
                                                      :query-string
                                                      query-string->params
                                                      :code))
                                {:status 200
                                 :body   "ok"})
        server (jetty/run-jetty http-redirect-handler
                                {:port port :join? false})
        _ (.setStopTimeout server 1000) ;; wait 1000ms for graceful shutdown, to avoid races between stopping and returning the response
        
        ^org.eclipse.jetty.server.NetworkConnector
        connector (-> server
                      .getConnectors
                      first)
        effective-port (.getLocalPort connector)
        effective-uri (if (= 0 port)
                        (add-port uri effective-port)
                        uri)]
    (on-server-started-callback effective-uri)
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
  (let [on-server-started-callback (fn [uri]
                                     (-> config
                                         (dissoc :redirect_uri :redirect_uris)
                                         (assoc :redirect_uri uri)
                                         (oauth2/set-authorization-parameters scopes optional)
                                         (browse/browse-url)))]
    (wait-for-redirect on-server-started-callback config)))

(defn update-credentials [config credentials scopes optional]
  ;; scopes can grow
  (let [scopes (set/union (set (oauth2/credential-scopes credentials)) (set scopes))]
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
