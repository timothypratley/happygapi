(ns happygapi.content.localinventory
  "Content API for Shopping: localinventory.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/localinventory"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/localinventory/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :localInventory LocalInventory,
              :merchantId string,
              :method string,
              :productId string}]}
  
  Updates local inventory for multiple products or stores in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/localinventory/insert
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Body: 
  
  {:availability string,
   :pickupSla string,
   :salePrice {:currency string, :value string},
   :instoreProductLocation string,
   :pickupMethod string,
   :kind string,
   :storeCode string,
   :quantity integer,
   :price {:currency string, :value string},
   :salePriceEffectiveDate string}
  
  Update the local inventory of a product in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
