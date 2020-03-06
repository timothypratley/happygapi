(ns happygapi.youtube.liveChatMessages
  "YouTube Data API: liveChatMessages.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatMessages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatMessages/delete
  
  Required parameters: id
  
  Optional parameters: none
  Deletes a chat message."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveChat/messages"
     #{:id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatMessages/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:authorDetails {:channelId string,
                   :channelUrl string,
                   :displayName string,
                   :isChatModerator boolean,
                   :isChatOwner boolean,
                   :isChatSponsor boolean,
                   :isVerified boolean,
                   :profileImageUrl string},
   :etag string,
   :id string,
   :kind string,
   :snippet {:publishedAt string,
             :superChatDetails LiveChatSuperChatDetails,
             :messageDeletedDetails LiveChatMessageDeletedDetails,
             :hasDisplayContent boolean,
             :superStickerDetails LiveChatSuperStickerDetails,
             :type string,
             :pollOpenedDetails LiveChatPollOpenedDetails,
             :fanFundingEventDetails LiveChatFanFundingEventDetails,
             :textMessageDetails LiveChatTextMessageDetails,
             :authorChannelId string,
             :pollClosedDetails LiveChatPollClosedDetails,
             :userBannedDetails LiveChatUserBannedMessageDetails,
             :liveChatId string,
             :pollVotedDetails LiveChatPollVotedDetails,
             :pollEditedDetails LiveChatPollEditedDetails,
             :displayMessage string,
             :messageRetractedDetails LiveChatMessageRetractedDetails}}
  
  Adds a message to a live chat."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveChat/messages"
     #{:part}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatMessages/list
  
  Required parameters: liveChatId, part
  
  Optional parameters: hl, maxResults, pageToken, profileImageSize
  Lists live chat messages for a specific chat."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:part :liveChatId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveChat/messages"
     #{:part :liveChatId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
