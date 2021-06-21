(ns happygapi.androidenterprise.storelayoutpages
  "Google Play EMM API: storelayoutpages.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages/delete
  
  Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Deletes a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :pageId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{:enterpriseId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages/get
  
  Required parameters: pageId, enterpriseId
  
  Optional parameters: none
  
  Retrieves details of a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :pageId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{:enterpriseId :pageId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages/insert
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Body: 
  
  {:link [string], :name [{:locale string, :text string}], :id string}
  
  Inserts a new store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages"
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

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages/list
  
  Required parameters: enterpriseId
  
  Optional parameters: none
  
  Retrieves the details of all pages in the store."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages"
     #{:enterpriseId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutpages/update
  
  Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Body: 
  
  {:link [string], :name [{:locale string, :text string}], :id string}
  
  Updates the content of a store page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId :pageId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}"
     #{:enterpriseId :pageId}
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
