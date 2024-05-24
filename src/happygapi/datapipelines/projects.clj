(ns happygapi.datapipelines.projects
  "Data pipelines API: projects.
  Data Pipelines provides an interface for creating, updating, and managing recurring Data Analytics jobs.
  See: https://cloud.google.com/dataflow/docs/guides/data-pipelinesdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-pipelines-stop$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Freezes pipeline execution permanently. If there's a corresponding scheduler entry, it's deleted, and the pipeline state is changed to \"ARCHIVED\". However, pipeline metadata is retained."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+name}:stop"
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

(defn locations-pipelines-delete$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a pipeline. If a scheduler job is attached to the pipeline, it will be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datapipelines.googleapis.com/"
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

(defn locations-pipelines-run$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Creates a job for the specified pipeline directly. You can use this method when the internal scheduler is not configured and you want to trigger the job directly or through an external system. Returns a \"NOT_FOUND\" error if the pipeline doesn't exist. Returns a \"FORBIDDEN\" error if the user doesn't have permission to access the pipeline or run jobs for the pipeline."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-pipelines-patch$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:schedulerServiceAccountEmail string,
   :scheduleInfo {:schedule string,
                  :timeZone string,
                  :nextJobTime string},
   :jobCount integer,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :pipelineSources {},
   :lastUpdateTime string,
   :workload {:dataflowFlexTemplateRequest GoogleCloudDatapipelinesV1LaunchFlexTemplateRequest,
              :dataflowLaunchTemplateRequest GoogleCloudDatapipelinesV1LaunchTemplateRequest}}
  
  Updates a pipeline. If successful, the updated Pipeline is returned. Returns `NOT_FOUND` if the pipeline doesn't exist. If UpdatePipeline does not return successfully, you can retry the UpdatePipeline request until you receive a successful response."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+name}"
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

(defn locations-pipelines-create$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:schedulerServiceAccountEmail string,
   :scheduleInfo {:schedule string,
                  :timeZone string,
                  :nextJobTime string},
   :jobCount integer,
   :displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :pipelineSources {},
   :lastUpdateTime string,
   :workload {:dataflowFlexTemplateRequest GoogleCloudDatapipelinesV1LaunchFlexTemplateRequest,
              :dataflowLaunchTemplateRequest GoogleCloudDatapipelinesV1LaunchTemplateRequest}}
  
  Creates a pipeline. For a batch pipeline, you can pass scheduler information. Data Pipelines uses the scheduler information to create an internal scheduler that runs jobs periodically. If the internal scheduler is not configured, you can use RunPipeline to run jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+parent}/pipelines"
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

(defn locations-pipelines-get$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Looks up a single pipeline. Returns a \"NOT_FOUND\" error if no such pipeline exists. Returns a \"FORBIDDEN\" error if the caller doesn't have permission to access it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datapipelines.googleapis.com/"
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

(defn locations-pipelines-list$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, filter, pageToken
  
  Lists pipelines. Returns a \"FORBIDDEN\" error if the caller doesn't have permission to access it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+parent}/pipelines"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-pipelines-jobs-list$
  "https://cloud.google.com/dataflow/docs/guides/data-pipelinesapi/reference/rest/v1/projects/locations/pipelines/jobs/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists jobs for a given pipeline. Throws a \"FORBIDDEN\" error if the caller doesn't have permission to access it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datapipelines.googleapis.com/"
     "v1/{+parent}/jobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
