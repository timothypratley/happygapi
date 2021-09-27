(ns happygapi.datalabeling.projects
  "Data Labeling API: projects.
  Public API for Google Cloud AI Data Labeling Service.
  See: https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn evaluationJobs-resume$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes a paused evaluation job. A deleted evaluation job can't be resumed. Resuming a running or scheduled evaluation job is a no-op."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}:resume"
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

(defn evaluationJobs-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Stops and deletes an evaluation job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn evaluationJobs-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an evaluation job by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn evaluationJobs-patch$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :evaluationJobConfig {:boundingPolyConfig GoogleCloudDatalabelingV1beta1BoundingPolyConfig,
                         :humanAnnotationConfig GoogleCloudDatalabelingV1beta1HumanAnnotationConfig,
                         :exampleSamplePercentage number,
                         :imageClassificationConfig GoogleCloudDatalabelingV1beta1ImageClassificationConfig,
                         :exampleCount integer,
                         :bigqueryImportKeys {},
                         :evaluationConfig GoogleCloudDatalabelingV1beta1EvaluationConfig,
                         :evaluationJobAlertConfig GoogleCloudDatalabelingV1beta1EvaluationJobAlertConfig,
                         :textClassificationConfig GoogleCloudDatalabelingV1beta1TextClassificationConfig,
                         :inputConfig GoogleCloudDatalabelingV1beta1InputConfig},
   :schedule string,
   :labelMissingGroundTruth boolean,
   :name string,
   :attempts [{:attemptTime string, :partialFailures [GoogleRpcStatus]}],
   :createTime string,
   :state string,
   :annotationSpecSet string,
   :modelVersion string}
  
  Updates an evaluation job. You can only update certain fields of the job's EvaluationJobConfig: `humanAnnotationConfig.instruction`, `exampleCount`, and `exampleSamplePercentage`. If you want to change any other aspect of the evaluation job, you must delete the job and create a new one."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
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

(defn evaluationJobs-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all evaluation jobs within a project with possible filters. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/evaluationJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn evaluationJobs-pause$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses an evaluation job. Pausing an evaluation job that is already in a `PAUSED` state is a no-op."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}:pause"
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

(defn evaluationJobs-create$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluationJobs/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:job {:description string,
         :evaluationJobConfig GoogleCloudDatalabelingV1beta1EvaluationJobConfig,
         :schedule string,
         :labelMissingGroundTruth boolean,
         :name string,
         :attempts [GoogleCloudDatalabelingV1beta1Attempt],
         :createTime string,
         :state string,
         :annotationSpecSet string,
         :modelVersion string}}
  
  Creates an evaluation job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/evaluationJobs"
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

(defn datasets-exportData$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/exportData
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:filter string,
   :annotatedDataset string,
   :userEmailAddress string,
   :outputConfig {:gcsFolderDestination GoogleCloudDatalabelingV1beta1GcsFolderDestination,
                  :gcsDestination GoogleCloudDatalabelingV1beta1GcsDestination}}
  
  Exports data and annotations from dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}:exportData"
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

(defn datasets-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets dataset by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-create$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dataset {:displayName string,
             :dataItemCount string,
             :description string,
             :lastMigrateTime string,
             :blockingResources [string],
             :inputConfigs [GoogleCloudDatalabelingV1beta1InputConfig],
             :createTime string,
             :name string}}
  
  Creates dataset. If success return a Dataset resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/datasets"
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

(defn datasets-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists datasets under a project. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/datasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-importData$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/importData
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:userEmailAddress string,
   :inputConfig {:bigquerySource GoogleCloudDatalabelingV1beta1BigQuerySource,
                 :dataType string,
                 :gcsSource GoogleCloudDatalabelingV1beta1GcsSource,
                 :textMetadata GoogleCloudDatalabelingV1beta1TextMetadata,
                 :annotationType string,
                 :classificationMetadata GoogleCloudDatalabelingV1beta1ClassificationMetadata}}
  
  Imports data into dataset based on source locations defined in request. It can be called multiple times for the same dataset. Each dataset can only have one long running operation running on it. For example, no labeling task (also long running operation) can be started while importing is still ongoing. Vice versa."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}:importData"
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

(defn datasets-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a dataset by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-dataItems-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/dataItems/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a data item in a dataset by resource name. This API can be called after data are imported into dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-dataItems-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/dataItems/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists data items in a dataset. This API can be called after data are imported into dataset. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/dataItems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-evaluations-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/evaluations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an evaluation by resource name (to search, use projects.evaluations.search)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-evaluations-exampleComparisons-search$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/evaluations/exampleComparisons/search
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:pageToken string, :pageSize integer}
  
  Searches example comparisons from an evaluation. The return format is a list of example comparisons that show ground truth and prediction(s) for a single input. Search by providing an evaluation ID."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/exampleComparisons:search"
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

(defn datasets-annotatedDatasets-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists annotated datasets for a dataset. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/annotatedDatasets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an annotated dataset by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an annotated dataset by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-examples-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/examples/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, filter, pageSize
  
  Lists examples in an annotated dataset. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/examples"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-examples-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/examples/get
  
  Required parameters: name
  
  Optional parameters: filter
  
  Gets an example by resource name, including both data and annotation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-dataItems-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/dataItems/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a data item in a dataset by resource name. This API can be called after data are imported into dataset."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-dataItems-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/dataItems/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists data items in a dataset. This API can be called after data are imported into dataset. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/dataItems"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a FeedbackThread."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  List FeedbackThreads with pagination."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/feedbackThreads"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a FeedbackThread object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-feedbackMessages-create$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/feedbackMessages/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requesterFeedbackMetadata {},
   :body string,
   :image string,
   :operatorFeedbackMetadata {},
   :name string,
   :createTime string}
  
  Create a FeedbackMessage object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/feedbackMessages"
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

(defn datasets-annotatedDatasets-feedbackThreads-feedbackMessages-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/feedbackMessages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List FeedbackMessages with pagination."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/feedbackMessages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-feedbackMessages-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/feedbackMessages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Get a FeedbackMessage object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-annotatedDatasets-feedbackThreads-feedbackMessages-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/annotatedDatasets/feedbackThreads/feedbackMessages/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Delete a FeedbackMessage."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn datasets-image-label$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/image/label
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:imageClassificationConfig {:allowMultiLabel boolean,
                               :annotationSpecSet string,
                               :answerAggregationType string},
   :basicConfig {:annotatedDatasetDisplayName string,
                 :annotatedDatasetDescription string,
                 :labelGroup string,
                 :languageCode string,
                 :userEmailAddress string,
                 :contributorEmails [string],
                 :replicaCount integer,
                 :instruction string,
                 :questionDuration string},
   :feature string,
   :polylineConfig {:instructionMessage string,
                    :annotationSpecSet string},
   :segmentationConfig {:instructionMessage string,
                        :annotationSpecSet string},
   :boundingPolyConfig {:instructionMessage string,
                        :annotationSpecSet string}}
  
  Starts a labeling task for image. The type of image labeling task is configured by feature in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/image:label"
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

(defn datasets-text-label$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/text/label
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:feature string,
   :textClassificationConfig {:allowMultiLabel boolean,
                              :annotationSpecSet string,
                              :sentimentConfig GoogleCloudDatalabelingV1beta1SentimentConfig},
   :basicConfig {:annotatedDatasetDisplayName string,
                 :annotatedDatasetDescription string,
                 :labelGroup string,
                 :languageCode string,
                 :userEmailAddress string,
                 :contributorEmails [string],
                 :replicaCount integer,
                 :instruction string,
                 :questionDuration string},
   :textEntityExtractionConfig {:annotationSpecSet string}}
  
  Starts a labeling task for text. The type of text labeling task is configured by feature in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/text:label"
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

(defn datasets-video-label$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/datasets/video/label
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventConfig {:clipLength integer,
                 :annotationSpecSets [string],
                 :overlapLength integer},
   :objectDetectionConfig {:extractionFrameRate number,
                           :annotationSpecSet string},
   :objectTrackingConfig {:overlapLength integer,
                          :annotationSpecSet string,
                          :clipLength integer},
   :basicConfig {:annotatedDatasetDisplayName string,
                 :annotatedDatasetDescription string,
                 :labelGroup string,
                 :languageCode string,
                 :userEmailAddress string,
                 :contributorEmails [string],
                 :replicaCount integer,
                 :instruction string,
                 :questionDuration string},
   :feature string,
   :videoClassificationConfig {:applyShotDetection boolean,
                               :annotationSpecSetConfigs [GoogleCloudDatalabelingV1beta1AnnotationSpecSetConfig]}}
  
  Starts a labeling task for video. The type of video labeling task is configured by feature in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/video:label"
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

(defn annotationSpecSets-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/annotationSpecSets/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an annotation spec set by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotationSpecSets-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/annotationSpecSets/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists annotation spec sets for a project. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/annotationSpecSets"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn annotationSpecSets-create$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/annotationSpecSets/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:annotationSpecSet {:name string,
                       :description string,
                       :blockingResources [string],
                       :displayName string,
                       :annotationSpecs [GoogleCloudDatalabelingV1beta1AnnotationSpec]}}
  
  Creates an annotation spec set by providing a set of labels."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/annotationSpecSets"
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

(defn annotationSpecSets-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/annotationSpecSets/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an annotation spec set by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instructions-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/instructions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an instruction by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instructions-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/instructions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an instruction object by resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instructions-create$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/instructions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:instruction {:description string,
                 :pdfInstruction GoogleCloudDatalabelingV1beta1PdfInstruction,
                 :displayName string,
                 :name string,
                 :createTime string,
                 :updateTime string,
                 :csvInstruction GoogleCloudDatalabelingV1beta1CsvInstruction,
                 :dataType string,
                 :blockingResources [string]}}
  
  Creates an instruction for how data should be labeled."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/instructions"
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

(defn instructions-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/instructions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists instructions for a project. Pagination is supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/instructions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-cancel$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-delete$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-get$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn operations-list$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn evaluations-search$
  "https://cloud.google.com/data-labeling/docs/api/reference/rest/v1beta1/projects/evaluations/search
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize
  
  Searches evaluations within a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datalabeling.googleapis.com/"
     "v1beta1/{+parent}/evaluations:search"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
