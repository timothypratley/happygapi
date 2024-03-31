(ns happygapi.cloudsearch.operations
  "Cloud Search API: operations.
  Cloud Search provides cloud-based search capabilities over Google Workspace data. The Cloud Search API allows indexing of non-Google Workspace data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"
            "https://www.googleapis.com/auth/cloud_search.indexing"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
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

(defn lro-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/operations/lro/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.debug"
            "https://www.googleapis.com/auth/cloud_search.indexing"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/{+name}/lro"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
