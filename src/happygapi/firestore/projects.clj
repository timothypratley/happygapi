(ns happygapi.firestore.projects
  "Cloud Firestore API
  Accesses the NoSQL document database built for automatic scaling, high performance, and ease of application development.
  
  See: https://cloud.google.com/firestore"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "firestore_schema.edn"))))

(defn databases-exportDocuments$
  "Required parameters: name
  
  Optional parameters: none
  
  Exports a copy of all or a subset of documents from Google Cloud Firestore
  to another storage system, such as Google Cloud Storage. Recent updates to
  documents may not be reflected in the export. The export occurs in the
  background and its progress can be monitored and managed via the
  Operation resource that is created. The output of an export may only be
  used once the associated operation is done. If an export operation is
  cancelled before completion it may leave partial data behind in Google
  Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}:exportDocuments"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-importDocuments$
  "Required parameters: name
  
  Optional parameters: none
  
  Imports documents into Google Cloud Firestore. Existing documents with the
  same name are overwritten. The import occurs in the background and its
  progress can be monitored and managed via the Operation resource that is
  created. If an ImportDocuments operation is cancelled, it is possible
  that a subset of the data has already been imported to Cloud Firestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}:importDocuments"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-collectionGroups-fields-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the metadata and configuration for a Field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-fields-patch$
  "Required parameters: name
  
  Optional parameters: updateMask
  
  Updates a field configuration. Currently, field updates apply only to
  single field index configuration. However, calls to
  FirestoreAdmin.UpdateField should provide a field mask to avoid
  changing any configuration that the caller isn't aware of. The field mask
  should be specified as: `{ paths: \"index_config\" }`.
  
  This call returns a google.longrunning.Operation which may be used to
  track the status of the field update. The metadata for
  the operation will be the type FieldOperationMetadata.
  
  To configure the default field settings for the database, use
  the special `Field` with resource name:
  `projects/{project_id}/databases/{database_id}/collectionGroups/__default__/fields/*`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-fields-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists the field configuration and metadata for this database.
  
  Currently, FirestoreAdmin.ListFields only supports listing fields
  that have been explicitly overridden. To issue this query, call
  FirestoreAdmin.ListFields with the filter set to
  `indexConfig.usesAncestorConfig:false`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/fields"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-indexes-list$
  "Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists composite indexes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/indexes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-indexes-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a composite index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-collectionGroups-indexes-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a composite index. This returns a google.longrunning.Operation
  which may be used to track the status of the creation. The metadata for
  the operation will be the type IndexOperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/indexes"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-collectionGroups-indexes-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a composite index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-rollback$
  "Required parameters: database
  
  Optional parameters: none
  
  Rolls back a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:rollback"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-get$
  "Required parameters: name
  
  Optional parameters: mask.fieldPaths, readTime, transaction
  
  Gets a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-patch$
  "Required parameters: name
  
  Optional parameters: currentDocument.updateTime, currentDocument.exists, updateMask.fieldPaths, mask.fieldPaths
  
  Updates or inserts a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-batchGet$
  "Required parameters: database
  
  Optional parameters: none
  
  Gets multiple documents.
  
  Documents returned by this method are not guaranteed to be returned in the
  same order that they were requested."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:batchGet"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-delete$
  "Required parameters: name
  
  Optional parameters: currentDocument.exists, currentDocument.updateTime
  
  Deletes a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-runQuery$
  "Required parameters: parent
  
  Optional parameters: none
  
  Runs a query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:runQuery"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-write$
  "Required parameters: database
  
  Optional parameters: none
  
  Streams batches of document updates and deletes, in order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:write"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-beginTransaction$
  "Required parameters: database
  
  Optional parameters: none
  
  Starts a new transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:beginTransaction"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-listen$
  "Required parameters: database
  
  Optional parameters: none
  
  Listens to changes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:listen"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-list$
  "Required parameters: collectionId, parent
  
  Optional parameters: mask.fieldPaths, transaction, pageToken, pageSize, readTime, showMissing, orderBy
  
  Lists documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"collectionId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/{collectionId}"
     #{"collectionId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-documents-commit$
  "Required parameters: database
  
  Optional parameters: none
  
  Commits a transaction, while optionally updating documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+database}/documents:commit"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-listCollectionIds$
  "Required parameters: parent
  
  Optional parameters: none
  
  Lists all the collection IDs underneath a document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}:listCollectionIds"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-documents-createDocument$
  "Required parameters: collectionId, parent
  
  Optional parameters: mask.fieldPaths, documentId
  
  Creates a new document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"collectionId" "parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+parent}/{collectionId}"
     #{"collectionId" "parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn databases-operations-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-operations-list$
  "Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}/operations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn databases-operations-cancel$
  "Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}:cancel"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://firestore.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
