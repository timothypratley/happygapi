(ns happygapi.dataproc.projects
  "Cloud Dataproc API: projects.
  Manages Hadoop-based clusters and jobs on Google Cloud Platform.
  See: https://cloud.google.com/dataproc/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-autoscalingPolicies-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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

(defn locations-autoscalingPolicies-create$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :basicAlgorithm {:cooldownPeriod string,
                    :yarnConfig BasicYarnAutoscalingConfig},
   :workerConfig {:maxInstances integer,
                  :minInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:maxInstances integer,
                           :minInstances integer,
                           :weight integer},
   :id string}
  
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

(defn locations-autoscalingPolicies-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/locations/autoscalingPolicies/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :basicAlgorithm {:cooldownPeriod string,
                    :yarnConfig BasicYarnAutoscalingConfig},
   :workerConfig {:maxInstances integer,
                  :minInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:maxInstances integer,
                           :minInstances integer,
                           :weight integer},
   :id string}
  
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
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
  
  Optional parameters: pageToken, pageSize
  
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
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
   :jobs [{:labels {},
           :prerequisiteStepIds [string],
           :sparkSqlJob SparkSqlJob,
           :prestoJob PrestoJob,
           :scheduling JobScheduling,
           :pigJob PigJob,
           :hiveJob HiveJob,
           :sparkJob SparkJob,
           :stepId string,
           :pysparkJob PySparkJob,
           :sparkRJob SparkRJob,
           :hadoopJob HadoopJob}],
   :id string,
   :dagTimeout string,
   :version integer,
   :placement {:clusterSelector ClusterSelector,
               :managedCluster ManagedCluster},
   :parameters [{:description string,
                 :validation ParameterValidation,
                 :name string,
                 :fields [string]}]}
  
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
  
  Optional parameters: pageToken, pageSize
  
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

(defn regions-jobs-get$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/jobs/get
  
  Required parameters: region, projectId, jobId
  
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
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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
  
  Required parameters: projectId, jobId, region
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :sparkSqlJob {:jarFileUris [string],
                 :loggingConfig LoggingConfig,
                 :scriptVariables {},
                 :properties {},
                 :queryFileUri string,
                 :queryList QueryList},
   :prestoJob {:properties {},
               :queryFileUri string,
               :outputFormat string,
               :loggingConfig LoggingConfig,
               :continueOnFailure boolean,
               :clientTags [string],
               :queryList QueryList},
   :scheduling {:maxFailuresPerHour integer, :maxFailuresTotal integer},
   :done boolean,
   :driverOutputResourceUri string,
   :pigJob {:jarFileUris [string],
            :continueOnFailure boolean,
            :properties {},
            :queryList QueryList,
            :queryFileUri string,
            :scriptVariables {},
            :loggingConfig LoggingConfig},
   :yarnApplications [{:name string,
                       :state string,
                       :progress number,
                       :trackingUrl string}],
   :hiveJob {:scriptVariables {},
             :queryFileUri string,
             :queryList QueryList,
             :properties {},
             :jarFileUris [string],
             :continueOnFailure boolean},
   :sparkJob {:archiveUris [string],
              :mainClass string,
              :jarFileUris [string],
              :args [string],
              :loggingConfig LoggingConfig,
              :fileUris [string],
              :mainJarFileUri string,
              :properties {}},
   :reference {:jobId string, :projectId string},
   :status {:stateStartTime string,
            :substate string,
            :state string,
            :details string},
   :pysparkJob {:properties {},
                :loggingConfig LoggingConfig,
                :pythonFileUris [string],
                :mainPythonFileUri string,
                :args [string],
                :fileUris [string],
                :jarFileUris [string],
                :archiveUris [string]},
   :sparkRJob {:archiveUris [string],
               :fileUris [string],
               :args [string],
               :loggingConfig LoggingConfig,
               :properties {},
               :mainRFileUri string},
   :jobUuid string,
   :placement {:clusterName string,
               :clusterLabels {},
               :clusterUuid string},
   :hadoopJob {:properties {},
               :jarFileUris [string],
               :fileUris [string],
               :args [string],
               :loggingConfig LoggingConfig,
               :mainClass string,
               :archiveUris [string],
               :mainJarFileUri string},
   :driverControlFilesUri string,
   :statusHistory [{:stateStartTime string,
                    :substate string,
                    :state string,
                    :details string}]}
  
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
  
  {:requestId string,
   :job {:labels {},
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
         :status JobStatus,
         :pysparkJob PySparkJob,
         :sparkRJob SparkRJob,
         :jobUuid string,
         :placement JobPlacement,
         :hadoopJob HadoopJob,
         :driverControlFilesUri string,
         :statusHistory [JobStatus]}}
  
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
  
  Required parameters: projectId, jobId, region
  
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
  
  Optional parameters: jobStateMatcher, filter, clusterName, pageToken, pageSize
  
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
  
  Required parameters: region, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :job {:labels {},
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
         :status JobStatus,
         :pysparkJob PySparkJob,
         :sparkRJob SparkRJob,
         :jobUuid string,
         :placement JobPlacement,
         :hadoopJob HadoopJob,
         :driverControlFilesUri string,
         :statusHistory [JobStatus]}}
  
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

(defn regions-operations-list$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED.NOTE: the name binding allows API services to override the binding to use different resource name schemes, such as users/*/operations. To override the binding, API services can add a binding such as \"/v1/{name=users/*}/operations\" to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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

(defn regions-operations-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/operations/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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
  
  {:name string,
   :basicAlgorithm {:cooldownPeriod string,
                    :yarnConfig BasicYarnAutoscalingConfig},
   :workerConfig {:maxInstances integer,
                  :minInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:maxInstances integer,
                           :minInstances integer,
                           :weight integer},
   :id string}
  
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

(defn regions-autoscalingPolicies-setIamPolicy$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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

(defn regions-autoscalingPolicies-update$
  "https://cloud.google.com/dataproc/api/reference/rest/v1/projects/regions/autoscalingPolicies/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :basicAlgorithm {:cooldownPeriod string,
                    :yarnConfig BasicYarnAutoscalingConfig},
   :workerConfig {:maxInstances integer,
                  :minInstances integer,
                  :weight integer},
   :secondaryWorkerConfig {:maxInstances integer,
                           :minInstances integer,
                           :weight integer},
   :id string}
  
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
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
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
  
  Required parameters: projectId, clusterName, region
  
  Optional parameters: gracefulDecommissionTimeout, requestId, updateMask
  
  Body: 
  
  {:clusterName string,
   :projectId string,
   :clusterUuid string,
   :config {:configBucket string,
            :gceClusterConfig GceClusterConfig,
            :metastoreConfig MetastoreConfig,
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
   :statusHistory [{:detail string,
                    :state string,
                    :stateStartTime string,
                    :substate string}],
   :labels {},
   :metrics {:hdfsMetrics {}, :yarnMetrics {}},
   :status {:detail string,
            :state string,
            :stateStartTime string,
            :substate string}}
  
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
  
  Required parameters: region, project, cluster
  
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
  
  Required parameters: region, projectId
  
  Optional parameters: requestId, actionOnFailedPrimaryWorkers
  
  Body: 
  
  {:clusterName string,
   :projectId string,
   :clusterUuid string,
   :config {:configBucket string,
            :gceClusterConfig GceClusterConfig,
            :metastoreConfig MetastoreConfig,
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
   :statusHistory [{:detail string,
                    :state string,
                    :stateStartTime string,
                    :substate string}],
   :labels {},
   :metrics {:hdfsMetrics {}, :yarnMetrics {}},
   :status {:detail string,
            :state string,
            :stateStartTime string,
            :substate string}}
  
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
  
  Required parameters: region, projectId, clusterName
  
  Optional parameters: none
  
  Body: 
  
  {:clusterUuid string, :requestId string}
  
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
  
  Required parameters: clusterName, projectId, region
  
  Optional parameters: clusterUuid, requestId
  
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
  
  Required parameters: clusterName, projectId, region
  
  Optional parameters: none
  
  Body: 
  
  {}
  
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
  
  {:requestId string, :clusterUuid string}
  
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
  
  Required parameters: region, projectId
  
  Optional parameters: pageToken, filter, pageSize
  
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
