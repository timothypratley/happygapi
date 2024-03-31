(ns happygapi.content.ordertrackingsignals
  "Content API for Shopping: ordertrackingsignals.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/ordertrackingsignals"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/ordertrackingsignals/create
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:deliveryPostalCode string,
   :shippingInfo [{:latestDeliveryPromiseTime DateTime,
                   :shippedTime DateTime,
                   :originPostalCode string,
                   :earliestDeliveryPromiseTime DateTime,
                   :carrierServiceName string,
                   :carrierName string,
                   :shippingStatus string,
                   :trackingId string,
                   :shipmentId string,
                   :originRegionCode string,
                   :actualDeliveryTime DateTime}],
   :orderCreatedTime {:timeZone TimeZone,
                      :day integer,
                      :nanos integer,
                      :month integer,
                      :seconds integer,
                      :year integer,
                      :utcOffset string,
                      :hours integer,
                      :minutes integer},
   :customerShippingFee {:value string, :currency string},
   :deliveryRegionCode string,
   :lineItems [{:mpn string,
                :productId string,
                :productDescription string,
                :brand string,
                :sku string,
                :lineItemId string,
                :upc string,
                :gtin string,
                :quantity string,
                :productTitle string}],
   :shipmentLineItemMapping [{:shipmentId string,
                              :lineItemId string,
                              :quantity string}],
   :orderTrackingSignalId string,
   :merchantId string,
   :orderId string}
  
  Creates new order tracking signal."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/ordertrackingsignals"
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
