(ns happygapi.vision.files
  "Cloud Vision API: files.
  Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
  See: https://cloud.google.com/vision/docs/reference/rest/v1/files"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn annotate$
  "https://cloud.google.com/vision/api/reference/rest/v1/files/annotate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:inputConfig InputConfig,
               :features [Feature],
               :imageContext ImageContext,
               :pages [integer]}],
   :parent string,
   :labels {}}
  
  Service that performs image detection and annotation for a batch of files. Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported. This service will extract at most 5 (customers can specify which 5 in AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each file provided and perform detection and annotation for each image extracted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/files:annotate"
     #{}
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

(defn asyncBatchAnnotate$
  "https://cloud.google.com/vision/api/reference/rest/v1/files/asyncBatchAnnotate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:inputConfig InputConfig,
               :features [Feature],
               :imageContext ImageContext,
               :outputConfig OutputConfig}],
   :parent string,
   :labels {}}
  
  Run asynchronous image detection and annotation for a list of generic files, such as PDF files, which may contain multiple pages and multiple images per page. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/files:asyncBatchAnnotate"
     #{}
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
