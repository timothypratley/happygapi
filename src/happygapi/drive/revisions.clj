(ns happygapi.drive.revisions
  "Drive API: revisions.
  Manages files in Drive including uploading, downloading, searching, detecting changes, and updating sharing permissions.
  See: https://developers.google.com/drive/api/reference/rest/v3/revisions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/drive/api/reference/rest/v3/revisions/delete
  
  Required parameters: fileId, revisionId
  
  Optional parameters: none
  
  Permanently deletes a file version. You can only delete revisions for files with binary content in Google Drive, like images or videos. Revisions for other files, like Google Docs or Sheets, and the last remaining file version can't be deleted."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:revisionId :fileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/revisions/{revisionId}"
     #{:revisionId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/revisions/get
  
  Required parameters: fileId, revisionId
  
  Optional parameters: acknowledgeAbuse
  
  Gets a revision's metadata or content by ID."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:revisionId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/revisions/{revisionId}"
     #{:revisionId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/revisions/list
  
  Required parameters: fileId
  
  Optional parameters: pageSize, pageToken
  
  Lists a file's revisions."
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
     "files/{fileId}/revisions"
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
  "https://developers.google.com/drive/api/reference/rest/v3/revisions/update
  
  Required parameters: fileId, revisionId
  
  Optional parameters: none
  
  Body: 
  
  {:publishedOutsideDomain boolean,
   :modifiedTime string,
   :publishAuto boolean,
   :exportLinks {},
   :size string,
   :lastModifyingUser {:displayName string,
                       :emailAddress string,
                       :kind string,
                       :me boolean,
                       :permissionId string,
                       :photoLink string},
   :id string,
   :kind string,
   :keepForever boolean,
   :mimeType string,
   :md5Checksum string,
   :originalFilename string,
   :published boolean}
  
  Updates a revision with patch semantics."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:revisionId :fileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "files/{fileId}/revisions/{revisionId}"
     #{:revisionId :fileId}
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
