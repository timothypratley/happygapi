(ns happygapi.youtube.comments
  "YouTube Data API: comments.
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3api/reference/rest/v3/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/delete
  
  Required parameters: id
  
  Optional parameters: none
  Deletes a comment."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/insert
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
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
             :authorChannelId any,
             :videoId string,
             :parentId string,
             :moderationStatus string}}
  
  Creates a reply to an existing comment. Note: To create a top-level comment, use the commentThreads.insert method."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
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
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/list
  
  Required parameters: part
  
  Optional parameters: id, maxResults, pageToken, parentId, textFormat
  Returns a list of comments that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
     #{:part}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/markAsSpam
  
  Required parameters: id
  
  Optional parameters: none
  Expresses the caller's opinion that one or more comments should be flagged as spam."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments/markAsSpam"
     #{:id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setModerationStatus$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/setModerationStatus
  
  Required parameters: id, moderationStatus
  
  Optional parameters: banAuthor
  Sets the moderation status of one or more comments. The API request must be authorized by the owner of the channel or video associated with the comments."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :moderationStatus})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments/setModerationStatus"
     #{:id :moderationStatus}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/youtube/v3api/reference/rest/v3/comments/update
  
  Required parameters: part
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
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
             :authorChannelId any,
             :videoId string,
             :parentId string,
             :moderationStatus string}}
  
  Modifies a comment."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:part})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
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
