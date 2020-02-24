(ns happygapi.vision.files
  "Cloud Vision API
  Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
  See: https://cloud.google.com/vision/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn asyncBatchAnnotate$
  "Required parameters: none
  
  Run asynchronous image detection and annotation for a list of generic
  files, such as PDF files, which may contain multiple pages and multiple
  images per page. Progress and results can be retrieved through the
  `google.longrunning.Operations` interface.
  `Operation.metadata` contains `OperationMetadata` (metadata).
  `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/files:asyncBatchAnnotate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn annotate$
  "Required parameters: none
  
  Service that performs image detection and annotation for a batch of files.
  Now only \"application/pdf\", \"image/tiff\" and \"image/gif\" are supported.
  
  This service will extract at most 5 (customers can specify which 5 in
  AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
  file provided and perform detection and annotation for each image
  extracted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/files:annotate"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
