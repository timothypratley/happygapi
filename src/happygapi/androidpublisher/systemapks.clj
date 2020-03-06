(ns happygapi.androidpublisher.systemapks
  "Google Play Developer API: systemapks.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn variants-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/create
  
  Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Body: 
  
  {:deviceSpec {:screenDensity integer,
                :supportedAbis [string],
                :supportedLocales [string]}}
  
  Creates a new variant of APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :versionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants"
     #{:packageName :versionCode}
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

(defn variants-download$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/download
  
  Required parameters: packageName, variantId, versionCode
  
  Optional parameters: none
  Download a previously created APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:variantId :packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants/{variantId}:download"
     #{:variantId :packageName :versionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn variants-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/get
  
  Required parameters: packageName, variantId, versionCode
  
  Optional parameters: none
  Returns a previously created system APK variant."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:variantId :packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants/{variantId}"
     #{:variantId :packageName :versionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn variants-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/list
  
  Required parameters: packageName, versionCode
  
  Optional parameters: none
  Returns the list of previously created system APK variants."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants"
     #{:packageName :versionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
