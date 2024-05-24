(ns happygapi.youtube.captions
  "YouTube Data API v3: captions.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/docs/reference/rest/v3/captions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://developers.google.com/youtube/api/reference/rest/v3/captions/download
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, tfmt, tlang, onBehalfOf
  
  Downloads a caption track."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/captions/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/captions/update
  
  Required parameters: part
  
  Optional parameters: sync, onBehalfOfContentOwner, onBehalfOf
  
  Body: 
  
  {:etag string,
   :kind string,
   :id string,
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
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/captions"
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

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/captions/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOf, sync
  
  Body: 
  
  {:etag string,
   :kind string,
   :id string,
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
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/captions"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/captions/list
  
  Required parameters: part, videoId
  
  Optional parameters: onBehalfOf, id, onBehalfOfContentOwner
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :videoId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/captions"
     #{:part :videoId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/captions/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOf
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/captions"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
