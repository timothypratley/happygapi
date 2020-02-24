(ns happygapi.youtube.commentThreads
  "YouTube Data API
  Supports core YouTube features, such as uploading videos, creating and managing playlists, searching for content, and much more.
  See: https://developers.google.com/youtube/v3"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn insert$
  "Required parameters: part
  
  Creates a new top-level comment. To add a reply to an existing comment, use the comments.insert method instead."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
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
  
  Returns a list of comment threads that match the API request parameters."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: part
  
  Modifies the top-level comment in a comment thread."
  {:scopes ["https://www.googleapis.com/auth/youtube.force-ssl"]}
  [auth args]
  {:pre [(util/has-keys? args #{"part"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/youtube/v3/"
     "commentThreads"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
