(ns happygapi.androidenterprise.managedconfigurationsforuser
  "Google Play EMM API: managedconfigurationsforuser.
  Manages the deployment of apps to Android for Work users.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsforuser"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsforuser/delete
  
  Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Removes a per-user managed configuration for an app for the specified user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :managedConfigurationForUserId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{:enterpriseId :managedConfigurationForUserId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsforuser/get
  
  Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Retrieves details of a per-user managed configuration for an app for the specified user."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :managedConfigurationForUserId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{:enterpriseId :managedConfigurationForUserId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsforuser/list
  
  Required parameters: enterpriseId, userId
  
  Optional parameters: none
  
  Lists all the per-user managed configurations for the specified user. Only the ID is set."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser"
     #{:enterpriseId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/managedconfigurationsforuser/update
  
  Required parameters: enterpriseId, managedConfigurationForUserId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:configurationVariables {:kind string,
                            :mcmId string,
                            :variableSet [VariableSet]},
   :kind string,
   :managedProperty [{:key string,
                      :valueBool boolean,
                      :valueBundle ManagedPropertyBundle,
                      :valueBundleArray [ManagedPropertyBundle],
                      :valueInteger integer,
                      :valueString string,
                      :valueStringArray [string]}],
   :productId string}
  
  Adds or updates the managed configuration settings for an app for the specified user. If you support the Managed configurations iframe, you can apply managed configurations to a user by specifying an mcmId and its associated configuration variables (if any) in the request. Alternatively, all EMMs can apply managed configurations by passing a list of managed properties."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :managedConfigurationForUserId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/androidenterprise/v1/"
     "enterprises/{enterpriseId}/users/{userId}/managedConfigurationsForUser/{managedConfigurationForUserId}"
     #{:enterpriseId :managedConfigurationForUserId :userId}
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
