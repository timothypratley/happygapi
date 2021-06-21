(ns happygapi.artifactregistry.projects
  "Artifact Registry API: projects.
  Store and manage build artifacts in a scalable and integrated service built on Google infrastructure.
  See: https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-repositories-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists repositories."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/repositories"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-get$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a repository."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-repositories-dockerImages-list$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/projects/locations/repositories/dockerImages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists docker images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+parent}/dockerImages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
