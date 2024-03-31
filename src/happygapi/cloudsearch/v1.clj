(ns happygapi.cloudsearch.v1
  "Cloud Search API: v1.
  Cloud Search provides cloud-based search capabilities over Google Workspace data. The Cloud Search API allows indexing of non-Google Workspace data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/initializeCustomer
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enables `third party` support in Google Cloud Search. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1:initializeCustomer"
     #{}
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
