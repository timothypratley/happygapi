(ns happygapi.storage.managedFolders
  "Cloud Storage JSON API: managedFolders.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/delete
  
  Required parameters: bucket, managedFolder
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, allowNonEmpty
  
  Permanently deletes a managed folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedFolder :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders/{managedFolder}"
     #{:managedFolder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/get
  
  Required parameters: bucket, managedFolder
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch
  
  Returns metadata of the specified managed folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedFolder :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders/{managedFolder}"
     #{:managedFolder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/getIamPolicy
  
  Required parameters: bucket, managedFolder
  
  Optional parameters: optionsRequestedPolicyVersion, userProject
  
  Returns an IAM policy for the specified managed folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:managedFolder :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders/{managedFolder}/iam"
     #{:managedFolder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/insert
  
  Required parameters: bucket
  
  Optional parameters: none
  
  Body: 
  
  {:bucket string,
   :id string,
   :kind string,
   :metageneration string,
   :name string,
   :selfLink string,
   :createTime string,
   :updateTime string}
  
  Creates a new managed folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders"
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/list
  
  Required parameters: bucket
  
  Optional parameters: pageSize, pageToken, prefix
  
  Lists managed folders in the given bucket."
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
     "b/{bucket}/managedFolders"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/setIamPolicy
  
  Required parameters: bucket, managedFolder
  
  Optional parameters: userProject
  
  Body: 
  
  {:bindings [{:condition {:description string,
                           :expression string,
                           :location string,
                           :title string},
               :members [string],
               :role string}],
   :etag string,
   :kind string,
   :resourceId string,
   :version integer}
  
  Updates an IAM policy for the specified managed folder."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:managedFolder :bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders/{managedFolder}/iam"
     #{:managedFolder :bucket}
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

(defn testIamPermissions$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/managedFolders/testIamPermissions
  
  Required parameters: bucket, managedFolder, permissions
  
  Optional parameters: userProject
  
  Tests a set of permissions on the given managed folder to see which, if any, are held by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:permissions :managedFolder :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/managedFolders/{managedFolder}/iam/testPermissions"
     #{:permissions :managedFolder :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
