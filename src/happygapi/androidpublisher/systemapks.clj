(ns happygapi.androidpublisher.systemapks
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn variants-create$
  "Required parameters: packageName,versionCode
  
  Creates a new variant of APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"packageName" "versionCode"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants"
     #{"packageName" "versionCode"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn variants-download$
  "Required parameters: packageName,variantId,versionCode
  
  Download a previously created APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"packageName" "versionCode" "variantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants/{variantId}:download"
     #{"packageName" "versionCode" "variantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn variants-get$
  "Required parameters: packageName,variantId,versionCode
  
  Returns a previously created system APK variant."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"packageName" "versionCode" "variantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants/{variantId}"
     #{"packageName" "versionCode" "variantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn variants-list$
  "Required parameters: packageName,versionCode
  
  Returns the list of previously created system APK variants."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"packageName" "versionCode"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/systemApks/{versionCode}/variants"
     #{"packageName" "versionCode"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
