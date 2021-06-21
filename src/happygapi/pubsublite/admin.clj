(ns happygapi.pubsublite.admin
  "Pub/Sub Lite API: admin.
  
  See: https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn projects-locations-subscriptions-create$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/subscriptions/create
  
  Required parameters: parent
  
  Optional parameters: skipBacklog, subscriptionId
  
  Body: 
  
  {:deliveryConfig {:deliveryRequirement string},
   :topic string,
   :name string}
  
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
  
  {:deliveryConfig {:deliveryRequirement string},
   :topic string,
   :name string}
  
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

(defn projects-locations-topics-create$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/create
  
  Required parameters: parent
  
  Optional parameters: topicId
  
  Body: 
  
  {:partitionConfig {:capacity Capacity, :count string, :scale integer},
   :retentionConfig {:period string, :perPartitionBytes string},
   :name string}
  
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

(defn projects-locations-topics-patch$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:partitionConfig {:capacity Capacity, :count string, :scale integer},
   :retentionConfig {:period string, :perPartitionBytes string},
   :name string}
  
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

(defn projects-locations-topics-subscriptions-list$
  "https://cloud.google.com/pubsub/lite/docsapi/reference/rest/v1/admin/projects/locations/topics/subscriptions/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize
  
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
