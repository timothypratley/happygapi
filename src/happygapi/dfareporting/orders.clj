(ns happygapi.dfareporting.orders
  "DCM/DFA Reporting And Trafficking API: orders.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orders/get
  
  Required parameters: id, profileId, projectId
  
  Optional parameters: none
  
  Gets one order by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orders/{id}"
     #{:id :profileId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orders/list
  
  Required parameters: profileId, projectId
  
  Optional parameters: siteId, ids, searchString, pageToken, sortField, sortOrder, maxResults
  
  Retrieves a list of orders, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orders"
     #{:profileId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
