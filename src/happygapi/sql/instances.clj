(ns happygapi.sql.instances
  "Cloud SQL Admin API: instances.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn failover$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/failover
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:failoverContext {:settingsVersion string, :kind string}}
  
  Failover the instance to its failover replica instance. Using this
  operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/failover"
     #{:instance :project}
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

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/get
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Retrieves a resource containing information about a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/insert
  
  Required parameters: project
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:clientKey string,
                             :hostPort string,
                             :dumpFilePath string,
                             :clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
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
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:available boolean, :name string},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canReschedule boolean,
                          :canDefer boolean,
                          :startTime string},
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances"
     #{:project}
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

(defn demoteMaster$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/demoteMaster
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:demoteMasterContext {:replicaConfiguration DemoteMasterConfiguration,
                         :kind string,
                         :masterInstanceName string,
                         :verifyGtidConsistency boolean}}
  
  Demotes the stand-alone instance to be a Cloud SQL read replica for an
  external database server."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/demoteMaster"
     #{:instance :project}
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

(defn restart$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/restart
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Restarts a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/restart"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/patch
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:clientKey string,
                             :hostPort string,
                             :dumpFilePath string,
                             :clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
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
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:available boolean, :name string},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canReschedule boolean,
                          :canDefer boolean,
                          :startTime string},
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
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

(defn addServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/addServerCa
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Add a new trusted Certificate Authority (CA) version for the specified
  instance. Required to prepare for a certificate rotation. If a CA version
  was previously added but never used in a certificate rotation, this
  operation replaces that version. There cannot be more than one CA version
  waiting to be rotated in."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/addServerCa"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn stopReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/stopReplica
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Stops the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/stopReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/update
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:onPremisesConfiguration {:clientKey string,
                             :hostPort string,
                             :dumpFilePath string,
                             :clientCertificate string,
                             :username string,
                             :caCertificate string,
                             :kind string,
                             :password string},
   :diskEncryptionConfiguration {:kmsKeyName string, :kind string},
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
   :ipAddresses [{:type string, :ipAddress string, :timeToRetire string}],
   :state string,
   :ipv6Address string,
   :region string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :replicaNames [string],
   :failoverReplica {:available boolean, :name string},
   :project string,
   :kind string,
   :backendType string,
   :serviceAccountEmailAddress string,
   :scheduledMaintenance {:canReschedule boolean,
                          :canDefer boolean,
                          :startTime string},
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
  
  Updates settings of a Cloud SQL instance. Using this operation might cause
  your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
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

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/delete
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Deletes a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn export$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/export
  
  Required parameters: instance, project
  
  Optional parameters: none
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/export"
     #{:instance :project}
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

(defn listServerCas$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/listServerCas
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Lists all of the trusted Certificate Authorities (CAs) for the specified
  instance. There can be up to three CAs listed: the CA that was used to sign
  the certificate that is currently in use, a CA that has been added but not
  yet used to sign a certificate, and a CA used to sign a certificate that
  has previously rotated out."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/listServerCas"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn promoteReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/promoteReplica
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Promotes the read replica instance to be a stand-alone Cloud SQL instance.
  Using this operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/promoteReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resetSslConfig$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/resetSslConfig
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Deletes all client certificates and generates a new server SSL certificate
  for the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/resetSslConfig"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/list
  
  Required parameters: project
  
  Optional parameters: pageToken, maxResults, filter
  
  Lists instances under a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clone$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/clone
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:cloneContext {:kind string,
                  :pointInTime string,
                  :destinationInstanceName string,
                  :pitrTimestampMs string,
                  :binLogCoordinates BinLogCoordinates}}
  
  Creates a Cloud SQL instance as a clone of the source instance. Using this
  operation might cause your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/clone"
     #{:instance :project}
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

(defn restoreBackup$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/restoreBackup
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:restoreBackupContext {:kind string,
                          :project string,
                          :backupRunId string,
                          :instanceId string}}
  
  Restores a backup of a Cloud SQL instance. Using this operation might cause
  your instance to restart."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/restoreBackup"
     #{:instance :project}
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

(defn startReplica$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/startReplica
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Starts the replication in the read replica instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/startReplica"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rotateServerCa$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/rotateServerCa
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:rotateServerCaContext {:nextVersion string, :kind string}}
  
  Rotates the server certificate to one signed by the Certificate Authority
  (CA) version previously added with the addServerCA method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/rotateServerCa"
     #{:instance :project}
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

(defn truncateLog$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/truncateLog
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:truncateLogContext {:logType string, :kind string}}
  
  Truncate MySQL general and slow query log tables"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/truncateLog"
     #{:instance :project}
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

(defn import$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/instances/import
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:importContext {:database string,
                   :importUser string,
                   :bakImportOptions {:encryptionOptions {:pvkPassword string,
                                                          :certPath string,
                                                          :pvkPath string}},
                   :fileType string,
                   :uri string,
                   :kind string,
                   :csvImportOptions {:columns [string], :table string}}}
  
  Imports data into a Cloud SQL instance from a SQL dump  or CSV file in
  Cloud Storage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/import"
     #{:instance :project}
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
