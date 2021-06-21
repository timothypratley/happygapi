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

(defn lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/lookup
  
  Required parameters: none
  
  Optional parameters: groupKey.id, groupKey.namespace
  
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
  
  {:description string,
   :labels {},
   :parent string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :dynamicGroupMetadata {:status DynamicGroupStatus,
                          :queries [DynamicGroupQuery]},
   :groupKey {:id string, :namespace string}}
  
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

(defn list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/list
  
  Required parameters: none
  
  Optional parameters: pageToken, pageSize, view, parent
  
  Lists the `Group` resources under a customer or namespace."
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

(defn search$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/search
  
  Required parameters: none
  
  Optional parameters: view, query, pageToken, pageSize
  
  Searches for `Group` resources matching a specified query."
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

(defn create$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/create
  
  Required parameters: none
  
  Optional parameters: initialGroupConfig
  
  Body: 
  
  {:description string,
   :labels {},
   :parent string,
   :displayName string,
   :name string,
   :createTime string,
   :updateTime string,
   :dynamicGroupMetadata {:status DynamicGroupStatus,
                          :queries [DynamicGroupQuery]},
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

(defn memberships-searchTransitiveMemberships$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/searchTransitiveMemberships
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Search transitive memberships of a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the group is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A transitive membership is any direct or indirect membership of a group. Actor must have view permissions to all transitive memberships."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:searchTransitiveMemberships"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-checkTransitiveMembership$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/checkTransitiveMembership
  
  Required parameters: parent
  
  Optional parameters: query
  
  Check a potential member for membership in a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A member has membership to a group as long as there is a single viewable transitive membership between the group and the member. The actor must have view permissions to at least one transitive membership between the member and group."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:checkTransitiveMembership"
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

(defn memberships-lookup$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/lookup
  
  Required parameters: parent
  
  Optional parameters: memberKey.namespace, memberKey.id
  
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

(defn memberships-getMembershipGraph$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/getMembershipGraph
  
  Required parameters: parent
  
  Optional parameters: query
  
  Get a membership graph of just a member or both a member and a group. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. Given a member, the response will contain all membership paths from the member. Given both a group and a member, the response will contain all membership paths between the group and the member."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:getMembershipGraph"
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
  
  {:name string,
   :roles [{:name string, :expiryDetail ExpiryDetail}],
   :createTime string,
   :updateTime string,
   :preferredMemberKey {:id string, :namespace string},
   :type string}
  
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

(defn memberships-searchTransitiveGroups$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/searchTransitiveGroups
  
  Required parameters: parent
  
  Optional parameters: query, pageToken, pageSize
  
  Search transitive groups of a member. **Note:** This feature is only available to Google Workspace Enterprise Standard, Enterprise Plus, and Enterprise for Education; and Cloud Identity Premium accounts. If the account of the member is not one of these, a 403 (PERMISSION_DENIED) HTTP status code will be returned. A transitive group is any group that has a direct or indirect membership to the member. Actor must have view permissions all transitive groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-identity.groups"
            "https://www.googleapis.com/auth/cloud-identity.groups.readonly"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/memberships:searchTransitiveGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn memberships-modifyMembershipRoles$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/modifyMembershipRoles
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateRolesParams [{:fieldMask string,
                        :membershipRole MembershipRole}],
   :removeRoles [string],
   :addRoles [{:name string, :expiryDetail ExpiryDetail}]}
  
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

(defn memberships-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/groups/memberships/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, view, pageToken
  
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
