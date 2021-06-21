(ns happygapi.orgpolicy.folders
  "Organization Policy API: folders.
  The Org Policy API allows users to configure governance ruleson their GCP resources across the Cloud Resource Hierarchy.
  See: https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn policies-get$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a `Policy` on a resource. If no `Policy` is set on the resource, NOT_FOUND is returned. The `etag` value can be used with `UpdatePolicy()` to update a `Policy` during read-modify-write."
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

(defn policies-create$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:spec {:inheritFromParent boolean,
          :updateTime string,
          :etag string,
          :reset boolean,
          :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule]},
   :name string}
  
  Creates a Policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint does not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ALREADY_EXISTS` if the policy already exists on the given Cloud resource."
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

(defn policies-getEffectivePolicy$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/getEffectivePolicy
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the effective `Policy` on a resource. This is the result of merging `Policies` in the resource hierarchy and evaluating conditions. The returned `Policy` will not have an `etag` or `condition` set because it is a computed `Policy` across multiple resources. Subtrees of Resource Manager resource hierarchy with 'under:' prefix will not be expanded."
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

(defn policies-delete$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or Org Policy does not exist."
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

(defn policies-list$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Retrieves all of the `Policies` that exist on a particular resource."
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
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/policies/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:spec {:inheritFromParent boolean,
          :updateTime string,
          :etag string,
          :reset boolean,
          :rules [GoogleCloudOrgpolicyV2PolicySpecPolicyRule]},
   :name string}
  
  Updates a Policy. Returns a `google.rpc.Status` with `google.rpc.Code.NOT_FOUND` if the constraint or the policy do not exist. Returns a `google.rpc.Status` with `google.rpc.Code.ABORTED` if the etag supplied in the request does not match the persisted etag of the policy Note: the supplied policy will perform a full overwrite of all fields."
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

(defn constraints-list$
  "https://cloud.google.com/orgpolicy/docs/reference/rest/index.htmlapi/reference/rest/v2/folders/constraints/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists `Constraints` that could be applied on the specified resource."
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
