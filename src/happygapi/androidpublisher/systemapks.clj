(ns happygapi.androidpublisher.systemapks
  "Google Play Android Developer API: systemapks.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn variants-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/create
  
  Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Body: 
  
  {:variantId integer,
   :deviceSpec {:supportedAbis [string],
                :supportedLocales [string],
                :screenDensity integer},
   :options {:uncompressedNativeLibraries boolean,
             :uncompressedDexFiles boolean,
             :rotated boolean}}
  
  Creates an APK which is suitable for inclusion in a system image from an already uploaded Android App Bundle."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :versionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants"
     #{:packageName :versionCode}
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

(defn variants-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/list
  
  Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Returns the list of previously created system APK variants."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants"
     #{:packageName :versionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn variants-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/get
  
  Required parameters: packageName, versionCode, variantId
  
  Optional parameters: none
  
  Returns a previously created system APK variant."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:variantId :packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants/{variantId}"
     #{:variantId :packageName :versionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn variants-download$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/systemapks/variants/download
  
  Required parameters: packageName, versionCode, variantId
  
  Optional parameters: none
  
  Downloads a previously created system APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:variantId :packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/systemApks/{versionCode}/variants/{variantId}:download"
     #{:variantId :packageName :versionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
