(ns happygapi.logging.billingAccounts
  "Cloud Logging API: billingAccounts.
  Writes log entries and manages your Cloud Logging configuration. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the documentation at https://cloud.google.com/logging/docs.
  See: https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-buckets-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists buckets (Beta)."
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

(defn locations-buckets-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/locations/buckets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:updateTime string,
   :retentionDays integer,
   :name string,
   :lifecycleState string,
   :description string,
   :createTime string}
  
  Updates a bucket. This method replaces the following fields in the existing bucket with values from the new bucket: retention_periodIf the retention period is decreased and the bucket is locked, FAILED_PRECONDITION will be returned.If the bucket has a LifecycleState of DELETE_REQUESTED, FAILED_PRECONDITION will be returned.A buckets region may not be modified after it is created. This method is in Beta."
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

(defn sinks-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/patch
  
  Required parameters: sinkName
  
  Optional parameters: uniqueWriterIdentity, updateMask
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usesTimestampColumnPartitioning boolean,
                     :usePartitionedTables boolean},
   :includeChildren boolean,
   :disabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Updates a sink. This method replaces the following fields in the existing sink with values from the new sink: destination, and filter.The updated sink might also have a new writer_identity; see the unique_writer_identity field."
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

(defn sinks-update$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/update
  
  Required parameters: sinkName
  
  Optional parameters: uniqueWriterIdentity, updateMask
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usesTimestampColumnPartitioning boolean,
                     :usePartitionedTables boolean},
   :includeChildren boolean,
   :disabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Updates a sink. This method replaces the following fields in the existing sink with values from the new sink: destination, and filter.The updated sink might also have a new writer_identity; see the unique_writer_identity field."
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

(defn sinks-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
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

(defn sinks-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/sinks/create
  
  Required parameters: parent
  
  Optional parameters: uniqueWriterIdentity
  
  Body: 
  
  {:description string,
   :bigqueryOptions {:usesTimestampColumnPartitioning boolean,
                     :usePartitionedTables boolean},
   :includeChildren boolean,
   :disabled boolean,
   :name string,
   :createTime string,
   :updateTime string,
   :filter string,
   :outputVersionFormat string,
   :destination string,
   :writerIdentity string}
  
  Creates a sink that exports specified log entries to a destination. The export of newly-ingested log entries begins immediately, unless the sink's writer_identity is not permitted to write to the destination. A sink can export log entries only from the resource owning the sink."
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

(defn logs-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/logs/delete
  
  Required parameters: logName
  
  Optional parameters: none
  
  Deletes all the log entries in a log. The log reappears if it receives new entries. Log entries written shortly before the delete operation might not be deleted. Entries received after the delete operation with a timestamp before the operation will be deleted."
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
  
  Optional parameters: pageToken, pageSize
  
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

(defn exclusions-list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all the exclusions in a parent resource."
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
  
  Gets the description of an exclusion."
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

(defn exclusions-patch$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :disabled boolean,
   :createTime string,
   :updateTime string,
   :name string,
   :filter string}
  
  Changes one or more properties of an existing exclusion."
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

(defn exclusions-create$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :disabled boolean,
   :createTime string,
   :updateTime string,
   :name string,
   :filter string}
  
  Creates a new exclusion in a specified parent resource. Only log entries belonging to that resource can be excluded. You can have up to 10 exclusions in a resource."
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

(defn exclusions-delete$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/exclusions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an exclusion."
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

(defn buckets-get$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/billingAccounts/buckets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a bucket (Beta)."
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
