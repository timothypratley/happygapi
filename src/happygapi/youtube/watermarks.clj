(ns happygapi.youtube.watermarks
  "YouTube Data API v3: watermarks.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/watermarks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn unset$
  "https://developers.google.com/youtube/api/reference/rest/v3/watermarks/unset
  
  Required parameters: channelId
  
  Optional parameters: onBehalfOfContentOwner
  
  Allows removal of channel watermark."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/watermarks/unset"
     #{:channelId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn set$
  "https://developers.google.com/youtube/api/reference/rest/v3/watermarks/set
  
  Required parameters: channelId
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:targetChannelId string,
   :position {:type string, :cornerPosition string},
   :imageBytes string,
   :imageUrl string,
   :timing {:type string, :durationMs string, :offsetMs string}}
  
  Allows upload of watermark image and setting it for a channel."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/watermarks/set"
     #{:channelId}
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
