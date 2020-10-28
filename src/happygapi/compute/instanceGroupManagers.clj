(ns happygapi.compute.instanceGroupManagers
  "Compute Engine API: instanceGroupManagers.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listManagedInstances$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/listManagedInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all of the instances in the managed instance group. Each instance in the list has a currentAction, which indicates the action that the managed instance group is performing on the instance. For example, if the group is still creating an instance, the currentAction is CREATING. If a previous action failed, the list displays the errors for that failed action. The orderBy query parameter is not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listManagedInstances"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setInstanceTemplate$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/setInstanceTemplate
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instanceTemplate string}
  
  Specifies the instance template to use when creating new instances in this group. The templates for existing instances in the group do not change unless you recreate them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setInstanceTemplate"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/listErrors
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all errors thrown by actions on instances for a given managed instance group. The filter and orderBy query parameters are not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listErrors"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/get
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Returns all of the details about the specified managed instance group. Gets a list of available managed instance groups by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:instanceRedistributionType string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :minimalAction string,
                  :replacementMethod string,
                  :type string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :creating integer,
                    :deleting integer,
                    :refreshing integer,
                    :abandoning integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :status {:autoscaler string,
            :isStable boolean,
            :stateful InstanceGroupManagerStatusStateful,
            :versionTarget InstanceGroupManagerStatusVersionTarget},
   :instanceGroup string,
   :id string,
   :kind string,
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration]},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:instanceTemplate string,
               :name string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Creates a managed instance group using the information that you specify in the request. After the group is created, instances in the group are created using the specified instance template. This operation is marked as DONE when the group is created even if the instances in the group have not yet been created. You must separately verify the status of the individual instances with the listmanagedinstances method.
  
  A managed instance group can have up to 1000 VM instances per group. Please contact Cloud Support if you need an increase in this limit."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers"
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

(defn abandonInstances$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/abandonInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified instances to be removed from the managed instance group. Abandoning an instance does not delete the instance, but it does remove the instance from any target pools that are applied by the managed instance group. This method reduces the targetSize of the managed instance group by the number of instances that you abandon. This operation is marked as DONE when the action is scheduled even if the instances have not yet been removed from the group. You must separately verify the status of the abandoning action with the listmanagedinstances method.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted.
  
  You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/abandonInstances"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/updatePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:fingerprint string,
                         :name string,
                         :preservedState PreservedState,
                         :status string}]}
  
  Inserts or updates per-instance configs for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/updatePerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/recreateInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified instances in the managed instance group to be immediately recreated. The instances are deleted and recreated using the current instance template for the managed instance group. This operation is marked as DONE when the flag is set even if the instances have not yet been recreated. You must separately verify the status of the recreating action with the listmanagedinstances method.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted.
  
  You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/recreateInstances"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/applyUpdatesToInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Body: 
  
  {:allInstances boolean,
   :instances [string],
   :minimalAction string,
   :mostDisruptiveAllowedAction string}
  
  Applies changes to selected instances on the managed instance group. This method can be used to apply new overrides and/or new versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/applyUpdatesToInstances"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/patch
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :updatePolicy {:instanceRedistributionType string,
                  :maxSurge FixedOrPercent,
                  :maxUnavailable FixedOrPercent,
                  :minimalAction string,
                  :replacementMethod string,
                  :type string},
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :targetPools [string],
   :region string,
   :currentActions {:recreating integer,
                    :restarting integer,
                    :creating integer,
                    :deleting integer,
                    :refreshing integer,
                    :abandoning integer,
                    :verifying integer,
                    :none integer,
                    :creatingWithoutRetries integer},
   :autoHealingPolicies [{:healthCheck string, :initialDelaySec integer}],
   :status {:autoscaler string,
            :isStable boolean,
            :stateful InstanceGroupManagerStatusStateful,
            :versionTarget InstanceGroupManagerStatusVersionTarget},
   :instanceGroup string,
   :id string,
   :kind string,
   :distributionPolicy {:zones [DistributionPolicyZoneConfiguration]},
   :statefulPolicy {:preservedState StatefulPolicyPreservedState},
   :baseInstanceName string,
   :versions [{:instanceTemplate string,
               :name string,
               :targetSize FixedOrPercent}],
   :targetSize integer,
   :instanceTemplate string,
   :fingerprint string,
   :namedPorts [{:name string, :port integer}]}
  
  Updates a managed instance group using the information that you specify in the request. This operation is marked as DONE when the group is patched even if the instances in the group are still in the process of being patched. You must separately verify the status of the individual instances with the listManagedInstances method. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of managed instance groups and groups them by zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/instanceGroupManagers"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deletePerInstanceConfigs$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/deletePerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: none
  
  Body: 
  
  {:names [string]}
  
  Deletes selected per-instance configs for the managed instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deletePerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/delete
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified managed instance group and all of the instances in that group. Note that the instance group must not belong to a backend service. Read  Deleting an instance group for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/resize
  
  Required parameters: instanceGroupManager, project, size, zone
  
  Optional parameters: requestId
  
  Resizes the managed instance group. If you increase the size, the group creates new instances using the current instance template. If you decrease the size, the group deletes instances. The resize operation is marked DONE when the resize actions are scheduled even if the group has not yet added or deleted any instances. You must separately verify the status of the creating or deleting actions with the listmanagedinstances method.
  
  When resizing down, the instance group arbitrarily chooses the order in which VMs are deleted. The group takes into account some VM attributes when making the selection including:
  
  + The status of the VM instance. + The health of the VM instance. + The instance template version the VM is based on. + For regional managed instance groups, the location of the VM instance.
  
  This list is subject to change.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :size :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/resize"
     #{:zone :instanceGroupManager :size :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listPerInstanceConfigs$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/listPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists all of the per-instance configs defined for the managed instance group. The orderBy query parameter is not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/listPerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setTargetPools$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/setTargetPools
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:fingerprint string, :targetPools [string]}
  
  Modifies the target pools to which all instances in this managed instance group are assigned. The target pools automatically apply to all of the instances in the managed instance group. This operation is marked DONE when you make the request even if the instances have not yet been added to their target pools. The change might take some time to apply to all of the instances in the group depending on the size of the group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/setTargetPools"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of managed instance groups that are contained within the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchPerInstanceConfigs$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/patchPerInstanceConfigs
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:perInstanceConfigs [{:fingerprint string,
                         :name string,
                         :preservedState PreservedState,
                         :status string}]}
  
  Inserts or patches per-instance configs for the managed instance group. perInstanceConfig.name serves as a key used to distinguish whether to perform insert or patch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/patchPerInstanceConfigs"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/createInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:fingerprint string,
                :name string,
                :preservedState PreservedState,
                :status string}]}
  
  Creates instances with per-instance configs in this managed instance group. Instances are created using the current instance template. The create instances operation is marked DONE if the createInstances request is successful. The underlying actions take additional time. You must separately verify the status of the creating or actions with the listmanagedinstances method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/createInstances"
     #{:zone :instanceGroupManager :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroupManagers/deleteInstances
  
  Required parameters: instanceGroupManager, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [string]}
  
  Flags the specified instances in the managed instance group for immediate deletion. The instances are also removed from any target pools of which they were a member. This method reduces the targetSize of the managed instance group by the number of instances that you delete. This operation is marked as DONE when the action is scheduled even if the instances are still being deleted. You must separately verify the status of the deleting action with the listmanagedinstances method.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration has elapsed before the VM instance is removed or deleted.
  
  You can specify a maximum of 1000 instances with this method per request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :instanceGroupManager :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroupManagers/{instanceGroupManager}/deleteInstances"
     #{:zone :instanceGroupManager :project}
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
