(ns happygapi.dataproc.projects
  "Cloud Dataproc API: projects.
  Manages Hadoop-based clusters and jobs on Google Cloud Platform.
  See: https://cloud.google.com/dataproc/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn regions-operations-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-operations-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-operations-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-operations-cancel$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-operations-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-operations-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn regions-operations-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-autoscalingPolicies-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :basicAlgorithm {:yarnConfig BasicYarnAutoscalingConfig,
                    :sparkStandaloneConfig SparkStandaloneAutoscalingConfig,
                    :cooldownPeriod string},
   :workerConfig {:minInstances integer,
                  :maxInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:minInstances integer,
                           :maxInstances integer,
                           :weight integer},
   :labels {}}
  
  Creates new autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
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

(defn regions-autoscalingPolicies-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :basicAlgorithm {:yarnConfig BasicYarnAutoscalingConfig,
                    :sparkStandaloneConfig SparkStandaloneAutoscalingConfig,
                    :cooldownPeriod string},
   :workerConfig {:minInstances integer,
                  :maxInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:minInstances integer,
                           :maxInstances integer,
                           :weight integer},
   :labels {}}
  
  Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-autoscalingPolicies-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-autoscalingPolicies-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists autoscaling policies in the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-autoscalingPolicies-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-autoscalingPolicies-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-autoscalingPolicies-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn regions-autoscalingPolicies-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-clusters-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/get
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: none
  
  Gets the resource representation for a cluster in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{:clusterName :region :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-clusters-patch$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/patch
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: gracefulDecommissionTimeout, updateMask, requestId
  
  Body: 
  
  {:labels {},
   :clusterName string,
   :virtualClusterConfig {:stagingBucket string,
                          :kubernetesClusterConfig KubernetesClusterConfig,
                          :auxiliaryServicesConfig AuxiliaryServicesConfig},
   :config {:configBucket string,
            :gceClusterConfig GceClusterConfig,
            :auxiliaryNodeGroups [AuxiliaryNodeGroup],
            :metastoreConfig MetastoreConfig,
            :dataprocMetricConfig DataprocMetricConfig,
            :softwareConfig SoftwareConfig,
            :workerConfig InstanceGroupConfig,
            :initializationActions [NodeInitializationAction],
            :securityConfig SecurityConfig,
            :masterConfig InstanceGroupConfig,
            :lifecycleConfig LifecycleConfig,
            :secondaryWorkerConfig InstanceGroupConfig,
            :endpointConfig EndpointConfig,
            :tempBucket string,
            :encryptionConfig EncryptionConfig,
            :gkeClusterConfig GkeClusterConfig,
            :autoscalingConfig AutoscalingConfig},
   :status {:state string,
            :detail string,
            :stateStartTime string,
            :substate string},
   :projectId string,
   :clusterUuid string,
   :metrics {:hdfsMetrics {}, :yarnMetrics {}},
   :statusHistory [{:state string,
                    :detail string,
                    :stateStartTime string,
                    :substate string}]}
  
  Updates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). The cluster must be in a RUNNING state or an error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{:clusterName :region :projectId}
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

(defn regions-clusters-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-clusters-injectCredentials$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/injectCredentials
  
  Required parameters: project, region, cluster
  
  Optional parameters: none
  
  Body: 
  
  {:clusterUuid string, :credentialsCiphertext string}
  
  Inject encrypted credentials into all of the VMs in a cluster.The target cluster must be a personal auth cluster assigned to the user who is issuing the RPC."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:cluster :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+project}/{+region}/{+cluster}:injectCredentials"
     #{:cluster :region :project}
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

(defn regions-clusters-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/create
  
  Required parameters: projectId, region
  
  Optional parameters: requestId, actionOnFailedPrimaryWorkers
  
  Body: 
  
  {:labels {},
   :clusterName string,
   :virtualClusterConfig {:stagingBucket string,
                          :kubernetesClusterConfig KubernetesClusterConfig,
                          :auxiliaryServicesConfig AuxiliaryServicesConfig},
   :config {:configBucket string,
            :gceClusterConfig GceClusterConfig,
            :auxiliaryNodeGroups [AuxiliaryNodeGroup],
            :metastoreConfig MetastoreConfig,
            :dataprocMetricConfig DataprocMetricConfig,
            :softwareConfig SoftwareConfig,
            :workerConfig InstanceGroupConfig,
            :initializationActions [NodeInitializationAction],
            :securityConfig SecurityConfig,
            :masterConfig InstanceGroupConfig,
            :lifecycleConfig LifecycleConfig,
            :secondaryWorkerConfig InstanceGroupConfig,
            :endpointConfig EndpointConfig,
            :tempBucket string,
            :encryptionConfig EncryptionConfig,
            :gkeClusterConfig GkeClusterConfig,
            :autoscalingConfig AutoscalingConfig},
   :status {:state string,
            :detail string,
            :stateStartTime string,
            :substate string},
   :projectId string,
   :clusterUuid string,
   :metrics {:hdfsMetrics {}, :yarnMetrics {}},
   :statusHistory [{:state string,
                    :detail string,
                    :stateStartTime string,
                    :substate string}]}
  
  Creates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters"
     #{:region :projectId}
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

(defn regions-clusters-start$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/start
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: none
  
  Body: 
  
  {:clusterUuid string, :requestId string}
  
  Starts a cluster in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:start"
     #{:clusterName :region :projectId}
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

(defn regions-clusters-repair$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/repair
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: none
  
  Body: 
  
  {:clusterUuid string,
   :requestId string,
   :nodePools [{:id string,
                :instanceNames [string],
                :repairAction string}],
   :gracefulDecommissionTimeout string,
   :parentOperationId string}
  
  Repairs a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:repair"
     #{:clusterName :region :projectId}
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

(defn regions-clusters-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/delete
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: clusterUuid, requestId, gracefulTerminationTimeout
  
  Deletes a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{:clusterName :region :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-diagnose$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/diagnose
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: none
  
  Body: 
  
  {:tarballGcsDir string,
   :tarballAccess string,
   :diagnosisInterval {:startTime string, :endTime string},
   :job string,
   :yarnApplicationId string,
   :jobs [string],
   :yarnApplicationIds [string]}
  
  Gets cluster diagnostic information. The returned Operation.metadata will be ClusterOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#clusteroperationmetadata). After the operation completes, Operation.response contains DiagnoseClusterResults (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#diagnoseclusterresults)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:diagnose"
     #{:clusterName :region :projectId}
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

(defn regions-clusters-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn regions-clusters-stop$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/stop
  
  Required parameters: projectId, region, clusterName
  
  Optional parameters: none
  
  Body: 
  
  {:clusterUuid string, :requestId string}
  
  Stops a cluster in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clusterName :region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:stop"
     #{:clusterName :region :projectId}
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

(defn regions-clusters-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/list
  
  Required parameters: projectId, region
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists all regions/{region}/clusters in a project alphabetically."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters"
     #{:region :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-nodeGroups-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/nodeGroups/create
  
  Required parameters: parent
  
  Optional parameters: nodeGroupId, requestId, parentOperationId
  
  Body: 
  
  {:name string,
   :roles [string],
   :nodeGroupConfig {:minNumInstances integer,
                     :diskConfig DiskConfig,
                     :preemptibility string,
                     :imageUri string,
                     :startupConfig StartupConfig,
                     :numInstances integer,
                     :instanceNames [string],
                     :managedGroupConfig ManagedGroupConfig,
                     :instanceReferences [InstanceReference],
                     :instanceFlexibilityPolicy InstanceFlexibilityPolicy,
                     :isPreemptible boolean,
                     :machineTypeUri string,
                     :accelerators [AcceleratorConfig],
                     :minCpuPlatform string},
   :labels {}}
  
  Creates a node group in a cluster. The returned Operation.metadata is NodeGroupOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/nodeGroups"
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

(defn regions-clusters-nodeGroups-resize$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/nodeGroups/resize
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:size integer,
   :requestId string,
   :gracefulDecommissionTimeout string,
   :parentOperationId string}
  
  Resizes a node group in a cluster. The returned Operation.metadata is NodeGroupOperationMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#nodegroupoperationmetadata)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:resize"
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

(defn regions-clusters-nodeGroups-repair$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/nodeGroups/repair
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:instanceNames [string], :repairAction string, :requestId string}
  
  Repair nodes in a node group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:repair"
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

(defn regions-clusters-nodeGroups-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/clusters/nodeGroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the resource representation for a node group in a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-jobs-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/get
  
  Required parameters: projectId, region, jobId
  
  Optional parameters: none
  
  Gets the resource representation for a job in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{:region :projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-jobs-patch$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/patch
  
  Required parameters: projectId, region, jobId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:flinkJob {:mainJarFileUri string,
              :mainClass string,
              :args [string],
              :jarFileUris [string],
              :savepointUri string,
              :properties {},
              :loggingConfig LoggingConfig},
   :labels {},
   :sparkSqlJob {:queryFileUri string,
                 :queryList QueryList,
                 :scriptVariables {},
                 :properties {},
                 :jarFileUris [string],
                 :loggingConfig LoggingConfig},
   :prestoJob {:queryFileUri string,
               :queryList QueryList,
               :continueOnFailure boolean,
               :outputFormat string,
               :clientTags [string],
               :properties {},
               :loggingConfig LoggingConfig},
   :scheduling {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :done boolean,
   :driverOutputResourceUri string,
   :pigJob {:queryFileUri string,
            :queryList QueryList,
            :continueOnFailure boolean,
            :scriptVariables {},
            :properties {},
            :jarFileUris [string],
            :loggingConfig LoggingConfig},
   :yarnApplications [{:name string,
                       :state string,
                       :progress number,
                       :trackingUrl string}],
   :hiveJob {:queryFileUri string,
             :queryList QueryList,
             :continueOnFailure boolean,
             :scriptVariables {},
             :properties {},
             :jarFileUris [string]},
   :sparkJob {:mainJarFileUri string,
              :mainClass string,
              :args [string],
              :jarFileUris [string],
              :fileUris [string],
              :archiveUris [string],
              :properties {},
              :loggingConfig LoggingConfig},
   :reference {:projectId string, :jobId string},
   :trinoJob {:queryFileUri string,
              :queryList QueryList,
              :continueOnFailure boolean,
              :outputFormat string,
              :clientTags [string],
              :properties {},
              :loggingConfig LoggingConfig},
   :status {:state string,
            :details string,
            :stateStartTime string,
            :substate string},
   :pysparkJob {:mainPythonFileUri string,
                :args [string],
                :pythonFileUris [string],
                :jarFileUris [string],
                :fileUris [string],
                :archiveUris [string],
                :properties {},
                :loggingConfig LoggingConfig},
   :sparkRJob {:mainRFileUri string,
               :args [string],
               :fileUris [string],
               :archiveUris [string],
               :properties {},
               :loggingConfig LoggingConfig},
   :driverSchedulingConfig {:memoryMb integer, :vcores integer},
   :jobUuid string,
   :placement {:clusterName string,
               :clusterUuid string,
               :clusterLabels {}},
   :hadoopJob {:mainJarFileUri string,
               :mainClass string,
               :args [string],
               :jarFileUris [string],
               :fileUris [string],
               :archiveUris [string],
               :properties {},
               :loggingConfig LoggingConfig},
   :driverControlFilesUri string,
   :statusHistory [{:state string,
                    :details string,
                    :stateStartTime string,
                    :substate string}]}
  
  Updates a job in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :projectId :jobId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{:region :projectId :jobId}
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

(defn regions-jobs-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-jobs-submit$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/submit
  
  Required parameters: projectId, region
  
  Optional parameters: none
  
  Body: 
  
  {:job {:flinkJob FlinkJob,
         :labels {},
         :sparkSqlJob SparkSqlJob,
         :prestoJob PrestoJob,
         :scheduling JobScheduling,
         :done boolean,
         :driverOutputResourceUri string,
         :pigJob PigJob,
         :yarnApplications [YarnApplication],
         :hiveJob HiveJob,
         :sparkJob SparkJob,
         :reference JobReference,
         :trinoJob TrinoJob,
         :status JobStatus,
         :pysparkJob PySparkJob,
         :sparkRJob SparkRJob,
         :driverSchedulingConfig DriverSchedulingConfig,
         :jobUuid string,
         :placement JobPlacement,
         :hadoopJob HadoopJob,
         :driverControlFilesUri string,
         :statusHistory [JobStatus]},
   :requestId string}
  
  Submits a job to a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs:submit"
     #{:region :projectId}
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

(defn regions-jobs-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/delete
  
  Required parameters: projectId, region, jobId
  
  Optional parameters: none
  
  Deletes the job from the project. If the job is active, the delete fails, and the response returns FAILED_PRECONDITION."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :projectId :jobId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{:region :projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn regions-jobs-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/list
  
  Required parameters: projectId, region
  
  Optional parameters: pageSize, pageToken, clusterName, jobStateMatcher, filter
  
  Lists regions/{region}/jobs in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs"
     #{:region :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-submitAsOperation$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/submitAsOperation
  
  Required parameters: projectId, region
  
  Optional parameters: none
  
  Body: 
  
  {:job {:flinkJob FlinkJob,
         :labels {},
         :sparkSqlJob SparkSqlJob,
         :prestoJob PrestoJob,
         :scheduling JobScheduling,
         :done boolean,
         :driverOutputResourceUri string,
         :pigJob PigJob,
         :yarnApplications [YarnApplication],
         :hiveJob HiveJob,
         :sparkJob SparkJob,
         :reference JobReference,
         :trinoJob TrinoJob,
         :status JobStatus,
         :pysparkJob PySparkJob,
         :sparkRJob SparkRJob,
         :driverSchedulingConfig DriverSchedulingConfig,
         :jobUuid string,
         :placement JobPlacement,
         :hadoopJob HadoopJob,
         :driverControlFilesUri string,
         :statusHistory [JobStatus]},
   :requestId string}
  
  Submits job to a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs:submitAsOperation"
     #{:region :projectId}
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

(defn regions-jobs-cancel$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/cancel
  
  Required parameters: projectId, region, jobId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts a job cancellation request. To access the job resource after cancellation, call regions/{region}/jobs.list (https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/list) or regions/{region}/jobs.get (https://cloud.google.com/dataproc/docs/reference/rest/v1/projects.regions.jobs/get)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}:cancel"
     #{:region :projectId :jobId}
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

(defn regions-workflowTemplates-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/get
  
  Required parameters: name
  
  Optional parameters: version
  
  Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-workflowTemplates-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-workflowTemplates-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-workflowTemplates-instantiateInline$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/instantiateInline
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates:instantiateInline"
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

(defn regions-workflowTemplates-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Creates new workflow template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
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

(defn regions-workflowTemplates-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Updates (replaces) workflow template. The updated template must contain version that matches the current server version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-workflowTemplates-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/delete
  
  Required parameters: name
  
  Optional parameters: version
  
  Deletes a workflow template. It does not cancel in-progress workflows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn regions-workflowTemplates-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn regions-workflowTemplates-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists workflows that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-instantiate$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/workflowTemplates/instantiate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:version integer, :requestId string, :parameters {}}
  
  Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:instantiate"
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
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batches-analyze$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/batches/analyze
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Analyze a Batch for possible recommendations and insights."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:analyze"
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

(defn locations-batches-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/batches/create
  
  Required parameters: parent
  
  Optional parameters: batchId, requestId
  
  Body: 
  
  {:labels {},
   :pysparkBatch {:mainPythonFileUri string,
                  :args [string],
                  :pythonFileUris [string],
                  :jarFileUris [string],
                  :fileUris [string],
                  :archiveUris [string]},
   :creator string,
   :environmentConfig {:executionConfig ExecutionConfig,
                       :peripheralsConfig PeripheralsConfig},
   :sparkRBatch {:mainRFileUri string,
                 :args [string],
                 :fileUris [string],
                 :archiveUris [string]},
   :sparkBatch {:mainJarFileUri string,
                :mainClass string,
                :args [string],
                :jarFileUris [string],
                :fileUris [string],
                :archiveUris [string]},
   :runtimeConfig {:version string,
                   :containerImage string,
                   :properties {},
                   :repositoryConfig RepositoryConfig},
   :name string,
   :operation string,
   :createTime string,
   :state string,
   :runtimeInfo {:endpoints {},
                 :outputUri string,
                 :diagnosticOutputUri string,
                 :approximateUsage UsageMetrics,
                 :currentUsage UsageSnapshot},
   :uuid string,
   :stateTime string,
   :stateHistory [{:state string,
                   :stateMessage string,
                   :stateStartTime string}],
   :sparkSqlBatch {:queryFileUri string,
                   :queryVariables {},
                   :jarFileUris [string]},
   :stateMessage string}
  
  Creates a batch workload that executes asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/batches"
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

(defn locations-batches-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/batches/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the batch workload resource representation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-batches-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/batches/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists batch workloads."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/batches"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-batches-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/batches/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the batch workload resource. If the batch is not in a CANCELLED, SUCCEEDED or FAILED State, the delete operation fails and the response returns FAILED_PRECONDITION."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-autoscalingPolicies-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :basicAlgorithm {:yarnConfig BasicYarnAutoscalingConfig,
                    :sparkStandaloneConfig SparkStandaloneAutoscalingConfig,
                    :cooldownPeriod string},
   :workerConfig {:minInstances integer,
                  :maxInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:minInstances integer,
                           :maxInstances integer,
                           :weight integer},
   :labels {}}
  
  Creates new autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
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

(defn locations-autoscalingPolicies-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name string,
   :basicAlgorithm {:yarnConfig BasicYarnAutoscalingConfig,
                    :sparkStandaloneConfig SparkStandaloneAutoscalingConfig,
                    :cooldownPeriod string},
   :workerConfig {:minInstances integer,
                  :maxInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:minInstances integer,
                           :maxInstances integer,
                           :weight integer},
   :labels {}}
  
  Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-autoscalingPolicies-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-autoscalingPolicies-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists autoscaling policies in the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-autoscalingPolicies-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-autoscalingPolicies-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-autoscalingPolicies-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-autoscalingPolicies-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessions-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessions/create
  
  Required parameters: parent
  
  Optional parameters: sessionId, requestId
  
  Body: 
  
  {:labels {},
   :creator string,
   :environmentConfig {:executionConfig ExecutionConfig,
                       :peripheralsConfig PeripheralsConfig},
   :runtimeConfig {:version string,
                   :containerImage string,
                   :properties {},
                   :repositoryConfig RepositoryConfig},
   :name string,
   :createTime string,
   :state string,
   :jupyterSession {:kernel string, :displayName string},
   :runtimeInfo {:endpoints {},
                 :outputUri string,
                 :diagnosticOutputUri string,
                 :approximateUsage UsageMetrics,
                 :currentUsage UsageSnapshot},
   :sessionTemplate string,
   :uuid string,
   :stateTime string,
   :stateHistory [{:state string,
                   :stateMessage string,
                   :stateStartTime string}],
   :user string,
   :stateMessage string}
  
  Create an interactive session asynchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/sessions"
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

(defn locations-sessions-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the resource representation for an interactive session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessions-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists interactive sessions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/sessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sessions-terminate$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessions/terminate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Terminates the interactive session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessions-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessions/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes the interactive session resource. If the session is not in terminal state, it is terminated, and then deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessionTemplates-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessionTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :creator string,
   :environmentConfig {:executionConfig ExecutionConfig,
                       :peripheralsConfig PeripheralsConfig},
   :runtimeConfig {:version string,
                   :containerImage string,
                   :properties {},
                   :repositoryConfig RepositoryConfig},
   :name string,
   :createTime string,
   :jupyterSession {:kernel string, :displayName string},
   :updateTime string,
   :uuid string}
  
  Create a session template synchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/sessionTemplates"
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

(defn locations-sessionTemplates-patch$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessionTemplates/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :creator string,
   :environmentConfig {:executionConfig ExecutionConfig,
                       :peripheralsConfig PeripheralsConfig},
   :runtimeConfig {:version string,
                   :containerImage string,
                   :properties {},
                   :repositoryConfig RepositoryConfig},
   :name string,
   :createTime string,
   :jupyterSession {:kernel string, :displayName string},
   :updateTime string,
   :uuid string}
  
  Updates the session template synchronously."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessionTemplates-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessionTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the resource representation for a session template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-sessionTemplates-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessionTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists session templates."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/sessionTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sessionTemplates-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/sessionTemplates/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a session template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/get
  
  Required parameters: name
  
  Optional parameters: version
  
  Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return NOT_FOUND, INVALID_ARGUMENT, and PERMISSION_DENIED errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-testIamPermissions$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-instantiateInline$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/instantiateInline
  
  Required parameters: parent
  
  Optional parameters: requestId
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates:instantiateInline"
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

(defn locations-workflowTemplates-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Creates new workflow template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
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

(defn locations-workflowTemplates-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :name string,
   :createTime string,
   :updateTime string,
   :jobs [{:flinkJob FlinkJob,
           :labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :trinoJob TrinoJob,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:managedCluster ManagedCluster,
               :clusterSelector ClusterSelector},
   :parameters [{:name string,
                 :fields [string],
                 :description string,
                 :validation ParameterValidation}],
   :encryptionConfig {:kmsKey string}}
  
  Updates (replaces) workflow template. The updated template must contain version that matches the current server version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-delete$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/delete
  
  Required parameters: name
  
  Optional parameters: version
  
  Deletes a workflow template. It does not cancel in-progress workflows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
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

(defn locations-workflowTemplates-getIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-workflowTemplates-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists workflows that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflowTemplates-instantiate$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/workflowTemplates/instantiate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:version integer, :requestId string, :parameters {}}
  
  Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata (https://cloud.google.com/dataproc/docs/reference/rpc/google.cloud.dataproc.v1#workflowmetadata). Also see Using WorkflowMetadata (https://cloud.google.com/dataproc/docs/concepts/workflows/debugging#using_workflowmetadata).On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:instantiate"
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
