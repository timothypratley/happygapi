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
  
  Deletes a Group."
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

(defn list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize, view, parent
  
  Lists groups within a customer or a domain."
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

(defn lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/lookup
  
  Required parameters: none
  
  Optional parameters: groupKey.namespace, groupKey.id
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Group by
  its EntityKey."
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

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :description string,
   :parent string,
   :labels {},
   :createTime string,
   :updateTime string,
   :name string,
   :groupKey {:id string, :namespace string}}
  
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

(defn search$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/search
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize, query, view
  
  Searches for Groups."
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
  
  Retrieves a Group."
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

(defn patch$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :description string,
   :parent string,
   :labels {},
   :createTime string,
   :updateTime string,
   :name string,
   :groupKey {:id string, :namespace string}}
  
  Updates a Group."
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

(defn memberships-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a Membership."
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

(defn memberships-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, view
  
  Lists Memberships within a Group."
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
  
  {:preferredMemberKey {:id string, :namespace string},
   :createTime string,
   :updateTime string,
   :roles [{:name string}],
   :name string}
  
  Creates a Membership."
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

(defn memberships-lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/lookup
  
  Required parameters: parent
  
  Optional parameters: memberKey.id, memberKey.namespace
  
  Looks up [resource
  name](https://cloud.google.com/apis/design/resource_names) of a Membership
  within a Group by member's EntityKey."
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

(defn memberships-delete$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Membership."
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
