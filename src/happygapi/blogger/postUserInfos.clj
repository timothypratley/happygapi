(ns happygapi.blogger.postUserInfos
  "Blogger API: postUserInfos.
  The Blogger API provides access to posts, comments and pages of a Blogger blog.
  See: https://developers.google.com/blogger/docs/3.0/getting_starteddocs/reference/rest/v3/postUserInfos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/postUserInfos/list
  
  Required parameters: blogId, userId
  
  Optional parameters: labels, startDate, pageToken, endDate, fetchBodies, status, maxResults, view, orderBy
  
  Lists post and user info pairs."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/users/{userId}/blogs/{blogId}/posts"
     #{:blogId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/postUserInfos/get
  
  Required parameters: postId, userId, blogId
  
  Optional parameters: maxComments
  
  Gets one post and user info pair, by post_id and user_id."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :postId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/users/{userId}/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
