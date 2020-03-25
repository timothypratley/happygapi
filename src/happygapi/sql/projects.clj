(ns happygapi.sql.projects
  "Cloud SQL Admin API: projects.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn instances-verifyExternalSyncSettings$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/verifyExternalSyncSettings
  
  Required parameters: instance, project
  
  Optional parameters: syncMode, verifyConnectionOnly
  
  Verify External master external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/verifyExternalSyncSettings"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-rescheduleMaintenance$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/rescheduleMaintenance
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:reschedule {:rescheduleType string, :scheduleTime string}}
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/rescheduleMaintenance"
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
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/startExternalSync
  
  Required parameters: instance, project
  
  Optional parameters: syncMode
  
  Start External master migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/startExternalSync"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
