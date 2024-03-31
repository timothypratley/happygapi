(ns happygapi.storagetransfer.transferOperations
  "Storage Transfer API: transferOperations.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets. 
  See: https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/list
  
  Required parameters: name, filter
  
  Optional parameters: pageSize, pageToken
  
  Lists transfer operations. Operations are ordered by their creation time in reverse chronological order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name :filter})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+name}"
     #{:name :filter}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a transfer. Use the transferOperations.get method to check if the cancellation succeeded or if the operation completed despite the `cancel` request. When you cancel an operation, the currently running transfer is interrupted. For recurring transfer jobs, the next instance of the transfer job will still run. For example, if your job is configured to run every day at 1pm and you cancel Monday's operation at 1:05pm, Monday's transfer will stop. However, a transfer job will still be attempted on Tuesday. This applies only to currently running operations. If an operation is not currently running, `cancel` does nothing. *Caution:* Canceling a transfer job can leave your data in an unknown state. We recommend that you restore the state at both the destination and the source after the `cancel` request completes so that your data is in a consistent state. When you cancel a job, the next job computes a delta of files and may repair any inconsistent state. For instance, if you run a job every day, and today's job found 10 new files and transferred five files before you canceled the job, tomorrow's transfer operation will compute a new delta with the five files that were not copied today plus any new files discovered tomorrow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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

(defn pause$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses a transfer operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+name}:pause"
     #{:name}
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

(defn resume$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes a transfer operation that is paused."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/{+name}:resume"
     #{:name}
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
