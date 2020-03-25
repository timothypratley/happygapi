(ns happygapi.youtube.channels
  "YouTube Data API: channels.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/channels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/channels/list
  
  Required parameters: part
  
  Optional parameters: managedByMe, categoryId, forUsername, pageToken, mine, hl, id, mySubscribers, onBehalfOfContentOwner, maxResults
  
  Returns a collection of zero or more channel resources that match the request criteria."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"
            "https://www.googleapis.com/auth/youtubepartner"
            "https://www.googleapis.com/auth/youtubepartner-channel-audit"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "channels"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/channels/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentOwnerDetails {:contentOwner string, :timeLinked string},
   :localizations {},
   :brandingSettings {:channel ChannelSettings,
                      :hints [PropertyValue],
                      :image ImageSettings,
                      :watch WatchSettings},
   :snippet {:country string,
             :customUrl string,
             :defaultLanguage string,
             :description string,
             :localized ChannelLocalization,
             :publishedAt string,
             :thumbnails ThumbnailDetails,
             :title string},
   :etag string,
   :invideoPromotion {:defaultTiming InvideoTiming,
                      :items [PromotedItem],
                      :position InvideoPosition,
                      :useSmartTiming boolean},
   :auditDetails {:communityGuidelinesGoodStanding boolean,
                  :contentIdClaimsGoodStanding boolean,
                  :copyrightStrikesGoodStanding boolean},
   :conversionPings {:pings [ChannelConversionPing]},
   :statistics {:commentCount string,
                :hiddenSubscriberCount boolean,
                :subscriberCount string,
                :videoCount string,
                :viewCount string},
   :status {:isLinked boolean,
            :longUploadsStatus string,
            :madeForKids boolean,
            :privacyStatus string,
            :selfDeclaredMadeForKids boolean},
   :id string,
   :kind string,
   :contentDetails {:relatedPlaylists {:favorites string,
                                       :likes string,
                                       :uploads string,
                                       :watchHistory string,
                                       :watchLater string}},
   :topicDetails {:topicCategories [string], :topicIds [string]}}
  
  Updates a channel's metadata. Note that this method currently only supports updates to the channel resource's brandingSettings and invideoPromotion objects and their child properties."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "channels"
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
