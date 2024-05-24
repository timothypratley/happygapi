(ns happygapi.streetviewpublish.photo
  "Street View Publish API: photo.
  Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images. 
  See: https://developers.google.com/streetview/publish/docs/reference/rest/v1/photo"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn startUpload$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photo/startUpload
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Creates an upload session to start uploading photo bytes. The method uses the upload URL of the returned UploadRef to upload the bytes for the Photo. In addition to the photo requirements shown in https://support.google.com/maps/answer/7012050?ref_topic=6275604, the photo must meet the following requirements: * Photo Sphere XMP metadata must be included in the photo metadata. See https://developers.google.com/streetview/spherical-metadata for the required fields. * The pixel size of the photo must meet the size requirements listed in https://support.google.com/maps/answer/7012050?ref_topic=6275604, and the photo must be a full 360 horizontally. After the upload completes, the method uses UploadRef with CreatePhoto to create the Photo object entry."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo:startUpload"
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
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photo/update
  
  Required parameters: id
  
  Optional parameters: updateMask
  
  Body: 
  
  {:uploadTime string,
   :captureTime string,
   :thumbnailUrl string,
   :uploadReference {:uploadUrl string},
   :viewCount string,
   :transferStatus string,
   :pose {:pitch number,
          :accuracyMeters number,
          :gpsRecordTimestampUnixEpoch string,
          :heading number,
          :altitude number,
          :latLngPair LatLng,
          :level Level,
          :roll number},
   :shareLink string,
   :mapsPublishStatus string,
   :downloadUrl string,
   :connections [{:target PhotoId}],
   :places [{:name string, :placeId string, :languageCode string}],
   :photoId {:id string}}
  
  Updates the metadata of a Photo, such as pose, place association, connections, etc. Changing the pixels of a photo is not supported. Only the fields specified in the updateMask field are used. If `updateMask` is not present, the update applies to all fields. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo. * google.rpc.Code.INVALID_ARGUMENT if the request is malformed. * google.rpc.Code.NOT_FOUND if the requested photo does not exist. * google.rpc.Code.UNAVAILABLE if the requested Photo is still being indexed."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{id}"
     #{:id}
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
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photo/delete
  
  Required parameters: photoId
  
  Optional parameters: none
  
  Deletes a Photo and its metadata. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo. * google.rpc.Code.NOT_FOUND if the photo ID does not exist."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:photoId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{photoId}"
     #{:photoId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photo/get
  
  Required parameters: photoId
  
  Optional parameters: languageCode, view
  
  Gets the metadata of the specified Photo. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested Photo. * google.rpc.Code.NOT_FOUND if the requested Photo does not exist. * google.rpc.Code.UNAVAILABLE if the requested Photo is still being indexed."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:photoId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{photoId}"
     #{:photoId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photo/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:uploadTime string,
   :captureTime string,
   :thumbnailUrl string,
   :uploadReference {:uploadUrl string},
   :viewCount string,
   :transferStatus string,
   :pose {:pitch number,
          :accuracyMeters number,
          :gpsRecordTimestampUnixEpoch string,
          :heading number,
          :altitude number,
          :latLngPair LatLng,
          :level Level,
          :roll number},
   :shareLink string,
   :mapsPublishStatus string,
   :downloadUrl string,
   :connections [{:target PhotoId}],
   :places [{:name string, :placeId string, :languageCode string}],
   :photoId {:id string}}
  
  After the client finishes uploading the photo with the returned UploadRef, CreatePhoto publishes the uploaded Photo to Street View on Google Maps. Currently, the only way to set heading, pitch, and roll in CreatePhoto is through the [Photo Sphere XMP metadata](https://developers.google.com/streetview/spherical-metadata) in the photo bytes. CreatePhoto ignores the `pose.heading`, `pose.pitch`, `pose.roll`, `pose.altitude`, and `pose.level` fields in Pose. This method returns the following error codes: * google.rpc.Code.INVALID_ARGUMENT if the request is malformed or if the uploaded photo is not a 360 photo. * google.rpc.Code.NOT_FOUND if the upload reference does not exist. * google.rpc.Code.RESOURCE_EXHAUSTED if the account has reached the storage limit."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo"
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
