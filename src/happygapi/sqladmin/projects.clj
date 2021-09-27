(ns happygapi.sqladmin.projects
  "Cloud SQL Admin API: projects.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn instances-rescheduleMaintenance$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/rescheduleMaintenance
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:reschedule {:scheduleTime string, :rescheduleType string}}
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/rescheduleMaintenance"
     #{:instance :project}
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

(defn instances-startExternalSync$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/startExternalSync
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:mysqlSyncConfig {:initialSyncFlags [SyncFlags]},
   :syncMode string,
   :skipVerification boolean}
  
  Start External primary instance migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/startExternalSync"
     #{:instance :project}
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

(defn instances-verifyExternalSyncSettings$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/verifyExternalSyncSettings
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:verifyConnectionOnly boolean,
   :syncMode string,
   :mysqlSyncConfig {:initialSyncFlags [SyncFlags]},
   :verifyReplicationOnly boolean}
  
  Verify External primary instance external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/verifyExternalSyncSettings"
     #{:instance :project}
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
