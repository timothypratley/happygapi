(ns happygapi.storage.projects
  "Cloud Storage JSON API: projects.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn hmacKeys-create$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/hmacKeys/create
  
  Required parameters: projectId, serviceAccountEmail
  
  Optional parameters: userProject
  
  Creates a new HMAC key for the specified service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:serviceAccountEmail :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys"
     #{:serviceAccountEmail :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/hmacKeys/delete
  
  Required parameters: accessId, projectId
  
  Optional parameters: userProject
  
  Deletes an HMAC key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accessId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{:accessId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/hmacKeys/get
  
  Required parameters: accessId, projectId
  
  Optional parameters: userProject
  
  Retrieves an HMAC key's metadata"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accessId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{:accessId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/hmacKeys/list
  
  Required parameters: projectId
  
  Optional parameters: maxResults, pageToken, serviceAccountEmail, showDeletedKeys, userProject
  
  Retrieves a list of HMAC keys matching the criteria."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-update$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/hmacKeys/update
  
  Required parameters: accessId, projectId
  
  Optional parameters: userProject
  
  Body: 
  
  {:timeCreated string,
   :updated string,
   :selfLink string,
   :accessId string,
   :etag string,
   :state string,
   :serviceAccountEmail string,
   :id string,
   :kind string,
   :projectId string}
  
  Updates the state of an HMAC key. See the HMAC Key resource descriptor for valid states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accessId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{:accessId :projectId}
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

(defn serviceAccount-get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/projects/serviceAccount/get
  
  Required parameters: projectId
  
  Optional parameters: provisionalUserProject, userProject
  
  Get the email address of this project's Google Cloud Storage service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/serviceAccount"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
