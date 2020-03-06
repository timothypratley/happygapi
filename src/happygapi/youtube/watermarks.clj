(ns happygapi.youtube.watermarks
  "YouTube Data API: watermarks.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/watermarks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn set$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/watermarks/set
  
  Required parameters: channelId
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:imageBytes string,
   :imageUrl string,
   :position {:cornerPosition string, :type string},
   :targetChannelId string,
   :timing {:durationMs string, :offsetMs string, :type string}}
  
  Uploads a watermark image to YouTube and sets it for a channel."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:channelId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "watermarks/set"
     #{:channelId}
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

(defn unset$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/watermarks/unset
  
  Required parameters: channelId
  
  Optional parameters: onBehalfOfContentOwner
  Deletes a channel's watermark image."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{:channelId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "watermarks/unset"
     #{:channelId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
