(ns happygapi.content.localinventory
  "Content API for Shopping: localinventory.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/localinventory"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/localinventory/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :merchantId string,
              :method string,
              :productId string,
              :localInventory LocalInventory}]}
  
  Updates local inventory for multiple products or stores in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "localinventory/batch"
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

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/localinventory/insert
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Body: 
  
  {:availability string,
   :pickupSla string,
   :salePrice {:value string, :currency string},
   :instoreProductLocation string,
   :customAttributes [{:name string,
                       :value string,
                       :groupValues [CustomAttribute]}],
   :pickupMethod string,
   :kind string,
   :storeCode string,
   :quantity integer,
   :price {:value string, :currency string},
   :salePriceEffectiveDate string}
  
  Updates the local inventory of a product in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/products/{productId}/localinventory"
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
