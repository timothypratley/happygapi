(ns happygapi.cloudsearch.stats
  "Cloud Search API
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "cloudsearch_schema.edn"))))

(defn getQuery$
  "Required parameters: none
  
  Optional parameters: fromDate.year, toDate.day, toDate.month, toDate.year, fromDate.month, fromDate.day
  
  Get the query statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: toDate.year, fromDate.month, fromDate.day, fromDate.year, toDate.day, toDate.month
  
  Get the # of search sessions, % of successful sessions with a click query
  statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn getUser$
  "Required parameters: none
  
  Optional parameters: fromDate.year, toDate.day, toDate.month, toDate.year, fromDate.month, fromDate.day
  
  Get the users statistics for customer.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: fromDate.month, fromDate.day, fromDate.year, toDate.day, toDate.month, toDate.year
  
  Gets indexed item statistics aggreggated across all data sources. This
  API only returns statistics for previous dates; it doesn't return
  statistics for the current day.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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

(defn query-searchapplications-get$
  "Required parameters: name
  
  Optional parameters: toDate.day, toDate.month, toDate.year, fromDate.month, fromDate.day, fromDate.year
  
  Get the query statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: fromDate.month, fromDate.day, fromDate.year, toDate.day, toDate.month, toDate.year
  
  Gets indexed item statistics for a single data source.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
  
  Optional parameters: toDate.day, toDate.month, toDate.year, fromDate.month, fromDate.day, fromDate.year
  
  Get the # of search sessions, % of successful sessions with a click query
  statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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

(defn user-searchapplications-get$
  "Required parameters: name
  
  Optional parameters: fromDate.month, fromDate.day, fromDate.year, toDate.day, toDate.month, toDate.year
  
  Get the users statistics for search application.
  
  **Note:** This API requires a standard end user account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.stats"
            "https://www.googleapis.com/auth/cloud_search.stats.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})
         (json-schema/validate schemas args)]}
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
