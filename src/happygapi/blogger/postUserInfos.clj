(ns happygapi.blogger.postUserInfos
  "Blogger API: postUserInfos.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/postUserInfos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/postUserInfos/get
  
  Required parameters: blogId, postId, userId
  
  Optional parameters: maxComments
  Gets one post and user info pair, by post ID and user ID. The post user info contains per-user information about the post, such as access rights, specific to the user."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs/{blogId}/posts/{postId}"
     #{:blogId :postId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/postUserInfos/list
  
  Required parameters: blogId, userId
  
  Optional parameters: labels, startDate, pageToken, endDate, fetchBodies, status, maxResults, view, orderBy
  Retrieves a list of post and post user info pairs, possibly filtered. The post user info contains per-user information about the post, such as access rights, specific to the user."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs/{blogId}/posts"
     #{:blogId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
