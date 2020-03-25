(ns happygapi.servicecontrol.services
  "Service Control API: services.
  Provides control plane functionality to managed services, such as logging, monitoring, and status checks.
  See: https://cloud.google.com/service-control/api/reference/rest/v1/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn allocateQuota$
  "https://cloud.google.com/service-control/api/reference/rest/v1/services/allocateQuota
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:serviceConfigId string,
   :allocateOperation {:consumerId string,
                       :operationId string,
                       :quotaMode string,
                       :methodName string,
                       :quotaMetrics [MetricValueSet],
                       :labels {}}}
  
  Attempts to allocate quota for the specified consumer. It should be called
  before the operation is executed.
  
  This method requires the `servicemanagement.services.quota`
  permission on the specified service. For more information, see
  [Cloud IAM](https://cloud.google.com/iam).
  
  **NOTE:** The client **must** fail-open on server errors `INTERNAL`,
  `UNKNOWN`, `DEADLINE_EXCEEDED`, and `UNAVAILABLE`. To ensure system
  reliability, the server may inject these errors to prohibit any hard
  dependency on the quota functionality."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/servicecontrol"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicecontrol.googleapis.com/"
     "v1/services/{serviceName}:allocateQuota"
     #{:serviceName}
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

(defn check$
  "https://cloud.google.com/service-control/api/reference/rest/v1/services/check
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:serviceConfigId string,
   :skipActivationCheck boolean,
   :operation {:consumerId string,
               :labels {},
               :startTime string,
               :operationName string,
               :endTime string,
               :quotaProperties QuotaProperties,
               :traceSpans [TraceSpan],
               :metricValueSets [MetricValueSet],
               :resources [ResourceInfo],
               :userLabels {},
               :operationId string,
               :logEntries [LogEntry],
               :importance string},
   :requestProjectSettings boolean}
  
  Checks whether an operation on a service should be allowed to proceed
  based on the configuration of the service and related policies. It must be
  called before the operation is executed.
  
  If feasible, the client should cache the check results and reuse them for
  60 seconds. In case of any server errors, the client should rely on the
  cached results for much longer time to avoid outage.
  WARNING: There is general 60s delay for the configuration and policy
  propagation, therefore callers MUST NOT depend on the `Check` method having
  the latest policy information.
  
  NOTE: the CheckRequest has the size limit of 64KB.
  
  This method requires the `servicemanagement.services.check` permission
  on the specified service. For more information, see
  [Cloud IAM](https://cloud.google.com/iam)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/servicecontrol"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicecontrol.googleapis.com/"
     "v1/services/{serviceName}:check"
     #{:serviceName}
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

(defn report$
  "https://cloud.google.com/service-control/api/reference/rest/v1/services/report
  
  Required parameters: serviceName
  
  Optional parameters: none
  
  Body: 
  
  {:operations [{:consumerId string,
                 :labels {},
                 :startTime string,
                 :operationName string,
                 :endTime string,
                 :quotaProperties QuotaProperties,
                 :traceSpans [TraceSpan],
                 :metricValueSets [MetricValueSet],
                 :resources [ResourceInfo],
                 :userLabels {},
                 :operationId string,
                 :logEntries [LogEntry],
                 :importance string}],
   :serviceConfigId string}
  
  Reports operation results to Google Service Control, such as logs and
  metrics. It should be called after an operation is completed.
  
  If feasible, the client should aggregate reporting data for up to 5
  seconds to reduce API traffic. Limiting aggregation to 5 seconds is to
  reduce data loss during client crashes. Clients should carefully choose
  the aggregation time window to avoid data loss risk more than 0.01%
  for business and compliance reasons.
  
  NOTE: the ReportRequest has the size limit (wire-format byte size) of
  1MB.
  
  This method requires the `servicemanagement.services.report` permission
  on the specified service. For more information, see
  [Google Cloud IAM](https://cloud.google.com/iam)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/servicecontrol"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:serviceName})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicecontrol.googleapis.com/"
     "v1/services/{serviceName}:report"
     #{:serviceName}
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
