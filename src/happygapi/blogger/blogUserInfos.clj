(ns happygapi.blogger.blogUserInfos
  "Blogger API
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: blogId,userId
  
  Gets one blog and user info pair by blogId and userId."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId" "userId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs/{blogId}"
     #{"blogId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
