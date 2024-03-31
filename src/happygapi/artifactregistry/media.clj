(ns happygapi.artifactregistry.media
  "Artifact Registry API: media.
  Store and manage build artifacts in a scalable and integrated service built on Google infrastructure.
  See: https://cloud.google.com/artifacts/docs/api/reference/rest/v1/media"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn download$
  "https://cloud.google.com/artifacts/docs/api/reference/rest/v1/media/download
  
  Required parameters: name
  
  Optional parameters: none
  
  Download a file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://artifactregistry.googleapis.com/"
     "v1/{+name}:download"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
