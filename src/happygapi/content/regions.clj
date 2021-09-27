(ns happygapi.content.regions
  "Content API for Shopping: regions.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions/list
  
  Required parameters: merchantId
  
  Optional parameters: pageSize, pageToken
  
  Lists the regions in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/regions"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions/patch
  
  Required parameters: merchantId, regionId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:regionId string,
   :displayName string,
   :regionalInventoryEligible boolean,
   :merchantId string,
   :shippingEligible boolean,
   :postalCodeArea {:regionCode string,
                    :postalCodes [RegionPostalCodeAreaPostalCodeRange]},
   :geotargetArea {:geotargetCriteriaIds [string]}}
  
  Updates a region definition in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionId :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/regions/{regionId}"
     #{:regionId :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions/get
  
  Required parameters: merchantId, regionId
  
  Optional parameters: none
  
  Retrieves a region defined in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:regionId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/regions/{regionId}"
     #{:regionId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions/create
  
  Required parameters: merchantId
  
  Optional parameters: regionId
  
  Body: 
  
  {:regionId string,
   :displayName string,
   :regionalInventoryEligible boolean,
   :merchantId string,
   :shippingEligible boolean,
   :postalCodeArea {:regionCode string,
                    :postalCodes [RegionPostalCodeAreaPostalCodeRange]},
   :geotargetArea {:geotargetCriteriaIds [string]}}
  
  Creates a region definition in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/regions"
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/regions/delete
  
  Required parameters: regionId, merchantId
  
  Optional parameters: none
  
  Deletes a region definition from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:regionId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/regions/{regionId}"
     #{:regionId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
