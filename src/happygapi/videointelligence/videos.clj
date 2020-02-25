(ns happygapi.videointelligence.videos
  "Cloud Video Intelligence API
  Detects objects, explicit content, and scene changes in videos. It also specifies the region for annotation and transcribes speech to text. Supports both asynchronous API and streaming API.
  See: https://cloud.google.com/video-intelligence/docs/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "videointelligence_schema.edn"))))

(defn annotate$
  "Required parameters: none
  
  Optional parameters: none
  
  Performs asynchronous video annotation. Progress and results can be
  retrieved through the `google.longrunning.Operations` interface.
  `Operation.metadata` contains `AnnotateVideoProgress` (progress).
  `Operation.response` contains `AnnotateVideoResponse` (results)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
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
