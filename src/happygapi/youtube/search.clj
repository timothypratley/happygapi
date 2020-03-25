(ns happygapi.youtube.search
  "YouTube Data API: search.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/search"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/search/list
  
  Required parameters: part
  
  Optional parameters: publishedBefore, videoDuration, videoSyndicated, eventType, q, forDeveloper, videoCaption, videoEmbeddable, channelId, videoDimension, videoType, topicId, type, safeSearch, locationRadius, pageToken, videoLicense, forContentOwner, regionCode, relevanceLanguage, publishedAfter, order, forMine, videoDefinition, relatedToVideoId, location, onBehalfOfContentOwner, maxResults, channelType, videoCategoryId
  
  Returns a collection of search results that match the query parameters specified in the API request. By default, a search result set identifies matching video, channel, and playlist resources, but you can also configure queries to only retrieve a specific type of resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "search"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
