(ns happygapi.youtube.liveBroadcasts
  "YouTube Data API: liveBroadcasts.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn bind$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/bind
  
  Required parameters: id, part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, streamId
  
  Binds a YouTube broadcast to a stream or removes an existing binding between a broadcast and a stream. A broadcast can only be bound to one video stream, though a video stream may be bound to more than one broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/bind"
     #{:part :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn control$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/control
  
  Required parameters: id, part
  
  Optional parameters: displaySlate, offsetTimeMs, onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, walltime
  
  Controls the settings for a slate that can be displayed in the broadcast stream."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/control"
     #{:part :id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/delete
  
  Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Deletes a broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/insert
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:contentDetails {:stereoLayout string,
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
   :etag string,
   :id string,
   :kind string,
   :snippet {:description string,
             :publishedAt string,
             :scheduledEndTime string,
             :broadcastType string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :isDefaultBroadcast boolean,
             :liveChatId string,
             :scheduledStartTime string,
             :actualEndTime string,
             :actualStartTime string},
   :statistics {:concurrentViewers string, :totalChatCount string},
   :status {:lifeCycleStatus string,
            :liveBroadcastPriority string,
            :madeForKids boolean,
            :privacyStatus string,
            :recordingStatus string,
            :selfDeclaredMadeForKids boolean}}
  
  Creates a broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/list
  
  Required parameters: part
  
  Optional parameters: broadcastType, onBehalfOfContentOwnerChannel, pageToken, mine, id, broadcastStatus, onBehalfOfContentOwner, maxResults
  
  Returns a list of YouTube broadcasts that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn transition$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/transition
  
  Required parameters: broadcastStatus, id, part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Changes the status of a YouTube live broadcast and initiates any processes associated with the new status. For example, when you transition a broadcast's status to testing, YouTube starts to transmit video to that broadcast's monitor stream. Before calling this method, you should confirm that the value of the status.streamStatus property for the stream bound to your broadcast is active."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part :id :broadcastStatus})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/transition"
     #{:part :id :broadcastStatus}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/liveBroadcasts/update
  
  Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Body: 
  
  {:contentDetails {:stereoLayout string,
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
   :etag string,
   :id string,
   :kind string,
   :snippet {:description string,
             :publishedAt string,
             :scheduledEndTime string,
             :broadcastType string,
             :channelId string,
             :thumbnails ThumbnailDetails,
             :title string,
             :isDefaultBroadcast boolean,
             :liveChatId string,
             :scheduledStartTime string,
             :actualEndTime string,
             :actualStartTime string},
   :statistics {:concurrentViewers string, :totalChatCount string},
   :status {:lifeCycleStatus string,
            :liveBroadcastPriority string,
            :madeForKids boolean,
            :privacyStatus string,
            :recordingStatus string,
            :selfDeclaredMadeForKids boolean}}
  
  Updates a broadcast. For example, you could modify the broadcast settings defined in the liveBroadcast resource's contentDetails object."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
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
