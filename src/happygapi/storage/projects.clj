(ns happygapi.storage.projects
  "Cloud Storage JSON API
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn hmacKeys-create$
  "Required parameters: projectId,serviceAccountEmail
  
  Creates a new HMAC key for the specified service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"serviceAccountEmail" "projectId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn hmacKeys-delete$
  "Required parameters: accessId,projectId
  
  Deletes an HMAC key."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accessId" "projectId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{"accessId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-get$
  "Required parameters: accessId,projectId
  
  Retrieves an HMAC key's metadata"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accessId" "projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{"accessId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-list$
  "Required parameters: projectId
  
  Retrieves a list of HMAC keys matching the criteria."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn hmacKeys-update$
  "Required parameters: accessId,projectId
  
  Updates the state of an HMAC key. See the HMAC Key resource descriptor for valid states."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accessId" "projectId"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/hmacKeys/{accessId}"
     #{"accessId" "projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn serviceAccount-get$
  "Required parameters: projectId
  
  Get the email address of this project's Google Cloud Storage service account."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "projects/{projectId}/serviceAccount"
     #{"projectId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
