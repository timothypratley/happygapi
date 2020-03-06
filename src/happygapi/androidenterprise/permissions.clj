(ns happygapi.androidenterprise.permissions
  "Google Play EMM API: permissions.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/permissions/get
  
  Required parameters: permissionId
  
  Optional parameters: language
  Retrieves details of an Android app permission for display to an enterprise admin."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:permissionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "permissions/{permissionId}"
     #{:permissionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
