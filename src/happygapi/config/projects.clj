(ns happygapi.config.projects
  "Infrastructure Manager API: projects.
  Creates and manages Google Cloud Platform resources and infrastructure.
  See: https://cloud.google.com/infrastructure-manager/docsdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://config.googleapis.com/"
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
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://config.googleapis.com/"
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

(defn locations-deployments-get$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-setIamPolicy$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/setIamPolicy
  
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
     "https://config.googleapis.com/"
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

(defn locations-deployments-deleteState$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/deleteState
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:lockId string}
  
  Deletes Terraform state file in a given deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+name}:deleteState"
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

(defn locations-deployments-patch$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :latestRevision string,
   :stateDetail string,
   :errorCode string,
   :lockState string,
   :name string,
   :errorLogs string,
   :createTime string,
   :state string,
   :tfVersion string,
   :updateTime string,
   :tfErrors [{:resourceAddress string,
               :httpResponseCode integer,
               :errorDescription string,
               :error Status}],
   :importExistingResources boolean,
   :artifactsGcsBucket string,
   :deleteLogs string,
   :annotations {},
   :workerPool string,
   :deleteBuild string,
   :deleteResults {:content string, :artifacts string, :outputs {}},
   :tfVersionConstraint string,
   :quotaValidation string,
   :terraformBlueprint {:gcsSource string,
                        :gitSource GitSource,
                        :inputValues {}}}
  
  Updates a Deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-testIamPermissions$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/testIamPermissions
  
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
     "https://config.googleapis.com/"
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

(defn locations-deployments-create$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/create
  
  Required parameters: parent
  
  Optional parameters: deploymentId, requestId
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :latestRevision string,
   :stateDetail string,
   :errorCode string,
   :lockState string,
   :name string,
   :errorLogs string,
   :createTime string,
   :state string,
   :tfVersion string,
   :updateTime string,
   :tfErrors [{:resourceAddress string,
               :httpResponseCode integer,
               :errorDescription string,
               :error Status}],
   :importExistingResources boolean,
   :artifactsGcsBucket string,
   :deleteLogs string,
   :annotations {},
   :workerPool string,
   :deleteBuild string,
   :deleteResults {:content string, :artifacts string, :outputs {}},
   :tfVersionConstraint string,
   :quotaValidation string,
   :terraformBlueprint {:gcsSource string,
                        :gitSource GitSource,
                        :inputValues {}}}
  
  Creates a Deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/deployments"
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

(defn locations-deployments-delete$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force, deletePolicy
  
  Deletes a Deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-getIamPolicy$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-exportState$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/exportState
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:draft boolean}
  
  Exports Terraform state file from a given deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}:exportState"
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

(defn locations-deployments-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Deployments in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/deployments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deployments-exportLock$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/exportLock
  
  Required parameters: name
  
  Optional parameters: none
  
  Exports the lock info on a locked deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+name}:exportLock"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deployments-unlock$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/unlock
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:lockId string}
  
  Unlocks a locked deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+name}:unlock"
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

(defn locations-deployments-importState$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/importState
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:lockId string}
  
  Imports Terraform state file in a given deployment. The state file does not take effect until the Deployment has been unlocked."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}:importState"
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

(defn locations-deployments-lock$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/lock
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Locks a deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+name}:lock"
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

(defn locations-deployments-revisions-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/revisions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Revisions of a deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/revisions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-deployments-revisions-get$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/revisions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-revisions-exportState$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/revisions/exportState
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Exports Terraform state file from a given revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}:exportState"
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

(defn locations-deployments-revisions-resources-get$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/revisions/resources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Resource deployed by Infra Manager."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-deployments-revisions-resources-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/deployments/revisions/resources/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Resources in a given revision."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/resources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-previews-create$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/previews/create
  
  Required parameters: parent
  
  Optional parameters: previewId, requestId
  
  Body: 
  
  {:serviceAccount string,
   :labels {},
   :errorCode string,
   :logs string,
   :name string,
   :errorStatus {:code integer, :message string, :details [{}]},
   :errorLogs string,
   :createTime string,
   :state string,
   :tfVersion string,
   :tfErrors [{:resourceAddress string,
               :httpResponseCode integer,
               :errorDescription string,
               :error Status}],
   :build string,
   :artifactsGcsBucket string,
   :deployment string,
   :annotations {},
   :previewMode string,
   :workerPool string,
   :tfVersionConstraint string,
   :previewArtifacts {:content string, :artifacts string},
   :terraformBlueprint {:gcsSource string,
                        :gitSource GitSource,
                        :inputValues {}}}
  
  Creates a Preview."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/previews"
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

(defn locations-previews-get$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/previews/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Preview."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-previews-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/previews/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Previews in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/previews"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-previews-delete$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/previews/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Preview."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://config.googleapis.com/"
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

(defn locations-previews-export$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/previews/export
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Export Preview results."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}:export"
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

(defn locations-terraformVersions-list$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/terraformVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists TerraformVersions in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
     "v1/{+parent}/terraformVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-terraformVersions-get$
  "https://cloud.google.com/infrastructure-manager/docsapi/reference/rest/v1/projects/locations/terraformVersions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a TerraformVersion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://config.googleapis.com/"
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
