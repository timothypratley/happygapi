(ns happygapi.datamigration.projects
  "Database Migration API: projects.
  Manage Cloud Database Migration Service resources on Google Cloud Platform.
  See: https://cloud.google.com/database-migration/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-fetchStaticIps$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/fetchStaticIps
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Fetches a set of static IP addresses that need to be allowlisted by the customer when using the static-IP connectivity method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:fetchStaticIps"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-demoteDestination$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/demoteDestination
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Demotes the destination database to become a read replica of the source. This is applicable for the following migrations: 1. MySQL to Cloud SQL for MySQL 2. PostgreSQL to Cloud SQL for PostgreSQL 3. PostgreSQL to AlloyDB for PostgreSQL."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:demoteDestination"
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

(defn locations-migrationJobs-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-restart$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/restart
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipValidation boolean}
  
  Restart a stopped or failed migration job, resetting the destination instance to its original state and starting the migration process from scratch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-patch$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :dumpType string,
   :reverseSshConnectivity {:vmIp string,
                            :vmPort integer,
                            :vm string,
                            :vpc string},
   :destinationDatabase {:provider string, :engine string},
   :dumpPath string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :phase string,
   :type string,
   :staticIpConnectivity {},
   :duration string,
   :state string,
   :source string,
   :performanceConfig {:dumpParallelLevel string},
   :dumpFlags {:dumpFlags [DumpFlag]},
   :updateTime string,
   :filter string,
   :sqlserverHomogeneousMigrationJobConfig {:backupFilePattern string,
                                            :databaseBackups [SqlServerDatabaseBackup]},
   :error {:code integer, :message string, :details [{}]},
   :sourceDatabase {:provider string, :engine string},
   :cmekKeyName string,
   :vpcPeeringConnectivity {:vpc string},
   :destination string,
   :conversionWorkspace {:name string, :commitId string}}
  
  Updates the parameters of a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-generateSshScript$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/generateSshScript
  
  Required parameters: migrationJob
  
  Optional parameters: none
  
  Body: 
  
  {:vm string,
   :vmCreationConfig {:vmMachineType string,
                      :vmZone string,
                      :subnet string},
   :vmSelectionConfig {:vmZone string},
   :vmPort integer}
  
  Generate a SSH configuration script to configure the reverse SSH connectivity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migrationJob})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+migrationJob}:generateSshScript"
     #{:migrationJob}
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

(defn locations-migrationJobs-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/create
  
  Required parameters: parent
  
  Optional parameters: migrationJobId, requestId
  
  Body: 
  
  {:labels {},
   :dumpType string,
   :reverseSshConnectivity {:vmIp string,
                            :vmPort integer,
                            :vm string,
                            :vpc string},
   :destinationDatabase {:provider string, :engine string},
   :dumpPath string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :phase string,
   :type string,
   :staticIpConnectivity {},
   :duration string,
   :state string,
   :source string,
   :performanceConfig {:dumpParallelLevel string},
   :dumpFlags {:dumpFlags [DumpFlag]},
   :updateTime string,
   :filter string,
   :sqlserverHomogeneousMigrationJobConfig {:backupFilePattern string,
                                            :databaseBackups [SqlServerDatabaseBackup]},
   :error {:code integer, :message string, :details [{}]},
   :sourceDatabase {:provider string, :engine string},
   :cmekKeyName string,
   :vpcPeeringConnectivity {:vpc string},
   :destination string,
   :conversionWorkspace {:name string, :commitId string}}
  
  Creates a new migration job in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/migrationJobs"
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

(defn locations-migrationJobs-start$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipValidation boolean}
  
  Start an already created migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:start"
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

(defn locations-migrationJobs-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-stop$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a running migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:stop"
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

(defn locations-migrationJobs-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists migration jobs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/migrationJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migrationJobs-verify$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/verify
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :migrationJob {:labels {},
                  :dumpType string,
                  :reverseSshConnectivity ReverseSshConnectivity,
                  :destinationDatabase DatabaseType,
                  :dumpPath string,
                  :displayName string,
                  :name string,
                  :endTime string,
                  :createTime string,
                  :phase string,
                  :type string,
                  :staticIpConnectivity StaticIpConnectivity,
                  :duration string,
                  :state string,
                  :source string,
                  :performanceConfig PerformanceConfig,
                  :dumpFlags DumpFlags,
                  :updateTime string,
                  :filter string,
                  :sqlserverHomogeneousMigrationJobConfig SqlServerHomogeneousMigrationJobConfig,
                  :error Status,
                  :sourceDatabase DatabaseType,
                  :cmekKeyName string,
                  :vpcPeeringConnectivity VpcPeeringConnectivity,
                  :destination string,
                  :conversionWorkspace ConversionWorkspaceInfo}}
  
  Verify a migration job, making sure the destination can reach the source and that all configuration and prerequisites are met."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:verify"
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

(defn locations-migrationJobs-resume$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipValidation boolean}
  
  Resume a migration job that is currently stopped and is resumable (was stopped during CDC phase)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:resume"
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

(defn locations-migrationJobs-generateTcpProxyScript$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/generateTcpProxyScript
  
  Required parameters: migrationJob
  
  Optional parameters: none
  
  Body: 
  
  {:vmName string,
   :vmMachineType string,
   :vmZone string,
   :vmSubnet string}
  
  Generate a TCP Proxy configuration script to configure a cloud-hosted VM running a TCP Proxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migrationJob})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+migrationJob}:generateTcpProxyScript"
     #{:migrationJob}
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

(defn locations-migrationJobs-promote$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/promote
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Promote a migration job, stopping replication to the destination and promoting the destination to be a standalone database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Retrieves a list of all connection profiles in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/connectionProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connectionProfiles-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/create
  
  Required parameters: parent
  
  Optional parameters: connectionProfileId, requestId, validateOnly, skipValidation
  
  Body: 
  
  {:labels {},
   :alloydb {:clusterId string, :settings AlloyDbSettings},
   :postgresql {:ssl SslConfig,
                :password string,
                :networkArchitecture string,
                :privateServiceConnectConnectivity PrivateServiceConnectConnectivity,
                :username string,
                :staticIpConnectivity StaticIpConnectivity,
                :cloudSqlId string,
                :port integer,
                :host string,
                :alloydbClusterId string,
                :passwordSet boolean},
   :displayName string,
   :name string,
   :createTime string,
   :cloudsql {:cloudSqlId string,
              :settings CloudSqlSettings,
              :privateIp string,
              :publicIp string,
              :additionalPublicIp string},
   :oracle {:ssl SslConfig,
            :privateConnectivity PrivateConnectivity,
            :password string,
            :username string,
            :forwardSshConnectivity ForwardSshTunnelConnectivity,
            :port integer,
            :host string,
            :databaseService string,
            :staticServiceIpConnectivity StaticServiceIpConnectivity,
            :passwordSet boolean},
   :state string,
   :updateTime string,
   :error {:code integer, :message string, :details [{}]},
   :provider string,
   :mysql {:host string,
           :port integer,
           :username string,
           :password string,
           :passwordSet boolean,
           :ssl SslConfig,
           :cloudSqlId string},
   :sqlserver {:ssl SslConfig,
               :privateConnectivity PrivateConnectivity,
               :password string,
               :privateServiceConnectConnectivity PrivateServiceConnectConnectivity,
               :username string,
               :staticIpConnectivity StaticIpConnectivity,
               :forwardSshConnectivity ForwardSshTunnelConnectivity,
               :cloudSqlId string,
               :port integer,
               :backups SqlServerBackups,
               :host string,
               :passwordSet boolean}}
  
  Creates a new connection profile in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/connectionProfiles"
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

(defn locations-connectionProfiles-patch$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, skipValidation
  
  Body: 
  
  {:labels {},
   :alloydb {:clusterId string, :settings AlloyDbSettings},
   :postgresql {:ssl SslConfig,
                :password string,
                :networkArchitecture string,
                :privateServiceConnectConnectivity PrivateServiceConnectConnectivity,
                :username string,
                :staticIpConnectivity StaticIpConnectivity,
                :cloudSqlId string,
                :port integer,
                :host string,
                :alloydbClusterId string,
                :passwordSet boolean},
   :displayName string,
   :name string,
   :createTime string,
   :cloudsql {:cloudSqlId string,
              :settings CloudSqlSettings,
              :privateIp string,
              :publicIp string,
              :additionalPublicIp string},
   :oracle {:ssl SslConfig,
            :privateConnectivity PrivateConnectivity,
            :password string,
            :username string,
            :forwardSshConnectivity ForwardSshTunnelConnectivity,
            :port integer,
            :host string,
            :databaseService string,
            :staticServiceIpConnectivity StaticServiceIpConnectivity,
            :passwordSet boolean},
   :state string,
   :updateTime string,
   :error {:code integer, :message string, :details [{}]},
   :provider string,
   :mysql {:host string,
           :port integer,
           :username string,
           :password string,
           :passwordSet boolean,
           :ssl SslConfig,
           :cloudSqlId string},
   :sqlserver {:ssl SslConfig,
               :privateConnectivity PrivateConnectivity,
               :password string,
               :privateServiceConnectConnectivity PrivateServiceConnectConnectivity,
               :username string,
               :staticIpConnectivity StaticIpConnectivity,
               :forwardSshConnectivity ForwardSshTunnelConnectivity,
               :cloudSqlId string,
               :port integer,
               :backups SqlServerBackups,
               :host string,
               :passwordSet boolean}}
  
  Update the configuration of a single connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a single Database Migration Service connection profile. A connection profile can only be deleted if it is not in use by any active migration jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-privateConnections-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/create
  
  Required parameters: parent
  
  Optional parameters: privateConnectionId, requestId, skipValidation
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :displayName string,
   :state string,
   :error {:code integer, :message string, :details [{}]},
   :vpcPeeringConfig {:vpcName string, :subnet string}}
  
  Creates a new private connection in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/privateConnections"
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

(defn locations-privateConnections-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single private connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-privateConnections-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Retrieves a list of private connections in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/privateConnections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateConnections-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Database Migration Service private connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-privateConnections-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-privateConnections-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-privateConnections-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/privateConnections/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-rollback$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Rolls back a conversion workspace to the last committed snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:rollback"
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

(defn locations-conversionWorkspaces-describeConversionWorkspaceRevisions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/describeConversionWorkspaceRevisions
  
  Required parameters: conversionWorkspace
  
  Optional parameters: commitId
  
  Retrieves a list of committed revisions of a specific conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:conversionWorkspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+conversionWorkspace}:describeConversionWorkspaceRevisions"
     #{:conversionWorkspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversionWorkspaces-convert$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/convert
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:autoCommit boolean, :filter string, :convertFullPath boolean}
  
  Creates a draft tree schema for the destination database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:convert"
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

(defn locations-conversionWorkspaces-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-patch$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:latestCommitTime string,
   :latestCommitId string,
   :displayName string,
   :name string,
   :createTime string,
   :hasUncommittedChanges boolean,
   :source {:engine string, :version string},
   :updateTime string,
   :globalSettings {},
   :destination {:engine string, :version string}}
  
  Updates the parameters of a single conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-searchBackgroundJobs$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/searchBackgroundJobs
  
  Required parameters: conversionWorkspace
  
  Optional parameters: returnMostRecentPerJobType, maxSize, completedUntilTime
  
  Searches/lists the background jobs for a specific conversion workspace. The background jobs are not resources like conversion workspaces or mapping rules, and they can't be created, updated or deleted. Instead, they are a way to expose the data plane jobs log."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:conversionWorkspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+conversionWorkspace}:searchBackgroundJobs"
     #{:conversionWorkspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversionWorkspaces-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/create
  
  Required parameters: parent
  
  Optional parameters: conversionWorkspaceId, requestId
  
  Body: 
  
  {:latestCommitTime string,
   :latestCommitId string,
   :displayName string,
   :name string,
   :createTime string,
   :hasUncommittedChanges boolean,
   :source {:engine string, :version string},
   :updateTime string,
   :globalSettings {},
   :destination {:engine string, :version string}}
  
  Creates a new conversion workspace in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/conversionWorkspaces"
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

(defn locations-conversionWorkspaces-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a single conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-seed$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/seed
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:autoCommit boolean,
   :sourceConnectionProfile string,
   :destinationConnectionProfile string}
  
  Imports a snapshot of the source database into the conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:seed"
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

(defn locations-conversionWorkspaces-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists conversion workspaces in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/conversionWorkspaces"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversionWorkspaces-commit$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/commit
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:commitName string}
  
  Marks all the data in the conversion workspace as committed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:commit"
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

(defn locations-conversionWorkspaces-apply$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/apply
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :dryRun boolean,
   :autoCommit boolean,
   :connectionProfile string}
  
  Applies draft tree onto a specific destination database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:apply"
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

(defn locations-conversionWorkspaces-describeDatabaseEntities$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/describeDatabaseEntities
  
  Required parameters: conversionWorkspace
  
  Optional parameters: pageSize, pageToken, tree, uncommitted, commitId, filter, view
  
  Describes the database entities tree for a specific conversion workspace and a specific tree type. Database entities are not resources like conversion workspaces or mapping rules, and they can't be created, updated or deleted. Instead, they are simple data objects describing the structure of the client database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:conversionWorkspace})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+conversionWorkspace}:describeDatabaseEntities"
     #{:conversionWorkspace}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversionWorkspaces-mappingRules-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/mappingRules/create
  
  Required parameters: parent
  
  Optional parameters: mappingRuleId, requestId
  
  Body: 
  
  {:setTablePrimaryKey {:primaryKeyColumns [string], :primaryKey string},
   :ruleScope string,
   :multiColumnDataTypeChange {:sourceTextFilter SourceTextFilter,
                               :sourceDataTypeFilter string,
                               :customFeatures {},
                               :overrideLength string,
                               :overridePrecision integer,
                               :overrideFractionalSecondsPrecision integer,
                               :newDataType string,
                               :sourceNumericFilter SourceNumericFilter,
                               :overrideScale integer},
   :singleColumnChange {:customFeatures {},
                        :scale integer,
                        :precision integer,
                        :arrayLength integer,
                        :collation string,
                        :array boolean,
                        :charset string,
                        :autoGenerated boolean,
                        :udt boolean,
                        :dataType string,
                        :comment string,
                        :length string,
                        :setValues [string],
                        :fractionalSecondsPrecision integer,
                        :nullable boolean},
   :entityMove {:newSchema string},
   :displayName string,
   :revisionCreateTime string,
   :name string,
   :revisionId string,
   :multiEntityRename {:newNamePattern string,
                       :sourceNameTransformation string},
   :state string,
   :filterTableColumns {:includeColumns [string],
                        :excludeColumns [string]},
   :convertRowidColumn {:onlyIfNoPrimaryKey boolean},
   :conditionalColumnSetValue {:sourceTextFilter SourceTextFilter,
                               :sourceNumericFilter SourceNumericFilter,
                               :valueTransformation ValueTransformation,
                               :customFeatures {}},
   :filter {:parentEntity string,
            :entityNamePrefix string,
            :entityNameSuffix string,
            :entityNameContains string,
            :entities [string]},
   :singlePackageChange {:packageDescription string,
                         :packageBody string},
   :singleEntityRename {:newName string},
   :ruleOrder string,
   :sourceSqlChange {:sqlCode string}}
  
  Creates a new mapping rule for a given conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/mappingRules"
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

(defn locations-conversionWorkspaces-mappingRules-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/mappingRules/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single mapping rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-mappingRules-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/mappingRules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the mapping rules for a specific conversion workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/mappingRules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-conversionWorkspaces-mappingRules-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/mappingRules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a mapping rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-conversionWorkspaces-mappingRules-import$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/conversionWorkspaces/mappingRules/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:rulesFormat string,
   :rulesFiles [{:rulesSourceFilename string, :rulesContent string}],
   :autoCommit boolean}
  
  Imports the mapping rules for a given conversion workspace. Supports various formats of external rules files."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/mappingRules:import"
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
