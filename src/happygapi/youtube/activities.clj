(ns happygapi.youtube.activities
  "YouTube Data API: activities.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/activities"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/activities/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:contentDetails {:like ActivityContentDetailsLike,
                    :social ActivityContentDetailsSocial,
                    :promotedItem ActivityContentDetailsPromotedItem,
                    :recommendation ActivityContentDetailsRecommendation,
                    :playlistItem ActivityContentDetailsPlaylistItem,
                    :bulletin ActivityContentDetailsBulletin,
                    :comment ActivityContentDetailsComment,
                    :channelItem ActivityContentDetailsChannelItem,
                    :favorite ActivityContentDetailsFavorite,
                    :subscription ActivityContentDetailsSubscription,
                    :upload ActivityContentDetailsUpload},
   :etag string,
   :id string,
   :kind string,
   :snippet {:channelId string,
             :channelTitle string,
             :description string,
             :groupId string,
             :publishedAt string,
             :thumbnails ThumbnailDetails,
             :title string,
             :type string}}
  
  Posts a bulletin for a specific channel. (The user submitting the request must be authorized to act on the channel's behalf.)
  
  Note: Even though an activity resource can contain information about actions like a user rating a video or marking a video as a favorite, you need to use other API methods to generate those activity resources. For example, you would use the API's videos.rate() method to rate a video and the playlistItems.insert() method to mark a video as a favorite."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "activities"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/activities/list
  
  Required parameters: part
  
  Optional parameters: publishedBefore, home, channelId, pageToken, mine, regionCode, publishedAfter, maxResults
  
  Returns a list of channel activity events that match the request criteria. For example, you can retrieve events associated with a particular channel, events associated with the user's subscriptions and Google+ friends, or the YouTube home page feed, which is customized for each user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "activities"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
