(ns happygapi.storagetransfer.transferJobs
  "Storage Transfer API: transferJobs.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets.
  See: https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/list
  
  Required parameters: filter
  
  Optional parameters: pageSize, pageToken
  
  Lists transfer jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:filter})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
     #{:filter}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/get
  
  Required parameters: projectId, jobName
  
  Optional parameters: none
  
  Gets a transfer job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:jobName :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{:jobName :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :schedule {:scheduleStartDate Date,
              :repeatInterval string,
              :endTimeOfDay TimeOfDay,
              :scheduleEndDate Date,
              :startTimeOfDay TimeOfDay},
   :name string,
   :lastModificationTime string,
   :latestOperationName string,
   :deletionTime string,
   :status string,
   :notificationConfig {:eventTypes [string],
                        :pubsubTopic string,
                        :payloadFormat string},
   :projectId string,
   :transferSpec {:gcsDataSink GcsData,
                  :objectConditions ObjectConditions,
                  :awsS3DataSource AwsS3Data,
                  :gcsDataSource GcsData,
                  :azureBlobStorageDataSource AzureBlobStorageData,
                  :httpDataSource HttpData,
                  :transferOptions TransferOptions}}
  
  Creates a transfer job that runs periodically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/transferJobs"
     #{}
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

(defn patch$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/patch
  
  Required parameters: jobName
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :transferJob {:creationTime string,
                 :description string,
                 :schedule Schedule,
                 :name string,
                 :lastModificationTime string,
                 :latestOperationName string,
                 :deletionTime string,
                 :status string,
                 :notificationConfig NotificationConfig,
                 :projectId string,
                 :transferSpec TransferSpec},
   :updateTransferJobFieldMask string}
  
  Updates a transfer job. Updating a job's transfer spec does not affect transfer operations that are running already. **Note:** The job's status field can be modified using this RPC (for example, to set a job's status to DELETED, DISABLED, or ENABLED)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:jobName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}"
     #{:jobName}
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

(defn run$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/run
  
  Required parameters: jobName
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string}
  
  Attempts to start a new TransferOperation for the current TransferJob. A TransferJob has a maximum of one active TransferOperation. If this method is called while a TransferOperation is active, an error wil be returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:jobName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+jobName}:run"
     #{:jobName}
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
