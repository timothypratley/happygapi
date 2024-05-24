(ns happygapi.alloydb.projects
  "AlloyDB API: projects.
  AlloyDB for PostgreSQL is an open source-compatible database service that provides a powerful option for migrating, modernizing, or building commercial-grade applications. It offers full compatibility with standard PostgreSQL, and is more than 4x faster for transactional workloads and up to 100x faster for analytical queries than standard PostgreSQL in our performance tests. AlloyDB for PostgreSQL offers a 99.99 percent availability SLA inclusive of maintenance. AlloyDB is optimized for the most demanding use cases, allowing you to build new applications that require high transaction throughput, large database sizes, or multiple read resources; scale existing PostgreSQL workloads with no application changes; and modernize legacy proprietary databases. 
  See: https://cloud.google.com/alloydb/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-list$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/clusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-get$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-create$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/create
  
  Required parameters: parent
  
  Optional parameters: clusterId, requestId, validateOnly
  
  Body: 
  
  {:labels {},
   :continuousBackupConfig {:enabled boolean,
                            :recoveryWindowDays integer,
                            :encryptionConfig EncryptionConfig},
   :databaseVersion string,
   :initialUser {:user string, :password string},
   :deleteTime string,
   :encryptionInfo {:encryptionType string, :kmsKeyVersions [string]},
   :displayName string,
   :uid string,
   :name string,
   :primaryConfig {:secondaryClusterNames [string]},
   :continuousBackupInfo {:encryptionInfo EncryptionInfo,
                          :enabledTime string,
                          :schedule [string],
                          :earliestRestorableTime string},
   :createTime string,
   :pscConfig {:pscEnabled boolean},
   :etag string,
   :maintenanceSchedule {:startTime string},
   :state string,
   :networkConfig {:network string, :allocatedIpRange string},
   :updateTime string,
   :reconciling boolean,
   :maintenanceUpdatePolicy {:maintenanceWindows [MaintenanceWindow]},
   :automatedBackupPolicy {:weeklySchedule WeeklySchedule,
                           :timeBasedRetention TimeBasedRetention,
                           :quantityBasedRetention QuantityBasedRetention,
                           :enabled boolean,
                           :backupWindow string,
                           :encryptionConfig EncryptionConfig,
                           :location string,
                           :labels {}},
   :satisfiesPzs boolean,
   :migrationSource {:hostPort string,
                     :referenceId string,
                     :sourceType string},
   :annotations {},
   :network string,
   :sslConfig {:sslMode string, :caSource string},
   :secondaryConfig {:primaryClusterName string},
   :backupSource {:backupUid string, :backupName string},
   :clusterType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Creates a new Cluster in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/clusters"
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

(defn locations-clusters-patch$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, allowMissing
  
  Body: 
  
  {:labels {},
   :continuousBackupConfig {:enabled boolean,
                            :recoveryWindowDays integer,
                            :encryptionConfig EncryptionConfig},
   :databaseVersion string,
   :initialUser {:user string, :password string},
   :deleteTime string,
   :encryptionInfo {:encryptionType string, :kmsKeyVersions [string]},
   :displayName string,
   :uid string,
   :name string,
   :primaryConfig {:secondaryClusterNames [string]},
   :continuousBackupInfo {:encryptionInfo EncryptionInfo,
                          :enabledTime string,
                          :schedule [string],
                          :earliestRestorableTime string},
   :createTime string,
   :pscConfig {:pscEnabled boolean},
   :etag string,
   :maintenanceSchedule {:startTime string},
   :state string,
   :networkConfig {:network string, :allocatedIpRange string},
   :updateTime string,
   :reconciling boolean,
   :maintenanceUpdatePolicy {:maintenanceWindows [MaintenanceWindow]},
   :automatedBackupPolicy {:weeklySchedule WeeklySchedule,
                           :timeBasedRetention TimeBasedRetention,
                           :quantityBasedRetention QuantityBasedRetention,
                           :enabled boolean,
                           :backupWindow string,
                           :encryptionConfig EncryptionConfig,
                           :location string,
                           :labels {}},
   :satisfiesPzs boolean,
   :migrationSource {:hostPort string,
                     :referenceId string,
                     :sourceType string},
   :annotations {},
   :network string,
   :sslConfig {:sslMode string, :caSource string},
   :secondaryConfig {:primaryClusterName string},
   :backupSource {:backupUid string, :backupName string},
   :clusterType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Updates the parameters of a single Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-delete$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag, validateOnly, force
  
  Deletes a single Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-promote$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/promote
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :etag string, :validateOnly boolean}
  
  Promotes a SECONDARY cluster. This turns down replication from the PRIMARY cluster and promotes a secondary cluster into its own standalone cluster. Imperative only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+name}:promote"
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

(defn locations-clusters-restore$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/restore
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:backupSource {:backupUid string, :backupName string},
   :continuousBackupSource {:cluster string, :pointInTime string},
   :clusterId string,
   :cluster {:labels {},
             :continuousBackupConfig ContinuousBackupConfig,
             :databaseVersion string,
             :initialUser UserPassword,
             :deleteTime string,
             :encryptionInfo EncryptionInfo,
             :displayName string,
             :uid string,
             :name string,
             :primaryConfig PrimaryConfig,
             :continuousBackupInfo ContinuousBackupInfo,
             :createTime string,
             :pscConfig PscConfig,
             :etag string,
             :maintenanceSchedule MaintenanceSchedule,
             :state string,
             :networkConfig NetworkConfig,
             :updateTime string,
             :reconciling boolean,
             :maintenanceUpdatePolicy MaintenanceUpdatePolicy,
             :automatedBackupPolicy AutomatedBackupPolicy,
             :satisfiesPzs boolean,
             :migrationSource MigrationSource,
             :annotations {},
             :network string,
             :sslConfig SslConfig,
             :secondaryConfig SecondaryConfig,
             :backupSource BackupSource,
             :clusterType string,
             :encryptionConfig EncryptionConfig},
   :requestId string,
   :validateOnly boolean}
  
  Creates a new Cluster in a given project and location, with a volume restored from the provided source, either a backup ID or a point-in-time and a source cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/clusters:restore"
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

(defn locations-clusters-createsecondary$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/createsecondary
  
  Required parameters: parent
  
  Optional parameters: clusterId, requestId, validateOnly
  
  Body: 
  
  {:labels {},
   :continuousBackupConfig {:enabled boolean,
                            :recoveryWindowDays integer,
                            :encryptionConfig EncryptionConfig},
   :databaseVersion string,
   :initialUser {:user string, :password string},
   :deleteTime string,
   :encryptionInfo {:encryptionType string, :kmsKeyVersions [string]},
   :displayName string,
   :uid string,
   :name string,
   :primaryConfig {:secondaryClusterNames [string]},
   :continuousBackupInfo {:encryptionInfo EncryptionInfo,
                          :enabledTime string,
                          :schedule [string],
                          :earliestRestorableTime string},
   :createTime string,
   :pscConfig {:pscEnabled boolean},
   :etag string,
   :maintenanceSchedule {:startTime string},
   :state string,
   :networkConfig {:network string, :allocatedIpRange string},
   :updateTime string,
   :reconciling boolean,
   :maintenanceUpdatePolicy {:maintenanceWindows [MaintenanceWindow]},
   :automatedBackupPolicy {:weeklySchedule WeeklySchedule,
                           :timeBasedRetention TimeBasedRetention,
                           :quantityBasedRetention QuantityBasedRetention,
                           :enabled boolean,
                           :backupWindow string,
                           :encryptionConfig EncryptionConfig,
                           :location string,
                           :labels {}},
   :satisfiesPzs boolean,
   :migrationSource {:hostPort string,
                     :referenceId string,
                     :sourceType string},
   :annotations {},
   :network string,
   :sslConfig {:sslMode string, :caSource string},
   :secondaryConfig {:primaryClusterName string},
   :backupSource {:backupUid string, :backupName string},
   :clusterType string,
   :encryptionConfig {:kmsKeyName string}}
  
  Creates a cluster of type SECONDARY in the given location using the primary cluster as the source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/clusters:createsecondary"
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

(defn locations-clusters-instances-failover$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/failover
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :validateOnly boolean}
  
  Forces a Failover for a highly available instance. Failover promotes the HA standby instance as the new primary. Imperative only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-get$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-injectFault$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/injectFault
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:faultType string, :requestId string, :validateOnly boolean}
  
  Injects fault in an instance. Imperative only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+name}:injectFault"
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

(defn locations-clusters-instances-restart$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/restart
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string, :validateOnly boolean}
  
  Restart an Instance in a cluster. Imperative only."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+name}:restart"
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

(defn locations-clusters-instances-patch$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, allowMissing
  
  Body: 
  
  {:availabilityType string,
   :labels {},
   :pscInstanceConfig {:serviceAttachmentLink string,
                       :allowedConsumerProjects [string],
                       :pscDnsName string},
   :databaseFlags {},
   :deleteTime string,
   :clientConnectionConfig {:requireConnectors boolean,
                            :sslConfig SslConfig},
   :instanceType string,
   :displayName string,
   :uid string,
   :gceZone string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :machineConfig {:cpuCount integer},
   :networkConfig {:authorizedExternalNetworks [AuthorizedNetwork],
                   :enablePublicIp boolean},
   :updateTime string,
   :reconciling boolean,
   :readPoolConfig {:nodeCount integer},
   :publicIpAddress string,
   :nodes [{:zoneId string, :id string, :ip string, :state string}],
   :satisfiesPzs boolean,
   :annotations {},
   :ipAddress string,
   :queryInsightsConfig {:recordApplicationTags boolean,
                         :recordClientAddress boolean,
                         :queryStringLength integer,
                         :queryPlansPerMinute integer},
   :writableNode {:zoneId string, :id string, :ip string, :state string}}
  
  Updates the parameters of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-create$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId, requestId, validateOnly
  
  Body: 
  
  {:availabilityType string,
   :labels {},
   :pscInstanceConfig {:serviceAttachmentLink string,
                       :allowedConsumerProjects [string],
                       :pscDnsName string},
   :databaseFlags {},
   :deleteTime string,
   :clientConnectionConfig {:requireConnectors boolean,
                            :sslConfig SslConfig},
   :instanceType string,
   :displayName string,
   :uid string,
   :gceZone string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :machineConfig {:cpuCount integer},
   :networkConfig {:authorizedExternalNetworks [AuthorizedNetwork],
                   :enablePublicIp boolean},
   :updateTime string,
   :reconciling boolean,
   :readPoolConfig {:nodeCount integer},
   :publicIpAddress string,
   :nodes [{:zoneId string, :id string, :ip string, :state string}],
   :satisfiesPzs boolean,
   :annotations {},
   :ipAddress string,
   :queryInsightsConfig {:recordApplicationTags boolean,
                         :recordClientAddress boolean,
                         :queryStringLength integer,
                         :queryPlansPerMinute integer},
   :writableNode {:zoneId string, :id string, :ip string, :state string}}
  
  Creates a new Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-delete$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag, validateOnly
  
  Deletes a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-createsecondary$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/createsecondary
  
  Required parameters: parent
  
  Optional parameters: instanceId, requestId, validateOnly
  
  Body: 
  
  {:availabilityType string,
   :labels {},
   :pscInstanceConfig {:serviceAttachmentLink string,
                       :allowedConsumerProjects [string],
                       :pscDnsName string},
   :databaseFlags {},
   :deleteTime string,
   :clientConnectionConfig {:requireConnectors boolean,
                            :sslConfig SslConfig},
   :instanceType string,
   :displayName string,
   :uid string,
   :gceZone string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :machineConfig {:cpuCount integer},
   :networkConfig {:authorizedExternalNetworks [AuthorizedNetwork],
                   :enablePublicIp boolean},
   :updateTime string,
   :reconciling boolean,
   :readPoolConfig {:nodeCount integer},
   :publicIpAddress string,
   :nodes [{:zoneId string, :id string, :ip string, :state string}],
   :satisfiesPzs boolean,
   :annotations {},
   :ipAddress string,
   :queryInsightsConfig {:recordApplicationTags boolean,
                         :recordClientAddress boolean,
                         :queryStringLength integer,
                         :queryPlansPerMinute integer},
   :writableNode {:zoneId string, :id string, :ip string, :state string}}
  
  Creates a new SECONDARY Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/instances:createsecondary"
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

(defn locations-clusters-instances-list$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Instances in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-instances-getConnectionInfo$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/instances/getConnectionInfo
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Get instance metadata used for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/connectionInfo"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-users-list$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/users/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Users in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/users"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-users-get$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/users/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single User."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-users-create$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/users/create
  
  Required parameters: parent
  
  Optional parameters: userId, requestId, validateOnly
  
  Body: 
  
  {:name string,
   :password string,
   :databaseRoles [string],
   :userType string}
  
  Creates a new User in a given project, location, and cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/users"
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

(defn locations-clusters-users-patch$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/users/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, allowMissing
  
  Body: 
  
  {:name string,
   :password string,
   :databaseRoles [string],
   :userType string}
  
  Updates the parameters of a single User."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-clusters-users-delete$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/clusters/users/delete
  
  Required parameters: name
  
  Optional parameters: requestId, validateOnly
  
  Deletes a single User."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alloydb.googleapis.com/"
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
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Backups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-backups-get$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-backups-create$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :databaseVersion string,
   :clusterName string,
   :deleteTime string,
   :encryptionInfo {:encryptionType string, :kmsKeyVersions [string]},
   :displayName string,
   :uid string,
   :name string,
   :sizeBytes string,
   :createTime string,
   :type string,
   :etag string,
   :state string,
   :updateTime string,
   :reconciling boolean,
   :satisfiesPzs boolean,
   :expiryQuantity {:retentionCount integer,
                    :totalRetentionCount integer},
   :annotations {},
   :expiryTime string,
   :clusterUid string,
   :encryptionConfig {:kmsKeyName string}}
  
  Creates a new Backup in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-backups-patch$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :databaseVersion string,
   :clusterName string,
   :deleteTime string,
   :encryptionInfo {:encryptionType string, :kmsKeyVersions [string]},
   :displayName string,
   :uid string,
   :name string,
   :sizeBytes string,
   :createTime string,
   :type string,
   :etag string,
   :state string,
   :updateTime string,
   :reconciling boolean,
   :satisfiesPzs boolean,
   :expiryQuantity {:retentionCount integer,
                    :totalRetentionCount integer},
   :annotations {},
   :expiryTime string,
   :clusterUid string,
   :encryptionConfig {:kmsKeyName string}}
  
  Updates the parameters of a single Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-backups-delete$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/backups/delete
  
  Required parameters: name
  
  Optional parameters: requestId, validateOnly, etag
  
  Deletes a single Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://alloydb.googleapis.com/"
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

(defn locations-supportedDatabaseFlags-list$
  "https://cloud.google.com/alloydb/api/reference/rest/v1/projects/locations/supportedDatabaseFlags/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists SupportedDatabaseFlags for a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alloydb.googleapis.com/"
     "v1/{+parent}/supportedDatabaseFlags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
