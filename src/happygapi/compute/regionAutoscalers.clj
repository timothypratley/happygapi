(ns happygapi.compute.regionAutoscalers
  "Compute Engine API: regionAutoscalers.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionAutoscalers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of autoscalers contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/get
  
  Required parameters: autoscaler, project, region
  
  Optional parameters: none
  
  Returns the specified autoscaler."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :autoscaler})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers/{autoscaler}"
     #{:region :project :autoscaler}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/insert
  
  Required parameters: project, region
  
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
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers"
     #{:region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/update
  
  Required parameters: project, region
  
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
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers"
     #{:region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/patch
  
  Required parameters: project, region
  
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
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers"
     #{:region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionAutoscalers/delete
  
  Required parameters: autoscaler, project, region
  
  Optional parameters: requestId
  
  Deletes the specified autoscaler."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :autoscaler})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/autoscalers/{autoscaler}"
     #{:region :project :autoscaler}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
