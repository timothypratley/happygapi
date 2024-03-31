(ns happygapi.androidmanagement.provisioningInfo
  "Android Management API: provisioningInfo.
  The Android Management API provides remote enterprise management of Android devices and apps.
  See: https://developers.google.com/android/managementapi/reference/rest/v1/provisioningInfo"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/managementapi/reference/rest/v1/provisioningInfo/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the device provisioning information by the identifier provided in the sign-in url."
  {:scopes ["https://www.googleapis.com/auth/androidmanagement"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidmanagement.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
