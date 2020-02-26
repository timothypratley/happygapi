(ns happygapi.analytics.metadata
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

(defn columns-list$
  "Required parameters: reportType
  
  Optional parameters: none
  
  Lists all columns for a report type"
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportType"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "metadata/{reportType}/columns"
     #{"reportType"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
