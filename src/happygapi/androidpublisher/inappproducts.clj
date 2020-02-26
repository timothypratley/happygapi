(ns happygapi.androidpublisher.inappproducts
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidpublisher_schema.edn"))))

(defn delete$
  "Required parameters: packageName, sku
  
  Optional parameters: none
  
  Delete an in-app product for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"sku" "packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
     #{"sku" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: packageName, sku
  
  Optional parameters: none
  
  Returns information about the in-app product specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"sku" "packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
     #{"sku" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: packageName
  
  Optional parameters: autoConvertMissingPrices
  
  Creates a new in-app product for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts"
     #{"packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn list$
  "Required parameters: packageName
  
  Optional parameters: maxResults, startIndex, token
  
  List all the in-app products for an Android app, both subscriptions and managed in-app products.."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts"
     #{"packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: packageName, sku
  
  Optional parameters: autoConvertMissingPrices
  
  Updates the details of an in-app product. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"sku" "packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
     #{"sku" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: packageName, sku
  
  Optional parameters: autoConvertMissingPrices
  
  Updates the details of an in-app product."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"sku" "packageName"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/inappproducts/{sku}"
     #{"sku" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
