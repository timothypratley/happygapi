(ns happy.monkey
  "Discovers Google API definitions."
  (:require [clj-http.client :as http]))

(def discovery-url "https://www.googleapis.com/discovery/v1/apis")

(defn fetch
  "API definitions rarely change, use the memoized version as much as possible."
  [url]
  (-> (http/get url {:accept :json :as :json})
      (:body)))

(defn list-apis
  "Returns a vector of preferred APIs with their discovery URL."
  []
  (vec
    (for [{:keys [preferred name version discoveryRestUrl]} (-> (fetch discovery-url)
                                                                (:items))
          :when preferred]
      [name version discoveryRestUrl])))
