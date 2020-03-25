(ns happygapi.content.orderreturns
  "Content API for Shopping: orderreturns.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreturns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreturns/get
  
  Required parameters: merchantId, returnId
  
  Optional parameters: none
  
  Retrieves an order return from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns/{returnId}"
     #{:returnId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreturns/list
  
  Required parameters: merchantId
  
  Optional parameters: createdEndDate, createdStartDate, maxResults, orderBy, pageToken
  
  Lists order returns in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreturns"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
