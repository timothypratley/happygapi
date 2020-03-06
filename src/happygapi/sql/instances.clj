(ns happygapi.sql.instances
  "Cloud SQL Admin API: instances.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn failover$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/failover
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:failoverContext {:settingsVersion string, :kind string}}
  
  Failover the instance to its failover replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/failover"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/get
  
  Required parameters: instance, project
  
  Optional parameters: resourceName
  Retrieves a resource containing information about a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/insert
  
  Required parameters: project
  
  Optional parameters: parent
  
  Body: 
  
  {:onPremisesConfiguration {:clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string,
                             :clientKey string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kind string, :kmsKeyName string},
   :databaseVersion string,
   :maxDiskSize string,
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :settings {:availabilityType string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :ipConfiguration IpConfiguration,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :backupConfiguration BackupConfiguration,
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :etag string,
   :ipAddresses [{:ipAddress string, :timeToRetire string, :type string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:name string, :available boolean},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canDefer boolean,
                          :startTime string,
                          :canReschedule boolean},
   :replicaConfiguration {:mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :kind string},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :suspensionReason [string]}
  
  Creates a new Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances"
     #{:project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn demoteMaster$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/demoteMaster
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:demoteMasterContext {:replicaConfiguration DemoteMasterConfiguration,
                         :kind string,
                         :masterInstanceName string,
                         :verifyGtidConsistency boolean}}
  
  Demotes the stand-alone instance to be a Cloud SQL read replica for an
  external database server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/demoteMaster"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn restart$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/restart
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Restarts a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/restart"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/patch
  
  Required parameters: project, instance
  
  Optional parameters: resourceName
  
  Body: 
  
  {:onPremisesConfiguration {:clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string,
                             :clientKey string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kind string, :kmsKeyName string},
   :databaseVersion string,
   :maxDiskSize string,
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :settings {:availabilityType string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :ipConfiguration IpConfiguration,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :backupConfiguration BackupConfiguration,
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :etag string,
   :ipAddresses [{:ipAddress string, :timeToRetire string, :type string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:name string, :available boolean},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canDefer boolean,
                          :startTime string,
                          :canReschedule boolean},
   :replicaConfiguration {:mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :kind string},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :suspensionReason [string]}
  
  Updates settings of a Cloud SQL instance.
  This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn addServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/addServerCa
  
  Required parameters: project, instance
  
  Optional parameters: parent
  Add a new trusted Certificate Authority (CA) version for the specified
  instance. Required to prepare for a certificate rotation. If a CA version
  was previously added but never used in a certificate rotation, this
  operation replaces that version. There cannot be more than one CA version
  waiting to be rotated in."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/addServerCa"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn stopReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/stopReplica
  
  Required parameters: project, instance
  
  Optional parameters: parent
  Stops the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/stopReplica"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/update
  
  Required parameters: instance, project
  
  Optional parameters: resourceName
  
  Body: 
  
  {:onPremisesConfiguration {:clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string,
                             :clientKey string,
                             :dumpFilePath string,
                             :hostPort string},
   :diskEncryptionConfiguration {:kind string, :kmsKeyName string},
   :databaseVersion string,
   :maxDiskSize string,
   :instanceType string,
   :rootPassword string,
   :currentDiskSize string,
   :gceZone string,
   :name string,
   :masterInstanceName string,
   :settings {:availabilityType string,
              :tier string,
              :databaseFlags [DatabaseFlags],
              :databaseReplicationEnabled boolean,
              :settingsVersion string,
              :storageAutoResizeLimit string,
              :crashSafeReplicationEnabled boolean,
              :activationPolicy string,
              :storageAutoResize boolean,
              :pricingPlan string,
              :locationPreference LocationPreference,
              :ipConfiguration IpConfiguration,
              :kind string,
              :maintenanceWindow MaintenanceWindow,
              :backupConfiguration BackupConfiguration,
              :dataDiskSizeGb string,
              :replicationType string,
              :userLabels {},
              :dataDiskType string,
              :authorizedGaeApplications [string]},
   :selfLink string,
   :etag string,
   :ipAddresses [{:ipAddress string, :timeToRetire string, :type string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:name string, :available boolean},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canDefer boolean,
                          :startTime string,
                          :canReschedule boolean},
   :replicaConfiguration {:mysqlReplicaConfiguration MySqlReplicaConfiguration,
                          :failoverTarget boolean,
                          :kind string},
   :serverCaCert {:instance string,
                  :expirationTime string,
                  :cert string,
                  :createTime string,
                  :selfLink string,
                  :sha1Fingerprint string,
                  :kind string,
                  :commonName string,
                  :certSerialNumber string},
   :connectionName string,
   :suspensionReason [string]}
  
  Updates settings of a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/delete
  
  Required parameters: project, instance
  
  Optional parameters: resourceName
  Deletes a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn export$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/export
  
  Required parameters: project, instance
  
  Optional parameters: parent
  
  Body: 
  
  {:exportContext {:databases [string],
                   :sqlExportOptions {:mysqlExportOptions {:masterData integer},
                                      :tables [string],
                                      :schemaOnly boolean},
                   :fileType string,
                   :uri string,
                   :csvExportOptions {:selectQuery string},
                   :kind string}}
  
  Exports data from a Cloud SQL instance to a Cloud Storage bucket as a SQL
  dump or CSV file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/export"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listServerCas$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/listServerCas
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Lists all of the trusted Certificate Authorities (CAs) for the specified
  instance. There can be up to three CAs listed: the CA that was used to sign
  the certificate that is currently in use, a CA that has been added but not
  yet used to sign a certificate, and a CA used to sign a certificate that
  has previously rotated out."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/listServerCas"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn promoteReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/promoteReplica
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Promotes the read replica instance to be a stand-alone Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/promoteReplica"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn resetSslConfig$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/resetSslConfig
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Deletes all client certificates and generates a new server SSL certificate
  for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/resetSslConfig"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/list
  
  Required parameters: project
  
  Optional parameters: parent, filter, pageToken, maxResults
  Lists instances under a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clone$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/clone
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:cloneContext {:kind string,
                  :pointInTime string,
                  :destinationInstanceName string,
                  :pitrTimestampMs string,
                  :binLogCoordinates BinLogCoordinates}}
  
  Creates a Cloud SQL instance as a clone of the source instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/clone"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn restoreBackup$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/restoreBackup
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:restoreBackupContext {:instanceId string,
                          :kind string,
                          :project string,
                          :backupRunId string}}
  
  Restores a backup of a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/restoreBackup"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn startReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/startReplica
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Starts the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/startReplica"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn rotateServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/rotateServerCa
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:rotateServerCaContext {:kind string, :nextVersion string}}
  
  Rotates the server certificate to one signed by the Certificate Authority
  (CA) version previously added with the addServerCA method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/rotateServerCa"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn truncateLog$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/truncateLog
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:truncateLogContext {:kind string, :logType string}}
  
  Truncate MySQL general and slow query log tables"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/truncateLog"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn import$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/import
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:importContext {:database string,
                   :importUser string,
                   :bakImportOptions {:encryptionOptions {:certPath string,
                                                          :pvkPath string,
                                                          :pvkPassword string}},
                   :fileType string,
                   :uri string,
                   :kind string,
                   :csvImportOptions {:table string, :columns [string]}}}
  
  Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
  Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/import"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
