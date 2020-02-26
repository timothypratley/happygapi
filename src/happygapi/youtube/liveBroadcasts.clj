(ns happygapi.youtube.liveBroadcasts
  "YouTube Data API
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "youtube_schema.edn"))))

(defn bind$
  "Required parameters: id, part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, streamId
  
  Binds a YouTube broadcast to a stream or removes an existing binding between a broadcast and a stream. A broadcast can only be bound to one video stream, though a video stream may be bound to more than one broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/bind"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn control$
  "Required parameters: id, part
  
  Optional parameters: displaySlate, offsetTimeMs, onBehalfOfContentOwner, onBehalfOfContentOwnerChannel, walltime
  
  Controls the settings for a slate that can be displayed in the broadcast stream."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/control"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn delete$
  "Required parameters: id
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Deletes a broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Creates a broadcast."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: part
  
  Optional parameters: broadcastType, onBehalfOfContentOwnerChannel, pageToken, mine, id, broadcastStatus, onBehalfOfContentOwner, maxResults
  
  Returns a list of YouTube broadcasts that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"
            "https://www.googleapis.com/auth/youtube.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn transition$
  "Required parameters: broadcastStatus, id, part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Changes the status of a YouTube live broadcast and initiates any processes associated with the new status. For example, when you transition a broadcast's status to testing, YouTube starts to transmit video to that broadcast's monitor stream. Before calling this method, you should confirm that the value of the status.streamStatus property for the stream bound to your broadcast is active."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part" "broadcastStatus" "id"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts/transition"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn update$
  "Required parameters: part
  
  Optional parameters: onBehalfOfContentOwner, onBehalfOfContentOwnerChannel
  
  Updates a broadcast. For example, you could modify the broadcast settings defined in the liveBroadcast resource's contentDetails object."
  {:scopes ["https://www.googleapis.com/auth/youtube"
            "https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "liveBroadcasts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
