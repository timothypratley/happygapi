(ns happygapi.displayvideo.users
  "Display & Video 360 API: users.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/users/list
  
  Required parameters: none
  
  Optional parameters: pageToken, filter, orderBy, pageSize
  
  Lists users that are accessible to the current user. If two users have user roles on the same partner or advertiser, they can access each other."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users"
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
  "https://developers.google.com/display-video/api/reference/rest/v1/users/patch
  
  Required parameters: userId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:assignedUserRoles [{:userRole string,
                        :advertiserId string,
                        :partnerId string,
                        :assignedUserRoleId string}],
   :displayName string,
   :name string,
   :email string,
   :userId string}
  
  Updates an existing user. Returns the updated user if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users/{+userId}"
     #{:userId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/users/get
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets a user."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users/{+userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/users/delete
  
  Required parameters: userId
  
  Optional parameters: none
  
  Deletes a user."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users/{+userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v1/users/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:assignedUserRoles [{:userRole string,
                        :advertiserId string,
                        :partnerId string,
                        :assignedUserRoleId string}],
   :displayName string,
   :name string,
   :email string,
   :userId string}
  
  Creates a new user. Returns the newly created user if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users"
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

(defn bulkEditAssignedUserRoles$
  "https://developers.google.com/display-video/api/reference/rest/v1/users/bulkEditAssignedUserRoles
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:createdAssignedUserRoles [{:userRole string,
                               :advertiserId string,
                               :partnerId string,
                               :assignedUserRoleId string}],
   :deletedAssignedUserRoles [string]}
  
  Bulk edits user roles for a user. The operation will delete the assigned user roles provided in BulkEditAssignedUserRolesRequest.deletedAssignedUserRoles and then assign the user roles provided in BulkEditAssignedUserRolesRequest.createdAssignedUserRoles."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/users/{+userId}:bulkEditAssignedUserRoles"
     #{:userId}
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
