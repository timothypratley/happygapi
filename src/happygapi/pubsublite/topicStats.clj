(ns happygapi.pubsublite.topicStats
  "Pub/Sub Lite API: topicStats.
  
  See: https://cloud.google.com/pubsub/lite/docsdocs/reference/rest/v1/topicStats"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn projects-locations-topics-computeMessageStats$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/topicStats/projects/locations/topics/computeMessageStats
  
  Required parameters: topic
  
  Optional parameters: none
  
  Body: 
  
  {:partition string,
   :startCursor {:offset string},
   :endCursor {:offset string}}
  
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

(defn projects-locations-topics-computeHeadCursor$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/topicStats/projects/locations/topics/computeHeadCursor
  
  Required parameters: topic
  
  Optional parameters: none
  
  Body: 
  
  {:partition string}
  
  Compute the head cursor for the partition. The head cursor's offset is guaranteed to be less than or equal to all messages which have not yet been acknowledged as published, and greater than the offset of any message whose publish has already been acknowledged. It is zero if there have never been messages in the partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/topicStats/{+topic}:computeHeadCursor"
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

(defn projects-locations-topics-computeTimeCursor$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/topicStats/projects/locations/topics/computeTimeCursor
  
  Required parameters: topic
  
  Optional parameters: none
  
  Body: 
  
  {:partition string, :target {:publishTime string, :eventTime string}}
  
  Compute the corresponding cursor for a publish or event time in a topic partition."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/topicStats/{+topic}:computeTimeCursor"
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
