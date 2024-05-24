(ns happygapi.networkconnectivity.projects
  "Network Connectivity API: projects.
  This API enables connectivity with and between Google Cloud resources.
  See: https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-regionalEndpoints-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/regionalEndpoints/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists RegionalEndpoints in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/regionalEndpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-regionalEndpoints-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/regionalEndpoints/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single RegionalEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-regionalEndpoints-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/regionalEndpoints/create
  
  Required parameters: parent
  
  Optional parameters: regionalEndpointId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :address string,
   :pscForwardingRule string,
   :accessType string,
   :targetGoogleApi string,
   :name string,
   :createTime string,
   :updateTime string,
   :ipAddress string,
   :network string,
   :subnetwork string}
  
  Creates a new RegionalEndpoint in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/regionalEndpoints"
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

(defn locations-regionalEndpoints-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/regionalEndpoints/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single RegionalEndpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ServiceConnectionPolicies in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionPolicies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceConnectionPolicies-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceConnectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/create
  
  Required parameters: parent
  
  Optional parameters: serviceConnectionPolicyId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :pscConfig {:subnetworks [string], :limit string},
   :etag string,
   :updateTime string,
   :serviceClass string,
   :pscConnections [{:consumerForwardingRule string,
                     :pscConnectionId string,
                     :consumerAddress string,
                     :errorType string,
                     :state string,
                     :consumerTargetProject string,
                     :producerInstanceId string,
                     :gceOperation string,
                     :error GoogleRpcStatus,
                     :errorInfo GoogleRpcErrorInfo,
                     :selectedSubnetwork string}],
   :network string,
   :infrastructure string}
  
  Creates a new ServiceConnectionPolicy in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionPolicies"
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

(defn locations-serviceConnectionPolicies-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :pscConfig {:subnetworks [string], :limit string},
   :etag string,
   :updateTime string,
   :serviceClass string,
   :pscConnections [{:consumerForwardingRule string,
                     :pscConnectionId string,
                     :consumerAddress string,
                     :errorType string,
                     :state string,
                     :consumerTargetProject string,
                     :producerInstanceId string,
                     :gceOperation string,
                     :error GoogleRpcStatus,
                     :errorInfo GoogleRpcErrorInfo,
                     :selectedSubnetwork string}],
   :network string,
   :infrastructure string}
  
  Updates the parameters of a single ServiceConnectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag
  
  Deletes a single ServiceConnectionPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionPolicies-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionPolicies/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-listSpokes$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/listSpokes
  
  Required parameters: name
  
  Optional parameters: spokeLocations, pageSize, pageToken, filter, orderBy, view
  
  Lists the Network Connectivity Center spokes associated with a specified hub and location. The list includes both spokes that are attached to the hub and spokes that have been proposed but not yet accepted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+name}:listSpokes"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-hubs-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Network Connectivity Center hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-rejectSpoke$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/rejectSpoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:spokeUri string, :requestId string, :details string}
  
  Rejects a Network Connectivity Center spoke from being attached to a hub. If the spoke was previously in the `ACTIVE` state, it transitions to the `INACTIVE` state and is no longer able to connect to other spokes that are attached to the hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+name}:rejectSpoke"
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

(defn locations-global-hubs-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :spokeSummary {:spokeTypeCounts [SpokeTypeCount],
                  :spokeStateCounts [SpokeStateCount],
                  :spokeStateReasonCounts [SpokeStateReasonCount]},
   :name string,
   :policyMode string,
   :routingVpcs [{:uri string,
                  :requiredForNewSiteToSiteDataTransferSpokes boolean}],
   :createTime string,
   :state string,
   :presetTopology string,
   :routeTables [string],
   :updateTime string,
   :exportPsc boolean,
   :uniqueId string}
  
  Updates the description and/or labels of a Network Connectivity Center hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/create
  
  Required parameters: parent
  
  Optional parameters: hubId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :spokeSummary {:spokeTypeCounts [SpokeTypeCount],
                  :spokeStateCounts [SpokeStateCount],
                  :spokeStateReasonCounts [SpokeStateReasonCount]},
   :name string,
   :policyMode string,
   :routingVpcs [{:uri string,
                  :requiredForNewSiteToSiteDataTransferSpokes boolean}],
   :createTime string,
   :state string,
   :presetTopology string,
   :routeTables [string],
   :updateTime string,
   :exportPsc boolean,
   :uniqueId string}
  
  Creates a new Network Connectivity Center hub in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/hubs"
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

(defn locations-global-hubs-acceptSpoke$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/acceptSpoke
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:spokeUri string, :requestId string}
  
  Accepts a proposal to attach a Network Connectivity Center spoke to a hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+name}:acceptSpoke"
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

(defn locations-global-hubs-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Network Connectivity Center hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the Network Connectivity Center hubs associated with a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/hubs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-hubs-routeTables-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/routeTables/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Network Connectivity Center route table."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-routeTables-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/routeTables/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists route tables in a given hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/routeTables"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-hubs-routeTables-routes-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/routeTables/routes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about the specified route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-routeTables-routes-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/routeTables/routes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists routes in a given route table."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/routes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-hubs-groups-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Network Connectivity Center group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-groups-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists groups in a given hub."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/groups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-hubs-groups-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :autoAccept {:autoAcceptProjects [string]},
   :uid string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :routeTable string}
  
  Updates the parameters of a Network Connectivity Center group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-groups-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-groups-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-hubs-groups-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/hubs/groups/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-policyBasedRoutes-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists policy-based routes in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/policyBasedRoutes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-global-policyBasedRoutes-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single policy-based route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-policyBasedRoutes-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/create
  
  Required parameters: parent
  
  Optional parameters: policyBasedRouteId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :nextHopIlbIp string,
   :name string,
   :interconnectAttachment {:region string},
   :createTime string,
   :selfLink string,
   :warnings [{:code string, :data {}, :warningMessage string}],
   :updateTime string,
   :filter {:ipProtocol string,
            :srcRange string,
            :destRange string,
            :protocolVersion string},
   :priority integer,
   :kind string,
   :virtualMachine {:tags [string]},
   :network string,
   :nextHopOtherRoutes string}
  
  Creates a new policy-based route in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/policyBasedRoutes"
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

(defn locations-global-policyBasedRoutes-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single policy-based route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-policyBasedRoutes-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-policyBasedRoutes-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-global-policyBasedRoutes-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/global/policyBasedRoutes/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionTokens-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionTokens/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceConnectionToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionTokens-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionTokens/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ServiceConnectionTokens in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionTokens"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceConnectionTokens-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionTokens/create
  
  Required parameters: parent
  
  Optional parameters: serviceConnectionTokenId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :token string,
   :expireTime string,
   :network string}
  
  Creates a new ServiceConnectionToken in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionTokens"
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

(defn locations-serviceConnectionTokens-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionTokens/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag
  
  Deletes a single ServiceConnectionToken."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ServiceConnectionMaps in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionMaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceConnectionMaps-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceConnectionMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/create
  
  Required parameters: parent
  
  Optional parameters: serviceConnectionMapId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :serviceClassUri string,
   :name string,
   :createTime string,
   :etag string,
   :producerPscConfigs [{:serviceAttachmentUri string}],
   :updateTime string,
   :token string,
   :serviceClass string,
   :consumerPscConfigs [{:project string,
                         :network string,
                         :disableGlobalAccess boolean,
                         :state string,
                         :producerInstanceId string}],
   :infrastructure string,
   :consumerPscConnections [{:ip string,
                             :pscConnectionId string,
                             :errorType string,
                             :state string,
                             :project string,
                             :producerInstanceId string,
                             :gceOperation string,
                             :error GoogleRpcStatus,
                             :forwardingRule string,
                             :errorInfo GoogleRpcErrorInfo,
                             :network string,
                             :selectedSubnetwork string,
                             :serviceAttachmentUri string}]}
  
  Creates a new ServiceConnectionMap in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceConnectionMaps"
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

(defn locations-serviceConnectionMaps-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :serviceClassUri string,
   :name string,
   :createTime string,
   :etag string,
   :producerPscConfigs [{:serviceAttachmentUri string}],
   :updateTime string,
   :token string,
   :serviceClass string,
   :consumerPscConfigs [{:project string,
                         :network string,
                         :disableGlobalAccess boolean,
                         :state string,
                         :producerInstanceId string}],
   :infrastructure string,
   :consumerPscConnections [{:ip string,
                             :pscConnectionId string,
                             :errorType string,
                             :state string,
                             :project string,
                             :producerInstanceId string,
                             :gceOperation string,
                             :error GoogleRpcStatus,
                             :forwardingRule string,
                             :errorInfo GoogleRpcErrorInfo,
                             :network string,
                             :selectedSubnetwork string,
                             :serviceAttachmentUri string}]}
  
  Updates the parameters of a single ServiceConnectionMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag
  
  Deletes a single ServiceConnectionMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceConnectionMaps-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceConnectionMaps/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the Network Connectivity Center spokes in a specified project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/spokes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-spokes-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a Network Connectivity Center spoke."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/create
  
  Required parameters: parent
  
  Optional parameters: spokeId, requestId
  
  Body: 
  
  {:description string,
   :linkedInterconnectAttachments {:uris [string],
                                   :siteToSiteDataTransfer boolean,
                                   :vpcNetwork string},
   :labels {},
   :spokeType string,
   :group string,
   :hub string,
   :linkedVpcNetwork {:uri string, :excludeExportRanges [string]},
   :name string,
   :reasons [{:code string, :message string, :userDetails string}],
   :linkedRouterApplianceInstances {:instances [RouterApplianceInstance],
                                    :siteToSiteDataTransfer boolean,
                                    :vpcNetwork string},
   :createTime string,
   :linkedVpnTunnels {:uris [string],
                      :siteToSiteDataTransfer boolean,
                      :vpcNetwork string},
   :state string,
   :updateTime string,
   :uniqueId string}
  
  Creates a Network Connectivity Center spoke."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/spokes"
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

(defn locations-spokes-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :linkedInterconnectAttachments {:uris [string],
                                   :siteToSiteDataTransfer boolean,
                                   :vpcNetwork string},
   :labels {},
   :spokeType string,
   :group string,
   :hub string,
   :linkedVpcNetwork {:uri string, :excludeExportRanges [string]},
   :name string,
   :reasons [{:code string, :message string, :userDetails string}],
   :linkedRouterApplianceInstances {:instances [RouterApplianceInstance],
                                    :siteToSiteDataTransfer boolean,
                                    :vpcNetwork string},
   :createTime string,
   :linkedVpnTunnels {:uris [string],
                      :siteToSiteDataTransfer boolean,
                      :vpcNetwork string},
   :state string,
   :updateTime string,
   :uniqueId string}
  
  Updates the parameters of a Network Connectivity Center spoke."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Network Connectivity Center spoke."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-spokes-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/spokes/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ServiceClasses in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/serviceClasses"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-serviceClasses-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ServiceClass."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :serviceClass string,
   :createTime string,
   :updateTime string,
   :labels {},
   :description string,
   :etag string}
  
  Updates the parameters of a single ServiceClass."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/delete
  
  Required parameters: name
  
  Optional parameters: requestId, etag
  
  Deletes a single ServiceClass."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-setIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/setIamPolicy
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-getIamPolicy$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-serviceClasses-testIamPermissions$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/serviceClasses/testIamPermissions
  
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
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-internalRanges-list$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/internalRanges/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists internal ranges in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/internalRanges"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-internalRanges-get$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/internalRanges/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single internal range."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-internalRanges-create$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/internalRanges/create
  
  Required parameters: parent
  
  Optional parameters: internalRangeId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :targetCidrRange [string],
   :name string,
   :ipCidrRange string,
   :createTime string,
   :peering string,
   :updateTime string,
   :prefixLength integer,
   :usage string,
   :overlaps [string],
   :network string,
   :users [string]}
  
  Creates a new internal range in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
     "v1/{+parent}/internalRanges"
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

(defn locations-internalRanges-patch$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/internalRanges/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :targetCidrRange [string],
   :name string,
   :ipCidrRange string,
   :createTime string,
   :peering string,
   :updateTime string,
   :prefixLength integer,
   :usage string,
   :overlaps [string],
   :network string,
   :users [string]}
  
  Updates the parameters of a single internal range."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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

(defn locations-internalRanges-delete$
  "https://cloud.google.com/network-connectivity/docs/reference/networkconnectivity/restapi/reference/rest/v1/projects/locations/internalRanges/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single internal range."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networkconnectivity.googleapis.com/"
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
