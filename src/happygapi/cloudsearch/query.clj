(ns happygapi.cloudsearch.query
  "Cloud Search API: query.
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/query"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/query/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requestOptions {:languageCode string,
                    :timeZone string,
                    :debugOptions DebugOptions,
                    :searchApplicationId string},
   :dataSourceRestrictions [{:filterOptions [FilterOptions],
                             :source Source}],
   :facetOptions [{:operatorName string,
                   :objectType string,
                   :sourceName string,
                   :numFacetBuckets integer}],
   :sortOptions {:operatorName string, :sortOrder string},
   :pageSize integer,
   :query string,
   :start integer,
   :queryInterpretationOptions {:enableVerbatimMode boolean,
                                :disableNlInterpretation boolean}}
  
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/search"
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

(defn suggest$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/query/suggest
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requestOptions {:languageCode string,
                    :timeZone string,
                    :debugOptions DebugOptions,
                    :searchApplicationId string},
   :query string,
   :dataSourceRestrictions [{:filterOptions [FilterOptions],
                             :source Source}]}
  
  Provides suggestions for autocompleting the query.
  
  **Note:** This API requires a standard end user account to execute.
  A service account can't perform Query API requests directly; to use a
  service account to perform queries, set up [G Suite domain-wide delegation
  of
  authority](https://developers.google.com/cloud-search/docs/guides/delegation/)."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.query"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/suggest"
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

(defn sources-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/query/sources/list
  
  Required parameters: none
  
  Optional parameters: requestOptions.searchApplicationId, requestOptions.timeZone, pageToken, requestOptions.debugOptions.enableDebugging, requestOptions.languageCode
  
  Returns list of sources that user can use for Search and Suggest APIs.
  
  **Note:** This API requires a standard end user account to execute.
  A service account can't perform Query API requests directly; to use a
  service account to perform queries, set up [G Suite domain-wide delegation
  of
  authority](https://developers.google.com/cloud-search/docs/guides/delegation/)."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/query/sources"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
