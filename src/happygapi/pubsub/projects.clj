(ns happygapi.pubsub.projects
  "Cloud Pub/Sub API
  Provides reliable, many-to-many, asynchronous messaging between applications.
  
  See: https://cloud.google.com/pubsub/docs"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn subscriptions-get$
  "Required parameters: subscription
  
  Gets the configuration details of a subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}"
     #{"subscription"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn subscriptions-acknowledge$
  "Required parameters: subscription
  
  Acknowledges the messages associated with the `ack_ids` in the
  `AcknowledgeRequest`. The Pub/Sub system can remove the relevant messages
  from the subscription.
  
  Acknowledging a message whose ack deadline has expired may succeed,
  but such a message may be redelivered later. Acknowledging a message more
  than once will not result in an error."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:acknowledge"
     #{"subscription"}
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

(defn subscriptions-patch$
  "Required parameters: name
  
  Updates an existing subscription. Note that certain properties of a
  subscription, such as its topic, are not modifiable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn subscriptions-create$
  "Required parameters: name
  
  Creates a subscription to a given topic. See the
  <a href=\"https://cloud.google.com/pubsub/docs/admin#resource_names\">
  resource name rules</a>.
  If the subscription already exists, returns `ALREADY_EXISTS`.
  If the corresponding topic doesn't exist, returns `NOT_FOUND`.
  
  If the name is not provided in the request, the server will assign a random
  name for this subscription on the same project as the topic, conforming
  to the
  [resource name
  format](https://cloud.google.com/pubsub/docs/admin#resource_names). The
  generated name is populated in the returned Subscription object. Note that
  for REST API requests, you must specify a name in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-modifyAckDeadline$
  "Required parameters: subscription
  
  Modifies the ack deadline for a specific message. This method is useful
  to indicate that more time is needed to process a message by the
  subscriber, or to make the message available for redelivery if the
  processing was interrupted. Note that this does not modify the
  subscription-level `ackDeadlineSeconds` used for subsequent messages."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:modifyAckDeadline"
     #{"subscription"}
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

(defn subscriptions-delete$
  "Required parameters: subscription
  
  Deletes an existing subscription. All messages retained in the subscription
  are immediately dropped. Calls to `Pull` after deletion will return
  `NOT_FOUND`. After a subscription is deleted, a new one may be created with
  the same name, but the new one has no association with the old
  subscription or its topic unless the same topic is specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}"
     #{"subscription"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-modifyPushConfig$
  "Required parameters: subscription
  
  Modifies the `PushConfig` for a specified subscription.
  
  This may be used to change a push subscription to a pull one (signified by
  an empty `PushConfig`) or vice versa, or change the endpoint URL and other
  attributes of a push subscription. Messages will accumulate for delivery
  continuously through the call regardless of changes to the `PushConfig`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:modifyPushConfig"
     #{"subscription"}
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

(defn subscriptions-list$
  "Required parameters: project
  
  Lists matching subscriptions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/subscriptions"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-seek$
  "Required parameters: subscription
  
  Seeks an existing subscription to a point in time or to a given snapshot,
  whichever is provided in the request. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot. Note that both the subscription and the snapshot
  must be on the same topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:seek"
     #{"subscription"}
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

(defn subscriptions-pull$
  "Required parameters: subscription
  
  Pulls messages from the server. The server may return `UNAVAILABLE` if
  there are too many concurrent pull requests pending for the given
  subscription."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscription"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+subscription}:pull"
     #{"subscription"}
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

(defn snapshots-delete$
  "Required parameters: snapshot
  
  Removes an existing snapshot. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot.<br><br>
  When the snapshot is deleted, all messages retained in the snapshot
  are immediately dropped. After a snapshot is deleted, a new one may be
  created with the same name, but the new one has no association with the old
  snapshot or its subscription, unless the same subscription is specified."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"snapshot"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+snapshot}"
     #{"snapshot"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-list$
  "Required parameters: project
  
  Lists the existing snapshots. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/snapshots"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-create$
  "Required parameters: name
  
  Creates a snapshot from the requested subscription. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot.
  <br><br>If the snapshot already exists, returns `ALREADY_EXISTS`.
  If the requested subscription doesn't exist, returns `NOT_FOUND`.
  If the backlog in the subscription is too old -- and the resulting snapshot
  would expire in less than 1 hour -- then `FAILED_PRECONDITION` is returned.
  See also the `Snapshot.expire_time` field. If the name is not provided in
  the request, the server will assign a random
  name for this snapshot on the same project as the subscription, conforming
  to the
  [resource name
  format](https://cloud.google.com/pubsub/docs/admin#resource_names). The
  generated name is populated in the returned Snapshot object. Note that for
  REST API requests, you must specify a name in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn snapshots-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-get$
  "Required parameters: snapshot
  
  Gets the configuration details of a snapshot. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow you to manage message acknowledgments in bulk. That
  is, you can set the acknowledgment state of messages in an existing
  subscription to the state captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"snapshot"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+snapshot}"
     #{"snapshot"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-patch$
  "Required parameters: name
  
  Updates an existing snapshot. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn snapshots-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn topics-get$
  "Required parameters: topic
  
  Gets the configuration of a topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"topic"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}"
     #{"topic"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy on the specified resource. Replaces any
  existing policy.
  
  Can return Public Errors: NOT_FOUND, INVALID_ARGUMENT and PERMISSION_DENIED"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{"resource"}
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

(defn topics-patch$
  "Required parameters: name
  
  Updates an existing topic. Note that certain properties of a
  topic are not modifiable."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on the specified resource.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{"resource"}
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

(defn topics-create$
  "Required parameters: name
  
  Creates the given topic with the given name. See the
  <a href=\"https://cloud.google.com/pubsub/docs/admin#resource_names\">
  resource name rules</a>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-delete$
  "Required parameters: topic
  
  Deletes the topic with the given name. Returns `NOT_FOUND` if the topic
  does not exist. After a topic is deleted, a new topic may be created with
  the same name; this is an entirely new topic with none of the old
  configuration or subscriptions. Existing subscriptions to this topic are
  not deleted, but their `topic` field is set to `_deleted-topic_`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"topic"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}"
     #{"topic"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a resource.
  Returns an empty policy if the resource exists and does not have a policy
  set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{"resource"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-list$
  "Required parameters: project
  
  Lists matching topics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+project}/topics"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-publish$
  "Required parameters: topic
  
  Adds one or more messages to the topic. Returns `NOT_FOUND` if the topic
  does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"topic"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}:publish"
     #{"topic"}
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

(defn topics-subscriptions-list$
  "Required parameters: topic
  
  Lists the names of the subscriptions on this topic."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"topic"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}/subscriptions"
     #{"topic"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn topics-snapshots-list$
  "Required parameters: topic
  
  Lists the names of the snapshots on this topic. Snapshots are used in
  <a href=\"https://cloud.google.com/pubsub/docs/replay-overview\">Seek</a>
  operations, which allow
  you to manage message acknowledgments in bulk. That is, you can set the
  acknowledgment state of messages in an existing subscription to the state
  captured by a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/pubsub"]}
  [auth args]
  {:pre [(util/has-keys? args #{"topic"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://pubsub.googleapis.com/"
     "v1/{+topic}/snapshots"
     #{"topic"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
