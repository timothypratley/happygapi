(ns happygapi.workflowexecutions.projects
  "Workflow Executions API: projects.
  Execute workflows created with Workflows API.
  See: https://cloud.google.com/workflowsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-workflows-executions-list$
  "https://cloud.google.com/workflowsapi/reference/rest/v1/projects/locations/workflows/executions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
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
  
  {:error {:context string, :payload string, :stackTrace StackTrace},
   :startTime string,
   :workflowRevisionId string,
   :endTime string,
   :argument string,
   :state string,
   :result string,
   :name string}
  
  Creates a new execution using the latest revision of the given workflow."
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
