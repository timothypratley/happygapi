(ns happygapi.pubsub.projects
  "Cloud Pub/Sub API: projects.
  Provides reliable, many-to-many, asynchronous messaging between applications. 
  See: https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn subscriptions-get$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/get
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Gets the configuration details of a subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}"
     #{:subscription}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-setIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn subscriptions-detach$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/detach
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Detaches a subscription from this topic. All messages retained in the subscription are dropped. Subsequent `Pull` and `StreamingPull` requests will return FAILED_PRECONDITION. If the subscription is a push subscription, pushes to the endpoint will stop."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:detach"
     #{:subscription}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-acknowledge$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/acknowledge
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:ackIds [string]}
  
  Acknowledges the messages associated with the `ack_ids` in the `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages from the subscription. Acknowledging a message whose ack deadline has expired may succeed, but such a message may be redelivered later. Acknowledging a message more than once will not result in an error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:acknowledge"
     #{:subscription}
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

(defn subscriptions-patch$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :subscription {:expirationPolicy ExpirationPolicy,
                  :labels {},
                  :name string,
                  :retryPolicy RetryPolicy,
                  :messageRetentionDuration string,
                  :detached boolean,
                  :topic string,
                  :deadLetterPolicy DeadLetterPolicy,
                  :retainAckedMessages boolean,
                  :filter string,
                  :enableMessageOrdering boolean,
                  :pushConfig PushConfig,
                  :ackDeadlineSeconds integer}}
  
  Updates an existing subscription. Note that certain properties of a subscription, such as its topic, are not modifiable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn subscriptions-testIamPermissions$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn subscriptions-create$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:expirationPolicy {:ttl string},
   :labels {},
   :name string,
   :retryPolicy {:maximumBackoff string, :minimumBackoff string},
   :messageRetentionDuration string,
   :detached boolean,
   :topic string,
   :deadLetterPolicy {:deadLetterTopic string,
                      :maxDeliveryAttempts integer},
   :retainAckedMessages boolean,
   :filter string,
   :enableMessageOrdering boolean,
   :pushConfig {:attributes {},
                :oidcToken OidcToken,
                :pushEndpoint string},
   :ackDeadlineSeconds integer}
  
  Creates a subscription to a given topic. See the [resource name rules] (https://cloud.google.com/pubsub/docs/admin#resource_names). If the subscription already exists, returns `ALREADY_EXISTS`. If the corresponding topic doesn't exist, returns `NOT_FOUND`. If the name is not provided in the request, the server will assign a random name for this subscription on the same project as the topic, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in the returned Subscription object. Note that for REST API requests, you must specify a name in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn subscriptions-modifyAckDeadline$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/modifyAckDeadline
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:ackDeadlineSeconds integer, :ackIds [string]}
  
  Modifies the ack deadline for a specific message. This method is useful to indicate that more time is needed to process a message by the subscriber, or to make the message available for redelivery if the processing was interrupted. Note that this does not modify the subscription-level `ackDeadlineSeconds` used for subsequent messages."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:modifyAckDeadline"
     #{:subscription}
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

(defn subscriptions-delete$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/delete
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Deletes an existing subscription. All messages retained in the subscription are immediately dropped. Calls to `Pull` after deletion will return `NOT_FOUND`. After a subscription is deleted, a new one may be created with the same name, but the new one has no association with the old subscription or its topic unless the same topic is specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}"
     #{:subscription}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-getIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-modifyPushConfig$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/modifyPushConfig
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:pushConfig {:attributes {},
                :oidcToken OidcToken,
                :pushEndpoint string}}
  
  Modifies the `PushConfig` for a specified subscription. This may be used to change a push subscription to a pull one (signified by an empty `PushConfig`) or vice versa, or change the endpoint URL and other attributes of a push subscription. Messages will accumulate for delivery continuously through the call regardless of changes to the `PushConfig`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:modifyPushConfig"
     #{:subscription}
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

(defn subscriptions-list$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/list
  
  Required parameters: project
  
  Optional parameters: pageToken, pageSize
  
  Lists matching subscriptions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/subscriptions"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-seek$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/seek
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:snapshot string, :time string}
  
  Seeks an existing subscription to a point in time or to a given snapshot, whichever is provided in the request. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. Note that both the subscription and the snapshot must be on the same topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:seek"
     #{:subscription}
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

(defn subscriptions-pull$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/subscriptions/pull
  
  Required parameters: subscription
  
  Optional parameters: none
  
  Body: 
  
  {:maxMessages integer, :returnImmediately boolean}
  
  Pulls messages from the server. The server may return `UNAVAILABLE` if there are too many concurrent pull requests pending for the given subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:subscription})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:pull"
     #{:subscription}
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

(defn snapshots-setIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn snapshots-getIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-delete$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/delete
  
  Required parameters: snapshot
  
  Optional parameters: none
  
  Removes an existing snapshot. Snapshots are used in [Seek] (https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. When the snapshot is deleted, all messages retained in the snapshot are immediately dropped. After a snapshot is deleted, a new one may be created with the same name, but the new one has no association with the old snapshot or its subscription, unless the same subscription is specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:snapshot})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+snapshot}"
     #{:snapshot}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-list$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/list
  
  Required parameters: project
  
  Optional parameters: pageToken, pageSize
  
  Lists the existing snapshots. Snapshots are used in [Seek]( https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/snapshots"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-get$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/get
  
  Required parameters: snapshot
  
  Optional parameters: none
  
  Gets the configuration details of a snapshot. Snapshots are used in Seek operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:snapshot})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+snapshot}"
     #{:snapshot}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-patch$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:snapshot {:labels {},
              :topic string,
              :expireTime string,
              :name string},
   :updateMask string}
  
  Updates an existing snapshot. Snapshots are used in Seek operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn snapshots-testIamPermissions$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn snapshots-create$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/snapshots/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {}, :subscription string}
  
  Creates a snapshot from the requested subscription. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot. If the snapshot already exists, returns `ALREADY_EXISTS`. If the requested subscription doesn't exist, returns `NOT_FOUND`. If the backlog in the subscription is too old -- and the resulting snapshot would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned. See also the `Snapshot.expire_time` field. If the name is not provided in the request, the server will assign a random name for this snapshot on the same project as the subscription, conforming to the [resource name format] (https://cloud.google.com/pubsub/docs/admin#resource_names). The generated name is populated in the returned Snapshot object. Note that for REST API requests, you must specify a name in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn topics-get$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/get
  
  Required parameters: topic
  
  Optional parameters: none
  
  Gets the configuration of a topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}"
     #{:topic}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-setIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer, :etag string, :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn topics-patch$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:topic {:labels {},
           :kmsKeyName string,
           :messageStoragePolicy MessageStoragePolicy,
           :name string},
   :updateMask string}
  
  Updates an existing topic. Note that certain properties of a topic are not modifiable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn topics-testIamPermissions$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn topics-create$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/create
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:labels {},
   :kmsKeyName string,
   :messageStoragePolicy {:allowedPersistenceRegions [string]},
   :name string}
  
  Creates the given topic with the given name. See the [resource name rules] (https://cloud.google.com/pubsub/docs/admin#resource_names)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
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

(defn topics-delete$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/delete
  
  Required parameters: topic
  
  Optional parameters: none
  
  Deletes the topic with the given name. Returns `NOT_FOUND` if the topic does not exist. After a topic is deleted, a new topic may be created with the same name; this is an entirely new topic with none of the old configuration or subscriptions. Existing subscriptions to this topic are not deleted, but their `topic` field is set to `_deleted-topic_`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}"
     #{:topic}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-getIamPolicy$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-list$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/list
  
  Required parameters: project
  
  Optional parameters: pageToken, pageSize
  
  Lists matching topics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/topics"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-publish$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/publish
  
  Required parameters: topic
  
  Optional parameters: none
  
  Body: 
  
  {:messages [{:attributes {},
               :orderingKey string,
               :data string,
               :messageId string,
               :publishTime string}]}
  
  Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}:publish"
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

(defn topics-snapshots-list$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/snapshots/list
  
  Required parameters: topic
  
  Optional parameters: pageSize, pageToken
  
  Lists the names of the snapshots on this topic. Snapshots are used in [Seek](https://cloud.google.com/pubsub/docs/replay-overview) operations, which allow you to manage message acknowledgments in bulk. That is, you can set the acknowledgment state of messages in an existing subscription to the state captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}/snapshots"
     #{:topic}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn topics-subscriptions-list$
  "https://cloud.google.com/pubsub/docsapi/reference/rest/v1/projects/topics/subscriptions/list
  
  Required parameters: topic
  
  Optional parameters: pageSize, pageToken
  
  Lists the names of the attached subscriptions on this topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:topic})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}/subscriptions"
     #{:topic}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
