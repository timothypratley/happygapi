(ns happygapi.bigquerydatatransfer.projects
  "BigQuery Data Transfer API: projects.
  Schedule queries or transfer external data from SaaS applications to Google BigQuery on a regular basis.
  See: https://cloud.google.com/bigquery-transfer/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn enrollDataSources$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/enrollDataSources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataSourceIds [string]}
  
  Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents can be found in the public guide for [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and [Data Transfer Service](https://cloud.google.com/bigquery/docs/working-with-transfers)."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+name}:enrollDataSources"
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

(defn dataSources-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a supported data source and returns its settings."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn dataSources-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists supported data sources and returns their settings."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/dataSources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dataSources-checkValidCreds$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/checkValidCreds
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns true if valid credentials exist for the given data source and requesting user."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+name}:checkValidCreds"
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

(defn transferConfigs-create$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/create
  
  Required parameters: parent
  
  Optional parameters: authorizationCode, versionInfo, serviceAccountName
  
  Body: 
  
  {:notificationPubsubTopic string,
   :destinationDatasetId string,
   :nextRunTime string,
   :schedule string,
   :disabled boolean,
   :ownerInfo {:email string},
   :displayName string,
   :name string,
   :params {},
   :emailPreferences {:enableFailureEmail boolean},
   :state string,
   :scheduleOptions {:disableAutoScheduling boolean,
                     :startTime string,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string,
   :encryptionConfiguration {:kmsKeyName string}}
  
  Creates a new data transfer configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferConfigs"
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

(defn transferConfigs-patch$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/patch
  
  Required parameters: name
  
  Optional parameters: authorizationCode, updateMask, versionInfo, serviceAccountName
  
  Body: 
  
  {:notificationPubsubTopic string,
   :destinationDatasetId string,
   :nextRunTime string,
   :schedule string,
   :disabled boolean,
   :ownerInfo {:email string},
   :displayName string,
   :name string,
   :params {},
   :emailPreferences {:enableFailureEmail boolean},
   :state string,
   :scheduleOptions {:disableAutoScheduling boolean,
                     :startTime string,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string,
   :encryptionConfiguration {:kmsKeyName string}}
  
  Updates a data transfer configuration. All fields must be set, even if they are not updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn transferConfigs-delete$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a data transfer configuration, including any associated transfer runs and logs."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn transferConfigs-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about a data transfer config."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn transferConfigs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/list
  
  Required parameters: parent
  
  Optional parameters: dataSourceIds, pageToken, pageSize
  
  Returns information about all transfer configs owned by a project in the specified location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn transferConfigs-scheduleRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/scheduleRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string, :endTime string}
  
  Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever granularity the data source supports - in the range, one transfer run is created. Note that runs are created per UTC time in the time range. DEPRECATED: use StartManualTransferRuns instead."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}:scheduleRuns"
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

(defn transferConfigs-startManualRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/startManualRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestedTimeRange {:startTime string, :endTime string},
   :requestedRunTime string}
  
  Start manual transfer runs to be executed now with schedule_time equal to current time. The transfer runs can be created for a time range where the run_time is between start_time (inclusive) and end_time (exclusive), or for a specific run_time."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}:startManualRuns"
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

(defn transferConfigs-runs-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/runs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about the particular transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn transferConfigs-runs-delete$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/runs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn transferConfigs-runs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/runs/list
  
  Required parameters: parent
  
  Optional parameters: states, pageToken, pageSize, runAttempt
  
  Returns information about running and completed transfer runs."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/runs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn transferConfigs-runs-transferLogs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/runs/transferLogs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, messageTypes
  
  Returns log messages for the transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferLogs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-enrollDataSources$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/enrollDataSources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataSourceIds [string]}
  
  Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the [BigQuery UI](https://console.cloud.google.com/bigquery), and the documents can be found in the public guide for [BigQuery Web UI](https://cloud.google.com/bigquery/bigquery-web-ui) and [Data Transfer Service](https://cloud.google.com/bigquery/docs/working-with-transfers)."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+name}:enrollDataSources"
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

(defn locations-unenrollDataSources$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/unenrollDataSources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataSourceIds [string]}
  
  Unenroll data sources in a user project. This allows users to remove transfer configurations for these data sources. They will no longer appear in the ListDataSources RPC and will also no longer appear in the [BigQuery UI](https://console.cloud.google.com/bigquery). Data transfers configurations of unenrolled data sources will not be scheduled."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+name}:unenrollDataSources"
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
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-dataSources-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/dataSources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a supported data source and returns its settings."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-dataSources-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/dataSources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists supported data sources and returns their settings."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/dataSources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataSources-checkValidCreds$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/dataSources/checkValidCreds
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns true if valid credentials exist for the given data source and requesting user."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+name}:checkValidCreds"
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

(defn locations-transferConfigs-create$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/create
  
  Required parameters: parent
  
  Optional parameters: authorizationCode, versionInfo, serviceAccountName
  
  Body: 
  
  {:notificationPubsubTopic string,
   :destinationDatasetId string,
   :nextRunTime string,
   :schedule string,
   :disabled boolean,
   :ownerInfo {:email string},
   :displayName string,
   :name string,
   :params {},
   :emailPreferences {:enableFailureEmail boolean},
   :state string,
   :scheduleOptions {:disableAutoScheduling boolean,
                     :startTime string,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string,
   :encryptionConfiguration {:kmsKeyName string}}
  
  Creates a new data transfer configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferConfigs"
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

(defn locations-transferConfigs-patch$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/patch
  
  Required parameters: name
  
  Optional parameters: authorizationCode, updateMask, versionInfo, serviceAccountName
  
  Body: 
  
  {:notificationPubsubTopic string,
   :destinationDatasetId string,
   :nextRunTime string,
   :schedule string,
   :disabled boolean,
   :ownerInfo {:email string},
   :displayName string,
   :name string,
   :params {},
   :emailPreferences {:enableFailureEmail boolean},
   :state string,
   :scheduleOptions {:disableAutoScheduling boolean,
                     :startTime string,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string,
   :encryptionConfiguration {:kmsKeyName string}}
  
  Updates a data transfer configuration. All fields must be set, even if they are not updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-transferConfigs-delete$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a data transfer configuration, including any associated transfer runs and logs."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-transferConfigs-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about a data transfer config."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-transferConfigs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/list
  
  Required parameters: parent
  
  Optional parameters: dataSourceIds, pageToken, pageSize
  
  Returns information about all transfer configs owned by a project in the specified location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-transferConfigs-scheduleRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/scheduleRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:startTime string, :endTime string}
  
  Creates transfer runs for a time range [start_time, end_time]. For each date - or whatever granularity the data source supports - in the range, one transfer run is created. Note that runs are created per UTC time in the time range. DEPRECATED: use StartManualTransferRuns instead."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}:scheduleRuns"
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

(defn locations-transferConfigs-startManualRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/startManualRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestedTimeRange {:startTime string, :endTime string},
   :requestedRunTime string}
  
  Start manual transfer runs to be executed now with schedule_time equal to current time. The transfer runs can be created for a time range where the run_time is between start_time (inclusive) and end_time (exclusive), or for a specific run_time."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}:startManualRuns"
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

(defn locations-transferConfigs-runs-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns information about the particular transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-transferConfigs-runs-delete$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
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

(defn locations-transferConfigs-runs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/list
  
  Required parameters: parent
  
  Optional parameters: states, pageToken, pageSize, runAttempt
  
  Returns information about running and completed transfer runs."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/runs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-transferConfigs-runs-transferLogs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/transferLogs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, messageTypes
  
  Returns log messages for the transfer run."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigquerydatatransfer.googleapis.com/"
     "v1/{+parent}/transferLogs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
