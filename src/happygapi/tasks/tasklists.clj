(ns happygapi.tasks.tasklists
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

(defn delete$
  "Required parameters: tasklist
  
  Optional parameters: none
  
  Deletes the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{"tasklist"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: tasklist
  
  Optional parameters: none
  
  Returns the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{"tasklist"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Optional parameters: none
  
  Creates a new task list and adds it to the authenticated user's task lists. Fails with HTTP code 403 or 429 after reaching the storage limit of 2,000 lists."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists"
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

(defn list$
  "Required parameters: none
  
  Optional parameters: maxResults, pageToken
  
  Returns all the authenticated user's task lists."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: tasklist
  
  Optional parameters: none
  
  Updates the authenticated user's specified task list. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{"tasklist"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: tasklist
  
  Optional parameters: none
  
  Updates the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{"tasklist"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
