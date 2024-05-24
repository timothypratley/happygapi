(ns happygapi.content.orderinvoices
  "Content API for Shopping: orderinvoices.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/orderinvoices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createchargeinvoice$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orderinvoices/createchargeinvoice
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:invoiceId string,
   :operationId string,
   :shipmentGroupId string,
   :lineItemInvoices [{:lineItemId string,
                       :productId string,
                       :shipmentUnitIds [string],
                       :unitInvoice UnitInvoice}],
   :invoiceSummary {:productTotal Amount,
                    :additionalChargeSummaries [InvoiceSummaryAdditionalChargeSummary]}}
  
  Creates a charge invoice for a shipment group, and triggers a charge capture for orderinvoice enabled orders."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createChargeInvoice"
     #{:merchantId :orderId}
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

(defn createrefundinvoice$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orderinvoices/createrefundinvoice
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:invoiceId string,
   :operationId string,
   :refundOnlyOption {:reason string, :description string},
   :shipmentInvoices [{:shipmentGroupId string,
                       :lineItemInvoices [ShipmentInvoiceLineItemInvoice],
                       :invoiceSummary InvoiceSummary}],
   :returnOption {:reason string, :description string}}
  
  Creates a refund invoice for one or more shipment groups, and triggers a refund for orderinvoice enabled orders. This can only be used for line items that have previously been charged using `createChargeInvoice`. All amounts (except for the summary) are incremental with respect to the previous invoice."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orderinvoices/{orderId}/createRefundInvoice"
     #{:merchantId :orderId}
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
