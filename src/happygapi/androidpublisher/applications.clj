(ns happygapi.androidpublisher.applications
  "Google Play Android Developer API: applications.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherdocs/reference/rest/v3/applications"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn dataSafety$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/applications/dataSafety
  
  Required parameters: packageName
  
  Optional parameters: none
  
  Body: 
  
  {:safetyLabels string}
  
  Writes the Safety Labels declaration of an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/dataSafety"
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

(defn deviceTierConfigs-create$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/applications/deviceTierConfigs/create
  
  Required parameters: packageName
  
  Optional parameters: allowUnknownDevices
  
  Body: 
  
  {:deviceTierConfigId string,
   :deviceGroups [{:name string, :deviceSelectors [DeviceSelector]}],
   :deviceTierSet {:deviceTiers [DeviceTier]},
   :userCountrySets [{:name string, :countryCodes [string]}]}
  
  Creates a new device tier config for an app."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/deviceTierConfigs"
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

(defn deviceTierConfigs-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/applications/deviceTierConfigs/get
  
  Required parameters: packageName, deviceTierConfigId
  
  Optional parameters: none
  
  Returns a particular device tier config."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :deviceTierConfigId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/deviceTierConfigs/{deviceTierConfigId}"
     #{:packageName :deviceTierConfigId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn deviceTierConfigs-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/applications/deviceTierConfigs/list
  
  Required parameters: packageName
  
  Optional parameters: pageSize, pageToken
  
  Returns created device tier configs, ordered by descending creation time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/applications/{packageName}/deviceTierConfigs"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
