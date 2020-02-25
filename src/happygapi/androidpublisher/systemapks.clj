(ns happygapi.androidpublisher.systemapks
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidpublisher_schema.edn"))))

(defn variants-create$
  "Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Creates a new variant of APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"packageName" "versionCode"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: packageName, variantId, versionCode
  
  Optional parameters: none
  
  Download a previously created APK which is suitable for inclusion in a system image."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"packageName" "versionCode" "variantId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: packageName, variantId, versionCode
  
  Optional parameters: none
  
  Returns a previously created system APK variant."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"packageName" "versionCode" "variantId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Returns the list of previously created system APK variants."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"packageName" "versionCode"})
         (json-schema/validate schemas args)]}
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
