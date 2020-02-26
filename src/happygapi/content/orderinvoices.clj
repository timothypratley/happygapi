(ns happygapi.content.orderinvoices
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

(defn createchargeinvoice$
  "Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Creates a charge invoice for a shipment group, and triggers a charge capture for orderinvoice enabled orders."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"orderId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createChargeInvoice"
     #{"orderId" "merchantId"}
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

(defn createrefundinvoice$
  "Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Creates a refund invoice for one or more shipment groups, and triggers a refund for orderinvoice enabled orders. This can only be used for line items that have previously been charged using createChargeInvoice. All amounts (except for the summary) are incremental with respect to the previous invoice."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"orderId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createRefundInvoice"
     #{"orderId" "merchantId"}
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
