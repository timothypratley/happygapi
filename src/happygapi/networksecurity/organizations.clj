(ns happygapi.networksecurity.organizations
  "Network Security API: organizations.
  
  See: https://cloud.google.com/networkingapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/operations/cancel
  
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
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :capacity integer,
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :updateTime string,
   :items [string]}
  
  Updates parameters of an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/create
  
  Required parameters: parent
  
  Optional parameters: addressGroupId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :capacity integer,
   :name string,
   :createTime string,
   :selfLink string,
   :type string,
   :updateTime string,
   :items [string]}
  
  Creates a new address group in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/addressGroups"
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

(defn locations-addressGroups-addItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/addItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:items [string], :requestId string}
  
  Adds items to an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:addItems"
     #{:addressGroup}
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

(defn locations-addressGroups-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-addressGroups-listReferences$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/listReferences
  
  Required parameters: addressGroup
  
  Optional parameters: pageSize, pageToken
  
  Lists references of an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:listReferences"
     #{:addressGroup}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-addressGroups-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists address groups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/addressGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-addressGroups-cloneItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/cloneItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:sourceAddressGroup string, :requestId string}
  
  Clones items from one address group to another."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:cloneItems"
     #{:addressGroup}
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

(defn locations-addressGroups-removeItems$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/addressGroups/removeItems
  
  Required parameters: addressGroup
  
  Optional parameters: none
  
  Body: 
  
  {:items [string], :requestId string}
  
  Removes items from an address group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:addressGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+addressGroup}:removeItems"
     #{:addressGroup}
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

(defn locations-firewallEndpoints-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/firewallEndpoints/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists FirewallEndpoints in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/firewallEndpoints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-firewallEndpoints-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/firewallEndpoints/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-firewallEndpoints-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/firewallEndpoints/create
  
  Required parameters: parent
  
  Optional parameters: firewallEndpointId, requestId
  
  Body: 
  
  {:description string,
   :associatedNetworks [string],
   :labels {},
   :name string,
   :createTime string,
   :state string,
   :associations [{:name string, :network string}],
   :updateTime string,
   :reconciling boolean,
   :billingProjectId string}
  
  Creates a new FirewallEndpoint in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/firewallEndpoints"
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

(defn locations-firewallEndpoints-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/firewallEndpoints/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-firewallEndpoints-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/firewallEndpoints/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :associatedNetworks [string],
   :labels {},
   :name string,
   :createTime string,
   :state string,
   :associations [{:name string, :network string}],
   :updateTime string,
   :reconciling boolean,
   :billingProjectId string}
  
  Update a single Endpoint."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfileGroups-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfileGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists SecurityProfileGroups in a given organization and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/securityProfileGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-securityProfileGroups-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfileGroups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single SecurityProfileGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfileGroups-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfileGroups/create
  
  Required parameters: parent
  
  Optional parameters: securityProfileGroupId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :etag string,
   :labels {},
   :threatPreventionProfile string}
  
  Creates a new SecurityProfileGroup in a given organization and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/securityProfileGroups"
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

(defn locations-securityProfileGroups-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfileGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :updateTime string,
   :etag string,
   :labels {},
   :threatPreventionProfile string}
  
  Updates the parameters of a single SecurityProfileGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfileGroups-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfileGroups/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a single SecurityProfileGroup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfiles-list$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists SecurityProfiles in a given organization and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/securityProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-securityProfiles-get$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single SecurityProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfiles-create$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfiles/create
  
  Required parameters: parent
  
  Optional parameters: securityProfileId
  
  Body: 
  
  {:threatPreventionProfile {:severityOverrides [SeverityOverride],
                             :threatOverrides [ThreatOverride]},
   :name string,
   :description string,
   :createTime string,
   :updateTime string,
   :etag string,
   :labels {},
   :type string}
  
  Creates a new SecurityProfile in a given organization and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://networksecurity.googleapis.com/"
     "v1/{+parent}/securityProfiles"
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

(defn locations-securityProfiles-patch$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:threatPreventionProfile {:severityOverrides [SeverityOverride],
                             :threatOverrides [ThreatOverride]},
   :name string,
   :description string,
   :createTime string,
   :updateTime string,
   :etag string,
   :labels {},
   :type string}
  
  Updates the parameters of a single SecurityProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://networksecurity.googleapis.com/"
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

(defn locations-securityProfiles-delete$
  "https://cloud.google.com/networkingapi/reference/rest/v1/organizations/locations/securityProfiles/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a single SecurityProfile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://networksecurity.googleapis.com/"
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
