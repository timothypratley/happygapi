(ns happygapi.accesscontextmanager.organizations
  "Access Context Manager API: organizations.
  An API for setting attribute based access control to requests to Google Cloud services. *Warning:* Do not mix *v1alpha* and *v1* API usage in the same access policy. The v1alpha API supports new Access Context Manager features, which may have different attributes or behaviors that are not supported by v1. The practice of mixed API usage within a policy may result in the inability to update that policy, including any access levels or service perimeters belonging to it. It is not recommended to use both v1 and v1alpha for modifying policies with critical service perimeters. Modifications using v1alpha should be limited to policies with non-production/non-critical service perimeters.
  See: https://cloud.google.com/access-context-manager/docs/reference/rest/docs/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn gcpUserAccessBindings-list$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/organizations/gcpUserAccessBindings/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all GcpUserAccessBindings for a Google Cloud organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/gcpUserAccessBindings"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn gcpUserAccessBindings-get$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/organizations/gcpUserAccessBindings/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the GcpUserAccessBinding with the given name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn gcpUserAccessBindings-create$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/organizations/gcpUserAccessBindings/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :groupKey string,
   :accessLevels [string],
   :dryRunAccessLevels [string],
   :restrictedClientApplications [{:clientId string, :name string}]}
  
  Creates a GcpUserAccessBinding. If the client specifies a name, the server ignores it. Fails if a resource already exists with the same group_key. Completion of this long-running operation does not necessarily signify that the new binding is deployed onto all affected users, which may take more time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
     "v1/{+parent}/gcpUserAccessBindings"
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

(defn gcpUserAccessBindings-patch$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/organizations/gcpUserAccessBindings/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :groupKey string,
   :accessLevels [string],
   :dryRunAccessLevels [string],
   :restrictedClientApplications [{:clientId string, :name string}]}
  
  Updates a GcpUserAccessBinding. Completion of this long-running operation does not necessarily signify that the changed binding is deployed onto all affected users, which may take more time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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

(defn gcpUserAccessBindings-delete$
  "https://cloud.google.com/access-context-manager/docs/reference/rest/api/reference/rest/v1/organizations/gcpUserAccessBindings/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a GcpUserAccessBinding. Completion of this long-running operation does not necessarily signify that the binding deletion is deployed onto all affected users, which may take more time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://accesscontextmanager.googleapis.com/"
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
