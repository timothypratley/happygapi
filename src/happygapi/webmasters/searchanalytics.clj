(ns happygapi.webmasters.searchanalytics
  "Search Console API
  View Google Search Console data for your verified sites.
  See: https://developers.google.com/webmaster-tools/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn query$
  "Required parameters: siteUrl
  
  Query your data with filters and parameters that you define. Returns zero or more rows grouped by the row keys that you define. You must define a date range of one or more days.
  
  When date is one of the group by values, any days without data are omitted from the result list. If you need to know which days have data, issue a broad date range query grouped by date for any metric, and see which day rows are returned."
  {:scopes ["https://www.googleapis.com/auth/webmasters"
            "https://www.googleapis.com/auth/webmasters.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"siteUrl"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/webmasters/v3/"
     "sites/{siteUrl}/searchAnalytics/query"
     #{"siteUrl"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
