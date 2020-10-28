(ns happygapi.compute.instances
  "Compute Engine API: instances.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deleteAccessConfig$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/deleteAccessConfig
  
  Required parameters: accessConfig, instance, networkInterface, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/deleteAccessConfig"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/getScreenshot
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/screenshot"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/get
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/startWithEncryptionKey
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/startWithEncryptionKey"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/updateAccessConfig
  
  Required parameters: instance, networkInterface, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:kind string,
   :name string,
   :natIP string,
   :networkTier string,
   :publicPtrDomainName string,
   :setPublicPtr boolean,
   :type string}
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/updateAccessConfig"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setIamPolicy
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:bindingId string,
               :condition Expr,
               :members [string],
               :role string}],
   :etag string,
   :policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :iamOwned boolean,
            :rules [Rule],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{resource}/setIamPolicy"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId, sourceInstanceTemplate
  
  Body: 
  
  {:description string,
   :tags {:fingerprint string, :items [string]},
   :labels {},
   :startRestricted boolean,
   :shieldedInstanceConfig {:enableIntegrityMonitoring boolean,
                            :enableSecureBoot boolean,
                            :enableVtpm boolean},
   :scheduling {:automaticRestart boolean,
                :minNodeCpus integer,
                :nodeAffinities [SchedulingNodeAffinity],
                :onHostMaintenance string,
                :preemptible boolean},
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
   :status string,
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
   :reservationAffinity {:consumeReservationType string,
                         :key string,
                         :values [string]},
   :networkInterfaces [{:accessConfigs [AccessConfig],
                        :name string,
                        :aliasIpRanges [AliasIpRange],
                        :ipv6Address string,
                        :kind string,
                        :network string,
                        :networkIP string,
                        :fingerprint string,
                        :subnetwork string}],
   :deletionProtection boolean,
   :metadata {:fingerprint string,
              :items [{:key string, :value string}],
              :kind string},
   :fingerprint string,
   :shieldedInstanceIntegrityPolicy {:updateAutoLearnPolicy boolean},
   :labelFingerprint string,
   :serviceAccounts [{:email string, :scopes [string]}],
   :minCpuPlatform string}
  
  Creates an instance resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setMachineResources
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setMachineResources"
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

(defn testIamPermissions$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/testIamPermissions
  
  Required parameters: project, resource, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{resource}/testIamPermissions"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/reset
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Performs a reset on the instance. This is a hard reset the VM does not do a graceful shutdown. For more information, see Resetting an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/reset"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setLabels
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setLabels"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves aggregated list of all of the instances in your project across all regions and zones."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/instances"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/updateNetworkInterface
  
  Required parameters: instance, networkInterface, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:accessConfigs [{:kind string,
                    :name string,
                    :natIP string,
                    :networkTier string,
                    :publicPtrDomainName string,
                    :setPublicPtr boolean,
                    :type string}],
   :name string,
   :aliasIpRanges [{:ipCidrRange string, :subnetworkRangeName string}],
   :ipv6Address string,
   :kind string,
   :network string,
   :networkIP string,
   :fingerprint string,
   :subnetwork string}
  
  Updates an instance's network interface. This method follows PATCH semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instance :zone :networkInterface :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/updateNetworkInterface"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/removeResourcePolicies
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/removeResourcePolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/updateShieldedInstanceConfig
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:enableIntegrityMonitoring boolean,
   :enableSecureBoot boolean,
   :enableVtpm boolean}
  
  Updates the Shielded Instance config for an instance. You can only use this method on a stopped instance. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/updateShieldedInstanceConfig"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/start
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/start"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/addAccessConfig
  
  Required parameters: instance, networkInterface, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:kind string,
   :name string,
   :natIP string,
   :networkTier string,
   :publicPtrDomainName string,
   :setPublicPtr boolean,
   :type string}
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/addAccessConfig"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setDeletionProtection
  
  Required parameters: project, resource, zone
  
  Optional parameters: deletionProtection, requestId
  
  Sets deletion protection on the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{resource}/setDeletionProtection"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/update
  
  Required parameters: instance, project, zone
  
  Optional parameters: minimalAction, mostDisruptiveAllowedAction, requestId
  
  Body: 
  
  {:description string,
   :tags {:fingerprint string, :items [string]},
   :labels {},
   :startRestricted boolean,
   :shieldedInstanceConfig {:enableIntegrityMonitoring boolean,
                            :enableSecureBoot boolean,
                            :enableVtpm boolean},
   :scheduling {:automaticRestart boolean,
                :minNodeCpus integer,
                :nodeAffinities [SchedulingNodeAffinity],
                :onHostMaintenance string,
                :preemptible boolean},
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
   :status string,
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
   :reservationAffinity {:consumeReservationType string,
                         :key string,
                         :values [string]},
   :networkInterfaces [{:accessConfigs [AccessConfig],
                        :name string,
                        :aliasIpRanges [AliasIpRange],
                        :ipv6Address string,
                        :kind string,
                        :network string,
                        :networkIP string,
                        :fingerprint string,
                        :subnetwork string}],
   :deletionProtection boolean,
   :metadata {:fingerprint string,
              :items [{:key string, :value string}],
              :kind string},
   :fingerprint string,
   :shieldedInstanceIntegrityPolicy {:updateAutoLearnPolicy boolean},
   :labelFingerprint string,
   :serviceAccounts [{:email string, :scopes [string]}],
   :minCpuPlatform string}
  
  Updates an instance only if the necessary resources are available. This method can update only a specific set of instance properties. See  Updating a running instance for a list of updatable instance properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/delete
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified Instance resource. For more information, see Stopping or Deleting an Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setDiskAutoDelete
  
  Required parameters: autoDelete, deviceName, instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setDiskAutoDelete"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/getIamPolicy
  
  Required parameters: project, resource, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{resource}/getIamPolicy"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/getShieldedInstanceIdentity
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/getShieldedInstanceIdentity"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/listReferrers
  
  Required parameters: instance, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of resources that refer to the VM instance specified in the request. For example, if the VM instance is part of a managed or unmanaged instance group, the referrers list includes the instance group. For more information, read Viewing referrers to VM instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/referrers"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/detachDisk
  
  Required parameters: deviceName, instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/detachDisk"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setServiceAccount
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setServiceAccount"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/getSerialPortOutput
  
  Required parameters: instance, project, zone
  
  Optional parameters: port, start
  
  Returns the last 1 MB of serial port output from the specified instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/serialPort"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/stop
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/stop"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setMinCpuPlatform
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setMinCpuPlatform"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/addResourcePolicies
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/addResourcePolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of instances contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/getGuestAttributes
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/getGuestAttributes"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/updateDisplayDevice
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/updateDisplayDevice"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setScheduling
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:automaticRestart boolean,
   :minNodeCpus integer,
   :nodeAffinities [{:key string, :operator string, :values [string]}],
   :onHostMaintenance string,
   :preemptible boolean}
  
  Sets an instance's scheduling options. You can only call this method on a stopped instance, that is, a VM instance that is in a `TERMINATED` state. See Instance Life Cycle for more information on the possible instance states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setScheduling"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/simulateMaintenanceEvent
  
  Required parameters: instance, project, zone
  
  Optional parameters: none
  
  Simulates a maintenance event on the instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/simulateMaintenanceEvent"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/attachDisk
  
  Required parameters: instance, project, zone
  
  Optional parameters: forceAttach, requestId
  
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
                      :diskName string},
   :diskSizeGb string,
   :diskEncryptionKey {:kmsKeyName string,
                       :kmsKeyServiceAccount string,
                       :rawKey string,
                       :sha256 string},
   :shieldedInstanceInitialState {:dbs [FileContentBuffer],
                                  :dbxs [FileContentBuffer],
                                  :keks [FileContentBuffer],
                                  :pk FileContentBuffer}}
  
  Attaches an existing Disk resource to an instance. You must first create the disk before you can attach it. It is not possible to create and attach a disk at the same time. For more information, read Adding a persistent disk to your instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/attachDisk"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setMetadata
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:fingerprint string,
   :items [{:key string, :value string}],
   :kind string}
  
  Sets metadata for the specified instance to the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setMetadata"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setShieldedInstanceIntegrityPolicy
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setShieldedInstanceIntegrityPolicy"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setMachineType
  
  Required parameters: instance, project, zone
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setMachineType"
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

(defn setTags$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instances/setTags
  
  Required parameters: instance, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:fingerprint string, :items [string]}
  
  Sets network tags for the specified instance to the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instances/{instance}/setTags"
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
