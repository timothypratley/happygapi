(ns happygapi.youtube.channels
  "YouTube Data API v3: channels.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/channels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/channels/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner
  
  Body: 
  
  {:contentOwnerDetails {:contentOwner string, :timeLinked string},
   :localizations {},
   :brandingSettings {:channel ChannelSettings,
                      :image ImageSettings,
                      :hints [PropertyValue],
                      :watch WatchSettings},
   :snippet {:country string,
             :publishedAt string,
             :thumbnails ThumbnailDetails,
             :title string,
             :localized ChannelLocalization,
             :description string,
             :defaultLanguage string,
             :customUrl string},
   :etag string,
   :auditDetails {:contentIdClaimsGoodStanding boolean,
                  :communityGuidelinesGoodStanding boolean,
                  :copyrightStrikesGoodStanding boolean},
   :conversionPings {:pings [ChannelConversionPing]},
   :statistics {:hiddenSubscriberCount boolean,
                :viewCount string,
                :videoCount string,
                :subscriberCount string,
                :commentCount string},
   :status {:longUploadsStatus string,
            :isLinked boolean,
            :madeForKids boolean,
            :selfDeclaredMadeForKids boolean,
            :privacyStatus string},
   :id string,
   :kind string,
   :contentDetails {:relatedPlaylists {:favorites string,
                                       :likes string,
                                       :uploads string,
                                       :watchHistory string,
                                       :watchLater string}},
   :topicDetails {:topicIds [string], :topicCategories [string]}}
  
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

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/channels/list
  
  Required parameters: part
  
  Optional parameters: managedByMe, categoryId, forUsername, pageToken, mine, hl, id, mySubscribers, onBehalfOfContentOwner, maxResults
  
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
