(ns happygapi.cloudidentity.groups
  "Cloud Identity API: groups.
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/api/reference/rest/v1/groups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a `Group`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn search$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/search
  
  Required parameters: none
  
  Optional parameters: pageToken, query, view, pageSize
  
  Searches for `Group`s matching a specified query."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups:search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `Group`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/lookup
  
  Required parameters: none
  
  Optional parameters: groupKey.namespace, groupKey.id
  
  Looks up the [resource name](https://cloud.google.com/apis/design/resource_names) of a `Group` by its `EntityKey`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups:lookup"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :createTime string,
   :groupKey {:namespace string, :id string},
   :name string,
   :parent string,
   :updateTime string,
   :description string,
   :displayName string}
  
  Updates a `Group`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/create
  
  Required parameters: none
  
  Optional parameters: initialGroupConfig
  
  Body: 
  
  {:labels {},
   :createTime string,
   :groupKey {:namespace string, :id string},
   :name string,
   :parent string,
   :updateTime string,
   :description string,
   :displayName string}
  
  Creates a Group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups"
     #{}
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

(defn list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/list
  
  Required parameters: none
  
  Optional parameters: pageToken, view, pageSize, parent
  
  Lists the `Group`s under a customer or namespace."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/groups"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/list
  
  Required parameters: parent
  
  Optional parameters: view, pageSize, pageToken
  
  Lists the `Membership`s within a `Group`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-create$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:roles [{:name string}],
   :type string,
   :preferredMemberKey {:namespace string, :id string},
   :updateTime string,
   :name string,
   :createTime string}
  
  Creates a `Membership`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships"
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

(defn memberships-modifyMembershipRoles$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/modifyMembershipRoles
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:addRoles [{:name string}], :removeRoles [string]}
  
  Modifies the `MembershipRole`s of a `Membership`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:modifyMembershipRoles"
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

(defn memberships-lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/lookup
  
  Required parameters: parent
  
  Optional parameters: memberKey.id, memberKey.namespace
  
  Looks up the [resource name](https://cloud.google.com/apis/design/resource_names) of a `Membership` by its `EntityKey`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:lookup"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a `Membership`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn memberships-delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a `Membership`."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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
