(ns happygapi.content.shippingsettings
  "Content API for Shopping: shippingsettings.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:accountId string,
              :batchId integer,
              :merchantId string,
              :method string,
              :shippingSettings ShippingSettings}]}
  
  Retrieves and updates the shipping settings of multiple accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "shippingsettings/batch"
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

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/get
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  Retrieves the shipping settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings/{accountId}"
     #{:accountId :merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedcarriers$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/getsupportedcarriers
  
  Required parameters: merchantId
  
  Optional parameters: none
  Retrieves supported carriers and carrier services for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/supportedCarriers"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedholidays$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/getsupportedholidays
  
  Required parameters: merchantId
  
  Optional parameters: none
  Retrieves supported holidays for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/supportedHolidays"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getsupportedpickupservices$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/getsupportedpickupservices
  
  Required parameters: merchantId
  
  Optional parameters: none
  Retrieves supported pickup services for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/supportedPickupServices"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  Lists the shipping settings of the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings"
     #{:merchantId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/shippingsettings/update
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :postalCodeGroups [{:country string,
                       :name string,
                       :postalCodeRanges [PostalCodeRange]}],
   :services [{:deliveryTime DeliveryTime,
               :deliveryCountry string,
               :name string,
               :rateGroups [RateGroup],
               :eligibility string,
               :minimumOrderValue Price,
               :pickupService PickupCarrierService,
               :currency string,
               :active boolean,
               :shipmentType string}]}
  
  Updates the shipping settings of the account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/shippingsettings/{accountId}"
     #{:accountId :merchantId}
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
