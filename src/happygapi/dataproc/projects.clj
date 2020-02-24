(ns happygapi.dataproc.projects
  "Cloud Dataproc API
  Manages Hadoop-based clusters and jobs on Google Cloud Platform.
  See: https://cloud.google.com/dataproc/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn regions-jobs-get$
  "Required parameters: region,projectId,jobId
  
  Gets the resource representation for a job in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"region" "projectId" "jobId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{"region" "projectId" "jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-jobs-patch$
  "Required parameters: region,projectId,jobId
  
  Updates a job in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"region" "projectId" "jobId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{"region" "projectId" "jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-jobs-submit$
  "Required parameters: projectId,region
  
  Submits a job to a cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"region" "projectId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs:submit"
     #{"region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-jobs-delete$
  "Required parameters: projectId,jobId,region
  
  Deletes the job from the project. If the job is active, the delete fails, and the response returns FAILED_PRECONDITION."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"region" "projectId" "jobId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}"
     #{"region" "projectId" "jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-jobs-list$
  "Required parameters: projectId,region
  
  Lists regions/{region}/jobs in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"region" "projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs"
     #{"region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-jobs-cancel$
  "Required parameters: projectId,jobId,region
  
  Starts a job cancellation request. To access the job resource after cancellation, call regions/{region}/jobs.list or regions/{region}/jobs.get."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"region" "projectId" "jobId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/jobs/{jobId}:cancel"
     #{"region" "projectId" "jobId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-get$
  "Required parameters: region,clusterName,projectId
  
  Gets the resource representation for a cluster in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterName" "region" "projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{"clusterName" "region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-patch$
  "Required parameters: clusterName,projectId,region
  
  Updates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterName" "region" "projectId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{"clusterName" "region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-create$
  "Required parameters: projectId,region
  
  Creates a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"region" "projectId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters"
     #{"region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-delete$
  "Required parameters: clusterName,projectId,region
  
  Deletes a cluster in a project. The returned Operation.metadata will be ClusterOperationMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"clusterName" "region" "projectId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}"
     #{"clusterName" "region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-clusters-diagnose$
  "Required parameters: clusterName,projectId,region
  
  Gets cluster diagnostic information. The returned Operation.metadata will be ClusterOperationMetadata. After the operation completes, Operation.response contains DiagnoseClusterResults."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"clusterName" "region" "projectId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters/{clusterName}:diagnose"
     #{"clusterName" "region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-clusters-list$
  "Required parameters: region,projectId
  
  Lists all regions/{region}/clusters in a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"region" "projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/projects/{projectId}/regions/{region}/clusters"
     #{"region" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-get$
  "Required parameters: name
  
  Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-workflowTemplates-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-workflowTemplates-instantiateInline$
  "Required parameters: parent
  
  Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata. Also see Using WorkflowMetadata.On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates:instantiateInline"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-workflowTemplates-create$
  "Required parameters: parent
  
  Creates new workflow template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-workflowTemplates-update$
  "Required parameters: name
  
  Updates (replaces) workflow template. The updated template must contain version that matches the current server version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-delete$
  "Required parameters: name
  
  Deletes a workflow template. It does not cancel in-progress workflows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-workflowTemplates-list$
  "Required parameters: parent
  
  Lists workflows that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-workflowTemplates-instantiate$
  "Required parameters: name
  
  Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata. Also see Using WorkflowMetadata.On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:instantiate"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-operations-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-operations-get$
  "Required parameters: name
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-operations-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-operations-delete$
  "Required parameters: name
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-operations-list$
  "Required parameters: name
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.NOTE: the name binding allows API services to override the binding to use different resource name schemes, such as users/*/operations. To override the binding, API services can add a binding such as \"/v1/{name=users/*}/operations\" to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-operations-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-operations-cancel$
  "Required parameters: name
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns google.rpc.Code.UNIMPLEMENTED. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to Code.CANCELLED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:cancel"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-autoscalingPolicies-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-autoscalingPolicies-get$
  "Required parameters: name
  
  Retrieves autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-autoscalingPolicies-update$
  "Required parameters: name
  
  Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-autoscalingPolicies-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-autoscalingPolicies-delete$
  "Required parameters: name
  
  Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-autoscalingPolicies-list$
  "Required parameters: parent
  
  Lists autoscaling policies in the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn regions-autoscalingPolicies-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn regions-autoscalingPolicies-create$
  "Required parameters: parent
  
  Creates new autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-get$
  "Required parameters: name
  
  Retrieves the latest workflow template.Can retrieve previously instantiated template by specifying optional version parameter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflowTemplates-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-instantiateInline$
  "Required parameters: parent
  
  Instantiates a template and begins execution.This method is equivalent to executing the sequence CreateWorkflowTemplate, InstantiateWorkflowTemplate, DeleteWorkflowTemplate.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata. Also see Using WorkflowMetadata.On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates:instantiateInline"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-create$
  "Required parameters: parent
  
  Creates new workflow template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-update$
  "Required parameters: name
  
  Updates (replaces) workflow template. The updated template must contain version that matches the current server version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflowTemplates-delete$
  "Required parameters: name
  
  Deletes a workflow template. It does not cancel in-progress workflows."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflowTemplates-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-workflowTemplates-list$
  "Required parameters: parent
  
  Lists workflows that match the specified filter in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/workflowTemplates"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflowTemplates-instantiate$
  "Required parameters: name
  
  Instantiates a template and begins execution.The returned Operation can be used to track execution of workflow by polling operations.get. The Operation will complete when entire workflow is finished.The running workflow can be aborted via operations.cancel. This will cause any inflight jobs to be cancelled and workflow-owned clusters to be deleted.The Operation.metadata will be WorkflowMetadata. Also see Using WorkflowMetadata.On successful completion, Operation.response will be Empty."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}:instantiate"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-autoscalingPolicies-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-autoscalingPolicies-get$
  "Required parameters: name
  
  Retrieves autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-autoscalingPolicies-update$
  "Required parameters: name
  
  Updates (replaces) autoscaling policy.Disabled check for update_mask, because all updates will be full replacements."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-autoscalingPolicies-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error.Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-autoscalingPolicies-delete$
  "Required parameters: name
  
  Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-autoscalingPolicies-list$
  "Required parameters: parent
  
  Lists autoscaling policies in the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-autoscalingPolicies-create$
  "Required parameters: parent
  
  Creates new autoscaling policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+parent}/autoscalingPolicies"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn locations-autoscalingPolicies-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy.Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataproc.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
