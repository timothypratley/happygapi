(ns happygapi.cloudasset.savedQueries
  "Cloud Asset API: savedQueries.
  The Cloud Asset API manages the history and inventory of Google Cloud resources.
  See: https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries/create
  
  Required parameters: parent
  
  Optional parameters: savedQueryId
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :creator string,
   :lastUpdateTime string,
   :lastUpdater string,
   :labels {},
   :content {:iamPolicyAnalysisQuery IamPolicyAnalysisQuery}}
  
  Creates a saved query in a parent project/folder/organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}/savedQueries"
     #{:parent}
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details about a saved query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists all saved queries in a parent project/folder/organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+parent}/savedQueries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :createTime string,
   :creator string,
   :lastUpdateTime string,
   :lastUpdater string,
   :labels {},
   :content {:iamPolicyAnalysisQuery IamPolicyAnalysisQuery}}
  
  Updates a saved query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
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
  "https://cloud.google.com/asset-inventory/docs/quickstartapi/reference/rest/v1/savedQueries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a saved query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudasset.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
