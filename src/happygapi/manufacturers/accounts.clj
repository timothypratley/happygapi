(ns happygapi.manufacturers.accounts
  "Manufacturer Center API: accounts.
  Public API for managing Manufacturer Center related data.
  See: https://developers.google.com/manufacturers/api/reference/rest/v1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn products-delete$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/delete
  
  Required parameters: name, parent
  
  Optional parameters: none
  Deletes the product from a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent :name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-list$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, include
  Lists all the products in a Manufacturer Center account."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-get$
  "https://developers.google.com/manufacturers/api/reference/rest/v1/accounts/products/get
  
  Required parameters: parent, name
  
  Optional parameters: include
  Gets the product from a Manufacturer Center account, including product
  issues.
  
  A recently updated product takes around 15 minutes to process. Changes are
  only visible after it has been processed. While some issues may be
  available once the product has been processed, other issues may take days
  to appear."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent :name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :suggestedRetailPrice {:currency string, :amount string},
   :flavor string,
   :color string,
   :productLine string,
   :capacity {:value string, :unit string},
   :includedDestination [string],
   :additionalImageLink [{:type string,
                          :imageUrl string,
                          :status string}],
   :productPageUrl string,
   :releaseDate string,
   :productDetail [{:attributeValue string,
                    :sectionName string,
                    :attributeName string}],
   :productName string,
   :sizeType string,
   :size string,
   :brand string,
   :title string,
   :theme string,
   :excludedDestination [string],
   :scent string,
   :itemGroupId string,
   :productType [string],
   :disclosureDate string,
   :featureDescription [{:text string, :image Image, :headline string}],
   :count {:value string, :unit string},
   :material string,
   :videoLink [string],
   :gtin [string],
   :gender string,
   :targetClientId string,
   :imageLink {:type string, :imageUrl string, :status string},
   :pattern string}
  
  Inserts or updates the attributes of the product in a Manufacturer Center
  account.
  
  Creates a product with the provided attributes. If the product already
  exists, then all attributes are replaced with the new ones. The checks at
  upload time are minimal. All required attributes need to be present for a
  product to be valid. Issues may show up later after the API has accepted a
  new upload for a product and it is possible to overwrite an existing valid
  product with an invalid product. To detect this, you should retrieve the
  product and check it for issues once the new version is available.
  
  Uploaded attributes first need to be processed before they can be
  retrieved. Until then, new products will be unavailable, and retrieval
  of previously uploaded products will return the original state of the
  product."
  {:scopes ["https://www.googleapis.com/auth/manufacturercenter"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent :name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://manufacturers.googleapis.com/"
     "v1/{+parent}/products/{+name}"
     #{:parent :name}
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
