(ns happygapi.compute.regionInstanceGroupManagers
  "Compute Engine API: regionInstanceGroupManagers.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionInstanceGroupManagers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listManagedInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/listManagedInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the instances in the managed instance group and instances that are scheduled to be created. The list includes any current actions that the group has scheduled for its instances. The orderBy query parameter is not supported. The `pageToken` query parameter is supported only if the group's `listManagedInstancesResults` field is set to `PAGINATED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances"
     #{:instanceGroupManager :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setInstanceTemplate$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/setInstanceTemplate
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instanceTemplate string}
  
  Sets the instance template to use when creating new instances or recreating instances in this group. Existing instances are not affected."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate"
     #{:instanceGroupManager :region :project}
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

(defn listErrors$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/listErrors
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all errors thrown by actions on instances for a given regional managed instance group. The filter and orderBy query parameters are not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listErrors"
     #{:instanceGroupManager :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/get
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: none
  
  Returns all of the details about the specified managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}"
     #{:instanceGroupManager :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:type string,
                  :instanceRedistributionType string,
                  :minimalAction string,
                  :mostDisruptiveAllowedAction string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :replacementMethod string},
   :instanceLifecyclePolicy {:forceUpdateOnRepair string,
                             :defaultActionOnFailure string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :starting integer,
                    :creating integer,
                    :deleting integer,
                    :stopping integer,
                    :suspending integer,
                    :refreshing integer,
                    :abandoning integer,
                    :resuming integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :listManagedInstancesResults string,
   :status {:isStable boolean,
            :allInstancesConfig InstanceGroupManagerStatusAllInstancesConfig,
            :versionTarget InstanceGroupManagerStatusVersionTarget,
            :stateful InstanceGroupManagerStatusStateful,
            :autoscaler string},
   :instanceGroup string,
   :id string,
   :kind string,
   :allInstancesConfig {:properties InstancePropertiesPatch},
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration],
                        :targetShape string},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:name string,
               :instanceTemplate string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Creates a managed instance group using the information that you specify in the request. After the group is created, instances in the group are created using the specified instance template. This operation is marked as DONE when the group is created even if the instances in the group have not yet been created. You must separately verify the status of the individual instances with the listmanagedinstances method. A regional managed instance group can contain up to 2000 instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers"
     #{:region :project}
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

(defn abandonInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/abandonInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified instances to be immediately removed from the managed instance group. Abandoning an instance does not delete the instance, but it does remove the instance from any target pools that are applied by the managed instance group. This method reduces the targetSize of the managed instance group by the number of instances that you abandon. This operation is marked as DONE when the action is scheduled even if the instances have not yet been removed from the group. You must separately verify the status of the abandoning action with the listmanagedinstances method. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/abandonInstances"
     #{:instanceGroupManager :region :project}
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

(defn updatePerInstanceConfigs$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/updatePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:name string,
                         :preservedState PreservedState,
                         :status string,
                         :fingerprint string}]}
  
  Inserts or updates per-instance configurations for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs"
     #{:instanceGroupManager :region :project}
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

(defn recreateInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/recreateInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified VM instances in the managed instance group to be immediately recreated. Each instance is recreated using the group's current configuration. This operation is marked as DONE when the flag is set even if the instances have not yet been recreated. You must separately verify the status of each instance by checking its currentAction field; for more information, see Checking the status of managed instances. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/recreateInstances"
     #{:instanceGroupManager :region :project}
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

(defn applyUpdatesToInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/applyUpdatesToInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: none
  
  Body: 
  
  {:instances [string],
   :minimalAction string,
   :mostDisruptiveAllowedAction string,
   :allInstances boolean}
  
  Apply updates to selected instances the managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances"
     #{:instanceGroupManager :region :project}
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/patch
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:type string,
                  :instanceRedistributionType string,
                  :minimalAction string,
                  :mostDisruptiveAllowedAction string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :replacementMethod string},
   :instanceLifecyclePolicy {:forceUpdateOnRepair string,
                             :defaultActionOnFailure string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :starting integer,
                    :creating integer,
                    :deleting integer,
                    :stopping integer,
                    :suspending integer,
                    :refreshing integer,
                    :abandoning integer,
                    :resuming integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :listManagedInstancesResults string,
   :status {:isStable boolean,
            :allInstancesConfig InstanceGroupManagerStatusAllInstancesConfig,
            :versionTarget InstanceGroupManagerStatusVersionTarget,
            :stateful InstanceGroupManagerStatusStateful,
            :autoscaler string},
   :instanceGroup string,
   :id string,
   :kind string,
   :allInstancesConfig {:properties InstancePropertiesPatch},
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration],
                        :targetShape string},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:name string,
               :instanceTemplate string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Updates a managed instance group using the information that you specify in the request. This operation is marked as DONE when the group is patched even if the instances in the group are still in the process of being patched. You must separately verify the status of the individual instances with the listmanagedinstances method. This method supports PATCH semantics and uses the JSON merge patch format and processing rules. If you update your group to specify a new template or instance configuration, it's possible that your intended specification for each VM in the group is different from the current state of that VM. To learn how to apply an updated configuration to the VMs in a MIG, see Updating instances in a MIG."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}"
     #{:instanceGroupManager :region :project}
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

(defn deletePerInstanceConfigs$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/deletePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes selected per-instance configurations for the managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs"
     #{:instanceGroupManager :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/delete
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Deletes the specified managed instance group and all of the instances in that group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}"
     #{:instanceGroupManager :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/resize
  
  Required parameters: instanceGroupManager, project, region, size
  
  Optional parameters: requestId
  
  Changes the intended size of the managed instance group. If you increase the size, the group creates new instances using the current instance template. If you decrease the size, the group deletes one or more instances. The resize operation is marked DONE if the resize request is successful. The underlying actions take additional time. You must separately verify the status of the creating or deleting actions with the listmanagedinstances method. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :size :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/resize"
     #{:instanceGroupManager :size :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listPerInstanceConfigs$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/listPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all of the per-instance configurations defined for the managed instance group. The orderBy query parameter is not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs"
     #{:instanceGroupManager :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setTargetPools$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/setTargetPools
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:targetPools [string], :fingerprint string}
  
  Modifies the target pools to which all new instances in this group are assigned. Existing instances in the group are not affected."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/setTargetPools"
     #{:instanceGroupManager :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of managed instance groups that are contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchPerInstanceConfigs$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/patchPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:name string,
                         :preservedState PreservedState,
                         :status string,
                         :fingerprint string}]}
  
  Inserts or patches per-instance configurations for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs"
     #{:instanceGroupManager :region :project}
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

(defn createInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/createInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:name string,
                :preservedState PreservedState,
                :status string,
                :fingerprint string}]}
  
  Creates instances with per-instance configurations in this regional managed instance group. Instances are created using the current instance template. The create instances operation is marked DONE if the createInstances request is successful. The underlying actions take additional time. You must separately verify the status of the creating or actions with the listmanagedinstances method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/createInstances"
     #{:instanceGroupManager :region :project}
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

(defn deleteInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroupManagers/deleteInstances
  
  Required parameters: instanceGroupManager, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string], :skipInstancesOnValidationError boolean}
  
  Flags the specified instances in the managed instance group to be immediately deleted. The instances are also removed from any target pools of which they were a member. This method reduces the targetSize of the managed instance group by the number of instances that you delete. The deleteInstances operation is marked DONE if the deleteInstances request is successful. The underlying actions take additional time. You must separately verify the status of the deleting action with the listmanagedinstances method. If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted. You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:instanceGroupManager :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroupManagers/{instanceGroupManager}/deleteInstances"
     #{:instanceGroupManager :region :project}
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
