(ns happygapi.cloudtasks.projects
  "Cloud Tasks API
  Manages the execution of large numbers of distributed requests.
  See: https://cloud.google.com/tasks/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn locations-list$
  "Required parameters: name
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}/locations"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "Required parameters: name
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-get$
  "Required parameters: name
  
  Gets a queue."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-setIamPolicy$
  "Required parameters: resource
  
  Sets the access control policy for a Queue. Replaces any existing
  policy.
  
  Note: The Cloud Console does not check queue-level IAM permissions yet.
  Project-level permissions are required to use the Cloud Console.
  
  Authorization requires the following
  [Google IAM](https://cloud.google.com/iam) permission on the specified
  resource parent:
  
  * `cloudtasks.queues.setIamPolicy`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:setIamPolicy"
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

(defn locations-queues-patch$
  "Required parameters: name
  
  Updates a queue.
  
  This method creates the queue if it does not exist and updates
  the queue if it does exist.
  
  Queues created with this method allow tasks to live for a maximum of 31
  days. After a task is 31 days old, the task will be deleted regardless of whether
  it was dispatched or not.
  
  WARNING: Using this method may have unintended side effects if you are
  using an App Engine `queue.yaml` or `queue.xml` file to manage your queues.
  Read
  [Overview of Queue Management and
  queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using
  this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-testIamPermissions$
  "Required parameters: resource
  
  Returns permissions that a caller has on a Queue.
  If the resource does not exist, this will return an empty set of
  permissions, not a NOT_FOUND error.
  
  Note: This operation is designed to be used for building permission-aware
  UIs and command-line tools, not for authorization checking. This operation
  may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:testIamPermissions"
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

(defn locations-queues-create$
  "Required parameters: parent
  
  Creates a queue.
  
  Queues created with this method allow tasks to live for a maximum of 31
  days. After a task is 31 days old, the task will be deleted regardless of whether
  it was dispatched or not.
  
  WARNING: Using this method may have unintended side effects if you are
  using an App Engine `queue.yaml` or `queue.xml` file to manage your queues.
  Read
  [Overview of Queue Management and
  queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using
  this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/queues"
     #{"parent"}
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

(defn locations-queues-delete$
  "Required parameters: name
  
  Deletes a queue.
  
  This command will delete the queue even if it has tasks in it.
  
  Note: If you delete a queue, a queue with the same name can't be created
  for 7 days.
  
  WARNING: Using this method may have unintended side effects if you are
  using an App Engine `queue.yaml` or `queue.xml` file to manage your queues.
  Read
  [Overview of Queue Management and
  queue.yaml](https://cloud.google.com/tasks/docs/queue-yaml) before using
  this method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-getIamPolicy$
  "Required parameters: resource
  
  Gets the access control policy for a Queue.
  Returns an empty policy if the resource exists and does not have a policy
  set.
  
  Authorization requires the following
  [Google IAM](https://cloud.google.com/iam) permission on the specified
  resource parent:
  
  * `cloudtasks.queues.getIamPolicy`"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+resource}:getIamPolicy"
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

(defn locations-queues-list$
  "Required parameters: parent
  
  Lists queues.
  
  Queues are returned in lexicographical order."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/queues"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-purge$
  "Required parameters: name
  
  Purges a queue by deleting all of its tasks.
  
  All tasks created before this method is called are permanently deleted.
  
  Purge operations can take up to one minute to take effect. Tasks
  might be dispatched before the purge takes effect. A purge is irreversible."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:purge"
     #{"name"}
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

(defn locations-queues-pause$
  "Required parameters: name
  
  Pauses the queue.
  
  If a queue is paused then the system will stop dispatching tasks
  until the queue is resumed via
  ResumeQueue. Tasks can still be added
  when the queue is paused. A queue is paused if its
  state is PAUSED."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:pause"
     #{"name"}
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

(defn locations-queues-resume$
  "Required parameters: name
  
  Resume a queue.
  
  This method resumes a queue after it has been
  PAUSED or
  DISABLED. The state of a queue is stored
  in the queue's state; after calling this method it
  will be set to RUNNING.
  
  WARNING: Resuming many high-QPS queues at the same time can
  lead to target overloading. If you are resuming high-QPS
  queues, follow the 500/50/5 pattern described in
  [Managing Cloud Tasks Scaling
  Risks](https://cloud.google.com/tasks/docs/manage-cloud-task-scaling)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:resume"
     #{"name"}
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

(defn locations-queues-tasks-create$
  "Required parameters: parent
  
  Creates a task and adds it to a queue.
  
  Tasks cannot be updated after creation; there is no UpdateTask command.
  
  * The maximum task size is 100KB."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/tasks"
     #{"parent"}
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

(defn locations-queues-tasks-run$
  "Required parameters: name
  
  Forces a task to run now.
  
  When this method is called, Cloud Tasks will dispatch the task, even if
  the task is already running, the queue has reached its RateLimits or
  is PAUSED.
  
  This command is meant to be used for manual debugging. For
  example, RunTask can be used to retry a failed
  task after a fix has been made or to manually force a task to be
  dispatched now.
  
  The dispatched task is returned. That is, the task that is returned
  contains the status after the task is dispatched but
  before the task is received by its target.
  
  If Cloud Tasks receives a successful response from the task's
  target, then the task will be deleted; otherwise the task's
  schedule_time will be reset to the time that
  RunTask was called plus the retry delay specified
  in the queue's RetryConfig.
  
  RunTask returns
  NOT_FOUND when it is called on a
  task that has already succeeded or permanently failed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}:run"
     #{"name"}
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

(defn locations-queues-tasks-delete$
  "Required parameters: name
  
  Deletes a task.
  
  A task can be deleted if it is scheduled or dispatched. A task
  cannot be deleted if it has executed successfully or permanently
  failed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-tasks-list$
  "Required parameters: parent
  
  Lists the tasks in a queue.
  
  By default, only the BASIC view is retrieved
  due to performance considerations;
  response_view controls the
  subset of information which is returned.
  
  The tasks may be returned in any order. The ordering may change at any
  time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+parent}/tasks"
     #{"parent"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-queues-tasks-get$
  "Required parameters: name
  
  Gets a task."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth args]
  {:pre [(util/has-keys? args #{"name"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudtasks.googleapis.com/"
     "v2/{+name}"
     #{"name"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
