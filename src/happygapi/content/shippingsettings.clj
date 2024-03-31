(ns happygapi.content.shippingsettings
  "Content API for Shopping: shippingsettings.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :merchantId string,
              :method string,
              :accountId string,
              :shippingSettings ShippingSettings}]}
  
  Retrieves and updates the shipping settings of multiple accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "shippingsettings/batch"
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

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/get
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Retrieves the shipping settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedcarriers$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/getsupportedcarriers
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves supported carriers and carrier services for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/supportedCarriers"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedholidays$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/getsupportedholidays
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves supported holidays for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/supportedHolidays"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedpickupservices$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/getsupportedpickupservices
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves supported pickup services for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/supportedPickupServices"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the shipping settings of the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shippingsettings/update
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :services [{:storeConfig ServiceStoreConfig,
               :deliveryTime DeliveryTime,
               :deliveryCountry string,
               :minimumOrderValueTable MinimumOrderValueTable,
               :name string,
               :rateGroups [RateGroup],
               :eligibility string,
               :minimumOrderValue Price,
               :pickupService PickupCarrierService,
               :currency string,
               :active boolean,
               :shipmentType string}],
   :postalCodeGroups [{:name string,
                       :country string,
                       :postalCodeRanges [PostalCodeRange]}],
   :warehouses [{:name string,
                 :shippingAddress Address,
                 :cutoffTime WarehouseCutoffTime,
                 :handlingDays string,
                 :businessDayConfig BusinessDayConfig}]}
  
  Updates the shipping settings of the account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings/{accountId}"
     #{:accountId :merchantId}
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
