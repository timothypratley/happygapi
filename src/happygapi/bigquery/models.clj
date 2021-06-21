(ns happygapi.bigquery.models
  "BigQuery API: models.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/models"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/delete
  
  Required parameters: modelId, projectId, datasetId
  
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

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/models/get
  
  Required parameters: modelId, datasetId, projectId
  
  Optional parameters: none
  
  Gets the specified model resource by model ID."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
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
  
  Required parameters: projectId, datasetId
  
  Optional parameters: pageToken, maxResults
  
  Lists all models in the specified dataset. Requires the READER dataset role. After retrieving the list of models, you can get information about a particular model by calling the models.get method."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
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
  
  Required parameters: projectId, modelId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :labels {},
   :modelType string,
   :expirationTime string,
   :bestTrialId string,
   :etag string,
   :lastModifiedTime string,
   :friendlyName string,
   :trainingRuns [{:trainingOptions TrainingOptions,
                   :dataSplitResult DataSplitResult,
                   :startTime string,
                   :evaluationMetrics EvaluationMetrics,
                   :globalExplanations [GlobalExplanation],
                   :results [IterationResult]}],
   :featureColumns [{:type StandardSqlDataType, :name string}],
   :labelColumns [{:type StandardSqlDataType, :name string}],
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
