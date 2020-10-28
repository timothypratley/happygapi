(ns happygapi.dfareporting.userRoles
  "DCM/DFA Reporting And Trafficking API: userRoles.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:defaultUserRole boolean,
   :permissions [{:availability string,
                  :permissionGroupId string,
                  :kind string,
                  :id string,
                  :name string}],
   :subaccountId string,
   :id string,
   :name string,
   :kind string,
   :accountId string,
   :parentUserRoleId string}
  
  Updates an existing user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles"
     #{:profileId}
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

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/delete
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Deletes an existing user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:defaultUserRole boolean,
   :permissions [{:availability string,
                  :permissionGroupId string,
                  :kind string,
                  :id string,
                  :name string}],
   :subaccountId string,
   :id string,
   :name string,
   :kind string,
   :accountId string,
   :parentUserRoleId string}
  
  Inserts a new user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles"
     #{:profileId}
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:defaultUserRole boolean,
   :permissions [{:availability string,
                  :permissionGroupId string,
                  :kind string,
                  :id string,
                  :name string}],
   :subaccountId string,
   :id string,
   :name string,
   :kind string,
   :accountId string,
   :parentUserRoleId string}
  
  Updates an existing user role. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles"
     #{:id :profileId}
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one user role by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/userRoles/list
  
  Required parameters: profileId
  
  Optional parameters: ids, searchString, pageToken, sortField, sortOrder, subaccountId, accountUserRoleOnly, maxResults
  
  Retrieves a list of user roles, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/userRoles"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
