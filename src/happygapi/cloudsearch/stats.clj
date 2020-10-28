(ns happygapi.cloudsearch.stats
  "Cloud Search API: stats.
  Cloud Search provides cloud-based search capabilities over G Suite data. The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getIndex$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/getIndex
  
  Required parameters: none
  
  Optional parameters: toDate.day, toDate.month, fromDate.day, fromDate.year, fromDate.month, toDate.year
  
  Gets indexed item statistics aggreggated across all data sources. This API only returns statistics for previous dates; it doesn't return statistics for the current day. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getUser$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/getUser
  
  Required parameters: none
  
  Optional parameters: fromDate.month, toDate.year, toDate.month, fromDate.year, toDate.day, fromDate.day
  
  Get the users statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getQuery$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/getQuery
  
  Required parameters: none
  
  Optional parameters: fromDate.day, toDate.month, fromDate.month, fromDate.year, toDate.year, toDate.day
  
  Get the query statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getSession$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/getSession
  
  Required parameters: none
  
  Optional parameters: toDate.month, toDate.year, fromDate.day, fromDate.year, toDate.day, fromDate.month
  
  Get the # of search sessions, % of successful sessions with a click query statistics for customer. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn user-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/user/searchapplications/get
  
  Required parameters: name
  
  Optional parameters: fromDate.year, toDate.month, fromDate.month, toDate.year, fromDate.day, toDate.day
  
  Get the users statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn query-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/query/searchapplications/get
  
  Required parameters: name
  
  Optional parameters: toDate.month, toDate.day, fromDate.year, fromDate.day, toDate.year, fromDate.month
  
  Get the query statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn session-searchapplications-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/session/searchapplications/get
  
  Required parameters: name
  
  Optional parameters: toDate.day, fromDate.month, toDate.year, fromDate.year, fromDate.day, toDate.month
  
  Get the # of search sessions, % of successful sessions with a click query statistics for search application. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn index-datasources-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/stats/index/datasources/get
  
  Required parameters: name
  
  Optional parameters: toDate.month, fromDate.month, toDate.year, fromDate.year, fromDate.day, toDate.day
  
  Gets indexed item statistics for a single data source. **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
