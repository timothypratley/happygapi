(ns happygapi.youtube.liveChatBans
  "YouTube Data API: liveChatBans.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatBans"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatBans/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Removes a chat ban."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveChat/bans"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveChatBans/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :snippet {:banDurationSeconds string,
             :bannedUserDetails ChannelProfileDetails,
             :liveChatId string,
             :type string}}
  
  Adds a new ban to the chat."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveChat/bans"
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
