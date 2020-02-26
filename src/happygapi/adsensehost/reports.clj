(ns happygapi.adsensehost.reports
  "AdSense Host API
  Generates performance reports, generates ad codes, and provides publisher management capabilities for AdSense Hosts.
  See: https://developers.google.com/adsense/host/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adsensehost_schema.edn"))))

(defn generate$
  "Required parameters: startDate, endDate
  
  Optional parameters: locale, filter, dimension, startIndex, metric, sort, maxResults
  
  Generate an AdSense report based on the report request sent in the query parameters. Returns the result as JSON; to retrieve output in CSV format specify \"alt=csv\" as a query parameter."
  {:scopes ["https://www.googleapis.com/auth/adsensehost"]}
  [auth args]
  {:pre [(util/has-keys? args #{"startDate" "endDate"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsensehost/v4.1/"
     "reports"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
