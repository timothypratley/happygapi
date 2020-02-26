(ns happygapi.analytics.data
  "Google Analytics API
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "analytics_schema.edn"))))

(defn ga-get$
  "Required parameters: end-date, ids, start-date, metrics
  
  Optional parameters: start-index, include-empty-rows, filters, max-results, output, dimensions, segment, samplingLevel, sort
  
  Returns Analytics data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"end-date" "ids" "start-date" "metrics"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/ga"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn mcf-get$
  "Required parameters: end-date, ids, start-date, metrics
  
  Optional parameters: start-index, filters, max-results, dimensions, samplingLevel, sort
  
  Returns Analytics Multi-Channel Funnels data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"end-date" "ids" "start-date" "metrics"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/mcf"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn realtime-get$
  "Required parameters: ids, metrics
  
  Optional parameters: dimensions, filters, max-results, sort
  
  Returns real time data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"ids" "metrics"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/realtime"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
