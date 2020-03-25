(ns happygapi.youtube.commentThreads
  "YouTube Data API: commentThreads.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/commentThreads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/commentThreads/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :replies {:comments [Comment]},
   :snippet {:canReply boolean,
             :channelId string,
             :isPublic boolean,
             :topLevelComment Comment,
             :totalReplyCount integer,
             :videoId string}}
  
  Creates a new top-level comment. To add a reply to an existing comment, use the comments.insert method instead."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/commentThreads/list
  
  Required parameters: part
  
  Optional parameters: textFormat, channelId, allThreadsRelatedToChannelId, pageToken, id, videoId, order, searchTerms, moderationStatus, maxResults
  
  Returns a list of comment threads that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/commentThreads/update
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :replies {:comments [Comment]},
   :snippet {:canReply boolean,
             :channelId string,
             :isPublic boolean,
             :topLevelComment Comment,
             :totalReplyCount integer,
             :videoId string}}
  
  Modifies the top-level comment in a comment thread."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
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
