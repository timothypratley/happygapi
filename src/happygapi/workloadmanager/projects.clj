(ns happygapi.workloadmanager.projects
  "Workload Manager API: projects.
  Workload Manager is a service that provides tooling for enterprise workloads to automate the deployment and validation of your workloads against best practices and recommendations.
  See: https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-insights-writeInsight$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/insights/writeInsight
  
  Required parameters: location
  
  Optional parameters: none
  
  Body: 
  
  {:insight {:sentTime string,
             :sapValidation SapValidation,
             :sapDiscovery SapDiscovery,
             :sqlserverValidation SqlserverValidation,
             :instanceId string},
   :requestId string}
  
  Write the data insights to workload manager data warehouse."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+location}/insights:writeInsight"
     #{:location}
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

(defn locations-operations-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-operations-cancel$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+name}:cancel"
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

(defn locations-evaluations-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Evaluations in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/evaluations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-evaluations-get$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-evaluations-create$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/create
  
  Required parameters: parent
  
  Optional parameters: evaluationId, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :schedule string,
   :resourceStatus {:rulesNewerVersions [string], :state string},
   :name string,
   :createTime string,
   :ruleVersions [string],
   :updateTime string,
   :ruleNames [string],
   :resourceFilter {:scopes [string],
                    :resourceIdPatterns [string],
                    :inclusionLabels {},
                    :gceInstanceFilter GceInstanceFilter},
   :bigQueryDestination {:destinationDataset string,
                         :createNewResultsTable boolean},
   :customRulesBucket string}
  
  Creates a new Evaluation in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/evaluations"
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

(defn locations-evaluations-delete$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-evaluations-executions-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists Executions in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/executions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-evaluations-executions-get$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-evaluations-executions-run$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:executionId string,
   :execution {:name string,
               :startTime string,
               :endTime string,
               :inventoryTime string,
               :state string,
               :evaluationId string,
               :labels {},
               :runType string},
   :requestId string}
  
  Creates a new Execution in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+name}/executions:run"
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

(defn locations-evaluations-executions-delete$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Deletes a single Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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

(defn locations-evaluations-executions-results-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/results/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List the running result of a single Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/results"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-evaluations-executions-scannedResources-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/evaluations/executions/scannedResources/list
  
  Required parameters: parent
  
  Optional parameters: rule, pageSize, pageToken, filter, orderBy
  
  List all scanned resources for a single Execution."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/scannedResources"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-rules-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/rules/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, customRulesBucket
  
  Lists rules in a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/rules"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloadProfiles-list$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/workloadProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  List workloads"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
     "v1/{+parent}/workloadProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workloadProfiles-get$
  "https://cloud.google.com/workload-manager/docsapi/reference/rest/v1/projects/locations/workloadProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single workload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workloadmanager.googleapis.com/"
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
