(ns happygapi.manufacturers.accounts
  "Manufacturer Center API: accounts.
  Public API for managing Manufacturer Center related data.
  See: https://developers.google.com/manufacturers/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn products-list$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, include
  
  Lists all the products in a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn products-get$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/get
  
  Required parameters: parent, name
  
  Optional parameters: include
  
  Gets the product from a Manufacturer Center account, including product issues. A recently updated product takes around 15 minutes to process. Changes are only visible after it has been processed. While some issues may be available once the product has been processed, other issues may take days to appear."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn products-update$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/update
  
  Required parameters: parent, name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :mpn string,
   :format string,
   :ageGroup string,
   :sizeSystem string,
   :suggestedRetailPrice {:amount string, :currency string},
   :flavor string,
   :color string,
   :productLine string,
   :capacity {:value string, :unit string},
   :includedDestination [string],
   :additionalImageLink [{:type string,
                          :status string,
                          :imageUrl string}],
   :productPageUrl string,
   :releaseDate string,
   :productDetail [{:sectionName string,
                    :attributeName string,
                    :attributeValue string}],
   :productName string,
   :sizeType [string],
   :size string,
   :brand string,
   :title string,
   :theme string,
   :excludedDestination [string],
   :scent string,
   :itemGroupId string,
   :certification [{:name string, :authority string, :code string}],
   :productType [string],
   :disclosureDate string,
   :featureDescription [{:headline string, :text string, :image Image}],
   :count {:value string, :unit string},
   :material string,
   :virtualModelLink string,
   :videoLink [string],
   :grocery {:allergens string,
             :directions string,
             :nutritionClaim [string],
             :activeIngredients string,
             :storageInstructions string,
             :indications string,
             :ingredients string,
             :derivedNutritionClaim [string],
             :alcoholByVolume number},
   :gtin [string],
   :gender string,
   :targetClientId string,
   :productHighlight [string],
   :nutrition {:folateDailyPercentage number,
               :saturatedFatDailyPercentage number,
               :calciumDailyPercentage number,
               :totalFat FloatUnit,
               :nutritionFactMeasure string,
               :totalSugarsDailyPercentage number,
               :vitaminDDailyPercentage number,
               :monounsaturatedFat FloatUnit,
               :servingsPerContainer string,
               :servingSizeMeasure FloatUnit,
               :energyFromFat FloatUnit,
               :potassiumDailyPercentage number,
               :folateMcgDfe number,
               :addedSugarsDailyPercentage number,
               :transFatDailyPercentage number,
               :voluntaryNutritionFact [VoluntaryNutritionFact],
               :energy FloatUnit,
               :preparedSizeDescription string,
               :calcium FloatUnit,
               :dietaryFiberDailyPercentage number,
               :iron FloatUnit,
               :saturatedFat FloatUnit,
               :potassium FloatUnit,
               :proteinDailyPercentage number,
               :cholesterolDailyPercentage number,
               :polyols FloatUnit,
               :cholesterol FloatUnit,
               :folateFolicAcid FloatUnit,
               :ironDailyPercentage number,
               :dietaryFiber FloatUnit,
               :transFat FloatUnit,
               :totalFatDailyPercentage number,
               :totalCarbohydrateDailyPercentage number,
               :sodium FloatUnit,
               :protein FloatUnit,
               :totalSugars FloatUnit,
               :vitaminD FloatUnit,
               :totalCarbohydrate FloatUnit,
               :sodiumDailyPercentage number,
               :addedSugars FloatUnit,
               :starch FloatUnit,
               :servingSizeDescription string,
               :polyunsaturatedFat FloatUnit},
   :imageLink {:type string, :status string, :imageUrl string},
   :pattern string,
   :richProductContent [string]}
  
  Inserts or updates the attributes of the product in a Manufacturer Center account. Creates a product with the provided attributes. If the product already exists, then all attributes are replaced with the new ones. The checks at upload time are minimal. All required attributes need to be present for a product to be valid. Issues may show up later after the API has accepted a new upload for a product and it is possible to overwrite an existing valid product with an invalid product. To detect this, you should retrieve the product and check it for issues once the new version is available. Uploaded attributes first need to be processed before they can be retrieved. Until then, new products will be unavailable, and retrieval of previously uploaded products will return the original state of the product."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent :name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
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

(defn products-delete$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/delete
  
  Required parameters: parent, name
  
  Optional parameters: none
  
  Deletes the product from a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent :name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn languages-productCertifications-patch$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/languages/productCertifications/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:mpn [string],
   :issues [{:type string,
             :severity string,
             :attribute string,
             :title string,
             :description string,
             :resolution string,
             :destination string,
             :timestamp string}],
   :destinationStatuses [{:destination string, :status string}],
   :name string,
   :brand string,
   :title string,
   :certification [{:name string,
                    :authority string,
                    :code string,
                    :value string,
                    :link string,
                    :logo string,
                    :validUntil string}],
   :productType [string],
   :productCode [string],
   :countryCode [string]}
  
  Updates (or creates if allow_missing = true) a product certification which links certifications with products. This method can only be called by certification bodies."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn languages-productCertifications-list$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/languages/productCertifications/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists product certifications from a specified certification body. This method can only be called by certification bodies."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/productCertifications"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn languages-productCertifications-get$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/languages/productCertifications/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a product certification by its name. This method can only be called by certification bodies."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn languages-productCertifications-delete$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/languages/productCertifications/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a product certification by its name. This method can only be called by certification bodies."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
