(ns happygapi.youtubeAnalytics.reports
  "YouTube Analytics API: reports.
  Retrieves your YouTube Analytics data.
  See: https://developers.google.com/youtube/analyticsapi/reference/rest/v2/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn query$
  "https://developers.google.com/youtube/analyticsapi/reference/rest/v2/reports/query
  
  Required parameters: none
  
  Optional parameters: filters, startDate, ids, dimensions, currency, includeHistoricalChannelData, endDate, startIndex, metrics, sort, maxResults
  
  Retrieve your YouTube Analytics reports."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubeanalytics.googleapis.com/"
     "v2/reports"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
