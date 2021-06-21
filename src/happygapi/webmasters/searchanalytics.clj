(ns happygapi.webmasters.searchanalytics
  "Search Console API: searchanalytics.
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/api/reference/rest/v3/searchanalytics"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/webmaster-tools/api/reference/rest/v3/searchanalytics/query
  
  Required parameters: siteUrl
  
  Optional parameters: none
  
  Body: 
  
  {:searchType string,
   :startDate string,
   :dataState string,
   :rowLimit integer,
   :dimensions [string],
   :endDate string,
   :dimensionFilterGroups [{:filters [ApiDimensionFilter],
                            :groupType string}],
   :startRow integer,
   :aggregationType string}
  
  Query your data with filters and parameters that you define. Returns zero or more rows grouped by the row keys that you define. You must define a date range of one or more days.
  
  When date is one of the group by values, any days without data are omitted from the result list. If you need to know which days have data, issue a broad date range query grouped by date for any metric, and see which day rows are returned."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteUrl})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/searchAnalytics/query"
     #{:siteUrl}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
