(ns happygapi.metastore.projects
  "Dataproc Metastore API: projects.
  The Dataproc Metastore API is used to manage the lifecycle and configuration of metastore services.
  See: https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+name}/locations"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/get
  
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
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/get
  
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
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-setIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+resource}:setIamPolicy"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :tier string,
   :metadataManagementActivity {:metadataExports [MetadataExport],
                                :restores [Restore]},
   :uid string,
   :name string,
   :createTime string,
   :hiveMetastoreConfig {:configOverrides {},
                         :kerberosConfig KerberosConfig,
                         :version string},
   :state string,
   :port integer,
   :releaseChannel string,
   :updateTime string,
   :artifactGcsUri string,
   :maintenanceWindow {:hourOfDay integer, :dayOfWeek string},
   :network string,
   :metadataIntegration {:dataCatalogConfig DataCatalogConfig},
   :stateMessage string}
  
  Updates the parameters of a single service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+name}"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/testIamPermissions
  
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
     "v1beta/{+resource}:testIamPermissions"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/restore
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:restoreType string, :requestId string, :backup string}
  
  Restores a service from a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+service}:restore"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId, requestId
  
  Body: 
  
  {:endpointUri string,
   :labels {},
   :tier string,
   :metadataManagementActivity {:metadataExports [MetadataExport],
                                :restores [Restore]},
   :uid string,
   :name string,
   :createTime string,
   :hiveMetastoreConfig {:configOverrides {},
                         :kerberosConfig KerberosConfig,
                         :version string},
   :state string,
   :port integer,
   :releaseChannel string,
   :updateTime string,
   :artifactGcsUri string,
   :maintenanceWindow {:hourOfDay integer, :dayOfWeek string},
   :network string,
   :metadataIntegration {:dataCatalogConfig DataCatalogConfig},
   :stateMessage string}
  
  Creates a metastore service in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+parent}/services"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/delete
  
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
     "v1beta/{+name}"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/getIamPolicy
  
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
     "v1beta/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize, orderBy
  
  Lists services in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-exportMetadata$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/exportMetadata
  
  Required parameters: service
  
  Optional parameters: none
  
  Body: 
  
  {:destinationGcsFolder string,
   :databaseDumpType string,
   :requestId string}
  
  Exports metadata from a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:service})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+service}:exportMetadata"
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

(defn locations-services-metadataImports-patch$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/metadataImports/patch
  
  Required parameters: name
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:name string,
   :updateTime string,
   :databaseDump {:gcsUri string,
                  :sourceDatabase string,
                  :databaseType string,
                  :type string},
   :createTime string,
   :description string,
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
     "v1beta/{+name}"
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

(defn locations-services-metadataImports-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/metadataImports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, orderBy, pageToken, filter
  
  Lists imports in a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+parent}/metadataImports"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/metadataImports/get
  
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
     "v1beta/{+name}"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/metadataImports/create
  
  Required parameters: parent
  
  Optional parameters: metadataImportId, requestId
  
  Body: 
  
  {:name string,
   :updateTime string,
   :databaseDump {:gcsUri string,
                  :sourceDatabase string,
                  :databaseType string,
                  :type string},
   :createTime string,
   :description string,
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
     "v1beta/{+parent}/metadataImports"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/delete
  
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
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-backups-getIamPolicy$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/getIamPolicy
  
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
     "v1beta/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-backups-list$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken, orderBy
  
  Lists backups in a service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+parent}/backups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-backups-testIamPermissions$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/testIamPermissions
  
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
     "v1beta/{+resource}:testIamPermissions"
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

(defn locations-services-backups-create$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/create
  
  Required parameters: parent
  
  Optional parameters: requestId, backupId
  
  Body: 
  
  {:createTime string,
   :endTime string,
   :state string,
   :name string,
   :description string,
   :serviceRevision {:endpointUri string,
                     :labels {},
                     :tier string,
                     :metadataManagementActivity MetadataManagementActivity,
                     :uid string,
                     :name string,
                     :createTime string,
                     :hiveMetastoreConfig HiveMetastoreConfig,
                     :state string,
                     :port integer,
                     :releaseChannel string,
                     :updateTime string,
                     :artifactGcsUri string,
                     :maintenanceWindow MaintenanceWindow,
                     :network string,
                     :metadataIntegration MetadataIntegration,
                     :stateMessage string}}
  
  Creates a new backup in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+parent}/backups"
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

(defn locations-services-backups-get$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/get
  
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
     "v1beta/{+name}"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/services/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+resource}:setIamPolicy"
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

(defn locations-operations-delete$
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/operations/delete
  
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
     "v1beta/{+name}"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.NOTE: the name binding allows API services to override the binding to use different resource name schemes, such as users/*/operations. To override the binding, API services can add a binding such as \"/v1/{name=users/*}/operations\" to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://metastore.googleapis.com/"
     "v1beta/{+name}/operations"
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
  "https://cloud.google.com/dataproc-metastore/docsapi/reference/rest/v1beta/projects/locations/operations/get
  
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
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
