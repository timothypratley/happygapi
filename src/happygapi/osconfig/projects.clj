(ns happygapi.osconfig.projects
  "OS Config API: projects.
  OS management tools that can be used for patch management, patch compliance, and configuration management on VM instances.
  See: https://cloud.google.com/compute/docs/osconfig/restdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-global-getProjectFeatureSettings$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/global/getProjectFeatureSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  GetProjectFeatureSettings returns the VM Manager feature settings for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-global-updateProjectFeatureSettings$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/global/updateProjectFeatureSettings
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :patchAndConfigFeatureSet string}
  
  UpdateProjectFeatureSettings sets the VM Manager features for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-osPolicyAssignments-create$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/create
  
  Required parameters: parent
  
  Optional parameters: osPolicyAssignmentId, requestId
  
  Body: 
  
  {:description string,
   :baseline boolean,
   :deleted boolean,
   :rolloutState string,
   :revisionCreateTime string,
   :uid string,
   :name string,
   :revisionId string,
   :osPolicies [{:id string,
                 :description string,
                 :mode string,
                 :resourceGroups [OSPolicyResourceGroup],
                 :allowNoResourceGroupMatch boolean}],
   :etag string,
   :reconciling boolean,
   :rollout {:disruptionBudget FixedOrPercent, :minWaitDuration string},
   :instanceFilter {:all boolean,
                    :inclusionLabels [OSPolicyAssignmentLabelSet],
                    :exclusionLabels [OSPolicyAssignmentLabelSet],
                    :inventories [OSPolicyAssignmentInstanceFilterInventory]}}
  
  Create an OS policy assignment. This method also creates the first revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/osPolicyAssignments"
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

(defn locations-osPolicyAssignments-patch$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing, requestId
  
  Body: 
  
  {:description string,
   :baseline boolean,
   :deleted boolean,
   :rolloutState string,
   :revisionCreateTime string,
   :uid string,
   :name string,
   :revisionId string,
   :osPolicies [{:id string,
                 :description string,
                 :mode string,
                 :resourceGroups [OSPolicyResourceGroup],
                 :allowNoResourceGroupMatch boolean}],
   :etag string,
   :reconciling boolean,
   :rollout {:disruptionBudget FixedOrPercent, :minWaitDuration string},
   :instanceFilter {:all boolean,
                    :inclusionLabels [OSPolicyAssignmentLabelSet],
                    :exclusionLabels [OSPolicyAssignmentLabelSet],
                    :inventories [OSPolicyAssignmentInstanceFilterInventory]}}
  
  Update an existing OS policy assignment. This method creates a new revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-osPolicyAssignments-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve an existing OS policy assignment. This method always returns the latest revision. In order to retrieve a previous revision of the assignment, also provide the revision ID in the `name` parameter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-osPolicyAssignments-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the OS policy assignments under the parent resource. For each OS policy assignment, the latest revision is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/osPolicyAssignments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-osPolicyAssignments-listRevisions$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/listRevisions
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  List the OS policy assignment revisions for a given OS policy assignment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+name}:listRevisions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-osPolicyAssignments-delete$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Delete the OS policy assignment. This method creates a new revision of the OS policy assignment. This method returns a long running operation (LRO) that contains the rollout details. The rollout can be cancelled by cancelling the LRO. If the LRO completes and is not cancelled, all revisions associated with the OS policy assignment are deleted. For more information, see [Method: projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1/projects.locations.osPolicyAssignments.operations/cancel)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-osPolicyAssignments-operations-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-osPolicyAssignments-operations-cancel$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/osPolicyAssignments/operations/cancel
  
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
     "https://osconfig.googleapis.com/"
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

(defn locations-instances-osPolicyAssignments-reports-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/osPolicyAssignments/reports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the OS policy assignment report for the specified Compute Engine VM instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-instances-osPolicyAssignments-reports-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/osPolicyAssignments/reports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  List OS policy assignment reports for all Compute Engine VM instances in the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/reports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-inventories-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/inventories/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Get inventory data for the specified VM instance. If the VM has no associated inventory, the message `NOT_FOUND` is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-instances-inventories-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/inventories/list
  
  Required parameters: parent
  
  Optional parameters: view, pageSize, pageToken, filter
  
  List inventory data for all VM instances in the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/inventories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-vulnerabilityReports-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/vulnerabilityReports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have vulnerability reports associated with them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn locations-instances-vulnerabilityReports-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/locations/instances/vulnerabilityReports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List vulnerability reports for all VM instances in the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/vulnerabilityReports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchJobs-execute$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchJobs/execute
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :instanceFilter {:all boolean,
                    :groupLabels [PatchInstanceFilterGroupLabel],
                    :zones [string],
                    :instances [string],
                    :instanceNamePrefixes [string]},
   :patchConfig {:windowsUpdate WindowsUpdateSettings,
                 :zypper ZypperSettings,
                 :goo GooSettings,
                 :apt AptSettings,
                 :rebootConfig string,
                 :migInstancesAllowed boolean,
                 :postStep ExecStep,
                 :yum YumSettings,
                 :preStep ExecStep},
   :duration string,
   :dryRun boolean,
   :displayName string,
   :rollout {:mode string, :disruptionBudget FixedOrPercent}}
  
  Patch VM instances by creating and running a patch job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchJobs:execute"
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

(defn patchJobs-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the patch job. This can be used to track the progress of an ongoing patch job or review the details of completed jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchJobs-cancel$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchJobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancel a patch job. The patch job must be active. Canceled patch jobs cannot be restarted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchJobs-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Get a list of patch jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchJobs-instanceDetails-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchJobs/instanceDetails/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Get a list of instance details for a given patch job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/instanceDetails"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchDeployments-create$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/create
  
  Required parameters: parent
  
  Optional parameters: patchDeploymentId
  
  Body: 
  
  {:description string,
   :lastExecuteTime string,
   :name string,
   :patchConfig {:windowsUpdate WindowsUpdateSettings,
                 :zypper ZypperSettings,
                 :goo GooSettings,
                 :apt AptSettings,
                 :rebootConfig string,
                 :migInstancesAllowed boolean,
                 :postStep ExecStep,
                 :yum YumSettings,
                 :preStep ExecStep},
   :createTime string,
   :duration string,
   :state string,
   :updateTime string,
   :recurringSchedule {:timeZone TimeZone,
                       :lastExecuteTime string,
                       :nextExecuteTime string,
                       :startTime string,
                       :endTime string,
                       :frequency string,
                       :monthly MonthlySchedule,
                       :weekly WeeklySchedule,
                       :timeOfDay TimeOfDay},
   :oneTimeSchedule {:executeTime string},
   :rollout {:mode string, :disruptionBudget FixedOrPercent},
   :instanceFilter {:all boolean,
                    :groupLabels [PatchInstanceFilterGroupLabel],
                    :zones [string],
                    :instances [string],
                    :instanceNamePrefixes [string]}}
  
  Create an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchDeployments"
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

(defn patchDeployments-get$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchDeployments-list$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Get a page of OS Config patch deployments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+parent}/patchDeployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patchDeployments-delete$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchDeployments-patch$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :lastExecuteTime string,
   :name string,
   :patchConfig {:windowsUpdate WindowsUpdateSettings,
                 :zypper ZypperSettings,
                 :goo GooSettings,
                 :apt AptSettings,
                 :rebootConfig string,
                 :migInstancesAllowed boolean,
                 :postStep ExecStep,
                 :yum YumSettings,
                 :preStep ExecStep},
   :createTime string,
   :duration string,
   :state string,
   :updateTime string,
   :recurringSchedule {:timeZone TimeZone,
                       :lastExecuteTime string,
                       :nextExecuteTime string,
                       :startTime string,
                       :endTime string,
                       :frequency string,
                       :monthly MonthlySchedule,
                       :weekly WeeklySchedule,
                       :timeOfDay TimeOfDay},
   :oneTimeSchedule {:executeTime string},
   :rollout {:mode string, :disruptionBudget FixedOrPercent},
   :instanceFilter {:all boolean,
                    :groupLabels [PatchInstanceFilterGroupLabel],
                    :zones [string],
                    :instances [string],
                    :instanceNamePrefixes [string]}}
  
  Update an OS Config patch deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://osconfig.googleapis.com/"
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

(defn patchDeployments-pause$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Change state of patch deployment to \"PAUSED\". Patch deployment in paused state doesn't generate patch jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
     "v1/{+name}:pause"
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

(defn patchDeployments-resume$
  "https://cloud.google.com/compute/docs/osconfig/restapi/reference/rest/v1/projects/patchDeployments/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Change state of patch deployment back to \"ACTIVE\". Patch deployment in active state continues to generate patch jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://osconfig.googleapis.com/"
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
