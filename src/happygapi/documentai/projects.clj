(ns happygapi.documentai.projects
  "Cloud Document AI API: projects.
  Service to parse structured information from unstructured or semi-structured documents using state-of-the-art Google AI such as natural language, computer vision, translation, and AutoML.
  See: https://cloud.google.com/document-ai/docs/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageToken, pageSize
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-fetchProcessorTypes$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/fetchProcessorTypes
  
  Required parameters: parent
  
  Optional parameters: none
  
  Fetches processor types. Note that we don't use ListProcessorTypes here, because it isn't paginated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}:fetchProcessorTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-operations-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processorTypes-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processorTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor type detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processorTypes-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processorTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists the processor types that exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processors-disable$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/disable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Disables a processor"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:disable"
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

(defn locations-processors-setDefaultProcessorVersion$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/setDefaultProcessorVersion
  
  Required parameters: processor
  
  Optional parameters: none
  
  Body: 
  
  {:defaultProcessorVersion string}
  
  Set the default (active) version of a Processor that will be used in ProcessDocument and BatchProcessDocuments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:processor})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+processor}:setDefaultProcessorVersion"
     #{:processor}
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

(defn locations-processors-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-enable$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/enable
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Enables a processor"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:enable"
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

(defn locations-processors-create$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :createTime string,
   :type string,
   :state string,
   :kmsKeyName string,
   :processorVersionAliases [{:processorVersion string, :alias string}],
   :processEndpoint string,
   :defaultProcessorVersion string}
  
  Creates a processor from the ProcessorType provided. The processor will be at `ENABLED` state by default after its creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processors"
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

(defn locations-processors-process$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/process
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :skipHumanReview boolean,
   :rawDocument {:mimeType string, :displayName string, :content string},
   :gcsDocument {:gcsUri string, :mimeType string},
   :processOptions {:schemaOverride GoogleCloudDocumentaiV1DocumentSchema,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :fromEnd integer,
                    :fromStart integer},
   :labels {},
   :fieldMask string}
  
  Processes a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:process"
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

(defn locations-processors-delete$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the processor, unloads all deployed model artifacts if it was enabled and then deletes all artifacts associated with this processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all processors which belong to this project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processors"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processors-batchProcess$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/batchProcess
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig},
   :inputDocuments {:gcsDocuments GoogleCloudDocumentaiV1GcsDocuments,
                    :gcsPrefix GoogleCloudDocumentaiV1GcsPrefix},
   :processOptions {:schemaOverride GoogleCloudDocumentaiV1DocumentSchema,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :fromEnd integer,
                    :fromStart integer},
   :skipHumanReview boolean,
   :labels {}}
  
  LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:batchProcess"
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

(defn locations-processors-humanReviewConfig-reviewDocument$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/humanReviewConfig/reviewDocument
  
  Required parameters: humanReviewConfig
  
  Optional parameters: none
  
  Body: 
  
  {:inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :priority string,
   :documentSchema {:displayName string,
                    :entityTypes [GoogleCloudDocumentaiV1DocumentSchemaEntityType],
                    :description string,
                    :metadata GoogleCloudDocumentaiV1DocumentSchemaMetadata},
   :enableSchemaValidation boolean}
  
  Send a document for Human Review. The input document should be processed by the specified processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:humanReviewConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+humanReviewConfig}:reviewDocument"
     #{:humanReviewConfig}
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

(defn locations-processors-processorVersions-undeploy$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/undeploy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Undeploys the processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:undeploy"
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

(defn locations-processors-processorVersions-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a processor version detail."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-process$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/process
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
                    :content string,
                    :textStyles [GoogleCloudDocumentaiV1DocumentStyle],
                    :shardInfo GoogleCloudDocumentaiV1DocumentShardInfo,
                    :entities [GoogleCloudDocumentaiV1DocumentEntity],
                    :entityRelations [GoogleCloudDocumentaiV1DocumentEntityRelation],
                    :pages [GoogleCloudDocumentaiV1DocumentPage],
                    :mimeType string,
                    :revisions [GoogleCloudDocumentaiV1DocumentRevision],
                    :error GoogleRpcStatus,
                    :uri string,
                    :text string},
   :skipHumanReview boolean,
   :rawDocument {:mimeType string, :displayName string, :content string},
   :gcsDocument {:gcsUri string, :mimeType string},
   :processOptions {:schemaOverride GoogleCloudDocumentaiV1DocumentSchema,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :fromEnd integer,
                    :fromStart integer},
   :labels {},
   :fieldMask string}
  
  Processes a single document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:process"
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

(defn locations-processors-processorVersions-delete$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the processor version, all artifacts under the processor version will be deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-train$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/train
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:baseProcessorVersion string,
   :inputData {:testDocuments GoogleCloudDocumentaiV1BatchDocumentsInputConfig,
               :trainingDocuments GoogleCloudDocumentaiV1BatchDocumentsInputConfig},
   :customDocumentExtractionOptions {:trainingMethod string},
   :processorVersion {:modelType string,
                      :deprecationInfo GoogleCloudDocumentaiV1ProcessorVersionDeprecationInfo,
                      :kmsKeyVersionName string,
                      :displayName string,
                      :name string,
                      :createTime string,
                      :state string,
                      :googleManaged boolean,
                      :latestEvaluation GoogleCloudDocumentaiV1EvaluationReference,
                      :kmsKeyName string,
                      :documentSchema GoogleCloudDocumentaiV1DocumentSchema},
   :documentSchema {:displayName string,
                    :entityTypes [GoogleCloudDocumentaiV1DocumentSchemaEntityType],
                    :description string,
                    :metadata GoogleCloudDocumentaiV1DocumentSchemaMetadata},
   :foundationModelTuningOptions {:learningRateMultiplier number,
                                  :trainSteps integer}}
  
  Trains a new processor version. Operation metadata is returned as TrainProcessorVersionMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorVersions:train"
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

(defn locations-processors-processorVersions-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Lists all versions of a processor."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+parent}/processorVersions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-processors-processorVersions-batchProcess$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/batchProcess
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig},
   :inputDocuments {:gcsDocuments GoogleCloudDocumentaiV1GcsDocuments,
                    :gcsPrefix GoogleCloudDocumentaiV1GcsPrefix},
   :processOptions {:schemaOverride GoogleCloudDocumentaiV1DocumentSchema,
                    :individualPageSelector GoogleCloudDocumentaiV1ProcessOptionsIndividualPageSelector,
                    :ocrConfig GoogleCloudDocumentaiV1OcrConfig,
                    :fromEnd integer,
                    :fromStart integer},
   :skipHumanReview boolean,
   :labels {}}
  
  LRO endpoint to batch process many documents. The output is written to Cloud Storage as JSON in the [Document] format."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:batchProcess"
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

(defn locations-processors-processorVersions-evaluateProcessorVersion$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/evaluateProcessorVersion
  
  Required parameters: processorVersion
  
  Optional parameters: none
  
  Body: 
  
  {:evaluationDocuments {:gcsDocuments GoogleCloudDocumentaiV1GcsDocuments,
                         :gcsPrefix GoogleCloudDocumentaiV1GcsPrefix}}
  
  Evaluates a ProcessorVersion against annotated documents, producing an Evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:processorVersion})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+processorVersion}:evaluateProcessorVersion"
     #{:processorVersion}
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

(defn locations-processors-processorVersions-deploy$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/deploy
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deploys the processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://documentai.googleapis.com/"
     "v1/{+name}:deploy"
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

(defn locations-processors-processorVersions-evaluations-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/evaluations/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, pageSize
  
  Retrieves a set of evaluations for a given processor version."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn locations-processors-processorVersions-evaluations-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/evaluations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves a specific evaluation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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

(defn operations-get$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://documentai.googleapis.com/"
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
