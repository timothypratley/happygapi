(ns happygapi.androidenterprise.storelayoutclusters
  "Google Play EMM API: storelayoutclusters.
  Manages the deployment of apps to Android Enterprise devices.
  See: https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters/list
  
  Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Retrieves the details of all clusters on the specified page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:enterpriseId :pageId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters"
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
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters/insert
  
  Required parameters: enterpriseId, pageId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name [{:locale string, :text string}],
   :productId [string],
   :orderInPage string}
  
  Inserts a new cluster in a page."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:enterpriseId :pageId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters"
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

(defn get$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters/get
  
  Required parameters: enterpriseId, pageId, clusterId
  
  Optional parameters: none
  
  Retrieves details of a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :pageId :clusterId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{:enterpriseId :pageId :clusterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters/update
  
  Required parameters: enterpriseId, pageId, clusterId
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :name [{:locale string, :text string}],
   :productId [string],
   :orderInPage string}
  
  Updates a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :pageId :clusterId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{:enterpriseId :pageId :clusterId}
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
  "https://developers.google.com/android/work/play/emm-apiapi/reference/rest/v1/storelayoutclusters/delete
  
  Required parameters: enterpriseId, pageId, clusterId
  
  Optional parameters: none
  
  Deletes a cluster."
  {:scopes ["https://www.googleapis.com/auth/androidenterprise"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:enterpriseId :pageId :clusterId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://androidenterprise.googleapis.com/"
     "androidenterprise/v1/enterprises/{enterpriseId}/storeLayout/pages/{pageId}/clusters/{clusterId}"
     #{:enterpriseId :pageId :clusterId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
