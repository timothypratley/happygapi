(ns happygapi.bigquery.routines
  "BigQuery API: routines.
  A data platform for customers to create, manage, share and query data.
  See: https://cloud.google.com/bigquery/docs/reference/rest/v2/routines"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/delete
  
  Required parameters: datasetId, projectId, routineId
  
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

(defn get$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/get
  
  Required parameters: datasetId, projectId, routineId
  
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

(defn getIamPolicy$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/getIamPolicy
  
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

(defn insert$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/insert
  
  Required parameters: datasetId, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :remoteFunctionOptions {:connection string,
                           :endpoint string,
                           :maxBatchingRows string,
                           :userDefinedContext {}},
   :importedLibraries [string],
   :arguments [{:argumentKind string,
                :dataType StandardSqlDataType,
                :isAggregate boolean,
                :mode string,
                :name string}],
   :securityMode string,
   :etag string,
   :dataGovernanceType string,
   :returnType {:arrayElementType StandardSqlDataType,
                :rangeElementType StandardSqlDataType,
                :structType StandardSqlStructType,
                :typeKind string},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:datasetId string,
                      :projectId string,
                      :routineId string},
   :returnTableType {:columns [StandardSqlField]},
   :sparkOptions {:properties {},
                  :archiveUris [string],
                  :containerImage string,
                  :mainClass string,
                  :pyFileUris [string],
                  :jarUris [string],
                  :fileUris [string],
                  :runtimeVersion string,
                  :connection string,
                  :mainFileUri string},
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

(defn list$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/list
  
  Required parameters: datasetId, projectId
  
  Optional parameters: filter, maxResults, pageToken, readMask
  
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

(defn setIamPolicy$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/setIamPolicy
  
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

(defn update$
  "https://cloud.google.com/bigquery/api/reference/rest/v2/routines/update
  
  Required parameters: datasetId, projectId, routineId
  
  Optional parameters: none
  
  Body: 
  
  {:creationTime string,
   :description string,
   :remoteFunctionOptions {:connection string,
                           :endpoint string,
                           :maxBatchingRows string,
                           :userDefinedContext {}},
   :importedLibraries [string],
   :arguments [{:argumentKind string,
                :dataType StandardSqlDataType,
                :isAggregate boolean,
                :mode string,
                :name string}],
   :securityMode string,
   :etag string,
   :dataGovernanceType string,
   :returnType {:arrayElementType StandardSqlDataType,
                :rangeElementType StandardSqlDataType,
                :structType StandardSqlStructType,
                :typeKind string},
   :routineType string,
   :lastModifiedTime string,
   :definitionBody string,
   :language string,
   :routineReference {:datasetId string,
                      :projectId string,
                      :routineId string},
   :returnTableType {:columns [StandardSqlField]},
   :sparkOptions {:properties {},
                  :archiveUris [string],
                  :containerImage string,
                  :mainClass string,
                  :pyFileUris [string],
                  :jarUris [string],
                  :fileUris [string],
                  :runtimeVersion string,
                  :connection string,
                  :mainFileUri string},
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
