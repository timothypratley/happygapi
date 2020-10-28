(ns happygapi.youtube.liveBroadcasts
  "YouTube Data API v3: liveBroadcasts.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Body: 
  
  {:status {:privacyStatus string,
            :lifeCycleStatus string,
            :liveBroadcastPriority string,
            :madeForKids boolean,
            :selfDeclaredMadeForKids boolean,
            :recordingStatus string},
   :etag string,
   :kind string,
   :statistics {:totalChatCount string},
   :contentDetails {:enableAutoStop boolean,
                    :enableContentEncryption boolean,
                    :enableLowLatency boolean,
                    :enableAutoStart boolean,
                    :latencyPreference string,
                    :enableDvr boolean,
                    :mesh string,
                    :boundStreamId string,
                    :enableClosedCaptions boolean,
                    :boundStreamLastUpdateTimeMs string,
                    :recordFromStart boolean,
                    :monitorStream MonitorStreamInfo,
                    :startWithSlate boolean,
                    :enableEmbed boolean,
                    :closedCaptionsType string,
                    :projection string},
   :id string,
   :snippet {:description string,
             :publishedAt string,
             :scheduledEndTime string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :isDefaultBroadcast boolean,
             :liveChatId string,
             :scheduledStartTime string,
             :actualEndTime string,
             :actualStartTime string}}
  
  Updates an existing broadcast for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts"
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

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Delete a given broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bind$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/bind
  
  Required parameters: id, part
  
  Optional parameters: onBehalfOfContentOwnerChannel, streamId, onBehalfOfContentOwner
  
  Bind a broadcast to a stream."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts/bind"
     #{:part :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:status {:privacyStatus string,
            :lifeCycleStatus string,
            :liveBroadcastPriority string,
            :madeForKids boolean,
            :selfDeclaredMadeForKids boolean,
            :recordingStatus string},
   :etag string,
   :kind string,
   :statistics {:totalChatCount string},
   :contentDetails {:enableAutoStop boolean,
                    :enableContentEncryption boolean,
                    :enableLowLatency boolean,
                    :enableAutoStart boolean,
                    :latencyPreference string,
                    :enableDvr boolean,
                    :mesh string,
                    :boundStreamId string,
                    :enableClosedCaptions boolean,
                    :boundStreamLastUpdateTimeMs string,
                    :recordFromStart boolean,
                    :monitorStream MonitorStreamInfo,
                    :startWithSlate boolean,
                    :enableEmbed boolean,
                    :closedCaptionsType string,
                    :projection string},
   :id string,
   :snippet {:description string,
             :publishedAt string,
             :scheduledEndTime string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :isDefaultBroadcast boolean,
             :liveChatId string,
             :scheduledStartTime string,
             :actualEndTime string,
             :actualStartTime string}}
  
  Inserts a new stream for the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts"
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

(defn transition$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/transition
  
  Required parameters: part, broadcastStatus, id
  
  Optional parameters: onBehalfOfContentOwnerChannel, onBehalfOfContentOwner
  
  Transition a broadcast to a given status."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id :broadcastStatus})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts/transition"
     #{:part :id :broadcastStatus}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn control$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/control
  
  Required parameters: part, id
  
  Optional parameters: onBehalfOfContentOwnerChannel, displaySlate, walltime, offsetTimeMs, onBehalfOfContentOwner
  
  Slate and recording control of the live broadcast. Support actions: slate on/off, recording start/stop/pause/resume. Design doc: goto/yt-api-liveBroadcast-control"
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts/control"
     #{:part :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/liveBroadcasts/list
  
  Required parameters: part
  
  Optional parameters: broadcastType, onBehalfOfContentOwnerChannel, pageToken, mine, id, broadcastStatus, onBehalfOfContentOwner, maxResults
  
  Retrieve the list of broadcasts associated with the given channel."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/liveBroadcasts"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
