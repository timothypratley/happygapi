(ns happygapi.androidpublisher.edits
  "Google Play Developer API: edits.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/edits"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn commit$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/commit
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Commits/applies the changes made in this edit back to the app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}:commit"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/delete
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Deletes an edit for an app. Creating a new edit will automatically delete any of your previous edits so this method need only be called if you want to preemptively abandon an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/get
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Returns information about the edit specified. Calls will fail if the edit is no long active (e.g. has been deleted, superseded or expired)."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/insert
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:expiryTimeSeconds string, :id string}
  
  Creates a new edit for an app, populated with the app's current state."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits"
     #{:packageName}
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

(defn validate$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/validate
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Checks that the edit can be successfully committed. The edit's changes are not applied to the live app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}:validate"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bundles-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/bundles/list
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/bundles"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bundles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/bundles/upload
  
  Required parameters: editId, packageName
  
  Optional parameters: ackBundleInstallationWarning
  Uploads a new Android App Bundle to this edit. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See: https://developers.google.com/api-client-library/java/google-api-java-client/errors for an example in java."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/bundles"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/delete
  
  Required parameters: editId, imageId, imageType, language, packageName
  
  Optional parameters: none
  Deletes the image (specified by id) from the edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :imageType :language :editId :imageId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}/{imageId}"
     #{:packageName :imageType :language :editId :imageId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-deleteall$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/deleteall
  
  Required parameters: editId, imageType, language, packageName
  
  Optional parameters: none
  Deletes all images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/list
  
  Required parameters: editId, imageType, language, packageName
  
  Optional parameters: none
  Lists all images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/images/upload
  
  Required parameters: editId, imageType, language, packageName
  
  Optional parameters: none
  Uploads a new image and adds it to the list of images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :imageType :language :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{:packageName :imageType :language :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/get
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  Fetches the track configuration for the specified track type. Includes the APK version codes that are in this track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/list
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Lists all the track configurations for this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/patch
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  
  Body: 
  
  {:releases [{:releaseNotes [LocalizedText],
               :rollbackEnabled boolean,
               :countryTargeting CountryTargeting,
               :name string,
               :versionCodes [string],
               :controls [Control],
               :status string,
               :pinnedVersions [TrackReleasePin],
               :userFraction number,
               :sampling Sampling,
               :inAppUpdatePriority integer}],
   :track string}
  
  Updates the track configuration for the specified track type. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
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

(defn tracks-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/tracks/update
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  
  Body: 
  
  {:releases [{:releaseNotes [LocalizedText],
               :rollbackEnabled boolean,
               :countryTargeting CountryTargeting,
               :name string,
               :versionCodes [string],
               :controls [Control],
               :status string,
               :pinnedVersions [TrackReleasePin],
               :userFraction number,
               :sampling Sampling,
               :inAppUpdatePriority integer}],
   :track string}
  
  Updates the track configuration for the specified track type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{:packageName :editId :track}
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

(defn deobfuscationfiles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/deobfuscationfiles/upload
  
  Required parameters: apkVersionCode, deobfuscationFileType, editId, packageName
  
  Optional parameters: none
  Uploads the deobfuscation file of the specified APK. If a deobfuscation file already exists, it will be replaced."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName
            :deobfuscationFileType
            :editId
            :apkVersionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/deobfuscationFiles/{deobfuscationFileType}"
     #{:packageName :deobfuscationFileType :editId :apkVersionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn apks-addexternallyhosted$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/addexternallyhosted
  
  Required parameters: editId, packageName
  
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
                         :usesPermissions [ExternallyHostedApkUsesPermission],
                         :iconBase64 string}}
  
  Creates a new APK without uploading the APK itself to Google Play, instead hosting the APK at a specified URL. This function is only available to enterprises using Google Play for Work whose application is configured to restrict distribution to the enterprise domain."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/externallyHosted"
     #{:packageName :editId}
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

(defn apks-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/list
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn apks-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/apks/upload
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn details-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/get
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Fetches app details for this edit. This includes the default language and developer support contact information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn details-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/patch
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:contactEmail string,
   :contactPhone string,
   :contactWebsite string,
   :defaultLanguage string}
  
  Updates app details for this edit. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{:packageName :editId}
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

(defn details-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/details/update
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:contactEmail string,
   :contactPhone string,
   :contactWebsite string,
   :defaultLanguage string}
  
  Updates app details for this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{:packageName :editId}
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

(defn testers-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/get
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testers-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/patch
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  
  Body: 
  
  {:autoEnrolledAndroidGroups [string],
   :autoEnrolledGoogleGroups [string],
   :excludedGoogleGroups [string],
   :googleGroups [string]}
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
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

(defn testers-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/testers/update
  
  Required parameters: editId, packageName, track
  
  Optional parameters: none
  
  Body: 
  
  {:autoEnrolledAndroidGroups [string],
   :autoEnrolledGoogleGroups [string],
   :excludedGoogleGroups [string],
   :googleGroups [string]}
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :editId :track})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{:packageName :editId :track}
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

(defn listings-delete$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/delete
  
  Required parameters: editId, language, packageName
  
  Optional parameters: none
  Deletes the specified localized store listing from an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :language :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-deleteall$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/deleteall
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Deletes all localized listings from an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/get
  
  Required parameters: editId, language, packageName
  
  Optional parameters: none
  Fetches information about a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :language :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/list
  
  Required parameters: editId, packageName
  
  Optional parameters: none
  Returns all of the localized store listings attached to this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{:packageName :editId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings"
     #{:packageName :editId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/patch
  
  Required parameters: editId, language, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:fullDescription string,
   :language string,
   :shortDescription string,
   :title string,
   :video string}
  
  Creates or updates a localized store listing. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :language :editId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
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

(defn listings-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/listings/update
  
  Required parameters: editId, language, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:fullDescription string,
   :language string,
   :shortDescription string,
   :title string,
   :video string}
  
  Creates or updates a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:packageName :language :editId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{:packageName :language :editId}
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

(defn expansionfiles-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/get
  
  Required parameters: apkVersionCode, editId, expansionFileType, packageName
  
  Optional parameters: none
  Fetches the Expansion File configuration for the APK specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-patch$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/patch
  
  Required parameters: apkVersionCode, editId, expansionFileType, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:fileSize string, :referencesVersion integer}
  
  Updates the APK's Expansion File configuration to reference another APK's Expansion Files. To add a new Expansion File use the Upload method. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
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

(defn expansionfiles-update$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/update
  
  Required parameters: apkVersionCode, editId, expansionFileType, packageName
  
  Optional parameters: none
  
  Body: 
  
  {:fileSize string, :referencesVersion integer}
  
  Updates the APK's Expansion File configuration to reference another APK's Expansion Files. To add a new Expansion File use the Upload method."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
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

(defn expansionfiles-upload$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/edits/expansionfiles/upload
  
  Required parameters: apkVersionCode, editId, expansionFileType, packageName
  
  Optional parameters: none
  Uploads and attaches a new Expansion File to the APK specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:packageName :expansionFileType :editId :apkVersionCode})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{:packageName :expansionFileType :editId :apkVersionCode}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
