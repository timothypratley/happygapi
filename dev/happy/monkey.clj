(ns happy.monkey
  "Discovers Google APIs and produces defn forms to call them"
  (:require [clj-http.client :as http]
            [clojure.string :as str]))

(def discovery-url "https://www.googleapis.com/discovery/v1/apis")

(defn fetch [url]
  (-> (http/get url {:accept :json :as :json})
      (:body)))
#_(fetch "https://sheets.googleapis.com/$discovery/rest?version=v4")

(defn list-apis
  "Returns a list of preferred APIs with their discovery URL."
  []
  (for [{:keys [preferred name version discoveryRestUrl]} (-> (fetch discovery-url)
                                                              (:items))
        :when preferred]
    [name version discoveryRestUrl]))
#_(list-apis)

(defn- match-params
  "Filter the parameters by a given function"
  [params f]
  (for [[k v] params
        :when (f v)]
    (name k)))

(defn- get-path-params
  "Return a vector of parameter names which appear in the URL path"
  [params]
  (match-params params (fn [{:keys [location]}]
                         (= "path" location))))

(defn- get-required-params
  "Return a vector of required parameter names"
  [params]
  (match-params params :required))

(defn method-name
  "To avoid collisions with clojure.core, methods are named like `get$`.
  Where they are a sub-resource, they are named like `parent-get$`"
  [id]
  (str (str/join \- (drop 2 (str/split id #"\."))) \$))

(comment
 ;; TODO
 (defmethod call-params :oauth [state params]
   ;; TODO: check for expired auth token and call refresh if possible
   (let [headers (if (params :headers) (params :headers) {})]
     (assoc params :headers (assoc headers "Authorization" (str "Bearer " (@state :token))))))


 (defmethod call-params :simple [state, params]
   (assoc params :query-params (assoc (params :query-params) "key" (@state :api_key)))))

(defn extract-methods [base-url resource]
  (for [[_ {:keys [id path parameters description scopes httpMethod]}] (:methods resource)
        :let [required-parameters (get-required-params parameters)
              post? (= httpMethod "POST")]]
    `(~'defn ~(symbol (method-name id))
      ~(str "Required parameters: " (if (seq required-parameters)
                                      (str/join "," required-parameters)
                                      "none")
            \newline \newline
            description)
      {:scopes ~scopes}
      ~(if post?
         '[auth args body]
         '[auth args])
      {:pre [(~'util/has-keys? ~'args ~(set required-parameters))]}
      (~'util/get-response
       (~(symbol "http" (str/lower-case httpMethod))
        (~'util/get-url ~base-url ~path ~(set (get-path-params parameters)) ~'args)
        (~'merge-with ~'merge
         ~(cond->
           '{:throw-exceptions false
             :query-params args
             :accept :json
             :as :json}
           post? (merge '{:content-type :json
                          :body body}))
         ~'auth))))))

(defn extract-all-methods [baseUrl resources]
  (for [[_ resource] resources]
    (apply concat
           (extract-methods baseUrl resource)
           (extract-all-methods baseUrl (:resources resource)))))

(defn build-methods [{:keys [baseUrl resources name version]}]
  (println "Building" name version)
  (for [[k resource] resources]
    [k (apply concat (extract-all-methods baseUrl {k resource}))]))

(defn fetch-all-apis []
  (for [[name version api-url] (list-apis)
        ;; gameConfiguration 404s, just ignore it
        :let [api (try
                    (println "Fetching" name version)
                    (fetch api-url)
                    (catch Exception ex))]
        :when api]
    api))
