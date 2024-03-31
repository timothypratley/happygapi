(ns happygapi.vmmigration.projects
  "VM Migration API: projects.
  Use the Migrate to Virtual Machines API to programmatically migrate workloads. 
  See: https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Sources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/create
  
  Required parameters: parent
  
  Optional parameters: sourceId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :aws {:accessKeyCreds AccessKeyCredentials,
         :awsRegion string,
         :state string,
         :error Status,
         :inventoryTagList [Tag],
         :inventorySecurityGroupNames [string],
         :migrationResourcesUserTags {},
         :publicIp string},
   :name string,
   :createTime string,
   :updateTime string,
   :encryption {:kmsKey string},
   :vmware {:username string,
            :password string,
            :vcenterIp string,
            :thumbprint string,
            :resolvedVcenterHost string},
   :azure {:clientSecretCreds ClientSecretCredentials,
           :subscriptionId string,
           :azureLocation string,
           :state string,
           :error Status,
           :migrationResourcesUserTags {},
           :resourceGroupId string}}
  
  Creates a new Source in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/sources"
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

(defn locations-sources-patch$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :aws {:accessKeyCreds AccessKeyCredentials,
         :awsRegion string,
         :state string,
         :error Status,
         :inventoryTagList [Tag],
         :inventorySecurityGroupNames [string],
         :migrationResourcesUserTags {},
         :publicIp string},
   :name string,
   :createTime string,
   :updateTime string,
   :encryption {:kmsKey string},
   :vmware {:username string,
            :password string,
            :vcenterIp string,
            :thumbprint string,
            :resolvedVcenterHost string},
   :azure {:clientSecretCreds ClientSecretCredentials,
           :subscriptionId string,
           :azureLocation string,
           :state string,
           :error Status,
           :migrationResourcesUserTags {},
           :resourceGroupId string}}
  
  Updates the parameters of a single Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-fetchInventory$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/fetchInventory
  
  Required parameters: source
  
  Optional parameters: forceRefresh, pageSize, pageToken
  
  List remote source's inventory of VMs. The remote source is the onprem vCenter (remote in the sense it's not in Compute Engine). The inventory describes the list of existing VMs in that source. Note that this operation lists the VMs on the remote source, as opposed to listing the MigratingVms resources in the vmmigration service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:source})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+source}:fetchInventory"
     #{:source}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-utilizationReports-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/utilizationReports/list
  
  Required parameters: parent
  
  Optional parameters: view, pageSize, pageToken, filter, orderBy
  
  Lists Utilization Reports of the given Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/utilizationReports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-utilizationReports-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/utilizationReports/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets a single Utilization Report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-utilizationReports-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/utilizationReports/create
  
  Required parameters: parent
  
  Optional parameters: utilizationReportId, requestId
  
  Body: 
  
  {:vms [{:vmwareVmDetails VmwareVmDetails,
          :vmId string,
          :utilization VmUtilizationMetrics}],
   :displayName string,
   :name string,
   :createTime string,
   :vmCount integer,
   :state string,
   :error {:code integer, :message string, :details [{}]},
   :stateTime string,
   :timeFrame string,
   :frameEndTime string}
  
  Creates a new UtilizationReport."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/utilizationReports"
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

(defn locations-sources-utilizationReports-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/utilizationReports/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Utilization Report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-datacenterConnectors-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/datacenterConnectors/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DatacenterConnectors in a given Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/datacenterConnectors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-datacenterConnectors-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/datacenterConnectors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single DatacenterConnector."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-datacenterConnectors-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/datacenterConnectors/create
  
  Required parameters: parent
  
  Optional parameters: datacenterConnectorId, requestId
  
  Body: 
  
  {:serviceAccount string,
   :availableVersions {:newDeployableAppliance ApplianceVersion,
                       :inPlaceUpdate ApplianceVersion},
   :registrationId string,
   :name string,
   :createTime string,
   :applianceInfrastructureVersion string,
   :state string,
   :updateTime string,
   :applianceSoftwareVersion string,
   :error {:code integer, :message string, :details [{}]},
   :upgradeStatus {:version string,
                   :state string,
                   :error Status,
                   :startTime string,
                   :previousVersion string},
   :stateTime string,
   :version string,
   :bucket string}
  
  Creates a new DatacenterConnector in a given Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/datacenterConnectors"
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

(defn locations-sources-datacenterConnectors-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/datacenterConnectors/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single DatacenterConnector."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-datacenterConnectors-upgradeAppliance$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/datacenterConnectors/upgradeAppliance
  
  Required parameters: datacenterConnector
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Upgrades the appliance relate to this DatacenterConnector to the in-place updateable version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datacenterConnector})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+datacenterConnector}:upgradeAppliance"
     #{:datacenterConnector}
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

(defn locations-sources-migratingVms-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single MigratingVm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-patch$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :awsSourceVmDetails {:firmware string,
                        :committedStorageBytes string,
                        :disks [AwsDiskDetails],
                        :vmCapabilitiesInfo VmCapabilities},
   :labels {},
   :lastSync {:lastSyncTime string},
   :group string,
   :displayName string,
   :name string,
   :createTime string,
   :currentSyncInfo {:startTime string,
                     :name string,
                     :endTime string,
                     :steps [CycleStep],
                     :state string,
                     :warnings [MigrationWarning],
                     :progressPercent integer,
                     :error Status,
                     :totalPauseDuration string,
                     :cycleNumber integer},
   :computeEngineTargetDefaults {:serviceAccount string,
                                 :licenseType string,
                                 :computeScheduling ComputeScheduling,
                                 :labels {},
                                 :additionalLicenses [string],
                                 :appliedLicense AppliedLicense,
                                 :bootOption string,
                                 :zone string,
                                 :vmName string,
                                 :hostname string,
                                 :machineType string,
                                 :targetProject string,
                                 :encryption Encryption,
                                 :diskType string,
                                 :machineTypeSeries string,
                                 :networkInterfaces [NetworkInterface],
                                 :networkTags [string],
                                 :secureBoot boolean,
                                 :metadata {}},
   :state string,
   :sourceVmId string,
   :policy {:idleDuration string, :skipOsAdaptation boolean},
   :updateTime string,
   :recentCloneJobs [{:name string,
                      :endTime string,
                      :steps [CloneStep],
                      :createTime string,
                      :computeEngineTargetDetails ComputeEngineTargetDetails,
                      :state string,
                      :computeEngineDisksTargetDetails ComputeEngineDisksTargetDetails,
                      :error Status,
                      :stateTime string}],
   :vmwareSourceVmDetails {:firmware string,
                           :committedStorageBytes string,
                           :disks [VmwareDiskDetails],
                           :vmCapabilitiesInfo VmCapabilities},
   :cutoverForecast {:estimatedCutoverJobDuration string},
   :lastReplicationCycle {:startTime string,
                          :name string,
                          :endTime string,
                          :steps [CycleStep],
                          :state string,
                          :warnings [MigrationWarning],
                          :progressPercent integer,
                          :error Status,
                          :totalPauseDuration string,
                          :cycleNumber integer},
   :computeEngineDisksTargetDefaults {:zone string,
                                      :disksTargetDefaults DisksMigrationDisksTargetDefaults,
                                      :vmTargetDefaults DisksMigrationVmTargetDefaults,
                                      :targetProject string,
                                      :disks [PersistentDiskDefaults]},
   :azureSourceVmDetails {:firmware string,
                          :committedStorageBytes string,
                          :disks [AzureDiskDetails],
                          :vmCapabilitiesInfo VmCapabilities},
   :error {:code integer, :message string, :details [{}]},
   :stateTime string,
   :recentCutoverJobs [{:name string,
                        :endTime string,
                        :steps [CutoverStep],
                        :createTime string,
                        :computeEngineTargetDetails ComputeEngineTargetDetails,
                        :state string,
                        :computeEngineDisksTargetDetails ComputeEngineDisksTargetDetails,
                        :progressPercent integer,
                        :error Status,
                        :stateTime string,
                        :stateMessage string}]}
  
  Updates the parameters of a single MigratingVm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/create
  
  Required parameters: parent
  
  Optional parameters: migratingVmId, requestId
  
  Body: 
  
  {:description string,
   :awsSourceVmDetails {:firmware string,
                        :committedStorageBytes string,
                        :disks [AwsDiskDetails],
                        :vmCapabilitiesInfo VmCapabilities},
   :labels {},
   :lastSync {:lastSyncTime string},
   :group string,
   :displayName string,
   :name string,
   :createTime string,
   :currentSyncInfo {:startTime string,
                     :name string,
                     :endTime string,
                     :steps [CycleStep],
                     :state string,
                     :warnings [MigrationWarning],
                     :progressPercent integer,
                     :error Status,
                     :totalPauseDuration string,
                     :cycleNumber integer},
   :computeEngineTargetDefaults {:serviceAccount string,
                                 :licenseType string,
                                 :computeScheduling ComputeScheduling,
                                 :labels {},
                                 :additionalLicenses [string],
                                 :appliedLicense AppliedLicense,
                                 :bootOption string,
                                 :zone string,
                                 :vmName string,
                                 :hostname string,
                                 :machineType string,
                                 :targetProject string,
                                 :encryption Encryption,
                                 :diskType string,
                                 :machineTypeSeries string,
                                 :networkInterfaces [NetworkInterface],
                                 :networkTags [string],
                                 :secureBoot boolean,
                                 :metadata {}},
   :state string,
   :sourceVmId string,
   :policy {:idleDuration string, :skipOsAdaptation boolean},
   :updateTime string,
   :recentCloneJobs [{:name string,
                      :endTime string,
                      :steps [CloneStep],
                      :createTime string,
                      :computeEngineTargetDetails ComputeEngineTargetDetails,
                      :state string,
                      :computeEngineDisksTargetDetails ComputeEngineDisksTargetDetails,
                      :error Status,
                      :stateTime string}],
   :vmwareSourceVmDetails {:firmware string,
                           :committedStorageBytes string,
                           :disks [VmwareDiskDetails],
                           :vmCapabilitiesInfo VmCapabilities},
   :cutoverForecast {:estimatedCutoverJobDuration string},
   :lastReplicationCycle {:startTime string,
                          :name string,
                          :endTime string,
                          :steps [CycleStep],
                          :state string,
                          :warnings [MigrationWarning],
                          :progressPercent integer,
                          :error Status,
                          :totalPauseDuration string,
                          :cycleNumber integer},
   :computeEngineDisksTargetDefaults {:zone string,
                                      :disksTargetDefaults DisksMigrationDisksTargetDefaults,
                                      :vmTargetDefaults DisksMigrationVmTargetDefaults,
                                      :targetProject string,
                                      :disks [PersistentDiskDefaults]},
   :azureSourceVmDetails {:firmware string,
                          :committedStorageBytes string,
                          :disks [AzureDiskDetails],
                          :vmCapabilitiesInfo VmCapabilities},
   :error {:code integer, :message string, :details [{}]},
   :stateTime string,
   :recentCutoverJobs [{:name string,
                        :endTime string,
                        :steps [CutoverStep],
                        :createTime string,
                        :computeEngineTargetDetails ComputeEngineTargetDetails,
                        :state string,
                        :computeEngineDisksTargetDetails ComputeEngineDisksTargetDetails,
                        :progressPercent integer,
                        :error Status,
                        :stateTime string,
                        :stateMessage string}]}
  
  Creates a new MigratingVm in a given Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/migratingVms"
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

(defn locations-sources-migratingVms-startMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/startMigration
  
  Required parameters: migratingVm
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts migration for a VM. Starts the process of uploading data and creating snapshots, in replication cycles scheduled by the policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migratingVm})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+migratingVm}:startMigration"
     #{:migratingVm}
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

(defn locations-sources-migratingVms-finalizeMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/finalizeMigration
  
  Required parameters: migratingVm
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Marks a migration as completed, deleting migration resources that are no longer being used. Only applicable after cutover is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migratingVm})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+migratingVm}:finalizeMigration"
     #{:migratingVm}
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

(defn locations-sources-migratingVms-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single MigratingVm."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, view
  
  Lists MigratingVms in a given Source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/migratingVms"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-migratingVms-pauseMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/pauseMigration
  
  Required parameters: migratingVm
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses a migration for a VM. If cycle tasks are running they will be cancelled, preserving source task data. Further replication cycles will not be triggered while the VM is paused."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migratingVm})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+migratingVm}:pauseMigration"
     #{:migratingVm}
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

(defn locations-sources-migratingVms-resumeMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/resumeMigration
  
  Required parameters: migratingVm
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes a migration for a VM. When called on a paused migration, will start the process of uploading data and creating snapshots; when called on a completed cut-over migration, will update the migration to active state and start the process of uploading data and creating snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migratingVm})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+migratingVm}:resumeMigration"
     #{:migratingVm}
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

(defn locations-sources-migratingVms-cloneJobs-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cloneJobs/create
  
  Required parameters: parent
  
  Optional parameters: cloneJobId, requestId
  
  Body: 
  
  {:name string,
   :endTime string,
   :steps [{:adaptingOs AdaptingOSStep,
            :preparingVmDisks PreparingVMDisksStep,
            :instantiatingMigratedVm InstantiatingMigratedVMStep,
            :startTime string,
            :endTime string}],
   :createTime string,
   :computeEngineTargetDetails {:serviceAccount string,
                                :licenseType string,
                                :computeScheduling ComputeScheduling,
                                :labels {},
                                :additionalLicenses [string],
                                :appliedLicense AppliedLicense,
                                :bootOption string,
                                :zone string,
                                :vmName string,
                                :hostname string,
                                :machineType string,
                                :encryption Encryption,
                                :project string,
                                :diskType string,
                                :machineTypeSeries string,
                                :networkInterfaces [NetworkInterface],
                                :networkTags [string],
                                :secureBoot boolean,
                                :metadata {}},
   :state string,
   :computeEngineDisksTargetDetails {:disksTargetDetails DisksMigrationDisksTargetDetails,
                                     :vmTargetDetails DisksMigrationVmTargetDetails,
                                     :disks [PersistentDisk]},
   :error {:code integer, :message string, :details [{}]},
   :stateTime string}
  
  Initiates a Clone of a specific migrating VM."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/cloneJobs"
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

(defn locations-sources-migratingVms-cloneJobs-cancel$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cloneJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Initiates the cancellation of a running clone job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-cloneJobs-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cloneJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the CloneJobs of a migrating VM. Only 25 most recent CloneJobs are listed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/cloneJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-migratingVms-cloneJobs-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cloneJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CloneJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-cutoverJobs-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cutoverJobs/create
  
  Required parameters: parent
  
  Optional parameters: cutoverJobId, requestId
  
  Body: 
  
  {:name string,
   :endTime string,
   :steps [{:previousReplicationCycle ReplicationCycle,
            :shuttingDownSourceVm ShuttingDownSourceVMStep,
            :finalSync ReplicationCycle,
            :preparingVmDisks PreparingVMDisksStep,
            :instantiatingMigratedVm InstantiatingMigratedVMStep,
            :startTime string,
            :endTime string}],
   :createTime string,
   :computeEngineTargetDetails {:serviceAccount string,
                                :licenseType string,
                                :computeScheduling ComputeScheduling,
                                :labels {},
                                :additionalLicenses [string],
                                :appliedLicense AppliedLicense,
                                :bootOption string,
                                :zone string,
                                :vmName string,
                                :hostname string,
                                :machineType string,
                                :encryption Encryption,
                                :project string,
                                :diskType string,
                                :machineTypeSeries string,
                                :networkInterfaces [NetworkInterface],
                                :networkTags [string],
                                :secureBoot boolean,
                                :metadata {}},
   :state string,
   :computeEngineDisksTargetDetails {:disksTargetDetails DisksMigrationDisksTargetDetails,
                                     :vmTargetDetails DisksMigrationVmTargetDetails,
                                     :disks [PersistentDisk]},
   :progressPercent integer,
   :error {:code integer, :message string, :details [{}]},
   :stateTime string,
   :stateMessage string}
  
  Initiates a Cutover of a specific migrating VM. The returned LRO is completed when the cutover job resource is created and the job is initiated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/cutoverJobs"
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

(defn locations-sources-migratingVms-cutoverJobs-cancel$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cutoverJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Initiates the cancellation of a running cutover job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-cutoverJobs-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cutoverJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the CutoverJobs of a migrating VM. Only 25 most recent CutoverJobs are listed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/cutoverJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-migratingVms-cutoverJobs-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/cutoverJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CutoverJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-sources-migratingVms-replicationCycles-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/replicationCycles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ReplicationCycles in a given MigratingVM."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/replicationCycles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-migratingVms-replicationCycles-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/sources/migratingVms/replicationCycles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ReplicationCycle."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-groups-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Groups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/groups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-groups-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-groups-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/create
  
  Required parameters: parent
  
  Optional parameters: groupId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :displayName string,
   :migrationTargetType string}
  
  Creates a new Group in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/groups"
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

(defn locations-groups-patch$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :displayName string,
   :migrationTargetType string}
  
  Updates the parameters of a single Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-groups-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-groups-addGroupMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/addGroupMigration
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:migratingVm string}
  
  Adds a MigratingVm to a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+group}:addGroupMigration"
     #{:group}
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

(defn locations-groups-removeGroupMigration$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/groups/removeGroupMigration
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:migratingVm string}
  
  Removes a MigratingVm from a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+group}:removeGroupMigration"
     #{:group}
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

(defn locations-targetProjects-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/targetProjects/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists TargetProjects in a given project. NOTE: TargetProject is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/targetProjects"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-targetProjects-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/targetProjects/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single TargetProject. NOTE: TargetProject is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-targetProjects-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/targetProjects/create
  
  Required parameters: parent
  
  Optional parameters: targetProjectId, requestId
  
  Body: 
  
  {:name string,
   :project string,
   :description string,
   :createTime string,
   :updateTime string}
  
  Creates a new TargetProject in a given project. NOTE: TargetProject is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/targetProjects"
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

(defn locations-targetProjects-patch$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/targetProjects/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :project string,
   :description string,
   :createTime string,
   :updateTime string}
  
  Updates the parameters of a single TargetProject. NOTE: TargetProject is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-targetProjects-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/targetProjects/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single TargetProject. NOTE: TargetProject is a global resource; hence the only supported value for location is `global`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-imageImports-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ImageImports in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/imageImports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-imageImports-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ImageImport."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-imageImports-create$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/create
  
  Required parameters: parent
  
  Optional parameters: imageImportId, requestId
  
  Body: 
  
  {:cloudStorageUri string,
   :diskImageTargetDefaults {:osAdaptationParameters ImageImportOsAdaptationParameters,
                             :description string,
                             :labels {},
                             :additionalLicenses [string],
                             :dataDiskImageImport DataDiskImageImport,
                             :familyName string,
                             :targetProject string,
                             :encryption Encryption,
                             :imageName string,
                             :singleRegionStorage boolean},
   :name string,
   :createTime string,
   :recentImageImportJobs [{:cloudStorageUri string,
                            :errors [Status],
                            :name string,
                            :endTime string,
                            :steps [ImageImportStep],
                            :createTime string,
                            :state string,
                            :warnings [MigrationWarning],
                            :createdResources [string],
                            :diskImageTargetDetails DiskImageTargetDetails}],
   :encryption {:kmsKey string}}
  
  Creates a new ImageImport in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/imageImports"
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

(defn locations-imageImports-delete$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single ImageImport."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-imageImports-imageImportJobs-list$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/imageImportJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ImageImportJobs in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
     "v1/{+parent}/imageImportJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-imageImports-imageImportJobs-get$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/imageImportJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ImageImportJob."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://vmmigration.googleapis.com/"
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

(defn locations-imageImports-imageImportJobs-cancel$
  "https://cloud.google.com/migrate/virtual-machinesapi/reference/rest/v1/projects/locations/imageImports/imageImportJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Initiates the cancellation of a running clone job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vmmigration.googleapis.com/"
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
