(ns happygapi.cloudsearch.media
  "Cloud Search API
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudsearch_schema.edn"))))

(defn upload$
  "Required parameters: resourceName
  
  Optional parameters: none
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{"resourceName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/media/{+resourceName}"
     #{"resourceName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
