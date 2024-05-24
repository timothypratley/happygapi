(ns happygapi.content.orders
  "Content API for Shopping: orders.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/orders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn refundorder$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/refundorder
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :reason string,
   :reasonText string,
   :fullRefund boolean,
   :amount {:priceAmount Price, :taxAmount Price}}
  
  Issues a partial or total refund for an order."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/refundorder"
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

(defn createtestorder$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/createtestorder
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:testOrder {:promotions [OrderPromotion],
               :predefinedPickupDetails string,
               :shippingOption string,
               :pickupDetails TestOrderPickupDetails,
               :enableOrderinvoices boolean,
               :predefinedBillingAddress string,
               :lineItems [TestOrderLineItem],
               :deliveryDetails TestOrderDeliveryDetails,
               :shippingCost Price,
               :kind string,
               :predefinedDeliveryAddress string,
               :predefinedEmail string,
               :notificationMode string},
   :templateName string,
   :country string}
  
  Sandbox only. Creates a test order."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/testorders"
     #{:merchantId}
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

(defn updatelineitemshippingdetails$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/updatelineitemshippingdetails
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :productId string,
   :shipByDate string,
   :deliverByDate string}
  
  Updates ship by and delivery by dates for a line item."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/updateLineItemShippingDetails"
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

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/get
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Retrieves an order from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}"
     #{:merchantId :orderId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn acknowledge$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/acknowledge
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string}
  
  Marks an order as acknowledged."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/acknowledge"
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

(defn setlineitemmetadata$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/setlineitemmetadata
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :productId string,
   :annotations [{:key string, :value string}]}
  
  Sets (or overrides if it already exists) merchant provided annotations in the form of key-value pairs. A common use case would be to supply us with additional structured information about a line item that cannot be provided through other methods. Submitted key-value pairs can be retrieved as part of the orders resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/setLineItemMetadata"
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

(defn createtestreturn$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/createtestreturn
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:items [{:lineItemId string, :quantity integer}]}
  
  Sandbox only. Creates a test return."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/testreturn"
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

(defn cancellineitem$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/cancellineitem
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :quantity integer,
   :reason string,
   :reasonText string,
   :productId string}
  
  Cancels a line item, making a full refund."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/cancelLineItem"
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

(defn updateshipment$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/updateshipment
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:readyPickupDate string,
   :undeliveredDate string,
   :carrier string,
   :trackingId string,
   :lastPickupDate string,
   :shipmentId string,
   :status string,
   :operationId string,
   :deliveryDate string,
   :scheduledDeliveryDetails {:scheduledDate string,
                              :carrierPhoneNumber string}}
  
  Updates a shipment's status, carrier, and/or tracking ID."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/updateShipment"
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

(defn rejectreturnlineitem$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/rejectreturnlineitem
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :productId string,
   :quantity integer,
   :reason string,
   :reasonText string}
  
  Rejects return on an line item."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/rejectReturnLineItem"
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

(defn instorerefundlineitem$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/instorerefundlineitem
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :productId string,
   :quantity integer,
   :reason string,
   :reasonText string,
   :priceAmount {:value string, :currency string},
   :taxAmount {:value string, :currency string}}
  
  Deprecated. Notifies that item return and refund was handled directly by merchant outside of Google payments processing (for example, cash refund done in store). Note: We recommend calling the returnrefundlineitem method to refund in-store returns. We will issue the refund directly to the customer. This helps to prevent possible differences arising between merchant and Google transaction records. We also recommend having the point of sale system communicate with Google to ensure that customers do not receive a double refund by first refunding through Google then through an in-store return."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/inStoreRefundLineItem"
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken, statuses, placedDateStart, placedDateEnd, orderBy, acknowledged
  
  Lists the orders in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn shiplineitems$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/shiplineitems
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItems [{:lineItemId string,
                :quantity integer,
                :productId string}],
   :shipmentInfos [{:shipmentId string,
                    :carrier string,
                    :trackingId string}],
   :shipmentGroupId string}
  
  Marks line item(s) as shipped."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/shipLineItems"
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

(defn captureOrder$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/captureOrder
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Capture funds from the customer for the current order total. This method should be called after the merchant verifies that they are able and ready to start shipping the order. This method blocks until a response is received from the payment processsor. If this method succeeds, the merchant is guaranteed to receive funds for the order after shipment. If the request fails, it can be retried or the order may be cancelled. This method cannot be called after the entire order is already shipped. A rejected error code is returned when the payment service provider has declined the charge. This indicates a problem between the PSP and either the merchant's or customer's account. Sometimes this error will be resolved by the customer. We recommend retrying these errors once per day or cancelling the order with reason `failedToCaptureFunds` if the items cannot be held."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/captureOrder"
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

(defn gettestordertemplate$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/gettestordertemplate
  
  Required parameters: merchantId, templateName
  
  Optional parameters: country
  
  Sandbox only. Retrieves an order template that can be used to quickly create a new order in sandbox."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:templateName :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/testordertemplates/{templateName}"
     #{:templateName :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getbymerchantorderid$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/getbymerchantorderid
  
  Required parameters: merchantId, merchantOrderId
  
  Optional parameters: none
  
  Retrieves an order using merchant order ID."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantOrderId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/ordersbymerchantid/{merchantOrderId}"
     #{:merchantOrderId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn cancel$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/cancel
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string, :reason string, :reasonText string}
  
  Cancels all line items in an order, making a full refund."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/cancel"
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

(defn advancetestorder$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/advancetestorder
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Sandbox only. Moves a test order from state \"`inProgress`\" to state \"`pendingShipment`\"."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/testorders/{orderId}/advance"
     #{:merchantId :orderId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn refunditem$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/refunditem
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :reason string,
   :reasonText string,
   :items [{:lineItemId string,
            :productId string,
            :quantity integer,
            :fullRefund boolean,
            :amount MonetaryAmount}],
   :shipping {:fullRefund boolean, :amount Price}}
  
  Issues a partial or total refund for items and shipment."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/refunditem"
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

(defn returnrefundlineitem$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/returnrefundlineitem
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string,
   :lineItemId string,
   :productId string,
   :quantity integer,
   :reason string,
   :reasonText string,
   :priceAmount {:value string, :currency string},
   :taxAmount {:value string, :currency string}}
  
  Returns and refunds a line item. Note that this method can only be called on fully shipped orders. The Orderreturns API is the preferred way to handle returns after you receive a return from a customer. You can use Orderreturns.list or Orderreturns.get to search for the return, and then use Orderreturns.processreturn to issue the refund. If the return cannot be found, then we recommend using this API to issue a refund."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/returnRefundLineItem"
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

(defn canceltestorderbycustomer$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/canceltestorderbycustomer
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:reason string}
  
  Sandbox only. Cancels a test order for customer-initiated cancellation."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/testorders/{orderId}/cancelByCustomer"
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

(defn updatemerchantorderid$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/orders/updatemerchantorderid
  
  Required parameters: merchantId, orderId
  
  Optional parameters: none
  
  Body: 
  
  {:operationId string, :merchantOrderId string}
  
  Updates the merchant order ID for a given order."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId :orderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/orders/{orderId}/updateMerchantOrderId"
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
