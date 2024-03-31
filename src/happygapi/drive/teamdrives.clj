(ns happygapi.drive.teamdrives
  "Google Drive API: teamdrives.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/api/reference/rest/v3/teamdrives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/create
  
  Required parameters: requestId
  
  Optional parameters: none
  
  Body: 
  
  {:capabilities {:canChangeDomainUsersOnlyRestriction boolean,
                  :canCopy boolean,
                  :canManageMembers boolean,
                  :canTrashChildren boolean,
                  :canChangeTeamDriveBackground boolean,
                  :canDownload boolean,
                  :canDeleteTeamDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canRenameTeamDrive boolean,
                  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction boolean,
                  :canResetTeamDriveRestrictions boolean,
                  :canReadRevisions boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canChangeTeamMembersOnlyRestriction boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canShare boolean},
   :restrictions {:copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :teamMembersOnly boolean,
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
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Deprecated: Use `drives.create` instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:requestId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
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
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/delete
  
  Required parameters: teamDriveId
  
  Optional parameters: none
  
  Deprecated: Use `drives.delete` instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:teamDriveId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/get
  
  Required parameters: teamDriveId
  
  Optional parameters: useDomainAdminAccess
  
  Deprecated: Use `drives.get` instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:teamDriveId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, q, useDomainAdminAccess
  
  Deprecated: Use `drives.list` instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/update
  
  Required parameters: teamDriveId
  
  Optional parameters: useDomainAdminAccess
  
  Body: 
  
  {:capabilities {:canChangeDomainUsersOnlyRestriction boolean,
                  :canCopy boolean,
                  :canManageMembers boolean,
                  :canTrashChildren boolean,
                  :canChangeTeamDriveBackground boolean,
                  :canDownload boolean,
                  :canDeleteTeamDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canRenameTeamDrive boolean,
                  :canChangeSharingFoldersRequiresOrganizerPermissionRestriction boolean,
                  :canResetTeamDriveRestrictions boolean,
                  :canReadRevisions boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canChangeTeamMembersOnlyRestriction boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canShare boolean},
   :restrictions {:copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :teamMembersOnly boolean,
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
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Deprecated: Use `drives.update` instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:teamDriveId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
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
