(ns happygapi.run.projects
  "Cloud Run Admin API: projects.
  Deploy and manage user provided container images that scale automatically based on incoming requests. The Cloud Run Admin API v1 follows the Knative Serving API specification, while v2 is aligned with Google Cloud AIP-based API standards, as described in https://google.aip.dev/.
  See: https://cloud.google.com/run/docs/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-exportMetadata$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/exportMetadata
  
  Required parameters: name
  
  Optional parameters: none
  
  Export generated customer metadata for a given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}:exportMetadata"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-exportImageMetadata$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/exportImageMetadata
  
  Required parameters: name
  
  Optional parameters: none
  
  Export image metadata for a given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}:exportImageMetadata"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-exportImage$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/exportImage
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationRepo string}
  
  Export image for a given resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}:exportImage"
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

(defn locations-operations-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-operations-wait$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/operations/wait
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timeout string}
  
  Waits until the specified long-running operation is done or reaches at most a specified timeout, returning the latest state. If the operation is already done, the latest state is immediately returned. If the timeout specified is greater than the default HTTP/RPC timeout, the HTTP/RPC timeout is used. If the server does not support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Note that this method is on a best-effort basis. It may return the latest state before the specified timeout (including immediately), meaning even an immediate response is no guarantee that the operation is done."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}:wait"
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

(defn locations-jobs-get$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-setIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM Access control policy for the specified Job. Overwrites any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-run$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :etag string,
   :overrides {:containerOverrides [GoogleCloudRunV2ContainerOverride],
               :taskCount integer,
               :timeout string}}
  
  Triggers creation of a new Execution of this Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}:run"
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

(defn locations-jobs-patch$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/patch
  
  Required parameters: name
  
  Optional parameters: validateOnly, allowMissing
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :terminalCondition {:type string,
                       :state string,
                       :message string,
                       :lastTransitionTime string,
                       :severity string,
                       :reason string,
                       :revisionReason string,
                       :executionReason string},
   :generation string,
   :creator string,
   :uid string,
   :name string,
   :executionCount integer,
   :binaryAuthorization {:useDefault boolean,
                         :policy string,
                         :breakglassJustification string},
   :client string,
   :createTime string,
   :etag string,
   :template {:labels {},
              :annotations {},
              :parallelism integer,
              :taskCount integer,
              :template GoogleCloudRunV2TaskTemplate},
   :lastModifier string,
   :observedGeneration string,
   :updateTime string,
   :reconciling boolean,
   :latestCreatedExecution {:name string,
                            :createTime string,
                            :completionTime string},
   :conditions [{:type string,
                 :state string,
                 :message string,
                 :lastTransitionTime string,
                 :severity string,
                 :reason string,
                 :revisionReason string,
                 :executionReason string}],
   :clientVersion string,
   :satisfiesPzs boolean,
   :startExecutionToken string,
   :annotations {},
   :expireTime string,
   :launchStage string}
  
  Updates a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-testIamPermissions$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified Project. There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-create$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/create
  
  Required parameters: parent
  
  Optional parameters: jobId, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :terminalCondition {:type string,
                       :state string,
                       :message string,
                       :lastTransitionTime string,
                       :severity string,
                       :reason string,
                       :revisionReason string,
                       :executionReason string},
   :generation string,
   :creator string,
   :uid string,
   :name string,
   :executionCount integer,
   :binaryAuthorization {:useDefault boolean,
                         :policy string,
                         :breakglassJustification string},
   :client string,
   :createTime string,
   :etag string,
   :template {:labels {},
              :annotations {},
              :parallelism integer,
              :taskCount integer,
              :template GoogleCloudRunV2TaskTemplate},
   :lastModifier string,
   :observedGeneration string,
   :updateTime string,
   :reconciling boolean,
   :latestCreatedExecution {:name string,
                            :createTime string,
                            :completionTime string},
   :conditions [{:type string,
                 :state string,
                 :message string,
                 :lastTransitionTime string,
                 :severity string,
                 :reason string,
                 :revisionReason string,
                 :executionReason string}],
   :clientVersion string,
   :satisfiesPzs boolean,
   :startExecutionToken string,
   :annotations {},
   :expireTime string,
   :launchStage string}
  
  Creates a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/jobs"
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

(defn locations-jobs-delete$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-getIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM Access Control policy currently in effect for the given Job. This result does not include any inherited policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Lists Jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-executions-exportStatus$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/exportStatus
  
  Required parameters: name, operationId
  
  Optional parameters: none
  
  Read the status of an image export operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name :operationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}/{+operationId}:exportStatus"
     #{:name :operationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-executions-get$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about an Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-executions-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Lists Executions from a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-executions-delete$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes an Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-executions-cancel$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean, :etag string}
  
  Cancels an Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-executions-tasks-get$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/tasks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a Task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-jobs-executions-tasks-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/jobs/executions/tasks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Lists Tasks from an Execution of a Job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/tasks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-create$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId, validateOnly
  
  Body: 
  
  {:description string,
   :labels {},
   :deleteTime string,
   :terminalCondition {:type string,
                       :state string,
                       :message string,
                       :lastTransitionTime string,
                       :severity string,
                       :reason string,
                       :revisionReason string,
                       :executionReason string},
   :generation string,
   :ingress string,
   :creator string,
   :traffic [{:type string,
              :revision string,
              :percent integer,
              :tag string}],
   :uid string,
   :name string,
   :binaryAuthorization {:useDefault boolean,
                         :policy string,
                         :breakglassJustification string},
   :latestCreatedRevision string,
   :client string,
   :createTime string,
   :trafficStatuses [{:type string,
                      :revision string,
                      :percent integer,
                      :tag string,
                      :uri string}],
   :etag string,
   :template {:serviceAccount string,
              :labels {},
              :maxInstanceRequestConcurrency integer,
              :revision string,
              :nodeSelector GoogleCloudRunV2NodeSelector,
              :healthCheckDisabled boolean,
              :encryptionKey string,
              :vpcAccess GoogleCloudRunV2VpcAccess,
              :containers [GoogleCloudRunV2Container],
              :executionEnvironment string,
              :volumes [GoogleCloudRunV2Volume],
              :scaling GoogleCloudRunV2RevisionScaling,
              :sessionAffinity boolean,
              :annotations {},
              :timeout string},
   :latestReadyRevision string,
   :lastModifier string,
   :observedGeneration string,
   :updateTime string,
   :reconciling boolean,
   :conditions [{:type string,
                 :state string,
                 :message string,
                 :lastTransitionTime string,
                 :severity string,
                 :reason string,
                 :revisionReason string,
                 :executionReason string}],
   :clientVersion string,
   :satisfiesPzs boolean,
   :scaling {:minInstanceCount integer},
   :annotations {},
   :expireTime string,
   :uri string,
   :launchStage string,
   :customAudiences [string],
   :defaultUriDisabled boolean}
  
  Creates a new Service in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/services"
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

(defn locations-services-get$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Lists Services."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-patch$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :deleteTime string,
   :terminalCondition {:type string,
                       :state string,
                       :message string,
                       :lastTransitionTime string,
                       :severity string,
                       :reason string,
                       :revisionReason string,
                       :executionReason string},
   :generation string,
   :ingress string,
   :creator string,
   :traffic [{:type string,
              :revision string,
              :percent integer,
              :tag string}],
   :uid string,
   :name string,
   :binaryAuthorization {:useDefault boolean,
                         :policy string,
                         :breakglassJustification string},
   :latestCreatedRevision string,
   :client string,
   :createTime string,
   :trafficStatuses [{:type string,
                      :revision string,
                      :percent integer,
                      :tag string,
                      :uri string}],
   :etag string,
   :template {:serviceAccount string,
              :labels {},
              :maxInstanceRequestConcurrency integer,
              :revision string,
              :nodeSelector GoogleCloudRunV2NodeSelector,
              :healthCheckDisabled boolean,
              :encryptionKey string,
              :vpcAccess GoogleCloudRunV2VpcAccess,
              :containers [GoogleCloudRunV2Container],
              :executionEnvironment string,
              :volumes [GoogleCloudRunV2Volume],
              :scaling GoogleCloudRunV2RevisionScaling,
              :sessionAffinity boolean,
              :annotations {},
              :timeout string},
   :latestReadyRevision string,
   :lastModifier string,
   :observedGeneration string,
   :updateTime string,
   :reconciling boolean,
   :conditions [{:type string,
                 :state string,
                 :message string,
                 :lastTransitionTime string,
                 :severity string,
                 :reason string,
                 :revisionReason string,
                 :executionReason string}],
   :clientVersion string,
   :satisfiesPzs boolean,
   :scaling {:minInstanceCount integer},
   :annotations {},
   :expireTime string,
   :uri string,
   :launchStage string,
   :customAudiences [string],
   :defaultUriDisabled boolean}
  
  Updates a Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-delete$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a Service. This will cause the Service to stop serving traffic and will delete all revisions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-getIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the IAM Access Control policy currently in effect for the given Cloud Run Service. This result does not include any inherited policies."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-setIamPolicy$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [GoogleIamV1Binding],
            :auditConfigs [GoogleIamV1AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the IAM Access control policy for the specified Service. Overwrites any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-testIamPermissions$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified Project. There are no permissions required for making this API call."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-revisions-exportStatus$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/revisions/exportStatus
  
  Required parameters: name, operationId
  
  Optional parameters: none
  
  Read the status of an image export operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name :operationId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+name}/{+operationId}:exportStatus"
     #{:name :operationId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-revisions-get$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/revisions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a Revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
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

(defn locations-services-revisions-list$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/revisions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, showDeleted
  
  Lists Revisions from a given Service, or from a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://run.googleapis.com/"
     "v2/{+parent}/revisions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-services-revisions-delete$
  "https://cloud.google.com/run/api/reference/rest/v2/projects/locations/services/revisions/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes a Revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://run.googleapis.com/"
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
