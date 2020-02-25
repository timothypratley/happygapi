(ns happygapi.datastore.projects
  "Cloud Datastore API
  Accesses the schemaless NoSQL database to provide fully managed, robust, scalable storage for your application.
  
  See: https://cloud.google.com/datastore/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "datastore_schema.edn"))))

(defn rollback$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Rolls back a transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:rollback"
     #{"projectId"}
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

(defn reserveIds$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Prevents the supplied keys' IDs from being auto-allocated by Cloud
  Datastore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:reserveIds"
     #{"projectId"}
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

(defn lookup$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Looks up entities by key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:lookup"
     #{"projectId"}
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

(defn runQuery$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Queries for entities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:runQuery"
     #{"projectId"}
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

(defn export$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Exports a copy of all or a subset of entities from Google Cloud Datastore
  to another storage system, such as Google Cloud Storage. Recent updates to
  entities may not be reflected in the export. The export occurs in the
  background and its progress can be monitored and managed via the
  Operation resource that is created. The output of an export may only be
  used once the associated operation is done. If an export operation is
  cancelled before completion it may leave partial data behind in Google
  Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:export"
     #{"projectId"}
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

(defn beginTransaction$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Begins a new transaction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:beginTransaction"
     #{"projectId"}
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

(defn commit$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Commits a transaction, optionally creating, deleting or modifying some
  entities."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:commit"
     #{"projectId"}
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

(defn allocateIds$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Allocates IDs for the given keys, which is useful for referencing an entity
  before it is inserted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:allocateIds"
     #{"projectId"}
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

(defn import$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Imports entities into Google Cloud Datastore. Existing entities with the
  same key are overwritten. The import occurs in the background and its
  progress can be monitored and managed via the Operation resource that is
  created. If an ImportEntities operation is cancelled, it is possible
  that a subset of the data has already been imported to Cloud Datastore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}:import"
     #{"projectId"}
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

(defn indexes-delete$
  "Required parameters: projectId, indexId
  
  Optional parameters: none
  
  Deletes an existing index.
  An index can only be deleted if it is in a `READY` or `ERROR` state. On
  successful execution of the request, the index will be in a `DELETING`
  state. And on completion of the
  returned google.longrunning.Operation, the index will be removed.
  
  During index deletion, the process could result in an error, in which
  case the index will move to the `ERROR` state. The process can be recovered
  by fixing the data that caused the error, followed by calling
  delete again."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"indexId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes/{indexId}"
     #{"indexId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-get$
  "Required parameters: indexId, projectId
  
  Optional parameters: none
  
  Gets an index."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"indexId" "projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes/{indexId}"
     #{"indexId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-list$
  "Required parameters: projectId
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists the indexes that match the specified filters.  Datastore uses an
  eventually consistent query to fetch the list of indexes and may
  occasionally return stale results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn indexes-create$
  "Required parameters: projectId
  
  Optional parameters: none
  
  Creates the specified index.
  A newly created index's initial state is `CREATING`. On completion of the
  returned google.longrunning.Operation, the state will be `READY`.
  If the index already exists, the call will return an `ALREADY_EXISTS`
  status.
  
  During index creation, the process could result in an error, in which
  case the index will move to the `ERROR` state. The process can be recovered
  by fixing the data that caused the error, removing the index with
  delete, then
  re-creating the index with create.
  
  Indexes with a single property cannot be created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/datastore"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"projectId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastore.googleapis.com/"
     "v1/projects/{projectId}/indexes"
     #{"projectId"}
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

(defn operations-cancel$
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
     "https://datastore.googleapis.com/"
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

(defn operations-delete$
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
     "https://datastore.googleapis.com/"
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

(defn operations-list$
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
     "https://datastore.googleapis.com/"
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

(defn operations-get$
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
     "https://datastore.googleapis.com/"
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
