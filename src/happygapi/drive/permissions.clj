(ns happygapi.drive.permissions
  "Drive API: permissions.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/api/reference/rest/v3/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/create
  
  Required parameters: fileId
  
  Optional parameters: emailMessage, sendNotificationEmail, supportsAllDrives, supportsTeamDrives, transferOwnership, useDomainAdminAccess
  
  Body: 
  
  {:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails [{:inherited boolean,
                        :inheritedFrom string,
                        :permissionType string,
                        :role string}],
   :teamDrivePermissionDetails [{:inherited boolean,
                                 :inheritedFrom string,
                                 :role string,
                                 :teamDrivePermissionType string}],
   :id string,
   :kind string,
   :domain string,
   :photoLink string}
  
  Creates a permission for a file or shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions"
     #{:fileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/delete
  
  Required parameters: fileId, permissionId
  
  Optional parameters: supportsAllDrives, supportsTeamDrives, useDomainAdminAccess
  Deletes a permission."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args]
  {:pre [(util/has-keys? args #{:permissionId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/get
  
  Required parameters: fileId, permissionId
  
  Optional parameters: supportsAllDrives, supportsTeamDrives, useDomainAdminAccess
  Gets a permission by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:permissionId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/list
  
  Required parameters: fileId
  
  Optional parameters: pageSize, pageToken, supportsAllDrives, supportsTeamDrives, useDomainAdminAccess
  Lists a file's or shared drive's permissions."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions"
     #{:fileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/update
  
  Required parameters: fileId, permissionId
  
  Optional parameters: removeExpiration, supportsAllDrives, supportsTeamDrives, transferOwnership, useDomainAdminAccess
  
  Body: 
  
  {:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails [{:inherited boolean,
                        :inheritedFrom string,
                        :permissionType string,
                        :role string}],
   :teamDrivePermissionDetails [{:inherited boolean,
                                 :inheritedFrom string,
                                 :role string,
                                 :teamDrivePermissionType string}],
   :id string,
   :kind string,
   :domain string,
   :photoLink string}
  
  Updates a permission with patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:permissionId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
