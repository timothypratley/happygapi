(ns happygapi.notebooks.projects
  "Notebooks API: projects.
  Notebooks API is used to manage notebook resources in Google Cloud.
  See: https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}/locations"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}/operations"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/operations/cancel
  
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
     "https://notebooks.googleapis.com/"
     "v2/{+name}:cancel"
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

(defn locations-instances-rollback$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetSnapshot string, :revisionId string}
  
  Rollbacks a notebook instance to the previous version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:rollback"
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

(defn locations-instances-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-setIamPolicy$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/setIamPolicy
  
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
     "https://notebooks.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
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

(defn locations-instances-patch$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :gceSetup {:gpuDriverConfig GPUDriverConfig,
              :tags [string],
              :shieldedInstanceConfig ShieldedInstanceConfig,
              :bootDisk BootDisk,
              :acceleratorConfigs [AcceleratorConfig],
              :containerImage ContainerImage,
              :disablePublicIp boolean,
              :machineType string,
              :vmImage VmImage,
              :dataDisks [DataDisk],
              :networkInterfaces [NetworkInterface],
              :enableIpForwarding boolean,
              :metadata {},
              :serviceAccounts [ServiceAccount]},
   :creator string,
   :proxyUri string,
   :thirdPartyProxyUrl string,
   :name string,
   :createTime string,
   :state string,
   :disableProxyAccess boolean,
   :updateTime string,
   :id string,
   :healthState string,
   :upgradeHistory [{:containerImage string,
                     :createTime string,
                     :targetVersion string,
                     :state string,
                     :vmImage string,
                     :snapshot string,
                     :action string,
                     :version string,
                     :framework string}],
   :healthInfo {},
   :instanceOwners [string]}
  
  UpdateInstance updates an Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
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

(defn locations-instances-testIamPermissions$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/testIamPermissions
  
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
     "https://notebooks.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
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

(defn locations-instances-reset$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets a notebook instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:reset"
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

(defn locations-instances-create$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId, requestId
  
  Body: 
  
  {:labels {},
   :gceSetup {:gpuDriverConfig GPUDriverConfig,
              :tags [string],
              :shieldedInstanceConfig ShieldedInstanceConfig,
              :bootDisk BootDisk,
              :acceleratorConfigs [AcceleratorConfig],
              :containerImage ContainerImage,
              :disablePublicIp boolean,
              :machineType string,
              :vmImage VmImage,
              :dataDisks [DataDisk],
              :networkInterfaces [NetworkInterface],
              :enableIpForwarding boolean,
              :metadata {},
              :serviceAccounts [ServiceAccount]},
   :creator string,
   :proxyUri string,
   :thirdPartyProxyUrl string,
   :name string,
   :createTime string,
   :state string,
   :disableProxyAccess boolean,
   :updateTime string,
   :id string,
   :healthState string,
   :upgradeHistory [{:containerImage string,
                     :createTime string,
                     :targetVersion string,
                     :state string,
                     :vmImage string,
                     :snapshot string,
                     :action string,
                     :version string,
                     :framework string}],
   :healthInfo {},
   :instanceOwners [string]}
  
  Creates a new Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+parent}/instances"
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

(defn locations-instances-resizeDisk$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/resizeDisk
  
  Required parameters: notebookInstance
  
  Optional parameters: none
  
  Body: 
  
  {:bootDisk {:diskSizeGb string,
              :diskType string,
              :diskEncryption string,
              :kmsKey string},
   :dataDisk {:diskSizeGb string,
              :diskType string,
              :diskEncryption string,
              :kmsKey string}}
  
  Resize a notebook instance disk to a higher capacity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:notebookInstance})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+notebookInstance}:resizeDisk"
     #{:notebookInstance}
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

(defn locations-instances-start$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a notebook instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:start"
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

(defn locations-instances-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-diagnose$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/diagnose
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:diagnosticConfig {:gcsBucket string,
                      :relativePath string,
                      :enableRepairFlag boolean,
                      :enablePacketCaptureFlag boolean,
                      :enableCopyHomeFilesFlag boolean},
   :timeoutMinutes integer}
  
  Creates a Diagnostic File and runs Diagnostic Tool given an Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:diagnose"
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

(defn locations-instances-getIamPolicy$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-upgrade$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/upgrade
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Upgrades a notebook instance to the latest version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:upgrade"
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

(defn locations-instances-checkUpgradability$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/checkUpgradability
  
  Required parameters: notebookInstance
  
  Optional parameters: none
  
  Checks whether a notebook instance is upgradable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:notebookInstance})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+notebookInstance}:checkUpgradability"
     #{:notebookInstance}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-getConfig$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets general backend configurations that might also affect the frontend. Location is required by CCFE. Although we could bypass it to send location- less request directly to the backend job, we would need CPE (go/cloud-cpe). Having the location might also be useful depending on the query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}/instances:getConfig"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-stop$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a notebook instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:stop"
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

(defn locations-instances-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists instances in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-reportInfoSystem$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/reportInfoSystem
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:vmId string, :event {:reportTime string, :type string, :details {}}}
  
  Allows notebook instances to report their latest instance information to the Notebooks API server. The server will merge the reported information to the instance metadata store. Do not use this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:reportInfoSystem"
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

(defn locations-instances-upgradeSystem$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v2/projects/locations/instances/upgradeSystem
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:vmId string}
  
  Allows notebook instances to upgrade themselves. Do not use this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v2/{+name}:upgradeSystem"
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
