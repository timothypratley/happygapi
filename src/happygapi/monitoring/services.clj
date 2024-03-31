(ns happygapi.monitoring.services
  "Cloud Monitoring API: services.
  Manages your Cloud Monitoring data and configurations.
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId
  
  Body: 
  
  {:basicService {:serviceType string, :serviceLabels {}},
   :meshIstio {:meshUid string,
               :serviceNamespace string,
               :serviceName string},
   :displayName string,
   :name string,
   :gkeWorkload {:projectId string,
                 :location string,
                 :clusterName string,
                 :namespaceName string,
                 :topLevelControllerType string,
                 :topLevelControllerName string},
   :custom {},
   :cloudRun {:serviceName string, :location string},
   :cloudEndpoints {:service string},
   :gkeService {:projectId string,
                :location string,
                :clusterName string,
                :namespaceName string,
                :serviceName string},
   :clusterIstio {:location string,
                  :clusterName string,
                  :serviceNamespace string,
                  :serviceName string},
   :telemetry {:resourceName string},
   :istioCanonicalService {:meshUid string,
                           :canonicalServiceNamespace string,
                           :canonicalService string},
   :appEngine {:moduleId string},
   :gkeNamespace {:projectId string,
                  :location string,
                  :clusterName string,
                  :namespaceName string},
   :userLabels {}}
  
  Create a Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/services"
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

(defn get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get the named Service."
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

(defn list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  List Services for this Metrics Scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/services"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:basicService {:serviceType string, :serviceLabels {}},
   :meshIstio {:meshUid string,
               :serviceNamespace string,
               :serviceName string},
   :displayName string,
   :name string,
   :gkeWorkload {:projectId string,
                 :location string,
                 :clusterName string,
                 :namespaceName string,
                 :topLevelControllerType string,
                 :topLevelControllerName string},
   :custom {},
   :cloudRun {:serviceName string, :location string},
   :cloudEndpoints {:service string},
   :gkeService {:projectId string,
                :location string,
                :clusterName string,
                :namespaceName string,
                :serviceName string},
   :clusterIstio {:location string,
                  :clusterName string,
                  :serviceNamespace string,
                  :serviceName string},
   :telemetry {:resourceName string},
   :istioCanonicalService {:meshUid string,
                           :canonicalServiceNamespace string,
                           :canonicalService string},
   :appEngine {:moduleId string},
   :gkeNamespace {:projectId string,
                  :location string,
                  :clusterName string,
                  :namespaceName string},
   :userLabels {}}
  
  Update this Service."
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

(defn delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Soft delete this Service."
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

(defn serviceLevelObjectives-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/create
  
  Required parameters: parent
  
  Optional parameters: serviceLevelObjectiveId
  
  Body: 
  
  {:name string,
   :displayName string,
   :serviceLevelIndicator {:basicSli BasicSli,
                           :requestBased RequestBasedSli,
                           :windowsBased WindowsBasedSli},
   :goal number,
   :rollingPeriod string,
   :calendarPeriod string,
   :userLabels {}}
  
  Create a ServiceLevelObjective for the given Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/serviceLevelObjectives"
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

(defn serviceLevelObjectives-get$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Get a ServiceLevelObjective by name."
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

(defn serviceLevelObjectives-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken, view
  
  List the ServiceLevelObjectives for the given Service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+parent}/serviceLevelObjectives"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn serviceLevelObjectives-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :serviceLevelIndicator {:basicSli BasicSli,
                           :requestBased RequestBasedSli,
                           :windowsBased WindowsBasedSli},
   :goal number,
   :rollingPeriod string,
   :calendarPeriod string,
   :userLabels {}}
  
  Update the given ServiceLevelObjective."
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

(defn serviceLevelObjectives-delete$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete the given ServiceLevelObjective."
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
