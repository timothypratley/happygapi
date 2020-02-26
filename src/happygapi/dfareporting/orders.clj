(ns happygapi.dfareporting.orders
  "DCM/DFA Reporting And Trafficking API
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "dfareporting_schema.edn"))))

(defn get$
  "Required parameters: id, profileId, projectId
  
  Optional parameters: none
  
  Gets one order by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"id" "projectId" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orders/{id}"
     #{"id" "projectId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: profileId, projectId
  
  Optional parameters: siteId, ids, searchString, pageToken, sortField, sortOrder, maxResults
  
  Retrieves a list of orders, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{"projectId" "profileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orders"
     #{"projectId" "profileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
