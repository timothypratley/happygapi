(ns happygapi.compute.instances
  "Compute Engine API: instances.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/instances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deleteAccessConfig$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/deleteAccessConfig
  
  Required parameters: accessConfig, zone, project, networkInterface, instance
  
  Optional parameters: requestId
  
  Deletes an access config from an instance's network interface."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project :accessConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/deleteAccessConfig"
     #{:instance :zone :networkInterface :project :accessConfig}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getScreenshot$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getScreenshot
  
  Required parameters: instance, project, zone
  
  Optional parameters: none
  
  Returns the screenshot from the specified instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/screenshot"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/get
  
  Required parameters: project, instance, zone
  
  Optional parameters: none
  
  Returns the specified Instance resource. Gets a list of available instances by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn startWithEncryptionKey$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/startWithEncryptionKey
  
  Required parameters: instance, zone, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:disks [{:diskEncryptionKey CustomerEncryptionKey, :source string}]}
  
  Starts an instance that was stopped using the instances().stop method. For more information, see Restart an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/startWithEncryptionKey"
     #{:instance :zone :project}
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

(defn updateAccessConfig$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/updateAccessConfig
  
  Required parameters: networkInterface, instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:publicPtrDomainName string,
   :name string,
   :natIP string,
   :type string,
   :externalIpv6 string,
   :kind string,
   :networkTier string,
   :setPublicPtr boolean,
   :externalIpv6PrefixLength integer}
  
  Updates the specified access config from an instance's network interface with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/updateAccessConfig"
     #{:instance :zone :networkInterface :project}
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

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setIamPolicy
  
  Required parameters: project, zone, resource
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:members [string],
               :condition Expr,
               :bindingId string,
               :role string}],
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :rules [Rule],
            :bindings [Binding]},
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{resource}/setIamPolicy"
     #{:zone :project :resource}
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/insert
  
  Required parameters: project, zone
  
  Optional parameters: sourceInstanceTemplate, requestId
  
  Body: 
  
  {:description string,
   :tags {:items [string], :fingerprint string},
   :labels {},
   :startRestricted boolean,
   :shieldedInstanceConfig {:enableVtpm boolean,
                            :enableIntegrityMonitoring boolean,
                            :enableSecureBoot boolean},
   :scheduling {:locationHint string,
                :automaticRestart boolean,
                :onHostMaintenance string,
                :preemptible boolean,
                :nodeAffinities [SchedulingNodeAffinity],
                :minNodeCpus integer},
   :resourcePolicies [string],
   :lastSuspendedTimestamp string,
   :creationTimestamp string,
   :zone string,
   :privateIpv6GoogleAccess string,
   :name string,
   :canIpForward boolean,
   :statusMessage string,
   :guestAccelerators [{:acceleratorCount integer,
                        :acceleratorType string}],
   :selfLink string,
   :hostname string,
   :machineType string,
   :displayDevice {:enableDisplay boolean},
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :satisfiesPzs boolean,
   :status string,
   :advancedMachineFeatures {:enableNestedVirtualization boolean,
                             :threadsPerCore integer},
   :id string,
   :lastStopTimestamp string,
   :kind string,
   :disks [{:interface string,
            :guestOsFeatures [GuestOsFeature],
            :index integer,
            :deviceName string,
            :boot boolean,
            :mode string,
            :licenses [string],
            :type string,
            :source string,
            :autoDelete boolean,
            :kind string,
            :initializeParams AttachedDiskInitializeParams,
            :diskSizeGb string,
            :diskEncryptionKey CustomerEncryptionKey,
            :shieldedInstanceInitialState InitialStateConfig}],
   :lastStartTimestamp string,
   :cpuPlatform string,
   :reservationAffinity {:key string,
                         :consumeReservationType string,
                         :values [string]},
   :networkInterfaces [{:ipv6AccessType string,
                        :stackType string,
                        :accessConfigs [AccessConfig],
                        :name string,
                        :aliasIpRanges [AliasIpRange],
                        :nicType string,
                        :ipv6Address string,
                        :ipv6AccessConfigs [AccessConfig],
                        :kind string,
                        :queueCount integer,
                        :network string,
                        :networkIP string,
                        :fingerprint string,
                        :subnetwork string}],
   :deletionProtection boolean,
   :metadata {:items [{:key string, :value string}],
              :kind string,
              :fingerprint string},
   :fingerprint string,
   :shieldedInstanceIntegrityPolicy {:updateAutoLearnPolicy boolean},
   :labelFingerprint string,
   :serviceAccounts [{:scopes [string], :email string}],
   :minCpuPlatform string}
  
  Creates an instance resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances"
     #{:zone :project}
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

(defn setMachineResources$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setMachineResources
  
  Required parameters: zone, project, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:guestAccelerators [{:acceleratorCount integer,
                        :acceleratorType string}]}
  
  Changes the number and/or type of accelerator for a stopped instance to the values specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setMachineResources"
     #{:instance :zone :project}
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

(defn getEffectiveFirewalls$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getEffectiveFirewalls
  
  Required parameters: instance, zone, networkInterface, project
  
  Optional parameters: none
  
  Returns effective firewalls applied to an interface of the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/getEffectiveFirewalls"
     #{:instance :zone :networkInterface :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/testIamPermissions
  
  Required parameters: zone, project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{resource}/testIamPermissions"
     #{:zone :project :resource}
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

(defn reset$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/reset
  
  Required parameters: zone, instance, project
  
  Optional parameters: requestId
  
  Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown. For more information, see Resetting an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/reset"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setLabels
  
  Required parameters: zone, project, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets labels on an instance. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setLabels"
     #{:instance :zone :project}
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/aggregatedList
  
  Required parameters: project
  
  Optional parameters: includeAllScopes, orderBy, pageToken, returnPartialSuccess, filter, maxResults
  
  Retrieves aggregated list of all of the instances in your project across all regions and zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/instances"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateNetworkInterface$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/updateNetworkInterface
  
  Required parameters: zone, project, networkInterface, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:ipv6AccessType string,
   :stackType string,
   :accessConfigs [{:publicPtrDomainName string,
                    :name string,
                    :natIP string,
                    :type string,
                    :externalIpv6 string,
                    :kind string,
                    :networkTier string,
                    :setPublicPtr boolean,
                    :externalIpv6PrefixLength integer}],
   :name string,
   :aliasIpRanges [{:ipCidrRange string, :subnetworkRangeName string}],
   :nicType string,
   :ipv6Address string,
   :ipv6AccessConfigs [{:publicPtrDomainName string,
                        :name string,
                        :natIP string,
                        :type string,
                        :externalIpv6 string,
                        :kind string,
                        :networkTier string,
                        :setPublicPtr boolean,
                        :externalIpv6PrefixLength integer}],
   :kind string,
   :queueCount integer,
   :network string,
   :networkIP string,
   :fingerprint string,
   :subnetwork string}
  
  Updates an instance's network interface. This method can only update an interface's alias IP range and attached network. See Modifying alias IP ranges for an existing instance for instructions on changing alias IP ranges. See Migrating a VM between networks for instructions on migrating an interface. This method follows PATCH semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/updateNetworkInterface"
     #{:instance :zone :networkInterface :project}
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

(defn removeResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/removeResourcePolicies
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Removes resource policies from an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/removeResourcePolicies"
     #{:instance :zone :project}
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

(defn updateShieldedInstanceConfig$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/updateShieldedInstanceConfig
  
  Required parameters: zone, project, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:enableVtpm boolean,
   :enableIntegrityMonitoring boolean,
   :enableSecureBoot boolean}
  
  Updates the Shielded Instance config for an instance. You can only use this method on a stopped instance. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/updateShieldedInstanceConfig"
     #{:instance :zone :project}
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

(defn start$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/start
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Starts an instance that was stopped using the instances().stop method. For more information, see Restart an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/start"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addAccessConfig$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/addAccessConfig
  
  Required parameters: project, networkInterface, instance, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:publicPtrDomainName string,
   :name string,
   :natIP string,
   :type string,
   :externalIpv6 string,
   :kind string,
   :networkTier string,
   :setPublicPtr boolean,
   :externalIpv6PrefixLength integer}
  
  Adds an access config to an instance's network interface."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/addAccessConfig"
     #{:instance :zone :networkInterface :project}
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

(defn setDeletionProtection$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setDeletionProtection
  
  Required parameters: zone, resource, project
  
  Optional parameters: requestId, deletionProtection
  
  Sets deletion protection on the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{resource}/setDeletionProtection"
     #{:zone :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/update
  
  Required parameters: zone, instance, project
  
  Optional parameters: minimalAction, requestId, mostDisruptiveAllowedAction
  
  Body: 
  
  {:description string,
   :tags {:items [string], :fingerprint string},
   :labels {},
   :startRestricted boolean,
   :shieldedInstanceConfig {:enableVtpm boolean,
                            :enableIntegrityMonitoring boolean,
                            :enableSecureBoot boolean},
   :scheduling {:locationHint string,
                :automaticRestart boolean,
                :onHostMaintenance string,
                :preemptible boolean,
                :nodeAffinities [SchedulingNodeAffinity],
                :minNodeCpus integer},
   :resourcePolicies [string],
   :lastSuspendedTimestamp string,
   :creationTimestamp string,
   :zone string,
   :privateIpv6GoogleAccess string,
   :name string,
   :canIpForward boolean,
   :statusMessage string,
   :guestAccelerators [{:acceleratorCount integer,
                        :acceleratorType string}],
   :selfLink string,
   :hostname string,
   :machineType string,
   :displayDevice {:enableDisplay boolean},
   :confidentialInstanceConfig {:enableConfidentialCompute boolean},
   :satisfiesPzs boolean,
   :status string,
   :advancedMachineFeatures {:enableNestedVirtualization boolean,
                             :threadsPerCore integer},
   :id string,
   :lastStopTimestamp string,
   :kind string,
   :disks [{:interface string,
            :guestOsFeatures [GuestOsFeature],
            :index integer,
            :deviceName string,
            :boot boolean,
            :mode string,
            :licenses [string],
            :type string,
            :source string,
            :autoDelete boolean,
            :kind string,
            :initializeParams AttachedDiskInitializeParams,
            :diskSizeGb string,
            :diskEncryptionKey CustomerEncryptionKey,
            :shieldedInstanceInitialState InitialStateConfig}],
   :lastStartTimestamp string,
   :cpuPlatform string,
   :reservationAffinity {:key string,
                         :consumeReservationType string,
                         :values [string]},
   :networkInterfaces [{:ipv6AccessType string,
                        :stackType string,
                        :accessConfigs [AccessConfig],
                        :name string,
                        :aliasIpRanges [AliasIpRange],
                        :nicType string,
                        :ipv6Address string,
                        :ipv6AccessConfigs [AccessConfig],
                        :kind string,
                        :queueCount integer,
                        :network string,
                        :networkIP string,
                        :fingerprint string,
                        :subnetwork string}],
   :deletionProtection boolean,
   :metadata {:items [{:key string, :value string}],
              :kind string,
              :fingerprint string},
   :fingerprint string,
   :shieldedInstanceIntegrityPolicy {:updateAutoLearnPolicy boolean},
   :labelFingerprint string,
   :serviceAccounts [{:scopes [string], :email string}],
   :minCpuPlatform string}
  
  Updates an instance only if the necessary resources are available. This method can update only a specific set of instance properties. See Updating a running instance for a list of updatable instance properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}"
     #{:instance :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/delete
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified Instance resource. For more information, see Deleting an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setDiskAutoDelete$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setDiskAutoDelete
  
  Required parameters: zone, deviceName, project, autoDelete, instance
  
  Optional parameters: requestId
  
  Sets the auto-delete flag for a disk attached to an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:deviceName :instance :zone :autoDelete :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setDiskAutoDelete"
     #{:deviceName :instance :zone :autoDelete :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getIamPolicy
  
  Required parameters: zone, project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{resource}/getIamPolicy"
     #{:zone :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getShieldedInstanceIdentity$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getShieldedInstanceIdentity
  
  Required parameters: zone, instance, project
  
  Optional parameters: none
  
  Returns the Shielded Instance Identity of an instance"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/getShieldedInstanceIdentity"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listReferrers$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/listReferrers
  
  Required parameters: zone, instance, project
  
  Optional parameters: maxResults, pageToken, orderBy, returnPartialSuccess, filter
  
  Retrieves a list of resources that refer to the VM instance specified in the request. For example, if the VM instance is part of a managed or unmanaged instance group, the referrers list includes the instance group. For more information, read Viewing referrers to VM instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/referrers"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn detachDisk$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/detachDisk
  
  Required parameters: instance, project, deviceName, zone
  
  Optional parameters: requestId
  
  Detaches a disk from an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:deviceName :instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/detachDisk"
     #{:deviceName :instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setServiceAccount$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setServiceAccount
  
  Required parameters: zone, instance, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:email string, :scopes [string]}
  
  Sets the service account on the instance. For more information, read Changing the service account and access scopes for an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setServiceAccount"
     #{:instance :zone :project}
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

(defn getSerialPortOutput$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getSerialPortOutput
  
  Required parameters: project, instance, zone
  
  Optional parameters: start, port
  
  Returns the last 1 MB of serial port output from the specified instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/serialPort"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn stop$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/stop
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Stops a running instance, shutting it down cleanly, and allows you to restart the instance at a later time. Stopped instances do not incur VM usage charges while they are stopped. However, resources that the VM is using, such as persistent disks and static IP addresses, will continue to be charged until they are deleted. For more information, see Stopping an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/stop"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setMinCpuPlatform$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setMinCpuPlatform
  
  Required parameters: project, instance, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:minCpuPlatform string}
  
  Changes the minimum CPU platform that this instance should use. This method can only be called on a stopped instance. For more information, read Specifying a Minimum CPU Platform."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setMinCpuPlatform"
     #{:instance :zone :project}
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

(defn addResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/addResourcePolicies
  
  Required parameters: zone, project, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Adds existing resource policies to an instance. You can only add one policy right now which will be applied to this instance for scheduling live migrations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/addResourcePolicies"
     #{:instance :zone :project}
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, returnPartialSuccess, maxResults, orderBy, pageToken
  
  Retrieves the list of instances contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getGuestAttributes$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/getGuestAttributes
  
  Required parameters: zone, instance, project
  
  Optional parameters: queryPath, variableKey
  
  Returns the specified guest attributes entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/getGuestAttributes"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn sendDiagnosticInterrupt$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/sendDiagnosticInterrupt
  
  Required parameters: project, zone, instance
  
  Optional parameters: none
  
  Sends diagnostic interrupt to the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/sendDiagnosticInterrupt"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updateDisplayDevice$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/updateDisplayDevice
  
  Required parameters: instance, zone, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:enableDisplay boolean}
  
  Updates the Display config for a VM instance. You can only use this method on a stopped VM instance. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/updateDisplayDevice"
     #{:instance :zone :project}
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

(defn setScheduling$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setScheduling
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:locationHint string,
   :automaticRestart boolean,
   :onHostMaintenance string,
   :preemptible boolean,
   :nodeAffinities [{:key string, :values [string], :operator string}],
   :minNodeCpus integer}
  
  Sets an instance's scheduling options. You can only call this method on a stopped instance, that is, a VM instance that is in a `TERMINATED` state. See Instance Life Cycle for more information on the possible instance states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setScheduling"
     #{:instance :zone :project}
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

(defn simulateMaintenanceEvent$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/simulateMaintenanceEvent
  
  Required parameters: instance, zone, project
  
  Optional parameters: none
  
  Simulates a maintenance event on the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/simulateMaintenanceEvent"
     #{:instance :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachDisk$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/attachDisk
  
  Required parameters: project, instance, zone
  
  Optional parameters: requestId, forceAttach
  
  Body: 
  
  {:interface string,
   :guestOsFeatures [{:type string}],
   :index integer,
   :deviceName string,
   :boot boolean,
   :mode string,
   :licenses [string],
   :type string,
   :source string,
   :autoDelete boolean,
   :kind string,
   :initializeParams {:description string,
                      :labels {},
                      :sourceSnapshotEncryptionKey CustomerEncryptionKey,
                      :resourcePolicies [string],
                      :sourceImage string,
                      :sourceImageEncryptionKey CustomerEncryptionKey,
                      :sourceSnapshot string,
                      :diskType string,
                      :onUpdateAction string,
                      :diskSizeGb string,
                      :diskName string,
                      :provisionedIops string},
   :diskSizeGb string,
   :diskEncryptionKey {:kmsKeyName string,
                       :kmsKeyServiceAccount string,
                       :sha256 string,
                       :rawKey string,
                       :rsaEncryptedKey string},
   :shieldedInstanceInitialState {:keks [FileContentBuffer],
                                  :dbxs [FileContentBuffer],
                                  :dbs [FileContentBuffer],
                                  :pk FileContentBuffer}}
  
  Attaches an existing Disk resource to an instance. You must first create the disk before you can attach it. It is not possible to create and attach a disk at the same time. For more information, read Adding a persistent disk to your instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/attachDisk"
     #{:instance :zone :project}
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

(defn setMetadata$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setMetadata
  
  Required parameters: zone, instance, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:items [{:key string, :value string}],
   :kind string,
   :fingerprint string}
  
  Sets metadata for the specified instance to the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setMetadata"
     #{:instance :zone :project}
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

(defn setShieldedInstanceIntegrityPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setShieldedInstanceIntegrityPolicy
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:updateAutoLearnPolicy boolean}
  
  Sets the Shielded Instance integrity policy for an instance. You can only use this method on a running instance. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setShieldedInstanceIntegrityPolicy"
     #{:instance :zone :project}
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

(defn setMachineType$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setMachineType
  
  Required parameters: project, zone, instance
  
  Optional parameters: requestId
  
  Body: 
  
  {:machineType string}
  
  Changes the machine type for a stopped instance to the machine type specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setMachineType"
     #{:instance :zone :project}
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

(defn bulkInsert$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/bulkInsert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:minCount string,
   :count string,
   :namePattern string,
   :instanceProperties {:description string,
                        :tags Tags,
                        :labels {},
                        :shieldedInstanceConfig ShieldedInstanceConfig,
                        :scheduling Scheduling,
                        :resourcePolicies [string],
                        :privateIpv6GoogleAccess string,
                        :canIpForward boolean,
                        :guestAccelerators [AcceleratorConfig],
                        :machineType string,
                        :confidentialInstanceConfig ConfidentialInstanceConfig,
                        :advancedMachineFeatures AdvancedMachineFeatures,
                        :disks [AttachedDisk],
                        :reservationAffinity ReservationAffinity,
                        :networkInterfaces [NetworkInterface],
                        :metadata Metadata,
                        :serviceAccounts [ServiceAccount],
                        :minCpuPlatform string},
   :locationPolicy {:locations {}},
   :perInstanceProperties {},
   :sourceInstanceTemplate string}
  
  Creates multiple instances. Count specifies the number of instances to create."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/bulkInsert"
     #{:zone :project}
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

(defn setTags$
  "https://cloud.google.com/compute/api/reference/rest/v1/instances/setTags
  
  Required parameters: project, instance, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:items [string], :fingerprint string}
  
  Sets network tags for the specified instance to the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/instances/{instance}/setTags"
     #{:instance :zone :project}
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
