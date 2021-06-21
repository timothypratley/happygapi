(ns happygapi.redis.projects
  "Google Cloud Memorystore for Redis API: projects.
  Creates and manages Redis instances on the Google Cloud Platform.
  See: https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-failover$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/failover
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataProtectionMode string}
  
  Initiates a failover of the primary node to current replica node for a specific STANDARD tier Cloud Memorystore for Redis instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}:failover"
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

(defn locations-instances-get$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a specific Redis instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-patch$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :tier string,
   :connectMode string,
   :memorySizeGb integer,
   :authEnabled boolean,
   :redisVersion string,
   :displayName string,
   :locationId string,
   :name string,
   :reservedIpRange string,
   :statusMessage string,
   :createTime string,
   :maintenanceSchedule {:endTime string,
                         :canReschedule boolean,
                         :scheduleDeadlineTime string,
                         :startTime string},
   :state string,
   :port integer,
   :redisConfigs {},
   :maintenancePolicy {:weeklyMaintenanceWindow [WeeklyMaintenanceWindow],
                       :createTime string,
                       :updateTime string,
                       :description string},
   :persistenceIamIdentity string,
   :host string,
   :serverCaCerts [{:createTime string,
                    :expireTime string,
                    :serialNumber string,
                    :sha1Fingerprint string,
                    :cert string}],
   :currentLocationId string,
   :alternativeLocationId string,
   :transitEncryptionMode string,
   :authorizedNetwork string}
  
  Updates the metadata and configuration of a specific Redis instance. Completed longrunning.Operation will contain the new instance object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-getAuthString$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/getAuthString
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the AUTH string for a Redis instance. If AUTH is not enabled for the instance the response will be empty. This information is not included in the details returned to GetInstance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}/authString"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-rescheduleMaintenance$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/rescheduleMaintenance
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:rescheduleType string, :scheduleTime string}
  
  Reschedule maintenance for a given instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}:rescheduleMaintenance"
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

(defn locations-instances-create$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:labels {},
   :tier string,
   :connectMode string,
   :memorySizeGb integer,
   :authEnabled boolean,
   :redisVersion string,
   :displayName string,
   :locationId string,
   :name string,
   :reservedIpRange string,
   :statusMessage string,
   :createTime string,
   :maintenanceSchedule {:endTime string,
                         :canReschedule boolean,
                         :scheduleDeadlineTime string,
                         :startTime string},
   :state string,
   :port integer,
   :redisConfigs {},
   :maintenancePolicy {:weeklyMaintenanceWindow [WeeklyMaintenanceWindow],
                       :createTime string,
                       :updateTime string,
                       :description string},
   :persistenceIamIdentity string,
   :host string,
   :serverCaCerts [{:createTime string,
                    :expireTime string,
                    :serialNumber string,
                    :sha1Fingerprint string,
                    :cert string}],
   :currentLocationId string,
   :alternativeLocationId string,
   :transitEncryptionMode string,
   :authorizedNetwork string}
  
  Creates a Redis instance based on the specified tier and memory size. By default, the instance is accessible from the project's [default network](https://cloud.google.com/vpc/docs/vpc). The creation is executed asynchronously and callers may check the returned operation to track its progress. Once the operation is completed the Redis instance will be fully functional. Completed longrunning.Operation will contain the new instance object in the response field. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-delete$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a specific Redis instance. Instance stops serving and data is deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-export$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/export
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:outputConfig {:gcsDestination GcsDestination}}
  
  Export Redis instance data into a Redis RDB format file in Cloud Storage. Redis will continue serving during this operation. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}:export"
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

(defn locations-instances-upgrade$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/upgrade
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:redisVersion string}
  
  Upgrades Redis instance to the newer Redis version specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}:upgrade"
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

(defn locations-instances-list$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all Redis instances owned by a project in either the specified location (region) or all locations. The location should have the following format: * `projects/{project_id}/locations/{location_id}` If `location_id` is specified as `-` (wildcard), then all regions available to the project are queried, and the results are aggregated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-instances-import$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/instances/import
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:gcsSource GcsSource}}
  
  Import a Redis RDB snapshot file from Cloud Storage into a Redis instance. Redis may stop serving during this operation. Instance state will be IMPORTING for entire operation. When complete, the instance will contain only data from the imported file. The returned operation is automatically deleted after a few hours, so there is no need to call DeleteOperation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
     "v1/{+name}:import"
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

(defn locations-operations-delete$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://redis.googleapis.com/"
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
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://redis.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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
  "https://cloud.google.com/memorystore/docs/redis/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://redis.googleapis.com/"
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
