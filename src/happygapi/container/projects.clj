(ns happygapi.container.projects
  "Kubernetes Engine API: projects.
  Builds and manages container-based applications, powered by the open source Kubernetes technology.
  See: https://cloud.google.com/container-engine/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregated-usableSubnetworks-list$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/aggregated/usableSubnetworks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists subnetworks that are usable for creating clusters in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/aggregated/usableSubnetworks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-getServerconfig$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/getServerconfig
  
  Required parameters: projectId, zone
  
  Optional parameters: name
  
  Returns configuration info about the Google Kubernetes Engine service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/serverconfig"
     #{:zone :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-monitoring$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/monitoring
  
  Required parameters: clusterId, projectId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :monitoringService string,
   :clusterId string,
   :zone string,
   :name string}
  
  Sets the monitoring service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/monitoring"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-get$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/get
  
  Required parameters: clusterId, projectId, zone
  
  Optional parameters: name
  
  Gets the details of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{:zone :clusterId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-create$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/create
  
  Required parameters: projectId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :parent string,
   :cluster {:description string,
             :currentNodeCount integer,
             :tpuIpv4CidrBlock string,
             :verticalPodAutoscaling VerticalPodAutoscaling,
             :networkPolicy NetworkPolicy,
             :instanceGroupUrls [string],
             :autopilot Autopilot,
             :monitoringConfig MonitoringConfig,
             :loggingConfig LoggingConfig,
             :autoscaling ClusterAutoscaling,
             :enableKubernetesAlpha boolean,
             :nodeConfig NodeConfig,
             :masterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
             :zone string,
             :databaseEncryption DatabaseEncryption,
             :masterAuth MasterAuth,
             :privateClusterConfig PrivateClusterConfig,
             :loggingService string,
             :name string,
             :shieldedNodes ShieldedNodes,
             :initialClusterVersion string,
             :binaryAuthorization BinaryAuthorization,
             :statusMessage string,
             :defaultMaxPodsConstraint MaxPodsConstraint,
             :createTime string,
             :resourceUsageExportConfig ResourceUsageExportConfig,
             :selfLink string,
             :nodeIpv4CidrSize integer,
             :networkConfig NetworkConfig,
             :legacyAbac LegacyAbac,
             :nodePools [NodePool],
             :releaseChannel ReleaseChannel,
             :maintenancePolicy MaintenancePolicy,
             :locations [string],
             :clusterIpv4Cidr string,
             :currentNodeVersion string,
             :confidentialNodes ConfidentialNodes,
             :initialNodeCount integer,
             :conditions [StatusCondition],
             :resourceLabels {},
             :status string,
             :id string,
             :notificationConfig NotificationConfig,
             :currentMasterVersion string,
             :authenticatorGroupsConfig AuthenticatorGroupsConfig,
             :workloadIdentityConfig WorkloadIdentityConfig,
             :expireTime string,
             :monitoringService string,
             :network string,
             :addonsConfig AddonsConfig,
             :servicesIpv4Cidr string,
             :location string,
             :endpoint string,
             :enableTpu boolean,
             :subnetwork string,
             :labelFingerprint string,
             :ipAllocationPolicy IPAllocationPolicy},
   :zone string}
  
  Creates a cluster, consisting of the specified number and type of Google Compute Engine instances. By default, the cluster is created in the project's [default network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks). One firewall is added for the cluster. After cluster creation, the Kubelet creates routes for each node to allow the containers on that node to communicate with all other instances in the cluster. Finally, an entry is added to the project's global metadata indicating which CIDR range the cluster is using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters"
     #{:zone :projectId}
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

(defn zones-clusters-update$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/update
  
  Required parameters: projectId, clusterId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:update {:desiredIntraNodeVisibilityConfig IntraNodeVisibilityConfig,
            :desiredBinaryAuthorization BinaryAuthorization,
            :desiredDefaultSnatStatus DefaultSnatStatus,
            :desiredDatabaseEncryption DatabaseEncryption,
            :desiredAddonsConfig AddonsConfig,
            :desiredNodePoolId string,
            :desiredMonitoringConfig MonitoringConfig,
            :desiredLocations [string],
            :desiredAutopilot Autopilot,
            :desiredLoggingConfig LoggingConfig,
            :desiredResourceUsageExportConfig ResourceUsageExportConfig,
            :desiredAuthenticatorGroupsConfig AuthenticatorGroupsConfig,
            :desiredImageType string,
            :desiredLoggingService string,
            :desiredNodePoolAutoscaling NodePoolAutoscaling,
            :desiredNodeVersion string,
            :desiredPrivateClusterConfig PrivateClusterConfig,
            :desiredDatapathProvider string,
            :desiredReleaseChannel ReleaseChannel,
            :desiredWorkloadIdentityConfig WorkloadIdentityConfig,
            :desiredL4ilbSubsettingConfig ILBSubsettingConfig,
            :desiredPrivateIpv6GoogleAccess string,
            :desiredMonitoringService string,
            :desiredShieldedNodes ShieldedNodes,
            :desiredMasterVersion string,
            :desiredClusterAutoscaling ClusterAutoscaling,
            :desiredNotificationConfig NotificationConfig,
            :desiredMasterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
            :desiredVerticalPodAutoscaling VerticalPodAutoscaling},
   :zone string,
   :projectId string,
   :name string,
   :clusterId string}
  
  Updates the settings of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-delete$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/delete
  
  Required parameters: clusterId, zone, projectId
  
  Optional parameters: name
  
  Deletes the cluster, including the Kubernetes endpoint and all worker nodes. Firewalls and routes that were configured during cluster creation are also deleted. Other Google Compute Engine resources that might be in use by the cluster, such as load balancer resources, are not deleted if they weren't present when the cluster was initially created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}"
     #{:zone :clusterId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-legacyAbac$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/legacyAbac
  
  Required parameters: zone, clusterId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :enabled boolean,
   :name string,
   :clusterId string,
   :zone string}
  
  Enables or disables the ABAC authorization mechanism on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/legacyAbac"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-locations$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/locations
  
  Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :zone string,
   :name string,
   :clusterId string,
   :locations [string]}
  
  Sets the locations for a specific cluster. Deprecated. Use [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update) instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/locations"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-logging$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/logging
  
  Required parameters: clusterId, zone, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :zone string,
   :projectId string,
   :loggingService string,
   :clusterId string}
  
  Sets the logging service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/logging"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-resourceLabels$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/resourceLabels
  
  Required parameters: projectId, clusterId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:labelFingerprint string,
   :clusterId string,
   :zone string,
   :resourceLabels {},
   :name string,
   :projectId string}
  
  Sets labels on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/resourceLabels"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-setMasterAuth$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/setMasterAuth
  
  Required parameters: clusterId, projectId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :clusterId string,
   :update {:clientCertificate string,
            :clusterCaCertificate string,
            :clientKey string,
            :clientCertificateConfig ClientCertificateConfig,
            :password string,
            :username string},
   :zone string,
   :action string,
   :name string}
  
  Sets master auth materials. Currently supports changing the admin password or a specific cluster, either via password generation or explicitly setting the password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMasterAuth"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-list$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/list
  
  Required parameters: projectId, zone
  
  Optional parameters: parent
  
  Lists all clusters owned by a project in either the specified zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters"
     #{:zone :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-setNetworkPolicy$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/setNetworkPolicy
  
  Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:networkPolicy {:enabled boolean, :provider string},
   :projectId string,
   :zone string,
   :name string,
   :clusterId string}
  
  Enables or disables Network Policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setNetworkPolicy"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-addons$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/addons
  
  Required parameters: clusterId, zone, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:addonsConfig {:gcePersistentDiskCsiDriverConfig GcePersistentDiskCsiDriverConfig,
                  :configConnectorConfig ConfigConnectorConfig,
                  :cloudRunConfig CloudRunConfig,
                  :networkPolicyConfig NetworkPolicyConfig,
                  :httpLoadBalancing HttpLoadBalancing,
                  :kubernetesDashboard KubernetesDashboard,
                  :dnsCacheConfig DnsCacheConfig,
                  :gcpFilestoreCsiDriverConfig GcpFilestoreCsiDriverConfig,
                  :horizontalPodAutoscaling HorizontalPodAutoscaling},
   :name string,
   :zone string,
   :projectId string,
   :clusterId string}
  
  Sets the addons for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/addons"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-startIpRotation$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/startIpRotation
  
  Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:rotateCredentials boolean,
   :projectId string,
   :clusterId string,
   :name string,
   :zone string}
  
  Starts master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:startIpRotation"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-completeIpRotation$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/completeIpRotation
  
  Required parameters: clusterId, zone, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :projectId string, :zone string, :clusterId string}
  
  Completes master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:completeIpRotation"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-master$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/master
  
  Required parameters: projectId, zone, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:masterVersion string,
   :projectId string,
   :zone string,
   :name string,
   :clusterId string}
  
  Updates the master for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/master"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-setMaintenancePolicy$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/setMaintenancePolicy
  
  Required parameters: clusterId, projectId, zone
  
  Optional parameters: none
  
  Body: 
  
  {:maintenancePolicy {:window MaintenanceWindow,
                       :resourceVersion string},
   :clusterId string,
   :name string,
   :projectId string,
   :zone string}
  
  Sets the maintenance policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}:setMaintenancePolicy"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-rollback$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/rollback
  
  Required parameters: zone, clusterId, nodePoolId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :zone string,
   :projectId string,
   :nodePoolId string,
   :clusterId string}
  
  Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last upgrade successfully completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}:rollback"
     #{:nodePoolId :zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-get$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/get
  
  Required parameters: nodePoolId, projectId, zone, clusterId
  
  Optional parameters: name
  
  Retrieves the requested node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}"
     #{:nodePoolId :zone :clusterId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-nodePools-autoscaling$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/autoscaling
  
  Required parameters: clusterId, projectId, zone, nodePoolId
  
  Optional parameters: none
  
  Body: 
  
  {:nodePoolId string,
   :zone string,
   :projectId string,
   :name string,
   :autoscaling {:autoprovisioned boolean,
                 :enabled boolean,
                 :maxNodeCount integer,
                 :minNodeCount integer},
   :clusterId string}
  
  Sets the autoscaling settings for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/autoscaling"
     #{:nodePoolId :zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-create$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/create
  
  Required parameters: zone, clusterId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :clusterId string,
   :parent string,
   :zone string,
   :nodePool {:instanceGroupUrls [string],
              :maxPodsConstraint MaxPodsConstraint,
              :podIpv4CidrSize integer,
              :autoscaling NodePoolAutoscaling,
              :config NodeConfig,
              :name string,
              :statusMessage string,
              :selfLink string,
              :networkConfig NodeNetworkConfig,
              :locations [string],
              :initialNodeCount integer,
              :conditions [StatusCondition],
              :status string,
              :version string,
              :management NodeManagement,
              :upgradeSettings UpgradeSettings}}
  
  Creates a node pool for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools"
     #{:zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-setManagement$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/setManagement
  
  Required parameters: projectId, zone, nodePoolId, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :management {:autoUpgrade boolean,
                :autoRepair boolean,
                :upgradeOptions AutoUpgradeOptions},
   :zone string,
   :projectId string,
   :nodePoolId string,
   :clusterId string}
  
  Sets the NodeManagement options for a node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setManagement"
     #{:nodePoolId :zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-update$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/update
  
  Required parameters: zone, clusterId, nodePoolId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:nodePoolId string,
   :zone string,
   :name string,
   :clusterId string,
   :imageType string,
   :linuxNodeConfig {:sysctls {}},
   :kubeletConfig {:cpuCfsQuota boolean,
                   :cpuManagerPolicy string,
                   :cpuCfsQuotaPeriod string},
   :locations [string],
   :projectId string,
   :workloadMetadataConfig {:mode string},
   :nodeVersion string,
   :gvnic {:enabled boolean},
   :upgradeSettings {:maxUnavailable integer, :maxSurge integer}}
  
  Updates the version and/or image type for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/update"
     #{:nodePoolId :zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-delete$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/delete
  
  Required parameters: clusterId, zone, nodePoolId, projectId
  
  Optional parameters: name
  
  Deletes a node pool from a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}"
     #{:nodePoolId :zone :clusterId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-clusters-nodePools-setSize$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/setSize
  
  Required parameters: zone, projectId, nodePoolId, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :nodePoolId string,
   :nodeCount integer,
   :name string,
   :clusterId string,
   :projectId string}
  
  Sets the size for a specific node pool. The new size will be used for all replicas, including future replicas created by modifying NodePool.locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:nodePoolId :zone :clusterId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools/{nodePoolId}/setSize"
     #{:nodePoolId :zone :clusterId :projectId}
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

(defn zones-clusters-nodePools-list$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/clusters/nodePools/list
  
  Required parameters: clusterId, projectId, zone
  
  Optional parameters: parent
  
  Lists the node pools for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :clusterId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/clusters/{clusterId}/nodePools"
     #{:zone :clusterId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-operations-list$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/operations/list
  
  Required parameters: zone, projectId
  
  Optional parameters: parent
  
  Lists all operations in a project in a specific zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations"
     #{:zone :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn zones-operations-cancel$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/operations/cancel
  
  Required parameters: zone, projectId, operationId
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :operationId string, :zone string, :projectId string}
  
  Cancels the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :projectId :operationId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations/{operationId}:cancel"
     #{:zone :projectId :operationId}
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

(defn zones-operations-get$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/zones/operations/get
  
  Required parameters: projectId, operationId, zone
  
  Optional parameters: name
  
  Gets the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :projectId :operationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/projects/{projectId}/zones/{zone}/operations/{operationId}"
     #{:zone :projectId :operationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-getServerConfig$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/getServerConfig
  
  Required parameters: name
  
  Optional parameters: zone, projectId
  
  Returns configuration info about the Google Kubernetes Engine service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}/serverConfig"
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
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: zone, projectId, operationId
  
  Gets the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
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
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: parent
  
  Optional parameters: zone, projectId
  
  Lists all operations in a project in a specific zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/operations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :operationId string, :zone string, :projectId string}
  
  Cancels the specified operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-getJwks$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/getJwks
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the public component of the cluster signing keys in JSON Web Key format. This API is not yet intended for general use, and is not available for all clusters."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/jwks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-updateMaster$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/updateMaster
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:masterVersion string,
   :projectId string,
   :zone string,
   :name string,
   :clusterId string}
  
  Updates the master for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:updateMaster"
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

(defn locations-clusters-get$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/get
  
  Required parameters: name
  
  Optional parameters: clusterId, zone, projectId
  
  Gets the details of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-setResourceLabels$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setResourceLabels
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labelFingerprint string,
   :clusterId string,
   :zone string,
   :resourceLabels {},
   :name string,
   :projectId string}
  
  Sets labels on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setResourceLabels"
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

(defn locations-clusters-create$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :parent string,
   :cluster {:description string,
             :currentNodeCount integer,
             :tpuIpv4CidrBlock string,
             :verticalPodAutoscaling VerticalPodAutoscaling,
             :networkPolicy NetworkPolicy,
             :instanceGroupUrls [string],
             :autopilot Autopilot,
             :monitoringConfig MonitoringConfig,
             :loggingConfig LoggingConfig,
             :autoscaling ClusterAutoscaling,
             :enableKubernetesAlpha boolean,
             :nodeConfig NodeConfig,
             :masterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
             :zone string,
             :databaseEncryption DatabaseEncryption,
             :masterAuth MasterAuth,
             :privateClusterConfig PrivateClusterConfig,
             :loggingService string,
             :name string,
             :shieldedNodes ShieldedNodes,
             :initialClusterVersion string,
             :binaryAuthorization BinaryAuthorization,
             :statusMessage string,
             :defaultMaxPodsConstraint MaxPodsConstraint,
             :createTime string,
             :resourceUsageExportConfig ResourceUsageExportConfig,
             :selfLink string,
             :nodeIpv4CidrSize integer,
             :networkConfig NetworkConfig,
             :legacyAbac LegacyAbac,
             :nodePools [NodePool],
             :releaseChannel ReleaseChannel,
             :maintenancePolicy MaintenancePolicy,
             :locations [string],
             :clusterIpv4Cidr string,
             :currentNodeVersion string,
             :confidentialNodes ConfidentialNodes,
             :initialNodeCount integer,
             :conditions [StatusCondition],
             :resourceLabels {},
             :status string,
             :id string,
             :notificationConfig NotificationConfig,
             :currentMasterVersion string,
             :authenticatorGroupsConfig AuthenticatorGroupsConfig,
             :workloadIdentityConfig WorkloadIdentityConfig,
             :expireTime string,
             :monitoringService string,
             :network string,
             :addonsConfig AddonsConfig,
             :servicesIpv4Cidr string,
             :location string,
             :endpoint string,
             :enableTpu boolean,
             :subnetwork string,
             :labelFingerprint string,
             :ipAllocationPolicy IPAllocationPolicy},
   :zone string}
  
  Creates a cluster, consisting of the specified number and type of Google Compute Engine instances. By default, the cluster is created in the project's [default network](https://cloud.google.com/compute/docs/networks-and-firewalls#networks). One firewall is added for the cluster. After cluster creation, the Kubelet creates routes for each node to allow the containers on that node to communicate with all other instances in the cluster. Finally, an entry is added to the project's global metadata indicating which CIDR range the cluster is using."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-setAddons$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setAddons
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:addonsConfig {:gcePersistentDiskCsiDriverConfig GcePersistentDiskCsiDriverConfig,
                  :configConnectorConfig ConfigConnectorConfig,
                  :cloudRunConfig CloudRunConfig,
                  :networkPolicyConfig NetworkPolicyConfig,
                  :httpLoadBalancing HttpLoadBalancing,
                  :kubernetesDashboard KubernetesDashboard,
                  :dnsCacheConfig DnsCacheConfig,
                  :gcpFilestoreCsiDriverConfig GcpFilestoreCsiDriverConfig,
                  :horizontalPodAutoscaling HorizontalPodAutoscaling},
   :name string,
   :zone string,
   :projectId string,
   :clusterId string}
  
  Sets the addons for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setAddons"
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

(defn locations-clusters-update$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:update {:desiredIntraNodeVisibilityConfig IntraNodeVisibilityConfig,
            :desiredBinaryAuthorization BinaryAuthorization,
            :desiredDefaultSnatStatus DefaultSnatStatus,
            :desiredDatabaseEncryption DatabaseEncryption,
            :desiredAddonsConfig AddonsConfig,
            :desiredNodePoolId string,
            :desiredMonitoringConfig MonitoringConfig,
            :desiredLocations [string],
            :desiredAutopilot Autopilot,
            :desiredLoggingConfig LoggingConfig,
            :desiredResourceUsageExportConfig ResourceUsageExportConfig,
            :desiredAuthenticatorGroupsConfig AuthenticatorGroupsConfig,
            :desiredImageType string,
            :desiredLoggingService string,
            :desiredNodePoolAutoscaling NodePoolAutoscaling,
            :desiredNodeVersion string,
            :desiredPrivateClusterConfig PrivateClusterConfig,
            :desiredDatapathProvider string,
            :desiredReleaseChannel ReleaseChannel,
            :desiredWorkloadIdentityConfig WorkloadIdentityConfig,
            :desiredL4ilbSubsettingConfig ILBSubsettingConfig,
            :desiredPrivateIpv6GoogleAccess string,
            :desiredMonitoringService string,
            :desiredShieldedNodes ShieldedNodes,
            :desiredMasterVersion string,
            :desiredClusterAutoscaling ClusterAutoscaling,
            :desiredNotificationConfig NotificationConfig,
            :desiredMasterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
            :desiredVerticalPodAutoscaling VerticalPodAutoscaling},
   :zone string,
   :projectId string,
   :name string,
   :clusterId string}
  
  Updates the settings of a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
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
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/delete
  
  Required parameters: name
  
  Optional parameters: clusterId, projectId, zone
  
  Deletes the cluster, including the Kubernetes endpoint and all worker nodes. Firewalls and routes that were configured during cluster creation are also deleted. Other Google Compute Engine resources that might be in use by the cluster, such as load balancer resources, are not deleted if they weren't present when the cluster was initially created."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-setLogging$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setLogging
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :zone string,
   :projectId string,
   :loggingService string,
   :clusterId string}
  
  Sets the logging service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLogging"
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

(defn locations-clusters-setMasterAuth$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setMasterAuth
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :clusterId string,
   :update {:clientCertificate string,
            :clusterCaCertificate string,
            :clientKey string,
            :clientCertificateConfig ClientCertificateConfig,
            :password string,
            :username string},
   :zone string,
   :action string,
   :name string}
  
  Sets master auth materials. Currently supports changing the admin password or a specific cluster, either via password generation or explicitly setting the password."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMasterAuth"
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
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/list
  
  Required parameters: parent
  
  Optional parameters: projectId, zone
  
  Lists all clusters owned by a project in either the specified zone or all zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-setNetworkPolicy$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setNetworkPolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:networkPolicy {:enabled boolean, :provider string},
   :projectId string,
   :zone string,
   :name string,
   :clusterId string}
  
  Enables or disables Network Policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setNetworkPolicy"
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

(defn locations-clusters-setMonitoring$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setMonitoring
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :monitoringService string,
   :clusterId string,
   :zone string,
   :name string}
  
  Sets the monitoring service for a specific cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMonitoring"
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

(defn locations-clusters-startIpRotation$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/startIpRotation
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:rotateCredentials boolean,
   :projectId string,
   :clusterId string,
   :name string,
   :zone string}
  
  Starts master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:startIpRotation"
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

(defn locations-clusters-completeIpRotation$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/completeIpRotation
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :projectId string, :zone string, :clusterId string}
  
  Completes master IP rotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:completeIpRotation"
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

(defn locations-clusters-setLocations$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setLocations
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :zone string,
   :name string,
   :clusterId string,
   :locations [string]}
  
  Sets the locations for a specific cluster. Deprecated. Use [projects.locations.clusters.update](https://cloud.google.com/kubernetes-engine/docs/reference/rest/v1/projects.locations.clusters/update) instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLocations"
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

(defn locations-clusters-setLegacyAbac$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setLegacyAbac
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :enabled boolean,
   :name string,
   :clusterId string,
   :zone string}
  
  Enables or disables the ABAC authorization mechanism on a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setLegacyAbac"
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

(defn locations-clusters-setMaintenancePolicy$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/setMaintenancePolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:maintenancePolicy {:window MaintenanceWindow,
                       :resourceVersion string},
   :clusterId string,
   :name string,
   :projectId string,
   :zone string}
  
  Sets the maintenance policy for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setMaintenancePolicy"
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

(defn locations-clusters-nodePools-rollback$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :zone string,
   :projectId string,
   :nodePoolId string,
   :clusterId string}
  
  Rolls back a previously Aborted or Failed NodePool upgrade. This makes no changes if the last upgrade successfully completed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-nodePools-get$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/get
  
  Required parameters: name
  
  Optional parameters: clusterId, projectId, nodePoolId, zone
  
  Retrieves the requested node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-nodePools-create$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:projectId string,
   :clusterId string,
   :parent string,
   :zone string,
   :nodePool {:instanceGroupUrls [string],
              :maxPodsConstraint MaxPodsConstraint,
              :podIpv4CidrSize integer,
              :autoscaling NodePoolAutoscaling,
              :config NodeConfig,
              :name string,
              :statusMessage string,
              :selfLink string,
              :networkConfig NodeNetworkConfig,
              :locations [string],
              :initialNodeCount integer,
              :conditions [StatusCondition],
              :status string,
              :version string,
              :management NodeManagement,
              :upgradeSettings UpgradeSettings}}
  
  Creates a node pool for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/nodePools"
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

(defn locations-clusters-nodePools-setAutoscaling$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/setAutoscaling
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:nodePoolId string,
   :zone string,
   :projectId string,
   :name string,
   :autoscaling {:autoprovisioned boolean,
                 :enabled boolean,
                 :maxNodeCount integer,
                 :minNodeCount integer},
   :clusterId string}
  
  Sets the autoscaling settings for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setAutoscaling"
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

(defn locations-clusters-nodePools-setManagement$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/setManagement
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :management {:autoUpgrade boolean,
                :autoRepair boolean,
                :upgradeOptions AutoUpgradeOptions},
   :zone string,
   :projectId string,
   :nodePoolId string,
   :clusterId string}
  
  Sets the NodeManagement options for a node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setManagement"
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

(defn locations-clusters-nodePools-update$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:nodePoolId string,
   :zone string,
   :name string,
   :clusterId string,
   :imageType string,
   :linuxNodeConfig {:sysctls {}},
   :kubeletConfig {:cpuCfsQuota boolean,
                   :cpuManagerPolicy string,
                   :cpuCfsQuotaPeriod string},
   :locations [string],
   :projectId string,
   :workloadMetadataConfig {:mode string},
   :nodeVersion string,
   :gvnic {:enabled boolean},
   :upgradeSettings {:maxUnavailable integer, :maxSurge integer}}
  
  Updates the version and/or image type for the specified node pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-nodePools-delete$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/delete
  
  Required parameters: name
  
  Optional parameters: zone, nodePoolId, clusterId, projectId
  
  Deletes a node pool from a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://container.googleapis.com/"
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

(defn locations-clusters-nodePools-setSize$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/setSize
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :nodePoolId string,
   :nodeCount integer,
   :name string,
   :clusterId string,
   :projectId string}
  
  Sets the size for a specific node pool. The new size will be used for all replicas, including future replicas created by modifying NodePool.locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+name}:setSize"
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

(defn locations-clusters-nodePools-list$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/nodePools/list
  
  Required parameters: parent
  
  Optional parameters: clusterId, zone, projectId
  
  Lists the node pools for a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/nodePools"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-clusters-well-known-getOpenid-configuration$
  "https://cloud.google.com/container-engine/api/reference/rest/v1/projects/locations/clusters/well-known/getOpenid-configuration
  
  Required parameters: parent
  
  Optional parameters: none
  
  Gets the OIDC discovery document for the cluster. See the [OpenID Connect Discovery 1.0 specification](https://openid.net/specs/openid-connect-discovery-1_0.html) for details. This API is not yet intended for general use, and is not available for all clusters."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://container.googleapis.com/"
     "v1/{+parent}/.well-known/openid-configuration"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
