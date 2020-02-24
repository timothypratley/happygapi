(ns happygapi.blogger.comments
  "Blogger API
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn approve$
  "Required parameters: blogId,commentId,postId
  
  Marks a comment as not spam."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"postId" "blogId" "commentId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/approve"
     #{"postId" "blogId" "commentId"}
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

(defn delete$
  "Required parameters: blogId,commentId,postId
  
  Delete a comment by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId" "commentId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{"postId" "blogId" "commentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: blogId,commentId,postId
  
  Gets one comment by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId" "commentId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{"postId" "blogId" "commentId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: blogId,postId
  
  Retrieves the comments for a post, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments"
     #{"postId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listByBlog$
  "Required parameters: blogId
  
  Retrieves the comments for a blog, across all posts, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/comments"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "Required parameters: blogId,commentId,postId
  
  Marks a comment as spam."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"postId" "blogId" "commentId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/spam"
     #{"postId" "blogId" "commentId"}
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

(defn removeContent$
  "Required parameters: blogId,commentId,postId
  
  Removes the content of a comment."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"postId" "blogId" "commentId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/removecontent"
     #{"postId" "blogId" "commentId"}
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
