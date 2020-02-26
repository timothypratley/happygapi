(ns happygapi.streetviewpublish.photo
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

(defn delete$
  "Required parameters: photoId
  
  Optional parameters: none
  
  Deletes a Photo and its metadata.
  
  This method returns the following error codes:
  
  * google.rpc.Code.PERMISSION_DENIED if the requesting user did not
  create the requested photo.
  * google.rpc.Code.NOT_FOUND if the photo ID does not exist."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args]
  {:pre [(util/has-keys? args #{"photoId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{photoId}"
     #{"photoId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: photoId
  
  Optional parameters: view, languageCode
  
  Gets the metadata of the specified
  Photo.
  
  This method returns the following error codes:
  
  * google.rpc.Code.PERMISSION_DENIED if the requesting user did not
  create the requested Photo.
  * google.rpc.Code.NOT_FOUND if the requested
  Photo does not exist.
  * google.rpc.Code.UNAVAILABLE if the requested
  Photo is still being indexed."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args]
  {:pre [(util/has-keys? args #{"photoId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{photoId}"
     #{"photoId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: id
  
  Optional parameters: updateMask
  
  Updates the metadata of a Photo, such
  as pose, place association, connections, etc. Changing the pixels of a
  photo is not supported.
  
  Only the fields specified in the
  updateMask
  field are used. If `updateMask` is not present, the update applies to all
  fields.
  
  This method returns the following error codes:
  
  * google.rpc.Code.PERMISSION_DENIED if the requesting user did not
  create the requested photo.
  * google.rpc.Code.INVALID_ARGUMENT if the request is malformed.
  * google.rpc.Code.NOT_FOUND if the requested photo does not exist.
  * google.rpc.Code.UNAVAILABLE if the requested
  Photo is still being indexed."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo/{id}"
     #{"id"}
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

(defn create$
  "Required parameters: none
  
  Optional parameters: none
  
  After the client finishes uploading the photo with the returned
  UploadRef,
  CreatePhoto
  publishes the uploaded Photo to
  Street View on Google Maps.
  
  Currently, the only way to set heading, pitch, and roll in CreatePhoto is
  through the [Photo Sphere XMP
  metadata](https://developers.google.com/streetview/spherical-metadata) in
  the photo bytes. CreatePhoto ignores the  `pose.heading`, `pose.pitch`,
  `pose.roll`, `pose.altitude`, and `pose.level` fields in Pose.
  
  This method returns the following error codes:
  
  * google.rpc.Code.INVALID_ARGUMENT if the request is malformed or if
  the uploaded photo is not a 360 photo.
  * google.rpc.Code.NOT_FOUND if the upload reference does not exist.
  * google.rpc.Code.RESOURCE_EXHAUSTED if the account has reached the
  storage limit."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo"
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

(defn startUpload$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates an upload session to start uploading photo bytes.  The method uses
  the upload URL of the returned
  UploadRef to upload the bytes for
  the Photo.
  
  In addition to the photo requirements shown in
  https://support.google.com/maps/answer/7012050?hl=en&ref_topic=6275604,
  the photo must meet the following requirements:
  
  * Photo Sphere XMP metadata must be included in the photo metadata. See
  https://developers.google.com/streetview/spherical-metadata for the
  required fields.
  * The pixel size of the photo must meet the size requirements listed in
  https://support.google.com/maps/answer/7012050?hl=en&ref_topic=6275604, and
  the photo must be a full 360 horizontally.
  
  After the upload completes, the method uses
  UploadRef with
  CreatePhoto
  to create the Photo object entry."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photo:startUpload"
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
