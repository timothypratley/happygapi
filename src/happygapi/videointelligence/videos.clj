(ns happygapi.videointelligence.videos
  "Cloud Video Intelligence API: videos.
  Detects objects, explicit content, and scene changes in videos. It also specifies the region for annotation and transcribes speech to text. Supports both asynchronous API and streaming API.
  See: https://cloud.google.com/video-intelligence/docs/api/reference/rest/v1/videos"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn annotate$
  "https://cloud.google.com/video-intelligence/docs/api/reference/rest/v1/videos/annotate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:inputContent string,
   :outputUri string,
   :videoContext {:explicitContentDetectionConfig GoogleCloudVideointelligenceV1_ExplicitContentDetectionConfig,
                  :personDetectionConfig GoogleCloudVideointelligenceV1_PersonDetectionConfig,
                  :textDetectionConfig GoogleCloudVideointelligenceV1_TextDetectionConfig,
                  :labelDetectionConfig GoogleCloudVideointelligenceV1_LabelDetectionConfig,
                  :shotChangeDetectionConfig GoogleCloudVideointelligenceV1_ShotChangeDetectionConfig,
                  :segments [GoogleCloudVideointelligenceV1_VideoSegment],
                  :speechTranscriptionConfig GoogleCloudVideointelligenceV1_SpeechTranscriptionConfig,
                  :faceDetectionConfig GoogleCloudVideointelligenceV1_FaceDetectionConfig,
                  :objectTrackingConfig GoogleCloudVideointelligenceV1_ObjectTrackingConfig},
   :features [string],
   :inputUri string,
   :locationId string}
  
  Performs asynchronous video annotation. Progress and results can be retrieved through the `google.longrunning.Operations` interface. `Operation.metadata` contains `AnnotateVideoProgress` (progress). `Operation.response` contains `AnnotateVideoResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://videointelligence.googleapis.com/"
     "v1/videos:annotate"
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
