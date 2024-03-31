(ns happygapi.youtube.search
  "YouTube Data API v3: search.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/search"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/search/list
  
  Required parameters: part
  
  Optional parameters: publishedBefore, videoDuration, videoSyndicated, eventType, q, forDeveloper, videoCaption, videoEmbeddable, channelId, videoDimension, videoType, topicId, type, videoPaidProductPlacement, safeSearch, locationRadius, pageToken, videoLicense, forContentOwner, regionCode, relevanceLanguage, publishedAfter, order, forMine, videoDefinition, location, onBehalfOfContentOwner, maxResults, channelType, videoCategoryId
  
  Retrieves a list of search resources"
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
     "youtube/v3/search"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
