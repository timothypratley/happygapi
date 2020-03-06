(ns happygapi.content.pos
  "Content API for Shopping: pos.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :inventory PosInventory,
              :merchantId string,
              :method string,
              :sale PosSale,
              :store PosStore,
              :storeCode string,
              :targetMerchantId string}]}
  
  Batches multiple POS-related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "pos/batch"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/delete
  
  Required parameters: merchantId, storeCode, targetMerchantId
  
  Optional parameters: none
  Deletes a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/get
  
  Required parameters: merchantId, storeCode, targetMerchantId
  
  Optional parameters: none
  Retrieves information about the given store."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:targetMerchantId :storeCode :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{:targetMerchantId :storeCode :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/insert
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :storeAddress string, :storeCode string}
  
  Creates a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn inventory$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/inventory
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:contentLanguage string,
   :gtin string,
   :itemId string,
   :price {:currency string, :value string},
   :quantity string,
   :storeCode string,
   :targetCountry string,
   :timestamp string}
  
  Submit inventory for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/inventory"
     #{:targetMerchantId :merchantId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/list
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  Lists the stores of the target merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{:targetMerchantId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sale$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/pos/sale
  
  Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Body: 
  
  {:saleId string,
   :contentLanguage string,
   :storeCode string,
   :gtin string,
   :quantity string,
   :targetCountry string,
   :timestamp string,
   :price {:currency string, :value string},
   :itemId string}
  
  Submit a sale event for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:targetMerchantId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/sale"
     #{:targetMerchantId :merchantId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
