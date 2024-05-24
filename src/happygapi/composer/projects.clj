(ns happygapi.composer.projects
  "Cloud Composer API: projects.
  Manages Apache Airflow environments on Google Cloud Platform.
  See: https://cloud.google.com/composer/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
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
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
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
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-get$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get an existing environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-patch$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :config {:databaseConfig DatabaseConfig,
            :gkeCluster string,
            :workloadsConfig WorkloadsConfig,
            :airflowUri string,
            :airflowByoidUri string,
            :nodeConfig NodeConfig,
            :masterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
            :softwareConfig SoftwareConfig,
            :webServerNetworkAccessControl WebServerNetworkAccessControl,
            :privateEnvironmentConfig PrivateEnvironmentConfig,
            :recoveryConfig RecoveryConfig,
            :webServerConfig WebServerConfig,
            :resilienceMode string,
            :maintenanceWindow MaintenanceWindow,
            :dataRetentionConfig DataRetentionConfig,
            :nodeCount integer,
            :environmentSize string,
            :encryptionConfig EncryptionConfig,
            :dagGcsPrefix string},
   :name string,
   :createTime string,
   :storageConfig {:bucket string},
   :state string,
   :updateTime string,
   :satisfiesPzs boolean,
   :uuid string}
  
  Update an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-checkUpgrade$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/checkUpgrade
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:imageVersion string}
  
  Check if an upgrade operation on the environment will succeed. In case of problems detailed info can be found in the returned Operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:checkUpgrade"
     #{:environment}
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

(defn locations-environments-saveSnapshot$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/saveSnapshot
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:snapshotLocation string}
  
  Creates a snapshots of a Cloud Composer environment. As a result of this operation, snapshot of environment's state is stored in a location specified in the SaveSnapshotRequest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:saveSnapshot"
     #{:environment}
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

(defn locations-environments-create$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :config {:databaseConfig DatabaseConfig,
            :gkeCluster string,
            :workloadsConfig WorkloadsConfig,
            :airflowUri string,
            :airflowByoidUri string,
            :nodeConfig NodeConfig,
            :masterAuthorizedNetworksConfig MasterAuthorizedNetworksConfig,
            :softwareConfig SoftwareConfig,
            :webServerNetworkAccessControl WebServerNetworkAccessControl,
            :privateEnvironmentConfig PrivateEnvironmentConfig,
            :recoveryConfig RecoveryConfig,
            :webServerConfig WebServerConfig,
            :resilienceMode string,
            :maintenanceWindow MaintenanceWindow,
            :dataRetentionConfig DataRetentionConfig,
            :nodeCount integer,
            :environmentSize string,
            :encryptionConfig EncryptionConfig,
            :dagGcsPrefix string},
   :name string,
   :createTime string,
   :storageConfig {:bucket string},
   :state string,
   :updateTime string,
   :satisfiesPzs boolean,
   :uuid string}
  
  Create a new environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/environments"
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

(defn locations-environments-delete$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete an environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-pollAirflowCommand$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/pollAirflowCommand
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:executionId string,
   :pod string,
   :podNamespace string,
   :nextLineNumber integer}
  
  Polls Airflow CLI command execution and fetches logs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:pollAirflowCommand"
     #{:environment}
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

(defn locations-environments-databaseFailover$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/databaseFailover
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Triggers database failover (only for highly resilient environments)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:databaseFailover"
     #{:environment}
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

(defn locations-environments-fetchDatabaseProperties$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/fetchDatabaseProperties
  
  Required parameters: environment
  
  Optional parameters: none
  
  Fetches database properties."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:fetchDatabaseProperties"
     #{:environment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-environments-stopAirflowCommand$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/stopAirflowCommand
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:executionId string,
   :pod string,
   :podNamespace string,
   :force boolean}
  
  Stops Airflow CLI command execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:stopAirflowCommand"
     #{:environment}
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

(defn locations-environments-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List environments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/environments"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-environments-executeAirflowCommand$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/executeAirflowCommand
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:command string, :subcommand string, :parameters [string]}
  
  Executes Airflow CLI command."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:executeAirflowCommand"
     #{:environment}
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

(defn locations-environments-loadSnapshot$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/loadSnapshot
  
  Required parameters: environment
  
  Optional parameters: none
  
  Body: 
  
  {:snapshotPath string,
   :skipPypiPackagesInstallation boolean,
   :skipEnvironmentVariablesSetting boolean,
   :skipAirflowOverridesSetting boolean,
   :skipGcsDataCopying boolean}
  
  Loads a snapshot of a Cloud Composer environment. As a result of this operation, a snapshot of environment's specified in LoadSnapshotRequest is loaded into the environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:environment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+environment}:loadSnapshot"
     #{:environment}
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

(defn locations-environments-workloads-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/workloads/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists workloads in a Cloud Composer environment. Workload is a unit that runs a single Composer component. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/workloads"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-environments-userWorkloadsSecrets-create$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsSecrets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :data {}}
  
  Creates a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/userWorkloadsSecrets"
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

(defn locations-environments-userWorkloadsSecrets-get$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsSecrets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an existing user workloads Secret. Values of the \"data\" field in the response are cleared. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-userWorkloadsSecrets-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsSecrets/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists user workloads Secrets. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/userWorkloadsSecrets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-environments-userWorkloadsSecrets-update$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsSecrets/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :data {}}
  
  Updates a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-userWorkloadsSecrets-delete$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsSecrets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a user workloads Secret. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-userWorkloadsConfigMaps-create$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsConfigMaps/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :data {}}
  
  Creates a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/userWorkloadsConfigMaps"
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

(defn locations-environments-userWorkloadsConfigMaps-get$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsConfigMaps/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an existing user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-userWorkloadsConfigMaps-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsConfigMaps/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists user workloads ConfigMaps. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/userWorkloadsConfigMaps"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-environments-userWorkloadsConfigMaps-update$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsConfigMaps/update
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :data {}}
  
  Updates a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-environments-userWorkloadsConfigMaps-delete$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/environments/userWorkloadsConfigMaps/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a user workloads ConfigMap. This method is supported for Cloud Composer environments in versions composer-3.*.*-airflow-*.*.* and newer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://composer.googleapis.com/"
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

(defn locations-imageVersions-list$
  "https://cloud.google.com/composer/api/reference/rest/v1/projects/locations/imageVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, includePastReleases
  
  List ImageVersions for provided location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://composer.googleapis.com/"
     "v1/{+parent}/imageVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
