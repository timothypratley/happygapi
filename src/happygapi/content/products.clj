(ns happygapi.content.products
  "Content API for Shopping: products.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/get
  
  Required parameters: merchantId, productId
  
  Optional parameters: none
  
  Retrieves a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/products/{productId}"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/insert
  
  Required parameters: merchantId
  
  Optional parameters: feedId
  
  Body: 
  
  {:description string,
   :productHighlights [string],
   :mpn string,
   :customLabel0 string,
   :transitTimeLabel string,
   :shippingWeight {:value number, :unit string},
   :availability string,
   :sizes [string],
   :shippingHeight {:unit string, :value number},
   :taxCategory string,
   :ageGroup string,
   :subscriptionCost {:amount Price,
                      :periodLength string,
                      :period string},
   :sizeSystem string,
   :customLabel3 string,
   :displayAdsTitle string,
   :color string,
   :salePrice {:value string, :currency string},
   :maxEnergyEfficiencyClass string,
   :taxes [{:taxShip boolean,
            :region string,
            :locationId string,
            :country string,
            :rate number,
            :postalCode string}],
   :displayAdsId string,
   :adsRedirect string,
   :productDetails [{:attributeValue string,
                     :sectionName string,
                     :attributeName string}],
   :additionalImageLinks [string],
   :energyEfficiencyClass string,
   :isBundle boolean,
   :maxHandlingTime string,
   :adsLabels [string],
   :customAttributes [{:groupValues [CustomAttribute],
                       :value string,
                       :name string}],
   :displayAdsLink string,
   :displayAdsValue number,
   :channel string,
   :contentLanguage string,
   :shippingWidth {:unit string, :value number},
   :mobileLink string,
   :shippingLabel string,
   :shippingLength {:unit string, :value number},
   :canonicalLink string,
   :sizeType string,
   :source string,
   :shoppingAdsExcludedCountries [string],
   :googleProductCategory string,
   :brand string,
   :title string,
   :unitPricingBaseMeasure {:value string, :unit string},
   :loyaltyPoints {:ratio number, :name string, :pointsValue string},
   :offerId string,
   :installment {:months string, :amount Price},
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
   :costOfGoodsSold {:value string, :currency string},
   :gtin string,
   :multipack string,
   :unitPricingMeasure {:unit string, :value number},
   :shipping [{:price Price,
               :region string,
               :postalCode string,
               :locationId string,
               :country string,
               :locationGroupName string,
               :service string}],
   :gender string,
   :targetCountry string,
   :minEnergyEfficiencyClass string,
   :promotionIds [string],
   :price {:value string, :currency string},
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
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/products"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the products in your Merchant Center account. The response might contain fewer items than specified by maxResults. Rely on nextPageToken to determine if there are more items to be requested."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/products"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/delete
  
  Required parameters: merchantId, productId
  
  Optional parameters: feedId
  
  Deletes a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/products/{productId}"
     #{:productId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:merchantId string,
              :product Product,
              :feedId string,
              :batchId integer,
              :method string,
              :productId string}]}
  
  Retrieves, inserts, and deletes multiple products in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/products/batch"
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
