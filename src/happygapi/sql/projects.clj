(ns happygapi.sql.projects
  "Cloud SQL Admin API: projects.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-instances-startExternalSync$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/locations/instances/startExternalSync
  
  Required parameters: parent
  
  Optional parameters: instance, project, syncMode
  Start External master migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/startExternalSync"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-verifyExternalSyncSettings$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/locations/instances/verifyExternalSyncSettings
  
  Required parameters: parent
  
  Optional parameters: instance, project, syncMode, verifyConnectionOnly
  Verify External master external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/verifyExternalSyncSettings"
     #{:parent}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-rescheduleMaintenance$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/locations/instances/rescheduleMaintenance
  
  Required parameters: parent
  
  Optional parameters: instance, project
  
  Body: 
  
  {:reschedule {:scheduleTime string, :rescheduleType string}}
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/rescheduleMaintenance"
     #{:parent}
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

(defn instances-startExternalSync$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/startExternalSync
  
  Required parameters: project, instance
  
  Optional parameters: syncMode, parent
  Start External master migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/startExternalSync"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-verifyExternalSyncSettings$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/verifyExternalSyncSettings
  
  Required parameters: project, instance
  
  Optional parameters: syncMode, parent, verifyConnectionOnly
  Verify External master external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/verifyExternalSyncSettings"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn instances-rescheduleMaintenance$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/projects/instances/rescheduleMaintenance
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:reschedule {:scheduleTime string, :rescheduleType string}}
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/rescheduleMaintenance"
     #{:instance :project}
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
