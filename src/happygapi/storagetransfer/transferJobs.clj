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
   :schedule {:scheduleStartDate Date,
              :scheduleEndDate Date,
              :startTimeOfDay TimeOfDay,
              :endTimeOfDay TimeOfDay,
              :repeatInterval string},
   :loggingConfig {:logActions [string],
                   :logActionStates [string],
                   :enableOnpremGcsTransferLogs boolean},
   :name string,
   :lastModificationTime string,
   :eventStream {:name string,
                 :eventStreamStartTime string,
                 :eventStreamExpirationTime string},
   :latestOperationName string,
   :deletionTime string,
   :replicationSpec {:gcsDataSource GcsData,
                     :gcsDataSink GcsData,
                     :objectConditions ObjectConditions,
                     :transferOptions TransferOptions},
   :status string,
   :notificationConfig {:pubsubTopic string,
                        :eventTypes [string],
                        :payloadFormat string},
   :projectId string,
   :transferSpec {:awsS3CompatibleDataSource AwsS3CompatibleData,
                  :sourceAgentPoolName string,
                  :transferOptions TransferOptions,
                  :posixDataSink PosixFilesystem,
                  :gcsDataSource GcsData,
                  :transferManifest TransferManifest,
                  :hdfsDataSource HdfsData,
                  :sinkAgentPoolName string,
                  :httpDataSource HttpData,
                  :posixDataSource PosixFilesystem,
                  :objectConditions ObjectConditions,
                  :awsS3DataSource AwsS3Data,
                  :gcsDataSink GcsData,
                  :gcsIntermediateDataLocation GcsData,
                  :azureBlobStorageDataSource AzureBlobStorageData}}
  
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
                 :loggingConfig LoggingConfig,
                 :name string,
                 :lastModificationTime string,
                 :eventStream EventStream,
                 :latestOperationName string,
                 :deletionTime string,
                 :replicationSpec ReplicationSpec,
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

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/get
  
  Required parameters: jobName, projectId
  
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

(defn run$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/run
  
  Required parameters: jobName
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string}
  
  Starts a new operation for the specified transfer job. A `TransferJob` has a maximum of one active `TransferOperation`. If this method is called while a `TransferOperation` is active, an error is returned."
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

(defn delete$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferJobs/delete
  
  Required parameters: jobName, projectId
  
  Optional parameters: none
  
  Deletes a transfer job. Deleting a transfer job sets its status to DELETED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:jobName :projectId})]}
  (util/get-response
   (http/delete
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
