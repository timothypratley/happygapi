(ns happygapi.youtube.liveChatMessages
  "YouTube Data API v3: liveChatMessages.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/liveChatMessages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveChatMessages/list
  
  Required parameters: liveChatId, part
  
  Optional parameters: profileImageSize, maxResults, pageToken, hl
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :liveChatId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
     #{:part :liveChatId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveChatMessages/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a chat message."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/liveChatMessages/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :authorDetails {:isChatOwner boolean,
                   :channelUrl string,
                   :isVerified boolean,
                   :isChatSponsor boolean,
                   :displayName string,
                   :profileImageUrl string,
                   :channelId string,
                   :isChatModerator boolean},
   :etag string,
   :kind string,
   :snippet {:publishedAt string,
             :superChatDetails LiveChatSuperChatDetails,
             :messageDeletedDetails LiveChatMessageDeletedDetails,
             :hasDisplayContent boolean,
             :superStickerDetails LiveChatSuperStickerDetails,
             :type string,
             :fanFundingEventDetails LiveChatFanFundingEventDetails,
             :textMessageDetails LiveChatTextMessageDetails,
             :authorChannelId string,
             :userBannedDetails LiveChatUserBannedMessageDetails,
             :liveChatId string,
             :displayMessage string,
             :messageRetractedDetails LiveChatMessageRetractedDetails}}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveChat/messages"
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
