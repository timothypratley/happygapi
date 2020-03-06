(ns happygapi.bigquery.tables
  "BigQuery API: tables.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/tables"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/insert
  
  Required parameters: projectId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :selfLink string,
   :type string,
   :etag string,
   :timePartitioning {:field string,
                      :expirationMs string,
                      :type string,
                      :requirePartitionFilter boolean},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :csvOptions CsvOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :hivePartitioningMode string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:tableId string,
                    :projectId string,
                    :datasetId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:interval string,
                               :start string,
                               :end string}},
   :kind string,
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :location string,
   :materializedView {:query string,
                      :enableRefresh boolean,
                      :refreshIntervalMs string,
                      :lastRefreshTime string},
   :encryptionConfiguration {:kmsKeyName string},
   :view {:userDefinedFunctionResources [UserDefinedFunctionResource],
          :useLegacySql boolean,
          :query string},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Creates a new, empty table in the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables"
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/get
  
  Required parameters: projectId, datasetId, tableId
  
  Optional parameters: selectedFields
  Gets the specified table resource by table ID. This method does not return the data in the table, it only returns the table resource, which describes the structure of this table."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/bigquery.readonly"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/patch
  
  Required parameters: tableId, projectId, datasetId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :selfLink string,
   :type string,
   :etag string,
   :timePartitioning {:field string,
                      :expirationMs string,
                      :type string,
                      :requirePartitionFilter boolean},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :csvOptions CsvOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :hivePartitioningMode string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:tableId string,
                    :projectId string,
                    :datasetId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:interval string,
                               :start string,
                               :end string}},
   :kind string,
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :location string,
   :materializedView {:query string,
                      :enableRefresh boolean,
                      :refreshIntervalMs string,
                      :lastRefreshTime string},
   :encryptionConfiguration {:kmsKeyName string},
   :view {:userDefinedFunctionResources [UserDefinedFunctionResource],
          :useLegacySql boolean,
          :query string},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
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

(defn update$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/update
  
  Required parameters: projectId, datasetId, tableId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :selfLink string,
   :type string,
   :etag string,
   :timePartitioning {:field string,
                      :expirationMs string,
                      :type string,
                      :requirePartitionFilter boolean},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :csvOptions CsvOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :hivePartitioningMode string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:tableId string,
                    :projectId string,
                    :datasetId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:interval string,
                               :start string,
                               :end string}},
   :kind string,
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :location string,
   :materializedView {:query string,
                      :enableRefresh boolean,
                      :refreshIntervalMs string,
                      :lastRefreshTime string},
   :encryptionConfiguration {:kmsKeyName string},
   :view {:userDefinedFunctionResources [UserDefinedFunctionResource],
          :useLegacySql boolean,
          :query string},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
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

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/delete
  
  Required parameters: datasetId, tableId, projectId
  
  Optional parameters: none
  Deletes the table specified by tableId from the dataset. If the table contains data, all the data will be deleted."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/list
  
  Required parameters: projectId, datasetId
  
  Optional parameters: maxResults, pageToken
  Lists all tables in the specified dataset. Requires the READER dataset role."
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
     "projects/{projectId}/datasets/{datasetId}/tables"
     #{:datasetId :projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
