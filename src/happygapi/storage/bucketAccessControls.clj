(ns happygapi.storage.bucketAccessControls
  "Cloud Storage JSON API: bucketAccessControls.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/delete
  
  Required parameters: bucket, entity
  
  Optional parameters: provisionalUserProject, userProject
  Permanently deletes the ACL entry for the specified entity on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{:entity :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl/{entity}"
     #{:entity :bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/get
  
  Required parameters: bucket, entity
  
  Optional parameters: provisionalUserProject, userProject
  Returns the ACL entry for the specified entity on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{:entity :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl/{entity}"
     #{:entity :bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/insert
  
  Required parameters: bucket
  
  Optional parameters: provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}
  
  Creates a new ACL entry on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl"
     #{:bucket}
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

(defn list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/list
  
  Required parameters: bucket
  
  Optional parameters: provisionalUserProject, userProject
  Retrieves ACL entries on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl"
     #{:bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/patch
  
  Required parameters: bucket, entity
  
  Optional parameters: provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}
  
  Patches an ACL entry on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:entity :bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl/{entity}"
     #{:entity :bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/bucketAccessControls/update
  
  Required parameters: bucket, entity
  
  Optional parameters: provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :bucket string}
  
  Updates an ACL entry on the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:entity :bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/acl/{entity}"
     #{:entity :bucket}
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
