(ns happygapi.content.productstatuses
  "Content API for Shopping: productstatuses.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productstatuses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productstatuses/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:includeAttributes boolean,
              :merchantId string,
              :method string,
              :productId string,
              :destinations [string],
              :batchId integer}]}
  
  Gets the statuses of multiple products in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "productstatuses/batch"
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productstatuses/list
  
  Required parameters: merchantId
  
  Optional parameters: destinations, maxResults, pageToken
  
  Lists the statuses of the products in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productstatuses"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productstatuses/get
  
  Required parameters: productId, merchantId
  
  Optional parameters: destinations
  
  Gets the status of a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productstatuses/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn repricingreports-list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productstatuses/repricingreports/list
  
  Required parameters: productId, merchantId
  
  Optional parameters: pageSize, ruleId, endDate, startDate, pageToken
  
  Lists the metrics report for a given Repricing product."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productstatuses/{productId}/repricingreports"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
