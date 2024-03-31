(ns happygapi.kmsinventory.projects
  "KMS Inventory API: projects.
  
  See: https://cloud.google.com/kms/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cryptoKeys-list$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/cryptoKeys/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data is sourced from snapshots, meaning it may not completely reflect the actual state of key metadata at call time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kmsinventory.googleapis.com/"
     "v1/{+parent}/cryptoKeys"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-keyRings-cryptoKeys-getProtectedResourcesSummary$
  "https://cloud.google.com/kms/api/reference/rest/v1/projects/locations/keyRings/cryptoKeys/getProtectedResourcesSummary
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns aggregate information about the resources protected by the given Cloud KMS CryptoKey. Only resources within the same Cloud organization as the key will be returned. The project that holds the key must be part of an organization in order for this call to succeed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://kmsinventory.googleapis.com/"
     "v1/{+name}/protectedResourcesSummary"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
