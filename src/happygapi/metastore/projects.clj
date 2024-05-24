(ns happygapi.metastore.projects
  "Dataproc Metastore API: projects.
  The Dataproc Metastore API is used to manage the lifecycle and configuration of metastore services.
  See: https://cloud.google.com/dataproc-metastore/docsdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+name}/locations"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+name}/operations"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-federations-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists federations in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/federations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-federations-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a single federation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-federations-create$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/create
  
  Required parameters: parent
  
  Optional parameters: federationId, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :backendMetastores {},
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :version string,
   :stateMessage string}
  
  Creates a metastore federation in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/federations"
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

(defn locations-federations-patch$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :backendMetastores {},
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :version string,
   :stateMessage string}
  
  Updates the fields of a federation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+name}"
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

(defn locations-federations-delete$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single federation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-federations-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-federations-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-federations-testIamPermissions$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/federations/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-services-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a single service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-services-queryMetadata$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/queryMetadata
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:query string}
  
  Query Dataproc Metastore metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:queryMetadata"
     #{:service}
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

(defn locations-services-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-services-patch$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :tier string,
   :metadataManagementActivity {:metadataExports [MetadataExport],
                                :restores [Restore]},
   :telemetryConfig {:logFormat string},
   :scalingConfig {:instanceSize string, :scalingFactor number},
   :uid string,
   :name string,
   :createTime string,
   :scheduledBackup {:enabled boolean,
                     :cronSchedule string,
                     :timeZone string,
                     :nextScheduledTime string,
                     :backupLocation string,
                     :latestBackup LatestBackup},
   :hiveMetastoreConfig {:version string,
                         :configOverrides {},
                         :kerberosConfig KerberosConfig,
                         :endpointProtocol string,
                         :auxiliaryVersions {}},
   :state string,
   :port integer,
   :networkConfig {:consumers [Consumer]},
   :releaseChannel string,
   :updateTime string,
   :artifactGcsUri string,
   :maintenanceWindow {:hourOfDay integer, :dayOfWeek string},
   :databaseType string,
   :network string,
   :metadataIntegration {:dataCatalogConfig DataCatalogConfig},
   :deletionProtection boolean,
   :encryptionConfig {:kmsKey string},
   :stateMessage string}
  
  Updates the parameters of a single service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+name}"
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

(defn locations-services-testIamPermissions$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-services-restore$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/restore
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:backup string,
   :backupLocation string,
   :restoreType string,
   :requestId string}
  
  Restores a service from a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:restore"
     #{:service}
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

(defn locations-services-create$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :tier string,
   :metadataManagementActivity {:metadataExports [MetadataExport],
                                :restores [Restore]},
   :telemetryConfig {:logFormat string},
   :scalingConfig {:instanceSize string, :scalingFactor number},
   :uid string,
   :name string,
   :createTime string,
   :scheduledBackup {:enabled boolean,
                     :cronSchedule string,
                     :timeZone string,
                     :nextScheduledTime string,
                     :backupLocation string,
                     :latestBackup LatestBackup},
   :hiveMetastoreConfig {:version string,
                         :configOverrides {},
                         :kerberosConfig KerberosConfig,
                         :endpointProtocol string,
                         :auxiliaryVersions {}},
   :state string,
   :port integer,
   :networkConfig {:consumers [Consumer]},
   :releaseChannel string,
   :updateTime string,
   :artifactGcsUri string,
   :maintenanceWindow {:hourOfDay integer, :dayOfWeek string},
   :databaseType string,
   :network string,
   :metadataIntegration {:dataCatalogConfig DataCatalogConfig},
   :deletionProtection boolean,
   :encryptionConfig {:kmsKey string},
   :stateMessage string}
  
  Creates a metastore service in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/services"
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

(defn locations-services-delete$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-services-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-moveTableToDatabase$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/moveTableToDatabase
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:tableName string, :dbName string, :destinationDbName string}
  
  Move a table to another database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:moveTableToDatabase"
     #{:service}
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

(defn locations-services-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists services in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-alterTableProperties$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/alterTableProperties
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:tableName string, :updateMask string, :properties {}}
  
  Alter metadata table properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:alterTableProperties"
     #{:service}
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

(defn locations-services-exportMetadata$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/exportMetadata
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:destinationGcsFolder string,
   :requestId string,
   :databaseDumpType string}
  
  Exports metadata from a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:exportMetadata"
     #{:service}
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

(defn locations-services-alterLocation$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/alterLocation
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:resourceName string, :locationUri string}
  
  Alter metadata resource location. The metadata resource can be a database, table, or partition. This functionality only updates the parent directory for the respective metadata resource and does not transfer any existing data to the new location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+service}:alterLocation"
     #{:service}
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

(defn locations-services-metadataImports-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/metadataImports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists imports in a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/metadataImports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-metadataImports-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/metadataImports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single import."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-services-metadataImports-create$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/metadataImports/create
  
  Required parameters: parent
  
  Optional parameters: metadataImportId, requestId
  
  Body: 
  
  {:databaseDump {:databaseType string,
                  :gcsUri string,
                  :sourceDatabase string,
                  :type string},
   :name string,
   :description string,
   :createTime string,
   :updateTime string,
   :endTime string,
   :state string}
  
  Creates a new MetadataImport in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/metadataImports"
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

(defn locations-services-metadataImports-patch$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/metadataImports/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:databaseDump {:databaseType string,
                  :gcsUri string,
                  :sourceDatabase string,
                  :type string},
   :name string,
   :description string,
   :createTime string,
   :updateTime string,
   :endTime string,
   :state string}
  
  Updates a single import. Only the description field of MetadataImport is supported to be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+name}"
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

(defn locations-services-backups-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists backups in a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/backups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-backups-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-services-backups-create$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :endTime string,
   :state string,
   :serviceRevision {:endpointUri string,
                     :labels {},
                     :tier string,
                     :metadataManagementActivity MetadataManagementActivity,
                     :telemetryConfig TelemetryConfig,
                     :scalingConfig ScalingConfig,
                     :uid string,
                     :name string,
                     :createTime string,
                     :scheduledBackup ScheduledBackup,
                     :hiveMetastoreConfig HiveMetastoreConfig,
                     :state string,
                     :port integer,
                     :networkConfig NetworkConfig,
                     :releaseChannel string,
                     :updateTime string,
                     :artifactGcsUri string,
                     :maintenanceWindow MaintenanceWindow,
                     :databaseType string,
                     :network string,
                     :metadataIntegration MetadataIntegration,
                     :deletionProtection boolean,
                     :encryptionConfig EncryptionConfig,
                     :stateMessage string},
   :description string,
   :restoringServices [string]}
  
  Creates a new backup in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+parent}/backups"
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

(defn locations-services-backups-delete$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://metastore.googleapis.com/"
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

(defn locations-services-backups-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-services-backups-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-databases-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/databases/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-services-databases-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/databases/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-databases-tables-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/databases/tables/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-services-databases-tables-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1/projects/locations/services/databases/tables/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
