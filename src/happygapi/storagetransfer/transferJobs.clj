(ns happygapi.storagetransfer.transferJobs
  "Storage Transfer API: transferJobs.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets.
  See: https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :schedule {:scheduleEndDate Date,
              :startTimeOfDay TimeOfDay,
              :scheduleStartDate Date},
   :name string,
   :lastModificationTime string,
   :deletionTime string,
   :status string,
   :projectId string,
   :transferSpec {:awsS3DataSource AwsS3Data,
                  :httpDataSource HttpData,
                  :objectConditions ObjectConditions,
                  :gcsDataSink GcsData,
                  :gcsDataSource GcsData,
                  :transferOptions TransferOptions}}
  
  Creates a transfer job that runs periodically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
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

(defn patch$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/patch
  
  Required parameters: jobName
  
  Optional parameters: none
  
  Body: 
  
  {:transferJob {:creationTime string,
                 :description string,
                 :schedule Schedule,
                 :name string,
                 :lastModificationTime string,
                 :deletionTime string,
                 :status string,
                 :projectId string,
                 :transferSpec TransferSpec},
   :projectId string,
   :updateTransferJobFieldMask string}
  
  Updates a transfer job. Updating a job's transfer spec does not affect
  transfer operations that are running already. Updating a job's schedule
  is not allowed.
  
  **Note:** The job's status field can be modified
  using this RPC (for example, to set a job's status to
  DELETED,
  DISABLED, or
  ENABLED)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:jobName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{:jobName}
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

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/get
  
  Required parameters: jobName
  
  Optional parameters: projectId
  Gets a transfer job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:jobName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{:jobName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/list
  
  Required parameters: none
  
  Optional parameters: filter, pageToken, pageSize
  Lists transfer jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
