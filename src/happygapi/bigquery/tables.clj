(ns happygapi.bigquery.tables
  "BigQuery API: tables.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/api/reference/rest/v2/tables"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/tables/get
  
  Required parameters: datasetId, projectId, tableId
  
  Optional parameters: selectedFields, view
  
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
     "projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}"
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
  
  {:policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :version integer},
   :updateMask string}
  
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
   :maxStaleness string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numTimeTravelPhysicalBytes string,
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :tableReplicationInfo {:replicatedSourceLastRefreshTime string,
                          :replicationError ErrorProto,
                          :replicationIntervalMs string,
                          :replicationStatus string,
                          :sourceTable TableReference},
   :numLongTermLogicalBytes string,
   :materializedViewStatus {:lastRefreshStatus ErrorProto,
                            :refreshWatermark string},
   :selfLink string,
   :type string,
   :etag string,
   :numTotalLogicalBytes string,
   :timePartitioning {:expirationMs string,
                      :field string,
                      :requirePartitionFilter boolean,
                      :type string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :fileSetSpecType string,
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
                               :maxBadRecords integer,
                               :jsonOptions JsonOptions,
                               :objectMetadata string,
                               :referenceFileSchemaUri string,
                               :metadataCacheMode string,
                               :jsonExtension string},
   :lastModifiedTime string,
   :partitionDefinition {:partitionedColumn [PartitionedColumn]},
   :resourceTags {},
   :defaultRoundingMode string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:end string,
                               :interval string,
                               :start string}},
   :kind string,
   :replicas [{:datasetId string, :projectId string, :tableId string}],
   :defaultCollation string,
   :cloneDefinition {:baseTableReference TableReference,
                     :cloneTime string},
   :numPartitions string,
   :numActiveLogicalBytes string,
   :tableConstraints {:foreignKeys [{:columnReferences [{:referencedColumn string,
                                                         :referencingColumn string}],
                                     :name string,
                                     :referencedTable {:datasetId string,
                                                       :projectId string,
                                                       :tableId string}}],
                      :primaryKey {:columns [string]}},
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :numActivePhysicalBytes string,
   :biglakeConfiguration {:connectionId string,
                          :fileFormat string,
                          :storageUri string,
                          :tableFormat string},
   :location string,
   :numLongTermPhysicalBytes string,
   :materializedView {:allowNonIncrementalDefinition boolean,
                      :enableRefresh boolean,
                      :lastRefreshTime string,
                      :maxStaleness string,
                      :query string,
                      :refreshIntervalMs string},
   :encryptionConfiguration {:kmsKeyName string},
   :numTotalPhysicalBytes string,
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:privacyPolicy PrivacyPolicy,
          :query string,
          :useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
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
     "projects/{+projectId}/datasets/{+datasetId}/tables"
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
  
  Optional parameters: autodetect_schema
  
  Body: 
  
  {:creationTime string,
   :description string,
   :maxStaleness string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numTimeTravelPhysicalBytes string,
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :tableReplicationInfo {:replicatedSourceLastRefreshTime string,
                          :replicationError ErrorProto,
                          :replicationIntervalMs string,
                          :replicationStatus string,
                          :sourceTable TableReference},
   :numLongTermLogicalBytes string,
   :materializedViewStatus {:lastRefreshStatus ErrorProto,
                            :refreshWatermark string},
   :selfLink string,
   :type string,
   :etag string,
   :numTotalLogicalBytes string,
   :timePartitioning {:expirationMs string,
                      :field string,
                      :requirePartitionFilter boolean,
                      :type string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :fileSetSpecType string,
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
                               :maxBadRecords integer,
                               :jsonOptions JsonOptions,
                               :objectMetadata string,
                               :referenceFileSchemaUri string,
                               :metadataCacheMode string,
                               :jsonExtension string},
   :lastModifiedTime string,
   :partitionDefinition {:partitionedColumn [PartitionedColumn]},
   :resourceTags {},
   :defaultRoundingMode string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:end string,
                               :interval string,
                               :start string}},
   :kind string,
   :replicas [{:datasetId string, :projectId string, :tableId string}],
   :defaultCollation string,
   :cloneDefinition {:baseTableReference TableReference,
                     :cloneTime string},
   :numPartitions string,
   :numActiveLogicalBytes string,
   :tableConstraints {:foreignKeys [{:columnReferences [{:referencedColumn string,
                                                         :referencingColumn string}],
                                     :name string,
                                     :referencedTable {:datasetId string,
                                                       :projectId string,
                                                       :tableId string}}],
                      :primaryKey {:columns [string]}},
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :numActivePhysicalBytes string,
   :biglakeConfiguration {:connectionId string,
                          :fileFormat string,
                          :storageUri string,
                          :tableFormat string},
   :location string,
   :numLongTermPhysicalBytes string,
   :materializedView {:allowNonIncrementalDefinition boolean,
                      :enableRefresh boolean,
                      :lastRefreshTime string,
                      :maxStaleness string,
                      :query string,
                      :refreshIntervalMs string},
   :encryptionConfiguration {:kmsKeyName string},
   :numTotalPhysicalBytes string,
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:privacyPolicy PrivacyPolicy,
          :query string,
          :useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire table resource, whereas the patch method only replaces fields that are provided in the submitted table resource. This method supports RFC5789 patch semantics."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}"
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
  
  Required parameters: datasetId, projectId, tableId
  
  Optional parameters: autodetect_schema
  
  Body: 
  
  {:creationTime string,
   :description string,
   :maxStaleness string,
   :numBytes string,
   :schema {:fields [TableFieldSchema]},
   :labels {},
   :numTimeTravelPhysicalBytes string,
   :numLongTermBytes string,
   :numPhysicalBytes string,
   :numRows string,
   :expirationTime string,
   :tableReplicationInfo {:replicatedSourceLastRefreshTime string,
                          :replicationError ErrorProto,
                          :replicationIntervalMs string,
                          :replicationStatus string,
                          :sourceTable TableReference},
   :numLongTermLogicalBytes string,
   :materializedViewStatus {:lastRefreshStatus ErrorProto,
                            :refreshWatermark string},
   :selfLink string,
   :type string,
   :etag string,
   :numTotalLogicalBytes string,
   :timePartitioning {:expirationMs string,
                      :field string,
                      :requirePartitionFilter boolean,
                      :type string},
   :requirePartitionFilter boolean,
   :externalDataConfiguration {:schema TableSchema,
                               :bigtableOptions BigtableOptions,
                               :connectionId string,
                               :csvOptions CsvOptions,
                               :fileSetSpecType string,
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
                               :maxBadRecords integer,
                               :jsonOptions JsonOptions,
                               :objectMetadata string,
                               :referenceFileSchemaUri string,
                               :metadataCacheMode string,
                               :jsonExtension string},
   :lastModifiedTime string,
   :partitionDefinition {:partitionedColumn [PartitionedColumn]},
   :resourceTags {},
   :defaultRoundingMode string,
   :clustering {:fields [string]},
   :friendlyName string,
   :tableReference {:datasetId string,
                    :projectId string,
                    :tableId string},
   :id string,
   :rangePartitioning {:field string,
                       :range {:end string,
                               :interval string,
                               :start string}},
   :kind string,
   :replicas [{:datasetId string, :projectId string, :tableId string}],
   :defaultCollation string,
   :cloneDefinition {:baseTableReference TableReference,
                     :cloneTime string},
   :numPartitions string,
   :numActiveLogicalBytes string,
   :tableConstraints {:foreignKeys [{:columnReferences [{:referencedColumn string,
                                                         :referencingColumn string}],
                                     :name string,
                                     :referencedTable {:datasetId string,
                                                       :projectId string,
                                                       :tableId string}}],
                      :primaryKey {:columns [string]}},
   :streamingBuffer {:estimatedBytes string,
                     :estimatedRows string,
                     :oldestEntryTime string},
   :numActivePhysicalBytes string,
   :biglakeConfiguration {:connectionId string,
                          :fileFormat string,
                          :storageUri string,
                          :tableFormat string},
   :location string,
   :numLongTermPhysicalBytes string,
   :materializedView {:allowNonIncrementalDefinition boolean,
                      :enableRefresh boolean,
                      :lastRefreshTime string,
                      :maxStaleness string,
                      :query string,
                      :refreshIntervalMs string},
   :encryptionConfiguration {:kmsKeyName string},
   :numTotalPhysicalBytes string,
   :snapshotDefinition {:baseTableReference TableReference,
                        :snapshotTime string},
   :view {:privacyPolicy PrivacyPolicy,
          :query string,
          :useExplicitColumnNames boolean,
          :useLegacySql boolean,
          :userDefinedFunctionResources [UserDefinedFunctionResource]},
   :model {:modelOptions {:labels [string],
                          :lossType string,
                          :modelType string},
           :trainingRuns [BqmlTrainingRun]}}
  
  Updates information in an existing table. The update method replaces the entire Table resource, whereas the patch method only replaces fields that are provided in the submitted Table resource."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:tableId :datasetId :projectId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://bigquery.googleapis.com/bigquery/v2/"
     "projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}"
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
     "projects/{+projectId}/datasets/{+datasetId}/tables/{+tableId}"
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
  
  Required parameters: datasetId, projectId
  
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
     "projects/{+projectId}/datasets/{+datasetId}/tables"
     #{:datasetId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
