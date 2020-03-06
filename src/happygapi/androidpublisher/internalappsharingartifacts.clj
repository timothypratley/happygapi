(ns happygapi.androidpublisher.internalappsharingartifacts
  "Google Play Developer API: internalappsharingartifacts.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/internalappsharingartifacts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn uploadapk$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/internalappsharingartifacts/uploadapk
  
  Required parameters: packageName
  
  Optional parameters: none
  Uploads an APK to internal app sharing. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See: https://developers.google.com/api-client-library/java/google-api-java-client/errors for an example in java."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "internalappsharing/{packageName}/artifacts/apk"
     #{:packageName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn uploadbundle$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/internalappsharingartifacts/uploadbundle
  
  Required parameters: packageName
  
  Optional parameters: none
  Uploads an app bundle to internal app sharing. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See: https://developers.google.com/api-client-library/java/google-api-java-client/errors for an example in java."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "internalappsharing/{packageName}/artifacts/bundle"
     #{:packageName}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
