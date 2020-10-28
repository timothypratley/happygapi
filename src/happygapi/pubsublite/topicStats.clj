(ns happygapi.pubsublite.topicStats
  "Pub/Sub Lite API: topicStats.
  
  See: https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/topicStats"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn projects-locations-topics-computeMessageStats$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/topicStats/projects/locations/topics/computeMessageStats
  
  Required parameters: topic
  
  Optional parameters: none
  
  Body: 
  
  {:endCursor {:offset string},
   :partition string,
   :startCursor {:offset string}}
  
  Compute statistics about a range of messages in a given topic and partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/topicStats/{+topic}:computeMessageStats"
     #{:topic}
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
