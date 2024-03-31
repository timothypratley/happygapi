(ns happygapi.firebaseappdistribution.media
  "Firebase App Distribution API: media.
  
  See: https://firebase.google.com/products/app-distributionapi/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://firebase.google.com/products/app-distributionapi/reference/rest/v1/media/upload
  
  Required parameters: app
  
  Optional parameters: none
  
  Body: 
  
  {:blob {:path string,
          :sha256Hash string,
          :algorithm string,
          :hash string,
          :contentTypeInfo GdataContentTypeInfo,
          :diffChecksumsResponse GdataDiffChecksumsResponse,
          :objectId GdataObjectId,
          :crc32cHash integer,
          :isPotentialRetry boolean,
          :diffVersionResponse GdataDiffVersionResponse,
          :blobRef string,
          :bigstoreObjectRef string,
          :cosmoBinaryReference string,
          :md5Hash string,
          :token string,
          :filename string,
          :diffUploadResponse GdataDiffUploadResponse,
          :sha1Hash string,
          :diffDownloadResponse GdataDiffDownloadResponse,
          :compositeMedia [GdataCompositeMedia],
          :referenceType string,
          :length string,
          :downloadParameters GdataDownloadParameters,
          :blobstore2Info GdataBlobstore2Info,
          :hashVerified boolean,
          :contentType string,
          :diffUploadRequest GdataDiffUploadRequest,
          :timestamp string,
          :inline string,
          :mediaId string}}
  
  Uploads a binary. Uploading a binary can result in a new release being created, an update to an existing release, or a no-op if a release with the same binary already exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:app})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://firebaseappdistribution.googleapis.com/"
     "v1/{+app}/releases:upload"
     #{:app}
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
