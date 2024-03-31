(ns happygapi.logging.locations
  "Cloud Logging API: locations.
  Writes log entries and manages your Cloud Logging configuration.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}/locations"
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
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn buckets-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists log buckets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/buckets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a log bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-createAsync$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/createAsync
  
  Required parameters: parent
  
  Optional parameters: bucketId
  
  Body: 
  
  {:description string,
   :analyticsEnabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :locked boolean,
   :indexConfigs [{:fieldPath string, :type string, :createTime string}],
   :restrictedFields [string],
   :retentionDays integer,
   :lifecycleState string,
   :cmekSettings {:name string,
                  :kmsKeyName string,
                  :kmsKeyVersionName string,
                  :serviceAccountId string}}
  
  Creates a log bucket asynchronously that can be used to store log entries.After a bucket has been created, the bucket's location cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/buckets:createAsync"
     #{:parent}
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

(defn buckets-updateAsync$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/updateAsync
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :analyticsEnabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :locked boolean,
   :indexConfigs [{:fieldPath string, :type string, :createTime string}],
   :restrictedFields [string],
   :retentionDays integer,
   :lifecycleState string,
   :cmekSettings {:name string,
                  :kmsKeyName string,
                  :kmsKeyVersionName string,
                  :serviceAccountId string}}
  
  Updates a log bucket asynchronously.If the bucket has a lifecycle_state of DELETE_REQUESTED, then FAILED_PRECONDITION will be returned.After a bucket has been created, the bucket's location cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}:updateAsync"
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

(defn buckets-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/create
  
  Required parameters: parent
  
  Optional parameters: bucketId
  
  Body: 
  
  {:description string,
   :analyticsEnabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :locked boolean,
   :indexConfigs [{:fieldPath string, :type string, :createTime string}],
   :restrictedFields [string],
   :retentionDays integer,
   :lifecycleState string,
   :cmekSettings {:name string,
                  :kmsKeyName string,
                  :kmsKeyVersionName string,
                  :serviceAccountId string}}
  
  Creates a log bucket that can be used to store log entries. After a bucket has been created, the bucket's location cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/buckets"
     #{:parent}
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

(defn buckets-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :analyticsEnabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :locked boolean,
   :indexConfigs [{:fieldPath string, :type string, :createTime string}],
   :restrictedFields [string],
   :retentionDays integer,
   :lifecycleState string,
   :cmekSettings {:name string,
                  :kmsKeyName string,
                  :kmsKeyVersionName string,
                  :serviceAccountId string}}
  
  Updates a log bucket.If the bucket has a lifecycle_state of DELETE_REQUESTED, then FAILED_PRECONDITION will be returned.After a bucket has been created, the bucket's location cannot be changed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
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

(defn buckets-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a log bucket.Changes the bucket's lifecycle_state to the DELETE_REQUESTED state. After 7 days, the bucket will be purged and all log entries in the bucket will be permanently deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-undelete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeletes a log bucket. A bucket that has been deleted can be undeleted within the grace period of 7 days."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}:undelete"
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

(defn buckets-views-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/views/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists views on a log bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/views"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-views-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/views/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a view on a log bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-views-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/views/create
  
  Required parameters: parent
  
  Optional parameters: viewId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :filter string}
  
  Creates a view over log entries in a log bucket. A bucket may contain a maximum of 30 views."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/views"
     #{:parent}
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

(defn buckets-views-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/views/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :filter string}
  
  Updates a view on a log bucket. This method replaces the value of the filter field from the existing view with the corresponding value from the new view. If an UNAVAILABLE error is returned, this indicates that system is not in a state where it can update the view. If this occurs, please try again in a few minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
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

(defn buckets-views-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/views/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a view on a log bucket. If an UNAVAILABLE error is returned, this indicates that system is not in a state where it can delete the view. If this occurs, please try again in a few minutes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-links-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/links/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists links."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/links"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-links-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/links/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a link."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn buckets-links-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/links/create
  
  Required parameters: parent
  
  Optional parameters: linkId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :lifecycleState string,
   :bigqueryDataset {:datasetId string}}
  
  Asynchronously creates a linked dataset in BigQuery which makes it possible to use BigQuery to read the logs stored in the log bucket. A log bucket may currently only contain one link."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/links"
     #{:parent}
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

(defn buckets-links-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/locations/buckets/links/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a link. This will also delete the corresponding BigQuery linked dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
