(ns happygapi.androidenterprise.managedconfigurationsfordevice
  "Google Play EMM API: managedconfigurationsfordevice.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsfordevice"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsfordevice/get
  
  Required parameters: managedConfigurationForDeviceId, deviceId, enterpriseId, userId
  
  Optional parameters: none
  
  Retrieves details of a per-device managed configuration."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId
            :deviceId
            :userId
            :managedConfigurationForDeviceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{:enterpriseId
       :deviceId
       :userId
       :managedConfigurationForDeviceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsfordevice/update
  
  Required parameters: userId, enterpriseId, deviceId, managedConfigurationForDeviceId
  
  Optional parameters: none
  
  Body: 
  
  {:configurationVariables {:variableSet [VariableSet], :mcmId string},
   :kind string,
   :productId string,
   :managedProperty [{:valueStringArray [string],
                      :key string,
                      :valueBundle ManagedPropertyBundle,
                      :valueBool boolean,
                      :valueBundleArray [ManagedPropertyBundle],
                      :valueInteger integer,
                      :valueString string}]}
  
  Adds or updates a per-device managed configuration for an app for the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId
            :deviceId
            :userId
            :managedConfigurationForDeviceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{:enterpriseId
       :deviceId
       :userId
       :managedConfigurationForDeviceId}
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

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsfordevice/list
  
  Required parameters: deviceId, enterpriseId, userId
  
  Optional parameters: none
  
  Lists all the per-device managed configurations for the specified device. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice"
     #{:enterpriseId :deviceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsfordevice/delete
  
  Required parameters: managedConfigurationForDeviceId, deviceId, enterpriseId, userId
  
  Optional parameters: none
  
  Removes a per-device managed configuration for an app for the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId
            :deviceId
            :userId
            :managedConfigurationForDeviceId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{:enterpriseId
       :deviceId
       :userId
       :managedConfigurationForDeviceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
