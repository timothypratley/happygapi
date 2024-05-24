(ns happygapi.pubsublite.admin
  "Pub/Sub Lite API: admin.
  
  See: https://cloud.google.com/pubsub/lite/docsdocs/reference/rest/v1/admin"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn projects-locations-operations-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-operations-get$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-operations-delete$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-operations-cancel$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}:cancel"
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

(defn projects-locations-topics-create$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/create
  
  Required parameters: parent
  
  Optional parameters: topicId
  
  Body: 
  
  {:name string,
   :partitionConfig {:count string, :scale integer, :capacity Capacity},
   :retentionConfig {:perPartitionBytes string, :period string},
   :reservationConfig {:throughputReservation string}}
  
  Creates a new topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/topics"
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

(defn projects-locations-topics-get$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the topic configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-topics-getPartitions$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/getPartitions
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the partition information for the requested topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}/partitions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-topics-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of topics for the given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/topics"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-topics-patch$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :partitionConfig {:count string, :scale integer, :capacity Capacity},
   :retentionConfig {:perPartitionBytes string, :period string},
   :reservationConfig {:throughputReservation string}}
  
  Updates properties of the specified topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
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

(defn projects-locations-topics-delete$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-topics-subscriptions-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/subscriptions/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Lists the subscriptions attached to the specified topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}/subscriptions"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-subscriptions-create$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/create
  
  Required parameters: parent
  
  Optional parameters: subscriptionId, skipBacklog
  
  Body: 
  
  {:name string,
   :topic string,
   :deliveryConfig {:deliveryRequirement string},
   :exportConfig {:desiredState string,
                  :currentState string,
                  :deadLetterTopic string,
                  :pubsubConfig PubSubConfig}}
  
  Creates a new subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/subscriptions"
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

(defn projects-locations-subscriptions-get$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the subscription configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-subscriptions-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of subscriptions for the given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/subscriptions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-subscriptions-patch$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :topic string,
   :deliveryConfig {:deliveryRequirement string},
   :exportConfig {:desiredState string,
                  :currentState string,
                  :deadLetterTopic string,
                  :pubsubConfig PubSubConfig}}
  
  Updates properties of the specified subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
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

(defn projects-locations-subscriptions-delete$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-subscriptions-seek$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/seek
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:namedTarget string,
   :timeTarget {:publishTime string, :eventTime string}}
  
  Performs an out-of-band seek for a subscription to a specified target, which may be timestamps or named positions within the message backlog. Seek translates these targets to cursors for each partition and orchestrates subscribers to start consuming messages from these seek cursors. If an operation is returned, the seek has been registered and subscribers will eventually receive messages from the seek cursors (i.e. eventual consistency), as long as they are using a minimum supported client library version and not a system that tracks cursors independently of Pub/Sub Lite (e.g. Apache Beam, Dataflow, Spark). The seek operation will fail for unsupported clients. If clients would like to know when subscribers react to the seek (or not), they can poll the operation. The seek operation will succeed and complete once subscribers are ready to receive messages from the seek cursors for all partitions of the topic. This means that the seek operation will not complete until all subscribers come online. If the previous seek operation has not yet completed, it will be aborted and the new invocation of seek will supersede it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}:seek"
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

(defn projects-locations-reservations-create$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/create
  
  Required parameters: parent
  
  Optional parameters: reservationId
  
  Body: 
  
  {:name string, :throughputCapacity string}
  
  Creates a new reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/reservations"
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

(defn projects-locations-reservations-get$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the reservation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-reservations-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of reservations for the given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+parent}/reservations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-reservations-patch$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :throughputCapacity string}
  
  Updates properties of the specified reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
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

(defn projects-locations-reservations-delete$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes the specified reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-locations-reservations-topics-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/reservations/topics/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  Lists the topics attached to the specified reservation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsublite.googleapis.com/"
     "v1/admin/{+name}/topics"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
