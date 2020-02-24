(ns happygapi.youtubereporting.jobs
  "YouTube Reporting API
  Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
  See: https://developers.google.com/youtube/reporting/v1/reports/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: jobId
  
  Deletes a job."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"jobId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}"
     #{"jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Lists jobs."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: jobId
  
  Gets a job."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"jobId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}"
     #{"jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "Required parameters: none
  
  Creates a job and returns it."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs"
     #{}
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

(defn reports-list$
  "Required parameters: jobId
  
  Lists reports created by a specific job.
  Returns NOT_FOUND if the job does not exist."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"jobId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}/reports"
     #{"jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-get$
  "Required parameters: reportId,jobId
  
  Gets the metadata of a specific report."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"reportId" "jobId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}/reports/{reportId}"
     #{"reportId" "jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
