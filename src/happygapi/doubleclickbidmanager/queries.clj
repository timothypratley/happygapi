(ns happygapi.doubleclickbidmanager.queries
  "DoubleClick Bid Manager API
  API for viewing and managing your reports in DoubleClick Bid Manager.
  See: https://developers.google.com/bid-manager/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn createquery$
  "Required parameters: none
  
  Creates a query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query"
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

(defn deletequery$
  "Required parameters: queryId
  
  Deletes a stored query as well as the associated stored reports."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{"queryId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{"queryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getquery$
  "Required parameters: queryId
  
  Retrieves a stored query."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{"queryId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{"queryId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listqueries$
  "Required parameters: none
  
  Retrieves stored queries."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "queries"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn runquery$
  "Required parameters: queryId
  
  Runs a stored query to generate a report."
  {:scopes ["https://www.googleapis.com/auth/doubleclickbidmanager"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"queryId"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclickbidmanager/v1.1/"
     "query/{queryId}"
     #{"queryId"}
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
