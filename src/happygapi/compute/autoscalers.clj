(ns happygapi.compute.autoscalers
  "Compute Engine API: autoscalers.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/autoscalers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of autoscalers contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of autoscalers. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/autoscalers"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/get
  
  Required parameters: autoscaler, project, zone
  
  Optional parameters: none
  
  Returns the specified autoscaler resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :autoscaler})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers/{autoscaler}"
     #{:zone :project :autoscaler}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :scalingScheduleStatus {},
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :mode string,
                       :minNumReplicas integer,
                       :maxNumReplicas integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :scaleInControl AutoscalingPolicyScaleInControl,
                       :scalingSchedules {},
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization]},
   :target string}
  
  Creates an autoscaler in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/update
  
  Required parameters: project, zone
  
  Optional parameters: autoscaler, requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :scalingScheduleStatus {},
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :mode string,
                       :minNumReplicas integer,
                       :maxNumReplicas integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :scaleInControl AutoscalingPolicyScaleInControl,
                       :scalingSchedules {},
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization]},
   :target string}
  
  Updates an autoscaler in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/patch
  
  Required parameters: project, zone
  
  Optional parameters: autoscaler, requestId
  
  Body: 
  
  {:description string,
   :statusDetails [{:message string, :type string}],
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :region string,
   :recommendedSize integer,
   :scalingScheduleStatus {},
   :status string,
   :id string,
   :kind string,
   :autoscalingPolicy {:coolDownPeriodSec integer,
                       :mode string,
                       :minNumReplicas integer,
                       :maxNumReplicas integer,
                       :cpuUtilization AutoscalingPolicyCpuUtilization,
                       :scaleInControl AutoscalingPolicyScaleInControl,
                       :scalingSchedules {},
                       :loadBalancingUtilization AutoscalingPolicyLoadBalancingUtilization,
                       :customMetricUtilizations [AutoscalingPolicyCustomMetricUtilization]},
   :target string}
  
  Updates an autoscaler in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers"
     #{:zone :project}
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/autoscalers/delete
  
  Required parameters: autoscaler, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified autoscaler."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :autoscaler})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/autoscalers/{autoscaler}"
     #{:zone :project :autoscaler}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
