(ns happygapi.cloudsearch.media
  "Cloud Search API: media.
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn upload$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/media/upload
  
  Required parameters: resourceName
  
  Optional parameters: none
  
  Body: 
  
  {:resourceName string}
  
  Uploads media for indexing.
  
  The upload endpoint supports direct and resumable upload protocols and
  is intended for large items that can not be
  [inlined during index requests](https://developers.google.com/cloud-search/docs/reference/rest/v1/indexing.datasources.items#itemcontent).
  To index large content:
  
  1. Call
     indexing.datasources.items.upload
     with the resource name to begin an upload session and retrieve the
     UploadItemRef.
  1. Call media.upload to upload the content using the same resource name from step 1.
  1. Call indexing.datasources.items.index
     to index the item. Populate the
     [ItemContent](/cloud-search/docs/reference/rest/v1/indexing.datasources.items#ItemContent)
     with the UploadItemRef from step 1.
  
  
  For additional information, see
  [Create a content connector using the REST API](https://developers.google.com/cloud-search/docs/guides/content-connector#rest).
  
    **Note:** This API requires a service account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/media/{+resourceName}"
     #{:resourceName}
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
