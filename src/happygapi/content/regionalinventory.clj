(ns happygapi.content.regionalinventory
  "Content API for Shopping: regionalinventory.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regionalinventory"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regionalinventory/insert
  
  Required parameters: productId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:salePriceEffectiveDate string,
   :price {:value string, :currency string},
   :regionId string,
   :customAttributes [{:groupValues [CustomAttribute],
                       :value string,
                       :name string}],
   :kind string,
   :salePrice {:value string, :currency string},
   :availability string}
  
  Update the regional inventory of a product in your Merchant Center account. If a regional inventory with the same region ID already exists, this method updates that entry."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/products/{productId}/regionalinventory"
     #{:productId :merchantId}
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

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regionalinventory/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:merchantId string,
              :regionalInventory RegionalInventory,
              :productId string,
              :batchId integer,
              :method string}]}
  
  Updates regional inventory for multiple products or regions in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/regionalinventory/batch"
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
