(ns happygapi.apigeeregistry.projects
  "Apigee Registry API: projects.
  
  See: https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-instances-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :state string,
   :stateMessage string,
   :config {:location string, :cmekKeyName string},
   :build {:repo string, :commitId string, :commitTime string}}
  
  Provisions instance resources for the Registry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-instances-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the Registry instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-instances-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-instances-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-instances-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/instances/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching APIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/apis"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/create
  
  Required parameters: parent
  
  Optional parameters: apiId
  
  Body: 
  
  {:description string,
   :labels {},
   :availability string,
   :displayName string,
   :name string,
   :recommendedVersion string,
   :createTime string,
   :updateTime string,
   :annotations {},
   :recommendedDeployment string}
  
  Creates a specified API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/apis"
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

(defn locations-apis-patch$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :availability string,
   :displayName string,
   :name string,
   :recommendedVersion string,
   :createTime string,
   :updateTime string,
   :annotations {},
   :recommendedDeployment string}
  
  Used to modify a specified API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Removes a specified API and all of the resources that it owns."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/create
  
  Required parameters: parent
  
  Optional parameters: apiVersionId
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :annotations {},
   :primarySpec string}
  
  Creates a specified version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-patch$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :annotations {},
   :primarySpec string}
  
  Used to modify a specified version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Removes a specified version and all of the resources that it owns."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-rollback$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:revisionId string}
  
  Sets the current revision to a specified prior revision. Note that this creates a new revision with a new revision ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified spec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-patch$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :labels {},
   :hash string,
   :revisionCreateTime string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :revisionId string,
   :filename string,
   :sourceUri string,
   :mimeType string,
   :annotations {},
   :contents string,
   :revisionUpdateTime string}
  
  Used to modify a specified spec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/create
  
  Required parameters: parent
  
  Optional parameters: apiSpecId
  
  Body: 
  
  {:description string,
   :labels {},
   :hash string,
   :revisionCreateTime string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :revisionId string,
   :filename string,
   :sourceUri string,
   :mimeType string,
   :annotations {},
   :contents string,
   :revisionUpdateTime string}
  
  Creates a specified spec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/specs"
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

(defn locations-apis-versions-specs-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified spec. If specs are stored with GZip compression, the default behavior is to return the spec uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-specs-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Removes a specified spec, all revisions, and all child resources (e.g., artifacts)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching specs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/specs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-specs-tagRevision$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/tagRevision
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:tag string}
  
  Adds a tag to a specified revision of a spec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:tagRevision"
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

(defn locations-apis-versions-specs-deleteRevision$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/deleteRevision
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a revision of a spec."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:deleteRevision"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-specs-listRevisions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/listRevisions
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all revisions of a spec. Revisions are returned in descending order of revision creation time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:listRevisions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-specs-artifacts-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/create
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Creates a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
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

(defn locations-apis-versions-specs-artifacts-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-specs-artifacts-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-replaceArtifact$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/replaceArtifact
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Used to replace a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-specs-artifacts-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/specs/artifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-artifacts-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/create
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Creates a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
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

(defn locations-apis-versions-artifacts-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-versions-artifacts-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-replaceArtifact$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/replaceArtifact
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Used to replace a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-versions-artifacts-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/versions/artifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-deployments-rollback$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/rollback
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:revisionId string}
  
  Sets the current revision to a specified prior revision. Note that this creates a new revision with a new revision ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-patch$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :endpointUri string,
   :labels {},
   :displayName string,
   :revisionCreateTime string,
   :name string,
   :createTime string,
   :revisionId string,
   :externalChannelUri string,
   :intendedAudience string,
   :apiSpecRevision string,
   :annotations {},
   :accessGuidance string,
   :revisionUpdateTime string}
  
  Used to modify a specified deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/create
  
  Required parameters: parent
  
  Optional parameters: apiDeploymentId
  
  Body: 
  
  {:description string,
   :endpointUri string,
   :labels {},
   :displayName string,
   :revisionCreateTime string,
   :name string,
   :createTime string,
   :revisionId string,
   :externalChannelUri string,
   :intendedAudience string,
   :apiSpecRevision string,
   :annotations {},
   :accessGuidance string,
   :revisionUpdateTime string}
  
  Creates a specified deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Removes a specified deployment, all revisions, and all child resources (e.g., artifacts)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching deployments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-tagRevision$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/tagRevision
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:tag string}
  
  Adds a tag to a specified revision of a deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:tagRevision"
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

(defn locations-apis-deployments-deleteRevision$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/deleteRevision
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a revision of a deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:deleteRevision"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-deployments-listRevisions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/listRevisions
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all revisions of a deployment. Revisions are returned in descending order of revision creation time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:listRevisions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-deployments-artifacts-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-deployments-artifacts-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-artifacts-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-deployments-artifacts-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/create
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Creates a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
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

(defn locations-apis-deployments-artifacts-replaceArtifact$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/replaceArtifact
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Used to replace a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-deployments-artifacts-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/deployments/artifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/create
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Creates a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
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

(defn locations-apis-artifacts-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-apis-artifacts-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-replaceArtifact$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/replaceArtifact
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Used to replace a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-apis-artifacts-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/apis/artifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-artifacts-get$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-create$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/create
  
  Required parameters: parent
  
  Optional parameters: artifactId
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Creates a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
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

(defn locations-artifacts-getContents$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/getContents
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the contents of a specified artifact. If artifacts are stored with GZip compression, the default behavior is to return the artifact uncompressed (the mime_type response field indicates the exact format returned)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+name}:getContents"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-artifacts-delete$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-replaceArtifact$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/replaceArtifact
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :hash string,
   :name string,
   :sizeBytes integer,
   :createTime string,
   :updateTime string,
   :mimeType string,
   :annotations {},
   :contents string}
  
  Used to replace a specified artifact."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-artifacts-list$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/artifacts/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Returns matching artifacts."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
     "v1/{+parent}/artifacts"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-runtime-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/runtime/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-runtime-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/runtime/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-runtime-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/runtime/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-documents-setIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/documents/setIamPolicy
  
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
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-documents-getIamPolicy$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/documents/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://apigeeregistry.googleapis.com/"
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

(defn locations-documents-testIamPermissions$
  "https://cloud.google.com/apigee/docs/api-hub/what-is-api-hubapi/reference/rest/v1/projects/locations/documents/testIamPermissions
  
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
     "https://apigeeregistry.googleapis.com/"
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
