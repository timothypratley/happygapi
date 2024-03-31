(ns happygapi.cloudidentity.customers
  "Cloud Identity API: customers.
  API for provisioning and managing identity resources.
  See: https://cloud.google.com/identity/api/reference/rest/v1/customers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn userinvitations-get$
  "https://cloud.google.com/identity/api/reference/rest/v1/customers/userinvitations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a UserInvitation resource. **Note:** New consumer accounts with the customer's verified domain created within the previous 48 hours will not appear in the result. This delay also applies to newly-verified domains."
  {:scopes nil}
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

(defn userinvitations-list$
  "https://cloud.google.com/identity/api/reference/rest/v1/customers/userinvitations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Retrieves a list of UserInvitation resources. **Note:** New consumer accounts with the customer's verified domain created within the previous 48 hours will not appear in the result. This delay also applies to newly-verified domains."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+parent}/userinvitations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn userinvitations-send$
  "https://cloud.google.com/identity/api/reference/rest/v1/customers/userinvitations/send
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Sends a UserInvitation to email. If the `UserInvitation` does not exist for this request and it is a valid request, the request creates a `UserInvitation`. **Note:** The `get` and `list` methods have a 48-hour delay where newly-created consumer accounts will not appear in the results. You can still send a `UserInvitation` to those accounts if you know the unmanaged email address and IsInvitableUser==True."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:send"
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

(defn userinvitations-cancel$
  "https://cloud.google.com/identity/api/reference/rest/v1/customers/userinvitations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels a UserInvitation that was already sent."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudidentity.googleapis.com/"
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

(defn userinvitations-isInvitableUser$
  "https://cloud.google.com/identity/api/reference/rest/v1/customers/userinvitations/isInvitableUser
  
  Required parameters: name
  
  Optional parameters: none
  
  Verifies whether a user account is eligible to receive a UserInvitation (is an unmanaged account). Eligibility is based on the following criteria: * the email address is a consumer account and it's the primary email address of the account, and * the domain of the email address matches an existing verified Google Workspace or Cloud Identity domain If both conditions are met, the user is eligible. **Note:** This method is not supported for Workspace Essentials customers."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudidentity.googleapis.com/"
     "v1/{+name}:isInvitableUser"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
