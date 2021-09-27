(ns happygapi.bigquery.tables
  "BigQuery API: tables.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/tables"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/get
  
  Required parameters: tableId, datasetId, projectId
  
  Optional parameters: selectedFields
  
  Gets the specified table resource by table ID. This method does not return the data in the table, it only returns the table resource, which describes the structure of this table."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:etag string,
            :bindings [Binding],
            :version integer,
            :auditConfigs [AuditConfig]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "{+resource}:setIamPolicy"
     #{:resource}
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

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/insert
  
  Required parameters: datasetId, projectId
  
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
   :timePartitioning {:type string,
                      :requirePartitionFilter boolean,
                      :field string,
                      :expirationMs string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :parquetOptions ParquetOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :avroOptions AvroOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :decimalTargetTypes [string],
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:range {:start string,
                               :interval string,
                               :end string},
                       :field string},
   :kind string,
   :defaultCollation string,
   :streamingBuffer {:estimatedBytes string,
                     :oldestEntryTime string,
                     :estimatedRows string},
   :location string,
   :materializedView {:enableRefresh boolean,
                      :lastRefreshTime string,
                      :refreshIntervalMs string,
                      :query string},
   :encryptionConfiguration {:kmsKeyName string},
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :query string,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:modelType string,
                          :labels [string],
                          :lossType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Creates a new, empty table in the dataset."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables"
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

(defn patch$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/patch
  
  Required parameters: datasetId, projectId, tableId
  
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
   :timePartitioning {:type string,
                      :requirePartitionFilter boolean,
                      :field string,
                      :expirationMs string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :parquetOptions ParquetOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :avroOptions AvroOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :decimalTargetTypes [string],
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:range {:start string,
                               :interval string,
                               :end string},
                       :field string},
   :kind string,
   :defaultCollation string,
   :streamingBuffer {:estimatedBytes string,
                     :oldestEntryTime string,
                     :estimatedRows string},
   :location string,
   :materializedView {:enableRefresh boolean,
                      :lastRefreshTime string,
                      :refreshIntervalMs string,
                      :query string},
   :encryptionConfiguration {:kmsKeyName string},
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :query string,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:modelType string,
                          :labels [string],
                          :lossType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
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

(defn testIamPermissions$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "{+resource}:testIamPermissions"
     #{:resource}
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/update
  
  Required parameters: tableId, datasetId, projectId
  
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
   :timePartitioning {:type string,
                      :requirePartitionFilter boolean,
                      :field string,
                      :expirationMs string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :parquetOptions ParquetOptions,
                               :autodetect boolean,
                               :compression string,
                               :sourceFormat string,
                               :ignoreUnknownValues boolean,
                               :googleSheetsOptions GoogleSheetsOptions,
                               :avroOptions AvroOptions,
                               :hivePartitioningOptions HivePartitioningOptions,
                               :decimalTargetTypes [string],
                               :sourceUris [string],
                               :maxBadRecords integer},
   :lastModifiedTime string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:range {:start string,
                               :interval string,
                               :end string},
                       :field string},
   :kind string,
   :defaultCollation string,
   :streamingBuffer {:estimatedBytes string,
                     :oldestEntryTime string,
                     :estimatedRows string},
   :location string,
   :materializedView {:enableRefresh boolean,
                      :lastRefreshTime string,
                      :refreshIntervalMs string,
                      :query string},
   :encryptionConfiguration {:kmsKeyName string},
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :query string,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:modelType string,
                          :labels [string],
                          :lossType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/delete
  
  Required parameters: datasetId, projectId, tableId
  
  Optional parameters: none
  
  Deletes the table specified by tableId from the dataset. If the table contains data, all the data will be deleted."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables/{tableId}"
     #{:tableId :datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "{+resource}:getIamPolicy"
     #{:resource}
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
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/list
  
  Required parameters: projectId, datasetId
  
  Optional parameters: maxResults, pageToken
  
  Lists all tables in the specified dataset. Requires the READER dataset role."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:datasetId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{projectId}/datasets/{datasetId}/tables"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
