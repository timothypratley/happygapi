(ns happygapi.content.collectionstatuses
  "Content API for Shopping: collectionstatuses.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/collectionstatuses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/collectionstatuses/get
  
  Required parameters: merchantId, collectionId
  
  Optional parameters: none
  
  Gets the status of a collection from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:collectionId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/collectionstatuses/{collectionId}"
     #{:collectionId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/collectionstatuses/list
  
  Required parameters: merchantId
  
  Optional parameters: pageToken, pageSize
  
  Lists the statuses of the collections in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/collectionstatuses"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
