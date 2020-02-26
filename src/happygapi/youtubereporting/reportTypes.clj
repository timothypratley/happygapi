(ns happygapi.youtubereporting.reportTypes
  "YouTube Reporting API
  Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
  See: https://developers.google.com/youtube/reporting/v1/reports/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "youtubereporting_schema.edn"))))

(defn list$
  "Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner, pageToken, includeSystemManaged, pageSize
  
  Lists report types."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/reportTypes"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
