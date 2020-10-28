(ns happygapi.analyticsadmin.accounts
  "Google Analytics Admin API: accounts.
  
  See: http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :createTime string,
   :updateTime string,
   :countryCode string,
   :deleted boolean,
   :name string}
  
  Updates an account."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/list
  
  Required parameters: none
  
  Optional parameters: showDeleted, pageSize, pageToken
  
  Returns all accounts accessible by the caller. Note that these accounts might not currently have GA4 properties. Soft-deleted (ie: \"trashed\") accounts are excluded by default. Returns an empty list if no relevant accounts are found."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn provisionAccountTicket$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/provisionAccountTicket
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:redirectUri string,
   :account {:displayName string,
             :createTime string,
             :updateTime string,
             :countryCode string,
             :deleted boolean,
             :name string}}
  
  Requests a ticket for creating an account."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/accounts:provisionAccountTicket"
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

(defn getDataSharingSettings$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/getDataSharingSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Get data sharing settings on an account. Data sharing settings are singletons."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Marks target Account as soft-deleted (ie: \"trashed\") and returns it. This API does not have a method to restore soft-deleted accounts. However, they can be restored using the Trash Can UI. If the accounts are not restored before the expiration time, the account and all child resources (eg: Properties, GoogleAdsLinks, Streams, UserLinks) will be permanently purged. https://support.google.com/analytics/answer/6154772 Returns an error if the target is not found."
  {:scopes ["https://www.googleapis.com/auth/analytics.edit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Lookup for a single Account. Throws \"Target not found\" if no such account found, or if caller does not have permissions to access it."
  {:scopes ["https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-get$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a user's link to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-patch$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :emailAddress string, :directRoles [string]}
  
  Updates a user link on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
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

(defn userLinks-batchUpdate$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:userLink GoogleAnalyticsAdminV1alphaUserLink}]}
  
  Updates information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchUpdate"
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

(defn userLinks-create$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/create
  
  Required parameters: parent
  
  Optional parameters: notifyNewUser
  
  Body: 
  
  {:name string, :emailAddress string, :directRoles [string]}
  
  Creates a user link on an account or property. If the user with the specified email already has permissions on the account or property, then the user's existing permissions will be unioned with the permissions specified in the new UserLink."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks"
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

(defn userLinks-batchGet$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/batchGet
  
  Required parameters: parent
  
  Optional parameters: names
  
  Gets information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchGet"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-batchCreate$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notifyNewUsers boolean,
   :requests [{:parent string,
               :userLink GoogleAnalyticsAdminV1alphaUserLink,
               :notifyNewUser boolean}]}
  
  Creates information about multiple users' links to an account or property. This method is transactional. If any UserLink cannot be created, none of the UserLinks will be created."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchCreate"
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

(defn userLinks-delete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a user link on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-batchDelete$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:name string}]}
  
  Deletes information about multiple users' links to an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:batchDelete"
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

(defn userLinks-list$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all user links on an account or property."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userLinks-audit$
  "http://code.google.com/apis/analytics/docs/mgmt/home.htmlapi/reference/rest/v1alpha/accounts/userLinks/audit
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer}
  
  Lists all user links on an account or property, including implicit ones that come from effective permissions granted by groups or organization admin roles. If a returned user link does not have direct permissions, they cannot be removed from the account or property directly with the DeleteUserLink command. They have to be removed from the group/etc that gives them permissions, which is currently only usable/discoverable in the GA or GMP UIs."
  {:scopes ["https://www.googleapis.com/auth/analytics.manage.users.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsadmin.googleapis.com/"
     "v1alpha/{+parent}/userLinks:audit"
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
