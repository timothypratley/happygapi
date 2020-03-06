(ns happygapi.youtubereporting.jobs
  "YouTube Reporting API: jobs.
  Schedules reporting jobs containing your YouTube Analytics data and downloads the resulting bulk data reports in the form of CSV files.
  See: https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/create
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:createTime string,
   :reportTypeId string,
   :expireTime string,
   :name string,
   :systemManaged boolean,
   :id string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/delete
  
  Required parameters: jobId
  
  Optional parameters: onBehalfOfContentOwner
  Deletes a job."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:jobId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}"
     #{:jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/list
  
  Required parameters: none
  
  Optional parameters: onBehalfOfContentOwner, pageToken, includeSystemManaged, pageSize
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
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/get
  
  Required parameters: jobId
  
  Optional parameters: onBehalfOfContentOwner
  Gets a job."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}"
     #{:jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-list$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/reports/list
  
  Required parameters: jobId
  
  Optional parameters: onBehalfOfContentOwner, startTimeBefore, createdAfter, startTimeAtOrAfter, pageToken, pageSize
  Lists reports created by a specific job.
  Returns NOT_FOUND if the job does not exist."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}/reports"
     #{:jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn reports-get$
  "https://developers.google.com/youtube/reporting/v1/reports/api/reference/rest/v1/jobs/reports/get
  
  Required parameters: reportId, jobId
  
  Optional parameters: onBehalfOfContentOwner
  Gets the metadata of a specific report."
  {:scopes ["https://www.googleapis.com/auth/yt-analytics-monetary.readonly"
            "https://www.googleapis.com/auth/yt-analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:reportId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtubereporting.googleapis.com/"
     "v1/jobs/{jobId}/reports/{reportId}"
     #{:reportId :jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
