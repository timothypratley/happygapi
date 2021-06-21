(ns happygapi.cloudtasks.projects
  "Cloud Tasks API: projects.
  Manages the execution of large numbers of distributed requests.
  See: https://cloud.google.com/tasks/api/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-get$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageToken, pageSize, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-get$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a queue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-setIamPolicy$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:bindings [Binding], :version integer, :etag string}}
  
  Sets the access control policy for a Queue. Replaces any existing policy. Note: The Cloud Console does not check queue-level IAM permissions yet. Project-level permissions are required to use the Cloud Console. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission on the specified resource parent: * `cloudtasks.queues.setIamPolicy`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
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

(defn locations-queues-patch$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:appEngineRoutingOverride {:version string,
                              :instance string,
                              :host string,
                              :service string},
   :rateLimits {:maxDispatchesPerSecond number,
                :maxConcurrentDispatches integer,
                :maxBurstSize integer},
   :state string,
   :retryConfig {:maxBackoff string,
                 :maxRetryDuration string,
                 :maxAttempts integer,
                 :minBackoff string,
                 :maxDoublings integer},
   :stackdriverLoggingConfig {:samplingRatio number},
   :purgeTime string,
   :name string}
  
  Updates a queue. This method creates the queue if it does not exist and updates the queue if it does exist. Queues created with this method allow tasks to live for a maximum of 31 days. After a task is 31 days old, the task will be deleted regardless of whether it was dispatched or not. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
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

(defn locations-queues-testIamPermissions$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on a Queue. If the resource does not exist, this will return an empty set of permissions, not a NOT_FOUND error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
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

(defn locations-queues-create$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:appEngineRoutingOverride {:version string,
                              :instance string,
                              :host string,
                              :service string},
   :rateLimits {:maxDispatchesPerSecond number,
                :maxConcurrentDispatches integer,
                :maxBurstSize integer},
   :state string,
   :retryConfig {:maxBackoff string,
                 :maxRetryDuration string,
                 :maxAttempts integer,
                 :minBackoff string,
                 :maxDoublings integer},
   :stackdriverLoggingConfig {:samplingRatio number},
   :purgeTime string,
   :name string}
  
  Creates a queue. Queues created with this method allow tasks to live for a maximum of 31 days. After a task is 31 days old, the task will be deleted regardless of whether it was dispatched or not. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/queues"
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

(defn locations-queues-delete$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a queue. This command will delete the queue even if it has tasks in it. Note: If you delete a queue, a queue with the same name can't be created for 7 days. WARNING: Using this method may have unintended side effects if you are using an App Engine `queue.yaml` or `queue.xml` file to manage your queues. Read [Overview of Queue Management and queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-getIamPolicy$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a Queue. Returns an empty policy if the resource exists and does not have a policy set. Authorization requires the following [Google IAM](https://cloud.google.com/iam) permission on the specified resource parent: * `cloudtasks.queues.getIamPolicy`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
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

(defn locations-queues-list$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists queues. Queues are returned in lexicographical order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/queues"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-purge$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/purge
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Purges a queue by deleting all of its tasks. All tasks created before this method is called are permanently deleted. Purge operations can take up to one minute to take effect. Tasks might be dispatched before the purge takes effect. A purge is irreversible."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:purge"
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

(defn locations-queues-pause$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses the queue. If a queue is paused then the system will stop dispatching tasks until the queue is resumed via ResumeQueue. Tasks can still be added when the queue is paused. A queue is paused if its state is PAUSED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:pause"
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

(defn locations-queues-resume$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resume a queue. This method resumes a queue after it has been PAUSED or DISABLED. The state of a queue is stored in the queue's state; after calling this method it will be set to RUNNING. WARNING: Resuming many high-QPS queues at the same time can lead to target overloading. If you are resuming high-QPS queues, follow the 500/50/5 pattern described in [Managing Cloud Tasks Scaling Risks](https://cloud.google.com/tasks/docs/manage-cloud-task-scaling)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:resume"
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

(defn locations-queues-tasks-delete$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/tasks/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a task. A task can be deleted if it is scheduled or dispatched. A task cannot be deleted if it has executed successfully or permanently failed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-tasks-list$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/tasks/list
  
  Required parameters: parent
  
  Optional parameters: pageToken, responseView, pageSize
  
  Lists the tasks in a queue. By default, only the BASIC view is retrieved due to performance considerations; response_view controls the subset of information which is returned. The tasks may be returned in any order. The ordering may change at any time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/tasks"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-tasks-get$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/tasks/get
  
  Required parameters: name
  
  Optional parameters: responseView
  
  Gets a task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-tasks-create$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/tasks/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:task {:responseCount integer,
          :dispatchCount integer,
          :name string,
          :scheduleTime string,
          :createTime string,
          :firstAttempt Attempt,
          :dispatchDeadline string,
          :httpRequest HttpRequest,
          :appEngineHttpRequest AppEngineHttpRequest,
          :view string,
          :lastAttempt Attempt},
   :responseView string}
  
  Creates a task and adds it to a queue. Tasks cannot be updated after creation; there is no UpdateTask command. * The maximum task size is 100KB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/tasks"
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

(defn locations-queues-tasks-run$
  "https://cloud.google.com/tasks/api/reference/rest/v2/projects/locations/queues/tasks/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:responseView string}
  
  Forces a task to run now. When this method is called, Cloud Tasks will dispatch the task, even if the task is already running, the queue has reached its RateLimits or is PAUSED. This command is meant to be used for manual debugging. For example, RunTask can be used to retry a failed task after a fix has been made or to manually force a task to be dispatched now. The dispatched task is returned. That is, the task that is returned contains the status after the task is dispatched but before the task is received by its target. If Cloud Tasks receives a successful response from the task's target, then the task will be deleted; otherwise the task's schedule_time will be reset to the time that RunTask was called plus the retry delay specified in the queue's RetryConfig. RunTask returns NOT_FOUND when it is called on a task that has already succeeded or permanently failed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:run"
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
