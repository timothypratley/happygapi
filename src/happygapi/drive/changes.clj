(ns happygapi.drive.changes
  "Google Drive API: changes.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/api/reference/rest/v3/changes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getStartPageToken$
  "https://developers.google.com/drive/api/reference/rest/v3/changes/getStartPageToken
  
  Required parameters: none
  
  Optional parameters: driveId, supportsAllDrives, supportsTeamDrives, teamDriveId
  
  Gets the starting pageToken for listing future changes."
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
     "changes/startPageToken"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/changes/list
  
  Required parameters: pageToken
  
  Optional parameters: includeRemoved, restrictToMyDrive, includeCorpusRemovals, includePermissionsForView, includeLabels, includeItemsFromAllDrives, supportsAllDrives, teamDriveId, pageSize, spaces, includeTeamDriveItems, driveId, supportsTeamDrives
  
  Lists the changes for a user or shared drive."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:pageToken})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "changes"
     #{:pageToken}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn watch$
  "https://developers.google.com/drive/api/reference/rest/v3/changes/watch
  
  Required parameters: pageToken
  
  Optional parameters: includeRemoved, restrictToMyDrive, includeCorpusRemovals, includePermissionsForView, includeLabels, includeItemsFromAllDrives, supportsAllDrives, teamDriveId, pageSize, spaces, includeTeamDriveItems, driveId, supportsTeamDrives
  
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
  
  Subscribes to changes for a user."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.photos.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:pageToken})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "changes/watch"
     #{:pageToken}
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
