(ns happygapi.content.accounttax
  "Content API for Shopping: accounttax.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounttax"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounttax/update
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:rules [{:ratePercent string,
            :useGlobalRate boolean,
            :country string,
            :shippingTaxed boolean,
            :locationId string}],
   :accountId string,
   :kind string}
  
  Updates the tax settings of the account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounttax/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounttax/get
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Retrieves the tax settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounttax/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounttax/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the tax settings of the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounttax"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounttax/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:accountId string,
              :method string,
              :accountTax AccountTax,
              :batchId integer,
              :merchantId string}]}
  
  Retrieves and updates tax settings of multiple accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounttax/batch"
     #{}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
