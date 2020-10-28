(ns happygapi.androidenterprise.managedconfigurationssettings
  "Google Play EMM API: managedconfigurationssettings.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationssettings"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationssettings/list
  
  Required parameters: productId, enterpriseId
  
  Optional parameters: none
  
  Lists all the managed configurations settings for the specified app."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :productId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/products/{productId}/managedConfigurationsSettings"
     #{:enterpriseId :productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
