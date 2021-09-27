(ns happygapi.bigquerydatatransfer.projects
  "BigQuery Data Transfer API: projects.
  Schedule queries or transfer external data from SaaS applications to Google BigQuery on a regular basis.
  See: https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn enrollDataSources$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/enrollDataSources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataSourceIds [string]}
  
  Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the BigQuery UI 'https://bigquery.cloud.google.com' (and the documents can be found at https://cloud.google.com/bigquery/bigquery-web-ui and https://cloud.google.com/bigquery/docs/working-with-transfers)."
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
   :scheduleOptions {:startTime string,
                     :disableAutoScheduling boolean,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string}
  
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

(defn transferConfigs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, dataSourceIds
  
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
  
  {:endTime string, :startTime string}
  
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
  
  {:requestedRunTime string,
   :requestedTimeRange {:startTime string, :endTime string}}
  
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

(defn transferConfigs-patch$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, versionInfo, authorizationCode, serviceAccountName
  
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
   :scheduleOptions {:startTime string,
                     :disableAutoScheduling boolean,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string}
  
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

(defn transferConfigs-runs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/transferConfigs/runs/list
  
  Required parameters: parent
  
  Optional parameters: runAttempt, pageSize, states, pageToken
  
  Returns information about running and completed jobs."
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
  
  Optional parameters: messageTypes, pageToken, pageSize
  
  Returns user facing log messages for the data transfer run."
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

(defn dataSources-checkValidCreds$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/checkValidCreds
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns true if valid credentials exist for the given data source and requesting user. Some data sources doesn't support service account, so we need to talk to them on behalf of the end user. This API just checks whether we have OAuth token for the particular user, which is a pre-requisite before user can create a transfer config."
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

(defn dataSources-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists supported data sources and returns their settings, which can be used for UI rendering."
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

(defn dataSources-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/dataSources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a supported data source and returns its settings, which can be used for UI rendering."
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

(defn locations-enrollDataSources$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/enrollDataSources
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:dataSourceIds [string]}
  
  Enroll data sources in a user project. This allows users to create transfer configurations for these data sources. They will also appear in the ListDataSources RPC and as such, will appear in the BigQuery UI 'https://bigquery.cloud.google.com' (and the documents can be found at https://cloud.google.com/bigquery/bigquery-web-ui and https://cloud.google.com/bigquery/docs/working-with-transfers)."
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

(defn locations-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
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

(defn locations-dataSources-checkValidCreds$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/dataSources/checkValidCreds
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Returns true if valid credentials exist for the given data source and requesting user. Some data sources doesn't support service account, so we need to talk to them on behalf of the end user. This API just checks whether we have OAuth token for the particular user, which is a pre-requisite before user can create a transfer config."
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

(defn locations-dataSources-get$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/dataSources/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a supported data source and returns its settings, which can be used for UI rendering."
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
  
  Optional parameters: pageSize, pageToken
  
  Lists supported data sources and returns their settings, which can be used for UI rendering."
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

(defn locations-transferConfigs-create$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/create
  
  Required parameters: parent
  
  Optional parameters: serviceAccountName, authorizationCode, versionInfo
  
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
   :scheduleOptions {:startTime string,
                     :disableAutoScheduling boolean,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string}
  
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

(defn locations-transferConfigs-patch$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/patch
  
  Required parameters: name
  
  Optional parameters: versionInfo, serviceAccountName, updateMask, authorizationCode
  
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
   :scheduleOptions {:startTime string,
                     :disableAutoScheduling boolean,
                     :endTime string},
   :updateTime string,
   :dataRefreshWindowDays integer,
   :dataSourceId string,
   :datasetRegion string,
   :userId string}
  
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

(defn locations-transferConfigs-startManualRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/startManualRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestedRunTime string,
   :requestedTimeRange {:startTime string, :endTime string}}
  
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

(defn locations-transferConfigs-scheduleRuns$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/scheduleRuns
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:endTime string, :startTime string}
  
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

(defn locations-transferConfigs-runs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/list
  
  Required parameters: parent
  
  Optional parameters: runAttempt, states, pageToken, pageSize
  
  Returns information about running and completed jobs."
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

(defn locations-transferConfigs-runs-transferLogs-list$
  "https://cloud.google.com/bigquery-transfer/api/reference/rest/v1/projects/locations/transferConfigs/runs/transferLogs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, messageTypes, pageToken
  
  Returns user facing log messages for the data transfer run."
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
