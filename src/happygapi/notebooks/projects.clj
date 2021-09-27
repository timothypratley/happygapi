(ns happygapi.notebooks.projects
  "Notebooks API: projects.
  Notebooks API is used to manage notebook resources in Google Cloud.
  See: https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/get
  
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

(defn locations-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-runtimes-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Runtime. The location must be a regional endpoint rather than zonal."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-runtimes-reset$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resets a Managed Notebook Runtime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:reset"
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

(defn locations-runtimes-create$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/create
  
  Required parameters: parent
  
  Optional parameters: runtimeId
  
  Body: 
  
  {:name string,
   :softwareConfig {:idleShutdown boolean,
                    :enableHealthMonitoring boolean,
                    :notebookUpgradeSchedule string,
                    :installGpuDriver boolean,
                    :customGpuDriverPath string,
                    :idleShutdownTimeout integer,
                    :postStartupScript string},
   :createTime string,
   :state string,
   :updateTime string,
   :virtualMachine {:virtualMachineConfig VirtualMachineConfig,
                    :instanceName string,
                    :instanceId string},
   :healthState string,
   :accessConfig {:proxyUri string,
                  :accessType string,
                  :runtimeOwner string},
   :metrics {:systemMetrics {}}}
  
  Creates a new Runtime in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/runtimes"
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

(defn locations-runtimes-start$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a Managed Notebook Runtime. Perform \"Start\" on GPU instances; \"Resume\" on CPU instances See: https://cloud.google.com/compute/docs/instances/stop-start-instance https://cloud.google.com/compute/docs/instances/suspend-resume-instance"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:start"
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

(defn locations-runtimes-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Runtime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-runtimes-stop$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a Managed Notebook Runtime. Perform \"Stop\" on GPU instances; \"Suspend\" on CPU instances See: https://cloud.google.com/compute/docs/instances/stop-start-instance https://cloud.google.com/compute/docs/instances/suspend-resume-instance"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:stop"
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

(defn locations-runtimes-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists Runtimes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/runtimes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-runtimes-reportEvent$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/reportEvent
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:event {:reportTime string, :type string}, :vmId string}
  
  Report and process a runtime event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:reportEvent"
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

(defn locations-runtimes-switch$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/runtimes/switch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:machineType string,
   :acceleratorConfig {:type string, :coreCount string}}
  
  Switch a Managed Notebook Runtime."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:switch"
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

(defn locations-schedules-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/schedules/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes schedule and all underlying jobs"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-schedules-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/schedules/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of schedule"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-schedules-create$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/schedules/create
  
  Required parameters: parent
  
  Optional parameters: scheduleId
  
  Body: 
  
  {:description string,
   :timeZone string,
   :cronSchedule string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :executionTemplate {:serviceAccount string,
                       :labels {},
                       :dataprocParameters DataprocParameters,
                       :paramsYamlFile string,
                       :vertexAiParameters VertexAIParameters,
                       :containerImageUri string,
                       :inputNotebookFile string,
                       :acceleratorConfig SchedulerAcceleratorConfig,
                       :scaleTier string,
                       :parameters string,
                       :outputNotebookFolder string,
                       :jobType string,
                       :masterType string},
   :recentExecutions [{:description string,
                       :jobUri string,
                       :displayName string,
                       :name string,
                       :createTime string,
                       :state string,
                       :outputNotebookFile string,
                       :updateTime string,
                       :executionTemplate ExecutionTemplate}]}
  
  Creates a new Scheduled Notebook in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/schedules"
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

(defn locations-schedules-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/schedules/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists schedules in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/schedules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-schedules-trigger$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/schedules/trigger
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Triggers execution of an existing schedule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:trigger"
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

(defn locations-executions-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/executions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of executions"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-executions-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/executions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists executions in a given project and location"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-executions-create$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/executions/create
  
  Required parameters: parent
  
  Optional parameters: executionId
  
  Body: 
  
  {:description string,
   :jobUri string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :outputNotebookFile string,
   :updateTime string,
   :executionTemplate {:serviceAccount string,
                       :labels {},
                       :dataprocParameters DataprocParameters,
                       :paramsYamlFile string,
                       :vertexAiParameters VertexAIParameters,
                       :containerImageUri string,
                       :inputNotebookFile string,
                       :acceleratorConfig SchedulerAcceleratorConfig,
                       :scaleTier string,
                       :parameters string,
                       :outputNotebookFolder string,
                       :jobType string,
                       :masterType string}}
  
  Creates a new Execution in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/executions"
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

(defn locations-executions-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/executions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes execution"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-instances-rollback$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetSnapshot string}
  
  Rollbacks a notebook instance to the previous version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-instances-updateConfig$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/updateConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:config {:enableHealthMonitoring boolean,
            :notebookUpgradeSchedule string}}
  
  Update Notebook Instance configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:updateConfig"
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

(defn locations-instances-report$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/report
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:metadata {}, :vmId string}
  
  Allows notebook instances to report their latest instance information to the Notebooks API server. The server will merge the reported information to the instance metadata store. Do not use this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:report"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/get
  
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

(defn locations-instances-setIamPolicy$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/setIamPolicy
  
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

(defn locations-instances-setAccelerator$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/setAccelerator
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:type string, :coreCount string}
  
  Updates the guest accelerators of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:setAccelerator"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/testIamPermissions
  
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

(defn locations-instances-reset$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/reset
  
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
     "v1/{+name}:reset"
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

(defn locations-instances-setLabels$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/setLabels
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {}}
  
  Replaces all the labels of an Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:setLabels"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:serviceAccount string,
   :tags [string],
   :labels {},
   :shieldedInstanceConfig {:enableSecureBoot boolean,
                            :enableVtpm boolean,
                            :enableIntegrityMonitoring boolean},
   :installGpuDriver boolean,
   :bootDiskSizeGb string,
   :diskEncryption string,
   :proxyUri string,
   :serviceAccountScopes [string],
   :containerImage {:tag string, :repository string},
   :name string,
   :nicType string,
   :createTime string,
   :state string,
   :machineType string,
   :vmImage {:project string, :imageName string, :imageFamily string},
   :updateTime string,
   :customGpuDriverPath string,
   :acceleratorConfig {:coreCount string, :type string},
   :noProxyAccess boolean,
   :disks [{:interface string,
            :guestOsFeatures [GuestOsFeature],
            :index string,
            :deviceName string,
            :boot boolean,
            :mode string,
            :licenses [string],
            :type string,
            :source string,
            :autoDelete boolean,
            :kind string,
            :diskSizeGb string}],
   :kmsKey string,
   :postStartupScript string,
   :bootDiskType string,
   :noRemoveDataDisk boolean,
   :reservationAffinity {:consumeReservationType string,
                         :values [string],
                         :key string},
   :network string,
   :dataDiskSizeGb string,
   :noPublicIp boolean,
   :subnet string,
   :upgradeHistory [{:containerImage string,
                     :createTime string,
                     :targetVersion string,
                     :state string,
                     :vmImage string,
                     :snapshot string,
                     :action string,
                     :targetImage string,
                     :version string,
                     :framework string}],
   :dataDiskType string,
   :metadata {},
   :instanceOwners [string]}
  
  Creates a new Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/instances"
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

(defn locations-instances-updateShieldedInstanceConfig$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/updateShieldedInstanceConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:shieldedInstanceConfig {:enableSecureBoot boolean,
                            :enableVtpm boolean,
                            :enableIntegrityMonitoring boolean}}
  
  Updates the Shielded instance configuration of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:updateShieldedInstanceConfig"
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

(defn locations-instances-start$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/start
  
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
     "v1/{+name}:start"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-instances-getIamPolicy$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/getIamPolicy
  
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

(defn locations-instances-upgrade$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/upgrade
  
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
     "v1/{+name}:upgrade"
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

(defn locations-instances-stop$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/stop
  
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
     "v1/{+name}:stop"
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists instances in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-register$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/register
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:instanceId string}
  
  Registers an existing legacy notebook instance to the Notebooks API server. Legacy instances are instances created with the legacy Compute Engine calls. They are not manageable by the Notebooks API out of the box. This call makes these instances manageable by the Notebooks API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/instances:register"
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

(defn locations-instances-upgradeInternal$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/upgradeInternal
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:vmId string}
  
  Allows notebook instances to call this endpoint to upgrade themselves. Do not use this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:upgradeInternal"
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

(defn locations-instances-getInstanceHealth$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/getInstanceHealth
  
  Required parameters: name
  
  Optional parameters: none
  
  Check if a notebook instance is healthy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:getInstanceHealth"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-setMachineType$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/setMachineType
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:machineType string}
  
  Updates the machine type of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+name}:setMachineType"
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

(defn locations-instances-isUpgradeable$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/instances/isUpgradeable
  
  Required parameters: notebookInstance
  
  Optional parameters: none
  
  Check if a notebook instance is upgradable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:notebookInstance})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+notebookInstance}:isUpgradeable"
     #{:notebookInstance}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/operations/get
  
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/operations/delete
  
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
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/operations/cancel
  
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

(defn locations-environments-delete$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-environments-get$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
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

(defn locations-environments-create$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/environments/create
  
  Required parameters: parent
  
  Optional parameters: environmentId
  
  Body: 
  
  {:displayName string,
   :vmImage {:project string, :imageName string, :imageFamily string},
   :containerImage {:tag string, :repository string},
   :description string,
   :name string,
   :postStartupScript string,
   :createTime string}
  
  Creates a new Environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/environments"
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

(defn locations-environments-list$
  "https://cloud.google.com/notebooks/docs/api/reference/rest/v1/projects/locations/environments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists environments in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://notebooks.googleapis.com/"
     "v1/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
