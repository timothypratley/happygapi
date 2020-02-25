(ns happygapi.cloudsearch.query
  "Cloud Search API
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudsearch_schema.edn"))))

(defn search$
  "Required parameters: none
  
  Optional parameters: none
  
  The Cloud Search Query API provides the search method, which returns
  the most relevant results from a user query.  The results can come from
  G Suite Apps, such as Gmail or Google Drive, or they can come from data
  that you have indexed from a third party.
  
  **Note:** This API requires a standard end user account to execute.
  A service account can't perform Query API requests directly; to use a
  service account to perform queries, set up [G Suite domain-wide delegation
  of
  authority](https://developers.google.com/cloud-search/docs/guides/delegation/)."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.query"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/search"
     #{}
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

(defn suggest$
  "Required parameters: none
  
  Optional parameters: none
  
  Provides suggestions for autocompleting the query.
  
  **Note:** This API requires a standard end user account to execute.
  A service account can't perform Query API requests directly; to use a
  service account to perform queries, set up [G Suite domain-wide delegation
  of
  authority](https://developers.google.com/cloud-search/docs/guides/delegation/)."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.query"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/suggest"
     #{}
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

(defn sources-list$
  "Required parameters: none
  
  Optional parameters: requestOptions.debugOptions.enableDebugging, requestOptions.languageCode, requestOptions.searchApplicationId, requestOptions.timeZone, pageToken
  
  Returns list of sources that user can use for Search and Suggest APIs.
  
  **Note:** This API requires a standard end user account to execute.
  A service account can't perform Query API requests directly; to use a
  service account to perform queries, set up [G Suite domain-wide delegation
  of
  authority](https://developers.google.com/cloud-search/docs/guides/delegation/)."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.query"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/sources"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
