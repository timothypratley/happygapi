(ns happygapi.blogger.pages
  "Blogger API: pages.
  The Blogger API provides access to posts, comments and pages of a Blogger blog.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/get
  
  Required parameters: pageId, blogId
  
  Optional parameters: view
  
  Gets a page by blog id and page id."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/delete
  
  Required parameters: pageId, blogId
  
  Optional parameters: useTrash
  
  Deletes a page by blog id and page id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn revert$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/revert
  
  Required parameters: pageId, blogId
  
  Optional parameters: none
  
  Reverts a published or scheduled page to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}/revert"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/patch
  
  Required parameters: blogId, pageId
  
  Optional parameters: revert, publish
  
  Body: 
  
  {:content string,
   :updated string,
   :selfLink string,
   :etag string,
   :title string,
   :author {:url string,
            :image {:url string},
            :id string,
            :displayName string},
   :status string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Patches a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/insert
  
  Required parameters: blogId
  
  Optional parameters: isDraft
  
  Body: 
  
  {:content string,
   :updated string,
   :selfLink string,
   :etag string,
   :title string,
   :author {:url string,
            :image {:url string},
            :id string,
            :displayName string},
   :status string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Inserts a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages"
     #{:blogId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publish$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/publish
  
  Required parameters: pageId, blogId
  
  Optional parameters: none
  
  Publishes a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}/publish"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/list
  
  Required parameters: blogId
  
  Optional parameters: view, status, maxResults, pageToken, fetchBodies
  
  Lists pages."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages"
     #{:blogId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/update
  
  Required parameters: pageId, blogId
  
  Optional parameters: publish, revert
  
  Body: 
  
  {:content string,
   :updated string,
   :selfLink string,
   :etag string,
   :title string,
   :author {:url string,
            :image {:url string},
            :id string,
            :displayName string},
   :status string,
   :trashed string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Updates a page by blog id and page id."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://blogger.googleapis.com/"
     "v3/blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
