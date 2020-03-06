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
  
  {:workerMessages [{:workerShutdownNotice WorkerShutdownNotice,
                     :workerHealthReport WorkerHealthReport,
                     :workerMessageCode WorkerMessageCode,
                     :workerMetrics ResourceUtilizationReport,
                     :labels {},
                     :time string,
                     :workerLifecycleEvent WorkerLifecycleEvent}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/WorkerMessages"
     #{:projectId}
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

(defn templates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/launch
  
  Required parameters: projectId
  
  Optional parameters: validateOnly, gcsPath, location, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation
  
  Body: 
  
  {:parameters {},
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
                 :subnetwork string},
   :update boolean}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates:launch"
     #{:projectId}
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

(defn templates-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/get
  
  Required parameters: projectId
  
  Optional parameters: location, view, gcsPath
  Get the template associated with a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates:get"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:jobName string,
   :gcsPath string,
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
                 :subnetwork string},
   :location string,
   :parameters {}}
  
  Creates a Cloud Dataflow job from a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/templates"
     #{:projectId}
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

(defn locations-workerMessages$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/workerMessages
  
  Required parameters: location, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:workerMessages [{:workerShutdownNotice WorkerShutdownNotice,
                     :workerHealthReport WorkerHealthReport,
                     :workerMessageCode WorkerMessageCode,
                     :workerMetrics ResourceUtilizationReport,
                     :labels {},
                     :time string,
                     :workerLifecycleEvent WorkerLifecycleEvent}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/WorkerMessages"
     #{:projectId :location}
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

(defn locations-sql-validate$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/sql/validate
  
  Required parameters: projectId, location
  
  Optional parameters: query
  Validates a GoogleSQL query for Cloud Dataflow syntax. Will always
  confirm the given query parses correctly, and if able to look up
  schema information from DataCatalog, will validate that the query
  analyzes properly as well."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/sql:validate"
     #{:projectId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates:get"
     #{:projectId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/create
  
  Required parameters: location, projectId
  
  Optional parameters: none
  
  Body: 
  
  {:jobName string,
   :gcsPath string,
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
                 :subnetwork string},
   :location string,
   :parameters {}}
  
  Creates a Cloud Dataflow job from a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates"
     #{:projectId :location}
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

(defn locations-templates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: gcsPath, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation, validateOnly
  
  Body: 
  
  {:parameters {},
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
                 :subnetwork string},
   :update boolean}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/templates:launch"
     #{:projectId :location}
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}"
     #{:projectId :jobId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs"
     #{:projectId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :stageStates [{:executionStageName string,
                  :currentStateTime string,
                  :executionStageState string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary]},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}"
     #{:projectId :jobId :location}
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

(defn locations-jobs-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/create
  
  Required parameters: projectId, location
  
  Optional parameters: view, replaceJobId
  
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
   :stageStates [{:executionStageName string,
                  :currentStateTime string,
                  :executionStageState string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary]},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs"
     #{:projectId :location}
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

(defn locations-jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/getMetrics
  
  Required parameters: location, projectId, jobId
  
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/metrics"
     #{:projectId :jobId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-debug-getConfig$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/debug/getConfig
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: none
  
  Body: 
  
  {:location string, :componentId string, :workerId string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/getConfig"
     #{:projectId :jobId :location}
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

(defn locations-jobs-debug-sendCapture$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/debug/sendCapture
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:componentId string,
   :workerId string,
   :location string,
   :data string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/debug/sendCapture"
     #{:projectId :jobId :location}
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

(defn locations-jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/reportStatus
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workItemStatuses [{:stopPosition Position,
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
   :unifiedWorkerRequest {},
   :workerId string,
   :currentWorkerTime string,
   :location string}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:reportStatus"
     #{:projectId :jobId :location}
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

(defn locations-jobs-workItems-lease$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/lease
  
  Required parameters: location, projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:requestedLeaseDuration string,
   :currentWorkerTime string,
   :location string,
   :workItemTypes [string],
   :unifiedWorkerRequest {},
   :workerId string,
   :workerCapabilities [string]}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/workItems:lease"
     #{:projectId :jobId :location}
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

(defn locations-jobs-messages-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/messages/list
  
  Required parameters: projectId, jobId, location
  
  Optional parameters: minimumImportance, endTime, pageToken, startTime, pageSize
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/messages"
     #{:projectId :jobId :location}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-flexTemplates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/flexTemplates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :launchParameter {:containerSpec ContainerSpec,
                     :containerSpecGcsPath string,
                     :parameters {},
                     :jobName string}}
  
  Launch a job with a FlexTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/flexTemplates:launch"
     #{:projectId :location}
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

(defn jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/getMetrics
  
  Required parameters: projectId, jobId
  
  Optional parameters: startTime, location
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/metrics"
     #{:projectId :jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/get
  
  Required parameters: projectId, jobId
  
  Optional parameters: location, view
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}"
     #{:projectId :jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :stageStates [{:executionStageName string,
                  :currentStateTime string,
                  :executionStageState string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary]},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}"
     #{:projectId :jobId}
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

(defn jobs-aggregated$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/aggregated
  
  Required parameters: projectId
  
  Optional parameters: filter, location, pageToken, pageSize, view
  List the jobs of a project across all regions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs:aggregated"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/list
  
  Required parameters: projectId
  
  Optional parameters: pageToken, pageSize, view, filter, location
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs"
     #{:projectId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :stageStates [{:executionStageName string,
                  :currentStateTime string,
                  :executionStageState string}],
   :name string,
   :steps [{:properties {}, :name string, :kind string}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :displayData [DisplayData],
                         :executionPipelineStage [ExecutionStageSummary]},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs"
     #{:projectId}
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

(defn jobs-messages-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/messages/list
  
  Required parameters: jobId, projectId
  
  Optional parameters: endTime, location, startTime, pageToken, pageSize, minimumImportance
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
  [auth args]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/messages"
     #{:projectId :jobId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn jobs-debug-getConfig$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/debug/getConfig
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:location string, :componentId string, :workerId string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/debug/getConfig"
     #{:projectId :jobId}
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

(defn jobs-debug-sendCapture$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/debug/sendCapture
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:componentId string,
   :workerId string,
   :location string,
   :data string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/debug/sendCapture"
     #{:projectId :jobId}
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

(defn jobs-workItems-lease$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/workItems/lease
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:requestedLeaseDuration string,
   :currentWorkerTime string,
   :location string,
   :workItemTypes [string],
   :unifiedWorkerRequest {},
   :workerId string,
   :workerCapabilities [string]}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/workItems:lease"
     #{:projectId :jobId}
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

(defn jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/workItems/reportStatus
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workItemStatuses [{:stopPosition Position,
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
   :unifiedWorkerRequest {},
   :workerId string,
   :currentWorkerTime string,
   :location string}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"
            "https://www.googleapis.com/auth/userinfo.email"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:projectId :jobId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/jobs/{jobId}/workItems:reportStatus"
     #{:projectId :jobId}
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
