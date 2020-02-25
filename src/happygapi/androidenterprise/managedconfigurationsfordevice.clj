(ns happygapi.androidenterprise.managedconfigurationsfordevice
  "Google Play EMM API
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-api"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidenterprise_schema.edn"))))

(defn delete$
  "Required parameters: deviceId, enterpriseId, managedConfigurationForDeviceId, userId
  
  Optional parameters: none
  
  Removes a per-device managed configuration for an app for the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId"
            "userId"
            "managedConfigurationForDeviceId"
            "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{"enterpriseId"
       "userId"
       "managedConfigurationForDeviceId"
       "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: deviceId, enterpriseId, managedConfigurationForDeviceId, userId
  
  Optional parameters: none
  
  Retrieves details of a per-device managed configuration."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId"
            "userId"
            "managedConfigurationForDeviceId"
            "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{"enterpriseId"
       "userId"
       "managedConfigurationForDeviceId"
       "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: deviceId, enterpriseId, userId
  
  Optional parameters: none
  
  Lists all the per-device managed configurations for the specified device. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"enterpriseId" "userId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice"
     #{"enterpriseId" "userId" "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: deviceId, enterpriseId, managedConfigurationForDeviceId, userId
  
  Optional parameters: none
  
  Adds or updates a per-device managed configuration for an app for the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId"
            "userId"
            "managedConfigurationForDeviceId"
            "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/managedConfigurationsForDevice/{managedConfigurationForDeviceId}"
     #{"enterpriseId"
       "userId"
       "managedConfigurationForDeviceId"
       "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
