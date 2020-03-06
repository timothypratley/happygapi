(ns happygapi.youtube.thumbnails
  "YouTube Data API: thumbnails.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/thumbnails"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn set$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/thumbnails/set
  
  Required parameters: videoId
  
  Optional parameters: onBehalfOfContentOwner
  Uploads a custom video thumbnail to YouTube and sets it for a video."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.upload"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{:videoId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "thumbnails/set"
     #{:videoId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
