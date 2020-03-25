(ns happygapi.memcache.projects
  "Cloud Memorystore for Memcached API: projects.
  Google Cloud Memorystore for Memcached API is used for creating and managing Memcached instances in GCP.
  See: https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}/locations"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation.  The server
  makes a best effort to cancel the operation, but success is not
  guaranteed.  If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`.  Clients can use
  Operations.GetOperation or
  other methods to check whether the cancellation succeeded or whether the
  operation completed despite cancellation. On successful cancellation,
  the operation is not deleted; instead, it becomes an operation with
  an Operation.error value with a google.rpc.Status.code of 1,
  corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}:cancel"
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

(defn locations-operations-delete$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is
  no longer interested in the operation result. It does not cancel the
  operation. If the server doesn't support this method, it returns
  `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists operations that match the specified filter in the request. If the
  server doesn't support this method, it returns `UNIMPLEMENTED`.
  
  NOTE: the `name` binding allows API services to override the binding
  to use different resource name schemes, such as `users/*/operations`. To
  override the binding, API services can add a binding such as
  `\"/v1/{name=users/*}/operations\"` to their service configuration.
  For backwards compatibility, the default name includes the operations
  collection id, however overriding users must ensure the name binding
  is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}/operations"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation.  Clients can use this
  method to poll the operation result at intervals as recommended by the API
  service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+resource}:setIamPolicy"
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

(defn locations-instances-applyParameters$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/applyParameters
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:applyAll boolean, :nodeIds [string]}
  
  ApplyParameters will update current set of Parameters to the set of
  specified nodes of the Memcached Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}:applyParameters"
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

(defn locations-instances-patch$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :nodeConfig {:memorySizeMb integer, :cpuCount integer},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :memcacheFullVersion string,
   :memcacheVersion string,
   :zones [string],
   :memcacheNodes [{:port integer,
                    :nodeId string,
                    :host string,
                    :zone string,
                    :state string,
                    :parameters MemcacheParameters}],
   :discoveryEndpoint string,
   :nodeCount integer,
   :parameters {:id string, :params {}},
   :instanceMessages [{:message string, :code string}],
   :authorizedNetwork string}
  
  Updates an existing Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+resource}:testIamPermissions"
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

(defn locations-instances-create$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:labels {},
   :nodeConfig {:memorySizeMb integer, :cpuCount integer},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :memcacheFullVersion string,
   :memcacheVersion string,
   :zones [string],
   :memcacheNodes [{:port integer,
                    :nodeId string,
                    :host string,
                    :zone string,
                    :state string,
                    :parameters MemcacheParameters}],
   :discoveryEndpoint string,
   :nodeCount integer,
   :parameters {:id string, :params {}},
   :instanceMessages [{:message string, :code string}],
   :authorizedNetwork string}
  
  Creates a new Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+parent}/instances"
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

(defn locations-instances-updateParameters$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/updateParameters
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string, :parameters {:id string, :params {}}}
  
  Updates the defined Memcached Parameters for an existing Instance.
  This method only stages the parameters, it must be followed by
  ApplyParameters to apply the parameters to nodes of the Memcached Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}:updateParameters"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+name}"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-list$
  "https://cloud.google.com/memorystore/api/reference/rest/v1beta2/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, orderBy, pageSize, filter
  
  Lists Instances in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1beta2/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
