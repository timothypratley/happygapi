(ns happygapi.androidpublisher.inappproducts
  "Google Play Android Developer API: inappproducts.
  Lets Android application developers access their Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/list
  
  Required parameters: packageName
  
  Optional parameters: maxResults, startIndex, token
  
  Lists all in-app products - both managed products and subscriptions."
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

(defn delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/delete
  
  Required parameters: sku, packageName
  
  Optional parameters: none
  
  Deletes an in-app product (i.e. a managed product or a subscriptions)."
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

(defn update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/update
  
  Required parameters: packageName, sku
  
  Optional parameters: autoConvertMissingPrices
  
  Body: 
  
  {:packageName string,
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :defaultPrice {:currency string, :priceMicros string},
   :listings {},
   :defaultLanguage string}
  
  Updates an in-app product (i.e. a managed product or a subscriptions)."
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

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/get
  
  Required parameters: sku, packageName
  
  Optional parameters: none
  
  Gets an in-app product, which can be a managed product or a subscription."
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
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :defaultPrice {:currency string, :priceMicros string},
   :listings {},
   :defaultLanguage string}
  
  Creates an in-app product (i.e. a managed product or a subscriptions)."
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
  
  Required parameters: sku, packageName
  
  Optional parameters: autoConvertMissingPrices
  
  Body: 
  
  {:packageName string,
   :purchaseType string,
   :sku string,
   :prices {},
   :trialPeriod string,
   :status string,
   :subscriptionPeriod string,
   :gracePeriod string,
   :defaultPrice {:currency string, :priceMicros string},
   :listings {},
   :defaultLanguage string}
  
  Patches an in-app product (i.e. a managed product or a subscriptions)."
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
