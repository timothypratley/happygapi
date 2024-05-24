(ns happygapi.streetviewpublish.photoSequences
  "Street View Publish API: photoSequences.
  Publishes 360 photos to Google Maps, along with position, orientation, and connectivity metadata. Apps can offer an interface for positioning, connecting, and uploading user-generated Street View images. 
  See: https://developers.google.com/streetview/publish/docs/reference/rest/v1/photoSequences"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/streetview/publish/api/reference/rest/v1/photoSequences/list
  
  Required parameters: none
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists all the PhotoSequences that belong to the user, in descending CreatePhotoSequence timestamp order."
  {:scopes ["https://www.googleapis.com/auth/streetviewpublish"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://streetviewpublish.googleapis.com/"
     "v1/photoSequences"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
