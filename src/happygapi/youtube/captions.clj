(ns happygapi.youtube.captions
  "YouTube Data API: captions.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/captions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/captions/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOf, onBehalfOfContentOwner
  
  Deletes a specified caption track."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "captions"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn download$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/captions/download
  
  Required parameters: id
  
  Optional parameters: onBehalfOf, onBehalfOfContentOwner, tfmt, tlang
  
  Downloads a caption track. The caption track is returned in its original format unless the request specifies a value for the tfmt parameter and in its original language unless the request specifies a value for the tlang parameter."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "captions/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/captions/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOf, onBehalfOfContentOwner, sync
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :snippet {:isLarge boolean,
             :trackKind string,
             :audioTrackType string,
             :name string,
             :isCC boolean,
             :isDraft boolean,
             :isEasyReader boolean,
             :status string,
             :language string,
             :videoId string,
             :lastUpdated string,
             :failureReason string,
             :isAutoSynced boolean}}
  
  Uploads a caption track."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "captions"
     #{:part}
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

(defn list$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/captions/list
  
  Required parameters: part, videoId
  
  Optional parameters: id, onBehalfOf, onBehalfOfContentOwner
  
  Returns a list of caption tracks that are associated with a specified video. Note that the API response does not contain the actual captions and that the captions.download method provides the ability to retrieve a caption track."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :videoId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "captions"
     #{:part :videoId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/captions/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOf, onBehalfOfContentOwner, sync
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :snippet {:isLarge boolean,
             :trackKind string,
             :audioTrackType string,
             :name string,
             :isCC boolean,
             :isDraft boolean,
             :isEasyReader boolean,
             :status string,
             :language string,
             :videoId string,
             :lastUpdated string,
             :failureReason string,
             :isAutoSynced boolean}}
  
  Updates a caption track. When updating a caption track, you can change the track's draft status, upload a new caption file for the track, or both."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "captions"
     #{:part}
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
