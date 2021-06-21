(ns happygapi.documentai.projects
  "Cloud Document AI API: projects.
  Service to parse structured information from unstructured or semi-structured documents using state-of-the-art Google AI such as natural language, computer vision, translation, and AutoML.
  See: https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn locations-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, filter, pageSize
  
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

(defn locations-operations-cancelOperation$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/operations/cancelOperation
  
  Required parameters: name
  
  Optional parameters: none
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
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

(defn locations-operations-list$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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

(defn locations-processors-batchProcess$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/batchProcess
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipHumanReview boolean,
   :documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig},
   :inputDocuments {:gcsPrefix GoogleCloudDocumentaiV1GcsPrefix,
                    :gcsDocuments GoogleCloudDocumentaiV1GcsDocuments}}
  
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

(defn locations-processors-process$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/process
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:rawDocument {:mimeType string, :content string},
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
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
   :skipHumanReview boolean}
  
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

(defn locations-processors-humanReviewConfig-reviewDocument$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/humanReviewConfig/reviewDocument
  
  Required parameters: humanReviewConfig
  
  Optional parameters: none
  
  Body: 
  
  {:enableSchemaValidation boolean,
   :priority string,
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
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
                    :text string}}
  
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

(defn locations-processors-processorVersions-batchProcess$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/batchProcess
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:skipHumanReview boolean,
   :documentOutputConfig {:gcsOutputConfig GoogleCloudDocumentaiV1DocumentOutputConfigGcsOutputConfig},
   :inputDocuments {:gcsPrefix GoogleCloudDocumentaiV1GcsPrefix,
                    :gcsDocuments GoogleCloudDocumentaiV1GcsDocuments}}
  
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

(defn locations-processors-processorVersions-process$
  "https://cloud.google.com/document-ai/docs/api/reference/rest/v1/projects/locations/processors/processorVersions/process
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:rawDocument {:mimeType string, :content string},
   :inlineDocument {:textChanges [GoogleCloudDocumentaiV1DocumentTextChange],
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
   :skipHumanReview boolean}
  
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
