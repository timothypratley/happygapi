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
  
  {:contentOwnerDetails {:timeLinked string, :contentOwner string},
   :localizations {},
   :brandingSettings {:image ImageSettings,
                      :hints [PropertyValue],
                      :channel ChannelSettings,
                      :watch WatchSettings},
   :snippet {:publishedAt string,
             :defaultLanguage string,
             :customUrl string,
             :description string,
             :title string,
             :thumbnails ThumbnailDetails,
             :localized ChannelLocalization,
             :country string},
   :etag string,
   :auditDetails {:contentIdClaimsGoodStanding boolean,
                  :copyrightStrikesGoodStanding boolean,
                  :communityGuidelinesGoodStanding boolean},
   :conversionPings {:pings [ChannelConversionPing]},
   :statistics {:commentCount string,
                :viewCount string,
                :subscriberCount string,
                :hiddenSubscriberCount boolean,
                :videoCount string},
   :status {:longUploadsStatus string,
            :selfDeclaredMadeForKids boolean,
            :madeForKids boolean,
            :privacyStatus string,
            :isLinked boolean},
   :id string,
   :kind string,
   :contentDetails {:relatedPlaylists {:likes string,
                                       :watchLater string,
                                       :uploads string,
                                       :watchHistory string,
                                       :favorites string}},
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
