(ns happygapi.vision.images
  "Cloud Vision API: images.
  Integrates Google Vision features, including image labeling, face, logo, and landmark detection, optical character recognition (OCR), and detection of explicit content, into applications.
  See: https://cloud.google.com/vision/docs/reference/rest/v1/images"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn annotate$
  "https://cloud.google.com/vision/api/reference/rest/v1/images/annotate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:image Image,
               :features [Feature],
               :imageContext ImageContext}],
   :parent string,
   :labels {}}
  
  Run image detection and annotation for a batch of images."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/images:annotate"
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
  "https://cloud.google.com/vision/api/reference/rest/v1/images/asyncBatchAnnotate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:image Image,
               :features [Feature],
               :imageContext ImageContext}],
   :outputConfig {:gcsDestination GcsDestination, :batchSize integer},
   :parent string,
   :labels {}}
  
  Run asynchronous image detection and annotation for a list of images. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `OperationMetadata` (metadata). `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results). This service will write image annotation outputs to json files in customer GCS bucket, each json file containing BatchAnnotateImagesResponse proto."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-vision"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://vision.googleapis.com/"
     "v1/images:asyncBatchAnnotate"
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
