(ns happygapi.iam.organizations
  "Identity and Access Management (IAM) API: organizations.
  Manages identity and access control for Google Cloud Platform resources, including the creation of service accounts, which you can use to authenticate to Google and make API calls.
  See: https://cloud.google.com/iam/api/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn roles-undelete$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/undelete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:etag string}
  
  Undelete a Role, bringing it back in its previous state."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+name}:undelete"
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

(defn roles-get$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-patch$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:title string,
   :includedPermissions [string],
   :description string,
   :etag string,
   :stage string,
   :name string,
   :deleted boolean}
  
  Updates a Role definition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-delete$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Soft deletes a role. The role is suspended and cannot be used to create new
  IAM Policy Bindings.
  The Role will not be included in `ListRoles()` unless `show_deleted` is set
  in the `ListRolesRequest`. The Role contains the deleted boolean set.
  Existing Bindings remains, but are inactive. The Role can be undeleted
  within 7 days. After 7 days the Role is deleted and all Bindings associated
  with the role are removed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://iam.googleapis.com/"
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

(defn roles-list$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view, showDeleted
  
  Lists the Roles defined on a resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn roles-create$
  "https://cloud.google.com/iam/api/reference/rest/v1/organizations/roles/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:roleId string,
   :role {:title string,
          :includedPermissions [string],
          :description string,
          :etag string,
          :stage string,
          :name string,
          :deleted boolean}}
  
  Creates a new Role."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://iam.googleapis.com/"
     "v1/{+parent}/roles"
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
