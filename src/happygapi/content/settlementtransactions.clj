(ns happygapi.content.settlementtransactions
  "Content API for Shopping: settlementtransactions.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/settlementtransactions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/settlementtransactions/list
  
  Required parameters: settlementId, merchantId
  
  Optional parameters: transactionIds, maxResults, pageToken
  
  Retrieves a list of transactions for the settlement."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:settlementId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/settlementreports/{settlementId}/transactions"
     #{:settlementId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
