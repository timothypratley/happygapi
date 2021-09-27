(ns happygapi.monitoring.services
  "Cloud Monitoring API: services.
  Manages your Cloud Monitoring data and configurations. Most projects must be associated with a Workspace, with a few exceptions as noted on the individual method pages. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the Cloud Monitoring documentation (https://cloud.google.com/monitoring/docs).
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:meshIstio {:serviceNamespace string,
               :serviceName string,
               :meshUid string},
   :displayName string,
   :name string,
   :custom {},
   :cloudEndpoints {:service string},
   :clusterIstio {:serviceNamespace string,
                  :serviceName string,
                  :clusterName string,
                  :location string},
   :telemetry {:resourceName string},
   :istioCanonicalService {:canonicalService string,
                           :meshUid string,
                           :canonicalServiceNamespace string},
   :appEngine {:moduleId string},
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

(defn create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/create
  
  Required parameters: parent
  
  Optional parameters: serviceId
  
  Body: 
  
  {:meshIstio {:serviceNamespace string,
               :serviceName string,
               :meshUid string},
   :displayName string,
   :name string,
   :custom {},
   :cloudEndpoints {:service string},
   :clusterIstio {:serviceNamespace string,
                  :serviceName string,
                  :clusterName string,
                  :location string},
   :telemetry {:resourceName string},
   :istioCanonicalService {:canonicalService string,
                           :meshUid string,
                           :canonicalServiceNamespace string},
   :appEngine {:moduleId string},
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

(defn list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  List Services for this workspace."
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

(defn serviceLevelObjectives-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/list
  
  Required parameters: parent
  
  Optional parameters: view, pageToken, filter, pageSize
  
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

(defn serviceLevelObjectives-patch$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:goal number,
   :rollingPeriod string,
   :displayName string,
   :userLabels {},
   :serviceLevelIndicator {:requestBased RequestBasedSli,
                           :basicSli BasicSli,
                           :windowsBased WindowsBasedSli},
   :name string,
   :calendarPeriod string}
  
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

(defn serviceLevelObjectives-create$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/services/serviceLevelObjectives/create
  
  Required parameters: parent
  
  Optional parameters: serviceLevelObjectiveId
  
  Body: 
  
  {:goal number,
   :rollingPeriod string,
   :displayName string,
   :userLabels {},
   :serviceLevelIndicator {:requestBased RequestBasedSli,
                           :basicSli BasicSli,
                           :windowsBased WindowsBasedSli},
   :name string,
   :calendarPeriod string}
  
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
