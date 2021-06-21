(ns happygapi.streetviewpublish.photos
  "Street View Publish API: photos.
  Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images. 
  See: https://developers.google.com/streetview/publish/api/reference/rest/v1/photos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photos/list
  
  Required parameters: none
  
  Optional parameters: pageToken, view, languageCode, pageSize, filter
  
  Lists all the Photos that belong to the user. *Note:* Recently created photos that are still being indexed are not returned in the response."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchUpdate$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photos/batchUpdate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:updatePhotoRequests [{:photo Photo, :updateMask string}]}
  
  Updates the metadata of Photos, such as pose, place association, connections, etc. Changing the pixels of photos is not supported. Note that if BatchUpdatePhotos fails, either critical fields are missing or there is an authentication error. Even if BatchUpdatePhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchUpdatePhotosResponse.results. See UpdatePhoto for specific failures that can occur per photo. Only the fields specified in updateMask field are used. If `updateMask` is not present, the update applies to all fields. The number of UpdatePhotoRequest messages in a BatchUpdatePhotosRequest must not exceed 20. *Note:* To update Pose.altitude, Pose.latLngPair has to be filled as well. Otherwise, the request will fail."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchUpdate"
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

(defn batchGet$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photos/batchGet
  
  Required parameters: none
  
  Optional parameters: photoIds, view, languageCode
  
  Gets the metadata of the specified Photo batch. Note that if BatchGetPhotos fails, either critical fields are missing or there is an authentication error. Even if BatchGetPhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchGetPhotosResponse.results. See GetPhoto for specific failures that can occur per photo."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchGet"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchDelete$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photos/batchDelete
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:photoIds [string]}
  
  Deletes a list of Photos and their metadata. Note that if BatchDeletePhotos fails, either critical fields are missing or there is an authentication error. Even if BatchDeletePhotos succeeds, individual photos in the batch may have failures. These failures are specified in each PhotoResponse.status in BatchDeletePhotosResponse.results. See DeletePhoto for specific failures that can occur per photo."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photos:batchDelete"
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
