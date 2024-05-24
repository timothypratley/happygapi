(ns happygapi.drive.apps
  "Google Drive API: apps.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/docs/reference/rest/v3/apps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/apps/get
  
  Required parameters: appId
  
  Optional parameters: none
  
  Gets a specific app."
  {:scopes ["https://www.googleapis.com/auth/drive"
            "https://www.googleapis.com/auth/drive.appdata"
            "https://www.googleapis.com/auth/drive.apps.readonly"
            "https://www.googleapis.com/auth/drive.file"
            "https://www.googleapis.com/auth/drive.metadata"
            "https://www.googleapis.com/auth/drive.metadata.readonly"
            "https://www.googleapis.com/auth/drive.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "apps/{appId}"
     #{:appId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/drive/api/reference/rest/v3/apps/list
  
  Required parameters: none
  
  Optional parameters: appFilterExtensions, appFilterMimeTypes, languageCode
  
  Lists a user's installed apps."
  {:scopes ["https://www.googleapis.com/auth/drive.apps.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/drive/v3/"
     "apps"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
