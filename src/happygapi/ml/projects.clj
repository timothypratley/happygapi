(ns happygapi.ml.projects
  "AI Platform Training & Prediction API: projects.
  An API to enable creating and using machine learning models.
  See: https://cloud.google.com/ml/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn explain$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/explain
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:extensions [{}], :contentType string, :data string}}
  
  Performs explanation on the data in the request. {% dynamic include \"/ai-platform/includes/___explain-request\" %} "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:explain"
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

(defn predict$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/predict
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:httpBody {:extensions [{}], :contentType string, :data string}}
  
  Performs online prediction on the data in the request. {% dynamic include \"/ai-platform/includes/___predict-request\" %} "
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:predict"
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

(defn getConfig$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/getConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the service account information associated with your project. You need this information in order to grant the service account permissions for the Google Cloud Storage location where you put your model training code for training the model with Google Cloud Machine Learning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:getConfig"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Describes a job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn jobs-patch$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :errorMessage string,
   :predictionOutput {:predictionCount string,
                      :outputPath string,
                      :nodeHours number,
                      :errorCount string},
   :startTime string,
   :endTime string,
   :createTime string,
   :etag string,
   :state string,
   :trainingOutput {:isHyperparameterTuningJob boolean,
                    :isBuiltInAlgorithmJob boolean,
                    :builtInAlgorithmOutput GoogleCloudMlV1__BuiltInAlgorithmOutput,
                    :completedTrialCount string,
                    :hyperparameterMetricTag string,
                    :consumedMLUnits number,
                    :trials [GoogleCloudMlV1__HyperparameterOutput]},
   :trainingInput {:args [string],
                   :serviceAccount string,
                   :useChiefInTfConfig boolean,
                   :parameterServerType string,
                   :workerType string,
                   :scheduling GoogleCloudMlV1__Scheduling,
                   :workerCount string,
                   :evaluatorType string,
                   :hyperparameters GoogleCloudMlV1__HyperparameterSpec,
                   :workerConfig GoogleCloudMlV1__ReplicaConfig,
                   :jobDir string,
                   :evaluatorCount string,
                   :pythonVersion string,
                   :packageUris [string],
                   :region string,
                   :masterConfig GoogleCloudMlV1__ReplicaConfig,
                   :scaleTier string,
                   :runtimeVersion string,
                   :parameterServerCount string,
                   :evaluatorConfig GoogleCloudMlV1__ReplicaConfig,
                   :pythonModule string,
                   :network string,
                   :encryptionConfig GoogleCloudMlV1__EncryptionConfig,
                   :parameterServerConfig GoogleCloudMlV1__ReplicaConfig,
                   :masterType string},
   :predictionInput {:outputPath string,
                     :inputPaths [string],
                     :versionName string,
                     :modelName string,
                     :region string,
                     :outputDataFormat string,
                     :runtimeVersion string,
                     :batchSize string,
                     :uri string,
                     :signatureName string,
                     :maxWorkerCount string,
                     :dataFormat string},
   :jobId string}
  
  Updates a specific job resource. Currently the only supported fields to update are `labels`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn jobs-create$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :errorMessage string,
   :predictionOutput {:predictionCount string,
                      :outputPath string,
                      :nodeHours number,
                      :errorCount string},
   :startTime string,
   :endTime string,
   :createTime string,
   :etag string,
   :state string,
   :trainingOutput {:isHyperparameterTuningJob boolean,
                    :isBuiltInAlgorithmJob boolean,
                    :builtInAlgorithmOutput GoogleCloudMlV1__BuiltInAlgorithmOutput,
                    :completedTrialCount string,
                    :hyperparameterMetricTag string,
                    :consumedMLUnits number,
                    :trials [GoogleCloudMlV1__HyperparameterOutput]},
   :trainingInput {:args [string],
                   :serviceAccount string,
                   :useChiefInTfConfig boolean,
                   :parameterServerType string,
                   :workerType string,
                   :scheduling GoogleCloudMlV1__Scheduling,
                   :workerCount string,
                   :evaluatorType string,
                   :hyperparameters GoogleCloudMlV1__HyperparameterSpec,
                   :workerConfig GoogleCloudMlV1__ReplicaConfig,
                   :jobDir string,
                   :evaluatorCount string,
                   :pythonVersion string,
                   :packageUris [string],
                   :region string,
                   :masterConfig GoogleCloudMlV1__ReplicaConfig,
                   :scaleTier string,
                   :runtimeVersion string,
                   :parameterServerCount string,
                   :evaluatorConfig GoogleCloudMlV1__ReplicaConfig,
                   :pythonModule string,
                   :network string,
                   :encryptionConfig GoogleCloudMlV1__EncryptionConfig,
                   :parameterServerConfig GoogleCloudMlV1__ReplicaConfig,
                   :masterType string},
   :predictionInput {:outputPath string,
                     :inputPaths [string],
                     :versionName string,
                     :modelName string,
                     :region string,
                     :outputDataFormat string,
                     :runtimeVersion string,
                     :batchSize string,
                     :uri string,
                     :signatureName string,
                     :maxWorkerCount string,
                     :dataFormat string},
   :jobId string}
  
  Creates a training or a batch prediction job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/jobs"
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

(defn jobs-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists the jobs in the project. If there are no jobs that match the request parameters, the list request returns an empty response body: {}."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-setIamPolicy$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [GoogleIamV1__AuditConfig],
            :etag string,
            :version integer,
            :bindings [GoogleIamV1__Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn jobs-cancel$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a running job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn jobs-testIamPermissions$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/testIamPermissions
  
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
     "https://ml.googleapis.com/"
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

(defn jobs-getIamPolicy$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/jobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-testIamPermissions$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/testIamPermissions
  
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
     "https://ml.googleapis.com/"
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

(defn models-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the models in a project. Each project can contain multiple models, and each model can have multiple versions. If there are no models that match the request parameters, the list request returns an empty response body: {}."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/models"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn models-getIamPolicy$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-create$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:onlinePredictionConsoleLogging boolean,
   :description string,
   :onlinePredictionLogging boolean,
   :regions [string],
   :labels {},
   :defaultVersion {:description string,
                    :serviceAccount string,
                    :labels {},
                    :explanationConfig GoogleCloudMlV1__ExplanationConfig,
                    :routes GoogleCloudMlV1__RouteMap,
                    :autoScaling GoogleCloudMlV1__AutoScaling,
                    :isDefault boolean,
                    :errorMessage string,
                    :lastUseTime string,
                    :name string,
                    :createTime string,
                    :deploymentUri string,
                    :etag string,
                    :state string,
                    :machineType string,
                    :pythonVersion string,
                    :packageUris [string],
                    :acceleratorConfig GoogleCloudMlV1__AcceleratorConfig,
                    :runtimeVersion string,
                    :manualScaling GoogleCloudMlV1__ManualScaling,
                    :container GoogleCloudMlV1__ContainerSpec,
                    :predictionClass string,
                    :framework string,
                    :requestLoggingConfig GoogleCloudMlV1__RequestLoggingConfig},
   :etag string,
   :name string}
  
  Creates a model which will later contain one or more versions. You must add at least one version before you can request predictions from the model. Add versions by calling projects.models.versions.create."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/models"
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

(defn models-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a model, including its name, the description (if set), and the default version (if at least one version of the model has been deployed)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-patch$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:onlinePredictionConsoleLogging boolean,
   :description string,
   :onlinePredictionLogging boolean,
   :regions [string],
   :labels {},
   :defaultVersion {:description string,
                    :serviceAccount string,
                    :labels {},
                    :explanationConfig GoogleCloudMlV1__ExplanationConfig,
                    :routes GoogleCloudMlV1__RouteMap,
                    :autoScaling GoogleCloudMlV1__AutoScaling,
                    :isDefault boolean,
                    :errorMessage string,
                    :lastUseTime string,
                    :name string,
                    :createTime string,
                    :deploymentUri string,
                    :etag string,
                    :state string,
                    :machineType string,
                    :pythonVersion string,
                    :packageUris [string],
                    :acceleratorConfig GoogleCloudMlV1__AcceleratorConfig,
                    :runtimeVersion string,
                    :manualScaling GoogleCloudMlV1__ManualScaling,
                    :container GoogleCloudMlV1__ContainerSpec,
                    :predictionClass string,
                    :framework string,
                    :requestLoggingConfig GoogleCloudMlV1__RequestLoggingConfig},
   :etag string,
   :name string}
  
  Updates a specific model resource. Currently the only supported fields to update are `description` and `default_version.name`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-setIamPolicy$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [GoogleIamV1__AuditConfig],
            :etag string,
            :version integer,
            :bindings [GoogleIamV1__Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-delete$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a model. You can only delete a model if there are no versions in it. You can delete versions by calling projects.models.versions.delete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-versions-patch$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :explanationConfig {:xraiAttribution GoogleCloudMlV1__XraiAttribution,
                       :integratedGradientsAttribution GoogleCloudMlV1__IntegratedGradientsAttribution,
                       :sampledShapleyAttribution GoogleCloudMlV1__SampledShapleyAttribution},
   :routes {:health string, :predict string},
   :autoScaling {:metrics [GoogleCloudMlV1__MetricSpec],
                 :minNodes integer,
                 :maxNodes integer},
   :isDefault boolean,
   :errorMessage string,
   :lastUseTime string,
   :name string,
   :createTime string,
   :deploymentUri string,
   :etag string,
   :state string,
   :machineType string,
   :pythonVersion string,
   :packageUris [string],
   :acceleratorConfig {:count string, :type string},
   :runtimeVersion string,
   :manualScaling {:nodes integer},
   :container {:image string,
               :env [GoogleCloudMlV1__EnvVar],
               :command [string],
               :args [string],
               :ports [GoogleCloudMlV1__ContainerPort]},
   :predictionClass string,
   :framework string,
   :requestLoggingConfig {:bigqueryTableName string,
                          :samplingPercentage number}}
  
  Updates the specified Version resource. Currently the only update-able fields are `description`, `requestLoggingConfig`, `autoScaling.minNodes`, and `manualScaling.nodes`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-versions-setDefault$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/setDefault
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Designates a version to be the default for the model. The default version is used for prediction requests made against the model that don't specify a version. The first version to be created for a model is automatically set as the default. You must make any subsequent changes to the default version setting manually using this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:setDefault"
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

(defn models-versions-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a model version. Models can have multiple versions. You can call projects.models.versions.list to get the same information that this method returns for all of the versions of a model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-versions-create$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :serviceAccount string,
   :labels {},
   :explanationConfig {:xraiAttribution GoogleCloudMlV1__XraiAttribution,
                       :integratedGradientsAttribution GoogleCloudMlV1__IntegratedGradientsAttribution,
                       :sampledShapleyAttribution GoogleCloudMlV1__SampledShapleyAttribution},
   :routes {:health string, :predict string},
   :autoScaling {:metrics [GoogleCloudMlV1__MetricSpec],
                 :minNodes integer,
                 :maxNodes integer},
   :isDefault boolean,
   :errorMessage string,
   :lastUseTime string,
   :name string,
   :createTime string,
   :deploymentUri string,
   :etag string,
   :state string,
   :machineType string,
   :pythonVersion string,
   :packageUris [string],
   :acceleratorConfig {:count string, :type string},
   :runtimeVersion string,
   :manualScaling {:nodes integer},
   :container {:image string,
               :env [GoogleCloudMlV1__EnvVar],
               :command [string],
               :args [string],
               :ports [GoogleCloudMlV1__ContainerPort]},
   :predictionClass string,
   :framework string,
   :requestLoggingConfig {:bigqueryTableName string,
                          :samplingPercentage number}}
  
  Creates a new version of a model from a trained TensorFlow model. If the version created in the cloud by this call is the first deployed version of the specified model, it will be made the default version of the model. When you add a version to a model that already has one or more versions, the default version does not automatically change. If you want a new version to be the default, you must call projects.models.versions.setDefault."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/versions"
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

(defn models-versions-delete$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a model version. Each model can have multiple versions deployed and in use at any given time. Use this method to remove a single version. Note: You cannot delete the version that is set as the default version of the model unless it is the only remaining version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn models-versions-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/models/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Gets basic information about all the versions of a model. If you expect that a model has many versions, or if you need to handle only a limited number of results at a time, you can request that the list be retrieved in batches (called pages). If there are no versions that match the request parameters, the list request returns an empty response body: {}."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/versions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List all locations that provides at least one type of CMLE capability."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/locations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the complete list of CMLE capabilities in a location, along with their location-specific properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-delete$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-create$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/create
  
  Required parameters: parent
  
  Optional parameters: studyId
  
  Body: 
  
  {:createTime string,
   :name string,
   :studyConfig {:algorithm string,
                 :automatedStoppingConfig GoogleCloudMlV1__AutomatedStoppingConfig,
                 :parameters [GoogleCloudMlV1_StudyConfig_ParameterSpec],
                 :metrics [GoogleCloudMlV1_StudyConfig_MetricSpec]},
   :state string,
   :inactiveReason string}
  
  Creates a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/studies"
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

(defn locations-studies-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all the studies in a region for an associated project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/studies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-trials-create$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:clientId string,
   :startTime string,
   :measurements [{:elapsedTime string,
                   :metrics [GoogleCloudMlV1_Measurement_Metric],
                   :stepCount string}],
   :name string,
   :endTime string,
   :state string,
   :finalMeasurement {:elapsedTime string,
                      :metrics [GoogleCloudMlV1_Measurement_Metric],
                      :stepCount string},
   :infeasibleReason string,
   :trialInfeasible boolean,
   :parameters [{:intValue string,
                 :stringValue string,
                 :floatValue number,
                 :parameter string}]}
  
  Adds a user provided trial to a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/trials"
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

(defn locations-studies-trials-addMeasurement$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/addMeasurement
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:measurement {:elapsedTime string,
                 :metrics [GoogleCloudMlV1_Measurement_Metric],
                 :stepCount string}}
  
  Adds a measurement of the objective metrics to a trial. This measurement is assumed to have been taken before the trial is complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:addMeasurement"
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

(defn locations-studies-trials-delete$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-trials-checkEarlyStoppingState$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/checkEarlyStoppingState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Checks whether a trial should stop or not. Returns a long-running operation. When the operation is successful, it will contain a CheckTrialEarlyStoppingStateResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:checkEarlyStoppingState"
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

(defn locations-studies-trials-stop$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a trial."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-studies-trials-suggest$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/suggest
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:clientId string, :suggestionCount integer}
  
  Adds one or more trials to a study, with parameter values suggested by AI Platform Vizier. Returns a long-running operation associated with the generation of trial suggestions. When this long-running operation succeeds, it will contain a SuggestTrialsResponse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/trials:suggest"
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

(defn locations-studies-trials-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the trials associated with a study."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+parent}/trials"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-studies-trials-complete$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/studies/trials/complete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:finalMeasurement {:elapsedTime string,
                      :metrics [GoogleCloudMlV1_Measurement_Metric],
                      :stepCount string},
   :trialInfeasible boolean,
   :infeasibleReason string}
  
  Marks a trial as complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
     "v1/{+name}:complete"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn operations-cancel$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn operations-list$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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

(defn operations-get$
  "https://cloud.google.com/ml/api/reference/rest/v1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://ml.googleapis.com/"
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
