(ns happygapi.youtube.playlistItems
  "YouTube Data API: playlistItems.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/playlistItems"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/playlistItems/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner
  Deletes a playlist item."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "playlistItems"
     #{:id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/playlistItems/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentDetails {:endAt string,
                    :note string,
                    :startAt string,
                    :videoId string,
                    :videoPublishedAt string},
   :etag string,
   :id string,
   :kind string,
   :snippet {:description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :status {:privacyStatus string}}
  
  Adds a resource to a playlist."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "playlistItems"
     #{:part}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/playlistItems/list
  
  Required parameters: part
  
  Optional parameters: id, maxResults, onBehalfOfContentOwner, pageToken, playlistId, videoId
  Returns a collection of playlist items that match the API request parameters. You can retrieve all of the playlist items in a specified playlist or retrieve one or more playlist items by their unique IDs."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "playlistItems"
     #{:part}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/playlistItems/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentDetails {:endAt string,
                    :note string,
                    :startAt string,
                    :videoId string,
                    :videoPublishedAt string},
   :etag string,
   :id string,
   :kind string,
   :snippet {:description string,
             :publishedAt string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :resourceId ResourceId,
             :position integer,
             :channelTitle string,
             :playlistId string},
   :status {:privacyStatus string}}
  
  Modifies a playlist item. For example, you could update the item's position in the playlist."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "playlistItems"
     #{:part}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
