(ns happygapi.androidenterprise.devices
  "Google Play EMM API: devices.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setState$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/setState
  
  Required parameters: enterpriseId, deviceId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:accountState string}
  
  Sets whether a device's access to Google services is enabled or disabled. The device state takes effect only if enforcing EMM policies on Android devices is enabled in the Google Admin Console. Otherwise, the device state is ignored and all devices are allowed access to Google services. This is only supported for Google-managed users."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/state"
     #{:enterpriseId :deviceId :userId}
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

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/update
  
  Required parameters: userId, deviceId, enterpriseId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:policy {:productAvailabilityPolicy string,
            :deviceReportPolicy string,
            :productPolicy [ProductPolicy],
            :autoUpdatePolicy string,
            :maintenanceWindow MaintenanceWindow},
   :managementType string,
   :report {:appState [AppState], :lastUpdatedTimestampMillis string},
   :androidId string}
  
  Updates the device policy. To ensure the policy is properly enforced, you need to prevent unmanaged accounts from accessing Google Play by setting the allowed_accounts in the managed configuration for the Google Play package. See restrict accounts in Google Play."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}"
     #{:enterpriseId :deviceId :userId}
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

(defn forceReportUpload$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/forceReportUpload
  
  Required parameters: userId, enterpriseId, deviceId
  
  Optional parameters: none
  
  Uploads a report containing any changes in app states on the device since the last report was generated. You can call this method up to 3 times every 24 hours for a given device. If you exceed the quota, then the Google Play EMM API returns HTTP 429 Too Many Requests."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/forceReportUpload"
     #{:enterpriseId :deviceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/get
  
  Required parameters: enterpriseId, userId, deviceId
  
  Optional parameters: none
  
  Retrieves the details of a device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}"
     #{:enterpriseId :deviceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getState$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/getState
  
  Required parameters: enterpriseId, deviceId, userId
  
  Optional parameters: none
  
  Retrieves whether a device's access to Google services is enabled or disabled. The device state takes effect only if enforcing EMM policies on Android devices is enabled in the Google Admin Console. Otherwise, the device state is ignored and all devices are allowed access to Google services. This is only supported for Google-managed users."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/state"
     #{:enterpriseId :deviceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/devices/list
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  
  Retrieves the IDs of all of a user's devices."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/users/{userId}/devices"
     #{:enterpriseId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
