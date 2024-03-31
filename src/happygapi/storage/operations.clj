(ns happygapi.storage.operations
  "Cloud Storage JSON API: operations.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn operations-cancel$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/operations/cancel
  
  Required parameters: bucket, operationId
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket :operationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/operations/{operationId}/cancel"
     #{:bucket :operationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/operations/get
  
  Required parameters: bucket, operationId
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket :operationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/operations/{operationId}"
     #{:bucket :operationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/operations/list
  
  Required parameters: bucket
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/operations"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
