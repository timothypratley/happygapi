(ns happygapi.lifesciences.projects
  "Cloud Life Sciences API: projects.
  Cloud Life Sciences is a suite of services and tools for managing, processing, and transforming life sciences data.
  See: https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+name}/locations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelines-run$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/pipelines/run
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :pipeline {:actions [Action],
              :environment {},
              :timeout string,
              :resources Resources}}
  
  Runs a pipeline.  The returned Operation's metadata field will contain a
  google.cloud.lifesciences.v2beta.Metadata object describing the status
  of the pipeline execution. The
  response field will contain a
  google.cloud.lifesciences.v2beta.RunPipelineResponse object if the
  pipeline completes successfully.
  
  **Note:** Before you can use this method, the *Life Sciences Service Agent*
  must have access to your project. This is done automatically when the
  Cloud Life Sciences API is first enabled, but if you delete this permission
  you must disable and re-enable the API to grant the Life Sciences
  Service Agent the required permissions.
  Authorization requires the following [Google
  IAM](https://cloud.google.com/iam/) permission:
  
  * `lifesciences.workflows.run`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+parent}/pipelines:run"
     #{:parent}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  Lists operations that match the specified filter in the request.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `lifesciences.operations.list`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+name}/operations"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  Gets the latest state of a long-running operation.
  Clients can use this method to poll the operation result at intervals as
  recommended by the API service.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `lifesciences.operations.get`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/life-sciencesapi/reference/rest/v2beta/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation.
  The server makes a best effort to cancel the operation, but success is not
  guaranteed. Clients may use Operations.GetOperation
  or Operations.ListOperations
  to check whether the cancellation succeeded or the operation completed
  despite cancellation.
  Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission&#58;
  
  * `lifesciences.operations.cancel`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://lifesciences.googleapis.com/"
     "v2beta/{+name}:cancel"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
