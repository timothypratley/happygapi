(ns happygapi.workflowexecutions.projects
  "Workflow Executions API: projects.
  Execute workflows created with Workflows API.
  See: https://cloud.google.com/workflowsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-workflows-triggerPubsubExecution$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/triggerPubsubExecution
  
  Required parameters: workflow
  
  Optional parameters: none
  
  Body: 
  
  {:subscription string,
   :message {:data string,
             :attributes {},
             :messageId string,
             :publishTime string,
             :orderingKey string},
   :GCPCloudEventsMode string,
   :deliveryAttempt integer}
  
  Triggers a new execution using the latest revision of the given workflow by a Pub/Sub push notification."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workflow})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
     "v1/{+workflow}:triggerPubsubExecution"
     #{:workflow}
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

(defn locations-workflows-executions-list$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view, filter, orderBy
  
  Returns a list of executions which belong to the workflow with the given name. The method returns executions of all workflow revisions. Returned executions are ordered by their start time (newest first)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
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

(defn locations-workflows-executions-create$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :startTime string,
   :workflowRevisionId string,
   :name string,
   :endTime string,
   :createTime string,
   :duration string,
   :state string,
   :stateError {:details string, :type string},
   :argument string,
   :status {:currentSteps [Step]},
   :result string,
   :error {:payload string, :context string, :stackTrace StackTrace},
   :callLogLevel string,
   :disableConcurrencyQuotaOverflowBuffering boolean}
  
  Creates a new execution using the latest revision of the given workflow. For more information, see Execute a workflow."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
     "v1/{+parent}/executions"
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

(defn locations-workflows-executions-get$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/get
  
  Required parameters: name
  
  Optional parameters: view
  
  Returns an execution of the given name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
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

(defn locations-workflows-executions-cancel$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels an execution of the given name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
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

(defn locations-workflows-executions-exportData$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/exportData
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns all metadata stored about an execution, excluding most data that is already accessible using other API methods."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
     "v1/{+name}:exportData"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflows-executions-callbacks-list$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/callbacks/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of active callbacks that belong to the execution with the given name. The returned callbacks are ordered by callback ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
     "v1/{+parent}/callbacks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflows-executions-stepEntries-list$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/stepEntries/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, skip, filter, orderBy
  
  Lists step entries for the corresponding workflow execution. Returned entries are ordered by their create_time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
     "v1/{+parent}/stepEntries"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workflows-executions-stepEntries-get$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/stepEntries/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a step entry."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workflowexecutions.googleapis.com/"
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
