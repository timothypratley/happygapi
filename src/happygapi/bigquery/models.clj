(ns happygapi.bigquery.models
  "BigQuery API: models.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/models"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/get
  
  Required parameters: datasetId, modelId, projectId
  
  Optional parameters: none
  
  Gets the specified model resource by model ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:modelId :datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}"
     #{:modelId :datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/list
  
  Required parameters: datasetId, projectId
  
  Optional parameters: pageToken, maxResults
  
  Lists all models in the specified dataset. Requires the READER dataset
  role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/models"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/patch
  
  Required parameters: projectId, datasetId, modelId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :modelType string,
   :expirationTime string,
   :etag string,
   :lastModifiedTime string,
   :friendlyName string,
   :trainingRuns [{:startTime string,
                   :results [IterationResult],
                   :evaluationMetrics EvaluationMetrics,
                   :trainingOptions TrainingOptions,
                   :dataSplitResult DataSplitResult}],
   :featureColumns [{:name string, :type StandardSqlDataType}],
   :labelColumns [{:name string, :type StandardSqlDataType}],
   :location string,
   :encryptionConfiguration {:kmsKeyName string},
   :modelReference {:datasetId string,
                    :modelId string,
                    :projectId string}}
  
  Patch specific fields in the specified model."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:modelId :datasetId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}"
     #{:modelId :datasetId :projectId}
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/delete
  
  Required parameters: datasetId, modelId, projectId
  
  Optional parameters: none
  
  Deletes the model specified by modelId from the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:modelId :datasetId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/models/{+modelId}"
     #{:modelId :datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
