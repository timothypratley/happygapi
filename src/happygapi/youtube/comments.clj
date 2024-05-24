(ns happygapi.youtube.comments
  "YouTube Data API v3: comments.
  The YouTube Data API v3 is an API that provides access to YouTube data, such as videos, playlists, and channels.
  See: https://developers.google.com/youtube/docs/reference/rest/v3/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/update
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :kind string,
   :snippet {:authorProfileImageUrl string,
             :likeCount integer,
             :publishedAt string,
             :canRate boolean,
             :viewerRating string,
             :updatedAt string,
             :authorChannelUrl string,
             :textOriginal string,
             :channelId string,
             :authorDisplayName string,
             :textDisplay string,
             :authorChannelId CommentSnippetAuthorChannelId,
             :videoId string,
             :parentId string,
             :moderationStatus string},
   :etag string}
  
  Updates an existing resource."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments"
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

(defn setModerationStatus$
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/setModerationStatus
  
  Required parameters: id, moderationStatus
  
  Optional parameters: banAuthor
  
  Sets the moderation status of one or more comments."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :moderationStatus})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments/setModerationStatus"
     #{:id :moderationStatus}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :kind string,
   :snippet {:authorProfileImageUrl string,
             :likeCount integer,
             :publishedAt string,
             :canRate boolean,
             :viewerRating string,
             :updatedAt string,
             :authorChannelUrl string,
             :textOriginal string,
             :channelId string,
             :authorDisplayName string,
             :textDisplay string,
             :authorChannelId CommentSnippetAuthorChannelId,
             :videoId string,
             :parentId string,
             :moderationStatus string},
   :etag string}
  
  Inserts a new resource into this collection."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments"
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
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/list
  
  Required parameters: part
  
  Optional parameters: maxResults, pageToken, parentId, textFormat, id
  
  Retrieves a list of resources, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments"
     #{:part}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/delete
  
  Required parameters: id
  
  Optional parameters: none
  
  Deletes a resource."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "https://developers.google.com/youtube/api/reference/rest/v3/comments/markAsSpam
  
  Required parameters: id
  
  Optional parameters: none
  
  Expresses the caller's opinion that one or more comments should be flagged as spam."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://youtube.googleapis.com/"
     "youtube/v3/comments/markAsSpam"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
