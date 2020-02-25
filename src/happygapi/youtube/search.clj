(ns happygapi.youtube.search
  "YouTube Data API
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "youtube_schema.edn"))))

(defn list$
  "Required parameters: part
  
  Optional parameters: publishedBefore, videoDuration, videoSyndicated, eventType, q, forDeveloper, videoCaption, videoEmbeddable, channelId, videoDimension, videoType, topicId, type, safeSearch, locationRadius, pageToken, videoLicense, forContentOwner, regionCode, relevanceLanguage, publishedAfter, order, forMine, videoDefinition, relatedToVideoId, location, onBehalfOfContentOwner, maxResults, channelType, videoCategoryId
  
  Returns a collection of search results that match the query parameters specified in the API request. By default, a search result set identifies matching video, channel, and playlist resources, but you can also configure queries to only retrieve a specific type of resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "search"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
