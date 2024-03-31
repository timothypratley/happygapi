(ns happygapi.androidpublisher.edits
  "Google Play Android Developer API: edits.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/edits"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/insert
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:id string, :expiryTimeSeconds string}
  
  Creates a new edit for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits"
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

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/get
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Gets an app edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/delete
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Deletes an app edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn commit$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/commit
  
  Required parameters: packageName, editId
  
  Optional parameters: changesNotSentForReview
  
  Commits an app edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}:commit"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn validate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/validate
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Validates an app edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}:validate"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn countryavailability-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/countryavailability/get
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Gets country availability."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/countryAvailability/{track}"
     #{:packageName :editId :track}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bundles-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/bundles/list
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Lists all current Android App Bundles of the app and edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/bundles"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bundles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/bundles/upload
  
  Required parameters: packageName, editId
  
  Optional parameters: ackBundleInstallationWarning, deviceTierConfigId
  
  Uploads a new Android App Bundle to this edit. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See [Timeouts and Errors](https://developers.google.com/api-client-library/java/google-api-java-client/errors) for an example in java."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/bundles"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn images-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/list
  
  Required parameters: packageName, editId, language, imageType
  
  Optional parameters: none
  
  Lists all images. The response may be empty."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn images-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/delete
  
  Required parameters: packageName, editId, language, imageType, imageId
  
  Optional parameters: none
  
  Deletes the image (specified by id) from the edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :imageType :language :editId :imageId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}/{imageId}"
     #{:packageName :imageType :language :editId :imageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn images-deleteall$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/deleteall
  
  Required parameters: packageName, editId, language, imageType
  
  Optional parameters: none
  
  Deletes all images for the specified language and image type. Returns an empty response if no images are found."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn images-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/upload
  
  Required parameters: packageName, editId, language, imageType
  
  Optional parameters: none
  
  Uploads an image of the specified language and image type, and adds to the edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/get
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Gets a track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/list
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Lists all tracks."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/update
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Body: 
  
  {:track string,
   :releases [{:name string,
               :versionCodes [string],
               :releaseNotes [LocalizedText],
               :status string,
               :userFraction number,
               :countryTargeting CountryTargeting,
               :inAppUpdatePriority integer}]}
  
  Updates a track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
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

(defn tracks-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/patch
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Body: 
  
  {:track string,
   :releases [{:name string,
               :versionCodes [string],
               :releaseNotes [LocalizedText],
               :status string,
               :userFraction number,
               :countryTargeting CountryTargeting,
               :inAppUpdatePriority integer}]}
  
  Patches a track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
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

(defn tracks-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/create
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Body: 
  
  {:track string, :type string, :formFactor string}
  
  Creates a new track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/tracks"
     #{:packageName :editId}
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

(defn deobfuscationfiles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/deobfuscationfiles/upload
  
  Required parameters: packageName, editId, apkVersionCode, deobfuscationFileType
  
  Optional parameters: none
  
  Uploads a new deobfuscation file and attaches to the specified APK."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName
            :deobfuscationFileType
            :editId
            :apkVersionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/deobfuscationFiles/{deobfuscationFileType}"
     #{:packageName :deobfuscationFileType :editId :apkVersionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apks-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/upload
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Uploads an APK and adds to the current edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apks-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/list
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Lists all current APKs of the app and edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn apks-addexternallyhosted$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/addexternallyhosted
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Body: 
  
  {:externallyHostedApk {:usesFeatures [string],
                         :fileSize string,
                         :packageName string,
                         :nativeCodes [string],
                         :externallyHostedUrl string,
                         :certificateBase64s [string],
                         :fileSha256Base64 string,
                         :versionName string,
                         :minimumSdk integer,
                         :maximumSdk integer,
                         :versionCode integer,
                         :fileSha1Base64 string,
                         :applicationLabel string,
                         :usesPermissions [UsesPermission],
                         :iconBase64 string}}
  
  Creates a new APK without uploading the APK itself to Google Play, instead hosting the APK at a specified URL. This function is only available to organizations using Managed Play whose application is configured to restrict distribution to the organizations."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/externallyHosted"
     #{:packageName :editId}
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

(defn details-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/get
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Gets details of an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/details"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn details-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/update
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Body: 
  
  {:defaultLanguage string,
   :contactWebsite string,
   :contactEmail string,
   :contactPhone string}
  
  Updates details of an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/details"
     #{:packageName :editId}
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

(defn details-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/patch
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Body: 
  
  {:defaultLanguage string,
   :contactWebsite string,
   :contactEmail string,
   :contactPhone string}
  
  Patches details of an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/details"
     #{:packageName :editId}
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

(defn testers-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/get
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Gets testers. Note: Testers resource does not support email lists."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testers-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/update
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Body: 
  
  {:googleGroups [string]}
  
  Updates testers. Note: Testers resource does not support email lists."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
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

(defn testers-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/patch
  
  Required parameters: packageName, editId, track
  
  Optional parameters: none
  
  Body: 
  
  {:googleGroups [string]}
  
  Patches testers. Note: Testers resource does not support email lists."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :editId :track})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
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

(defn listings-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/update
  
  Required parameters: packageName, editId, language
  
  Optional parameters: none
  
  Body: 
  
  {:language string,
   :title string,
   :fullDescription string,
   :shortDescription string,
   :video string}
  
  Creates or updates a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :language :editId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
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

(defn listings-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/patch
  
  Required parameters: packageName, editId, language
  
  Optional parameters: none
  
  Body: 
  
  {:language string,
   :title string,
   :fullDescription string,
   :shortDescription string,
   :video string}
  
  Patches a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :language :editId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
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

(defn listings-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/get
  
  Required parameters: packageName, editId, language
  
  Optional parameters: none
  
  Gets a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :language :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listings-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/list
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Lists all localized store listings."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listings-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/delete
  
  Required parameters: packageName, editId, language
  
  Optional parameters: none
  
  Deletes a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :language :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listings-deleteall$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/deleteall
  
  Required parameters: packageName, editId
  
  Optional parameters: none
  
  Deletes all store listings."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/listings"
     #{:packageName :editId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/get
  
  Required parameters: packageName, editId, apkVersionCode, expansionFileType
  
  Optional parameters: none
  
  Fetches the expansion file configuration for the specified APK."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/update
  
  Required parameters: packageName, editId, apkVersionCode, expansionFileType
  
  Optional parameters: none
  
  Body: 
  
  {:referencesVersion integer, :fileSize string}
  
  Updates the APK's expansion file configuration to reference another APK's expansion file. To add a new expansion file use the Upload method."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
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

(defn expansionfiles-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/patch
  
  Required parameters: packageName, editId, apkVersionCode, expansionFileType
  
  Optional parameters: none
  
  Body: 
  
  {:referencesVersion integer, :fileSize string}
  
  Patches the APK's expansion file configuration to reference another APK's expansion file. To add a new expansion file use the Upload method."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
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

(defn expansionfiles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/upload
  
  Required parameters: packageName, editId, apkVersionCode, expansionFileType
  
  Optional parameters: none
  
  Uploads a new expansion file and attaches to the specified APK."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
