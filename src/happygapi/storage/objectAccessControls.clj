(ns happygapi.storage.objectAccessControls
  "Cloud Storage JSON API
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "storage_schema.edn"))))

(defn delete$
  "Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Permanently deletes the ACL entry for the specified entity on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket" "entity"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{"object" "bucket" "entity"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Returns the ACL entry for the specified entity on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket" "entity"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{"object" "bucket" "entity"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Creates a new ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl"
     #{"object" "bucket"}
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

(defn list$
  "Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Retrieves ACL entries on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl"
     #{"object" "bucket"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Patches an ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"object" "bucket" "entity"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{"object" "bucket" "entity"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: bucket, entity, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Updates an ACL entry on the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"object" "bucket" "entity"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/acl/{entity}"
     #{"object" "bucket" "entity"}
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
