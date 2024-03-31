(ns happygapi.orgpolicy.organizations
  "Organization Policy API: organizations.
  The Organization Policy API allows users to configure governance rules on their Google Cloud resources across the resource hierarchy.
  See: https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn customConstraints-patch$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/customConstraints/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:resourceTypes [string],
   :methodTypes [string],
   :updateTime string,
   :actionType string,
   :name string,
   :description string,
   :condition string,
   :displayName string}
  
  Updates a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Note: the supplied policy will perform a full overwrite of all fields."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn customConstraints-get$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/customConstraints/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the custom constraint does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn customConstraints-delete$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/customConstraints/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn customConstraints-create$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/customConstraints/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:resourceTypes [string],
   :methodTypes [string],
   :updateTime string,
   :actionType string,
   :name string,
   :description string,
   :condition string,
   :displayName string}
  
  Creates a custom constraint. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the organization does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the constraint already exists on the given organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+parent}/customConstraints"
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

(defn customConstraints-list$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/customConstraints/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves all of the custom constraints that exist on a particular organization resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+parent}/customConstraints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn constraints-list$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/constraints/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists constraints that could be applied on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+parent}/constraints"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn policies-list$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves all of the policies that exist on a particular resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+parent}/policies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn policies-patch$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:spec {:updateTime string,
          :etag string,
          :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule],
          :inheritFromParent boolean,
          :reset boolean},
   :etag string,
   :dryRunSpec {:updateTime string,
                :etag string,
                :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule],
                :inheritFromParent boolean,
                :reset boolean},
   :name string,
   :alternate {:spec GoogleCloudOrgpolicyV2PolicySpec, :launch string}}
  
  Updates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy Note: the supplied policy will perform a full overwrite of all fields."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn policies-create$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:spec {:updateTime string,
          :etag string,
          :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule],
          :inheritFromParent boolean,
          :reset boolean},
   :etag string,
   :dryRunSpec {:updateTime string,
                :etag string,
                :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule],
                :inheritFromParent boolean,
                :reset boolean},
   :name string,
   :alternate {:spec GoogleCloudOrgpolicyV2PolicySpec, :launch string}}
  
  Creates a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Google Cloud resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+parent}/policies"
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

(defn policies-delete$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes a policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or organization policy does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn policies-get$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a policy on a resource. If no policy is set on the resource, `NOT_FOUND` is returned. The `etag` value can be used with `UpdatePolicy()` to update a policy during read-modify-write."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
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

(defn policies-getEffectivePolicy$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/organizations/policies/getEffectivePolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the effective policy on a resource. This is the result of merging policies in the resource hierarchy and evaluating conditions. The returned policy will not have an `etag` or `condition` set because it is an evaluated policy across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://orgpolicy.googleapis.com/"
     "v2/{+name}:getEffectivePolicy"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
