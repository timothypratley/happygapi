(ns happygapi.bigquery.routines
  "BigQuery API: routines.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/routines"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/delete
  
  Required parameters: projectId, datasetId, routineId
  
  Optional parameters: none
  Deletes the routine specified by routineId from the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
                :argumentKind string,
                :mode string,
                :dataType StandardSqlDataType}],
   :etag string,
   :returnType {:structType StandardSqlStructType,
                :arrayElementType StandardSqlDataType,
                :typeKind string},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:projectId string,
                      :datasetId string,
                      :routineId string}}
  
  Creates a new routine in the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines"
     #{:datasetId :projectId}
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

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/get
  
  Required parameters: projectId, datasetId, routineId
  
  Optional parameters: readMask
  Gets the specified routine resource by routine ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/list
  
  Required parameters: datasetId, projectId
  
  Optional parameters: readMask, filter, pageToken, maxResults
  Lists all routines in the specified dataset. Requires the READER dataset
  role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines"
     #{:datasetId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/update
  
  Required parameters: projectId, datasetId, routineId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :importedLibraries [string],
   :arguments [{:name string,
                :argumentKind string,
                :mode string,
                :dataType StandardSqlDataType}],
   :etag string,
   :returnType {:structType StandardSqlStructType,
                :arrayElementType StandardSqlDataType,
                :typeKind string},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:projectId string,
                      :datasetId string,
                      :routineId string}}
  
  Updates information in an existing routine. The update method replaces the
  entire Routine resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:datasetId :projectId :routineId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/routines/{+routineId}"
     #{:datasetId :projectId :routineId}
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
