(ns happygapi.analytics.metadata
  "Google Analytics API: metadata.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/metadata"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn columns-list$
  "https://developers.google.com/analytics/api/reference/rest/v3/metadata/columns/list
  
  Required parameters: reportType
  
  Optional parameters: none
  Lists all columns for a report type"
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.edit"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:reportType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "metadata/{reportType}/columns"
     #{:reportType}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
