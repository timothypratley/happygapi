(ns happygapi.spanner.projects
  "Cloud Spanner API: projects.
  Cloud Spanner is a managed, mission-critical, globally consistent and scalable relational database service.
  See: https://cloud.google.com/spanner/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn instanceConfigs-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the supported instance configurations for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instanceConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instanceConfigs-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a particular instance configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:instanceConfigId string,
   :instanceConfig {:labels {},
                    :baseConfig string,
                    :displayName string,
                    :name string,
                    :etag string,
                    :state string,
                    :leaderOptions [string],
                    :reconciling boolean,
                    :freeInstanceAvailability string,
                    :replicas [ReplicaInfo],
                    :optionalReplicas [ReplicaInfo],
                    :storageLimitPerProcessingUnit string,
                    :configType string},
   :validateOnly boolean}
  
  Creates an instance config and begins preparing it to be used. The returned long-running operation can be used to track the progress of preparing the new instance config. The instance config name is assigned by the caller. If the named instance config already exists, `CreateInstanceConfig` returns `ALREADY_EXISTS`. Immediately after the request returns: * The instance config is readable via the API, with all requested attributes. The instance config's reconciling field is set to true. Its state is `CREATING`. While the operation is pending: * Cancelling the operation renders the instance config immediately unreadable via the API. * Except for deleting the creating resource, all other attempts to modify the instance config are rejected. Upon completion of the returned operation: * Instances can be created using the instance configuration. * The instance config's reconciling field becomes false. Its state becomes `READY`. The returned long-running operation will have a name of the format `/operations/` and can be used to track creation of the instance config. The metadata field type is CreateInstanceConfigMetadata. The response field type is InstanceConfig, if successful. Authorization requires `spanner.instanceConfigs.create` permission on the resource parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instanceConfigs"
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

(defn instanceConfigs-patch$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:instanceConfig {:labels {},
                    :baseConfig string,
                    :displayName string,
                    :name string,
                    :etag string,
                    :state string,
                    :leaderOptions [string],
                    :reconciling boolean,
                    :freeInstanceAvailability string,
                    :replicas [ReplicaInfo],
                    :optionalReplicas [ReplicaInfo],
                    :storageLimitPerProcessingUnit string,
                    :configType string},
   :updateMask string,
   :validateOnly boolean}
  
  Updates an instance config. The returned long-running operation can be used to track the progress of updating the instance. If the named instance config does not exist, returns `NOT_FOUND`. Only user managed configurations can be updated. Immediately after the request returns: * The instance config's reconciling field is set to true. While the operation is pending: * Cancelling the operation sets its metadata's cancel_time. The operation is guaranteed to succeed at undoing all changes, after which point it terminates with a `CANCELLED` status. * All other attempts to modify the instance config are rejected. * Reading the instance config via the API continues to give the pre-request values. Upon completion of the returned operation: * Creating instances using the instance configuration uses the new values. * The instance config's new values are readable via the API. * The instance config's reconciling field becomes false. The returned long-running operation will have a name of the format `/operations/` and can be used to track the instance config modification. The metadata field type is UpdateInstanceConfigMetadata. The response field type is InstanceConfig, if successful. Authorization requires `spanner.instanceConfigs.update` permission on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/delete
  
  Required parameters: name
  
  Optional parameters: etag, validateOnly
  
  Deletes the instance config. Deletion is only allowed when no instances are using the configuration. If any instances are using the config, returns `FAILED_PRECONDITION`. Only user managed configurations can be deleted. Authorization requires `spanner.instanceConfigs.delete` permission on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instanceConfigs-ssdCaches-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/ssdCaches/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-ssdCaches-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/ssdCaches/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-ssdCaches-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/ssdCaches/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instanceConfigs-ssdCaches-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigs/ssdCaches/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instanceConfigOperations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instanceConfigOperations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the user-managed instance config long-running operations in the given project. An instance config operation has a name of the form `projects//instanceConfigs//operations/`. The long-running operation metadata field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations. Operations returned are ordered by `operation.metadata.value.start_time` in descending order starting from the most recently started operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instanceConfigOperations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/get
  
  Required parameters: name
  
  Optional parameters: fieldMask
  
  Gets information about a particular instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-setIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on an instance resource. Replaces any existing policy. Authorization requires `spanner.instances.setIamPolicy` on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-patch$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:instance {:labels {},
              :freeInstanceMetadata FreeInstanceMetadata,
              :instanceType string,
              :config string,
              :displayName string,
              :name string,
              :createTime string,
              :state string,
              :updateTime string,
              :endpointUris [string],
              :processingUnits integer,
              :nodeCount integer,
              :autoscalingConfig AutoscalingConfig},
   :fieldMask string}
  
  Updates an instance, and begins allocating or releasing resources as requested. The returned long-running operation can be used to track the progress of updating the instance. If the named instance does not exist, returns `NOT_FOUND`. Immediately upon completion of this request: * For resource types for which a decrease in the instance's allocation has been requested, billing is based on the newly-requested level. Until completion of the returned operation: * Cancelling the operation sets its metadata's cancel_time, and begins restoring resources to their pre-request values. The operation is guaranteed to succeed at undoing all resource changes, after which point it terminates with a `CANCELLED` status. * All other attempts to modify the instance are rejected. * Reading the instance via the API continues to give the pre-request resource levels. Upon completion of the returned operation: * Billing begins for all successfully-allocated resources (some types may have lower than the requested levels). * All newly-reserved resources are available for serving the instance's tables. * The instance's new resource levels are readable via the API. The returned long-running operation will have a name of the format `/operations/` and can be used to track the instance modification. The metadata field type is UpdateInstanceMetadata. The response field type is Instance, if successful. Authorization requires `spanner.instances.update` permission on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-testIamPermissions$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified instance resource. Attempting this RPC on a non-existent Cloud Spanner instance resource will result in a NOT_FOUND error if the user has `spanner.instances.list` permission on the containing Google Cloud Project. Otherwise returns an empty set of permissions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:instanceId string,
   :instance {:labels {},
              :freeInstanceMetadata FreeInstanceMetadata,
              :instanceType string,
              :config string,
              :displayName string,
              :name string,
              :createTime string,
              :state string,
              :updateTime string,
              :endpointUris [string],
              :processingUnits integer,
              :nodeCount integer,
              :autoscalingConfig AutoscalingConfig}}
  
  Creates an instance and begins preparing it to begin serving. The returned long-running operation can be used to track the progress of preparing the new instance. The instance name is assigned by the caller. If the named instance already exists, `CreateInstance` returns `ALREADY_EXISTS`. Immediately upon completion of this request: * The instance is readable via the API, with all requested attributes but no allocated resources. Its state is `CREATING`. Until completion of the returned operation: * Cancelling the operation renders the instance immediately unreadable via the API. * The instance can be deleted. * All other attempts to modify the instance are rejected. Upon completion of the returned operation: * Billing for all successfully-allocated resources begins (some types may have lower than the requested levels). * Databases can be created in the instance. * The instance's allocated resource levels are readable via the API. * The instance's state becomes `READY`. The returned long-running operation will have a name of the format `/operations/` and can be used to track creation of the instance. The metadata field type is CreateInstanceMetadata. The response field type is Instance, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instances"
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

(defn instances-move$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/move
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetConfig string}
  
  Moves the instance to the target instance config. The returned long-running operation can be used to track the progress of moving the instance. `MoveInstance` returns `FAILED_PRECONDITION` if the instance meets any of the following criteria: * Has an ongoing move to a different instance config * Has backups * Has an ongoing update * Is under free trial * Contains any CMEK-enabled databases While the operation is pending: * All other attempts to modify the instance, including changes to its compute capacity, are rejected. * The following database and backup admin operations are rejected: * DatabaseAdmin.CreateDatabase, * DatabaseAdmin.UpdateDatabaseDdl (Disabled if default_leader is specified in the request.) * DatabaseAdmin.RestoreDatabase * DatabaseAdmin.CreateBackup * DatabaseAdmin.CopyBackup * Both the source and target instance configs are subject to hourly compute and storage charges. * The instance may experience higher read-write latencies and a higher transaction abort rate. However, moving an instance does not cause any downtime. The returned long-running operation will have a name of the format `/operations/` and can be used to track the move instance operation. The metadata field type is MoveInstanceMetadata. The response field type is Instance, if successful. Cancelling the operation sets its metadata's cancel_time. Cancellation is not immediate since it involves moving any data previously moved to target instance config back to the original instance config. The same operation can be used to track the progress of the cancellation. Upon successful completion of the cancellation, the operation terminates with CANCELLED status. Upon completion(if not cancelled) of the returned operation: * Instance would be successfully moved to the target instance config. * You are billed for compute and storage in target instance config. Authorization requires `spanner.instances.update` permission on the resource instance. For more details, please see [documentation](https://cloud.google.com/spanner/docs/move-instance)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:move"
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

(defn instances-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an instance. Immediately upon completion of the request: * Billing ceases for all of the instance's reserved resources. Soon afterward: * The instance and *all of its databases* immediately and irrevocably disappear from the API. All data in the databases is permanently deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-getIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for an instance resource. Returns an empty policy if an instance exists but does not have a policy set. Authorization requires `spanner.instances.getIamPolicy` on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn instances-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, instanceDeadline
  
  Lists all instances in the given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-getDdl$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/getDdl
  
  Required parameters: database
  
  Optional parameters: none
  
  Returns the schema of a Cloud Spanner database as a list of formatted DDL statements. This method does not show pending schema updates, those may be queried using the Operations API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/ddl"
     #{:database}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the state of a Cloud Spanner database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-setIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on a database or backup resource. Replaces any existing policy. Authorization requires `spanner.databases.setIamPolicy` permission on resource. For backups, authorization requires `spanner.backups.setIamPolicy` permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-patch$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:restoreInfo {:sourceType string, :backupInfo BackupInfo},
   :encryptionInfo [{:encryptionType string,
                     :encryptionStatus Status,
                     :kmsKeyVersion string}],
   :name string,
   :defaultLeader string,
   :createTime string,
   :state string,
   :earliestVersionTime string,
   :versionRetentionPeriod string,
   :reconciling boolean,
   :databaseDialect string,
   :enableDropProtection boolean,
   :encryptionConfig {:kmsKeyName string, :kmsKeyNames [string]}}
  
  Updates a Cloud Spanner database. The returned long-running operation can be used to track the progress of updating the database. If the named database does not exist, returns `NOT_FOUND`. While the operation is pending: * The database's reconciling field is set to true. * Cancelling the operation is best-effort. If the cancellation succeeds, the operation metadata's cancel_time is set, the updates are reverted, and the operation terminates with a `CANCELLED` status. * New UpdateDatabase requests will return a `FAILED_PRECONDITION` error until the pending operation is done (returns successfully or with error). * Reading the database via the API continues to give the pre-request values. Upon completion of the returned operation: * The new values are in effect and readable via the API. * The database's reconciling field becomes false. The returned long-running operation will have a name of the format `projects//instances//databases//operations/` and can be used to track the database modification. The metadata field type is UpdateDatabaseMetadata. The response field type is Database, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-testIamPermissions$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified database or backup resource. Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND error if the user has `spanner.databases.list` permission on the containing Cloud Spanner instance. Otherwise returns an empty set of permissions. Calling this method on a backup that does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list` permission on the containing instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-restore$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/restore
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:databaseId string,
   :backup string,
   :encryptionConfig {:encryptionType string,
                      :kmsKeyName string,
                      :kmsKeyNames [string]}}
  
  Create a new database by restoring from a completed backup. The new database must be in the same project and in an instance with the same instance configuration as the instance containing the backup. The returned database long-running operation has a name of the format `projects//instances//databases//operations/`, and can be used to track the progress of the operation, and to cancel it. The metadata field type is RestoreDatabaseMetadata. The response type is Database, if successful. Cancelling the returned operation will stop the restore and delete the database. There can be only one database being restored into an instance at a time. Once the restore operation completes, a new restore operation can be initiated, without waiting for the optimize operation associated with the first restore to complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:createStatement string,
   :extraStatements [string],
   :encryptionConfig {:kmsKeyName string, :kmsKeyNames [string]},
   :databaseDialect string,
   :protoDescriptors string}
  
  Creates a new Cloud Spanner database and starts to prepare it for serving. The returned long-running operation will have a name of the format `/operations/` and can be used to track preparation of the database. The metadata field type is CreateDatabaseMetadata. The response field type is Database, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-updateDdl$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/updateDdl
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:statements [string], :operationId string, :protoDescriptors string}
  
  Updates the schema of a Cloud Spanner database by creating/altering/dropping tables, columns, indexes, etc. The returned long-running operation will have a name of the format `/operations/` and can be used to track execution of the schema change(s). The metadata field type is UpdateDatabaseDdlMetadata. The operation has no response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/ddl"
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

(defn instances-databases-getIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a database or backup resource. Returns an empty policy if a database or backup exists but does not have a policy set. Authorization requires `spanner.databases.getIamPolicy` permission on resource. For backups, authorization requires `spanner.backups.getIamPolicy` permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn instances-databases-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Cloud Spanner databases."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-getScans$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/getScans
  
  Required parameters: name
  
  Optional parameters: view, startTime, endTime
  
  Request a specific scan with Database-specific data for Cloud Key Visualizer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}/scans"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-dropDatabase$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/dropDatabase
  
  Required parameters: database
  
  Optional parameters: none
  
  Drops (aka deletes) a Cloud Spanner database. Completed backups for the database will be retained according to their `expire_time`. Note: Cloud Spanner might continue to accept requests for a few seconds after the database has been deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}"
     #{:database}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-databaseRoles-testIamPermissions$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/databaseRoles/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified database or backup resource. Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND error if the user has `spanner.databases.list` permission on the containing Cloud Spanner instance. Otherwise returns an empty set of permissions. Calling this method on a backup that does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list` permission on the containing instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-databaseRoles-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/databaseRoles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Cloud Spanner database roles."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/databaseRoles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-sessions-rollback$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/rollback
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:transactionId string}
  
  Rolls back a transaction, releasing any locks it holds. It is a good idea to call this for any transaction that includes one or more Read or ExecuteSql requests and ultimately decides not to commit. `Rollback` returns `OK` if it successfully aborts the transaction, the transaction was already aborted, or the transaction is not found. `Rollback` never returns `ABORTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:rollback"
     #{:session}
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

(defn instances-databases-sessions-executeStreamingSql$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/executeStreamingSql
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryMode string,
   :dataBoostEnabled boolean,
   :directedReadOptions {:includeReplicas IncludeReplicas,
                         :excludeReplicas ExcludeReplicas},
   :params {},
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string},
   :transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :partitionToken string,
   :seqno string,
   :paramTypes {},
   :sql string,
   :resumeToken string,
   :queryOptions {:optimizerVersion string,
                  :optimizerStatisticsPackage string}}
  
  Like ExecuteSql, except returns the result set as a stream. Unlike ExecuteSql, there is no limit on the size of the returned result set. However, no individual row in the result set can exceed 100 MiB, and no column value can exceed 10 MiB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeStreamingSql"
     #{:session}
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

(defn instances-databases-sessions-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a session. Returns `NOT_FOUND` if the session does not exist. This is mainly useful for determining whether a session is still alive."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-sessions-batchWrite$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/batchWrite
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string},
   :mutationGroups [{:mutations [Mutation]}],
   :excludeTxnFromChangeStreams boolean}
  
  Batches the supplied mutation groups in a collection of efficient transactions. All mutations in a group are committed atomically. However, mutations across groups can be committed non-atomically in an unspecified order and thus, they must be independent of each other. Partial failure is possible, i.e., some groups may have been committed successfully, while some may have failed. The results of individual batches are streamed into the response as the batches are applied. BatchWrite requests are not replay protected, meaning that each mutation group may be applied more than once. Replays of non-idempotent mutations may have undesirable effects. For example, replays of an insert mutation may produce an already exists error or if you use generated or commit timestamp-based keys, it may result in additional rows being added to the mutation's table. We recommend structuring your mutation groups to be idempotent to avoid this issue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:batchWrite"
     #{:session}
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

(defn instances-databases-sessions-executeSql$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/executeSql
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:queryMode string,
   :dataBoostEnabled boolean,
   :directedReadOptions {:includeReplicas IncludeReplicas,
                         :excludeReplicas ExcludeReplicas},
   :params {},
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string},
   :transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :partitionToken string,
   :seqno string,
   :paramTypes {},
   :sql string,
   :resumeToken string,
   :queryOptions {:optimizerVersion string,
                  :optimizerStatisticsPackage string}}
  
  Executes an SQL statement, returning all results in a single reply. This method cannot be used to return a result set larger than 10 MiB; if the query yields more data than that, the query fails with a `FAILED_PRECONDITION` error. Operations inside read-write transactions might return `ABORTED`. If this occurs, the application should restart the transaction from the beginning. See Transaction for more details. Larger result sets can be fetched in streaming fashion by calling ExecuteStreamingSql instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeSql"
     #{:session}
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

(defn instances-databases-sessions-read$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/read
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:dataBoostEnabled boolean,
   :table string,
   :limit string,
   :index string,
   :directedReadOptions {:includeReplicas IncludeReplicas,
                         :excludeReplicas ExcludeReplicas},
   :columns [string],
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string},
   :transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :partitionToken string,
   :keySet {:keys [[any]], :ranges [KeyRange], :all boolean},
   :resumeToken string}
  
  Reads rows from the database using key lookups and scans, as a simple key/value style alternative to ExecuteSql. This method cannot be used to return a result set larger than 10 MiB; if the read matches more data than that, the read fails with a `FAILED_PRECONDITION` error. Reads inside read-write transactions might return `ABORTED`. If this occurs, the application should restart the transaction from the beginning. See Transaction for more details. Larger result sets can be yielded in streaming fashion by calling StreamingRead instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:read"
     #{:session}
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

(defn instances-databases-sessions-partitionRead$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/partitionRead
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :table string,
   :index string,
   :columns [string],
   :keySet {:keys [[any]], :ranges [KeyRange], :all boolean},
   :partitionOptions {:partitionSizeBytes string, :maxPartitions string}}
  
  Creates a set of partition tokens that can be used to execute a read operation in parallel. Each of the returned partition tokens can be used by StreamingRead to specify a subset of the read result to read. The same session and read-only transaction must be used by the PartitionReadRequest used to create the partition tokens and the ReadRequests that use the partition tokens. There are no ordering guarantees on rows returned among the returned partition tokens, or even within each individual StreamingRead call issued with a partition_token. Partition tokens become invalid when the session used to create them is deleted, is idle for too long, begins a new transaction, or becomes too old. When any of these happen, it is not possible to resume the read, and the whole operation must be restarted from the beginning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:partitionRead"
     #{:session}
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

(defn instances-databases-sessions-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/create
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:session {:name string,
             :labels {},
             :createTime string,
             :approximateLastUseTime string,
             :creatorRole string,
             :multiplexed boolean}}
  
  Creates a new session. A session can be used to perform transactions that read and/or modify data in a Cloud Spanner database. Sessions are meant to be reused for many consecutive transactions. Sessions can only execute one transaction at a time. To execute multiple concurrent read-write/write-only transactions, create multiple sessions. Note that standalone reads and queries use a transaction internally, and count toward the one transaction limit. Active sessions use additional server resources, so it is a good idea to delete idle and unneeded sessions. Aside from explicit deletes, Cloud Spanner may delete sessions for which no operations are sent for more than an hour. If a session is deleted, requests to it return `NOT_FOUND`. Idle sessions can be kept alive by sending a trivial SQL query periodically, e.g., `\"SELECT 1\"`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions"
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

(defn instances-databases-sessions-batchCreate$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/batchCreate
  
  Required parameters: database
  
  Optional parameters: none
  
  Body: 
  
  {:sessionTemplate {:name string,
                     :labels {},
                     :createTime string,
                     :approximateLastUseTime string,
                     :creatorRole string,
                     :multiplexed boolean},
   :sessionCount integer}
  
  Creates multiple new sessions. This API can be used to initialize a session cache on the clients. See https://goo.gl/TgSFN2 for best practices on session cache management."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions:batchCreate"
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

(defn instances-databases-sessions-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Ends a session, releasing server resources associated with it. This will asynchronously trigger cancellation of any operations that are running with this session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-databases-sessions-partitionQuery$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/partitionQuery
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :sql string,
   :params {},
   :paramTypes {},
   :partitionOptions {:partitionSizeBytes string, :maxPartitions string}}
  
  Creates a set of partition tokens that can be used to execute a query operation in parallel. Each of the returned partition tokens can be used by ExecuteStreamingSql to specify a subset of the query result to read. The same session and read-only transaction must be used by the PartitionQueryRequest used to create the partition tokens and the ExecuteSqlRequests that use the partition tokens. Partition tokens become invalid when the session used to create them is deleted, is idle for too long, begins a new transaction, or becomes too old. When any of these happen, it is not possible to resume the query, and the whole operation must be restarted from the beginning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:partitionQuery"
     #{:session}
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

(defn instances-databases-sessions-beginTransaction$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/beginTransaction
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:options {:readWrite ReadWrite,
             :partitionedDml PartitionedDml,
             :readOnly ReadOnly,
             :excludeTxnFromChangeStreams boolean},
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string}}
  
  Begins a new transaction. This step can often be skipped: Read, ExecuteSql and Commit can begin a new transaction as a side-effect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:beginTransaction"
     #{:session}
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

(defn instances-databases-sessions-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/list
  
  Required parameters: database
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all sessions in a given database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:database})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+database}/sessions"
     #{:database}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databases-sessions-commit$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/commit
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:transactionId string,
   :singleUseTransaction {:readWrite ReadWrite,
                          :partitionedDml PartitionedDml,
                          :readOnly ReadOnly,
                          :excludeTxnFromChangeStreams boolean},
   :mutations [{:insert Write,
                :update Write,
                :insertOrUpdate Write,
                :replace Write,
                :delete Delete}],
   :returnCommitStats boolean,
   :maxCommitDelay string,
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string}}
  
  Commits a transaction. The request includes the mutations to be applied to rows in the database. `Commit` might return an `ABORTED` error. This can occur at any time; commonly, the cause is conflicts with concurrent transactions. However, it can also happen for a variety of other reasons. If `Commit` returns `ABORTED`, the caller should re-attempt the transaction from the beginning, re-using the same session. On very rare occasions, `Commit` might return `UNKNOWN`. This can happen, for example, if the client job experiences a 1+ hour networking failure. At that point, Cloud Spanner has lost track of the transaction outcome and we recommend that you perform another read from the database to see the state of things as they are now."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:commit"
     #{:session}
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

(defn instances-databases-sessions-executeBatchDml$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/executeBatchDml
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :statements [{:sql string, :params {}, :paramTypes {}}],
   :seqno string,
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string}}
  
  Executes a batch of SQL DML statements. This method allows many statements to be run with lower latency than submitting them sequentially with ExecuteSql. Statements are executed in sequential order. A request can succeed even if a statement fails. The ExecuteBatchDmlResponse.status field in the response provides information about the statement that failed. Clients must inspect this field to determine whether an error occurred. Execution stops after the first failed statement; the remaining statements are not executed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:executeBatchDml"
     #{:session}
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

(defn instances-databases-sessions-streamingRead$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databases/sessions/streamingRead
  
  Required parameters: session
  
  Optional parameters: none
  
  Body: 
  
  {:dataBoostEnabled boolean,
   :table string,
   :limit string,
   :index string,
   :directedReadOptions {:includeReplicas IncludeReplicas,
                         :excludeReplicas ExcludeReplicas},
   :columns [string],
   :requestOptions {:priority string,
                    :requestTag string,
                    :transactionTag string},
   :transaction {:singleUse TransactionOptions,
                 :id string,
                 :begin TransactionOptions},
   :partitionToken string,
   :keySet {:keys [[any]], :ranges [KeyRange], :all boolean},
   :resumeToken string}
  
  Like Read, except returns the result set as a stream. Unlike Read, there is no limit on the size of the returned result set. However, no individual row in the result set can exceed 100 MiB, and no column value can exceed 10 MiB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:session})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+session}:streamingRead"
     #{:session}
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

(defn instances-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-backups-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metadata on a pending or completed Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-copy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/copy
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:backupId string,
   :sourceBackup string,
   :expireTime string,
   :encryptionConfig {:encryptionType string,
                      :kmsKeyName string,
                      :kmsKeyNames [string]}}
  
  Starts copying a Cloud Spanner Backup. The returned backup long-running operation will have a name of the format `projects//instances//backups//operations/` and can be used to track copying of the backup. The operation is associated with the destination backup. The metadata field type is CopyBackupMetadata. The response field type is Backup, if successful. Cancelling the returned operation will stop the copying and delete the destination backup. Concurrent CopyBackup requests can run on the same source backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/backups:copy"
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

(defn instances-backups-setIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on a database or backup resource. Replaces any existing policy. Authorization requires `spanner.databases.setIamPolicy` permission on resource. For backups, authorization requires `spanner.backups.setIamPolicy` permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-patch$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:maxExpireTime string,
   :encryptionInfo {:encryptionType string,
                    :encryptionStatus Status,
                    :kmsKeyVersion string},
   :referencingDatabases [string],
   :name string,
   :sizeBytes string,
   :createTime string,
   :state string,
   :encryptionInformation [{:encryptionType string,
                            :encryptionStatus Status,
                            :kmsKeyVersion string}],
   :referencingBackups [string],
   :database string,
   :databaseDialect string,
   :expireTime string,
   :versionTime string}
  
  Updates a pending or completed Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-testIamPermissions$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that the caller has on the specified database or backup resource. Attempting this RPC on a non-existent Cloud Spanner database will result in a NOT_FOUND error if the user has `spanner.databases.list` permission on the containing Cloud Spanner instance. Otherwise returns an empty set of permissions. Calling this method on a backup that does not exist will result in a NOT_FOUND error if the user has `spanner.backups.list` permission on the containing instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId, encryptionConfig.encryptionType, encryptionConfig.kmsKeyName, encryptionConfig.kmsKeyNames
  
  Body: 
  
  {:maxExpireTime string,
   :encryptionInfo {:encryptionType string,
                    :encryptionStatus Status,
                    :kmsKeyVersion string},
   :referencingDatabases [string],
   :name string,
   :sizeBytes string,
   :createTime string,
   :state string,
   :encryptionInformation [{:encryptionType string,
                            :encryptionStatus Status,
                            :kmsKeyVersion string}],
   :referencingBackups [string],
   :database string,
   :databaseDialect string,
   :expireTime string,
   :versionTime string}
  
  Starts creating a new Cloud Spanner Backup. The returned backup long-running operation will have a name of the format `projects//instances//backups//operations/` and can be used to track creation of the backup. The metadata field type is CreateBackupMetadata. The response field type is Backup, if successful. Cancelling the returned operation will stop the creation and delete the backup. There can be only one pending backup creation per database. Backup creation of different databases can run concurrently."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a pending or completed Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-getIamPolicy$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a database or backup resource. Returns an empty policy if a database or backup exists but does not have a policy set. Authorization requires `spanner.databases.getIamPolicy` permission on resource. For backups, authorization requires `spanner.backups.getIamPolicy` permission on resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn instances-backups-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists completed and pending backups. Backups returned are ordered by `create_time` in descending order, starting from the most recent `create_time`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-backups-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backups/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-databaseOperations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/databaseOperations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists database longrunning-operations. A database operation has a name of the form `projects//instances//databases//operations/`. The long-running operation metadata field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/databaseOperations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-backupOperations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/backupOperations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the backup long-running operations in the given instance. A backup operation has a name of the form `projects//instances//backups//operations/`. The long-running operation metadata field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations. Operations returned are ordered by `operation.metadata.value.progress.start_time` in descending order starting from the most recently started operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/backupOperations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-instancePartitions-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, instancePartitionDeadline
  
  Lists all instance partitions for the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instancePartitions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-instancePartitions-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a particular instance partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-create$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:instancePartitionId string,
   :instancePartition {:referencingDatabases [string],
                       :config string,
                       :displayName string,
                       :name string,
                       :createTime string,
                       :etag string,
                       :state string,
                       :updateTime string,
                       :referencingBackups [string],
                       :processingUnits integer,
                       :nodeCount integer}}
  
  Creates an instance partition and begins preparing it to be used. The returned long-running operation can be used to track the progress of preparing the new instance partition. The instance partition name is assigned by the caller. If the named instance partition already exists, `CreateInstancePartition` returns `ALREADY_EXISTS`. Immediately upon completion of this request: * The instance partition is readable via the API, with all requested attributes but no allocated resources. Its state is `CREATING`. Until completion of the returned operation: * Cancelling the operation renders the instance partition immediately unreadable via the API. * The instance partition can be deleted. * All other attempts to modify the instance partition are rejected. Upon completion of the returned operation: * Billing for all successfully-allocated resources begins (some types may have lower than the requested levels). * Databases can start using this instance partition. * The instance partition's allocated resource levels are readable via the API. * The instance partition's state becomes `READY`. The returned long-running operation will have a name of the format `/operations/` and can be used to track creation of the instance partition. The metadata field type is CreateInstancePartitionMetadata. The response field type is InstancePartition, if successful."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instancePartitions"
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

(defn instances-instancePartitions-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes an existing instance partition. Requires that the instance partition is not used by any database or backup and is not the default instance partition of an instance. Authorization requires `spanner.instancePartitions.delete` permission on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-patch$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:instancePartition {:referencingDatabases [string],
                       :config string,
                       :displayName string,
                       :name string,
                       :createTime string,
                       :etag string,
                       :state string,
                       :updateTime string,
                       :referencingBackups [string],
                       :processingUnits integer,
                       :nodeCount integer},
   :fieldMask string}
  
  Updates an instance partition, and begins allocating or releasing resources as requested. The returned long-running operation can be used to track the progress of updating the instance partition. If the named instance partition does not exist, returns `NOT_FOUND`. Immediately upon completion of this request: * For resource types for which a decrease in the instance partition's allocation has been requested, billing is based on the newly-requested level. Until completion of the returned operation: * Cancelling the operation sets its metadata's cancel_time, and begins restoring resources to their pre-request values. The operation is guaranteed to succeed at undoing all resource changes, after which point it terminates with a `CANCELLED` status. * All other attempts to modify the instance partition are rejected. * Reading the instance partition via the API continues to give the pre-request resource levels. Upon completion of the returned operation: * Billing begins for all successfully-allocated resources (some types may have lower than the requested levels). * All newly-reserved resources are available for serving the instance partition's tables. * The instance partition's new resource levels are readable via the API. The returned long-running operation will have a name of the format `/operations/` and can be used to track the instance partition modification. The metadata field type is UpdateInstancePartitionMetadata. The response field type is InstancePartition, if successful. Authorization requires `spanner.instancePartitions.update` permission on the resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-operations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-operations-get$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-operations-delete$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://spanner.googleapis.com/"
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

(defn instances-instancePartitions-operations-cancel$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitions/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-instancePartitionOperations-list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/projects/instances/instancePartitionOperations/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, instancePartitionDeadline
  
  Lists instance partition long-running operations in the given instance. An instance partition operation has a name of the form `projects//instances//instancePartitions//operations/`. The long-running operation metadata field type `metadata.type_url` describes the type of the metadata. Operations returned include those that have completed/failed/canceled within the last 7 days, and pending operations. Operations returned are ordered by `operation.metadata.value.start_time` in descending order starting from the most recently started operation. Authorization requires `spanner.instancePartitionOperations.list` permission on the resource parent."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}/instancePartitionOperations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
