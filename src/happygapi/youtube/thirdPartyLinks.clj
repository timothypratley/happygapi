(ns happygapi.youtube.thirdPartyLinks
  "YouTube Data API v3: thirdPartyLinks.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/api/reference/rest/v3/thirdPartyLinks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/thirdPartyLinks/insert
  
  Required parameters: part
  
  Optional parameters: externalChannelId
  
  Body: 
  
  {:etag string,
   :snippet {:channelToStoreLink ChannelToStoreLinkDetails,
             :type string},
   :kind string,
   :status {:linkStatus string},
   :linkingToken string}
  
  Inserts a new resource into this collection."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/thirdPartyLinks/list
  
  Required parameters: part
  
  Optional parameters: externalChannelId, type, linkingToken
  
  Retrieves a list of resources, possibly filtered."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/thirdPartyLinks/update
  
  Required parameters: part
  
  Optional parameters: externalChannelId
  
  Body: 
  
  {:etag string,
   :snippet {:channelToStoreLink ChannelToStoreLinkDetails,
             :type string},
   :kind string,
   :status {:linkStatus string},
   :linkingToken string}
  
  Updates an existing resource."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/thirdPartyLinks/delete
  
  Required parameters: linkingToken, type
  
  Optional parameters: part, externalChannelId
  
  Deletes a resource."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:type :linkingToken})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/thirdPartyLinks"
     #{:type :linkingToken}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
