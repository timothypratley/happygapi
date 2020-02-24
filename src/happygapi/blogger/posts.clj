(ns happygapi.blogger.posts
  "Blogger API
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_started"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: blogId,postId
  
  Get a post by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{"postId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: blogId
  
  Add a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts"
     #{"blogId"}
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

(defn patch$
  "Required parameters: blogId,postId
  
  Update a post. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{"postId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: blogId,postId
  
  Update a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{"postId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: blogId,postId
  
  Delete a post by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{"postId" "blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "Required parameters: blogId,q
  
  Search for a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId" "q"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/search"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revert$
  "Required parameters: blogId,postId
  
  Revert a published or scheduled post to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/revert"
     #{"postId" "blogId"}
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
  "Required parameters: blogId
  
  Retrieves a list of posts, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn publish$
  "Required parameters: blogId,postId
  
  Publishes a draft post, optionally at the specific time of the given publishDate parameter."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"postId" "blogId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/publish"
     #{"postId" "blogId"}
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

(defn getByPath$
  "Required parameters: blogId,path
  
  Retrieve a Post by Path."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"blogId" "path"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/bypath"
     #{"blogId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
