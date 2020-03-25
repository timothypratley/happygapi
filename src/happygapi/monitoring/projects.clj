(ns happygapi.monitoring.projects
  "Cloud Monitoring API: projects.
  Manages your Cloud Monitoring data and configurations. Most projects must be associated with a Workspace, with a few exceptions as noted on the individual method pages. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the Cloud Monitoring documentation.
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn notificationChannelDescriptors-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannelDescriptors/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
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
  
  Optional parameters: aggregation.perSeriesAligner, interval.startTime, aggregation.alignmentPeriod, pageToken, aggregation.crossSeriesReducer, interval.endTime, filter, pageSize, aggregation.groupByFields, view, orderBy
  
  Lists time series that match a filter. This method does not require a Workspace."
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
  
  {:timeSeries [{:metadata MonitoredResourceMetadata,
                 :valueType string,
                 :metricKind string,
                 :points [Point],
                 :metric Metric,
                 :resource MonitoredResource}]}
  
  Creates or adds data to one or more time series. The response is empty if all time series in the request were written. If any time series could not be written, a corresponding failure message is included in the error response."
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

(defn timeSeries-query$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/timeSeries/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer, :query string}
  
  Queries time series using the time series query language. This method does not require a Workspace."
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
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists monitored resource descriptors that match a filter. This method does not require a Workspace."
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
  
  Gets a single monitored resource descriptor. This method does not require a Workspace."
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
  
  Optional parameters: orderBy, pageToken, pageSize, filter
  
  Lists the existing alerting policies for the project."
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

(defn alertPolicies-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :name string,
   :documentation {:content string, :mimeType string},
   :combiner string,
   :conditions [{:name string,
                 :displayName string,
                 :conditionThreshold MetricThreshold,
                 :conditionAbsent MetricAbsence,
                 :conditionTimeSeriesQueryLanguage TimeSeriesQueryLanguageCondition}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :mutationRecord {:mutateTime string, :mutatedBy string},
   :userLabels {},
   :enabled boolean,
   :validity {:code integer, :message string, :details [{}]},
   :notificationChannels [string]}
  
  Updates an alerting policy. You can either replace the entire policy with a new one or replace only certain fields in the current alerting policy by specifying the fields to be updated via updateMask. Returns the updated alerting policy."
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

(defn alertPolicies-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/alertPolicies/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :documentation {:content string, :mimeType string},
   :combiner string,
   :conditions [{:name string,
                 :displayName string,
                 :conditionThreshold MetricThreshold,
                 :conditionAbsent MetricAbsence,
                 :conditionTimeSeriesQueryLanguage TimeSeriesQueryLanguageCondition}],
   :creationRecord {:mutateTime string, :mutatedBy string},
   :mutationRecord {:mutateTime string, :mutatedBy string},
   :userLabels {},
   :enabled boolean,
   :validity {:code integer, :message string, :details [{}]},
   :notificationChannels [string]}
  
  Creates a new alerting policy."
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
  
  Deletes an alerting policy."
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

(defn uptimeCheckConfigs-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
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

(defn uptimeCheckConfigs-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:httpCheck {:useSsl boolean,
               :maskHeaders boolean,
               :authInfo BasicAuthentication,
               :validateSsl boolean,
               :headers {},
               :path string,
               :port integer},
   :displayName string,
   :name string,
   :monitoredResource {:type string, :labels {}},
   :contentMatchers [{:content string, :matcher string}],
   :selectedRegions [string],
   :internalCheckers [{:state string,
                       :peerProjectId string,
                       :name string,
                       :gcpZone string,
                       :network string,
                       :displayName string}],
   :resourceGroup {:resourceType string, :groupId string},
   :tcpCheck {:port integer},
   :period string,
   :timeout string,
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

(defn uptimeCheckConfigs-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/uptimeCheckConfigs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:httpCheck {:useSsl boolean,
               :maskHeaders boolean,
               :authInfo BasicAuthentication,
               :validateSsl boolean,
               :headers {},
               :path string,
               :port integer},
   :displayName string,
   :name string,
   :monitoredResource {:type string, :labels {}},
   :contentMatchers [{:content string, :matcher string}],
   :selectedRegions [string],
   :internalCheckers [{:state string,
                       :peerProjectId string,
                       :name string,
                       :gcpZone string,
                       :network string,
                       :displayName string}],
   :resourceGroup {:resourceType string, :groupId string},
   :tcpCheck {:port integer},
   :period string,
   :timeout string,
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

(defn metricDescriptors-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :labels [{:key string, :description string, :valueType string}],
   :valueType string,
   :monitoredResourceTypes [string],
   :unit string,
   :displayName string,
   :name string,
   :type string,
   :metricKind string,
   :launchStage string,
   :metadata {:ingestDelay string,
              :launchStage string,
              :samplePeriod string}}
  
  Creates a new metric descriptor. User-created metric descriptors define custom metrics (https://cloud.google.com/monitoring/custom-metrics)."
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

(defn metricDescriptors-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/metricDescriptors/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists metric descriptors that match a filter. This method does not require a Workspace."
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
  
  Gets a single metric descriptor. This method does not require a Workspace."
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

(defn collectdTimeSeries-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/collectdTimeSeries/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:resource {:type string, :labels {}},
   :collectdPayloads [{:endTime string,
                       :startTime string,
                       :values [CollectdValue],
                       :typeInstance string,
                       :metadata {},
                       :type string,
                       :plugin string,
                       :pluginInstance string}],
   :collectdVersion string}
  
  Stackdriver Monitoring Agent only: Creates a new time series.<aside class=\"caution\">This method is only for use by the Stackdriver Monitoring Agent. Use projects.timeSeries.create instead.</aside>"
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

(defn groups-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/create
  
  Required parameters: name
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:name string,
   :parentName string,
   :displayName string,
   :isCluster boolean,
   :filter string}
  
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

(defn groups-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/list
  
  Required parameters: name
  
  Optional parameters: pageSize, ancestorsOfGroup, childrenOfGroup, descendantsOfGroup, pageToken
  
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

(defn groups-update$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/update
  
  Required parameters: name
  
  Optional parameters: validateOnly
  
  Body: 
  
  {:name string,
   :parentName string,
   :displayName string,
   :isCluster boolean,
   :filter string}
  
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

(defn groups-members-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/groups/members/list
  
  Required parameters: name
  
  Optional parameters: pageToken, interval.startTime, pageSize, interval.endTime, filter
  
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

(defn notificationChannels-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes a notification channel."
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

(defn notificationChannels-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/list
  
  Required parameters: name
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Lists the notification channels that have been created for the project."
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

(defn notificationChannels-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :verificationStatus string,
   :type string,
   :userLabels {},
   :description string,
   :displayName string,
   :enabled boolean,
   :labels {}}
  
  Creates a new notification channel, representing a single notification endpoint such as an email address, SMS number, or PagerDuty service."
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

(defn notificationChannels-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/projects/notificationChannels/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :verificationStatus string,
   :type string,
   :userLabels {},
   :description string,
   :displayName string,
   :enabled boolean,
   :labels {}}
  
  Updates a notification channel. Fields not specified in the field mask remain unchanged."
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
