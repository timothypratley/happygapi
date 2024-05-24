(ns happygapi.gkeonprem.projects
  "Anthos On-Prem API: projects.
  
  See: https://cloud.google.com/anthos/clusters/docs/on-prem/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single bare metal Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing, validateOnly
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :osEnvironmentConfig {:packageRepoExcluded boolean},
   :nodeConfig {:maxPodsPerNode string, :containerRuntime string},
   :bareMetalVersion string,
   :loadBalancer {:vipConfig BareMetalVipConfig,
                  :portConfig BareMetalPortConfig,
                  :metalLbConfig BareMetalMetalLbConfig,
                  :manualLbConfig BareMetalManualLbConfig,
                  :bgpLbConfig BareMetalBgpLbConfig},
   :uid string,
   :name string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :adminClusterMembership string,
   :state string,
   :clusterOperations {:enableApplicationLogs boolean},
   :securityConfig {:authorization Authorization},
   :networkConfig {:islandModeCidr BareMetalIslandModeCidrConfig,
                   :advancedNetworking boolean,
                   :multipleNetworkInterfacesConfig BareMetalMultipleNetworkInterfacesConfig,
                   :srIovConfig BareMetalSrIovConfig},
   :upgradePolicy {:policy string},
   :updateTime string,
   :reconciling boolean,
   :localName string,
   :proxy {:uri string, :noProxy [string]},
   :fleet {:membership string},
   :maintenanceStatus {:machineDrainStatus BareMetalMachineDrainStatus},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :controlPlane {:controlPlaneNodePoolConfig BareMetalControlPlaneNodePoolConfig,
                  :apiServerArgs [BareMetalApiServerArgument]},
   :storage {:lvpShareConfig BareMetalLvpShareConfig,
             :lvpNodeMountsConfig BareMetalLvpConfig},
   :annotations {},
   :nodeAccessConfig {:loginUser string},
   :adminClusterName string,
   :endpoint string,
   :maintenanceConfig {:maintenanceAddressCidrBlocks [string]}}
  
  Updates the parameters of a single bare metal Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-create$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/create
  
  Required parameters: parent
  
  Optional parameters: bareMetalClusterId, validateOnly
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :osEnvironmentConfig {:packageRepoExcluded boolean},
   :nodeConfig {:maxPodsPerNode string, :containerRuntime string},
   :bareMetalVersion string,
   :loadBalancer {:vipConfig BareMetalVipConfig,
                  :portConfig BareMetalPortConfig,
                  :metalLbConfig BareMetalMetalLbConfig,
                  :manualLbConfig BareMetalManualLbConfig,
                  :bgpLbConfig BareMetalBgpLbConfig},
   :uid string,
   :name string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :adminClusterMembership string,
   :state string,
   :clusterOperations {:enableApplicationLogs boolean},
   :securityConfig {:authorization Authorization},
   :networkConfig {:islandModeCidr BareMetalIslandModeCidrConfig,
                   :advancedNetworking boolean,
                   :multipleNetworkInterfacesConfig BareMetalMultipleNetworkInterfacesConfig,
                   :srIovConfig BareMetalSrIovConfig},
   :upgradePolicy {:policy string},
   :updateTime string,
   :reconciling boolean,
   :localName string,
   :proxy {:uri string, :noProxy [string]},
   :fleet {:membership string},
   :maintenanceStatus {:machineDrainStatus BareMetalMachineDrainStatus},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :controlPlane {:controlPlaneNodePoolConfig BareMetalControlPlaneNodePoolConfig,
                  :apiServerArgs [BareMetalApiServerArgument]},
   :storage {:lvpShareConfig BareMetalLvpShareConfig,
             :lvpNodeMountsConfig BareMetalLvpConfig},
   :annotations {},
   :nodeAccessConfig {:loginUser string},
   :adminClusterName string,
   :endpoint string,
   :maintenanceConfig {:maintenanceAddressCidrBlocks [string]}}
  
  Creates a new bare metal cluster in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalClusters"
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

(defn locations-bareMetalClusters-delete$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/delete
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, force, ignoreErrors
  
  Deletes a single bare metal Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, force
  
  Unenrolls an existing bare metal user cluster and its node pools from the Anthos On-Prem API within a given project and location. Unenrollment removes the Cloud reference to the cluster without modifying the underlying OnPrem Resources. Clusters and node pools will continue to run; however, they will no longer be accessible through the Anthos On-Prem API or its clients."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalClusters-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, view
  
  Lists bare metal clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalClusters-queryVersionConfig$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/queryVersionConfig
  
  Required parameters: parent
  
  Optional parameters: createConfig.adminClusterMembership, createConfig.adminClusterName, upgradeConfig.clusterName
  
  Queries the bare metal user cluster version config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalClusters:queryVersionConfig"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalClusters-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bareMetalClusterId string,
   :localName string,
   :adminClusterMembership string}
  
  Enrolls an existing bare metal user cluster and its node pools to the Anthos On-Prem API within a given project and location. Through enrollment, an existing cluster will become Anthos On-Prem API managed. The corresponding GCP resources will be created and all future modifications to the cluster and/or its node pools will be expected to be performed through the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalClusters:enroll"
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

(defn locations-bareMetalClusters-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single bare metal node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing, validateOnly
  
  Body: 
  
  {:nodePoolConfig {:nodeConfigs [BareMetalNodeConfig],
                    :operatingSystem string,
                    :taints [NodeTaint],
                    :labels {},
                    :kubeletConfig BareMetalKubeletConfig},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :upgradePolicy {:parallelUpgradeConfig BareMetalParallelUpgradeConfig},
   :updateTime string,
   :reconciling boolean,
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :annotations {}}
  
  Updates the parameters of a single bare metal node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-create$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/create
  
  Required parameters: parent
  
  Optional parameters: bareMetalNodePoolId, validateOnly
  
  Body: 
  
  {:nodePoolConfig {:nodeConfigs [BareMetalNodeConfig],
                    :operatingSystem string,
                    :taints [NodeTaint],
                    :labels {},
                    :kubeletConfig BareMetalKubeletConfig},
   :deleteTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :upgradePolicy {:parallelUpgradeConfig BareMetalParallelUpgradeConfig},
   :updateTime string,
   :reconciling boolean,
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :annotations {}}
  
  Creates a new bare metal node pool in a given project, location and Bare Metal cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalNodePools"
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

(defn locations-bareMetalClusters-bareMetalNodePools-delete$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/delete
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, ignoreErrors
  
  Deletes a single bare metal node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly
  
  Unenrolls a bare metal node pool from Anthos On-Prem API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalClusters-bareMetalNodePools-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists bare metal node pools in a given project, location and bare metal cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalNodePools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalClusters-bareMetalNodePools-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bareMetalNodePoolId string, :validateOnly boolean}
  
  Enrolls an existing bare metal node pool to the Anthos On-Prem API within a given project and location. Through enrollment, an existing node pool will become Anthos On-Prem API managed. The corresponding GCP resources will be created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalNodePools:enroll"
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

(defn locations-bareMetalClusters-bareMetalNodePools-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalClusters-bareMetalNodePools-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalClusters/bareMetalNodePools/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single VMware Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :controlPlaneNode {:cpus string,
                      :memory string,
                      :replicas string,
                      :autoResizeConfig VmwareAutoResizeConfig,
                      :vsphereConfig VmwareControlPlaneVsphereConfig},
   :deleteTime string,
   :loadBalancer {:vipConfig VmwareVipConfig,
                  :f5Config VmwareF5BigIpConfig,
                  :manualLbConfig VmwareManualLbConfig,
                  :seesawConfig VmwareSeesawConfig,
                  :metalLbConfig VmwareMetalLbConfig},
   :authorization {:adminUsers [ClusterUser]},
   :uid string,
   :name string,
   :antiAffinityGroups {:aagConfigDisabled boolean},
   :onPremVersion string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :adminClusterMembership string,
   :state string,
   :networkConfig {:serviceAddressCidrBlocks [string],
                   :podAddressCidrBlocks [string],
                   :staticIpConfig VmwareStaticIpConfig,
                   :dhcpIpConfig VmwareDhcpIpConfig,
                   :vcenterNetwork string,
                   :hostConfig VmwareHostConfig,
                   :controlPlaneV2Config VmwareControlPlaneV2Config},
   :disableBundledIngress boolean,
   :upgradePolicy {:controlPlaneOnly boolean},
   :updateTime string,
   :dataplaneV2 {:dataplaneV2Enabled boolean,
                 :windowsDataplaneV2Enabled boolean,
                 :advancedNetworking boolean,
                 :forwardMode string},
   :reconciling boolean,
   :localName string,
   :fleet {:membership string},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :storage {:vsphereCsiDisabled boolean},
   :annotations {},
   :adminClusterName string,
   :vmTrackingEnabled boolean,
   :endpoint string,
   :autoRepairConfig {:enabled boolean},
   :enableControlPlaneV2 boolean,
   :vcenter {:resourcePool string,
             :datastore string,
             :datacenter string,
             :cluster string,
             :folder string,
             :caCertData string,
             :address string,
             :storagePolicyName string}}
  
  Updates the parameters of a single VMware cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-create$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/create
  
  Required parameters: parent
  
  Optional parameters: vmwareClusterId, validateOnly
  
  Body: 
  
  {:description string,
   :controlPlaneNode {:cpus string,
                      :memory string,
                      :replicas string,
                      :autoResizeConfig VmwareAutoResizeConfig,
                      :vsphereConfig VmwareControlPlaneVsphereConfig},
   :deleteTime string,
   :loadBalancer {:vipConfig VmwareVipConfig,
                  :f5Config VmwareF5BigIpConfig,
                  :manualLbConfig VmwareManualLbConfig,
                  :seesawConfig VmwareSeesawConfig,
                  :metalLbConfig VmwareMetalLbConfig},
   :authorization {:adminUsers [ClusterUser]},
   :uid string,
   :name string,
   :antiAffinityGroups {:aagConfigDisabled boolean},
   :onPremVersion string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :adminClusterMembership string,
   :state string,
   :networkConfig {:serviceAddressCidrBlocks [string],
                   :podAddressCidrBlocks [string],
                   :staticIpConfig VmwareStaticIpConfig,
                   :dhcpIpConfig VmwareDhcpIpConfig,
                   :vcenterNetwork string,
                   :hostConfig VmwareHostConfig,
                   :controlPlaneV2Config VmwareControlPlaneV2Config},
   :disableBundledIngress boolean,
   :upgradePolicy {:controlPlaneOnly boolean},
   :updateTime string,
   :dataplaneV2 {:dataplaneV2Enabled boolean,
                 :windowsDataplaneV2Enabled boolean,
                 :advancedNetworking boolean,
                 :forwardMode string},
   :reconciling boolean,
   :localName string,
   :fleet {:membership string},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :storage {:vsphereCsiDisabled boolean},
   :annotations {},
   :adminClusterName string,
   :vmTrackingEnabled boolean,
   :endpoint string,
   :autoRepairConfig {:enabled boolean},
   :enableControlPlaneV2 boolean,
   :vcenter {:resourcePool string,
             :datastore string,
             :datacenter string,
             :cluster string,
             :folder string,
             :caCertData string,
             :address string,
             :storagePolicyName string}}
  
  Creates a new VMware user cluster in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareClusters"
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

(defn locations-vmwareClusters-delete$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/delete
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, force, ignoreErrors
  
  Deletes a single VMware Cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, force
  
  Unenrolls an existing VMware user cluster and its node pools from the Anthos On-Prem API within a given project and location. Unenrollment removes the Cloud reference to the cluster without modifying the underlying OnPrem Resources. Clusters and node pools will continue to run; however, they will no longer be accessible through the Anthos On-Prem API or UI."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareClusters-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, view
  
  Lists VMware Clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareClusters-queryVersionConfig$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/queryVersionConfig
  
  Required parameters: parent
  
  Optional parameters: createConfig.adminClusterMembership, createConfig.adminClusterName, upgradeConfig.clusterName
  
  Queries the VMware user cluster version config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareClusters:queryVersionConfig"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareClusters-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:vmwareClusterId string,
   :localName string,
   :adminClusterMembership string,
   :validateOnly boolean}
  
  Enrolls an existing VMware user cluster and its node pools to the Anthos On-Prem API within a given project and location. Through enrollment, an existing cluster will become Anthos On-Prem API managed. The corresponding GCP resources will be created and all future modifications to the cluster and/or its node pools will be expected to be performed through the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareClusters:enroll"
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

(defn locations-vmwareClusters-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single VMware node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:deleteTime string,
   :config {:labels {},
            :taints [NodeTaint],
            :bootDiskSizeGb string,
            :vsphereConfig VmwareVsphereConfig,
            :imageType string,
            :enableLoadBalancer boolean,
            :replicas string,
            :image string,
            :memoryMb string,
            :cpus string},
   :displayName string,
   :uid string,
   :name string,
   :onPremVersion string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :reconciling boolean,
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :nodePoolAutoscaling {:minReplicas integer, :maxReplicas integer},
   :annotations {}}
  
  Updates the parameters of a single VMware node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-create$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/create
  
  Required parameters: parent
  
  Optional parameters: vmwareNodePoolId, validateOnly
  
  Body: 
  
  {:deleteTime string,
   :config {:labels {},
            :taints [NodeTaint],
            :bootDiskSizeGb string,
            :vsphereConfig VmwareVsphereConfig,
            :imageType string,
            :enableLoadBalancer boolean,
            :replicas string,
            :image string,
            :memoryMb string,
            :cpus string},
   :displayName string,
   :uid string,
   :name string,
   :onPremVersion string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :reconciling boolean,
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :nodePoolAutoscaling {:minReplicas integer, :maxReplicas integer},
   :annotations {}}
  
  Creates a new VMware node pool in a given project, location and VMWare cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareNodePools"
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

(defn locations-vmwareClusters-vmwareNodePools-delete$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/delete
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, ignoreErrors
  
  Deletes a single VMware node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly
  
  Unenrolls a VMware node pool to Anthos On-Prem API"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareClusters-vmwareNodePools-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists VMware node pools in a given project, location and VMWare cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareNodePools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareClusters-vmwareNodePools-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:vmwareNodePoolId string}
  
  Enrolls a VMware node pool to Anthos On-Prem API"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareNodePools:enroll"
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

(defn locations-vmwareClusters-vmwareNodePools-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareClusters-vmwareNodePools-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareClusters/vmwareNodePools/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists VMware admin clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareAdminClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareAdminClusters-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single VMware admin cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:vmwareAdminClusterId string, :membership string}
  
  Enrolls an existing VMware admin cluster to the Anthos On-Prem API within a given project and location. Through enrollment, an existing admin cluster will become Anthos On-Prem API managed. The corresponding GCP resources will be created and all future modifications to the cluster will be expected to be performed through the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/vmwareAdminClusters:enroll"
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

(defn locations-vmwareAdminClusters-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly
  
  Unenrolls an existing VMware admin cluster from the Anthos On-Prem API within a given project and location. Unenrollment removes the Cloud reference to the cluster without modifying the underlying OnPrem Resources. Clusters will continue to run; however, they will no longer be accessible through the Anthos On-Prem API or its clients."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-vmwareAdminClusters-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :controlPlaneNode {:cpus string, :memory string, :replicas string},
   :loadBalancer {:vipConfig VmwareAdminVipConfig,
                  :f5Config VmwareAdminF5BigIpConfig,
                  :manualLbConfig VmwareAdminManualLbConfig,
                  :metalLbConfig VmwareAdminMetalLbConfig,
                  :seesawConfig VmwareAdminSeesawConfig},
   :authorization {:viewerUsers [ClusterUser]},
   :uid string,
   :name string,
   :antiAffinityGroups {:aagConfigDisabled boolean},
   :onPremVersion string,
   :preparedSecrets {:enabled boolean},
   :createTime string,
   :addonNode {:autoResizeConfig VmwareAutoResizeConfig},
   :etag string,
   :imageType string,
   :state string,
   :networkConfig {:serviceAddressCidrBlocks [string],
                   :podAddressCidrBlocks [string],
                   :staticIpConfig VmwareStaticIpConfig,
                   :dhcpIpConfig VmwareDhcpIpConfig,
                   :vcenterNetwork string,
                   :hostConfig VmwareHostConfig,
                   :haControlPlaneConfig VmwareAdminHAControlPlaneConfig},
   :updateTime string,
   :reconciling boolean,
   :localName string,
   :fleet {:membership string},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :bootstrapClusterMembership string,
   :annotations {},
   :endpoint string,
   :platformConfig {:requiredPlatformVersion string,
                    :platformVersion string,
                    :bundles [VmwareBundleConfig],
                    :status ResourceStatus},
   :autoRepairConfig {:enabled boolean},
   :vcenter {:address string,
             :cluster string,
             :folder string,
             :dataDisk string,
             :resourcePool string,
             :caCertData string,
             :datastore string,
             :datacenter string,
             :storagePolicyName string}}
  
  Updates the parameters of a single VMware admin cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-vmwareAdminClusters-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/vmwareAdminClusters/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single bare metal admin cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-setIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-patch$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :osEnvironmentConfig {:packageRepoExcluded boolean},
   :nodeConfig {:maxPodsPerNode string},
   :bareMetalVersion string,
   :loadBalancer {:vipConfig BareMetalAdminVipConfig,
                  :portConfig BareMetalAdminPortConfig,
                  :manualLbConfig BareMetalAdminManualLbConfig},
   :uid string,
   :name string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :state string,
   :clusterOperations {:enableApplicationLogs boolean},
   :securityConfig {:authorization Authorization},
   :networkConfig {:islandModeCidr BareMetalAdminIslandModeCidrConfig},
   :updateTime string,
   :reconciling boolean,
   :localName string,
   :proxy {:uri string, :noProxy [string]},
   :fleet {:membership string},
   :maintenanceStatus {:machineDrainStatus BareMetalAdminMachineDrainStatus},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :controlPlane {:controlPlaneNodePoolConfig BareMetalAdminControlPlaneNodePoolConfig,
                  :apiServerArgs [BareMetalAdminApiServerArgument]},
   :storage {:lvpShareConfig BareMetalLvpShareConfig,
             :lvpNodeMountsConfig BareMetalLvpConfig},
   :annotations {},
   :nodeAccessConfig {:loginUser string},
   :endpoint string,
   :maintenanceConfig {:maintenanceAddressCidrBlocks [string]}}
  
  Updates the parameters of a single bare metal admin cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-testIamPermissions$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/testIamPermissions
  
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
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-create$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/create
  
  Required parameters: parent
  
  Optional parameters: bareMetalAdminClusterId, validateOnly
  
  Body: 
  
  {:description string,
   :deleteTime string,
   :osEnvironmentConfig {:packageRepoExcluded boolean},
   :nodeConfig {:maxPodsPerNode string},
   :bareMetalVersion string,
   :loadBalancer {:vipConfig BareMetalAdminVipConfig,
                  :portConfig BareMetalAdminPortConfig,
                  :manualLbConfig BareMetalAdminManualLbConfig},
   :uid string,
   :name string,
   :binaryAuthorization {:evaluationMode string},
   :createTime string,
   :etag string,
   :state string,
   :clusterOperations {:enableApplicationLogs boolean},
   :securityConfig {:authorization Authorization},
   :networkConfig {:islandModeCidr BareMetalAdminIslandModeCidrConfig},
   :updateTime string,
   :reconciling boolean,
   :localName string,
   :proxy {:uri string, :noProxy [string]},
   :fleet {:membership string},
   :maintenanceStatus {:machineDrainStatus BareMetalAdminMachineDrainStatus},
   :status {:errorMessage string, :conditions [ResourceCondition]},
   :validationCheck {:option string,
                     :status ValidationCheckStatus,
                     :scenario string},
   :controlPlane {:controlPlaneNodePoolConfig BareMetalAdminControlPlaneNodePoolConfig,
                  :apiServerArgs [BareMetalAdminApiServerArgument]},
   :storage {:lvpShareConfig BareMetalLvpShareConfig,
             :lvpNodeMountsConfig BareMetalLvpConfig},
   :annotations {},
   :nodeAccessConfig {:loginUser string},
   :endpoint string,
   :maintenanceConfig {:maintenanceAddressCidrBlocks [string]}}
  
  Creates a new bare metal admin cluster in a given project and location. The API needs to be combined with creating a bootstrap cluster to work. See: https://cloud.google.com/anthos/clusters/docs/bare-metal/latest/installing/creating-clusters/create-admin-cluster-api#prepare_bootstrap_environment"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalAdminClusters"
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

(defn locations-bareMetalAdminClusters-unenroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/unenroll
  
  Required parameters: name
  
  Optional parameters: etag, allowMissing, validateOnly, ignoreErrors
  
  Unenrolls an existing bare metal admin cluster from the Anthos On-Prem API within a given project and location. Unenrollment removes the Cloud reference to the cluster without modifying the underlying OnPrem Resources. Clusters will continue to run; however, they will no longer be accessible through the Anthos On-Prem API or its clients."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+name}:unenroll"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalAdminClusters-getIamPolicy$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists bare metal admin clusters in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalAdminClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalAdminClusters-queryVersionConfig$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/queryVersionConfig
  
  Required parameters: parent
  
  Optional parameters: upgradeConfig.clusterName
  
  Queries the bare metal admin cluster version config."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalAdminClusters:queryVersionConfig"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-bareMetalAdminClusters-enroll$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/enroll
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:bareMetalAdminClusterId string, :membership string}
  
  Enrolls an existing bare metal admin cluster to the Anthos On-Prem API within a given project and location. Through enrollment, an existing admin cluster will become Anthos On-Prem API managed. The corresponding GCP resources will be created and all future modifications to the cluster will be expected to be performed through the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkeonprem.googleapis.com/"
     "v1/{+parent}/bareMetalAdminClusters:enroll"
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

(defn locations-bareMetalAdminClusters-operations-list$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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

(defn locations-bareMetalAdminClusters-operations-get$
  "https://cloud.google.com/anthos/clusters/docs/on-prem/api/reference/rest/v1/projects/locations/bareMetalAdminClusters/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkeonprem.googleapis.com/"
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
