(ns happygapi.bigquery.routines
  "BigQuery API: routines.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/routines"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/get
  
  Required parameters: datasetId, routineId, projectId
  
  Optional parameters: readMask
  
  Gets the specified routine resource by routine ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/update
  
  Required parameters: routineId, projectId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :importedLibraries [string],
   :arguments [{:name string,
                :mode string,
                :argumentKind string,
                :dataType StandardSqlDataType}],
   :etag string,
   :returnType {:arrayElementType StandardSqlDataType,
                :typeKind string,
                :structType StandardSqlStructType},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:datasetId string,
                      :routineId string,
                      :projectId string},
   :returnTableType {:columns [StandardSqlField]},
   :determinismLevel string,
   :strictMode boolean}
  
  Updates information in an existing routine. The update method replaces the entire Routine resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/list
  
  Required parameters: projectId, datasetId
  
  Optional parameters: readMask, maxResults, filter, pageToken
  
  Lists all routines in the specified dataset. Requires the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/delete
  
  Required parameters: routineId, datasetId, projectId
  
  Optional parameters: none
  
  Deletes the routine specified by routineId from the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/insert
  
  Required parameters: projectId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :importedLibraries [string],
   :arguments [{:name string,
                :mode string,
                :argumentKind string,
                :dataType StandardSqlDataType}],
   :etag string,
   :returnType {:arrayElementType StandardSqlDataType,
                :typeKind string,
                :structType StandardSqlStructType},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:datasetId string,
                      :routineId string,
                      :projectId string},
   :returnTableType {:columns [StandardSqlField]},
   :determinismLevel string,
   :strictMode boolean}
  
  Creates a new routine in the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines"
     #{:datasetId :projectId}
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
