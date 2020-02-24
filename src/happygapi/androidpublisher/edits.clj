(ns happygapi.androidpublisher.edits
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn commit$
  "Required parameters: editId,packageName
  
  Commits/applies the changes made in this edit back to the app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}:commit"
     #{"editId" "packageName"}
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

(defn delete$
  "Required parameters: editId,packageName
  
  Deletes an edit for an app. Creating a new edit will automatically delete any of your previous edits so this method need only be called if you want to preemptively abandon an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: editId,packageName
  
  Returns information about the edit specified. Calls will fail if the edit is no long active (e.g. has been deleted, superseded or expired)."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}"
     #{"editId" "packageName"}
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
  
  Creates a new edit for an app, populated with the app's current state."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits"
     #{"packageName"}
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

(defn validate$
  "Required parameters: editId,packageName
  
  Checks that the edit can be successfully committed. The edit's changes are not applied to the live app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}:validate"
     #{"editId" "packageName"}
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

(defn bundles-list$
  "Required parameters: editId,packageName
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/bundles"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn bundles-upload$
  "Required parameters: editId,packageName
  
  Uploads a new Android App Bundle to this edit. If you are using the Google API client libraries, please increase the timeout of the http request before calling this endpoint (a timeout of 2 minutes is recommended). See: https://developers.google.com/api-client-library/java/google-api-java-client/errors for an example in java."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/bundles"
     #{"editId" "packageName"}
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

(defn images-delete$
  "Required parameters: editId,imageId,imageType,language,packageName
  
  Deletes the image (specified by id) from the edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"editId" "imageId" "imageType" "packageName" "language"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}/{imageId}"
     #{"editId" "imageId" "imageType" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-deleteall$
  "Required parameters: editId,imageType,language,packageName
  
  Deletes all images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"editId" "imageType" "packageName" "language"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{"editId" "imageType" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-list$
  "Required parameters: editId,imageType,language,packageName
  
  Lists all images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"editId" "imageType" "packageName" "language"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{"editId" "imageType" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn images-upload$
  "Required parameters: editId,imageType,language,packageName
  
  Uploads a new image and adds it to the list of images for the specified language and image type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"editId" "imageType" "packageName" "language"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}/{imageType}"
     #{"editId" "imageType" "packageName" "language"}
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

(defn tracks-get$
  "Required parameters: editId,packageName,track
  
  Fetches the track configuration for the specified track type. Includes the APK version codes that are in this track."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-list$
  "Required parameters: editId,packageName
  
  Lists all the track configurations for this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-patch$
  "Required parameters: editId,packageName,track
  
  Updates the track configuration for the specified track type. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn tracks-update$
  "Required parameters: editId,packageName,track
  
  Updates the track configuration for the specified track type."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/tracks/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn deobfuscationfiles-upload$
  "Required parameters: apkVersionCode,deobfuscationFileType,editId,packageName
  
  Uploads the deobfuscation file of the specified APK. If a deobfuscation file already exists, it will be replaced."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"deobfuscationFileType"
            "apkVersionCode"
            "editId"
            "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/deobfuscationFiles/{deobfuscationFileType}"
     #{"deobfuscationFileType"
       "apkVersionCode"
       "editId"
       "packageName"}
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

(defn apks-addexternallyhosted$
  "Required parameters: editId,packageName
  
  Creates a new APK without uploading the APK itself to Google Play, instead hosting the APK at a specified URL. This function is only available to enterprises using Google Play for Work whose application is configured to restrict distribution to the enterprise domain."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/externallyHosted"
     #{"editId" "packageName"}
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

(defn apks-list$
  "Required parameters: editId,packageName
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn apks-upload$
  "Required parameters: editId,packageName
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks"
     #{"editId" "packageName"}
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

(defn details-get$
  "Required parameters: editId,packageName
  
  Fetches app details for this edit. This includes the default language and developer support contact information."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn details-patch$
  "Required parameters: editId,packageName
  
  Updates app details for this edit. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn details-update$
  "Required parameters: editId,packageName
  
  Updates app details for this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/details"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testers-get$
  "Required parameters: editId,packageName,track
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testers-patch$
  "Required parameters: editId,packageName,track
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testers-update$
  "Required parameters: editId,packageName,track
  
  "
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"track" "editId" "packageName"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/testers/{track}"
     #{"track" "editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-delete$
  "Required parameters: editId,language,packageName
  
  Deletes the specified localized store listing from an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName" "language"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{"editId" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-deleteall$
  "Required parameters: editId,packageName
  
  Deletes all localized listings from an edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-get$
  "Required parameters: editId,language,packageName
  
  Fetches information about a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName" "language"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{"editId" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-list$
  "Required parameters: editId,packageName
  
  Returns all of the localized store listings attached to this edit."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings"
     #{"editId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-patch$
  "Required parameters: editId,language,packageName
  
  Creates or updates a localized store listing. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName" "language"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{"editId" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listings-update$
  "Required parameters: editId,language,packageName
  
  Creates or updates a localized store listing."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"editId" "packageName" "language"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/listings/{language}"
     #{"editId" "packageName" "language"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-get$
  "Required parameters: apkVersionCode,editId,expansionFileType,packageName
  
  Fetches the Expansion File configuration for the APK specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"apkVersionCode"
            "editId"
            "expansionFileType"
            "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{"apkVersionCode" "editId" "expansionFileType" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-patch$
  "Required parameters: apkVersionCode,editId,expansionFileType,packageName
  
  Updates the APK's Expansion File configuration to reference another APK's Expansion Files. To add a new Expansion File use the Upload method. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"apkVersionCode"
            "editId"
            "expansionFileType"
            "packageName"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{"apkVersionCode" "editId" "expansionFileType" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-update$
  "Required parameters: apkVersionCode,editId,expansionFileType,packageName
  
  Updates the APK's Expansion File configuration to reference another APK's Expansion Files. To add a new Expansion File use the Upload method."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"apkVersionCode"
            "editId"
            "expansionFileType"
            "packageName"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{"apkVersionCode" "editId" "expansionFileType" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn expansionfiles-upload$
  "Required parameters: apkVersionCode,editId,expansionFileType,packageName
  
  Uploads and attaches a new Expansion File to the APK specified."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"apkVersionCode"
            "editId"
            "expansionFileType"
            "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/edits/{editId}/apks/{apkVersionCode}/expansionFiles/{expansionFileType}"
     #{"apkVersionCode" "editId" "expansionFileType" "packageName"}
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
