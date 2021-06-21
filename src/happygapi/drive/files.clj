(ns happygapi.drive.files
  "Drive API: files.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/api/reference/rest/v3/files"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn emptyTrash$
  "https://developers.google.com/drive/api/reference/rest/v3/files/emptyTrash
  
  Required parameters: none
  
  Optional parameters: enforceSingleParent
  
  Permanently deletes all of the user's trashed files."
  {:scopes ["https://www.googleapis.com/auth/drive"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/trash"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/files/get
  
  Required parameters: fileId
  
  Optional parameters: acknowledgeAbuse, includePermissionsForView, supportsAllDrives, supportsTeamDrives
  
  Gets a file's metadata or content by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
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
     "files/{fileId}"
     #{:fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn copy$
  "https://developers.google.com/drive/api/reference/rest/v3/files/copy
  
  Required parameters: fileId
  
  Optional parameters: enforceSingleParent, ignoreDefaultVisibility, includePermissionsForView, keepRevisionForever, ocrLanguage, supportsAllDrives, supportsTeamDrives
  
  Body: 
  
  {:description string,
   :properties {},
   :isAppAuthorized boolean,
   :capabilities {:canDelete boolean,
                  :canAddMyDriveParent boolean,
                  :canTrash boolean,
                  :canMoveChildrenOutOfTeamDrive boolean,
                  :canCopy boolean,
                  :canAddFolderFromAnotherDrive boolean,
                  :canTrashChildren boolean,
                  :canMoveChildrenWithinDrive boolean,
                  :canDownload boolean,
                  :canReadTeamDrive boolean,
                  :canUntrash boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canMoveItemWithinTeamDrive boolean,
                  :canModifyContent boolean,
                  :canShare boolean,
                  :canMoveItemOutOfTeamDrive boolean,
                  :canMoveChildrenWithinTeamDrive boolean,
                  :canChangeViewersCanCopyContent boolean,
                  :canChangeSecurityUpdateEnabled boolean,
                  :canMoveTeamDriveItem boolean,
                  :canReadDrive boolean,
                  :canMoveItemWithinDrive boolean},
   :copyRequiresWriterPermission boolean,
   :imageMediaMetadata {:focalLength number,
                        :aperture number,
                        :rotation integer,
                        :exposureBias number,
                        :flashUsed boolean,
                        :time string,
                        :maxApertureValue number,
                        :colorSpace string,
                        :width integer,
                        :lens string,
                        :exposureMode string,
                        :cameraModel string,
                        :cameraMake string,
                        :whiteBalance string,
                        :exposureTime number,
                        :subjectDistance integer,
                        :meteringMode string,
                        :isoSpeed integer,
                        :location {:altitude number,
                                   :latitude number,
                                   :longitude number},
                        :height integer,
                        :sensor string},
   :modifiedTime string,
   :permissions [{:role string,
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
                  :view string,
                  :photoLink string}],
   :owners [{:displayName string,
             :emailAddress string,
             :kind string,
             :me boolean,
             :permissionId string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :type string}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :emailAddress string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :photoLink string},
   :resourceKey string,
   :modifiedByMe boolean,
   :thumbnailVersion string,
   :folderColorRgb string,
   :createdTime string,
   :spaces [string],
   :fileExtension string,
   :trashed boolean,
   :id string,
   :thumbnailLink string,
   :writersCanShare boolean,
   :explicitlyTrashed boolean,
   :kind string,
   :parents [string],
   :driveId string,
   :sharedWithMeTime string,
   :viewedByMeTime string,
   :mimeType string,
   :trashingUser {:displayName string,
                  :emailAddress string,
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :photoLink string},
   :shared boolean,
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :emailAddress string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:durationMillis string,
                        :height integer,
                        :width integer},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
  Creates a copy of a file and applies any requested updates with patch semantics. Folders cannot be copied."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.photos.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/copy"
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

(defn create$
  "https://developers.google.com/drive/api/reference/rest/v3/files/create
  
  Required parameters: none
  
  Optional parameters: enforceSingleParent, ignoreDefaultVisibility, includePermissionsForView, keepRevisionForever, ocrLanguage, supportsAllDrives, supportsTeamDrives, useContentAsIndexableText
  
  Body: 
  
  {:description string,
   :properties {},
   :isAppAuthorized boolean,
   :capabilities {:canDelete boolean,
                  :canAddMyDriveParent boolean,
                  :canTrash boolean,
                  :canMoveChildrenOutOfTeamDrive boolean,
                  :canCopy boolean,
                  :canAddFolderFromAnotherDrive boolean,
                  :canTrashChildren boolean,
                  :canMoveChildrenWithinDrive boolean,
                  :canDownload boolean,
                  :canReadTeamDrive boolean,
                  :canUntrash boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canMoveItemWithinTeamDrive boolean,
                  :canModifyContent boolean,
                  :canShare boolean,
                  :canMoveItemOutOfTeamDrive boolean,
                  :canMoveChildrenWithinTeamDrive boolean,
                  :canChangeViewersCanCopyContent boolean,
                  :canChangeSecurityUpdateEnabled boolean,
                  :canMoveTeamDriveItem boolean,
                  :canReadDrive boolean,
                  :canMoveItemWithinDrive boolean},
   :copyRequiresWriterPermission boolean,
   :imageMediaMetadata {:focalLength number,
                        :aperture number,
                        :rotation integer,
                        :exposureBias number,
                        :flashUsed boolean,
                        :time string,
                        :maxApertureValue number,
                        :colorSpace string,
                        :width integer,
                        :lens string,
                        :exposureMode string,
                        :cameraModel string,
                        :cameraMake string,
                        :whiteBalance string,
                        :exposureTime number,
                        :subjectDistance integer,
                        :meteringMode string,
                        :isoSpeed integer,
                        :location {:altitude number,
                                   :latitude number,
                                   :longitude number},
                        :height integer,
                        :sensor string},
   :modifiedTime string,
   :permissions [{:role string,
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
                  :view string,
                  :photoLink string}],
   :owners [{:displayName string,
             :emailAddress string,
             :kind string,
             :me boolean,
             :permissionId string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :type string}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :emailAddress string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :photoLink string},
   :resourceKey string,
   :modifiedByMe boolean,
   :thumbnailVersion string,
   :folderColorRgb string,
   :createdTime string,
   :spaces [string],
   :fileExtension string,
   :trashed boolean,
   :id string,
   :thumbnailLink string,
   :writersCanShare boolean,
   :explicitlyTrashed boolean,
   :kind string,
   :parents [string],
   :driveId string,
   :sharedWithMeTime string,
   :viewedByMeTime string,
   :mimeType string,
   :trashingUser {:displayName string,
                  :emailAddress string,
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :photoLink string},
   :shared boolean,
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :emailAddress string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:durationMillis string,
                        :height integer,
                        :width integer},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
  Creates a new file."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files"
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

(defn update$
  "https://developers.google.com/drive/api/reference/rest/v3/files/update
  
  Required parameters: fileId
  
  Optional parameters: includePermissionsForView, removeParents, addParents, enforceSingleParent, supportsAllDrives, useContentAsIndexableText, ocrLanguage, supportsTeamDrives, keepRevisionForever
  
  Body: 
  
  {:description string,
   :properties {},
   :isAppAuthorized boolean,
   :capabilities {:canDelete boolean,
                  :canAddMyDriveParent boolean,
                  :canTrash boolean,
                  :canMoveChildrenOutOfTeamDrive boolean,
                  :canCopy boolean,
                  :canAddFolderFromAnotherDrive boolean,
                  :canTrashChildren boolean,
                  :canMoveChildrenWithinDrive boolean,
                  :canDownload boolean,
                  :canReadTeamDrive boolean,
                  :canUntrash boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canRename boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canAddChildren boolean,
                  :canMoveItemWithinTeamDrive boolean,
                  :canModifyContent boolean,
                  :canShare boolean,
                  :canMoveItemOutOfTeamDrive boolean,
                  :canMoveChildrenWithinTeamDrive boolean,
                  :canChangeViewersCanCopyContent boolean,
                  :canChangeSecurityUpdateEnabled boolean,
                  :canMoveTeamDriveItem boolean,
                  :canReadDrive boolean,
                  :canMoveItemWithinDrive boolean},
   :copyRequiresWriterPermission boolean,
   :imageMediaMetadata {:focalLength number,
                        :aperture number,
                        :rotation integer,
                        :exposureBias number,
                        :flashUsed boolean,
                        :time string,
                        :maxApertureValue number,
                        :colorSpace string,
                        :width integer,
                        :lens string,
                        :exposureMode string,
                        :cameraModel string,
                        :cameraMake string,
                        :whiteBalance string,
                        :exposureTime number,
                        :subjectDistance integer,
                        :meteringMode string,
                        :isoSpeed integer,
                        :location {:altitude number,
                                   :latitude number,
                                   :longitude number},
                        :height integer,
                        :sensor string},
   :modifiedTime string,
   :permissions [{:role string,
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
                  :view string,
                  :photoLink string}],
   :owners [{:displayName string,
             :emailAddress string,
             :kind string,
             :me boolean,
             :permissionId string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :type string}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :emailAddress string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :photoLink string},
   :resourceKey string,
   :modifiedByMe boolean,
   :thumbnailVersion string,
   :folderColorRgb string,
   :createdTime string,
   :spaces [string],
   :fileExtension string,
   :trashed boolean,
   :id string,
   :thumbnailLink string,
   :writersCanShare boolean,
   :explicitlyTrashed boolean,
   :kind string,
   :parents [string],
   :driveId string,
   :sharedWithMeTime string,
   :viewedByMeTime string,
   :mimeType string,
   :trashingUser {:displayName string,
                  :emailAddress string,
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :photoLink string},
   :shared boolean,
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :emailAddress string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:durationMillis string,
                        :height integer,
                        :width integer},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
  Updates a file's metadata and/or content. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.scripts"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}"
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
  "https://developers.google.com/drive/api/reference/rest/v3/files/delete
  
  Required parameters: fileId
  
  Optional parameters: enforceSingleParent, supportsAllDrives, supportsTeamDrives
  
  Permanently deletes a file owned by the user without moving it to the trash. If the file belongs to a shared drive the user must be an organizer on the parent. If the target is a folder, all descendants owned by the user are also deleted."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}"
     #{:fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn export$
  "https://developers.google.com/drive/api/reference/rest/v3/files/export
  
  Required parameters: fileId, mimeType
  
  Optional parameters: none
  
  Exports a Google Doc to the requested MIME type and returns the exported content. Please note that the exported content is limited to 10MB."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:mimeType :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/export"
     #{:mimeType :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/files/list
  
  Required parameters: none
  
  Optional parameters: q, includePermissionsForView, includeItemsFromAllDrives, corpora, supportsAllDrives, corpus, teamDriveId, pageToken, pageSize, spaces, includeTeamDriveItems, driveId, supportsTeamDrives, orderBy
  
  Lists or searches files."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "https://developers.google.com/drive/api/reference/rest/v3/files/watch
  
  Required parameters: fileId
  
  Optional parameters: acknowledgeAbuse, includePermissionsForView, supportsAllDrives, supportsTeamDrives
  
  Body: 
  
  {:address string,
   :resourceUri string,
   :payload boolean,
   :expiration string,
   :params {},
   :type string,
   :resourceId string,
   :token string,
   :id string,
   :kind string}
  
  Subscribes to changes to a file"
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/watch"
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

(defn generateIds$
  "https://developers.google.com/drive/api/reference/rest/v3/files/generateIds
  
  Required parameters: none
  
  Optional parameters: count, space, type
  
  Generates a set of file IDs which can be provided in create or copy requests."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/generateIds"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
