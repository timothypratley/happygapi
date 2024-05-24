(ns happygapi.mybusinessaccountmanagement.locations
  "My Business Account Management API: locations.
  The My Business Account Management API provides an interface for managing access to a location on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/docs/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn transfer$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/transfer
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:destinationAccount string}
  
  Moves a location from an account that the user owns to another account that the same user administers. The user must be an owner of the account the location is currently associated with and must also be at least a manager of the destination account."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessaccountmanagement.googleapis.com/"
     "v1/{+name}:transfer"
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
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/admins/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists all of the admins for the specified location."
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

(defn admins-create$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/admins/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :admin string,
   :account string,
   :role string,
   :pendingInvitation boolean}
  
  Invites the specified user to become an administrator for the specified location. The invitee must accept the invitation in order to be granted access to the location. See AcceptInvitation to programmatically accept an invitation."
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

(defn admins-delete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/admins/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Removes the specified admin as a manager of the specified location."
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

(defn admins-patch$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/admins/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :admin string,
   :account string,
   :role string,
   :pendingInvitation boolean}
  
  Updates the Admin for the specified location. Only the AdminRole of the Admin can be updated."
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
