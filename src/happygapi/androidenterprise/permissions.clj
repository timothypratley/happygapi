(ns happygapi.androidenterprise.permissions
  "Google Play EMM API: permissions.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apidocs/reference/rest/v1/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/permissions/get
  
  Required parameters: permissionId
  
  Optional parameters: language
  
  Retrieves details of an Android app permission for display to an enterprise admin."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:permissionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/permissions/{permissionId}"
     #{:permissionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
