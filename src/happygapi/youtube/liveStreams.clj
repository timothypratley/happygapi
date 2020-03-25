(ns happygapi.youtube.liveStreams
  "YouTube Data API: liveStreams.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/liveStreams"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveStreams/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Deletes a video stream."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveStreams"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveStreams/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:cdn {:format string,
         :frameRate string,
         :ingestionInfo IngestionInfo,
         :ingestionType string,
         :resolution string},
   :contentDetails {:closedCaptionsIngestionUrl string,
                    :isReusable boolean},
   :etag string,
   :id string,
   :kind string,
   :snippet {:channelId string,
             :description string,
             :isDefaultStream boolean,
             :publishedAt string,
             :title string},
   :status {:healthStatus LiveStreamHealthStatus, :streamStatus string}}
  
  Creates a video stream. The stream enables you to send your video to YouTube, which can then broadcast the video to your audience."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveStreams"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveStreams/list
  
  Required parameters: part
  
  Optional parameters: id, maxResults, mine, onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, pageToken
  
  Returns a list of video streams that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveStreams"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveStreams/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:cdn {:format string,
         :frameRate string,
         :ingestionInfo IngestionInfo,
         :ingestionType string,
         :resolution string},
   :contentDetails {:closedCaptionsIngestionUrl string,
                    :isReusable boolean},
   :etag string,
   :id string,
   :kind string,
   :snippet {:channelId string,
             :description string,
             :isDefaultStream boolean,
             :publishedAt string,
             :title string},
   :status {:healthStatus LiveStreamHealthStatus, :streamStatus string}}
  
  Updates a video stream. If the properties that you want to change cannot be updated, then you need to create a new stream with the proper settings."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveStreams"
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
