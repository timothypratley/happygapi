(ns happygapi.blogger.posts
  "Blogger API: posts.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/get
  
  Required parameters: blogId, postId
  
  Optional parameters: fetchBody, fetchImages, maxComments, view
  Get a post by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/insert
  
  Required parameters: blogId
  
  Optional parameters: fetchBody, fetchImages, isDraft
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:displayName string,
                               :id string,
                               :image {:url string},
                               :url string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :selfLink string,
             :totalItems string},
   :status string,
   :customMetaData string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:lat number, :lng number, :name string, :span string},
   :blog {:id string},
   :published string}
  
  Add a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:blogId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts"
     #{:blogId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/patch
  
  Required parameters: blogId, postId
  
  Optional parameters: fetchBody, fetchImages, maxComments, publish, revert
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:displayName string,
                               :id string,
                               :image {:url string},
                               :url string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :selfLink string,
             :totalItems string},
   :status string,
   :customMetaData string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:lat number, :lng number, :name string, :span string},
   :blog {:id string},
   :published string}
  
  Update a post. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/update
  
  Required parameters: blogId, postId
  
  Optional parameters: fetchBody, fetchImages, maxComments, publish, revert
  
  Body: 
  
  {:labels [string],
   :titleLink string,
   :content string,
   :updated string,
   :images [{:url string}],
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :replies {:items [{:inReplyTo {:id string},
                      :content string,
                      :updated string,
                      :selfLink string,
                      :author {:displayName string,
                               :id string,
                               :image {:url string},
                               :url string},
                      :status string,
                      :id string,
                      :kind string,
                      :post {:id string},
                      :blog {:id string},
                      :published string}],
             :selfLink string,
             :totalItems string},
   :status string,
   :customMetaData string,
   :id string,
   :kind string,
   :url string,
   :readerComments string,
   :location {:lat number, :lng number, :name string, :span string},
   :blog {:id string},
   :published string}
  
  Update a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/delete
  
  Required parameters: blogId, postId
  
  Optional parameters: none
  Delete a post by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/search
  
  Required parameters: blogId, q
  
  Optional parameters: fetchBodies, orderBy
  Search for a post."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :q})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/search"
     #{:blogId :q}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn revert$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/revert
  
  Required parameters: blogId, postId
  
  Optional parameters: none
  Revert a published or scheduled post to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/revert"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/list
  
  Required parameters: blogId
  
  Optional parameters: labels, startDate, pageToken, endDate, fetchBodies, status, fetchImages, maxResults, view, orderBy
  Retrieves a list of posts, possibly filtered."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts"
     #{:blogId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn publish$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/publish
  
  Required parameters: blogId, postId
  
  Optional parameters: publishDate
  Publishes a draft post, optionally at the specific time of the given publishDate parameter."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :postId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/{postId}/publish"
     #{:blogId :postId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getByPath$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/posts/getByPath
  
  Required parameters: blogId, path
  
  Optional parameters: maxComments, view
  Retrieve a Post by Path."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:blogId :path})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/posts/bypath"
     #{:blogId :path}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
