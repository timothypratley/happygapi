(ns happygapi.androidpublisher.apprecovery
  "Google Play Android Developer API: apprecovery.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherdocs/reference/rest/v3/apprecovery"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/apprecovery/create
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:targeting {:regions Regions,
               :androidSdks AndroidSdks,
               :allUsers AllUsers,
               :versionList AppVersionList,
               :versionRange AppVersionRange},
   :remoteInAppUpdate {:isRemoteInAppUpdateRequested boolean}}
  
  Create an app recovery action with recovery status as DRAFT. Note that this action does not execute the recovery action."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/appRecoveries"
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

(defn deploy$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/apprecovery/deploy
  
  Required parameters: packageName, appRecoveryId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deploy an already created app recovery action with recovery status DRAFT. Note that this action activates the recovery action for all targeted users and changes its status to ACTIVE."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :appRecoveryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:deploy"
     #{:packageName :appRecoveryId}
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

(defn appRecoveries$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/apprecovery/appRecoveries
  
  Required parameters: packageName
  
  Optional parameters: versionCode
  
  List all app recovery action resources associated with a particular package name and app version."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/appRecoveries"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addTargeting$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/apprecovery/addTargeting
  
  Required parameters: packageName, appRecoveryId
  
  Optional parameters: none
  
  Body: 
  
  {:targetingUpdate {:regions Regions,
                     :androidSdks AndroidSdks,
                     :allUsers AllUsers}}
  
  Incrementally update targeting for a recovery action. Note that only the criteria selected during the creation of recovery action can be expanded."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :appRecoveryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:addTargeting"
     #{:packageName :appRecoveryId}
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

(defn cancel$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/apprecovery/cancel
  
  Required parameters: packageName, appRecoveryId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancel an already executing app recovery action. Note that this action changes status of the recovery action to CANCELED."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :appRecoveryId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/appRecoveries/{appRecoveryId}:cancel"
     #{:packageName :appRecoveryId}
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
