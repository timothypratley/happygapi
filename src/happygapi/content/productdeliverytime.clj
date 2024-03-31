(ns happygapi.content.productdeliverytime
  "Content API for Shopping: productdeliverytime.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productdeliverytime"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productdeliverytime/create
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:productId {:productId string},
   :areaDeliveryTimes [{:deliveryArea DeliveryArea,
                        :deliveryTime ProductDeliveryTimeAreaDeliveryTimeDeliveryTime}]}
  
  Creates or updates the delivery time of a product."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productdeliverytime"
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

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productdeliverytime/get
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Gets `productDeliveryTime` by `productId`."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productdeliverytime/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/productdeliverytime/delete
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Deletes the delivery time of a product."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/productdeliverytime/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
