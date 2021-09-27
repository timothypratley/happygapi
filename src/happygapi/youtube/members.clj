(ns happygapi.youtube.members
  "YouTube Data API v3: members.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/members"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/youtube/api/reference/rest/v3/members/list
  
  Required parameters: part
  
  Optional parameters: maxResults, mode, pageToken, filterByMemberChannelId, hasAccessToLevel
  
  Retrieves a list of members that match the request criteria for a channel."
  {:scopes ["https://www.googleapis.com/auth/youtube.channel-memberships.creator"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/members"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
