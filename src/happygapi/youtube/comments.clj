(ns happygapi.youtube.comments
  "YouTube Data API
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: id
  
  Deletes a comment."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
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
  
  Creates a reply to an existing comment. Note: To create a top-level comment, use the commentThreads.insert method."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: part
  
  Returns a list of comments that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "Required parameters: id
  
  Expresses the caller's opinion that one or more comments should be flagged as spam."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments/markAsSpam"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn setModerationStatus$
  "Required parameters: id,moderationStatus
  
  Sets the moderation status of one or more comments. The API request must be authorized by the owner of the channel or video associated with the comments."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"id" "moderationStatus"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments/setModerationStatus"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn update$
  "Required parameters: part
  
  Modifies a comment."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "comments"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
