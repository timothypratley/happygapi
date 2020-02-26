(ns happygapi.androidenterprise.entitlements
  "Google Play EMM API
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-api"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "androidenterprise_schema.edn"))))

(defn delete$
  "Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: none
  
  Removes an entitlement to an app for a user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId" "userId" "entitlementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{"enterpriseId" "userId" "entitlementId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: none
  
  Retrieves details of an entitlement."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId" "userId" "entitlementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{"enterpriseId" "userId" "entitlementId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: enterpriseId, userId
  
  Optional parameters: none
  
  Lists all entitlements for the specified user. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"enterpriseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements"
     #{"enterpriseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: enterpriseId, entitlementId, userId
  
  Optional parameters: install
  
  Adds or updates an entitlement to an app for a user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"enterpriseId" "userId" "entitlementId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/entitlements/{entitlementId}"
     #{"enterpriseId" "userId" "entitlementId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
