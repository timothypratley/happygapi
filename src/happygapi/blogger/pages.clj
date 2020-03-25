(ns happygapi.blogger.pages
  "Blogger API: pages.
  API for access to the data within Blogger.
  See: https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/delete
  
  Required parameters: blogId, pageId
  
  Optional parameters: none
  
  Delete a page by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/get
  
  Required parameters: blogId, pageId
  
  Optional parameters: view
  
  Gets one blog page by ID."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
     #{:blogId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
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
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :status string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Add a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages"
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

(defn list$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/list
  
  Required parameters: blogId
  
  Optional parameters: fetchBodies, maxResults, pageToken, status, view
  
  Retrieves the pages for a blog, optionally including non-LIVE statuses."
  {:scopes ["https://www.googleapis.com/auth/blogger"
            "https://www.googleapis.com/auth/blogger.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages"
     #{:blogId}
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
  
  Optional parameters: publish, revert
  
  Body: 
  
  {:content string,
   :updated string,
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :status string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Update a page. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
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

(defn publish$
  "https://developers.google.com/blogger/docs/3.0/getting_startedapi/reference/rest/v3/pages/publish
  
  Required parameters: blogId, pageId
  
  Optional parameters: none
  
  Publishes a draft page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}/publish"
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
  
  Required parameters: blogId, pageId
  
  Optional parameters: none
  
  Revert a published or scheduled page to draft state."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}/revert"
     #{:blogId :pageId}
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
  
  Required parameters: blogId, pageId
  
  Optional parameters: publish, revert
  
  Body: 
  
  {:content string,
   :updated string,
   :selfLink string,
   :etag string,
   :title string,
   :author {:displayName string,
            :id string,
            :image {:url string},
            :url string},
   :status string,
   :id string,
   :kind string,
   :url string,
   :blog {:id string},
   :published string}
  
  Update a page."
  {:scopes ["https://www.googleapis.com/auth/blogger"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:blogId :pageId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/blogger/v3/"
     "blogs/{blogId}/pages/{pageId}"
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
