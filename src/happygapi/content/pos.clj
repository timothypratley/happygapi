(ns happygapi.content.pos
  "Content API for Shopping
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-content"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "content_schema.edn"))))

(defn custombatch$
  "Required parameters: none
  
  Optional parameters: none
  
  Batches multiple POS-related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "pos/batch"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn delete$
  "Required parameters: merchantId, storeCode, targetMerchantId
  
  Optional parameters: none
  
  Deletes a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"storeCode" "targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{"storeCode" "targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: merchantId, storeCode, targetMerchantId
  
  Optional parameters: none
  
  Retrieves information about the given store."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"storeCode" "targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store/{storeCode}"
     #{"storeCode" "targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Creates a store for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{"targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn inventory$
  "Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Submit inventory for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/inventory"
     #{"targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Lists the stores of the target merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/store"
     #{"targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn sale$
  "Required parameters: merchantId, targetMerchantId
  
  Optional parameters: none
  
  Submit a sale event for the given merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"targetMerchantId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/pos/{targetMerchantId}/sale"
     #{"targetMerchantId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
