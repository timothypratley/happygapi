(ns happygapi.dataflow.projects
  "Dataflow API: projects.
  Manages Google Cloud Dataflow projects on Google Cloud Platform.
  See: https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn workerMessages$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/workerMessages
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:workerMessages [{:labels {},
                     :time string,
                     :workerLifecycleEvent WorkerLifecycleEvent,
                     :workerShutdownNotice WorkerShutdownNotice,
                     :workerHealthReport WorkerHealthReport,
                     :workerMetrics ResourceUtilizationReport,
                     :workerMessageCode WorkerMessageCode}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/WorkerMessages"
     #{:projectId}
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

(defn deleteSnapshots$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/deleteSnapshots
  
  Required parameters: projectId
  
  Optional parameters: location, snapshotId
  
  Deletes a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/snapshots"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/snapshots/get
  
  Required parameters: projectId, snapshotId
  
  Optional parameters: location
  
  Gets information about a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:snapshotId :projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/snapshots/{snapshotId}"
     #{:snapshotId :projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/snapshots/list
  
  Required parameters: projectId
  
  Optional parameters: jobId, location
  
  Lists snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/snapshots"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :location string,
   :parameters {},
   :jobName string,
   :gcsPath string}
  
  Creates a Cloud Dataflow job from a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates"
     #{:projectId}
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

(defn templates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/launch
  
  Required parameters: projectId
  
  Optional parameters: validateOnly, gcsPath, location, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation
  
  Body: 
  
  {:update boolean,
   :parameters {},
   :jobName string,
   :transformNameMapping {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string}}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates:launch"
     #{:projectId}
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

(defn templates-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/get
  
  Required parameters: projectId
  
  Optional parameters: view, gcsPath, location
  
  Get the template associated with a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates:get"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workerMessages$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/workerMessages
  
  Required parameters: location, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:workerMessages [{:labels {},
                     :time string,
                     :workerLifecycleEvent WorkerLifecycleEvent,
                     :workerShutdownNotice WorkerShutdownNotice,
                     :workerHealthReport WorkerHealthReport,
                     :workerMetrics ResourceUtilizationReport,
                     :workerMessageCode WorkerMessageCode}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/WorkerMessages"
     #{:projectId :location}
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

(defn locations-sql-validate$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/sql/validate
  
  Required parameters: location, projectId
  
  Optional parameters: query
  
  Validates a GoogleSQL query for Cloud Dataflow syntax. Will always
  confirm the given query parses correctly, and if able to look up
  schema information from DataCatalog, will validate that the query
  analyzes properly as well."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/sql:validate"
     #{:projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-templates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: validateOnly, gcsPath, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation
  
  Body: 
  
  {:update boolean,
   :parameters {},
   :jobName string,
   :transformNameMapping {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string}}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates:launch"
     #{:projectId :location}
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

(defn locations-templates-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/get
  
  Required parameters: projectId, location
  
  Optional parameters: view, gcsPath
  
  Get the template associated with a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates:get"
     #{:projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/create
  
  Required parameters: location, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :location string,
   :parameters {},
   :jobName string,
   :gcsPath string}
  
  Creates a Cloud Dataflow job from a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates"
     #{:projectId :location}
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

(defn locations-jobs-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/get
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: view
  
  Gets the state of the specified Cloud Dataflow job.
  
  To get the state of a job, we recommend using `projects.locations.jobs.get`
  with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.get` is not recommended, as you can only get the state of
  jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}"
     #{:projectId :jobId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-update$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/update
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:datastoreDetails [DatastoreIODetails],
                 :sdkVersion SdkVersion,
                 :fileDetails [FileIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :spannerDetails [SpannerIODetails]},
   :clientRequestId string,
   :startTime string,
   :stageStates [{:executionStageState string,
                  :executionStageName string,
                  :currentStateTime string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary],
                         :originalPipelineTransform [TransformSummary]},
   :replacedByJobId string,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :sdkPipelineOptions {},
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string}
  
  Updates the state of an existing Cloud Dataflow job.
  
  To update the state of an existing job, we recommend using
  `projects.locations.jobs.update` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.update` is not recommended, as you can only update the state
  of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}"
     #{:projectId :jobId :location}
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

(defn locations-jobs-snapshot$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/snapshot
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :snapshotSources boolean,
   :ttl string,
   :location string}
  
  Snapshot the state of a streaming job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}:snapshot"
     #{:projectId :jobId :location}
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

(defn locations-jobs-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/list
  
  Required parameters: projectId, location
  
  Optional parameters: filter, pageToken, pageSize, view
  
  List the jobs of a project.
  
  To list the jobs of a project in a region, we recommend using
  `projects.locations.jobs.get` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
  list the all jobs across all regions, use `projects.jobs.aggregated`. Using
  `projects.jobs.list` is not recommended, as you can only get the list of
  jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs"
     #{:projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/create
  
  Required parameters: location, projectId
  
  Optional parameters: replaceJobId, view
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:datastoreDetails [DatastoreIODetails],
                 :sdkVersion SdkVersion,
                 :fileDetails [FileIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :spannerDetails [SpannerIODetails]},
   :clientRequestId string,
   :startTime string,
   :stageStates [{:executionStageState string,
                  :executionStageName string,
                  :currentStateTime string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary],
                         :originalPipelineTransform [TransformSummary]},
   :replacedByJobId string,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :sdkPipelineOptions {},
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string}
  
  Creates a Cloud Dataflow job.
  
  To create a job, we recommend using `projects.locations.jobs.create` with a
  [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.create` is not recommended, as your job will always start
  in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs"
     #{:projectId :location}
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

(defn locations-jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/getMetrics
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: startTime
  
  Request the job status.
  
  To request the status of a job, we recommend using
  `projects.locations.jobs.getMetrics` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.getMetrics` is not recommended, as you can only request the
  status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/metrics"
     #{:projectId :jobId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-snapshots-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/snapshots/list
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Lists snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/snapshots"
     #{:projectId :jobId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-messages-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/messages/list
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: endTime, pageToken, startTime, pageSize, minimumImportance
  
  Request the job status.
  
  To request the status of a job, we recommend using
  `projects.locations.jobs.messages.list` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.messages.list` is not recommended, as you can only request
  the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/messages"
     #{:projectId :jobId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-debug-getConfig$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/debug/getConfig
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:componentId string, :workerId string, :location string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/getConfig"
     #{:projectId :jobId :location}
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

(defn locations-jobs-debug-sendCapture$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/debug/sendCapture
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Body: 
  
  {:location string,
   :data string,
   :componentId string,
   :workerId string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/sendCapture"
     #{:projectId :jobId :location}
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

(defn locations-jobs-workItems-lease$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/lease
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:currentWorkerTime string,
   :workItemTypes [string],
   :location string,
   :unifiedWorkerRequest {},
   :workerCapabilities [string],
   :workerId string,
   :requestedLeaseDuration string}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:lease"
     #{:projectId :jobId :location}
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

(defn locations-jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/reportStatus
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string,
   :currentWorkerTime string,
   :location string,
   :workItemStatuses [{:stopPosition Position,
                       :sourceFork SourceFork,
                       :sourceOperationResponse SourceOperationResponse,
                       :errors [Status],
                       :reportedProgress ApproximateReportedProgress,
                       :completed boolean,
                       :workItemId string,
                       :reportIndex string,
                       :totalThrottlerWaitTimeSeconds number,
                       :metricUpdates [MetricUpdate],
                       :progress ApproximateProgress,
                       :dynamicSourceSplit DynamicSourceSplit,
                       :counterUpdates [CounterUpdate],
                       :requestedLeaseDuration string}],
   :unifiedWorkerRequest {}}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:reportStatus"
     #{:projectId :jobId :location}
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

(defn locations-flexTemplates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/flexTemplates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :launchParameter {:containerSpecGcsPath string,
                     :parameters {},
                     :jobName string,
                     :containerSpec ContainerSpec}}
  
  Launch a job with a FlexTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/flexTemplates:launch"
     #{:projectId :location}
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

(defn locations-snapshots-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/get
  
  Required parameters: projectId, snapshotId, location
  
  Optional parameters: none
  
  Gets information about a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:snapshotId :projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}"
     #{:snapshotId :projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-snapshots-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/list
  
  Required parameters: location, projectId
  
  Optional parameters: jobId
  
  Lists snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/snapshots"
     #{:projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-snapshots-delete$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/delete
  
  Required parameters: projectId, snapshotId, location
  
  Optional parameters: none
  
  Deletes a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:snapshotId :projectId :location})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/snapshots/{snapshotId}"
     #{:snapshotId :projectId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/create
  
  Required parameters: projectId
  
  Optional parameters: location, replaceJobId, view
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:datastoreDetails [DatastoreIODetails],
                 :sdkVersion SdkVersion,
                 :fileDetails [FileIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :spannerDetails [SpannerIODetails]},
   :clientRequestId string,
   :startTime string,
   :stageStates [{:executionStageState string,
                  :executionStageName string,
                  :currentStateTime string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary],
                         :originalPipelineTransform [TransformSummary]},
   :replacedByJobId string,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :sdkPipelineOptions {},
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string}
  
  Creates a Cloud Dataflow job.
  
  To create a job, we recommend using `projects.locations.jobs.create` with a
  [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.create` is not recommended, as your job will always start
  in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs"
     #{:projectId}
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

(defn jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/getMetrics
  
  Required parameters: projectId, jobId
  
  Optional parameters: location, startTime
  
  Request the job status.
  
  To request the status of a job, we recommend using
  `projects.locations.jobs.getMetrics` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.getMetrics` is not recommended, as you can only request the
  status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/metrics"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/get
  
  Required parameters: projectId, jobId
  
  Optional parameters: view, location
  
  Gets the state of the specified Cloud Dataflow job.
  
  To get the state of a job, we recommend using `projects.locations.jobs.get`
  with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.get` is not recommended, as you can only get the state of
  jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-update$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/update
  
  Required parameters: projectId, jobId
  
  Optional parameters: location
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:datastoreDetails [DatastoreIODetails],
                 :sdkVersion SdkVersion,
                 :fileDetails [FileIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :spannerDetails [SpannerIODetails]},
   :clientRequestId string,
   :startTime string,
   :stageStates [{:executionStageState string,
                  :executionStageName string,
                  :currentStateTime string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary],
                         :originalPipelineTransform [TransformSummary]},
   :replacedByJobId string,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :sdkPipelineOptions {},
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string}
  
  Updates the state of an existing Cloud Dataflow job.
  
  To update the state of an existing job, we recommend using
  `projects.locations.jobs.update` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.update` is not recommended, as you can only update the state
  of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}"
     #{:projectId :jobId}
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

(defn jobs-snapshot$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/snapshot
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :snapshotSources boolean,
   :ttl string,
   :location string}
  
  Snapshot the state of a streaming job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}:snapshot"
     #{:projectId :jobId}
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

(defn jobs-aggregated$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/aggregated
  
  Required parameters: projectId
  
  Optional parameters: filter, location, pageToken, pageSize, view
  
  List the jobs of a project across all regions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs:aggregated"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/list
  
  Required parameters: projectId
  
  Optional parameters: pageSize, view, filter, location, pageToken
  
  List the jobs of a project.
  
  To list the jobs of a project in a region, we recommend using
  `projects.locations.jobs.get` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To
  list the all jobs across all regions, use `projects.jobs.aggregated`. Using
  `projects.jobs.list` is not recommended, as you can only get the list of
  jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs"
     #{:projectId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-debug-getConfig$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/debug/getConfig
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:componentId string, :workerId string, :location string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/debug/getConfig"
     #{:projectId :jobId}
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

(defn jobs-debug-sendCapture$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/debug/sendCapture
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:location string,
   :data string,
   :componentId string,
   :workerId string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/debug/sendCapture"
     #{:projectId :jobId}
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

(defn jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/workItems/reportStatus
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string,
   :currentWorkerTime string,
   :location string,
   :workItemStatuses [{:stopPosition Position,
                       :sourceFork SourceFork,
                       :sourceOperationResponse SourceOperationResponse,
                       :errors [Status],
                       :reportedProgress ApproximateReportedProgress,
                       :completed boolean,
                       :workItemId string,
                       :reportIndex string,
                       :totalThrottlerWaitTimeSeconds number,
                       :metricUpdates [MetricUpdate],
                       :progress ApproximateProgress,
                       :dynamicSourceSplit DynamicSourceSplit,
                       :counterUpdates [CounterUpdate],
                       :requestedLeaseDuration string}],
   :unifiedWorkerRequest {}}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/workItems:reportStatus"
     #{:projectId :jobId}
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

(defn jobs-workItems-lease$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/workItems/lease
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:currentWorkerTime string,
   :workItemTypes [string],
   :location string,
   :unifiedWorkerRequest {},
   :workerCapabilities [string],
   :workerId string,
   :requestedLeaseDuration string}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/workItems:lease"
     #{:projectId :jobId}
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

(defn jobs-messages-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/messages/list
  
  Required parameters: projectId, jobId
  
  Optional parameters: endTime, location, pageToken, startTime, pageSize, minimumImportance
  
  Request the job status.
  
  To request the status of a job, we recommend using
  `projects.locations.jobs.messages.list` with a [regional endpoint]
  (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using
  `projects.jobs.messages.list` is not recommended, as you can only request
  the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/messages"
     #{:projectId :jobId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
