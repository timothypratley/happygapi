(ns happygapi.androidenterprise.grouplicenses
  "Google Play EMM API: grouplicenses.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/grouplicenses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/grouplicenses/get
  
  Required parameters: enterpriseId, groupLicenseId
  
  Optional parameters: none
  
  Retrieves details of an enterprise's group license for a product."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :groupLicenseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/groupLicenses/{groupLicenseId}"
     #{:enterpriseId :groupLicenseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/grouplicenses/list
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Retrieves IDs of all products for which the enterprise has a group license."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/groupLicenses"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
