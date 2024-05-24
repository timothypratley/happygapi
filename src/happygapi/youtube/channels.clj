(ns happygapi.youtube.channels
  "YouTube Data API v3: channels.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/docs/reference/rest/v3/channels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/channels/list
  
  Required parameters: part
  
  Optional parameters: managedByMe, categoryId, forUsername, pageToken, mine, hl, id, forHandle, mySubscribers, onBehalfOfContentOwner, maxResults
  
  Retrieves a list of resources, possibly filtered."
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
     "https://youtube.googleapis.com/"
     "youtube/v3/channels"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/channels/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentOwnerDetails {:timeLinked string, :contentOwner string},
   :localizations {},
   :brandingSettings {:watch WatchSettings,
                      :image ImageSettings,
                      :hints [PropertyValue],
                      :channel ChannelSettings},
   :snippet {:defaultLanguage string,
             :description string,
             :thumbnails ThumbnailDetails,
             :title string,
             :localized ChannelLocalization,
             :publishedAt string,
             :customUrl string,
             :country string},
   :etag string,
   :auditDetails {:communityGuidelinesGoodStanding boolean,
                  :contentIdClaimsGoodStanding boolean,
                  :copyrightStrikesGoodStanding boolean},
   :conversionPings {:pings [ChannelConversionPing]},
   :statistics {:hiddenSubscriberCount boolean,
                :videoCount string,
                :subscriberCount string,
                :viewCount string,
                :commentCount string},
   :status {:isLinked boolean,
            :privacyStatus string,
            :selfDeclaredMadeForKids boolean,
            :longUploadsStatus string,
            :madeForKids boolean},
   :id string,
   :kind string,
   :contentDetails {:relatedPlaylists {:favorites string,
                                       :uploads string,
                                       :likes string,
                                       :watchLater string,
                                       :watchHistory string}},
   :topicDetails {:topicCategories [string], :topicIds [string]}}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtubepartner"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/channels"
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
