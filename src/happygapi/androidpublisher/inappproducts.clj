(ns happygapi.androidpublisher.inappproducts
  "Google Play Developer API: inappproducts.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/delete
  
  Required parameters: packageName, sku
  
  Optional parameters: none
  
  Delete an in-app product for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
     #{:packageName :sku}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/get
  
  Required parameters: packageName, sku
  
  Optional parameters: none
  
  Returns information about the in-app product specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
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
  
  Creates a new in-app product for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts"
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
  
  Optional parameters: maxResults, startIndex, token
  
  List all the in-app products for an Android app, both subscriptions and managed in-app products.."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/inappproducts/patch
  
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
  
  Updates the details of an in-app product. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
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
  
  Updates the details of an in-app product."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :sku})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
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
