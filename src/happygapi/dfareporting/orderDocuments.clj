(ns happygapi.dfareporting.orderDocuments
  "DCM/DFA Reporting And Trafficking API: orderDocuments.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orderDocuments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orderDocuments/get
  
  Required parameters: id, profileId, projectId
  
  Optional parameters: none
  Gets one order document by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orderDocuments/{id}"
     #{:id :profileId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/orderDocuments/list
  
  Required parameters: profileId, projectId
  
  Optional parameters: siteId, ids, approved, searchString, pageToken, sortField, sortOrder, maxResults, orderId
  Retrieves a list of order documents, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/projects/{projectId}/orderDocuments"
     #{:profileId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
