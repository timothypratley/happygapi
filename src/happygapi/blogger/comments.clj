(ns happygapi.blogger.comments
  "Blogger API: comments.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn approve$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/approve
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: none
  Marks a comment as not spam."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/approve"
     #{:blogId :postId :commentId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/delete
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: none
  Delete a comment by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :commentId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{:blogId :postId :commentId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/get
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: view
  Gets one comment by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :commentId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{:blogId :postId :commentId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/list
  
  Required parameters: blogId, postId
  
  Optional parameters: startDate, pageToken, endDate, fetchBodies, status, maxResults, view
  Retrieves the comments for a post, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listByBlog$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/listByBlog
  
  Required parameters: blogId
  
  Optional parameters: endDate, fetchBodies, maxResults, pageToken, startDate, status
  Retrieves the comments for a blog, across all posts, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/comments"
     #{:blogId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/markAsSpam
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: none
  Marks a comment as spam."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/spam"
     #{:blogId :postId :commentId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn removeContent$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/removeContent
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: none
  Removes the content of a comment."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/comments/{commentId}/removecontent"
     #{:blogId :postId :commentId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
