(ns happygapi.monitoring.projects
  "Cloud Monitoring API: projects.
  Manages your Cloud Monitoring data and configurations.
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn notificationChannelDescriptors-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannelDescriptors/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Lists the descriptors for supported channel types. The use of descriptors makes it possible for new channel types to be dynamically added."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/notificationChannelDescriptors"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationChannelDescriptors-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannelDescriptors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single channel descriptor. The descriptor indicates which fields are expected / permitted for a notification channel of the given type."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn timeSeries-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/timeSeries/list
  
  Required parameters: name
  
  Optional parameters: aggregation.perSeriesAligner, interval.startTime, secondaryAggregation.alignmentPeriod, aggregation.alignmentPeriod, secondaryAggregation.groupByFields, pageToken, aggregation.crossSeriesReducer, interval.endTime, filter, pageSize, aggregation.groupByFields, secondaryAggregation.crossSeriesReducer, secondaryAggregation.perSeriesAligner, view, orderBy
  
  Lists time series that match a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/timeSeries"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn timeSeries-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/timeSeries/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timeSeries [{:metric Metric,
                 :resource MonitoredResource,
                 :metadata MonitoredResourceMetadata,
                 :metricKind string,
                 :valueType string,
                 :points [Point],
                 :unit string}]}
  
  Creates or adds data to one or more time series. The response is empty if all time series in the request were written. If any time series could not be written, a corresponding failure message is included in the error response. This method does not support resource locations constraint of an organization policy (https://cloud.google.com/resource-manager/docs/organization-policy/defining-locations#setting_the_organization_policy)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/timeSeries"
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

(defn timeSeries-createService$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/timeSeries/createService
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:timeSeries [{:metric Metric,
                 :resource MonitoredResource,
                 :metadata MonitoredResourceMetadata,
                 :metricKind string,
                 :valueType string,
                 :points [Point],
                 :unit string}]}
  
  Creates or adds data to one or more service time series. A service time series is a time series for a metric from a Google Cloud service. The response is empty if all time series in the request were written. If any time series could not be written, a corresponding failure message is included in the error response. This endpoint rejects writes to user-defined metrics. This method is only for use by Google Cloud services. Use projects.timeSeries.create instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/timeSeries:createService"
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

(defn timeSeries-query$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/timeSeries/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:query string, :pageSize integer, :pageToken string}
  
  Queries time series using Monitoring Query Language."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/timeSeries:query"
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

(defn monitoredResourceDescriptors-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/monitoredResourceDescriptors/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists monitored resource descriptors that match a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/monitoredResourceDescriptors"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn monitoredResourceDescriptors-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/monitoredResourceDescriptors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single monitored resource descriptor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alertPolicies-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/list
  
  Required parameters: name
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists the existing alerting policies for the workspace."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/alertPolicies"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alertPolicies-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single alerting policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alertPolicies-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :documentation {:content string, :mimeType string, :subject string},
   :combiner string,
   :alertStrategy {:notificationRateLimit NotificationRateLimit,
                   :autoClose string,
                   :notificationChannelStrategy [NotificationChannelStrategy]},
   :conditions [{:name string,
                 :displayName string,
                 :conditionThreshold MetricThreshold,
                 :conditionAbsent MetricAbsence,
                 :conditionMatchedLog LogMatch,
                 :conditionMonitoringQueryLanguage MonitoringQueryLanguageCondition,
                 :conditionPrometheusQueryLanguage PrometheusQueryLanguageCondition}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :mutationRecord {:mutateTime string, :mutatedBy string},
   :severity string,
   :userLabels {},
   :enabled boolean,
   :validity {:code integer, :message string, :details [{}]},
   :notificationChannels [string]}
  
  Creates a new alerting policy.Design your application to single-thread API calls that modify the state of alerting policies in a single project. This includes calls to CreateAlertPolicy, DeleteAlertPolicy and UpdateAlertPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/alertPolicies"
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

(defn alertPolicies-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an alerting policy.Design your application to single-thread API calls that modify the state of alerting policies in a single project. This includes calls to CreateAlertPolicy, DeleteAlertPolicy and UpdateAlertPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn alertPolicies-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :name string,
   :documentation {:content string, :mimeType string, :subject string},
   :combiner string,
   :alertStrategy {:notificationRateLimit NotificationRateLimit,
                   :autoClose string,
                   :notificationChannelStrategy [NotificationChannelStrategy]},
   :conditions [{:name string,
                 :displayName string,
                 :conditionThreshold MetricThreshold,
                 :conditionAbsent MetricAbsence,
                 :conditionMatchedLog LogMatch,
                 :conditionMonitoringQueryLanguage MonitoringQueryLanguageCondition,
                 :conditionPrometheusQueryLanguage PrometheusQueryLanguageCondition}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :mutationRecord {:mutateTime string, :mutatedBy string},
   :severity string,
   :userLabels {},
   :enabled boolean,
   :validity {:code integer, :message string, :details [{}]},
   :notificationChannels [string]}
  
  Updates an alerting policy. You can either replace the entire policy with a new one or replace only certain fields in the current alerting policy by specifying the fields to be updated via updateMask. Returns the updated alerting policy.Design your application to single-thread API calls that modify the state of alerting policies in a single project. This includes calls to CreateAlertPolicy, DeleteAlertPolicy and UpdateAlertPolicy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
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

(defn uptimeCheckConfigs-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the existing valid Uptime check configurations for the project (leaving out any invalid configurations)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/uptimeCheckConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn uptimeCheckConfigs-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single Uptime check configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn uptimeCheckConfigs-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:httpCheck {:path string,
               :useSsl boolean,
               :port integer,
               :headers {},
               :authInfo BasicAuthentication,
               :acceptedResponseStatusCodes [ResponseStatusCode],
               :maskHeaders boolean,
               :contentType string,
               :customContentType string,
               :pingConfig PingConfig,
               :requestMethod string,
               :body string,
               :validateSsl boolean},
   :displayName string,
   :name string,
   :monitoredResource {:type string, :labels {}},
   :contentMatchers [{:content string,
                      :matcher string,
                      :jsonPathMatcher JsonPathMatcher}],
   :selectedRegions [string],
   :internalCheckers [{:name string,
                       :displayName string,
                       :network string,
                       :gcpZone string,
                       :peerProjectId string,
                       :state string}],
   :syntheticMonitor {:cloudFunctionV2 CloudFunctionV2Target},
   :resourceGroup {:groupId string, :resourceType string},
   :tcpCheck {:port integer, :pingConfig PingConfig},
   :checkerType string,
   :period string,
   :timeout string,
   :userLabels {},
   :isInternal boolean}
  
  Creates a new Uptime check configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/uptimeCheckConfigs"
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

(defn uptimeCheckConfigs-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:httpCheck {:path string,
               :useSsl boolean,
               :port integer,
               :headers {},
               :authInfo BasicAuthentication,
               :acceptedResponseStatusCodes [ResponseStatusCode],
               :maskHeaders boolean,
               :contentType string,
               :customContentType string,
               :pingConfig PingConfig,
               :requestMethod string,
               :body string,
               :validateSsl boolean},
   :displayName string,
   :name string,
   :monitoredResource {:type string, :labels {}},
   :contentMatchers [{:content string,
                      :matcher string,
                      :jsonPathMatcher JsonPathMatcher}],
   :selectedRegions [string],
   :internalCheckers [{:name string,
                       :displayName string,
                       :network string,
                       :gcpZone string,
                       :peerProjectId string,
                       :state string}],
   :syntheticMonitor {:cloudFunctionV2 CloudFunctionV2Target},
   :resourceGroup {:groupId string, :resourceType string},
   :tcpCheck {:port integer, :pingConfig PingConfig},
   :checkerType string,
   :period string,
   :timeout string,
   :userLabels {},
   :isInternal boolean}
  
  Updates an Uptime check configuration. You can either replace the entire configuration with a new one or replace only certain fields in the current configuration by specifying the fields to be updated via updateMask. Returns the updated configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
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

(defn uptimeCheckConfigs-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an Uptime check configuration. Note that this method will fail if the Uptime check configuration is referenced by an alert policy or other dependent configs that would be rendered invalid by the deletion."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn metricDescriptors-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists metric descriptors that match a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/metricDescriptors"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn metricDescriptors-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single metric descriptor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn metricDescriptors-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels [{:key string, :valueType string, :description string}],
   :valueType string,
   :monitoredResourceTypes [string],
   :unit string,
   :displayName string,
   :name string,
   :type string,
   :metricKind string,
   :launchStage string,
   :metadata {:launchStage string,
              :samplePeriod string,
              :ingestDelay string}}
  
  Creates a new metric descriptor. The creation is executed asynchronously. User-created metric descriptors define custom metrics (https://cloud.google.com/monitoring/custom-metrics). The metric descriptor is updated if it already exists, except that metric labels are never removed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/metricDescriptors"
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

(defn metricDescriptors-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a metric descriptor. Only user-created custom metrics (https://cloud.google.com/monitoring/custom-metrics) can be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snoozes-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/snoozes/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :criteria {:policies [string]},
   :interval {:endTime string, :startTime string},
   :displayName string}
  
  Creates a Snooze that will prevent alerts, which match the provided criteria, from being opened. The Snooze applies for a specific time interval."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/snoozes"
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

(defn snoozes-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/snoozes/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists the Snoozes associated with a project. Can optionally pass in filter, which specifies predicates to match Snoozes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/snoozes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snoozes-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/snoozes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a Snooze by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snoozes-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/snoozes/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :criteria {:policies [string]},
   :interval {:endTime string, :startTime string},
   :displayName string}
  
  Updates a Snooze, identified by its name, with the parameters in the given Snooze object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
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

(defn collectdTimeSeries-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/collectdTimeSeries/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:resource {:type string, :labels {}},
   :collectdVersion string,
   :collectdPayloads [{:values [CollectdValue],
                       :startTime string,
                       :endTime string,
                       :plugin string,
                       :pluginInstance string,
                       :type string,
                       :typeInstance string,
                       :metadata {}}]}
  
  Cloud Monitoring Agent only: Creates a new time series.This method is only for use by the Cloud Monitoring Agent. Use projects.timeSeries.create instead."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/collectdTimeSeries"
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

(defn groups-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/list
  
  Required parameters: name
  
  Optional parameters: childrenOfGroup, ancestorsOfGroup, descendantsOfGroup, pageSize, pageToken
  
  Lists the existing groups."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/groups"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/create
  
  Required parameters: name
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:name string,
   :displayName string,
   :parentName string,
   :filter string,
   :isCluster boolean}
  
  Creates a new group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/groups"
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

(defn groups-update$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/update
  
  Required parameters: name
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:name string,
   :displayName string,
   :parentName string,
   :filter string,
   :isCluster boolean}
  
  Updates an existing group. You can change any group attributes except name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
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

(defn groups-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/delete
  
  Required parameters: name
  
  Optional parameters: recursive
  
  Deletes an existing group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn groups-members-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/members/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter, interval.endTime, interval.startTime
  
  Lists the monitored resources that are members of a group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/members"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationChannels-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/list
  
  Required parameters: name
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists the notification channels that have been created for the project. To list the types of notification channels that are supported, use the ListNotificationChannelDescriptors method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/notificationChannels"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationChannels-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single notification channel. The channel includes the relevant configuration details with which the channel was created. However, the response may truncate or omit passwords, API keys, or other private key matter and thus the response may not be 100% identical to the information that was supplied in the call to the create method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationChannels-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :name string,
   :type string,
   :mutationRecords [{:mutateTime string, :mutatedBy string}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :verificationStatus string,
   :userLabels {},
   :enabled boolean}
  
  Creates a new notification channel, representing a single notification endpoint such as an email address, SMS number, or PagerDuty service.Design your application to single-thread API calls that modify the state of notification channels in a single project. This includes calls to CreateNotificationChannel, DeleteNotificationChannel and UpdateNotificationChannel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/notificationChannels"
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

(defn notificationChannels-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :displayName string,
   :name string,
   :type string,
   :mutationRecords [{:mutateTime string, :mutatedBy string}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :verificationStatus string,
   :userLabels {},
   :enabled boolean}
  
  Updates a notification channel. Fields not specified in the field mask remain unchanged.Design your application to single-thread API calls that modify the state of notification channels in a single project. This includes calls to CreateNotificationChannel, DeleteNotificationChannel and UpdateNotificationChannel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
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

(defn notificationChannels-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a notification channel.Design your application to single-thread API calls that modify the state of notification channels in a single project. This includes calls to CreateNotificationChannel, DeleteNotificationChannel and UpdateNotificationChannel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn notificationChannels-sendVerificationCode$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/sendVerificationCode
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Causes a verification code to be delivered to the channel. The code can then be supplied in VerifyNotificationChannel to verify the channel."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}:sendVerificationCode"
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

(defn notificationChannels-getVerificationCode$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/getVerificationCode
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:expireTime string}
  
  Requests a verification code for an already verified channel that can then be used in a call to VerifyNotificationChannel() on a different channel with an equivalent identity in the same or in a different project. This makes it possible to copy a channel between projects without requiring manual reverification of the channel. If the channel is not in the verified state, this method will fail (in other words, this may only be used if the SendNotificationChannelVerificationCode and VerifyNotificationChannel paths have already been used to put the given channel into the verified state).There is no guarantee that the verification codes returned by this method will be of a similar structure or form as the ones that are delivered to the channel via SendNotificationChannelVerificationCode; while VerifyNotificationChannel() will recognize both the codes delivered via SendNotificationChannelVerificationCode() and returned from GetNotificationChannelVerificationCode(), it is typically the case that the verification codes delivered via SendNotificationChannelVerificationCode() will be shorter and also have a shorter expiration (e.g. codes such as \"G-123456\") whereas GetVerificationCode() will typically return a much longer, websafe base 64 encoded string that has a longer expiration time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}:getVerificationCode"
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

(defn notificationChannels-verify$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/verify
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:code string}
  
  Verifies a NotificationChannel by proving receipt of the code delivered to the channel as a result of calling SendNotificationChannelVerificationCode."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}:verify"
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
