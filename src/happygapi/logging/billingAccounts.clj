(ns happygapi.logging.billingAccounts
  "Cloud Logging API: billingAccounts.
  Writes log entries and manages your Cloud Logging configuration.
  See: https://cloud.google.com/logging/docs/docs/reference/rest/v2/billingAccounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getCmekSettings$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/getCmekSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the Logging CMEK settings for the given resource.Note: CMEK for the Log Router can be configured for Google Cloud projects, folders, organizations, and billing accounts. Once configured for an organization, it applies to all projects and folders in the Google Cloud organization.See Enabling CMEK for Log Router (https://cloud.google.com/logging/docs/routing/managed-encryption) for more information."
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
     "v2/{+name}/cmekSettings"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSettings$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/getSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the settings for the given resource.Note: Settings can be retrieved for Google Cloud projects, folders, organizations, and billing accounts.See View default resource settings for Logging (https://cloud.google.com/logging/docs/default-settings#view-org-settings) for more information."
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
     "v2/{+name}/settings"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/list
  
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

(defn locations-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/get
  
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

(defn locations-operations-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/operations/list
  
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

(defn locations-operations-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/operations/get
  
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

(defn locations-operations-cancel$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/operations/cancel
  
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

(defn locations-buckets-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/list
  
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

(defn locations-buckets-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/get
  
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

(defn locations-buckets-createAsync$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/createAsync
  
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

(defn locations-buckets-updateAsync$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/updateAsync
  
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

(defn locations-buckets-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/create
  
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

(defn locations-buckets-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/patch
  
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

(defn locations-buckets-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/delete
  
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

(defn locations-buckets-undelete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/undelete
  
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

(defn locations-buckets-views-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/list
  
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

(defn locations-buckets-views-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/get
  
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

(defn locations-buckets-views-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/create
  
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

(defn locations-buckets-views-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/patch
  
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

(defn locations-buckets-views-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/delete
  
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

(defn locations-buckets-views-logs-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/views/logs/list
  
  Required parameters: parent
  
  Optional parameters: resourceNames, pageSize, pageToken
  
  Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have entries are listed."
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
     "v2/{+parent}/logs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-buckets-links-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/links/list
  
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

(defn locations-buckets-links-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/links/get
  
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

(defn locations-buckets-links-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/links/create
  
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

(defn locations-buckets-links-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/links/delete
  
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

(defn locations-savedQueries-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/savedQueries/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the SavedQueries that were created by the user making the request."
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
     "v2/{+parent}/savedQueries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-savedQueries-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/savedQueries/create
  
  Required parameters: parent
  
  Optional parameters: savedQueryId
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :loggingQuery {:filter string,
                  :summaryFields [SummaryField],
                  :summaryFieldStart integer,
                  :summaryFieldEnd integer},
   :opsAnalyticsQuery {:sqlQueryText string},
   :createTime string,
   :updateTime string,
   :visibility string}
  
  Creates a new SavedQuery for the user making the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/savedQueries"
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

(defn locations-savedQueries-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/savedQueries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing SavedQuery that was created by the user making the request."
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

(defn locations-recentQueries-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/recentQueries/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the RecentQueries that were created by the user making the request."
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
     "v2/{+parent}/recentQueries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn exclusions-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the exclusions on the _Default sink in a parent resource."
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
     "v2/{+parent}/exclusions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn exclusions-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the description of an exclusion in the _Default sink."
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

(defn exclusions-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :description string,
   :filter string,
   :disabled boolean,
   :createTime string,
   :updateTime string}
  
  Creates a new exclusion in the _Default sink in a specified parent resource. Only log entries belonging to that resource can be excluded. You can have up to 10 exclusions in a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/exclusions"
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

(defn exclusions-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :filter string,
   :disabled boolean,
   :createTime string,
   :updateTime string}
  
  Changes one or more properties of an existing exclusion in the _Default sink."
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

(defn exclusions-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an exclusion in the _Default sink."
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

(defn sinks-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists sinks."
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
     "v2/{+parent}/sinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sinks-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/get
  
  Required parameters: sinkName
  
  Optional parameters: none
  
  Gets a sink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sinks-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/create
  
  Required parameters: parent
  
  Optional parameters: uniqueWriterIdentity, customWriterIdentity
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usePartitionedTables boolean,
                     :usesTimestampColumnPartitioning boolean},
   :includeChildren boolean,
   :disabled boolean,
   :interceptChildren boolean,
   :name string,
   :createTime string,
   :exclusions [{:name string,
                 :description string,
                 :filter string,
                 :disabled boolean,
                 :createTime string,
                 :updateTime string}],
   :updateTime string,
   :resourceName string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Creates a sink that exports specified log entries to a destination. The export begins upon ingress, unless the sink's writer_identity is not permitted to write to the destination. A sink can export log entries only from the resource owning the sink."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+parent}/sinks"
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

(defn sinks-update$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/update
  
  Required parameters: sinkName
  
  Optional parameters: uniqueWriterIdentity, customWriterIdentity, updateMask
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usePartitionedTables boolean,
                     :usesTimestampColumnPartitioning boolean},
   :includeChildren boolean,
   :disabled boolean,
   :interceptChildren boolean,
   :name string,
   :createTime string,
   :exclusions [{:name string,
                 :description string,
                 :filter string,
                 :disabled boolean,
                 :createTime string,
                 :updateTime string}],
   :updateTime string,
   :resourceName string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Updates a sink. This method replaces the values of the destination and filter fields of the existing sink with the corresponding values from the new sink.The updated sink might also have a new writer_identity; see the unique_writer_identity field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
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

(defn sinks-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/patch
  
  Required parameters: sinkName
  
  Optional parameters: uniqueWriterIdentity, customWriterIdentity, updateMask
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usePartitionedTables boolean,
                     :usesTimestampColumnPartitioning boolean},
   :includeChildren boolean,
   :disabled boolean,
   :interceptChildren boolean,
   :name string,
   :createTime string,
   :exclusions [{:name string,
                 :description string,
                 :filter string,
                 :disabled boolean,
                 :createTime string,
                 :updateTime string}],
   :updateTime string,
   :resourceName string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Updates a sink. This method replaces the values of the destination and filter fields of the existing sink with the corresponding values from the new sink.The updated sink might also have a new writer_identity; see the unique_writer_identity field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
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

(defn sinks-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/delete
  
  Required parameters: sinkName
  
  Optional parameters: none
  
  Deletes a sink. If the sink has a unique writer_identity, then that service account is also deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sinkName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+sinkName}"
     #{:sinkName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn logs-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/logs/delete
  
  Required parameters: logName
  
  Optional parameters: none
  
  Deletes all the log entries in a log for the _Default Log Bucket. The log reappears if it receives new entries. Log entries written shortly before the delete operation might not be deleted. Entries received after the delete operation with a timestamp before the operation will be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/logging.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:logName})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/{+logName}"
     #{:logName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn logs-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/logs/list
  
  Required parameters: parent
  
  Optional parameters: resourceNames, pageSize, pageToken
  
  Lists the logs in projects, organizations, folders, or billing accounts. Only logs that have entries are listed."
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
     "v2/{+parent}/logs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
