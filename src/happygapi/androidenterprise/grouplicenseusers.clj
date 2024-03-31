(ns happygapi.androidenterprise.grouplicenseusers
  "Google Play EMM API: grouplicenseusers.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/grouplicenseusers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/grouplicenseusers/list
  
  Required parameters: enterpriseId, groupLicenseId
  
  Optional parameters: none
  
  Retrieves the IDs of the users who have been granted entitlements under the license. **Note:** This item has been deprecated. New integrations cannot use this method and can refer to our new recommendations."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :groupLicenseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/groupLicenses/{groupLicenseId}/users"
     #{:enterpriseId :groupLicenseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
