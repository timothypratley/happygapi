(ns happygapi.blogger.blogs
  "Blogger API: blogs.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogs/get
  
  Required parameters: blogId
  
  Optional parameters: maxPosts, view
  
  Gets one blog by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}"
     #{:blogId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getByUrl$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogs/getByUrl
  
  Required parameters: url
  
  Optional parameters: view
  
  Retrieve a Blog by URL."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:url})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/byurl"
     #{:url}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listByUser$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/blogs/listByUser
  
  Required parameters: userId
  
  Optional parameters: fetchUserInfo, role, status, view
  
  Retrieves a list of blogs, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "users/{userId}/blogs"
     #{:userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
