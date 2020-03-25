(ns happygapi.content.products
  "Content API for Shopping: products.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :feedId string,
              :merchantId string,
              :method string,
              :product Product,
              :productId string}]}
  
  Retrieves, inserts, and deletes multiple products in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "products/batch"
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

(defn delete$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products/delete
  
  Required parameters: merchantId, productId
  
  Optional parameters: feedId
  
  Deletes a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/products/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products/get
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Retrieves a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/products/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products/insert
  
  Required parameters: merchantId
  
  Optional parameters: feedId
  
  Body: 
  
  {:description string,
   :mpn string,
   :customLabel0 string,
   :transitTimeLabel string,
   :shippingWeight {:unit string, :value number},
   :availability string,
   :sizes [string],
   :shippingHeight {:unit string, :value number},
   :taxCategory string,
   :ageGroup string,
   :sizeSystem string,
   :customLabel3 string,
   :displayAdsTitle string,
   :color string,
   :salePrice {:currency string, :value string},
   :maxEnergyEfficiencyClass string,
   :taxes [{:country string,
            :locationId string,
            :postalCode string,
            :rate number,
            :region string,
            :taxShip boolean}],
   :displayAdsId string,
   :adsRedirect string,
   :additionalImageLinks [string],
   :energyEfficiencyClass string,
   :isBundle boolean,
   :maxHandlingTime string,
   :adsLabels [string],
   :customAttributes [{:groupValues [CustomAttribute],
                       :name string,
                       :value string}],
   :displayAdsLink string,
   :displayAdsValue number,
   :channel string,
   :contentLanguage string,
   :shippingWidth {:unit string, :value number},
   :mobileLink string,
   :shippingLabel string,
   :shippingLength {:unit string, :value number},
   :sizeType string,
   :source string,
   :googleProductCategory string,
   :brand string,
   :title string,
   :unitPricingBaseMeasure {:unit string, :value string},
   :loyaltyPoints {:name string, :pointsValue string, :ratio number},
   :offerId string,
   :installment {:amount Price, :months string},
   :identifierExists boolean,
   :excludedDestinations [string],
   :adult boolean,
   :itemGroupId string,
   :customLabel2 string,
   :link string,
   :id string,
   :condition string,
   :kind string,
   :material string,
   :customLabel4 string,
   :displayAdsSimilarIds [string],
   :customLabel1 string,
   :sellOnGoogleQuantity string,
   :availabilityDate string,
   :minHandlingTime string,
   :costOfGoodsSold {:currency string, :value string},
   :gtin string,
   :multipack string,
   :unitPricingMeasure {:unit string, :value number},
   :shipping [{:country string,
               :locationGroupName string,
               :locationId string,
               :postalCode string,
               :price Price,
               :region string,
               :service string}],
   :gender string,
   :targetCountry string,
   :minEnergyEfficiencyClass string,
   :promotionIds [string],
   :price {:currency string, :value string},
   :adsGrouping string,
   :imageLink string,
   :expirationDate string,
   :pattern string,
   :includedDestinations [string],
   :productTypes [string],
   :salePriceEffectiveDate string}
  
  Uploads a product to your Merchant Center account. If an item with the same channel, contentLanguage, offerId, and targetCountry already exists, this method updates that entry."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/products"
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

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/products/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the products in your Merchant Center account. The response might contain fewer items than specified by maxResults. Rely on nextPageToken to determine if there are more items to be requested."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/products"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
