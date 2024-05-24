(ns happygapi.streetviewpublish.photoSequence
  "Street View Publish API: photoSequence.
  Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images. 
  See: https://developers.google.com/streetview/publish/docs/reference/rest/v1/photoSequence"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn startUpload$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photoSequence/startUpload
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Creates an upload session to start uploading photo sequence data. The upload URL of the returned UploadRef is used to upload the data for the `photoSequence`. After the upload is complete, the UploadRef is used with CreatePhotoSequence to create the PhotoSequence object entry."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photoSequence:startUpload"
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

(defn get$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photoSequence/get
  
  Required parameters: sequenceId
  
  Optional parameters: view, filter
  
  Gets the metadata of the specified PhotoSequence via the Operation interface. This method returns the following three types of responses: * `Operation.done` = false, if the processing of PhotoSequence is not finished yet. * `Operation.done` = true and `Operation.error` is populated, if there was an error in processing. * `Operation.done` = true and `Operation.response` is poulated, which contains a PhotoSequence message. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested PhotoSequence. * google.rpc.Code.NOT_FOUND if the requested PhotoSequence does not exist."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sequenceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photoSequence/{sequenceId}"
     #{:sequenceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photoSequence/create
  
  Required parameters: none
  
  Optional parameters: inputType
  
  Body: 
  
  {:uploadTime string,
   :gpsSource string,
   :imu {:magUt [Measurement3d],
         :gyroRps [Measurement3d],
         :accelMpsps [Measurement3d]},
   :distanceMeters number,
   :captureTimeOverride string,
   :rawGpsTimeline [{:pitch number,
                     :accuracyMeters number,
                     :gpsRecordTimestampUnixEpoch string,
                     :heading number,
                     :altitude number,
                     :latLngPair LatLng,
                     :level Level,
                     :roll number}],
   :uploadReference {:uploadUrl string},
   :processingState string,
   :filename string,
   :photos [{:uploadTime string,
             :captureTime string,
             :thumbnailUrl string,
             :uploadReference UploadRef,
             :viewCount string,
             :transferStatus string,
             :pose Pose,
             :shareLink string,
             :mapsPublishStatus string,
             :downloadUrl string,
             :connections [Connection],
             :places [Place],
             :photoId PhotoId}],
   :id string,
   :viewCount string,
   :failureDetails {:notOutdoorsDetails NotOutdoorsFailureDetails,
                    :noOverlapGpsDetails NoOverlapGpsFailureDetails,
                    :insufficientGpsDetails InsufficientGpsFailureDetails,
                    :gpsDataGapDetails GpsDataGapFailureDetails,
                    :imuDataGapDetails ImuDataGapFailureDetails},
   :sequenceBounds {:northeast LatLng, :southwest LatLng},
   :failureReason string}
  
  After the client finishes uploading the PhotoSequence with the returned UploadRef, CreatePhotoSequence extracts a sequence of 360 photos from a video or Extensible Device Metadata (XDM, http://www.xdm.org/) to be published to Street View on Google Maps. `CreatePhotoSequence` returns an Operation, with the PhotoSequence Id set in the `Operation.name` field. This method returns the following error codes: * google.rpc.Code.INVALID_ARGUMENT if the request is malformed. * google.rpc.Code.NOT_FOUND if the upload reference does not exist."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photoSequence"
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

(defn delete$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photoSequence/delete
  
  Required parameters: sequenceId
  
  Optional parameters: none
  
  Deletes a PhotoSequence and its metadata. This method returns the following error codes: * google.rpc.Code.PERMISSION_DENIED if the requesting user did not create the requested photo sequence. * google.rpc.Code.NOT_FOUND if the photo sequence ID does not exist. * google.rpc.Code.FAILED_PRECONDITION if the photo sequence ID is not yet finished processing."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:sequenceId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photoSequence/{sequenceId}"
     #{:sequenceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
