(ns happygapi.content.products
  "Content API for Shopping: products.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/products"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :merchantId string,
              :method string,
              :productId string,
              :product Product,
              :feedId string,
              :updateMask string}]}
  
  Retrieves, inserts, and deletes multiple products in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
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
     "https://shoppingcontent.googleapis.com/content/v2.1/"
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
     "https://shoppingcontent.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/insert
  
  Required parameters: merchantId
  
  Optional parameters: feedId
  
  Body: 
  
  {:description string,
   :linkTemplate string,
   :productHighlights [string],
   :mpn string,
   :customLabel0 string,
   :transitTimeLabel string,
   :shippingWeight {:value number, :unit string},
   :availability string,
   :sizes [string],
   :shippingHeight {:value number, :unit string},
   :taxCategory string,
   :ageGroup string,
   :subscriptionCost {:period string,
                      :periodLength string,
                      :amount Price},
   :productWeight {:value number, :unit string},
   :sizeSystem string,
   :customLabel3 string,
   :displayAdsTitle string,
   :color string,
   :pickupSla string,
   :salePrice {:value string, :currency string},
   :maxEnergyEfficiencyClass string,
   :taxes [{:rate number,
            :country string,
            :region string,
            :taxShip boolean,
            :locationId string,
            :postalCode string}],
   :displayAdsId string,
   :adsRedirect string,
   :productDetails [{:sectionName string,
                     :attributeName string,
                     :attributeValue string}],
   :additionalImageLinks [string],
   :productHeight {:value number, :unit string},
   :energyEfficiencyClass string,
   :cloudExportAdditionalProperties [{:propertyName string,
                                      :textValue [string],
                                      :boolValue boolean,
                                      :intValue [string],
                                      :floatValue [number],
                                      :minValue number,
                                      :maxValue number,
                                      :unitCode string}],
   :isBundle boolean,
   :maxHandlingTime string,
   :adsLabels [string],
   :freeShippingThreshold [{:country string, :priceThreshold Price}],
   :customAttributes [{:name string,
                       :value string,
                       :groupValues [CustomAttribute]}],
   :displayAdsLink string,
   :displayAdsValue number,
   :channel string,
   :contentLanguage string,
   :shippingWidth {:value number, :unit string},
   :mobileLink string,
   :lifestyleImageLinks [string],
   :shippingLabel string,
   :shippingLength {:value number, :unit string},
   :canonicalLink string,
   :sizeType string,
   :source string,
   :structuredTitle {:digitalSourceType string, :content string},
   :shoppingAdsExcludedCountries [string],
   :googleProductCategory string,
   :brand string,
   :title string,
   :unitPricingBaseMeasure {:value string, :unit string},
   :pickupMethod string,
   :offerId string,
   :installment {:months string,
                 :amount Price,
                 :downpayment Price,
                 :creditType string},
   :loyaltyPrograms [{:programLabel string,
                      :tierLabel string,
                      :price Price,
                      :cashbackForFutureUse Price,
                      :loyaltyPoints string}],
   :identifierExists boolean,
   :excludedDestinations [string],
   :adult boolean,
   :autoPricingMinPrice {:value string, :currency string},
   :itemGroupId string,
   :customLabel2 string,
   :productLength {:value number, :unit string},
   :link string,
   :id string,
   :condition string,
   :kind string,
   :disclosureDate string,
   :material string,
   :customLabel4 string,
   :mobileLinkTemplate string,
   :virtualModelLink string,
   :displayAdsSimilarIds [string],
   :customLabel1 string,
   :sellOnGoogleQuantity string,
   :certifications [{:certificationAuthority string,
                     :certificationName string,
                     :certificationCode string,
                     :certificationValue string}],
   :availabilityDate string,
   :minHandlingTime string,
   :additionalSizeType string,
   :costOfGoodsSold {:value string, :currency string},
   :pause string,
   :feedLabel string,
   :gtin string,
   :multipack string,
   :unitPricingMeasure {:value number, :unit string},
   :shipping [{:service string,
               :minTransitTime string,
               :locationId string,
               :maxHandlingTime string,
               :region string,
               :maxTransitTime string,
               :locationGroupName string,
               :postalCode string,
               :minHandlingTime string,
               :price Price,
               :country string}],
   :gender string,
   :loyaltyProgram {:programLabel string,
                    :tierLabel string,
                    :price Price,
                    :cashbackForFutureUse Price,
                    :loyaltyPoints string},
   :targetCountry string,
   :minEnergyEfficiencyClass string,
   :promotionIds [string],
   :price {:value string, :currency string},
   :adsGrouping string,
   :externalSellerId string,
   :structuredDescription {:digitalSourceType string, :content string},
   :imageLink string,
   :expirationDate string,
   :pattern string,
   :includedDestinations [string],
   :productTypes [string],
   :productWidth {:value number, :unit string},
   :salePriceEffectiveDate string}
  
  Uploads a product to your Merchant Center account. If an item with the same channel, contentLanguage, offerId, and targetCountry already exists, this method updates that entry."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
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

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/products/update
  
  Required parameters: merchantId, productId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :linkTemplate string,
   :productHighlights [string],
   :mpn string,
   :customLabel0 string,
   :transitTimeLabel string,
   :shippingWeight {:value number, :unit string},
   :availability string,
   :sizes [string],
   :shippingHeight {:value number, :unit string},
   :taxCategory string,
   :ageGroup string,
   :subscriptionCost {:period string,
                      :periodLength string,
                      :amount Price},
   :productWeight {:value number, :unit string},
   :sizeSystem string,
   :customLabel3 string,
   :displayAdsTitle string,
   :color string,
   :pickupSla string,
   :salePrice {:value string, :currency string},
   :maxEnergyEfficiencyClass string,
   :taxes [{:rate number,
            :country string,
            :region string,
            :taxShip boolean,
            :locationId string,
            :postalCode string}],
   :displayAdsId string,
   :adsRedirect string,
   :productDetails [{:sectionName string,
                     :attributeName string,
                     :attributeValue string}],
   :additionalImageLinks [string],
   :productHeight {:value number, :unit string},
   :energyEfficiencyClass string,
   :cloudExportAdditionalProperties [{:propertyName string,
                                      :textValue [string],
                                      :boolValue boolean,
                                      :intValue [string],
                                      :floatValue [number],
                                      :minValue number,
                                      :maxValue number,
                                      :unitCode string}],
   :isBundle boolean,
   :maxHandlingTime string,
   :adsLabels [string],
   :freeShippingThreshold [{:country string, :priceThreshold Price}],
   :customAttributes [{:name string,
                       :value string,
                       :groupValues [CustomAttribute]}],
   :displayAdsLink string,
   :displayAdsValue number,
   :channel string,
   :contentLanguage string,
   :shippingWidth {:value number, :unit string},
   :mobileLink string,
   :lifestyleImageLinks [string],
   :shippingLabel string,
   :shippingLength {:value number, :unit string},
   :canonicalLink string,
   :sizeType string,
   :source string,
   :structuredTitle {:digitalSourceType string, :content string},
   :shoppingAdsExcludedCountries [string],
   :googleProductCategory string,
   :brand string,
   :title string,
   :unitPricingBaseMeasure {:value string, :unit string},
   :pickupMethod string,
   :offerId string,
   :installment {:months string,
                 :amount Price,
                 :downpayment Price,
                 :creditType string},
   :loyaltyPrograms [{:programLabel string,
                      :tierLabel string,
                      :price Price,
                      :cashbackForFutureUse Price,
                      :loyaltyPoints string}],
   :identifierExists boolean,
   :excludedDestinations [string],
   :adult boolean,
   :autoPricingMinPrice {:value string, :currency string},
   :itemGroupId string,
   :customLabel2 string,
   :productLength {:value number, :unit string},
   :link string,
   :id string,
   :condition string,
   :kind string,
   :disclosureDate string,
   :material string,
   :customLabel4 string,
   :mobileLinkTemplate string,
   :virtualModelLink string,
   :displayAdsSimilarIds [string],
   :customLabel1 string,
   :sellOnGoogleQuantity string,
   :certifications [{:certificationAuthority string,
                     :certificationName string,
                     :certificationCode string,
                     :certificationValue string}],
   :availabilityDate string,
   :minHandlingTime string,
   :additionalSizeType string,
   :costOfGoodsSold {:value string, :currency string},
   :pause string,
   :feedLabel string,
   :gtin string,
   :multipack string,
   :unitPricingMeasure {:value number, :unit string},
   :shipping [{:service string,
               :minTransitTime string,
               :locationId string,
               :maxHandlingTime string,
               :region string,
               :maxTransitTime string,
               :locationGroupName string,
               :postalCode string,
               :minHandlingTime string,
               :price Price,
               :country string}],
   :gender string,
   :loyaltyProgram {:programLabel string,
                    :tierLabel string,
                    :price Price,
                    :cashbackForFutureUse Price,
                    :loyaltyPoints string},
   :targetCountry string,
   :minEnergyEfficiencyClass string,
   :promotionIds [string],
   :price {:value string, :currency string},
   :adsGrouping string,
   :externalSellerId string,
   :structuredDescription {:digitalSourceType string, :content string},
   :imageLink string,
   :expirationDate string,
   :pattern string,
   :includedDestinations [string],
   :productTypes [string],
   :productWidth {:value number, :unit string},
   :salePriceEffectiveDate string}
  
  Updates an existing product in your Merchant Center account. Only updates attributes provided in the request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/products/{productId}"
     #{:productId :merchantId}
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
     "https://shoppingcontent.googleapis.com/content/v2.1/"
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
