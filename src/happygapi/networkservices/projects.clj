(ns happygapi.networkservices.projects
  "Network Services API: projects.
  
  See: https://cloud.google.com/networkingapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-httpRoutes-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/httpRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists HttpRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/httpRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-httpRoutes-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/httpRoutes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single HttpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-httpRoutes-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/httpRoutes/create
  
  Required parameters: parent
  
  Optional parameters: httpRouteId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :hostnames [string],
   :rules [{:matches [HttpRouteRouteMatch],
            :action HttpRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Creates a new HttpRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/httpRoutes"
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

(defn locations-httpRoutes-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/httpRoutes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :hostnames [string],
   :rules [{:matches [HttpRouteRouteMatch],
            :action HttpRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Updates the parameters of a single HttpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-httpRoutes-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/httpRoutes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single HttpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheKeysets-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheKeysets/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheKeysets-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheKeysets/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheKeysets-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheKeysets/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists EndpointPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/endpointPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-endpointPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single EndpointPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/create
  
  Required parameters: parent
  
  Optional parameters: endpointPolicyId
  
  Body: 
  
  {:description string,
   :trafficPortSelector {:ports [string]},
   :labels {},
   :endpointMatcher {:metadataLabelMatcher EndpointMatcherMetadataLabelMatcher},
   :name string,
   :clientTlsPolicy string,
   :createTime string,
   :type string,
   :serverTlsPolicy string,
   :updateTime string,
   :authorizationPolicy string}
  
  Creates a new EndpointPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/endpointPolicies"
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

(defn locations-endpointPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :trafficPortSelector {:ports [string]},
   :labels {},
   :endpointMatcher {:metadataLabelMatcher EndpointMatcherMetadataLabelMatcher},
   :name string,
   :clientTlsPolicy string,
   :createTime string,
   :type string,
   :serverTlsPolicy string,
   :updateTime string,
   :authorizationPolicy string}
  
  Updates the parameters of a single EndpointPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single EndpointPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-endpointPolicies-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/endpointPolicies/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheOrigins-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheOrigins/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheOrigins-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheOrigins/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheOrigins-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheOrigins/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-grpcRoutes-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/grpcRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists GrpcRoutes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/grpcRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-grpcRoutes-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/grpcRoutes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single GrpcRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-grpcRoutes-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/grpcRoutes/create
  
  Required parameters: parent
  
  Optional parameters: grpcRouteId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :hostnames [string],
   :rules [{:matches [GrpcRouteRouteMatch],
            :action GrpcRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Creates a new GrpcRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/grpcRoutes"
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

(defn locations-grpcRoutes-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/grpcRoutes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :hostnames [string],
   :rules [{:matches [GrpcRouteRouteMatch],
            :action GrpcRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Updates the parameters of a single GrpcRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-grpcRoutes-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/grpcRoutes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single GrpcRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists ServiceLbPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/serviceLbPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceLbPolicies-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceLbPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/create
  
  Required parameters: parent
  
  Optional parameters: serviceLbPolicyId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :loadBalancingAlgorithm string,
   :autoCapacityDrain {:enable boolean},
   :failoverConfig {:failoverHealthThreshold integer}}
  
  Creates a new ServiceLbPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/serviceLbPolicies"
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

(defn locations-serviceLbPolicies-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :loadBalancingAlgorithm string,
   :autoCapacityDrain {:enable boolean},
   :failoverConfig {:failoverHealthThreshold integer}}
  
  Updates the parameters of a single ServiceLbPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ServiceLbPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceLbPolicies-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceLbPolicies/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Gateways in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/gateways"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-gateways-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/create
  
  Required parameters: parent
  
  Optional parameters: gatewayId
  
  Body: 
  
  {:description string,
   :labels {},
   :addresses [string],
   :certificateUrls [string],
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :serverTlsPolicy string,
   :scope string,
   :ipVersion string,
   :updateTime string,
   :ports [integer],
   :envoyHeaders string,
   :gatewaySecurityPolicy string,
   :network string,
   :subnetwork string}
  
  Creates a new Gateway in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/gateways"
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

(defn locations-gateways-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :addresses [string],
   :certificateUrls [string],
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :serverTlsPolicy string,
   :scope string,
   :ipVersion string,
   :updateTime string,
   :ports [integer],
   :envoyHeaders string,
   :gatewaySecurityPolicy string,
   :network string,
   :subnetwork string}
  
  Updates the parameters of a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Gateway."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-gateways-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/gateways/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-tlsRoutes-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists TlsRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/tlsRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tlsRoutes-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsRoutes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single TlsRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-tlsRoutes-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsRoutes/create
  
  Required parameters: parent
  
  Optional parameters: tlsRouteId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :rules [{:matches [TlsRouteRouteMatch], :action TlsRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Creates a new TlsRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/tlsRoutes"
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

(defn locations-tlsRoutes-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsRoutes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :rules [{:matches [TlsRouteRouteMatch], :action TlsRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Updates the parameters of a single TlsRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-tlsRoutes-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tlsRoutes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single TlsRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbTrafficExtensions-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbTrafficExtensions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `LbTrafficExtension` resources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/lbTrafficExtensions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lbTrafficExtensions-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbTrafficExtensions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of the specified `LbTrafficExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbTrafficExtensions-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbTrafficExtensions/create
  
  Required parameters: parent
  
  Optional parameters: lbTrafficExtensionId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :labels {},
   :forwardingRules [string],
   :extensionChains [{:name string,
                      :matchCondition ExtensionChainMatchCondition,
                      :extensions [ExtensionChainExtension]}],
   :loadBalancingScheme string}
  
  Creates a new `LbTrafficExtension` resource in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/lbTrafficExtensions"
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

(defn locations-lbTrafficExtensions-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbTrafficExtensions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :labels {},
   :forwardingRules [string],
   :extensionChains [{:name string,
                      :matchCondition ExtensionChainMatchCondition,
                      :extensions [ExtensionChainExtension]}],
   :loadBalancingScheme string}
  
  Updates the parameters of the specified `LbTrafficExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbTrafficExtensions-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbTrafficExtensions/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes the specified `LbTrafficExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists Meshes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/meshes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-meshes-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Mesh."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/create
  
  Required parameters: parent
  
  Optional parameters: meshId
  
  Body: 
  
  {:name string,
   :selfLink string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :interceptionPort integer,
   :envoyHeaders string}
  
  Creates a new Mesh in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/meshes"
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

(defn locations-meshes-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :selfLink string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :interceptionPort integer,
   :envoyHeaders string}
  
  Updates the parameters of a single Mesh."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single Mesh."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-meshes-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/meshes/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheServices-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheServices/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheServices-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheServices/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-edgeCacheServices-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/edgeCacheServices/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-tcpRoutes-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tcpRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists TcpRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/tcpRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tcpRoutes-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tcpRoutes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single TcpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-tcpRoutes-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tcpRoutes/create
  
  Required parameters: parent
  
  Optional parameters: tcpRouteId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :rules [{:matches [TcpRouteRouteMatch], :action TcpRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Creates a new TcpRoute in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/tcpRoutes"
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

(defn locations-tcpRoutes-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tcpRoutes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :selfLink string,
   :rules [{:matches [TcpRouteRouteMatch], :action TcpRouteRouteAction}],
   :updateTime string,
   :gateways [string],
   :meshes [string]}
  
  Updates the parameters of a single TcpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-tcpRoutes-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/tcpRoutes/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single TcpRoute."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbRouteExtensions-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbRouteExtensions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists `LbRouteExtension` resources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/lbRouteExtensions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-lbRouteExtensions-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbRouteExtensions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of the specified `LbRouteExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbRouteExtensions-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbRouteExtensions/create
  
  Required parameters: parent
  
  Optional parameters: lbRouteExtensionId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :labels {},
   :forwardingRules [string],
   :extensionChains [{:name string,
                      :matchCondition ExtensionChainMatchCondition,
                      :extensions [ExtensionChainExtension]}],
   :loadBalancingScheme string}
  
  Creates a new `LbRouteExtension` resource in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/lbRouteExtensions"
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

(defn locations-lbRouteExtensions-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbRouteExtensions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :description string,
   :labels {},
   :forwardingRules [string],
   :extensionChains [{:name string,
                      :matchCondition ExtensionChainMatchCondition,
                      :extensions [ExtensionChainExtension]}],
   :loadBalancingScheme string}
  
  Updates the parameters of the specified `LbRouteExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-lbRouteExtensions-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/lbRouteExtensions/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes the specified `LbRouteExtension` resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceBindings-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists ServiceBinding in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/serviceBindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceBindings-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceBindings-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/create
  
  Required parameters: parent
  
  Optional parameters: serviceBindingId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :service string,
   :serviceId string,
   :labels {}}
  
  Creates a new ServiceBinding in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkservices.googleapis.com/"
     "v1/{+parent}/serviceBindings"
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

(defn locations-serviceBindings-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a single ServiceBinding."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceBindings-setIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/setIamPolicy
  
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
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceBindings-getIamPolicy$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkservices.googleapis.com/"
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

(defn locations-serviceBindings-testIamPermissions$
  "https://cloud.google.com/networkingapi/reference/rest/v1/projects/locations/serviceBindings/testIamPermissions
  
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
     "https://networkservices.googleapis.com/"
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
