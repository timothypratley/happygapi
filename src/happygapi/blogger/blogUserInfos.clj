(ns happygapi.blogger.blogUserInfos
  "Blogger API: blogUserInfos.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogUserInfos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogUserInfos/get
  
  Required parameters: blogId, userId
  
  Optional parameters: maxPosts
  
  Gets one blog and user info pair by blogId and userId."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs/{blogId}"
     #{:blogId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
