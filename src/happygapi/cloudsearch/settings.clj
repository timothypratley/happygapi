(ns happygapi.cloudsearch.settings
  "Cloud Search API: settings.
  Cloud Search provides cloud-based search capabilities over G Suite data. The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn datasources-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/datasources/get
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  
  Gets a datasource. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-delete$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/datasources/delete
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  
  Deletes a datasource. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/datasources/list
  
  Required parameters: none
  
  Optional parameters: debugOptions.enableDebugging, pageSize, pageToken
  
  Lists datasources. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/datasources"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-update$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/datasources/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:source {:operationIds [string],
            :displayName string,
            :shortName string,
            :disableServing boolean,
            :disableModifications boolean,
            :indexingServiceAccounts [string],
            :name string,
            :itemsVisibility [GSuitePrincipal]},
   :debugOptions {:enableDebugging boolean}}
  
  Updates a datasource. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
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

(defn datasources-create$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/datasources/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:operationIds [string],
   :displayName string,
   :shortName string,
   :disableServing boolean,
   :disableModifications boolean,
   :indexingServiceAccounts [string],
   :name string,
   :itemsVisibility [{:gsuiteUserEmail string,
                      :gsuiteGroupEmail string,
                      :gsuiteDomain boolean}]}
  
  Creates a datasource. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/datasources"
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

(defn searchapplications-create$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :dataSourceRestrictions [{:filterOptions [FilterOptions],
                             :source Source}],
   :sourceConfig [{:scoringConfig SourceScoringConfig,
                   :crowdingConfig SourceCrowdingConfig,
                   :source Source}],
   :defaultSortOptions {:sortOrder string, :operatorName string},
   :defaultFacetOptions [{:sourceName string,
                          :numFacetBuckets integer,
                          :objectType string,
                          :operatorName string}],
   :operationIds [string],
   :scoringConfig {:disableFreshness boolean,
                   :disablePersonalization boolean}}
  
  Creates a search application. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/searchapplications"
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

(defn searchapplications-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/get
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  
  Gets the specified search application. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchapplications-update$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :dataSourceRestrictions [{:filterOptions [FilterOptions],
                             :source Source}],
   :sourceConfig [{:scoringConfig SourceScoringConfig,
                   :crowdingConfig SourceCrowdingConfig,
                   :source Source}],
   :defaultSortOptions {:sortOrder string, :operatorName string},
   :defaultFacetOptions [{:sourceName string,
                          :numFacetBuckets integer,
                          :objectType string,
                          :operatorName string}],
   :operationIds [string],
   :scoringConfig {:disableFreshness boolean,
                   :disablePersonalization boolean}}
  
  Updates a search application. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
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

(defn searchapplications-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/list
  
  Required parameters: none
  
  Optional parameters: pageSize, debugOptions.enableDebugging, pageToken
  
  Lists all search applications. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/searchapplications"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchapplications-delete$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/delete
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  
  Deletes a search application. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchapplications-reset$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/settings/searchapplications/reset
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:debugOptions {:enableDebugging boolean}}
  
  Resets a search application to default settings. This will return an empty response. **Note:** This API requires an admin account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.query"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/settings/{+name}:reset"
     #{:name}
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
