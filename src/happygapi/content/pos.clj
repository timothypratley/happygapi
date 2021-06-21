(ns happygapi.content.pos
  "Content API for Shopping: pos.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn sale$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/sale
  
  Required parameters: targetMerchantId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:saleId string,
   :contentLanguage string,
   :storeCode string,
   :gtin string,
   :quantity string,
   :targetCountry string,
   :timestamp string,
   :price {:value string, :currency string},
   :itemId string}
  
  Submit a sale event for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/sale"
     #{:targetMerchantId :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/list
  
  Required parameters: targetMerchantId, merchantId
  
  Optional parameters: none
  
  Lists the stores of the target merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/get
  
  Required parameters: targetMerchantId, merchantId, storeCode
  
  Optional parameters: none
  
  Retrieves information about the given store."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/insert
  
  Required parameters: targetMerchantId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :storeCode string, :storeAddress string}
  
  Creates a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
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

(defn inventory$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/inventory
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:timestamp string,
   :targetCountry string,
   :quantity string,
   :gtin string,
   :contentLanguage string,
   :storeCode string,
   :itemId string,
   :price {:value string, :currency string}}
  
  Submit inventory for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/inventory"
     #{:targetMerchantId :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:method string,
              :targetMerchantId string,
              :storeCode string,
              :merchantId string,
              :batchId integer,
              :store PosStore,
              :inventory PosInventory,
              :sale PosSale}]}
  
  Batches multiple POS-related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "pos/batch"
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/pos/delete
  
  Required parameters: storeCode, targetMerchantId, merchantId
  
  Optional parameters: none
  
  Deletes a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
