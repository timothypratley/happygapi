(ns happygapi.migrationcenter.projects
  "Migration Center API: projects.
  A unified platform that helps you accelerate your end-to-end cloud journey from your current on-premises or cloud environments to Google Cloud.
  See: https://cloud.google.com/migration-centerapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-getSettings$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/getSettings
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of regional settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-updateSettings$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/updateSettings
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string, :preferenceSet string, :disableCloudLogging boolean}
  
  Updates the regional-level project settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-operations-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-assets-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, view
  
  Lists all the assets in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/assets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-assets-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets the details of an asset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-assets-patch$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :performanceData {:dailyResourceUsageAggregations [DailyResourceUsageAggregation]},
   :sources [string],
   :name string,
   :createTime string,
   :insightList {:insights [Insight], :updateTime string},
   :updateTime string,
   :assignedGroups [string],
   :machineDetails {:powerState string,
                    :architecture MachineArchitectureDetails,
                    :coreCount integer,
                    :createTime string,
                    :guestOs GuestOsDetails,
                    :disks MachineDiskDetails,
                    :memoryMb integer,
                    :network MachineNetworkDetails,
                    :uuid string,
                    :machineName string,
                    :platform PlatformDetails},
   :attributes {}}
  
  Updates the parameters of an asset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-assets-batchUpdate$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:updateMask string, :asset Asset, :requestId string}]}
  
  Updates the parameters of a list of assets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/assets:batchUpdate"
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

(defn locations-assets-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes an asset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-assets-batchDelete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/batchDelete
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:names [string], :allowMissing boolean}
  
  Deletes list of Assets."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/assets:batchDelete"
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

(defn locations-assets-reportAssetFrames$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/reportAssetFrames
  
  Required parameters: parent
  
  Optional parameters: source
  
  Body: 
  
  {:framesData [{:machineDetails MachineDetails,
                 :reportTime string,
                 :labels {},
                 :attributes {},
                 :performanceSamples [PerformanceSample],
                 :traceToken string}]}
  
  Reports a set of frames."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/assets:reportAssetFrames"
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

(defn locations-assets-aggregateValues$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/assets/aggregateValues
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:aggregations [{:field string,
                   :count AggregationCount,
                   :sum AggregationSum,
                   :histogram AggregationHistogram,
                   :frequency AggregationFrequency}],
   :filter string}
  
  Aggregates the requested fields based on provided function."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/assets:aggregateValues"
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

(defn locations-importJobs-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/create
  
  Required parameters: parent
  
  Optional parameters: importJobId, requestId
  
  Body: 
  
  {:labels {},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :validationReport {:fileValidations [FileValidationReport],
                      :jobErrors [ImportError]},
   :completeTime string,
   :executionReport {:framesReported integer,
                     :executionErrors ValidationReport,
                     :totalRowsCount integer},
   :assetSource string}
  
  Creates an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/importJobs"
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

(defn locations-importJobs-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, view
  
  Lists all import jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/importJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-importJobs-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets the details of an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-importJobs-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-importJobs-patch$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :validationReport {:fileValidations [FileValidationReport],
                      :jobErrors [ImportError]},
   :completeTime string,
   :executionReport {:framesReported integer,
                     :executionErrors ValidationReport,
                     :totalRowsCount integer},
   :assetSource string}
  
  Updates an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-importJobs-validate$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/validate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Validates an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+name}:validate"
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

(defn locations-importJobs-run$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string}
  
  Runs an import job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-importJobs-importDataFiles-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/importDataFiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an import data file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-importJobs-importDataFiles-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/importDataFiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  List import data files."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/importDataFiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-importJobs-importDataFiles-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/importDataFiles/create
  
  Required parameters: parent
  
  Optional parameters: importDataFileId, requestId
  
  Body: 
  
  {:name string,
   :displayName string,
   :format string,
   :createTime string,
   :state string,
   :uploadFileInfo {:signedUri string,
                    :headers {},
                    :uriExpirationTime string}}
  
  Creates an import data file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/importDataFiles"
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

(defn locations-importJobs-importDataFiles-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/importJobs/importDataFiles/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Delete an import data file."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-groups-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all groups in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/groups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-groups-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-groups-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/create
  
  Required parameters: parent
  
  Optional parameters: groupId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :displayName string,
   :description string}
  
  Creates a new group in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/groups"
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

(defn locations-groups-patch$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :displayName string,
   :description string}
  
  Updates the parameters of a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-groups-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-groups-addAssets$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/addAssets
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :assets {:assetIds [string]},
   :allowExisting boolean}
  
  Adds assets to a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+group}:addAssets"
     #{:group}
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

(defn locations-groups-removeAssets$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/groups/removeAssets
  
  Required parameters: group
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :assets {:assetIds [string]},
   :allowMissing boolean}
  
  Removes assets from a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:group})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+group}:removeAssets"
     #{:group}
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

(defn locations-sources-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all the sources in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/sources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-sources-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/create
  
  Required parameters: parent
  
  Optional parameters: sourceId, requestId
  
  Body: 
  
  {:description string,
   :pendingFrameCount integer,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :updateTime string,
   :priority integer,
   :errorFrameCount integer,
   :managed boolean}
  
  Creates a new source in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/sources"
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

(defn locations-sources-patch$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:description string,
   :pendingFrameCount integer,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :updateTime string,
   :priority integer,
   :errorFrameCount integer,
   :managed boolean}
  
  Updates the parameters of a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-sources-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a source."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-sources-errorFrames-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/errorFrames/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists all error frames in a given source and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/errorFrames"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-sources-errorFrames-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/sources/errorFrames/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets the details of an error frame."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-preferenceSets-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/preferenceSets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy
  
  Lists all the preference sets in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/preferenceSets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-preferenceSets-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/preferenceSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a preference set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-preferenceSets-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/preferenceSets/create
  
  Required parameters: parent
  
  Optional parameters: preferenceSetId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :displayName string,
   :description string,
   :virtualMachinePreferences {:targetProduct string,
                               :regionPreferences RegionPreferences,
                               :commitmentPlan string,
                               :sizingOptimizationStrategy string,
                               :computeEnginePreferences ComputeEnginePreferences,
                               :vmwareEnginePreferences VmwareEnginePreferences,
                               :soleTenancyPreferences SoleTenancyPreferences}}
  
  Creates a new preference set in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/preferenceSets"
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

(defn locations-preferenceSets-patch$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/preferenceSets/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :displayName string,
   :description string,
   :virtualMachinePreferences {:targetProduct string,
                               :regionPreferences RegionPreferences,
                               :commitmentPlan string,
                               :sizingOptimizationStrategy string,
                               :computeEnginePreferences ComputeEnginePreferences,
                               :vmwareEnginePreferences VmwareEnginePreferences,
                               :soleTenancyPreferences SoleTenancyPreferences}}
  
  Updates the parameters of a preference set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-preferenceSets-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/preferenceSets/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a preference set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-reportConfigs-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/create
  
  Required parameters: parent
  
  Optional parameters: reportConfigId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :displayName string,
   :description string,
   :groupPreferencesetAssignments [{:group string,
                                    :preferenceSet string}]}
  
  Creates a report configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/reportConfigs"
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

(defn locations-reportConfigs-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single ReportConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-reportConfigs-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists ReportConfigs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/reportConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reportConfigs-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a ReportConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-reportConfigs-reports-create$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/reports/create
  
  Required parameters: parent
  
  Optional parameters: reportId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :displayName string,
   :description string,
   :type string,
   :state string,
   :summary {:allAssetsStats ReportSummaryAssetAggregateStats,
             :groupFindings [ReportSummaryGroupFinding]}}
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/reports"
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

(defn locations-reportConfigs-reports-get$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/reports/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Gets details of a single Report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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

(defn locations-reportConfigs-reports-list$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/reports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy, view
  
  Lists Reports in a given ReportConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://migrationcenter.googleapis.com/"
     "v1/{+parent}/reports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-reportConfigs-reports-delete$
  "https://cloud.google.com/migration-centerapi/reference/rest/v1/projects/locations/reportConfigs/reports/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a Report."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://migrationcenter.googleapis.com/"
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
