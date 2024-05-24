(ns happygapi.displayvideo.users
  "Display & Video 360 API: users.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/users/get
  
  Required parameters: userId
  
  Optional parameters: none
  
  Gets a user. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users/{+userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/users/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists users that are accessible to the current user. If two users have user roles on the same partner or advertiser, they can access each other. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/users/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :userId string,
   :email string,
   :displayName string,
   :assignedUserRoles [{:assignedUserRoleId string,
                        :partnerId string,
                        :advertiserId string,
                        :userRole string}],
   :lastLoginTime string}
  
  Creates a new user. Returns the newly created user if successful. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users"
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

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/users/patch
  
  Required parameters: userId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :userId string,
   :email string,
   :displayName string,
   :assignedUserRoles [{:assignedUserRoleId string,
                        :partnerId string,
                        :advertiserId string,
                        :userRole string}],
   :lastLoginTime string}
  
  Updates an existing user. Returns the updated user if successful. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users/{+userId}"
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

(defn delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/users/delete
  
  Required parameters: userId
  
  Optional parameters: none
  
  Deletes a user. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users/{+userId}"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bulkEditAssignedUserRoles$
  "https://developers.google.com/display-video/api/reference/rest/v3/users/bulkEditAssignedUserRoles
  
  Required parameters: userId
  
  Optional parameters: none
  
  Body: 
  
  {:deletedAssignedUserRoles [string],
   :createdAssignedUserRoles [{:assignedUserRoleId string,
                               :partnerId string,
                               :advertiserId string,
                               :userRole string}]}
  
  Bulk edits user roles for a user. The operation will delete the assigned user roles provided in BulkEditAssignedUserRolesRequest.deletedAssignedUserRoles and then assign the user roles provided in BulkEditAssignedUserRolesRequest.createdAssignedUserRoles. This method has unique authentication requirements. Read the prerequisites in our [Managing Users guide](/display-video/api/guides/users/overview#prerequisites) before using this method. The \"Try this method\" feature does not work for this method."
  {:scopes ["https://www.googleapis.com/auth/display-video-user-management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/users/{+userId}:bulkEditAssignedUserRoles"
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
