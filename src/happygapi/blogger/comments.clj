(ns happygapi.blogger.comments
  "Blogger API: comments.
  The Blogger API provides access to posts, comments and pages of a Blogger blog.
  See: https://developers.google.com/blogger/docs/3.0/getting_starteddocs/reference/rest/v3/comments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/delete
  
  Required parameters: blogId, postId, commentId
  
  Optional parameters: none
  
  Deletes a comment by blog id, post id and comment id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :commentId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{:blogId :postId :commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeContent$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/removeContent
  
  Required parameters: blogId, commentId, postId
  
  Optional parameters: none
  
  Removes the content of a comment by blog id, post id and comment id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/removecontent"
     #{:blogId :postId :commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn markAsSpam$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/markAsSpam
  
  Required parameters: commentId, postId, blogId
  
  Optional parameters: none
  
  Marks a comment as spam by blog id, post id and comment id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/spam"
     #{:blogId :postId :commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listByBlog$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/listByBlog
  
  Required parameters: blogId
  
  Optional parameters: status, startDate, endDate, maxResults, fetchBodies, pageToken
  
  Lists comments by blog."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/comments"
     #{:blogId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn approve$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/approve
  
  Required parameters: commentId, postId, blogId
  
  Optional parameters: none
  
  Marks a comment as not spam by blog id, post id and comment id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :commentId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments/{commentId}/approve"
     #{:blogId :postId :commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/list
  
  Required parameters: blogId, postId
  
  Optional parameters: startDate, pageToken, endDate, fetchBodies, status, maxResults, view
  
  Lists comments."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments"
     #{:blogId :postId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/comments/get
  
  Required parameters: postId, blogId, commentId
  
  Optional parameters: view
  
  Gets a comment by id."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :commentId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/posts/{postId}/comments/{commentId}"
     #{:blogId :postId :commentId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
