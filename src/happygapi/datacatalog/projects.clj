(ns happygapi.datacatalog.projects
  "Google Cloud Data Catalog API: projects.
  A fully managed and highly scalable data discovery and metadata management service. 
  See: https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/create
  
  Required parameters: parent
  
  Optional parameters: entryGroupId
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :dataCatalogTimestamps {:createTime string,
                           :updateTime string,
                           :expireTime string}}
  
  Creates an entry group. An entry group contains logically related entries together with [Cloud Identity and Access Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can create, edit, and view entries within entry groups. Data Catalog automatically creates entry groups with names that start with the `@` symbol for the following resources: * BigQuery entries (`@bigquery`) * Pub/Sub topics (`@pubsub`) * Dataproc Metastore services (`@dataproc_metastore_{SERVICE_NAME_HASH}`) You can create your own entry groups for Cloud Storage fileset entries and custom entries together with the corresponding IAM policies. User-created entry groups can't contain the `@` symbol, it is reserved for automatically created groups. Entry groups, like entries, can be searched. A maximum of 10,000 entry groups may be created per organization across all locations. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/entryGroups"
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

(defn locations-entryGroups-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/get
  
  Required parameters: name
  
  Optional parameters: readMask
  
  Gets an entry group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :dataCatalogTimestamps {:createTime string,
                           :updateTime string,
                           :expireTime string}}
  
  Updates an entry group. You must enable the Data Catalog API in the project identified by the `entry_group.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes an entry group. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/entryGroups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-setIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets an access control policy for a resource. Replaces any existing policy. Supported resources are: - Tag templates - Entry groups Note: This method sets policies only within Data Catalog and can't be used to manage policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources synced with the Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-entryGroups-getIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-entryGroups-testIamPermissions$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-entryGroups-entries-modifyEntryContacts$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/modifyEntryContacts
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:contacts {:people [GoogleCloudDatacatalogV1ContactsPerson]}}
  
  Modifies contacts, part of the business context of an Entry. To call this method, you must have the `datacatalog.entries.updateContacts` IAM permission on the corresponding project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:modifyEntryContacts"
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

(defn locations-entryGroups-entries-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-entries-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :cloudBigtableSystemSpec {:instanceDisplayName string},
   :schema {:columns [GoogleCloudDatacatalogV1ColumnSchema]},
   :labels {},
   :bigqueryDateShardedSpec {:dataset string,
                             :tablePrefix string,
                             :shardCount string,
                             :latestShardResource string},
   :userSpecifiedSystem string,
   :sourceSystemTimestamps {:createTime string,
                            :updateTime string,
                            :expireTime string},
   :displayName string,
   :name string,
   :businessContext {:entryOverview GoogleCloudDatacatalogV1EntryOverview,
                     :contacts GoogleCloudDatacatalogV1Contacts},
   :datasetSpec {:vertexDatasetSpec GoogleCloudDatacatalogV1VertexDatasetSpec},
   :usageSignal {:updateTime string,
                 :usageWithinTimeRange {},
                 :commonUsageWithinTimeRange {},
                 :favoriteCount string},
   :filesetSpec {:dataplexFileset GoogleCloudDatacatalogV1DataplexFilesetSpec},
   :featureOnlineStoreSpec {:storageType string},
   :gcsFilesetSpec {:filePatterns [string],
                    :sampleGcsFileSpecs [GoogleCloudDatacatalogV1GcsFileSpec]},
   :type string,
   :bigqueryTableSpec {:tableSourceType string,
                       :viewSpec GoogleCloudDatacatalogV1ViewSpec,
                       :tableSpec GoogleCloudDatacatalogV1TableSpec},
   :serviceSpec {:cloudBigtableInstanceSpec GoogleCloudDatacatalogV1CloudBigtableInstanceSpec},
   :linkedResource string,
   :routineSpec {:routineType string,
                 :language string,
                 :routineArguments [GoogleCloudDatacatalogV1RoutineSpecArgument],
                 :returnType string,
                 :definitionBody string,
                 :bigqueryRoutineSpec GoogleCloudDatacatalogV1BigQueryRoutineSpec},
   :dataSourceConnectionSpec {:bigqueryConnectionSpec GoogleCloudDatacatalogV1BigQueryConnectionSpec},
   :modelSpec {:vertexModelSpec GoogleCloudDatacatalogV1VertexModelSpec},
   :dataSource {:service string,
                :resource string,
                :sourceEntry string,
                :storageProperties GoogleCloudDatacatalogV1StorageProperties},
   :lookerSystemSpec {:parentInstanceId string,
                      :parentInstanceDisplayName string,
                      :parentModelId string,
                      :parentModelDisplayName string,
                      :parentViewId string,
                      :parentViewDisplayName string},
   :databaseTableSpec {:type string,
                       :dataplexTable GoogleCloudDatacatalogV1DataplexTableSpec,
                       :databaseViewSpec GoogleCloudDatacatalogV1DatabaseTableSpecDatabaseViewSpec},
   :sqlDatabaseSystemSpec {:sqlEngine string,
                           :databaseVersion string,
                           :instanceHost string},
   :userSpecifiedType string,
   :integratedSystem string,
   :fullyQualifiedName string,
   :personalDetails {:starred boolean, :starTime string}}
  
  Updates an existing entry. You must enable the Data Catalog API in the project identified by the `entry.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-entries-testIamPermissions$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-entryGroups-entries-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/create
  
  Required parameters: parent
  
  Optional parameters: entryId
  
  Body: 
  
  {:description string,
   :cloudBigtableSystemSpec {:instanceDisplayName string},
   :schema {:columns [GoogleCloudDatacatalogV1ColumnSchema]},
   :labels {},
   :bigqueryDateShardedSpec {:dataset string,
                             :tablePrefix string,
                             :shardCount string,
                             :latestShardResource string},
   :userSpecifiedSystem string,
   :sourceSystemTimestamps {:createTime string,
                            :updateTime string,
                            :expireTime string},
   :displayName string,
   :name string,
   :businessContext {:entryOverview GoogleCloudDatacatalogV1EntryOverview,
                     :contacts GoogleCloudDatacatalogV1Contacts},
   :datasetSpec {:vertexDatasetSpec GoogleCloudDatacatalogV1VertexDatasetSpec},
   :usageSignal {:updateTime string,
                 :usageWithinTimeRange {},
                 :commonUsageWithinTimeRange {},
                 :favoriteCount string},
   :filesetSpec {:dataplexFileset GoogleCloudDatacatalogV1DataplexFilesetSpec},
   :featureOnlineStoreSpec {:storageType string},
   :gcsFilesetSpec {:filePatterns [string],
                    :sampleGcsFileSpecs [GoogleCloudDatacatalogV1GcsFileSpec]},
   :type string,
   :bigqueryTableSpec {:tableSourceType string,
                       :viewSpec GoogleCloudDatacatalogV1ViewSpec,
                       :tableSpec GoogleCloudDatacatalogV1TableSpec},
   :serviceSpec {:cloudBigtableInstanceSpec GoogleCloudDatacatalogV1CloudBigtableInstanceSpec},
   :linkedResource string,
   :routineSpec {:routineType string,
                 :language string,
                 :routineArguments [GoogleCloudDatacatalogV1RoutineSpecArgument],
                 :returnType string,
                 :definitionBody string,
                 :bigqueryRoutineSpec GoogleCloudDatacatalogV1BigQueryRoutineSpec},
   :dataSourceConnectionSpec {:bigqueryConnectionSpec GoogleCloudDatacatalogV1BigQueryConnectionSpec},
   :modelSpec {:vertexModelSpec GoogleCloudDatacatalogV1VertexModelSpec},
   :dataSource {:service string,
                :resource string,
                :sourceEntry string,
                :storageProperties GoogleCloudDatacatalogV1StorageProperties},
   :lookerSystemSpec {:parentInstanceId string,
                      :parentInstanceDisplayName string,
                      :parentModelId string,
                      :parentModelDisplayName string,
                      :parentViewId string,
                      :parentViewDisplayName string},
   :databaseTableSpec {:type string,
                       :dataplexTable GoogleCloudDatacatalogV1DataplexTableSpec,
                       :databaseViewSpec GoogleCloudDatacatalogV1DatabaseTableSpecDatabaseViewSpec},
   :sqlDatabaseSystemSpec {:sqlEngine string,
                           :databaseVersion string,
                           :instanceHost string},
   :userSpecifiedType string,
   :integratedSystem string,
   :fullyQualifiedName string,
   :personalDetails {:starred boolean, :starTime string}}
  
  Creates an entry. You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data Catalog automatically creates entries with other types during metadata ingestion from integrated systems. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project). An entry group can have a maximum of 100,000 entries."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/entries"
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

(defn locations-entryGroups-entries-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing entry. You can delete only the entries created by the CreateEntry method. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-entries-star$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/star
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Marks an Entry as starred by the current user. Starring information is private to each user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:star"
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

(defn locations-entryGroups-entries-getIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-entryGroups-entries-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, readMask
  
  Lists entries. Note: Currently, this method can list only custom entries. To get a list of both custom and automatically created entries, use SearchCatalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/entries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-modifyEntryOverview$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/modifyEntryOverview
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:entryOverview {:overview string}}
  
  Modifies entry overview, part of the business context of an Entry. To call this method, you must have the `datacatalog.entries.updateOverview` IAM permission on the corresponding project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:modifyEntryOverview"
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

(defn locations-entryGroups-entries-unstar$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/unstar
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Marks an Entry as NOT starred by the current user. Starring information is private to each user."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:unstar"
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

(defn locations-entryGroups-entries-import$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:gcsBucketPath string, :jobId string}
  
  Imports entries from a source, such as data previously dumped into a Cloud Storage bucket, into Data Catalog. Import of entries is a sync operation that reconciles the state of the third-party system with the Data Catalog. `ImportEntries` accepts source data snapshots of a third-party system. Snapshot should be delivered as a .wire or base65-encoded .txt file containing a sequence of Protocol Buffer messages of DumpItem type. `ImportEntries` returns a long-running operation resource that can be queried with Operations.GetOperation to return ImportEntriesMetadata and an ImportEntriesResponse message."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/entries:import"
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

(defn locations-entryGroups-entries-tags-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/tags/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :template string,
   :templateDisplayName string,
   :column string,
   :fields {}}
  
  Creates a tag and assigns it to: * An Entry if the method name is `projects.locations.entryGroups.entries.tags.create`. * Or EntryGroupif the method name is `projects.locations.entryGroups.tags.create`. Note: The project identified by the `parent` parameter for the [tag] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters) and the [tag template] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters) used to create the tag must be in the same organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tags"
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

(defn locations-entryGroups-entries-tags-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/tags/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :template string,
   :templateDisplayName string,
   :column string,
   :fields {}}
  
  Updates an existing tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-entries-tags-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/tags/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-entries-tags-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/tags/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists tags assigned to an Entry. The columns in the response are lowercased."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-entryGroups-entries-tags-reconcile$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/entries/tags/reconcile
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:tagTemplate string,
   :forceDeleteMissing boolean,
   :tags [{:name string,
           :template string,
           :templateDisplayName string,
           :column string,
           :fields {}}]}
  
  `ReconcileTags` creates or updates a list of tags on the entry. If the ReconcileTagsRequest.force_delete_missing parameter is set, the operation deletes tags not included in the input tag list. `ReconcileTags` returns a long-running operation resource that can be queried with Operations.GetOperation to return ReconcileTagsMetadata and a ReconcileTagsResponse message."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tags:reconcile"
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

(defn locations-entryGroups-tags-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/tags/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :template string,
   :templateDisplayName string,
   :column string,
   :fields {}}
  
  Creates a tag and assigns it to: * An Entry if the method name is `projects.locations.entryGroups.entries.tags.create`. * Or EntryGroupif the method name is `projects.locations.entryGroups.tags.create`. Note: The project identified by the `parent` parameter for the [tag] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters) and the [tag template] (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters) used to create the tag must be in the same organization."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tags"
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

(defn locations-entryGroups-tags-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/tags/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :template string,
   :templateDisplayName string,
   :column string,
   :fields {}}
  
  Updates an existing tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-tags-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/tags/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-entryGroups-tags-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/entryGroups/tags/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists tags assigned to an Entry. The columns in the response are lowercased."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-tagTemplates-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/create
  
  Required parameters: parent
  
  Optional parameters: tagTemplateId
  
  Body: 
  
  {:name string,
   :displayName string,
   :isPubliclyReadable boolean,
   :fields {},
   :dataplexTransferStatus string}
  
  Creates a tag template. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/tagTemplates"
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

(defn locations-tagTemplates-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a tag template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-tagTemplates-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :isPubliclyReadable boolean,
   :fields {},
   :dataplexTransferStatus string}
  
  Updates a tag template. You can't update template fields with this method. These fields are separate resources with their own create, update, and delete methods. You must enable the Data Catalog API in the project identified by the `tag_template.name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-tagTemplates-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a tag template and all tags that use it. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-tagTemplates-setIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets an access control policy for a resource. Replaces any existing policy. Supported resources are: - Tag templates - Entry groups Note: This method sets policies only within Data Catalog and can't be used to manage policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources synced with the Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-tagTemplates-getIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. May return: * A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view it. * An empty policy if the resource exists but doesn't have a set policy. Supported resources are: - Tag templates - Entry groups Note: This method doesn't get policies from Google Cloud Platform resources ingested into Data Catalog. To call this method, you must have the following Google IAM permissions: - `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-tagTemplates-testIamPermissions$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Gets your permissions on a resource. Returns an empty set of permissions if the resource doesn't exist. Supported resources are: - Tag templates - Entry groups Note: This method gets policies only within Data Catalog and can't be used to get policies from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources ingested into Data Catalog. No Google IAM permissions are required to call this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-tagTemplates-fields-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/fields/create
  
  Required parameters: parent
  
  Optional parameters: tagTemplateFieldId
  
  Body: 
  
  {:name string,
   :displayName string,
   :type {:primitiveType string,
          :enumType GoogleCloudDatacatalogV1FieldTypeEnumType},
   :isRequired boolean,
   :description string,
   :order integer}
  
  Creates a field in a tag template. You must enable the Data Catalog API in the project identified by the `parent` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/fields"
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

(defn locations-tagTemplates-fields-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/fields/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :type {:primitiveType string,
          :enumType GoogleCloudDatacatalogV1FieldTypeEnumType},
   :isRequired boolean,
   :description string,
   :order integer}
  
  Updates a field in a tag template. You can't update the field type with this method. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-tagTemplates-fields-rename$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/fields/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newTagTemplateFieldId string}
  
  Renames a field in a tag template. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:rename"
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

(defn locations-tagTemplates-fields-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/fields/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a field in a tag template and all uses of this field from the tags based on this template. You must enable the Data Catalog API in the project identified by the `name` parameter. For more information, see [Data Catalog resource project](https://cloud.google.com/data-catalog/docs/concepts/resource-project)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-tagTemplates-fields-enumValues-rename$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/tagTemplates/fields/enumValues/rename
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:newEnumValueDisplayName string}
  
  Renames an enum value in a tag template. Within a single enum field, enum values must be unique."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:rename"
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

(defn locations-taxonomies-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-setIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the IAM policy for a policy tag or a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-taxonomies-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :policyTagCount integer,
   :taxonomyTimestamps {:createTime string,
                        :updateTime string,
                        :expireTime string},
   :activatedPolicyTypes [string],
   :service {:name string, :identity string}}
  
  Updates a taxonomy, including its display name, description, and activated policy types."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-testIamPermissions$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns your permissions on a specified policy tag or taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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

(defn locations-taxonomies-replace$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/replace
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:serializedTaxonomy {:displayName string,
                        :description string,
                        :policyTags [GoogleCloudDatacatalogV1SerializedPolicyTag],
                        :activatedPolicyTypes [string]}}
  
  Replaces (updates) a taxonomy and all its policy tags. The taxonomy and its entire hierarchy of policy tags must be represented literally by `SerializedTaxonomy` and the nested `SerializedPolicyTag` messages. This operation automatically does the following: - Deletes the existing policy tags that are missing from the `SerializedPolicyTag`. - Creates policy tags that don't have resource names. They are considered new. - Updates policy tags with valid resources names accordingly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+name}:replace"
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

(defn locations-taxonomies-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :policyTagCount integer,
   :taxonomyTimestamps {:createTime string,
                        :updateTime string,
                        :expireTime string},
   :activatedPolicyTypes [string],
   :service {:name string, :identity string}}
  
  Creates a taxonomy in a specified project. The taxonomy is initially empty, that is, it doesn't contain policy tags."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/taxonomies"
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

(defn locations-taxonomies-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a taxonomy, including all policy tags in this taxonomy, their associated policies, and the policy tags references from BigQuery columns."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-export$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/export
  
  Required parameters: parent
  
  Optional parameters: taxonomies, serializedTaxonomies
  
  Exports taxonomies in the requested type and returns them, including their policy tags. The requested taxonomies must belong to the same project. This method generates `SerializedTaxonomy` protocol buffers with nested policy tags that can be used as input for `ImportTaxonomies` calls."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/taxonomies:export"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-getIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy for a policy tag or a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-taxonomies-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all taxonomies in a project in a particular location that you have a permission to view."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/taxonomies"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-import$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inlineSource {:taxonomies [GoogleCloudDatacatalogV1SerializedTaxonomy]},
   :crossRegionalSource {:taxonomy string}}
  
  Creates new taxonomies (including their policy tags) in a given project by importing from inlined or cross-regional sources. For a cross-regional source, new taxonomies are created by copying from a source in another region. For an inlined source, taxonomies and policy tags are created in bulk using nested protocol buffer structures."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/taxonomies:import"
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

(defn locations-taxonomies-policyTags-create$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :parentPolicyTag string,
   :childPolicyTags [string]}
  
  Creates a policy tag in a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/policyTags"
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

(defn locations-taxonomies-policyTags-delete$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a policy tag together with the following: * All of its descendant policy tags, if any * Policies associated with the policy tag and its descendants * References from BigQuery table schema of the policy tag and its descendants"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-policyTags-patch$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :description string,
   :parentPolicyTag string,
   :childPolicyTags [string]}
  
  Updates a policy tag, including its display name, description, and parent policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-policyTags-list$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all policy tags in a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+parent}/policyTags"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-taxonomies-policyTags-get$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a policy tag."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datacatalog.googleapis.com/"
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

(defn locations-taxonomies-policyTags-getIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the IAM policy for a policy tag or a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-taxonomies-policyTags-setIamPolicy$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :bindings [Binding], :etag string}}
  
  Sets the IAM policy for a policy tag or a taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
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

(defn locations-taxonomies-policyTags-testIamPermissions$
  "https://cloud.google.com/data-catalog/docs/api/reference/rest/v1/projects/locations/taxonomies/policyTags/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns your permissions on a specified policy tag or taxonomy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datacatalog.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
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
