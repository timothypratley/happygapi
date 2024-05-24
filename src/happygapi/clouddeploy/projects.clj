(ns happygapi.clouddeploy.projects
  "Cloud Deploy API: projects.
  
  See: https://cloud.google.com/deploy/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getConfig$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the configuration for a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single DeliveryPipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-setIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-patch$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, allowMissing, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :suspended boolean,
   :updateTime string,
   :condition {:pipelineReadyCondition PipelineReadyCondition,
               :targetsPresentCondition TargetsPresentCondition,
               :targetsTypeCondition TargetsTypeCondition},
   :annotations {},
   :serialPipeline {:stages [Stage]}}
  
  Updates the parameters of a single DeliveryPipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-testIamPermissions$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/testIamPermissions
  
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
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/create
  
  Required parameters: parent
  
  Optional parameters: deliveryPipelineId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :suspended boolean,
   :updateTime string,
   :condition {:pipelineReadyCondition PipelineReadyCondition,
               :targetsPresentCondition TargetsPresentCondition,
               :targetsTypeCondition TargetsTypeCondition},
   :annotations {},
   :serialPipeline {:stages [Stage]}}
  
  Creates a new DeliveryPipeline in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/deliveryPipelines"
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

(defn locations-deliveryPipelines-delete$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/delete
  
  Required parameters: name
  
  Optional parameters: requestId, allowMissing, validateOnly, force, etag
  
  Deletes a single DeliveryPipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-getIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-rollbackTarget$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/rollbackTarget
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetId string,
   :rolloutId string,
   :releaseId string,
   :rolloutToRollBack string,
   :rollbackConfig {:rollout Rollout, :startingPhaseId string},
   :validateOnly boolean}
  
  Creates a `Rollout` to roll back the specified target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+name}:rollbackTarget"
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

(defn locations-deliveryPipelines-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists DeliveryPipelines in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/deliveryPipelines"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-releases-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Releases in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/releases"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-releases-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Release."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-releases-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/create
  
  Required parameters: parent
  
  Optional parameters: releaseId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :targetRenders {},
   :buildArtifacts [{:image string, :tag string}],
   :abandoned boolean,
   :renderEndTime string,
   :uid string,
   :name string,
   :customTargetTypeSnapshots [{:description string,
                                :labels {},
                                :uid string,
                                :name string,
                                :createTime string,
                                :etag string,
                                :updateTime string,
                                :customActions CustomTargetSkaffoldActions,
                                :customTargetTypeId string,
                                :annotations {}}],
   :createTime string,
   :etag string,
   :targetArtifacts {},
   :renderStartTime string,
   :skaffoldVersion string,
   :targetSnapshots [{:description string,
                      :labels {},
                      :run CloudRunLocation,
                      :multiTarget MultiTarget,
                      :uid string,
                      :name string,
                      :targetId string,
                      :createTime string,
                      :customTarget CustomTarget,
                      :etag string,
                      :requireApproval boolean,
                      :updateTime string,
                      :gke GkeCluster,
                      :executionConfigs [ExecutionConfig],
                      :annotations {},
                      :anthosCluster AnthosCluster,
                      :deployParameters {}}],
   :condition {:releaseReadyCondition ReleaseReadyCondition,
               :skaffoldSupportedCondition SkaffoldSupportedCondition},
   :skaffoldConfigUri string,
   :annotations {},
   :deliveryPipelineSnapshot {:description string,
                              :labels {},
                              :uid string,
                              :name string,
                              :createTime string,
                              :etag string,
                              :suspended boolean,
                              :updateTime string,
                              :condition PipelineCondition,
                              :annotations {},
                              :serialPipeline SerialPipeline},
   :skaffoldConfigPath string,
   :renderState string,
   :deployParameters {}}
  
  Creates a new Release in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/releases"
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

(defn locations-deliveryPipelines-releases-abandon$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/abandon
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Abandons a Release in the Delivery Pipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+name}:abandon"
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

(defn locations-deliveryPipelines-releases-rollouts-approve$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/approve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:approved boolean}
  
  Approves a Rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+name}:approve"
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

(defn locations-deliveryPipelines-releases-rollouts-advance$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/advance
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:phaseId string}
  
  Advances a Rollout in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+name}:advance"
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

(defn locations-deliveryPipelines-releases-rollouts-cancel$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a Rollout in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-releases-rollouts-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Rollouts in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/rollouts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-releases-rollouts-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-releases-rollouts-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/create
  
  Required parameters: parent
  
  Optional parameters: rolloutId, requestId, validateOnly, startingPhaseId
  
  Body: 
  
  {:description string,
   :deployingBuild string,
   :rolledBackByRollouts [string],
   :labels {},
   :rollbackOfRollout string,
   :approveTime string,
   :uid string,
   :name string,
   :targetId string,
   :createTime string,
   :controllerRollout string,
   :etag string,
   :state string,
   :deployStartTime string,
   :deployEndTime string,
   :phases [{:id string,
             :state string,
             :skipMessage string,
             :deploymentJobs DeploymentJobs,
             :childRolloutJobs ChildRolloutJobs}],
   :annotations {},
   :enqueueTime string,
   :approvalState string,
   :failureReason string,
   :deployFailureCause string,
   :metadata {:cloudRun CloudRunMetadata,
              :automation AutomationRolloutMetadata,
              :custom CustomMetadata}}
  
  Creates a new Rollout in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/rollouts"
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

(defn locations-deliveryPipelines-releases-rollouts-ignoreJob$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/ignoreJob
  
  Required parameters: rollout
  
  Optional parameters: none
  
  Body: 
  
  {:phaseId string, :jobId string}
  
  Ignores the specified Job in a Rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:rollout})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+rollout}:ignoreJob"
     #{:rollout}
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

(defn locations-deliveryPipelines-releases-rollouts-retryJob$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/retryJob
  
  Required parameters: rollout
  
  Optional parameters: none
  
  Body: 
  
  {:phaseId string, :jobId string}
  
  Retries the specified Job in a Rollout."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:rollout})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+rollout}:retryJob"
     #{:rollout}
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

(defn locations-deliveryPipelines-releases-rollouts-jobRuns-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/jobRuns/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists JobRuns in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/jobRuns"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-releases-rollouts-jobRuns-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/jobRuns/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single JobRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-releases-rollouts-jobRuns-terminate$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/releases/rollouts/jobRuns/terminate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Terminates a Job Run in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+name}:terminate"
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

(defn locations-deliveryPipelines-automations-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automations/create
  
  Required parameters: parent
  
  Optional parameters: automationId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :selector {:targets [TargetAttribute]},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :rules [{:promoteReleaseRule PromoteReleaseRule,
            :advanceRolloutRule AdvanceRolloutRule,
            :repairRolloutRule RepairRolloutRule}],
   :suspended boolean,
   :updateTime string,
   :annotations {}}
  
  Creates a new Automation in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/automations"
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

(defn locations-deliveryPipelines-automations-patch$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, allowMissing, validateOnly
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :selector {:targets [TargetAttribute]},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :rules [{:promoteReleaseRule PromoteReleaseRule,
            :advanceRolloutRule AdvanceRolloutRule,
            :repairRolloutRule RepairRolloutRule}],
   :suspended boolean,
   :updateTime string,
   :annotations {}}
  
  Updates the parameters of a single Automation resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-automations-delete$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automations/delete
  
  Required parameters: name
  
  Optional parameters: requestId, allowMissing, validateOnly, etag
  
  Deletes a single Automation resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-automations-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Automation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-automations-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Automations in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/automations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-automationRuns-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automationRuns/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single AutomationRun."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-deliveryPipelines-automationRuns-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automationRuns/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists AutomationRuns in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/automationRuns"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deliveryPipelines-automationRuns-cancel$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/deliveryPipelines/automationRuns/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels an AutomationRun. The `state` of the `AutomationRun` after cancelling is `CANCELLED`. `CancelAutomationRun` can be called on AutomationRun in the state `IN_PROGRESS` and `PENDING`; AutomationRun in a different state returns an `FAILED_PRECONDITION` error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Targets in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/targets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-targets-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/create
  
  Required parameters: parent
  
  Optional parameters: targetId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :run {:location string},
   :multiTarget {:targetIds [string]},
   :uid string,
   :name string,
   :targetId string,
   :createTime string,
   :customTarget {:customTargetType string},
   :etag string,
   :requireApproval boolean,
   :updateTime string,
   :gke {:cluster string, :internalIp boolean},
   :executionConfigs [{:usages [string],
                       :defaultPool DefaultPool,
                       :privatePool PrivatePool,
                       :workerPool string,
                       :serviceAccount string,
                       :artifactStorage string,
                       :executionTimeout string,
                       :verbose boolean}],
   :annotations {},
   :anthosCluster {:membership string},
   :deployParameters {}}
  
  Creates a new Target in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/targets"
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

(defn locations-targets-patch$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, allowMissing, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :run {:location string},
   :multiTarget {:targetIds [string]},
   :uid string,
   :name string,
   :targetId string,
   :createTime string,
   :customTarget {:customTargetType string},
   :etag string,
   :requireApproval boolean,
   :updateTime string,
   :gke {:cluster string, :internalIp boolean},
   :executionConfigs [{:usages [string],
                       :defaultPool DefaultPool,
                       :privatePool PrivatePool,
                       :workerPool string,
                       :serviceAccount string,
                       :artifactStorage string,
                       :executionTimeout string,
                       :verbose boolean}],
   :annotations {},
   :anthosCluster {:membership string},
   :deployParameters {}}
  
  Updates the parameters of a single Target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-delete$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/delete
  
  Required parameters: name
  
  Optional parameters: requestId, allowMissing, validateOnly, etag
  
  Deletes a single Target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-setIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-getIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-targets-testIamPermissions$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/targets/testIamPermissions
  
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
     "https://clouddeploy.googleapis.com/"
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

(defn locations-customTargetTypes-list$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists CustomTargetTypes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/customTargetTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-customTargetTypes-get$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single CustomTargetType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-customTargetTypes-create$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/create
  
  Required parameters: parent
  
  Optional parameters: customTargetTypeId, requestId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :customActions {:renderAction string,
                   :deployAction string,
                   :includeSkaffoldModules [SkaffoldModules]},
   :customTargetTypeId string,
   :annotations {}}
  
  Creates a new CustomTargetType in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
     "v1/{+parent}/customTargetTypes"
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

(defn locations-customTargetTypes-patch$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, allowMissing, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :customActions {:renderAction string,
                   :deployAction string,
                   :includeSkaffoldModules [SkaffoldModules]},
   :customTargetTypeId string,
   :annotations {}}
  
  Updates a single CustomTargetType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-customTargetTypes-delete$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/delete
  
  Required parameters: name
  
  Optional parameters: requestId, allowMissing, validateOnly, etag
  
  Deletes a single CustomTargetType."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-customTargetTypes-setIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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

(defn locations-customTargetTypes-getIamPolicy$
  "https://cloud.google.com/deploy/api/reference/rest/v1/projects/locations/customTargetTypes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://clouddeploy.googleapis.com/"
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
