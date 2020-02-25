(ns happygapi.androidenterprise.installs
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
  "Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Requests to remove an app from a device. A call to get or list will still show the app as installed on the device until it is actually removed."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"installId" "enterpriseId" "userId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{"installId" "enterpriseId" "userId" "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Retrieves details of an installation of an app on a device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"installId" "enterpriseId" "userId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{"installId" "enterpriseId" "userId" "deviceId"}
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
  
  Retrieves the details of all apps installed on the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"enterpriseId" "userId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs"
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
  "Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Requests to install the latest version of an app to a device. If the app is already installed, then it is updated to the latest version if necessary."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"installId" "enterpriseId" "userId" "deviceId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{"installId" "enterpriseId" "userId" "deviceId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
