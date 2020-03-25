(ns happygapi.youtube.subscriptions
  "YouTube Data API: subscriptions.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/subscriptions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/subscriptions/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a subscription."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "subscriptions"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/subscriptions/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:contentDetails {:activityType string,
                    :newItemCount integer,
                    :totalItemCount integer},
   :etag string,
   :id string,
   :kind string,
   :snippet {:channelId string,
             :channelTitle string,
             :description string,
             :publishedAt string,
             :resourceId ResourceId,
             :thumbnails ThumbnailDetails,
             :title string},
   :subscriberSnippet {:channelId string,
                       :description string,
                       :thumbnails ThumbnailDetails,
                       :title string}}
  
  Adds a subscription for the authenticated user's channel."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "subscriptions"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/subscriptions/list
  
  Required parameters: part
  
  Optional parameters: forChannelId, onBehalfOfContentOwnerChannel, channelId, myRecentSubscribers, pageToken, mine, id, order, mySubscribers, onBehalfOfContentOwner, maxResults
  
  Returns subscription resources that match the API request criteria."
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
     "subscriptions"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
