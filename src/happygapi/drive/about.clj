(ns happygapi.drive.about
  "Google Drive API: about.
  The Google Drive API allows clients to access resources from Google Drive.
  See: https://developers.google.com/drive/api/reference/rest/v3/about"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/drive/api/reference/rest/v3/about/get
  
  Required parameters: none
  
  Optional parameters: none
  
  Gets information about the user, the user's Drive, and system capabilities."
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
     "about"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
