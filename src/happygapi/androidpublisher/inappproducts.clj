(ns happygapi.androidpublisher.inappproducts
  "Google Play Android Developer API: inappproducts.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/get
  
  Required parameters: packageName, sku
  
  Optional parameters: none
  
  Gets an in-app product, which can be a managed product or a subscription. This method should no longer be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts/{sku}"
     #{:packageName :sku}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/insert
  
  Required parameters: packageName
  
  Optional parameters: autoConvertMissingPrices
  
  Body: 
  
  {:packageName string,
   :subscriptionTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                            :taxRateInfoByRegionCode {},
                                            :isTokenizedDigitalAsset boolean},
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :managedProductTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                              :taxRateInfoByRegionCode {},
                                              :isTokenizedDigitalAsset boolean},
   :defaultPrice {:priceMicros string, :currency string},
   :listings {},
   :defaultLanguage string}
  
  Creates an in-app product (a managed product or a subscription). This method should no longer be used to create subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts"
     #{:packageName}
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

(defn patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/patch
  
  Required parameters: packageName, sku
  
  Optional parameters: autoConvertMissingPrices, latencyTolerance
  
  Body: 
  
  {:packageName string,
   :subscriptionTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                            :taxRateInfoByRegionCode {},
                                            :isTokenizedDigitalAsset boolean},
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :managedProductTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                              :taxRateInfoByRegionCode {},
                                              :isTokenizedDigitalAsset boolean},
   :defaultPrice {:priceMicros string, :currency string},
   :listings {},
   :defaultLanguage string}
  
  Patches an in-app product (a managed product or a subscription). This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts/{sku}"
     #{:packageName :sku}
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

(defn batchUpdate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/batchUpdate
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:packageName string,
               :sku string,
               :autoConvertMissingPrices boolean,
               :inappproduct InAppProduct,
               :allowMissing boolean,
               :latencyTolerance string}]}
  
  Updates or inserts one or more in-app products (managed products or subscriptions). Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput. This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts:batchUpdate"
     #{:packageName}
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

(defn batchGet$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/batchGet
  
  Required parameters: packageName
  
  Optional parameters: sku
  
  Reads multiple in-app products, which can be managed products or subscriptions. This method should not be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts:batchGet"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/update
  
  Required parameters: packageName, sku
  
  Optional parameters: autoConvertMissingPrices, allowMissing, latencyTolerance
  
  Body: 
  
  {:packageName string,
   :subscriptionTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                            :taxRateInfoByRegionCode {},
                                            :isTokenizedDigitalAsset boolean},
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :managedProductTaxesAndComplianceSettings {:eeaWithdrawalRightType string,
                                              :taxRateInfoByRegionCode {},
                                              :isTokenizedDigitalAsset boolean},
   :defaultPrice {:priceMicros string, :currency string},
   :listings {},
   :defaultLanguage string}
  
  Updates an in-app product (a managed product or a subscription). This method should no longer be used to update subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts/{sku}"
     #{:packageName :sku}
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
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/delete
  
  Required parameters: packageName, sku
  
  Optional parameters: latencyTolerance
  
  Deletes an in-app product (a managed product or a subscription). This method should no longer be used to delete subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts/{sku}"
     #{:packageName :sku}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn batchDelete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/batchDelete
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:packageName string,
               :sku string,
               :latencyTolerance string}]}
  
  Deletes in-app products (managed products or subscriptions). Set the latencyTolerance field on nested requests to PRODUCT_UPDATE_LATENCY_TOLERANCE_LATENCY_TOLERANT to achieve maximum update throughput. This method should not be used to delete subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts:batchDelete"
     #{:packageName}
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
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/list
  
  Required parameters: packageName
  
  Optional parameters: token, startIndex, maxResults
  
  Lists all in-app products - both managed products and subscriptions. If an app has a large number of in-app products, the response may be paginated. In this case the response field `tokenPagination.nextPageToken` will be set and the caller should provide its value as a `token` request parameter to retrieve the next page. This method should no longer be used to retrieve subscriptions. See [this article](https://android-developers.googleblog.com/2023/06/changes-to-google-play-developer-api-june-2023.html) for more information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/inappproducts"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
