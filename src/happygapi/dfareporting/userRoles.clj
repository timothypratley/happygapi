(ns happygapi.dfareporting.userRoles
  "Campaign Manager 360 API: userRoles.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/delete
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Deletes an existing user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :permissions [{:permissionGroupId string,
                  :kind string,
                  :name string,
                  :id string,
                  :availability string}],
   :parentUserRoleId string,
   :defaultUserRole boolean,
   :kind string,
   :subaccountId string,
   :id string,
   :accountId string}
  
  Updates an existing user role. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one user role by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :permissions [{:permissionGroupId string,
                  :kind string,
                  :name string,
                  :id string,
                  :availability string}],
   :parentUserRoleId string,
   :defaultUserRole boolean,
   :kind string,
   :subaccountId string,
   :id string,
   :accountId string}
  
  Updates an existing user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/list
  
  Required parameters: profileId
  
  Optional parameters: ids, searchString, pageToken, sortField, sortOrder, subaccountId, accountUserRoleOnly, maxResults
  
  Retrieves a list of user roles, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/userRoles/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :permissions [{:permissionGroupId string,
                  :kind string,
                  :name string,
                  :id string,
                  :availability string}],
   :parentUserRoleId string,
   :defaultUserRole boolean,
   :kind string,
   :subaccountId string,
   :id string,
   :accountId string}
  
  Inserts a new user role."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/userRoles"
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
