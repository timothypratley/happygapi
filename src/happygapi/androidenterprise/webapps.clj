(ns happygapi.androidenterprise.webapps
  "Google Play EMM API: webapps.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps/get
  
  Required parameters: enterpriseId, webAppId
  
  Optional parameters: none
  
  Gets an existing web app."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :webAppId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}"
     #{:enterpriseId :webAppId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps/list
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Retrieves the details of all web apps for a given enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/webApps"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps/insert
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:webAppId string,
   :title string,
   :startUrl string,
   :icons [{:imageData string}],
   :displayMode string,
   :versionCode string,
   :isPublished boolean}
  
  Creates a new web app for the enterprise."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/webApps"
     #{:enterpriseId}
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

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps/update
  
  Required parameters: enterpriseId, webAppId
  
  Optional parameters: none
  
  Body: 
  
  {:webAppId string,
   :title string,
   :startUrl string,
   :icons [{:imageData string}],
   :displayMode string,
   :versionCode string,
   :isPublished boolean}
  
  Updates an existing web app."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId :webAppId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}"
     #{:enterpriseId :webAppId}
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

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/webapps/delete
  
  Required parameters: enterpriseId, webAppId
  
  Optional parameters: none
  
  Deletes an existing web app."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :webAppId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/webApps/{webAppId}"
     #{:enterpriseId :webAppId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
