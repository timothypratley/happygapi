(ns happygapi.cloudfunctions.projects
  "Cloud Functions API: projects.
  Manages lightweight user-provided functions executed in response to events.
  See: https://cloud.google.com/functionsapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-get$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/get
  
  Required parameters: name
  
  Optional parameters: revision
  
  Returns a function with the given name from the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-setIamPolicy$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/setIamPolicy
  
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
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-setupFunctionUpgradeConfig$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/setupFunctionUpgradeConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Creates a 2nd Gen copy of the function configuration based on the 1st Gen function with the given name. This is the first step of the multi step process to upgrade 1st Gen functions to 2nd Gen. Only 2nd Gen configuration is setup as part of this request and traffic continues to be served by 1st Gen."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:setupFunctionUpgradeConfig"
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

(defn locations-functions-patch$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :upgradeInfo {:upgradeState string,
                 :serviceConfig ServiceConfig,
                 :eventTrigger EventTrigger,
                 :buildConfig BuildConfig},
   :buildConfig {:serviceAccount string,
                 :sourceToken string,
                 :entryPoint string,
                 :environmentVariables {},
                 :source Source,
                 :build string,
                 :automaticUpdatePolicy AutomaticUpdatePolicy,
                 :runtime string,
                 :sourceProvenance SourceProvenance,
                 :dockerRepository string,
                 :workerPool string,
                 :onDeployUpdatePolicy OnDeployUpdatePolicy,
                 :dockerRegistry string},
   :state string,
   :updateTime string,
   :eventTrigger {:eventType string,
                  :service string,
                  :triggerRegion string,
                  :retryPolicy string,
                  :channel string,
                  :pubsubTopic string,
                  :eventFilters [EventFilter],
                  :serviceAccountEmail string,
                  :trigger string},
   :satisfiesPzs boolean,
   :serviceConfig {:maxInstanceCount integer,
                   :service string,
                   :maxInstanceRequestConcurrency integer,
                   :secretEnvironmentVariables [SecretEnvVar],
                   :secretVolumes [SecretVolume],
                   :revision string,
                   :allTrafficOnLatestRevision boolean,
                   :environmentVariables {},
                   :vpcConnector string,
                   :timeoutSeconds integer,
                   :vpcConnectorEgressSettings string,
                   :availableMemory string,
                   :serviceAccountEmail string,
                   :securityLevel string,
                   :minInstanceCount integer,
                   :uri string,
                   :availableCpu string,
                   :ingressSettings string},
   :kmsKeyName string,
   :url string,
   :environment string,
   :stateMessages [{:severity string, :type string, :message string}]}
  
  Updates existing function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-testIamPermissions$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/testIamPermissions
  
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
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-redirectFunctionUpgradeTraffic$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/redirectFunctionUpgradeTraffic
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Changes the traffic target of a function from the original 1st Gen function to the 2nd Gen copy. This is the second step of the multi step process to upgrade 1st Gen functions to 2nd Gen. After this operation, all new traffic will be served by 2nd Gen copy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:redirectFunctionUpgradeTraffic"
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

(defn locations-functions-create$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/create
  
  Required parameters: parent
  
  Optional parameters: functionId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :upgradeInfo {:upgradeState string,
                 :serviceConfig ServiceConfig,
                 :eventTrigger EventTrigger,
                 :buildConfig BuildConfig},
   :buildConfig {:serviceAccount string,
                 :sourceToken string,
                 :entryPoint string,
                 :environmentVariables {},
                 :source Source,
                 :build string,
                 :automaticUpdatePolicy AutomaticUpdatePolicy,
                 :runtime string,
                 :sourceProvenance SourceProvenance,
                 :dockerRepository string,
                 :workerPool string,
                 :onDeployUpdatePolicy OnDeployUpdatePolicy,
                 :dockerRegistry string},
   :state string,
   :updateTime string,
   :eventTrigger {:eventType string,
                  :service string,
                  :triggerRegion string,
                  :retryPolicy string,
                  :channel string,
                  :pubsubTopic string,
                  :eventFilters [EventFilter],
                  :serviceAccountEmail string,
                  :trigger string},
   :satisfiesPzs boolean,
   :serviceConfig {:maxInstanceCount integer,
                   :service string,
                   :maxInstanceRequestConcurrency integer,
                   :secretEnvironmentVariables [SecretEnvVar],
                   :secretVolumes [SecretVolume],
                   :revision string,
                   :allTrafficOnLatestRevision boolean,
                   :environmentVariables {},
                   :vpcConnector string,
                   :timeoutSeconds integer,
                   :vpcConnectorEgressSettings string,
                   :availableMemory string,
                   :serviceAccountEmail string,
                   :securityLevel string,
                   :minInstanceCount integer,
                   :uri string,
                   :availableCpu string,
                   :ingressSettings string},
   :kmsKeyName string,
   :url string,
   :environment string,
   :stateMessages [{:severity string, :type string, :message string}]}
  
  Creates a new function. If a function with the given name already exists in the specified project, the long running operation will return `ALREADY_EXISTS` error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+parent}/functions"
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

(defn locations-functions-generateUploadUrl$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/generateUploadUrl
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:kmsKeyName string, :environment string}
  
  Returns a signed URL for uploading a function source code. For more information about the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls. Once the function source code upload is complete, the used signed URL should be provided in CreateFunction or UpdateFunction request as a reference to the function source code. When uploading source code to the generated signed URL, please follow these restrictions: * Source file type should be a zip file. * No credentials should be attached - the signed URLs provide access to the target bucket using internal service identity; if credentials were attached, the identity from the credentials would be used, but that identity does not have permissions to upload files to the URL. When making a HTTP PUT request, specify this header: * `content-type: application/zip` Do not specify this header: * `Authorization: Bearer YOUR_TOKEN`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+parent}/functions:generateUploadUrl"
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

(defn locations-functions-delete$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a function with the given name from the specified project. If the given function is used by some trigger, the trigger will be updated to remove this function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-getIamPolicy$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
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

(defn locations-functions-generateDownloadUrl$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/generateDownloadUrl
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns a signed URL for downloading deployed function source code. The URL is only valid for a limited period and should be used within 30 minutes of generation. For more information about the signed URL usage see: https://cloud.google.com/storage/docs/access-control/signed-urls"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:generateDownloadUrl"
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

(defn locations-functions-commitFunctionUpgrade$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/commitFunctionUpgrade
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Finalizes the upgrade after which function upgrade can not be rolled back. This is the last step of the multi step process to upgrade 1st Gen functions to 2nd Gen. Deletes all original 1st Gen related configuration and resources."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:commitFunctionUpgrade"
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

(defn locations-functions-list$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns a list of functions that belong to the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+parent}/functions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-functions-rollbackFunctionUpgradeTraffic$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/rollbackFunctionUpgradeTraffic
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reverts the traffic target of a function from the 2nd Gen copy to the original 1st Gen function. After this operation, all new traffic would be served by the 1st Gen."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:rollbackFunctionUpgradeTraffic"
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

(defn locations-functions-abortFunctionUpgrade$
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/functions/abortFunctionUpgrade
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Aborts generation upgrade process for a function with the given name from the specified project. Deletes all 2nd Gen copy related configuration and resources which were created during the upgrade process."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+name}:abortFunctionUpgrade"
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
  "https://cloud.google.com/functionsapi/reference/rest/v2/projects/locations/runtimes/list
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Returns a list of runtimes that are supported for the requested project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudfunctions.googleapis.com/"
     "v2/{+parent}/runtimes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
