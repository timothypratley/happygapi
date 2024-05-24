(ns happygapi.drive.drives
  "Google Drive API: drives.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/docs/reference/rest/v3/drives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/create
  
  Required parameters: requestId
  
  Optional parameters: none
  
  Body: 
  
  {:capabilities {:canChangeDomainUsersOnlyRestriction boolean,
                  :canRenameDrive boolean,
                  :canCopy boolean,
                  :canManageMembers boolean,
                  :canTrashChildren boolean,
                  :canDownload boolean,
                  :canChangeDriveMembersOnlyRestriction boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction boolean,
                  :canReadRevisions boolean,
                  :canDeleteDrive boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canAddChildren boolean,
                  :canChangeDriveBackground boolean,
                  :canResetDriveRestrictions boolean,
                  :canShare boolean},
   :restrictions {:copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :driveMembersOnly boolean,
                  :adminManagedRestrictions boolean,
                  :sharingFoldersRequiresOrganizerPermission boolean},
   :themeId string,
   :backgroundImageFile {:id string,
                         :xCoordinate number,
                         :yCoordinate number,
                         :width number},
   :name string,
   :orgUnitId string,
   :createdTime string,
   :hidden boolean,
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Creates a shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:requestId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives"
     #{:requestId}
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
  "https://developers.google.com/drive/api/reference/rest/v3/drives/delete
  
  Required parameters: driveId
  
  Optional parameters: useDomainAdminAccess, allowItemDeletion
  
  Permanently deletes a shared drive for which the user is an `organizer`. The shared drive cannot contain any untrashed items."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:driveId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{:driveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/get
  
  Required parameters: driveId
  
  Optional parameters: useDomainAdminAccess
  
  Gets a shared drive's metadata by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:driveId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{:driveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn hide$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/hide
  
  Required parameters: driveId
  
  Optional parameters: none
  
  Hides a shared drive from the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:driveId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}/hide"
     #{:driveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, q, useDomainAdminAccess
  
   Lists the user's shared drives. This method accepts the `q` parameter, which is a search query combining one or more search terms. For more information, see the [Search for shared drives](/drive/api/guides/search-shareddrives) guide."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn unhide$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/unhide
  
  Required parameters: driveId
  
  Optional parameters: none
  
  Restores a shared drive to the default view."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:driveId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}/unhide"
     #{:driveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/drives/update
  
  Required parameters: driveId
  
  Optional parameters: useDomainAdminAccess
  
  Body: 
  
  {:capabilities {:canChangeDomainUsersOnlyRestriction boolean,
                  :canRenameDrive boolean,
                  :canCopy boolean,
                  :canManageMembers boolean,
                  :canTrashChildren boolean,
                  :canDownload boolean,
                  :canChangeDriveMembersOnlyRestriction boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction boolean,
                  :canReadRevisions boolean,
                  :canDeleteDrive boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canAddChildren boolean,
                  :canChangeDriveBackground boolean,
                  :canResetDriveRestrictions boolean,
                  :canShare boolean},
   :restrictions {:copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :driveMembersOnly boolean,
                  :adminManagedRestrictions boolean,
                  :sharingFoldersRequiresOrganizerPermission boolean},
   :themeId string,
   :backgroundImageFile {:id string,
                         :xCoordinate number,
                         :yCoordinate number,
                         :width number},
   :name string,
   :orgUnitId string,
   :createdTime string,
   :hidden boolean,
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Updates the metadata for a shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:driveId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "drives/{driveId}"
     #{:driveId}
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
