(ns happygapi.appengine.apps
  "App Engine Admin API: apps.
  Provisions and manages developers' App Engine applications.
  See: https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/get
  
  Required parameters: appsId
  
  Optional parameters: includeExtraData
  
  Gets information about an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount string,
   :gcrDomain string,
   :defaultBucket string,
   :codeBucket string,
   :locationId string,
   :servingStatus string,
   :name string,
   :authDomain string,
   :dispatchRules [{:domain string, :path string, :service string}],
   :defaultHostname string,
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :generatedCustomerMetadata {},
   :id string,
   :featureSettings {:splitHealthChecks boolean,
                     :useContainerOptimizedOs boolean},
   :databaseType string,
   :defaultCookieExpiration string}
  
  Creates an App Engine application for a Google Cloud Platform project. Required fields: id - The ID of the target Cloud Platform project. location - The region (https://cloud.google.com/appengine/docs/locations) where you want the App Engine application located.For more information about App Engine applications, see Managing Projects, Applications, and Billing (https://cloud.google.com/appengine/docs/standard/python/console/)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps"
     #{}
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
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/patch
  
  Required parameters: appsId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serviceAccount string,
   :gcrDomain string,
   :defaultBucket string,
   :codeBucket string,
   :locationId string,
   :servingStatus string,
   :name string,
   :authDomain string,
   :dispatchRules [{:domain string, :path string, :service string}],
   :defaultHostname string,
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :generatedCustomerMetadata {},
   :id string,
   :featureSettings {:splitHealthChecks boolean,
                     :useContainerOptimizedOs boolean},
   :databaseType string,
   :defaultCookieExpiration string}
  
  Updates the specified Application resource. You can update the following fields: auth_domain - Google authentication domain for controlling user access to the application. default_cookie_expiration - Cookie expiration policy for the application. iap - Identity-Aware Proxy properties for the application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}"
     #{:appsId}
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

(defn repair$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/repair
  
  Required parameters: appsId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Recreates the required App Engine features for the specified App Engine application, for example a Cloud Storage bucket or App Engine service account. Use this method if you receive an error message about a missing feature, for example, Error retrieving the App Engine service account. If you have deleted your App Engine service account, this will not be able to recreate it. Instead, you should attempt to use the IAM undelete API if possible at https://cloud.google.com/iam/reference/rest/v1/projects.serviceAccounts/undelete?apix_params=%7B\"name\"%3A\"projects%2F-%2FserviceAccounts%2Funique_id\"%2C\"resource\"%3A%7B%7D%7D . If the deletion was recent, the numeric ID can be found in the Cloud Console Activity Log."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}:repair"
     #{:appsId}
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

(defn listRuntimes$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/listRuntimes
  
  Required parameters: appsId
  
  Optional parameters: environment
  
  Lists all the available runtimes for the application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}:listRuntimes"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/operations/list
  
  Required parameters: appsId
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns UNIMPLEMENTED."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/operations"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/operations/get
  
  Required parameters: appsId, operationsId
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :operationsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/operations/{operationsId}"
     #{:appsId :operationsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/list
  
  Required parameters: appsId
  
  Optional parameters: pageSize, pageToken
  
  Lists all the services in the application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/get
  
  Required parameters: appsId, servicesId
  
  Optional parameters: none
  
  Gets the current configuration of the specified service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :servicesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{:appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-patch$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/patch
  
  Required parameters: appsId, servicesId
  
  Optional parameters: updateMask, migrateTraffic
  
  Body: 
  
  {:name string,
   :id string,
   :split {:shardBy string, :allocations {}},
   :labels {},
   :networkSettings {:ingressTrafficAllowed string},
   :generatedCustomerMetadata {}}
  
  Updates the configuration of the specified service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId :servicesId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{:appsId :servicesId}
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

(defn services-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/delete
  
  Required parameters: appsId, servicesId
  
  Optional parameters: none
  
  Deletes the specified service and all enclosed versions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :servicesId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}"
     #{:appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/list
  
  Required parameters: appsId, servicesId
  
  Optional parameters: view, pageSize, pageToken
  
  Lists the versions of a service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :servicesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions"
     #{:appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/get
  
  Required parameters: appsId, servicesId, versionsId
  
  Optional parameters: view
  
  Gets the specified Version resource. By default, only a BASIC_VIEW will be returned. Specify the FULL_VIEW parameter to get the full resource."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :servicesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{:versionsId :appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-create$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/create
  
  Required parameters: appsId, servicesId
  
  Optional parameters: none
  
  Body: 
  
  {:serviceAccount string,
   :runtimeChannel string,
   :appEngineApis boolean,
   :automaticScaling {:maxConcurrentRequests integer,
                      :maxPendingLatency string,
                      :requestUtilization RequestUtilization,
                      :maxTotalInstances integer,
                      :standardSchedulerSettings StandardSchedulerSettings,
                      :diskUtilization DiskUtilization,
                      :cpuUtilization CpuUtilization,
                      :coolDownPeriod string,
                      :minPendingLatency string,
                      :minTotalInstances integer,
                      :minIdleInstances integer,
                      :maxIdleInstances integer,
                      :networkUtilization NetworkUtilization},
   :createdBy string,
   :libraries [{:name string, :version string}],
   :nobuildFilesRegex string,
   :servingStatus string,
   :endpointsApiService {:name string,
                         :configId string,
                         :rolloutStrategy string,
                         :disableTraceSampling boolean},
   :name string,
   :versionUrl string,
   :createTime string,
   :vm boolean,
   :betaSettings {},
   :handlers [{:urlRegex string,
               :staticFiles StaticFilesHandler,
               :script ScriptHandler,
               :apiEndpoint ApiEndpointHandler,
               :securityLevel string,
               :login string,
               :authFailAction string,
               :redirectHttpResponseCode string}],
   :env string,
   :buildEnvVariables {},
   :threadsafe boolean,
   :runtimeMainExecutablePath string,
   :livenessCheck {:path string,
                   :host string,
                   :failureThreshold integer,
                   :successThreshold integer,
                   :checkInterval string,
                   :timeout string,
                   :initialDelay string},
   :envVariables {},
   :vpcAccessConnector {:name string, :egressSetting string},
   :generatedCustomerMetadata {},
   :id string,
   :runtime string,
   :manualScaling {:instances integer},
   :zones [string],
   :entrypoint {:shell string},
   :deployment {:files {},
                :container ContainerInfo,
                :zip ZipInfo,
                :cloudBuildOptions CloudBuildOptions},
   :errorHandlers [{:errorCode string,
                    :staticFile string,
                    :mimeType string}],
   :network {:forwardedPorts [string],
             :instanceTag string,
             :name string,
             :subnetworkName string,
             :sessionAffinity boolean,
             :instanceIpMode string},
   :instanceClass string,
   :inboundServices [string],
   :resources {:cpu number,
               :diskGb number,
               :memoryGb number,
               :volumes [Volume],
               :kmsKeyReference string},
   :defaultExpiration string,
   :diskUsageBytes string,
   :flexibleRuntimeSettings {:operatingSystem string,
                             :runtimeVersion string},
   :apiConfig {:authFailAction string,
               :login string,
               :script string,
               :securityLevel string,
               :url string},
   :healthCheck {:disableHealthCheck boolean,
                 :host string,
                 :healthyThreshold integer,
                 :unhealthyThreshold integer,
                 :restartThreshold integer,
                 :checkInterval string,
                 :timeout string},
   :basicScaling {:idleTimeout string, :maxInstances integer},
   :readinessCheck {:path string,
                    :host string,
                    :failureThreshold integer,
                    :successThreshold integer,
                    :checkInterval string,
                    :timeout string,
                    :appStartTimeout string},
   :runtimeApiVersion string}
  
  Deploys code and resource files to a new version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId :servicesId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions"
     #{:appsId :servicesId}
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

(defn services-versions-patch$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/patch
  
  Required parameters: appsId, servicesId, versionsId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:serviceAccount string,
   :runtimeChannel string,
   :appEngineApis boolean,
   :automaticScaling {:maxConcurrentRequests integer,
                      :maxPendingLatency string,
                      :requestUtilization RequestUtilization,
                      :maxTotalInstances integer,
                      :standardSchedulerSettings StandardSchedulerSettings,
                      :diskUtilization DiskUtilization,
                      :cpuUtilization CpuUtilization,
                      :coolDownPeriod string,
                      :minPendingLatency string,
                      :minTotalInstances integer,
                      :minIdleInstances integer,
                      :maxIdleInstances integer,
                      :networkUtilization NetworkUtilization},
   :createdBy string,
   :libraries [{:name string, :version string}],
   :nobuildFilesRegex string,
   :servingStatus string,
   :endpointsApiService {:name string,
                         :configId string,
                         :rolloutStrategy string,
                         :disableTraceSampling boolean},
   :name string,
   :versionUrl string,
   :createTime string,
   :vm boolean,
   :betaSettings {},
   :handlers [{:urlRegex string,
               :staticFiles StaticFilesHandler,
               :script ScriptHandler,
               :apiEndpoint ApiEndpointHandler,
               :securityLevel string,
               :login string,
               :authFailAction string,
               :redirectHttpResponseCode string}],
   :env string,
   :buildEnvVariables {},
   :threadsafe boolean,
   :runtimeMainExecutablePath string,
   :livenessCheck {:path string,
                   :host string,
                   :failureThreshold integer,
                   :successThreshold integer,
                   :checkInterval string,
                   :timeout string,
                   :initialDelay string},
   :envVariables {},
   :vpcAccessConnector {:name string, :egressSetting string},
   :generatedCustomerMetadata {},
   :id string,
   :runtime string,
   :manualScaling {:instances integer},
   :zones [string],
   :entrypoint {:shell string},
   :deployment {:files {},
                :container ContainerInfo,
                :zip ZipInfo,
                :cloudBuildOptions CloudBuildOptions},
   :errorHandlers [{:errorCode string,
                    :staticFile string,
                    :mimeType string}],
   :network {:forwardedPorts [string],
             :instanceTag string,
             :name string,
             :subnetworkName string,
             :sessionAffinity boolean,
             :instanceIpMode string},
   :instanceClass string,
   :inboundServices [string],
   :resources {:cpu number,
               :diskGb number,
               :memoryGb number,
               :volumes [Volume],
               :kmsKeyReference string},
   :defaultExpiration string,
   :diskUsageBytes string,
   :flexibleRuntimeSettings {:operatingSystem string,
                             :runtimeVersion string},
   :apiConfig {:authFailAction string,
               :login string,
               :script string,
               :securityLevel string,
               :url string},
   :healthCheck {:disableHealthCheck boolean,
                 :host string,
                 :healthyThreshold integer,
                 :unhealthyThreshold integer,
                 :restartThreshold integer,
                 :checkInterval string,
                 :timeout string},
   :basicScaling {:idleTimeout string, :maxInstances integer},
   :readinessCheck {:path string,
                    :host string,
                    :failureThreshold integer,
                    :successThreshold integer,
                    :checkInterval string,
                    :timeout string,
                    :appStartTimeout string},
   :runtimeApiVersion string}
  
  Updates the specified Version resource. You can specify the following fields depending on the App Engine environment and type of scaling that the version resource uses:Standard environment instance_class (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.instance_class)automatic scaling in the standard environment: automatic_scaling.min_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.max_idle_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automaticScaling.standard_scheduler_settings.max_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.min_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.target_cpu_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings) automaticScaling.standard_scheduler_settings.target_throughput_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#StandardSchedulerSettings)basic scaling or manual scaling in the standard environment: serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status) manual_scaling.instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)Flexible environment serving_status (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.serving_status)automatic scaling in the flexible environment: automatic_scaling.min_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.max_total_instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.cool_down_period_sec (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling) automatic_scaling.cpu_utilization.target_utilization (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#Version.FIELDS.automatic_scaling)manual scaling in the flexible environment: manual_scaling.instances (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions#manualscaling)"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :servicesId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{:versionsId :appsId :servicesId}
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

(defn services-versions-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/delete
  
  Required parameters: appsId, servicesId, versionsId
  
  Optional parameters: none
  
  Deletes an existing Version resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :servicesId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}"
     #{:versionsId :appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/instances/list
  
  Required parameters: appsId, servicesId, versionsId
  
  Optional parameters: pageSize, pageToken
  
  Lists the instances of a version.Tip: To aggregate details about instances over time, see the Stackdriver Monitoring API (https://cloud.google.com/monitoring/api/ref_v3/rest/v3/projects.timeSeries/list)."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :servicesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances"
     #{:versionsId :appsId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/instances/get
  
  Required parameters: appsId, servicesId, versionsId, instancesId
  
  Optional parameters: none
  
  Gets instance information."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :instancesId :servicesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}"
     #{:versionsId :appsId :instancesId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/instances/delete
  
  Required parameters: appsId, servicesId, versionsId, instancesId
  
  Optional parameters: none
  
  Stops a running instance.The instance might be automatically recreated based on the scaling settings of the version. For more information, see \"How Instances are Managed\" (standard environment (https://cloud.google.com/appengine/docs/standard/python/how-instances-are-managed) | flexible environment (https://cloud.google.com/appengine/docs/flexible/python/how-instances-are-managed)).To ensure that instances are not re-created and avoid getting billed, you can stop all instances within the target version by changing the serving status of the version to STOPPED with the apps.services.versions.patch (https://cloud.google.com/appengine/docs/admin-api/reference/rest/v1/apps.services.versions/patch) method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :instancesId :servicesId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}"
     #{:versionsId :appsId :instancesId :servicesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn services-versions-instances-debug$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/services/versions/instances/debug
  
  Required parameters: appsId, servicesId, versionsId, instancesId
  
  Optional parameters: none
  
  Body: 
  
  {:sshKey string}
  
  Enables debugging on a VM instance. This allows you to use the SSH command to connect to the virtual machine where the instance lives. While in \"debug mode\", the instance continues to serve live traffic. You should delete the instance when you are done debugging and then allow the system to take over and determine if another instance should be started.Only applicable for instances in App Engine flexible environment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:versionsId :appsId :instancesId :servicesId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/services/{servicesId}/versions/{versionsId}/instances/{instancesId}:debug"
     #{:versionsId :appsId :instancesId :servicesId}
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

(defn firewall-ingressRules-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/list
  
  Required parameters: appsId
  
  Optional parameters: pageSize, pageToken, matchingAddress
  
  Lists the firewall rules of an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-batchUpdate$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/batchUpdate
  
  Required parameters: appsId
  
  Optional parameters: none
  
  Body: 
  
  {:ingressRules [{:priority integer,
                   :action string,
                   :sourceRange string,
                   :description string}]}
  
  Replaces the entire firewall ruleset in one bulk operation. This overrides and replaces the rules of an existing firewall with the new rules.If the final rule does not match traffic with the '*' wildcard IP range, then an \"allow all\" rule is explicitly added to the end of the list."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules:batchUpdate"
     #{:appsId}
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

(defn firewall-ingressRules-create$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/create
  
  Required parameters: appsId
  
  Optional parameters: none
  
  Body: 
  
  {:priority integer,
   :action string,
   :sourceRange string,
   :description string}
  
  Creates a firewall rule for the application."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules"
     #{:appsId}
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

(defn firewall-ingressRules-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/get
  
  Required parameters: appsId, ingressRulesId
  
  Optional parameters: none
  
  Gets the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ingressRulesId :appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{:ingressRulesId :appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn firewall-ingressRules-patch$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/patch
  
  Required parameters: appsId, ingressRulesId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:priority integer,
   :action string,
   :sourceRange string,
   :description string}
  
  Updates the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:ingressRulesId :appsId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{:ingressRulesId :appsId}
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

(defn firewall-ingressRules-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/firewall/ingressRules/delete
  
  Required parameters: appsId, ingressRulesId
  
  Optional parameters: none
  
  Deletes the specified firewall rule."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ingressRulesId :appsId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/firewall/ingressRules/{ingressRulesId}"
     #{:ingressRulesId :appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedDomains-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedDomains/list
  
  Required parameters: appsId
  
  Optional parameters: pageSize, pageToken
  
  Lists all domains the user is authorized to administer."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedDomains"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedCertificates/list
  
  Required parameters: appsId
  
  Optional parameters: view, pageSize, pageToken
  
  Lists all SSL certificates the user is authorized to administer."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedCertificates/get
  
  Required parameters: appsId, authorizedCertificatesId
  
  Optional parameters: view
  
  Gets the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:appsId :authorizedCertificatesId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{:appsId :authorizedCertificatesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn authorizedCertificates-create$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedCertificates/create
  
  Required parameters: appsId
  
  Optional parameters: none
  
  Body: 
  
  {:certificateRawData {:publicCertificate string, :privateKey string},
   :displayName string,
   :name string,
   :visibleDomainMappings [string],
   :id string,
   :domainMappingsCount integer,
   :domainNames [string],
   :managedCertificate {:lastRenewalTime string, :status string},
   :expireTime string}
  
  Uploads the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates"
     #{:appsId}
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

(defn authorizedCertificates-patch$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedCertificates/patch
  
  Required parameters: appsId, authorizedCertificatesId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:certificateRawData {:publicCertificate string, :privateKey string},
   :displayName string,
   :name string,
   :visibleDomainMappings [string],
   :id string,
   :domainMappingsCount integer,
   :domainNames [string],
   :managedCertificate {:lastRenewalTime string, :status string},
   :expireTime string}
  
  Updates the specified SSL certificate. To renew a certificate and maintain its existing domain mappings, update certificate_data with a new certificate. The new certificate must be applicable to the same domains as the original certificate. The certificate display_name may also be updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:appsId :authorizedCertificatesId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{:appsId :authorizedCertificatesId}
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

(defn authorizedCertificates-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/authorizedCertificates/delete
  
  Required parameters: appsId, authorizedCertificatesId
  
  Optional parameters: none
  
  Deletes the specified SSL certificate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:appsId :authorizedCertificatesId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/authorizedCertificates/{authorizedCertificatesId}"
     #{:appsId :authorizedCertificatesId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/domainMappings/list
  
  Required parameters: appsId
  
  Optional parameters: pageSize, pageToken
  
  Lists the domain mappings on an application."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/domainMappings/get
  
  Required parameters: appsId, domainMappingsId
  
  Optional parameters: none
  
  Gets the specified domain mapping."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :domainMappingsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{:appsId :domainMappingsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn domainMappings-create$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/domainMappings/create
  
  Required parameters: appsId
  
  Optional parameters: overrideStrategy
  
  Body: 
  
  {:name string,
   :id string,
   :sslSettings {:certificateId string,
                 :sslManagementType string,
                 :pendingManagedCertificateId string},
   :resourceRecords [{:name string, :rrdata string, :type string}]}
  
  Maps a domain to an application. A user must be authorized to administer a domain in order to map it to an application. For a list of available authorized domains, see AuthorizedDomains.ListAuthorizedDomains."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings"
     #{:appsId}
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

(defn domainMappings-patch$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/domainMappings/patch
  
  Required parameters: appsId, domainMappingsId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :id string,
   :sslSettings {:certificateId string,
                 :sslManagementType string,
                 :pendingManagedCertificateId string},
   :resourceRecords [{:name string, :rrdata string, :type string}]}
  
  Updates the specified domain mapping. To map an SSL certificate to a domain mapping, update certificate_id to point to an AuthorizedCertificate resource. A user must be authorized to administer the associated domain in order to update a DomainMapping resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:appsId :domainMappingsId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{:appsId :domainMappingsId}
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

(defn domainMappings-delete$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/domainMappings/delete
  
  Required parameters: appsId, domainMappingsId
  
  Optional parameters: none
  
  Deletes the specified domain mapping. A user must be authorized to administer the associated domain in order to delete a DomainMapping resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :domainMappingsId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/domainMappings/{domainMappingsId}"
     #{:appsId :domainMappingsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/locations/list
  
  Required parameters: appsId
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/locations"
     #{:appsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/appengine/docs/admin-api/api/reference/rest/v1/apps/locations/get
  
  Required parameters: appsId, locationsId
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/appengine.admin"
            "https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:appsId :locationsId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://appengine.googleapis.com/"
     "v1/apps/{appsId}/locations/{locationsId}"
     #{:appsId :locationsId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
