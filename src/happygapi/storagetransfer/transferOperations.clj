(ns happygapi.storagetransfer.transferOperations
  "Storage Transfer API: transferOperations.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets.
  See: https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists transfer operations."
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

(defn get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
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

(defn cancel$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/transferOperations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Cancels a transfer. Use the get method to check whether the cancellation succeeded or whether the operation completed despite cancellation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
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
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
