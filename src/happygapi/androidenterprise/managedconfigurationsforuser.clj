(ns happygapi.androidenterprise.managedconfigurationsforuser
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
  "Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Removes a per-user managed configuration for an app for the specified user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"managedConfigurationForUserId" "enterpriseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{"managedConfigurationForUserId" "enterpriseId" "userId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Retrieves details of a per-user managed configuration for an app for the specified user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"managedConfigurationForUserId" "enterpriseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{"managedConfigurationForUserId" "enterpriseId" "userId"}
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
  
  Lists all the per-user managed configurations for the specified user. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args]
  {:pre [(util/has-keys? args #{"enterpriseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser"
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
  "Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Adds or updates the managed configuration settings for an app for the specified user. If you support the Managed configurations iframe, you can apply managed configurations to a user by specifying an mcmId and its associated configuration variables (if any) in the request. Alternatively, all EMMs can apply managed configurations by passing a list of managed properties."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"managedConfigurationForUserId" "enterpriseId" "userId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{"managedConfigurationForUserId" "enterpriseId" "userId"}
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
