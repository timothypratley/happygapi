(ns happygapi.firestore.projects
  "Cloud Firestore API: projects.
  Accesses the NoSQL document database built for automatic scaling, high performance, and ease of application development. 
  See: https://cloud.google.com/firestoredocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn locations-backups-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/locations/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn locations-backups-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/locations/backups/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all the backups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn locations-backups-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/locations/backups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-exportDocuments$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/exportDocuments
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:collectionIds [string],
   :outputUriPrefix string,
   :namespaceIds [string],
   :snapshotTime string}
  
  Exports a copy of all or a subset of documents from Google Cloud Firestore to another storage system, such as Google Cloud Storage. Recent updates to documents may not be reflected in the export. The export occurs in the background and its progress can be monitored and managed via the Operation resource that is created. The output of an export may only be used once the associated operation is done. If an export operation is cancelled before completion it may leave partial data behind in Google Cloud Storage. For more details on export behavior and output format, refer to: https://cloud.google.com/firestore/docs/manage-data/export-import"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}:exportDocuments"
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

(defn databases-importDocuments$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/importDocuments
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:collectionIds [string],
   :inputUriPrefix string,
   :namespaceIds [string]}
  
  Imports documents into Google Cloud Firestore. Existing documents with the same name are overwritten. The import occurs in the background and its progress can be monitored and managed via the Operation resource that is created. If an ImportDocuments operation is cancelled, it is possible that a subset of the data has already been imported to Cloud Firestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}:importDocuments"
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

(defn databases-create$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/create
  
  Required parameters: parent
  
  Optional parameters: databaseId
  
  Body: 
  
  {:deleteTime string,
   :cmekConfig {:kmsKeyName string, :activeKeyVersion [string]},
   :deleteProtectionState string,
   :locationId string,
   :uid string,
   :name string,
   :createTime string,
   :appEngineIntegrationMode string,
   :type string,
   :etag string,
   :earliestVersionTime string,
   :concurrencyMode string,
   :versionRetentionPeriod string,
   :updateTime string,
   :previousId string,
   :keyPrefix string,
   :pointInTimeRecoveryEnablement string}
  
  Create a database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/databases"
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

(defn databases-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/list
  
  Required parameters: parent
  
  Optional parameters: showDeleted
  
  List all the databases in the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/databases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn databases-patch$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:deleteTime string,
   :cmekConfig {:kmsKeyName string, :activeKeyVersion [string]},
   :deleteProtectionState string,
   :locationId string,
   :uid string,
   :name string,
   :createTime string,
   :appEngineIntegrationMode string,
   :type string,
   :etag string,
   :earliestVersionTime string,
   :concurrencyMode string,
   :versionRetentionPeriod string,
   :updateTime string,
   :previousId string,
   :keyPrefix string,
   :pointInTimeRecoveryEnablement string}
  
  Updates a database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-restore$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/restore
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :backup string,
   :databaseSnapshot {:database string, :snapshotTime string}}
  
  Creates a new database by restoring from an existing backup. The new database must be in the same cloud region or multi-region location as the existing backup. This behaves similar to FirestoreAdmin.CreateDatabase except instead of creating a new empty database, a new database is created with the database type, index configuration, and documents from an existing backup. The long-running operation can be used to track the progress of the restore, with the Operation's metadata field type being the RestoreDatabaseMetadata. The response type is the Database if the restore was successful. The new database is not readable or writeable until the LRO has completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/databases:restore"
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

(defn databases-operations-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-operations-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-operations-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-operations-cancel$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-collectionGroups-indexes-create$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/indexes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :queryScope string,
   :apiScope string,
   :fields [{:fieldPath string,
             :order string,
             :arrayConfig string,
             :vectorConfig GoogleFirestoreAdminV1VectorConfig}],
   :state string}
  
  Creates a composite index. This returns a google.longrunning.Operation which may be used to track the status of the creation. The metadata for the operation will be the type IndexOperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/indexes"
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

(defn databases-collectionGroups-indexes-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/indexes/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists composite indexes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/indexes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-indexes-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/indexes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a composite index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-collectionGroups-indexes-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/indexes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a composite index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-collectionGroups-fields-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/fields/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the metadata and configuration for a Field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-collectionGroups-fields-patch$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/fields/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :indexConfig {:indexes [GoogleFirestoreAdminV1Index],
                 :usesAncestorConfig boolean,
                 :ancestorField string,
                 :reverting boolean},
   :ttlConfig {:state string}}
  
  Updates a field configuration. Currently, field updates apply only to single field index configuration. However, calls to FirestoreAdmin.UpdateField should provide a field mask to avoid changing any configuration that the caller isn't aware of. The field mask should be specified as: `{ paths: \"index_config\" }`. This call returns a google.longrunning.Operation which may be used to track the status of the field update. The metadata for the operation will be the type FieldOperationMetadata. To configure the default field settings for the database, use the special `Field` with resource name: `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/*`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-collectionGroups-fields-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/collectionGroups/fields/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the field configuration and metadata for this database. Currently, FirestoreAdmin.ListFields only supports listing fields that have been explicitly overridden. To issue this query, call FirestoreAdmin.ListFields with the filter set to `indexConfig.usesAncestorConfig:false` or `ttlConfig:*`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/fields"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn databases-backupSchedules-create$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/backupSchedules/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :retention string,
   :dailyRecurrence {:time TimeOfDay},
   :weeklyRecurrence {:time TimeOfDay, :day string}}
  
  Creates a backup schedule on a database. At most two backup schedules can be configured on a database, one daily backup schedule and one weekly backup schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/backupSchedules"
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

(defn databases-backupSchedules-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/backupSchedules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a backup schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-backupSchedules-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/backupSchedules/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  List backup schedules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/backupSchedules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn databases-backupSchedules-patch$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/backupSchedules/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :retention string,
   :dailyRecurrence {:time TimeOfDay},
   :weeklyRecurrence {:time TimeOfDay, :day string}}
  
  Updates a backup schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-backupSchedules-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/backupSchedules/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a backup schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-documents-rollback$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/rollback
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:transaction string}
  
  Rolls back a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:rollback"
     #{:database}
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

(defn databases-documents-get$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/get
  
  Required parameters: name
  
  Optional parameters: mask.fieldPaths, transaction, readTime
  
  Gets a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-documents-batchWrite$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/batchWrite
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:writes [{:update Document,
             :delete string,
             :transform DocumentTransform,
             :updateMask DocumentMask,
             :updateTransforms [FieldTransform],
             :currentDocument Precondition}],
   :labels {}}
  
  Applies a batch of write operations. The BatchWrite method does not apply the write operations atomically and can apply them out of order. Method does not allow more than one write per document. Each write succeeds or fails independently. See the BatchWriteResponse for the success status of each write. If you require an atomically applied set of writes, use Commit instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:batchWrite"
     #{:database}
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

(defn databases-documents-patch$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/patch
  
  Required parameters: name
  
  Optional parameters: updateMask.fieldPaths, mask.fieldPaths, currentDocument.exists, currentDocument.updateTime
  
  Body: 
  
  {:name string, :fields {}, :createTime string, :updateTime string}
  
  Updates or inserts a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-documents-batchGet$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/batchGet
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:documents [string],
   :mask {:fieldPaths [string]},
   :transaction string,
   :newTransaction {:readOnly ReadOnly, :readWrite ReadWrite},
   :readTime string}
  
  Gets multiple documents. Documents returned by this method are not guaranteed to be returned in the same order that they were requested."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:batchGet"
     #{:database}
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

(defn databases-documents-delete$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/delete
  
  Required parameters: name
  
  Optional parameters: currentDocument.exists, currentDocument.updateTime
  
  Deletes a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
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

(defn databases-documents-runQuery$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/runQuery
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:structuredQuery {:where Filter,
                     :limit integer,
                     :offset integer,
                     :endAt Cursor,
                     :from [CollectionSelector],
                     :findNearest FindNearest,
                     :startAt Cursor,
                     :select Projection,
                     :orderBy [Order]},
   :transaction string,
   :newTransaction {:readOnly ReadOnly, :readWrite ReadWrite},
   :readTime string,
   :explainOptions {:analyze boolean}}
  
  Runs a query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:runQuery"
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

(defn databases-documents-partitionQuery$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/partitionQuery
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:structuredQuery {:where Filter,
                     :limit integer,
                     :offset integer,
                     :endAt Cursor,
                     :from [CollectionSelector],
                     :findNearest FindNearest,
                     :startAt Cursor,
                     :select Projection,
                     :orderBy [Order]},
   :partitionCount string,
   :pageToken string,
   :pageSize integer,
   :readTime string}
  
  Partitions a query by returning partition cursors that can be used to run the query in parallel. The returned partition cursors are split points that can be used by RunQuery as starting/end points for the query results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:partitionQuery"
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

(defn databases-documents-write$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/write
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:streamId string,
   :writes [{:update Document,
             :delete string,
             :transform DocumentTransform,
             :updateMask DocumentMask,
             :updateTransforms [FieldTransform],
             :currentDocument Precondition}],
   :streamToken string,
   :labels {}}
  
  Streams batches of document updates and deletes, in order. This method is only available via gRPC or WebChannel (not REST)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:write"
     #{:database}
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

(defn databases-documents-beginTransaction$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/beginTransaction
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:options {:readOnly ReadOnly, :readWrite ReadWrite}}
  
  Starts a new transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:beginTransaction"
     #{:database}
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

(defn databases-documents-listen$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/listen
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:addTarget {:query QueryTarget,
               :documents DocumentsTarget,
               :resumeToken string,
               :readTime string,
               :targetId integer,
               :once boolean,
               :expectedCount integer},
   :removeTarget integer,
   :labels {}}
  
  Listens to changes. This method is only available via gRPC or WebChannel (not REST)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:listen"
     #{:database}
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

(defn databases-documents-list$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/list
  
  Required parameters: collectionId, parent
  
  Optional parameters: mask.fieldPaths, transaction, pageToken, pageSize, readTime, showMissing, orderBy
  
  Lists documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collectionId :parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/{collectionId}"
     #{:collectionId :parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-commit$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/commit
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:writes [{:update Document,
             :delete string,
             :transform DocumentTransform,
             :updateMask DocumentMask,
             :updateTransforms [FieldTransform],
             :currentDocument Precondition}],
   :transaction string}
  
  Commits a transaction, while optionally updating documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:commit"
     #{:database}
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

(defn databases-documents-runAggregationQuery$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/runAggregationQuery
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:structuredAggregationQuery {:structuredQuery StructuredQuery,
                                :aggregations [Aggregation]},
   :transaction string,
   :newTransaction {:readOnly ReadOnly, :readWrite ReadWrite},
   :readTime string,
   :explainOptions {:analyze boolean}}
  
  Runs an aggregation query. Rather than producing Document results like Firestore.RunQuery, this API allows running an aggregation to produce a series of AggregationResult server-side. High-Level Example: ``` -- Return the number of documents in table given a filter. SELECT COUNT(*) FROM ( SELECT * FROM k where a = true ); ```"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:runAggregationQuery"
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

(defn databases-documents-listCollectionIds$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/listCollectionIds
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer, :pageToken string, :readTime string}
  
  Lists all the collection IDs underneath a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:listCollectionIds"
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

(defn databases-documents-createDocument$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/createDocument
  
  Required parameters: parent, collectionId
  
  Optional parameters: documentId, mask.fieldPaths
  
  Body: 
  
  {:name string, :fields {}, :createTime string, :updateTime string}
  
  Creates a new document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:collectionId :parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/{collectionId}"
     #{:collectionId :parent}
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

(defn databases-documents-listDocuments$
  "https://cloud.google.com/firestoreapi/reference/rest/v1/projects/databases/documents/listDocuments
  
  Required parameters: collectionId, parent
  
  Optional parameters: mask.fieldPaths, transaction, pageToken, pageSize, readTime, showMissing, orderBy
  
  Lists documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collectionId :parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/{collectionId}"
     #{:collectionId :parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
