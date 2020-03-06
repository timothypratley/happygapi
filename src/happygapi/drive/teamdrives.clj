(ns happygapi.drive.teamdrives
  "Drive API: teamdrives.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
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
                  :canReadRevisions boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canChangeTeamMembersOnlyRestriction boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canShare boolean},
   :restrictions {:adminManagedRestrictions boolean,
                  :copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :teamMembersOnly boolean},
   :themeId string,
   :backgroundImageFile {:id string,
                         :width number,
                         :xCoordinate number,
                         :yCoordinate number},
   :name string,
   :createdTime string,
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Deprecated use drives.create instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:requestId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
     #{:requestId}
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
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/delete
  
  Required parameters: teamDriveId
  
  Optional parameters: none
  Deprecated use drives.delete instead."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args]
  {:pre [(util/has-keys? args #{:teamDriveId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/get
  
  Required parameters: teamDriveId
  
  Optional parameters: useDomainAdminAccess
  Deprecated use drives.get instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:teamDriveId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/teamdrives/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, q, useDomainAdminAccess
  Deprecated use drives.list instead."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
                  :canReadRevisions boolean,
                  :canChangeCopyRequiresWriterPermissionRestriction boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canChangeTeamMembersOnlyRestriction boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canShare boolean},
   :restrictions {:adminManagedRestrictions boolean,
                  :copyRequiresWriterPermission boolean,
                  :domainUsersOnly boolean,
                  :teamMembersOnly boolean},
   :themeId string,
   :backgroundImageFile {:id string,
                         :width number,
                         :xCoordinate number,
                         :yCoordinate number},
   :name string,
   :createdTime string,
   :id string,
   :kind string,
   :colorRgb string,
   :backgroundImageLink string}
  
  Deprecated use drives.update instead"
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:teamDriveId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "teamdrives/{teamDriveId}"
     #{:teamDriveId}
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
