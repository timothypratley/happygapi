(ns happygapi.storagetransfer.projects
  "Storage Transfer API: projects.
  Transfers data from external data sources to a Google Cloud Storage bucket or between Google Cloud Storage buckets. 
  See: https://cloud.google.com/storage-transfer/docsdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn agentPools-create$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/projects/agentPools/create
  
  Required parameters: projectId
  
  Optional parameters: agentPoolId
  
  Body: 
  
  {:name string,
   :displayName string,
   :state string,
   :bandwidthLimit {:limitMbps string}}
  
  Creates an agent pool resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/projects/{+projectId}/agentPools"
     #{:projectId}
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

(defn agentPools-patch$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/projects/agentPools/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :state string,
   :bandwidthLimit {:limitMbps string}}
  
  Updates an existing agent pool resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storagetransfer.googleapis.com/"
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

(defn agentPools-get$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/projects/agentPools/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an agent pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
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

(defn agentPools-list$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/projects/agentPools/list
  
  Required parameters: projectId
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists agent pools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storagetransfer.googleapis.com/"
     "v1/projects/{+projectId}/agentPools"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn agentPools-delete$
  "https://cloud.google.com/storage-transfer/docsapi/reference/rest/v1/projects/agentPools/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an agent pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storagetransfer.googleapis.com/"
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
