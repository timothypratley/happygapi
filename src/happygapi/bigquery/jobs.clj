(ns happygapi.bigquery.jobs
  "BigQuery API: jobs.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/jobs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cancel$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/cancel
  
  Required parameters: projectId, jobId
  
  Optional parameters: location
  
  Requests that a job be cancelled. This call will return immediately, and the client will need to poll for the job status to see if the cancel completed successfully. Cancelled jobs may still incur costs."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/jobs/{jobId}/cancel"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/get
  
  Required parameters: jobId, projectId
  
  Optional parameters: location
  
  Returns information about a specific job. Job information is available for a six month period after creation. Requires that you're the person who ran the job, or have the Is Owner project role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/jobs/{jobId}"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/delete
  
  Required parameters: jobId, projectId
  
  Optional parameters: location
  
  Requests that a job is deleted. This call will return when the job is deleted. This method is available in limited preview."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/jobs/{+jobId}/delete"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn query$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/query
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:dryRun boolean,
   :labels {},
   :maximumBytesBilled string,
   :queryParameters [{:name string,
                      :parameterType QueryParameterType,
                      :parameterValue QueryParameterValue}],
   :parameterMode string,
   :connectionProperties [{:key string, :value string}],
   :defaultDataset {:projectId string, :datasetId string},
   :preserveNulls boolean,
   :timeoutMs integer,
   :requestId string,
   :kind string,
   :useQueryCache boolean,
   :query string,
   :useLegacySql boolean,
   :location string,
   :createSession boolean,
   :maxResults integer}
  
  Runs a BigQuery SQL query synchronously and returns query results if the query completes within a specified timeout."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/queries"
     #{:projectId}
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

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/list
  
  Required parameters: projectId
  
  Optional parameters: allUsers, maxCreationTime, pageToken, parentJobId, stateFilter, projection, maxResults, minCreationTime
  
  Lists all jobs that you started in the specified project. Job information is available for a six month period after creation. The job list is sorted in reverse chronological order, by job creation time. Requires the Can View project role, or the Is Owner project role if you set the allUsers property."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/jobs"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/insert
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:selfLink string,
   :etag string,
   :user_email string,
   :jobReference {:jobId string, :location string, :projectId string},
   :statistics {:reservation_id string,
                :creationTime string,
                :load JobStatistics3,
                :transactionInfo TransactionInfo,
                :startTime string,
                :reservationUsage [{:slotMs string, :name string}],
                :endTime string,
                :totalSlotMs string,
                :completionRatio number,
                :numChildJobs string,
                :parentJobId string,
                :rowLevelSecurityStatistics RowLevelSecurityStatistics,
                :extract JobStatistics4,
                :totalBytesProcessed string,
                :scriptStatistics ScriptStatistics,
                :quotaDeferments [string],
                :query JobStatistics2,
                :sessionInfo SessionInfo},
   :status {:errors [ErrorProto],
            :errorResult ErrorProto,
            :state string},
   :id string,
   :kind string,
   :configuration {:extract JobConfigurationExtract,
                   :load JobConfigurationLoad,
                   :jobType string,
                   :copy JobConfigurationTableCopy,
                   :query JobConfigurationQuery,
                   :dryRun boolean,
                   :labels {},
                   :jobTimeoutMs string}}
  
  Starts a new asynchronous job. Requires the Can View project role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/jobs"
     #{:projectId}
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

(defn getQueryResults$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/jobs/getQueryResults
  
  Required parameters: jobId, projectId
  
  Optional parameters: timeoutMs, pageToken, maxResults, startIndex, location
  
  Retrieves the results of a query job."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/queries/{jobId}"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
