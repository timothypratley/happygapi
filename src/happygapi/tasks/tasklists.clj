(ns happygapi.tasks.tasklists
  "Tasks API
  Manages your tasks and task lists.
  See: https://developers.google.com/google-apps/tasks/firstapp"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: tasklist
  
  Deletes the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})]}
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
  
  Returns the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})]}
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
  
  Creates a new task list and adds it to the authenticated user's task lists. Fails with HTTP code 403 or 429 after reaching the storage limit of 2,000 lists."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
  
  Returns all the authenticated user's task lists."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  
  Updates the authenticated user's specified task list. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})]}
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
  
  Updates the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{"tasklist"})]}
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
