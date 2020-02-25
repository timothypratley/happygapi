(ns happygapi.tasks.tasks
  "Tasks API
  Manages your tasks and task lists.
  See: https://developers.google.com/google-apps/tasks/firstapp"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "tasks_schema.edn"))))

(defn clear$
  "Required parameters: tasklist
  
  Optional parameters: none
  
  Clears all completed tasks from the specified task list. The affected tasks will be marked as 'hidden' and no longer be returned by default when retrieving all tasks for a task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/clear"
     #{"tasklist"}
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

(defn delete$
  "Required parameters: task, tasklist
  
  Optional parameters: none
  
  Deletes the specified task from the task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist" "task"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{"tasklist" "task"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: task, tasklist
  
  Optional parameters: none
  
  Returns the specified task."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist" "task"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{"tasklist" "task"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: tasklist
  
  Optional parameters: parent, previous
  
  Creates a new task on the specified task list. Fails with HTTP code 403 or 429 after reaching the storage limit of 100,000 tasks per account."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks"
     #{"tasklist"}
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

(defn list$
  "Required parameters: tasklist
  
  Optional parameters: completedMin, showCompleted, completedMax, pageToken, showHidden, dueMin, showDeleted, updatedMin, dueMax, maxResults
  
  Returns all tasks in the specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks"
     #{"tasklist"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn move$
  "Required parameters: task, tasklist
  
  Optional parameters: parent, previous
  
  Moves the specified task to another position in the task list. This can include putting it as a child task under a new parent and/or move it to a different position among its sibling tasks."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"tasklist" "task"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}/move"
     #{"tasklist" "task"}
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

(defn patch$
  "Required parameters: task, tasklist
  
  Optional parameters: none
  
  Updates the specified task. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist" "task"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{"tasklist" "task"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: task, tasklist
  
  Optional parameters: none
  
  Updates the specified task."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist" "task"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "lists/{tasklist}/tasks/{task}"
     #{"tasklist" "task"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
