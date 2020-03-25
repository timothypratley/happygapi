(ns happygapi.youtubereporting.media
  "YouTube Reporting API: media.
  Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
  See: https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/media/download
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Method for media download. Download is supported
  on the URI `/v1/media/{+name}?alt=media`."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/media/{+resourceName}"
     #{:resourceName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
