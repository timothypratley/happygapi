(ns happygapi.dataflow.projects
  "Dataflow API: projects.
  Manages Google Cloud Dataflow projects on Google Cloud Platform.
  See: https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn deleteSnapshots$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/deleteSnapshots
  
  Required parameters: projectId
  
  Optional parameters: snapshotId, location
  
  Deletes a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn workerMessages$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/workerMessages
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:workerMessages [{:labels {},
                     :streamingScalingReport StreamingScalingReport,
                     :workerHealthReport WorkerHealthReport,
                     :workerShutdownNotice WorkerShutdownNotice,
                     :time string,
                     :workerThreadScalingReport WorkerThreadScalingReport,
                     :workerLifecycleEvent WorkerLifecycleEvent,
                     :perWorkerMetrics PerWorkerMetrics,
                     :dataSamplingReport DataSamplingReport,
                     :workerMessageCode WorkerMessageCode,
                     :workerMetrics ResourceUtilizationReport}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn snapshots-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/snapshots/get
  
  Required parameters: projectId, snapshotId
  
  Optional parameters: location
  
  Gets information about a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/create
  
  Required parameters: projectId
  
  Optional parameters: view, replaceJobId, location
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:sdkVersion SdkVersion,
                 :spannerDetails [SpannerIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :fileDetails [FileIODetails],
                 :datastoreDetails [DatastoreIODetails],
                 :userDisplayProperties {}},
   :clientRequestId string,
   :startTime string,
   :satisfiesPzi boolean,
   :stageStates [{:executionStageName string,
                  :executionStageState string,
                  :currentStateTime string}],
   :name string,
   :steps [{:kind string, :name string, :properties {}}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :executionPipelineStage [ExecutionStageSummary],
                         :displayData [DisplayData],
                         :stepNamesHash string},
   :replacedByJobId string,
   :satisfiesPzs boolean,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :shuffleMode string,
                 :debugOptions DebugOptions,
                 :streamingMode string,
                 :sdkPipelineOptions {},
                 :useStreamingEngineResourceBasedBilling boolean,
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :serviceOptions [string],
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string,
   :runtimeUpdatableParams {:maxNumWorkers integer,
                            :minNumWorkers integer,
                            :workerUtilizationHint number}}
  
  Creates a Cloud Dataflow job. To create a job, we recommend using `projects.locations.jobs.create` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.create` is not recommended, as your job will always start in `us-central1`. Do not enter confidential information when you supply string values using the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/get
  
  Required parameters: projectId, jobId
  
  Optional parameters: view, location
  
  Gets the state of the specified Cloud Dataflow job. To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Optional parameters: location, updateMask
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:sdkVersion SdkVersion,
                 :spannerDetails [SpannerIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :fileDetails [FileIODetails],
                 :datastoreDetails [DatastoreIODetails],
                 :userDisplayProperties {}},
   :clientRequestId string,
   :startTime string,
   :satisfiesPzi boolean,
   :stageStates [{:executionStageName string,
                  :executionStageState string,
                  :currentStateTime string}],
   :name string,
   :steps [{:kind string, :name string, :properties {}}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :executionPipelineStage [ExecutionStageSummary],
                         :displayData [DisplayData],
                         :stepNamesHash string},
   :replacedByJobId string,
   :satisfiesPzs boolean,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :shuffleMode string,
                 :debugOptions DebugOptions,
                 :streamingMode string,
                 :sdkPipelineOptions {},
                 :useStreamingEngineResourceBasedBilling boolean,
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :serviceOptions [string],
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string,
   :runtimeUpdatableParams {:maxNumWorkers integer,
                            :minNumWorkers integer,
                            :workerUtilizationHint number}}
  
  Updates the state of an existing Cloud Dataflow job. To update the state of an existing job, we recommend using `projects.locations.jobs.update` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.update` is not recommended, as you can only update the state of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/list
  
  Required parameters: projectId
  
  Optional parameters: filter, view, pageSize, pageToken, location, name
  
  List the jobs of a project. To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not recommended, because you can only get the list of jobs that are running in `us-central1`. `projects.locations.jobs.list` and `projects.jobs.list` support filtering the list of jobs by name. Filtering by name isn't supported by `projects.jobs.aggregated`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-aggregated$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/aggregated
  
  Required parameters: projectId
  
  Optional parameters: filter, view, pageSize, pageToken, location, name
  
  List the jobs of a project across all regions. **Note:** This method doesn't support filtering the list of jobs by name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-snapshot$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/snapshot
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:ttl string,
   :location string,
   :snapshotSources boolean,
   :description string}
  
  Snapshot the state of a streaming job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/getMetrics
  
  Required parameters: projectId, jobId
  
  Optional parameters: startTime, location
  
  Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-debug-getConfig$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/debug/getConfig
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string, :componentId string, :location string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  {:workerId string,
   :componentId string,
   :data string,
   :dataFormat string,
   :location string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-messages-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/messages/list
  
  Required parameters: projectId, jobId
  
  Optional parameters: minimumImportance, pageSize, pageToken, startTime, endTime, location
  
  Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.messages.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/jobs/workItems/reportStatus
  
  Required parameters: projectId, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string,
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
   :currentWorkerTime string,
   :location string,
   :unifiedWorkerRequest {}}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  {:workItemTypes [string],
   :workerCapabilities [string],
   :requestedLeaseDuration string,
   :currentWorkerTime string,
   :workerId string,
   :location string,
   :unifiedWorkerRequest {}}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/templates/create
  
  Required parameters: projectId
  
  Optional parameters: none
  
  Body: 
  
  {:jobName string,
   :gcsPath string,
   :parameters {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :streamingMode string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :enableStreamingEngine boolean,
                 :diskSizeGb integer,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :location string}
  
  Creates a Cloud Dataflow job from a template. Do not enter confidential information when you supply string values using the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Optional parameters: validateOnly, gcsPath, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation, location
  
  Body: 
  
  {:jobName string,
   :parameters {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :streamingMode string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :enableStreamingEngine boolean,
                 :diskSizeGb integer,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :update boolean,
   :transformNameMapping {}}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Optional parameters: gcsPath, view, location
  
  Get the template associated with a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Required parameters: projectId, location
  
  Optional parameters: none
  
  Body: 
  
  {:workerMessages [{:labels {},
                     :streamingScalingReport StreamingScalingReport,
                     :workerHealthReport WorkerHealthReport,
                     :workerShutdownNotice WorkerShutdownNotice,
                     :time string,
                     :workerThreadScalingReport WorkerThreadScalingReport,
                     :workerLifecycleEvent WorkerLifecycleEvent,
                     :perWorkerMetrics PerWorkerMetrics,
                     :dataSamplingReport DataSamplingReport,
                     :workerMessageCode WorkerMessageCode,
                     :workerMetrics ResourceUtilizationReport}],
   :location string}
  
  Send a worker_message to the service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-snapshots-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/get
  
  Required parameters: projectId, location, snapshotId
  
  Optional parameters: none
  
  Gets information about a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-snapshots-delete$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/delete
  
  Required parameters: projectId, location, snapshotId
  
  Optional parameters: none
  
  Deletes a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-snapshots-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/snapshots/list
  
  Required parameters: projectId, location
  
  Optional parameters: jobId
  
  Lists snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/create
  
  Required parameters: projectId, location
  
  Optional parameters: view, replaceJobId
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:sdkVersion SdkVersion,
                 :spannerDetails [SpannerIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :fileDetails [FileIODetails],
                 :datastoreDetails [DatastoreIODetails],
                 :userDisplayProperties {}},
   :clientRequestId string,
   :startTime string,
   :satisfiesPzi boolean,
   :stageStates [{:executionStageName string,
                  :executionStageState string,
                  :currentStateTime string}],
   :name string,
   :steps [{:kind string, :name string, :properties {}}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :executionPipelineStage [ExecutionStageSummary],
                         :displayData [DisplayData],
                         :stepNamesHash string},
   :replacedByJobId string,
   :satisfiesPzs boolean,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :shuffleMode string,
                 :debugOptions DebugOptions,
                 :streamingMode string,
                 :sdkPipelineOptions {},
                 :useStreamingEngineResourceBasedBilling boolean,
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :serviceOptions [string],
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string,
   :runtimeUpdatableParams {:maxNumWorkers integer,
                            :minNumWorkers integer,
                            :workerUtilizationHint number}}
  
  Creates a Cloud Dataflow job. To create a job, we recommend using `projects.locations.jobs.create` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.create` is not recommended, as your job will always start in `us-central1`. Do not enter confidential information when you supply string values using the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-get$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/get
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: view
  
  Gets the state of the specified Cloud Dataflow job. To get the state of a job, we recommend using `projects.locations.jobs.get` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.get` is not recommended, as you can only get the state of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:labels {},
   :stepsLocation string,
   :executionInfo {:stages {}},
   :jobMetadata {:sdkVersion SdkVersion,
                 :spannerDetails [SpannerIODetails],
                 :bigqueryDetails [BigQueryIODetails],
                 :bigTableDetails [BigTableIODetails],
                 :pubsubDetails [PubSubIODetails],
                 :fileDetails [FileIODetails],
                 :datastoreDetails [DatastoreIODetails],
                 :userDisplayProperties {}},
   :clientRequestId string,
   :startTime string,
   :satisfiesPzi boolean,
   :stageStates [{:executionStageName string,
                  :executionStageState string,
                  :currentStateTime string}],
   :name string,
   :steps [{:kind string, :name string, :properties {}}],
   :createTime string,
   :currentStateTime string,
   :type string,
   :transformNameMapping {},
   :replaceJobId string,
   :pipelineDescription {:originalPipelineTransform [TransformSummary],
                         :executionPipelineStage [ExecutionStageSummary],
                         :displayData [DisplayData],
                         :stepNamesHash string},
   :replacedByJobId string,
   :satisfiesPzs boolean,
   :currentState string,
   :tempFiles [string],
   :id string,
   :createdFromSnapshotId string,
   :environment {:flexResourceSchedulingGoal string,
                 :internalExperiments {},
                 :experiments [string],
                 :workerRegion string,
                 :shuffleMode string,
                 :debugOptions DebugOptions,
                 :streamingMode string,
                 :sdkPipelineOptions {},
                 :useStreamingEngineResourceBasedBilling boolean,
                 :serviceKmsKeyName string,
                 :tempStoragePrefix string,
                 :serviceAccountEmail string,
                 :clusterManagerApiService string,
                 :userAgent {},
                 :serviceOptions [string],
                 :workerZone string,
                 :version {},
                 :workerPools [WorkerPool],
                 :dataset string},
   :projectId string,
   :requestedState string,
   :location string,
   :runtimeUpdatableParams {:maxNumWorkers integer,
                            :minNumWorkers integer,
                            :workerUtilizationHint number}}
  
  Updates the state of an existing Cloud Dataflow job. To update the state of an existing job, we recommend using `projects.locations.jobs.update` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.update` is not recommended, as you can only update the state of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/list
  
  Required parameters: projectId, location
  
  Optional parameters: filter, view, pageSize, pageToken, name
  
  List the jobs of a project. To list the jobs of a project in a region, we recommend using `projects.locations.jobs.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). To list the all jobs across all regions, use `projects.jobs.aggregated`. Using `projects.jobs.list` is not recommended, because you can only get the list of jobs that are running in `us-central1`. `projects.locations.jobs.list` and `projects.jobs.list` support filtering the list of jobs by name. Filtering by name isn't supported by `projects.jobs.aggregated`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-snapshot$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/snapshot
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:ttl string,
   :location string,
   :snapshotSources boolean,
   :description string}
  
  Snapshot the state of a streaming job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-getMetrics$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/getMetrics
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: startTime
  
  Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.getMetrics` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.getMetrics` is not recommended, as you can only request the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-getExecutionDetails$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/getExecutionDetails
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: pageSize, pageToken
  
  Request detailed information about the execution status of the job. EXPERIMENTAL. This API is subject to change or removal without notice."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/executionDetails"
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
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string, :componentId string, :location string}
  
  Get encoded debug configuration for component. Not cacheable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string,
   :componentId string,
   :data string,
   :dataFormat string,
   :location string}
  
  Send encoded debug capture data for component."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-snapshots-list$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/snapshots/list
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Lists snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: minimumImportance, pageSize, pageToken, startTime, endTime
  
  Request the job status. To request the status of a job, we recommend using `projects.locations.jobs.messages.list` with a [regional endpoint] (https://cloud.google.com/dataflow/docs/concepts/regional-endpoints). Using `projects.jobs.messages.list` is not recommended, as you can only request the status of jobs that are running in `us-central1`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-stages-getExecutionDetails$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/stages/getExecutionDetails
  
  Required parameters: projectId, location, jobId, stageId
  
  Optional parameters: pageSize, pageToken, startTime, endTime
  
  Request detailed information about the execution status of a stage of the job. EXPERIMENTAL. This API is subject to change or removal without notice."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:stageId :projectId :jobId :location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dataflow.googleapis.com/"
     "v1b3/projects/{projectId}/locations/{location}/jobs/{jobId}/stages/{stageId}/executionDetails"
     #{:stageId :projectId :jobId :location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-jobs-workItems-reportStatus$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/reportStatus
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workerId string,
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
   :currentWorkerTime string,
   :location string,
   :unifiedWorkerRequest {}}
  
  Reports the status of dataflow WorkItems leased by a worker."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-jobs-workItems-lease$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/jobs/workItems/lease
  
  Required parameters: projectId, location, jobId
  
  Optional parameters: none
  
  Body: 
  
  {:workItemTypes [string],
   :workerCapabilities [string],
   :requestedLeaseDuration string,
   :currentWorkerTime string,
   :workerId string,
   :location string,
   :unifiedWorkerRequest {}}
  
  Leases a dataflow WorkItem to run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-templates-create$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/create
  
  Required parameters: projectId, location
  
  Optional parameters: none
  
  Body: 
  
  {:jobName string,
   :gcsPath string,
   :parameters {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :streamingMode string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :enableStreamingEngine boolean,
                 :diskSizeGb integer,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :location string}
  
  Creates a Cloud Dataflow job from a template. Do not enter confidential information when you supply string values using the API."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-templates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/templates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: validateOnly, gcsPath, dynamicTemplate.gcsPath, dynamicTemplate.stagingLocation
  
  Body: 
  
  {:jobName string,
   :parameters {},
   :environment {:maxWorkers integer,
                 :workerRegion string,
                 :additionalExperiments [string],
                 :zone string,
                 :streamingMode string,
                 :machineType string,
                 :tempLocation string,
                 :numWorkers integer,
                 :serviceAccountEmail string,
                 :bypassTempDirValidation boolean,
                 :ipConfiguration string,
                 :kmsKeyName string,
                 :enableStreamingEngine boolean,
                 :diskSizeGb integer,
                 :network string,
                 :workerZone string,
                 :additionalUserLabels {},
                 :subnetwork string},
   :update boolean,
   :transformNameMapping {}}
  
  Launch a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
  
  Optional parameters: gcsPath, view
  
  Get the template associated with a template."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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

(defn locations-flexTemplates-launch$
  "https://cloud.google.com/dataflowapi/reference/rest/v1b3/projects/locations/flexTemplates/launch
  
  Required parameters: projectId, location
  
  Optional parameters: none
  
  Body: 
  
  {:launchParameter {:jobName string,
                     :containerSpec ContainerSpec,
                     :containerSpecGcsPath string,
                     :parameters {},
                     :launchOptions {},
                     :environment FlexTemplateRuntimeEnvironment,
                     :update boolean,
                     :transformNameMappings {}},
   :validateOnly boolean}
  
  Launch a job with a FlexTemplate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
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
