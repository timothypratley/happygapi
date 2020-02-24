(ns happygapi.youtubereporting.media
  "YouTube Reporting API
  Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
  See: https://developers.google.com/youtube/reporting/v1/reports/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn download$
  "Required parameters: resourceName
  
  Method for media download. Download is supported
  on the URI `/v1/media/{+name}?alt=media`."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resourceName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/media/{+resourceName}"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
