(ns happygapi.streetviewpublish.photos
  "Street View Publish API
  Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images.
  
  See: https://developers.google.com/streetview/publish/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "streetviewpublish_schema.edn"))))

(defn batchGet$
  "Required parameters: none
  
  Optional parameters: languageCode, photoIds, view
  
  Gets the metadata of the specified
  Photo batch.
  
  Note that if
  BatchGetPhotos
  fails, either critical fields are missing or there is an authentication
  error. Even if
  BatchGetPhotos
  succeeds, individual photos in the batch may have failures.
  These failures are specified in each
  PhotoResponse.status
  in
  BatchGetPhotosResponse.results.
  See
  GetPhoto
  for specific failures that can occur per photo."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchGet"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  Optional parameters: view, filter, languageCode, pageToken, pageSize
  
  Lists all the Photos that belong to
  the user.
  
  <aside class=\"note\"><b>Note:</b> Recently created photos that are still
  being indexed are not returned in the response.</aside>"
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn batchUpdate$
  "Required parameters: none
  
  Optional parameters: none
  
  Updates the metadata of Photos, such
  as pose, place association, connections, etc. Changing the pixels of photos
  is not supported.
  
  Note that if
  BatchUpdatePhotos
  fails, either critical fields are missing or there is an authentication
  error. Even if
  BatchUpdatePhotos
  succeeds, individual photos in the batch may have failures.
  These failures are specified in each
  PhotoResponse.status
  in
  BatchUpdatePhotosResponse.results.
  See
  UpdatePhoto
  for specific failures that can occur per photo.
  
  Only the fields specified in
  updateMask
  field are used. If `updateMask` is not present, the update applies to all
  fields.
  
  The number of
  UpdatePhotoRequest
  messages in a
  BatchUpdatePhotosRequest
  must not exceed 20.
  
  <aside class=\"note\"><b>Note:</b> To update
  Pose.altitude,
  Pose.latLngPair has to be
  filled as well. Otherwise, the request will fail.</aside>"
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchUpdate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn batchDelete$
  "Required parameters: none
  
  Optional parameters: none
  
  Deletes a list of Photos and their
  metadata.
  
  Note that if
  BatchDeletePhotos
  fails, either critical fields are missing or there is an authentication
  error. Even if
  BatchDeletePhotos
  succeeds, individual photos in the batch may have failures.
  These failures are specified in each
  PhotoResponse.status
  in
  BatchDeletePhotosResponse.results.
  See
  DeletePhoto
  for specific failures that can occur per photo."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchDelete"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
