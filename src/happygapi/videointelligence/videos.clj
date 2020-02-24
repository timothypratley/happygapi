(ns happygapi.videointelligence.videos
  "Cloud Video Intelligence API
  Detects objects, explicit content, and scene changes in videos. It also specifies the region for annotation and transcribes speech to text. Supports both asynchronous API and streaming API.
  See: https://cloud.google.com/video-intelligence/docs/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn annotate$
  "Required parameters: none
  
  Performs asynchronous video annotation. Progress and results can be
  retrieved through the `google.longrunning.Operations` interface.
  `Operation.metadata` contains `AnnotateVideoProgress` (progress).
  `Operation.response` contains `AnnotateVideoResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://videointelligence.googleapis.com/"
     "v1/videos:annotate"
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
