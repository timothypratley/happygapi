(ns happygapi.youtube.playlistItems
  "YouTube Data API v3: playlistItems.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/playlistItems"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistItems/list
  
  Required parameters: part
  
  Optional parameters: videoId, pageToken, maxResults, onBehalfOfContentOwner, id, playlistId
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistItems/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:id string,
   :snippet {:videoOwnerChannelTitle string,
             :description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :videoOwnerChannelId string,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :contentDetails {:startAt string,
                    :videoPublishedAt string,
                    :note string,
                    :videoId string,
                    :endAt string},
   :status {:privacyStatus string},
   :etag string,
   :kind string}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistItems/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:id string,
   :snippet {:videoOwnerChannelTitle string,
             :description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :videoOwnerChannelId string,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :contentDetails {:startAt string,
                    :videoPublishedAt string,
                    :note string,
                    :videoId string,
                    :endAt string},
   :status {:privacyStatus string},
   :etag string,
   :kind string}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
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

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/playlistItems/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/playlistItems"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
