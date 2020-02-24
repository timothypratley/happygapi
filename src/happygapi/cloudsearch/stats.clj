(ns happygapi.cloudsearch.stats
  "Cloud Search API
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn getUser$
  "Required parameters: none
  
  Get the users statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIndex$
  "Required parameters: none
  
  Gets indexed item statistics aggreggated across all data sources. This
  API only returns statistics for previous dates; it doesn't return
  statistics for the current day.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getQuery$
  "Required parameters: none
  
  Get the query statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getSession$
  "Required parameters: none
  
  Get the # of search sessions, % of successful sessions with a click query
  statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn user-searchapplications-get$
  "Required parameters: name
  
  Get the users statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/user/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn query-searchapplications-get$
  "Required parameters: name
  
  Get the query statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/query/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn index-datasources-get$
  "Required parameters: name
  
  Gets indexed item statistics for a single data source.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/index/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn session-searchapplications-get$
  "Required parameters: name
  
  Get the # of search sessions, % of successful sessions with a click query
  statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/stats/session/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
