(ns happygapi.tasks.tasklists
  "Tasks API: tasklists.
  Manages your tasks and task lists.
  See: https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/delete
  
  Required parameters: tasklist
  
  Optional parameters: none
  Deletes the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/get
  
  Required parameters: tasklist
  
  Optional parameters: none
  Returns the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"
            "https://www.googleapis.com/auth/tasks.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :selfLink string,
   :title string,
   :updated string}
  
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
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/list
  
  Required parameters: none
  
  Optional parameters: maxResults, pageToken
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
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/patch
  
  Required parameters: tasklist
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :selfLink string,
   :title string,
   :updated string}
  
  Updates the authenticated user's specified task list. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/google-apps/tasks/firstappapi/reference/rest/v1/tasklists/update
  
  Required parameters: tasklist
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :id string,
   :kind string,
   :selfLink string,
   :title string,
   :updated string}
  
  Updates the authenticated user's specified task list."
  {:scopes ["https://www.googleapis.com/auth/tasks"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:tasklist})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/tasks/v1/"
     "users/@me/lists/{tasklist}"
     #{:tasklist}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
