(ns happygapi.spanner.projects
  "Cloud Spanner API
  Cloud Spanner is a managed, mission-critical, globally consistent and scalable relational database service.
  See: https://cloud.google.com/spanner/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "spanner_schema.edn"))))

(defn instances-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes an instance.
  
  Immediately upon completion of the request:
  
    * Billing ceases for all of the instance's reserved resources.
  
  Soon afterward:
  
    * The instance and *all of its databases* immediately and
      irrevocably disappear from the API. All data in the databases
      is permanently deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists all instances in the given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instances"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on an instance resource. Replaces any
  existing policy.
  
  Authorization requires `spanner.instances.setIamPolicy` on
  resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates an instance and begins preparing it to begin serving. The
  returned long-running operation
  can be used to track the progress of preparing the new
  instance. The instance name is assigned by the caller. If the
  named instance already exists, `CreateInstance` returns
  `ALREADY_EXISTS`.
  
  Immediately upon completion of this request:
  
    * The instance is readable via the API, with all requested attributes
      but no allocated resources. Its state is `CREATING`.
  
  Until completion of the returned operation:
  
    * Cancelling the operation renders the instance immediately unreadable
      via the API.
    * The instance can be deleted.
    * All other attempts to modify the instance are rejected.
  
  Upon completion of the returned operation:
  
    * Billing for all successfully-allocated resources begins (some types
      may have lower than the requested levels).
    * Databases can be created in the instance.
    * The instance's allocated resource levels are readable via the API.
    * The instance's state becomes `READY`.
  
  The returned long-running operation will
  have a name of the format `<instance_name>/operations/<operation_id>` and
  can be used to track creation of the instance.  The
  metadata field type is
  CreateInstanceMetadata.
  The response field type is
  Instance, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instances"
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

(defn instances-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for an instance resource. Returns an empty
  policy if an instance exists but does not have a policy set.
  
  Authorization requires `spanner.instances.getIamPolicy` on
  resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-patch$
  "Required parameters: name
  
  Optional parameters: none
  
  Updates an instance, and begins allocating or releasing resources
  as requested. The returned long-running
  operation can be used to track the
  progress of updating the instance. If the named instance does not
  exist, returns `NOT_FOUND`.
  
  Immediately upon completion of this request:
  
    * For resource types for which a decrease in the instance's allocation
      has been requested, billing is based on the newly-requested level.
  
  Until completion of the returned operation:
  
    * Cancelling the operation sets its metadata's
      cancel_time, and begins
      restoring resources to their pre-request values. The operation
      is guaranteed to succeed at undoing all resource changes,
      after which point it terminates with a `CANCELLED` status.
    * All other attempts to modify the instance are rejected.
    * Reading the instance via the API continues to give the pre-request
      resource levels.
  
  Upon completion of the returned operation:
  
    * Billing begins for all successfully-allocated resources (some types
      may have lower than the requested levels).
    * All newly-reserved resources are available for serving the instance's
      tables.
    * The instance's new resource levels are readable via the API.
  
  The returned long-running operation will
  have a name of the format `<instance_name>/operations/<operation_id>` and
  can be used to track the instance modification.  The
  metadata field type is
  UpdateInstanceMetadata.
  The response field type is
  Instance, if successful.
  
  Authorization requires `spanner.instances.update` permission on
  resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-get$
  "Required parameters: name
  
  Optional parameters: fieldMask
  
  Gets information about a particular instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that the caller has on the specified instance resource.
  
  Attempting this RPC on a non-existent Cloud Spanner instance resource will
  result in a NOT_FOUND error if the user has `spanner.instances.list`
  permission on the containing Google Cloud Project. Otherwise returns an
  empty set of permissions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn instances-databases-getDdl$
  "Required parameters: database
  
  Optional parameters: none
  
  Returns the schema of a Cloud Spanner database as a list of formatted
  DDL statements. This method does not show pending schema updates, those may
  be queried using the Operations API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/ddl"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the state of a Cloud Spanner database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on a database resource.
  Replaces any existing policy.
  
  Authorization requires `spanner.databases.setIamPolicy`
  permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-databases-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that the caller has on the specified database resource.
  
  Attempting this RPC on a non-existent Cloud Spanner database will
  result in a NOT_FOUND error if the user has
  `spanner.databases.list` permission on the containing Cloud
  Spanner instance. Otherwise returns an empty set of permissions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn instances-databases-create$
  "Required parameters: parent
  
  Optional parameters: none
  
  Creates a new Cloud Spanner database and starts to prepare it for serving.
  The returned long-running operation will
  have a name of the format `<database_name>/operations/<operation_id>` and
  can be used to track preparation of the database. The
  metadata field type is
  CreateDatabaseMetadata. The
  response field type is
  Database, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/databases"
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

(defn instances-databases-updateDdl$
  "Required parameters: database
  
  Optional parameters: none
  
  Updates the schema of a Cloud Spanner database by
  creating/altering/dropping tables, columns, indexes, etc. The returned
  long-running operation will have a name of
  the format `<database_name>/operations/<operation_id>` and can be used to
  track execution of the schema change(s). The
  metadata field type is
  UpdateDatabaseDdlMetadata.  The operation has no response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/ddl"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a database resource.
  Returns an empty policy if a database exists but does
  not have a policy set.
  
  Authorization requires `spanner.databases.getIamPolicy` permission on
  resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-databases-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists Cloud Spanner databases."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/databases"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-dropDatabase$
  "Required parameters: database
  
  Optional parameters: none
  
  Drops (aka deletes) a Cloud Spanner database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-operations-cancel$
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-list$
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-sessions-rollback$
  "Required parameters: session
  
  Optional parameters: none
  
  Rolls back a transaction, releasing any locks it holds. It is a good
  idea to call this for any transaction that includes one or more
  Read or ExecuteSql requests and
  ultimately decides not to commit.
  
  `Rollback` returns `OK` if it successfully aborts the transaction, the
  transaction was already aborted, or the transaction is not
  found. `Rollback` never returns `ABORTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:rollback"
     #{"session"}
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

(defn instances-databases-sessions-executeStreamingSql$
  "Required parameters: session
  
  Optional parameters: none
  
  Like ExecuteSql, except returns the result
  set as a stream. Unlike ExecuteSql, there
  is no limit on the size of the returned result set. However, no
  individual row in the result set can exceed 100 MiB, and no
  column value can exceed 10 MiB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeStreamingSql"
     #{"session"}
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

(defn instances-databases-sessions-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets a session. Returns `NOT_FOUND` if the session does not exist.
  This is mainly useful for determining whether a session is still
  alive."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-sessions-executeSql$
  "Required parameters: session
  
  Optional parameters: none
  
  Executes an SQL statement, returning all results in a single reply. This
  method cannot be used to return a result set larger than 10 MiB;
  if the query yields more data than that, the query fails with
  a `FAILED_PRECONDITION` error.
  
  Operations inside read-write transactions might return `ABORTED`. If
  this occurs, the application should restart the transaction from
  the beginning. See Transaction for more details.
  
  Larger result sets can be fetched in streaming fashion by calling
  ExecuteStreamingSql instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeSql"
     #{"session"}
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

(defn instances-databases-sessions-read$
  "Required parameters: session
  
  Optional parameters: none
  
  Reads rows from the database using key lookups and scans, as a
  simple key/value style alternative to
  ExecuteSql.  This method cannot be used to
  return a result set larger than 10 MiB; if the read matches more
  data than that, the read fails with a `FAILED_PRECONDITION`
  error.
  
  Reads inside read-write transactions might return `ABORTED`. If
  this occurs, the application should restart the transaction from
  the beginning. See Transaction for more details.
  
  Larger result sets can be yielded in streaming fashion by calling
  StreamingRead instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:read"
     #{"session"}
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

(defn instances-databases-sessions-partitionRead$
  "Required parameters: session
  
  Optional parameters: none
  
  Creates a set of partition tokens that can be used to execute a read
  operation in parallel.  Each of the returned partition tokens can be used
  by StreamingRead to specify a subset of the read
  result to read.  The same session and read-only transaction must be used by
  the PartitionReadRequest used to create the partition tokens and the
  ReadRequests that use the partition tokens.  There are no ordering
  guarantees on rows returned among the returned partition tokens, or even
  within each individual StreamingRead call issued with a partition_token.
  
  Partition tokens become invalid when the session used to create them
  is deleted, is idle for too long, begins a new transaction, or becomes too
  old.  When any of these happen, it is not possible to resume the read, and
  the whole operation must be restarted from the beginning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:partitionRead"
     #{"session"}
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

(defn instances-databases-sessions-create$
  "Required parameters: database
  
  Optional parameters: none
  
  Creates a new session. A session can be used to perform
  transactions that read and/or modify data in a Cloud Spanner database.
  Sessions are meant to be reused for many consecutive
  transactions.
  
  Sessions can only execute one transaction at a time. To execute
  multiple concurrent read-write/write-only transactions, create
  multiple sessions. Note that standalone reads and queries use a
  transaction internally, and count toward the one transaction
  limit.
  
  Active sessions use additional server resources, so it is a good idea to
  delete idle and unneeded sessions.
  Aside from explicit deletes, Cloud Spanner may delete sessions for which no
  operations are sent for more than an hour. If a session is deleted,
  requests to it return `NOT_FOUND`.
  
  Idle sessions can be kept alive by sending a trivial SQL query
  periodically, e.g., `\"SELECT 1\"`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions"
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

(defn instances-databases-sessions-batchCreate$
  "Required parameters: database
  
  Optional parameters: none
  
  Creates multiple new sessions.
  
  This API can be used to initialize a session cache on the clients.
  See https://goo.gl/TgSFN2 for best practices on session cache management."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions:batchCreate"
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

(defn instances-databases-sessions-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Ends a session, releasing server resources associated with it. This will
  asynchronously trigger cancellation of any operations that are running with
  this session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-sessions-partitionQuery$
  "Required parameters: session
  
  Optional parameters: none
  
  Creates a set of partition tokens that can be used to execute a query
  operation in parallel.  Each of the returned partition tokens can be used
  by ExecuteStreamingSql to specify a subset
  of the query result to read.  The same session and read-only transaction
  must be used by the PartitionQueryRequest used to create the
  partition tokens and the ExecuteSqlRequests that use the partition tokens.
  
  Partition tokens become invalid when the session used to create them
  is deleted, is idle for too long, begins a new transaction, or becomes too
  old.  When any of these happen, it is not possible to resume the query, and
  the whole operation must be restarted from the beginning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:partitionQuery"
     #{"session"}
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

(defn instances-databases-sessions-beginTransaction$
  "Required parameters: session
  
  Optional parameters: none
  
  Begins a new transaction. This step can often be skipped:
  Read, ExecuteSql and
  Commit can begin a new transaction as a
  side-effect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:beginTransaction"
     #{"session"}
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

(defn instances-databases-sessions-list$
  "Required parameters: database
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists all sessions in a given database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args]
  {:pre [(util/has-keys? args #{"database"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions"
     #{"database"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-sessions-commit$
  "Required parameters: session
  
  Optional parameters: none
  
  Commits a transaction. The request includes the mutations to be
  applied to rows in the database.
  
  `Commit` might return an `ABORTED` error. This can occur at any time;
  commonly, the cause is conflicts with concurrent
  transactions. However, it can also happen for a variety of other
  reasons. If `Commit` returns `ABORTED`, the caller should re-attempt
  the transaction from the beginning, re-using the same session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:commit"
     #{"session"}
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

(defn instances-databases-sessions-executeBatchDml$
  "Required parameters: session
  
  Optional parameters: none
  
  Executes a batch of SQL DML statements. This method allows many statements
  to be run with lower latency than submitting them sequentially with
  ExecuteSql.
  
  Statements are executed in sequential order. A request can succeed even if
  a statement fails. The ExecuteBatchDmlResponse.status field in the
  response provides information about the statement that failed. Clients must
  inspect this field to determine whether an error occurred.
  
  Execution stops after the first failed statement; the remaining statements
  are not executed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeBatchDml"
     #{"session"}
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

(defn instances-databases-sessions-streamingRead$
  "Required parameters: session
  
  Optional parameters: none
  
  Like Read, except returns the result set as a
  stream. Unlike Read, there is no limit on the
  size of the returned result set. However, no individual row in
  the result set can exceed 100 MiB, and no column value can exceed
  10 MiB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"session"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:streamingRead"
     #{"session"}
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

(defn instances-operations-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-list$
  "Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-cancel$
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-getIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Gets the access control policy for a database resource.
  Returns an empty policy if a database exists but does
  not have a policy set.
  
  Authorization requires `spanner.databases.getIamPolicy` permission on
  resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
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

(defn instances-backups-setIamPolicy$
  "Required parameters: resource
  
  Optional parameters: none
  
  Sets the access control policy on a database resource.
  Replaces any existing policy.
  
  Authorization requires `spanner.databases.setIamPolicy`
  permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn instances-backups-testIamPermissions$
  "Required parameters: resource
  
  Optional parameters: none
  
  Returns permissions that the caller has on the specified database resource.
  
  Attempting this RPC on a non-existent Cloud Spanner database will
  result in a NOT_FOUND error if the user has
  `spanner.databases.list` permission on the containing Cloud
  Spanner instance. Otherwise returns an empty set of permissions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn instances-backups-operations-cancel$
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-delete$
  "Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-list$
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
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-list$
  "Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists the supported instance configurations for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instanceConfigs"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instanceConfigs-get$
  "Required parameters: name
  
  Optional parameters: none
  
  Gets information about a particular instance configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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
