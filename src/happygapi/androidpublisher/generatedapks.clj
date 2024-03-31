(ns happygapi.androidpublisher.generatedapks
  "Google Play Android Developer API: generatedapks.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/generatedapks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/generatedapks/list
  
  Required parameters: packageName, versionCode
  
  Optional parameters: none
  
  Returns download metadata for all APKs that were generated from a given app bundle."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/generatedApks/{versionCode}"
     #{:packageName :versionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn download$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/generatedapks/download
  
  Required parameters: packageName, versionCode, downloadId
  
  Optional parameters: none
  
  Downloads a single signed APK generated from an app bundle."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:downloadId :packageName :versionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/generatedApks/{versionCode}/downloads/{downloadId}:download"
     #{:downloadId :packageName :versionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
