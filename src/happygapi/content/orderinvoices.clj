(ns happygapi.content.orderinvoices
  "Content API for Shopping: orderinvoices.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderinvoices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createchargeinvoice$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderinvoices/createchargeinvoice
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:invoiceId string,
   :invoiceSummary {:additionalChargeSummaries [InvoiceSummaryAdditionalChargeSummary],
                    :productTotal Amount},
   :lineItemInvoices [{:lineItemId string,
                       :productId string,
                       :shipmentUnitIds [string],
                       :unitInvoice UnitInvoice}],
   :operationId string,
   :shipmentGroupId string}
  
  Creates a charge invoice for a shipment group, and triggers a charge capture for orderinvoice enabled orders."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createChargeInvoice"
     #{:merchantId :orderId}
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

(defn createrefundinvoice$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderinvoices/createrefundinvoice
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:invoiceId string,
   :operationId string,
   :refundOnlyOption {:description string, :reason string},
   :returnOption {:description string, :reason string},
   :shipmentInvoices [{:invoiceSummary InvoiceSummary,
                       :lineItemInvoices [ShipmentInvoiceLineItemInvoice],
                       :shipmentGroupId string}]}
  
  Creates a refund invoice for one or more shipment groups, and triggers a refund for orderinvoice enabled orders. This can only be used for line items that have previously been charged using createChargeInvoice. All amounts (except for the summary) are incremental with respect to the previous invoice."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createRefundInvoice"
     #{:merchantId :orderId}
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
