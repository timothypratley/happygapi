(ns happygapi.mybusinessaccountmanagement.accounts
  "My Business Account Management API: accounts.
  The My Business Account Management API provides an interface for managing access to a location on Google.
  See: https://developers.google.com/my-business/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the specified account. Returns `NOT_FOUND` if the account does not exist or if the caller does not have access rights to it."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
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

(defn create$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:role string,
   :vettedState string,
   :primaryOwner string,
   :accountNumber string,
   :name string,
   :accountName string,
   :type string,
   :verificationState string,
   :organizationInfo {:registeredDomain string,
                      :phoneNumber string,
                      :address PostalAddress},
   :permissionLevel string}
  
  Creates an account with the specified name and type under the given parent. - Personal accounts and Organizations cannot be created. - User Groups cannot be created with a Personal account as primary owner. - Location Groups cannot be created with a primary owner of a Personal account if the Personal account is in an Organization. - Location Groups cannot own Location Groups."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/accounts"
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
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/list
  
  Required parameters: none
  
  Optional parameters: pageToken, filter, pageSize, parentAccount
  
  Lists all of the accounts for the authenticated user. This includes all accounts that the user owns, as well as any accounts for which the user has management rights."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/accounts"
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
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly
  
  Body: 
  
  {:role string,
   :vettedState string,
   :primaryOwner string,
   :accountNumber string,
   :name string,
   :accountName string,
   :type string,
   :verificationState string,
   :organizationInfo {:registeredDomain string,
                      :phoneNumber string,
                      :address PostalAddress},
   :permissionLevel string}
  
  Updates the specified business account. Personal accounts cannot be updated using this method."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
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

(defn admins-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/admins/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists the admins for the specified account."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+parent}/admins"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn admins-delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/admins/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes the specified admin from the specified account."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
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

(defn admins-create$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/admins/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:admin string,
   :pendingInvitation boolean,
   :role string,
   :name string}
  
  Invites the specified user to become an administrator for the specified account. The invitee must accept the invitation in order to be granted access to the account. See AcceptInvitation to programmatically accept an invitation."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+parent}/admins"
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

(defn admins-patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/admins/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:admin string,
   :pendingInvitation boolean,
   :role string,
   :name string}
  
  Updates the Admin for the specified Account Admin."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
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

(defn invitations-accept$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/invitations/accept
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Accepts the specified invitation."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+name}:accept"
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

(defn invitations-decline$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/invitations/decline
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Declines the specified invitation."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+name}:decline"
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

(defn invitations-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/accounts/invitations/list
  
  Required parameters: parent
  
  Optional parameters: filter
  
  Lists pending invitations for the specified account."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+parent}/invitations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
