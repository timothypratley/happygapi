(ns happygapi.androidenterprise.installs
  "Google Play EMM API: installs.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/installs"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/installs/delete
  
  Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Requests to remove an app from a device. A call to get or list will still show the app as installed on the device until it is actually removed."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :installId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{:enterpriseId :deviceId :installId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/installs/get
  
  Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Retrieves details of an installation of an app on a device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :installId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{:enterpriseId :deviceId :installId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/installs/list
  
  Required parameters: deviceId, enterpriseId, userId
  
  Optional parameters: none
  
  Retrieves the details of all apps installed on the specified device."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs"
     #{:enterpriseId :deviceId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/installs/update
  
  Required parameters: deviceId, enterpriseId, installId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:installState string,
   :kind string,
   :productId string,
   :versionCode integer}
  
  Requests to install the latest version of an app to a device. If the app is already installed, then it is updated to the latest version if necessary."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :deviceId :installId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/devices/{deviceId}/installs/{installId}"
     #{:enterpriseId :deviceId :installId :userId}
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
