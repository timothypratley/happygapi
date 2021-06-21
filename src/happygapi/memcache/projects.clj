(ns happygapi.memcache.projects
  "Cloud Memorystore for Memcached API: projects.
  Google Cloud Memorystore for Memcached API is used for creating and managing Memcached instances in GCP.
  See: https://cloud.google.com/memorystore/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-get$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/get
  
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
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

(defn locations-instances-patch$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/patch
  
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
                    :zone string,
                    :nodeId string,
                    :parameters MemcacheParameters,
                    :host string,
                    :state string}],
   :discoveryEndpoint string,
   :nodeCount integer,
   :parameters {:params {}, :id string},
   :instanceMessages [{:code string, :message string}],
   :authorizedNetwork string}
  
  Updates an existing Instance in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://memcache.googleapis.com/"
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

(defn locations-instances-create$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/create
  
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
                    :zone string,
                    :nodeId string,
                    :parameters MemcacheParameters,
                    :host string,
                    :state string}],
   :discoveryEndpoint string,
   :nodeCount integer,
   :parameters {:params {}, :id string},
   :instanceMessages [{:code string, :message string}],
   :authorizedNetwork string}
  
  Creates a new Instance in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
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

(defn locations-instances-get$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/get
  
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

(defn locations-instances-applyParameters$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/applyParameters
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:applyAll boolean, :nodeIds [string]}
  
  `ApplyParameters` restarts the set of specified nodes in order to update them to the current set of parameters for the Memcached Instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1/{+name}:applyParameters"
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

(defn locations-instances-list$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, pageSize, pageToken, filter
  
  Lists Instances in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-updateParameters$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/updateParameters
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:parameters {:params {}, :id string}, :updateMask string}
  
  Updates the defined Memcached parameters for an existing instance. This method only stages the parameters, it must be followed by `ApplyParameters` to apply the parameters to nodes of the Memcached instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://memcache.googleapis.com/"
     "v1/{+name}:updateParameters"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/instances/delete
  
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://memcache.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://memcache.googleapis.com/"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
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
  "https://cloud.google.com/memorystore/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://memcache.googleapis.com/"
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
