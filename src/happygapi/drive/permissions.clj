(ns happygapi.drive.permissions
  "Google Drive API: permissions.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/docs/reference/rest/v3/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/create
  
  Required parameters: fileId
  
  Optional parameters: transferOwnership, moveToNewOwnersRoot, emailMessage, enforceSingleParent, supportsAllDrives, useDomainAdminAccess, sendNotificationEmail, supportsTeamDrives
  
  Body: 
  
  {:role string,
   :deleted boolean,
   :allowFileDiscovery boolean,
   :expirationTime string,
   :displayName string,
   :emailAddress string,
   :type string,
   :permissionDetails [{:permissionType string,
                        :inheritedFrom string,
                        :role string,
                        :inherited boolean}],
   :teamDrivePermissionDetails [{:teamDrivePermissionType string,
                                 :inheritedFrom string,
                                 :role string,
                                 :inherited boolean}],
   :id string,
   :kind string,
   :pendingOwner boolean,
   :domain string,
   :view string,
   :photoLink string}
  
  Creates a permission for a file or shared drive. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions"
     #{:fileId}
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
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/delete
  
  Required parameters: fileId, permissionId
  
  Optional parameters: supportsAllDrives, supportsTeamDrives, useDomainAdminAccess
  
  Deletes a permission. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:permissionId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
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
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:permissionId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/permissions/list
  
  Required parameters: fileId
  
  Optional parameters: pageSize, pageToken, supportsAllDrives, supportsTeamDrives, useDomainAdminAccess, includePermissionsForView
  
  Lists a file's or shared drive's permissions."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions"
     #{:fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
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
   :permissionDetails [{:permissionType string,
                        :inheritedFrom string,
                        :role string,
                        :inherited boolean}],
   :teamDrivePermissionDetails [{:teamDrivePermissionType string,
                                 :inheritedFrom string,
                                 :role string,
                                 :inherited boolean}],
   :id string,
   :kind string,
   :pendingOwner boolean,
   :domain string,
   :view string,
   :photoLink string}
  
  Updates a permission with patch semantics. **Warning:** Concurrent permissions operations on the same file are not supported; only the last update is applied."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:permissionId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/permissions/{permissionId}"
     #{:permissionId :fileId}
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
