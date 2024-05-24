(ns happygapi.storage.folders
  "Cloud Storage JSON API: folders.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/docs/reference/rest/v1/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/folders/delete
  
  Required parameters: bucket, folder
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch
  
  Permanently deletes a folder. Only applicable to buckets with hierarchical namespace enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:folder :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/folders/{folder}"
     #{:folder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/folders/get
  
  Required parameters: bucket, folder
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch
  
  Returns metadata for the specified folder. Only applicable to buckets with hierarchical namespace enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:folder :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/folders/{folder}"
     #{:folder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/folders/insert
  
  Required parameters: bucket
  
  Optional parameters: recursive
  
  Body: 
  
  {:pendingRenameInfo {:operationId string},
   :name string,
   :createTime string,
   :selfLink string,
   :updateTime string,
   :id string,
   :kind string,
   :bucket string,
   :metageneration string}
  
  Creates a new folder. Only applicable to buckets with hierarchical namespace enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/folders"
     #{:bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/folders/list
  
  Required parameters: bucket
  
  Optional parameters: delimiter, endOffset, pageSize, pageToken, prefix, startOffset
  
  Retrieves a list of folders matching the criteria. Only applicable to buckets with hierarchical namespace enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/folders"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rename$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/folders/rename
  
  Required parameters: bucket, destinationFolder, sourceFolder
  
  Optional parameters: ifSourceMetagenerationMatch, ifSourceMetagenerationNotMatch
  
  Renames a source folder to a destination folder. Only applicable to buckets with hierarchical namespace enabled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:destinationFolder :sourceFolder :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/folders/{sourceFolder}/renameTo/folders/{destinationFolder}"
     #{:destinationFolder :sourceFolder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
