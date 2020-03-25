(ns happygapi.storage.objectAccessControls
  "Cloud Storage JSON API: objectAccessControls.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/delete
  
  Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Permanently deletes the ACL entry for the specified entity on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:entity :object :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{:entity :object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/get
  
  Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Returns the ACL entry for the specified entity on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:entity :object :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{:entity :object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/insert
  
  Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}
  
  Creates a new ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl"
     #{:object :bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/list
  
  Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Retrieves ACL entries on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl"
     #{:object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/patch
  
  Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}
  
  Patches an ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entity :object :bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{:entity :object :bucket}
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

(defn update$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objectAccessControls/update
  
  Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Body: 
  
  {:role string,
   :email string,
   :generation string,
   :projectTeam {:projectNumber string, :team string},
   :selfLink string,
   :etag string,
   :id string,
   :kind string,
   :domain string,
   :entity string,
   :entityId string,
   :object string,
   :bucket string}
  
  Updates an ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entity :object :bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{:entity :object :bucket}
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
