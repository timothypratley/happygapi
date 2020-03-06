(ns happygapi.androidenterprise.entitlements
  "Google Play EMM API: entitlements.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/entitlements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/entitlements/delete
  
  Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: none
  Removes an entitlement to an app for a user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :entitlementId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{:enterpriseId :entitlementId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/entitlements/get
  
  Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: none
  Retrieves details of an entitlement."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :entitlementId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{:enterpriseId :entitlementId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/entitlements/list
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  Lists all entitlements for the specified user. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{:enterpriseId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements"
     #{:enterpriseId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/entitlements/update
  
  Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: install
  
  Body: 
  
  {:kind string, :productId string, :reason string}
  
  Adds or updates an entitlement to an app for a user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:enterpriseId :entitlementId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{:enterpriseId :entitlementId :userId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
