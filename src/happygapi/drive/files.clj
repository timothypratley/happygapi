(ns happygapi.drive.files
  "Google Drive API: files.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/api/reference/rest/v3/files"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn emptyTrash$
  "https://developers.google.com/drive/api/reference/rest/v3/files/emptyTrash
  
  Required parameters: none
  
  Optional parameters: enforceSingleParent, driveId
  
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
  
  Optional parameters: acknowledgeAbuse, supportsAllDrives, supportsTeamDrives, includePermissionsForView, includeLabels
  
   Gets a file's metadata or content by ID. If you provide the URL parameter `alt=media`, then the response includes the file contents in the response body. Downloading content with `alt=media` only works if the file is stored in Drive. To download Google Docs, Sheets, and Slides use [`files.export`](/drive/api/reference/rest/v3/files/export) instead. For more information, see [Download & export files](/drive/api/guides/manage-downloads)."
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
  
  Optional parameters: includePermissionsForView, includeLabels, enforceSingleParent, supportsAllDrives, ocrLanguage, ignoreDefaultVisibility, supportsTeamDrives, keepRevisionForever
  
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
                  :canModifyEditorContentRestriction boolean,
                  :canModifyLabels boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canAcceptOwnership boolean,
                  :canRename boolean,
                  :canRemoveContentRestriction boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canModifyOwnerContentRestriction boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canReadLabels boolean,
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
                        :location {:latitude number,
                                   :longitude number,
                                   :altitude number},
                        :height integer,
                        :sensor string},
   :sha256Checksum string,
   :modifiedTime string,
   :permissions [{:role string,
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
                  :photoLink string}],
   :owners [{:displayName string,
             :kind string,
             :me boolean,
             :permissionId string,
             :emailAddress string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :type string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :ownerRestricted boolean,
                          :systemRestricted boolean}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :emailAddress string,
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
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :emailAddress string,
                  :photoLink string},
   :shared boolean,
   :labelInfo {:labels [{:id string,
                         :revisionId string,
                         :kind string,
                         :fields {}}]},
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :emailAddress string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:width integer,
                        :height integer,
                        :durationMillis string},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :sha1Checksum string,
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
  Creates a copy of a file and applies any requested updates with patch semantics."
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

(defn modifyLabels$
  "https://developers.google.com/drive/api/reference/rest/v3/files/modifyLabels
  
  Required parameters: fileId
  
  Optional parameters: none
  
  Body: 
  
  {:labelModifications [{:labelId string,
                         :fieldModifications [LabelFieldModification],
                         :removeLabel boolean,
                         :kind string}],
   :kind string}
  
  Modifies the set of labels applied to a file. Returns a list of the labels that were added or modified."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/modifyLabels"
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
  
  Optional parameters: includePermissionsForView, includeLabels, enforceSingleParent, supportsAllDrives, useContentAsIndexableText, ocrLanguage, ignoreDefaultVisibility, supportsTeamDrives, keepRevisionForever
  
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
                  :canModifyEditorContentRestriction boolean,
                  :canModifyLabels boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canAcceptOwnership boolean,
                  :canRename boolean,
                  :canRemoveContentRestriction boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canModifyOwnerContentRestriction boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canReadLabels boolean,
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
                        :location {:latitude number,
                                   :longitude number,
                                   :altitude number},
                        :height integer,
                        :sensor string},
   :sha256Checksum string,
   :modifiedTime string,
   :permissions [{:role string,
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
                  :photoLink string}],
   :owners [{:displayName string,
             :kind string,
             :me boolean,
             :permissionId string,
             :emailAddress string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :type string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :ownerRestricted boolean,
                          :systemRestricted boolean}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :emailAddress string,
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
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :emailAddress string,
                  :photoLink string},
   :shared boolean,
   :labelInfo {:labels [{:id string,
                         :revisionId string,
                         :kind string,
                         :fields {}}]},
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :emailAddress string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:width integer,
                        :height integer,
                        :durationMillis string},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :sha1Checksum string,
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
   Creates a new file. This method supports an */upload* URI and accepts uploaded media with the following characteristics: - *Maximum file size:* 5,120 GB - *Accepted Media MIME types:*`*/*` Note: Specify a valid MIME type, rather than the literal `*/*` value. The literal `*/*` is only used to indicate that any valid MIME type can be uploaded. For more information on uploading files, see [Upload file data](/drive/api/guides/manage-uploads). Apps creating shortcuts with `files.create` must specify the MIME type `application/vnd.google-apps.shortcut`. Apps should specify a file extension in the `name` property when inserting files with the API. For example, an operation to insert a JPEG file should specify something like `\"name\": \"cat.jpg\"` in the metadata. Subsequent `GET` requests include the read-only `fileExtension` property populated with the extension originally specified in the `title` property. When a Google Drive user requests to download a file, or when the file is downloaded through the sync client, Drive builds a full filename (with extension) based on the title. In cases where the extension is missing, Drive attempts to determine the extension based on the file's MIME type."
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
  
  Optional parameters: includePermissionsForView, includeLabels, removeParents, addParents, enforceSingleParent, supportsAllDrives, useContentAsIndexableText, ocrLanguage, supportsTeamDrives, keepRevisionForever
  
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
                  :canModifyEditorContentRestriction boolean,
                  :canModifyLabels boolean,
                  :canMoveChildrenOutOfDrive boolean,
                  :canDeleteChildren boolean,
                  :canListChildren boolean,
                  :canAcceptOwnership boolean,
                  :canRename boolean,
                  :canRemoveContentRestriction boolean,
                  :canChangeCopyRequiresWriterPermission boolean,
                  :canModifyOwnerContentRestriction boolean,
                  :canReadRevisions boolean,
                  :canMoveItemIntoTeamDrive boolean,
                  :canRemoveMyDriveParent boolean,
                  :canModifyContentRestriction boolean,
                  :canMoveItemOutOfDrive boolean,
                  :canEdit boolean,
                  :canComment boolean,
                  :canRemoveChildren boolean,
                  :canReadLabels boolean,
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
                        :location {:latitude number,
                                   :longitude number,
                                   :altitude number},
                        :height integer,
                        :sensor string},
   :sha256Checksum string,
   :modifiedTime string,
   :permissions [{:role string,
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
                  :photoLink string}],
   :owners [{:displayName string,
             :kind string,
             :me boolean,
             :permissionId string,
             :emailAddress string,
             :photoLink string}],
   :permissionIds [string],
   :headRevisionId string,
   :modifiedByMeTime string,
   :starred boolean,
   :fullFileExtension string,
   :exportLinks {},
   :contentRestrictions [{:readOnly boolean,
                          :reason string,
                          :type string,
                          :restrictingUser User,
                          :restrictionTime string,
                          :ownerRestricted boolean,
                          :systemRestricted boolean}],
   :name string,
   :viewersCanCopyContent boolean,
   :iconLink string,
   :teamDriveId string,
   :size string,
   :hasThumbnail boolean,
   :lastModifyingUser {:displayName string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :emailAddress string,
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
                  :kind string,
                  :me boolean,
                  :permissionId string,
                  :emailAddress string,
                  :photoLink string},
   :shared boolean,
   :labelInfo {:labels [{:id string,
                         :revisionId string,
                         :kind string,
                         :fields {}}]},
   :shortcutDetails {:targetId string,
                     :targetMimeType string,
                     :targetResourceKey string},
   :sharingUser {:displayName string,
                 :kind string,
                 :me boolean,
                 :permissionId string,
                 :emailAddress string,
                 :photoLink string},
   :md5Checksum string,
   :hasAugmentedPermissions boolean,
   :quotaBytesUsed string,
   :version string,
   :originalFilename string,
   :trashedTime string,
   :webViewLink string,
   :videoMediaMetadata {:width integer,
                        :height integer,
                        :durationMillis string},
   :viewedByMe boolean,
   :linkShareMetadata {:securityUpdateEligible boolean,
                       :securityUpdateEnabled boolean},
   :sha1Checksum string,
   :contentHints {:indexableText string,
                  :thumbnail {:image string, :mimeType string}},
   :appProperties {},
   :ownedByMe boolean,
   :webContentLink string}
  
   Updates a file's metadata and/or content. When calling this method, only populate fields in the request that you want to modify. When updating fields, some fields might be changed automatically, such as `modifiedDate`. This method supports patch semantics. This method supports an */upload* URI and accepts uploaded media with the following characteristics: - *Maximum file size:* 5,120 GB - *Accepted Media MIME types:*`*/*` Note: Specify a valid MIME type, rather than the literal `*/*` value. The literal `*/*` is only used to indicate that any valid MIME type can be uploaded. For more information on uploading files, see [Upload file data](/drive/api/guides/manage-uploads)."
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
  
  Optional parameters: supportsAllDrives, supportsTeamDrives, enforceSingleParent
  
  Permanently deletes a file owned by the user without moving it to the trash. If the file belongs to a shared drive, the user must be an `organizer` on the parent folder. If the target is a folder, all descendants owned by the user are also deleted."
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
  
  Exports a Google Workspace document to the requested MIME type and returns exported byte content. Note that the exported content is limited to 10MB."
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
  
  Optional parameters: q, includePermissionsForView, includeLabels, includeItemsFromAllDrives, corpora, supportsAllDrives, corpus, teamDriveId, pageToken, pageSize, spaces, includeTeamDriveItems, driveId, supportsTeamDrives, orderBy
  
   Lists the user's files. This method accepts the `q` parameter, which is a search query combining one or more search terms. For more information, see the [Search for files & folders](/drive/api/guides/search-files) guide. *Note:* This method returns *all* files by default, including trashed files. If you don't want trashed files to appear in the list, use the `trashed=false` query parameter to remove trashed files from the results."
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
  
  Optional parameters: supportsAllDrives, supportsTeamDrives, acknowledgeAbuse, includePermissionsForView, includeLabels
  
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
  
  Subscribes to changes to a file."
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

(defn listLabels$
  "https://developers.google.com/drive/api/reference/rest/v3/files/listLabels
  
  Required parameters: fileId
  
  Optional parameters: maxResults, pageToken
  
  Lists the labels on a file."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/listLabels"
     #{:fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
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
