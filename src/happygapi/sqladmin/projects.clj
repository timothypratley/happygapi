(ns happygapi.sqladmin.projects
  "Cloud SQL Admin API: projects.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn instances-rescheduleMaintenance$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/rescheduleMaintenance
  
  Required parameters: project, instance
  
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

(defn instances-verifyExternalSyncSettings$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/verifyExternalSyncSettings
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:verifyConnectionOnly boolean,
   :syncMode string,
   :verifyReplicationOnly boolean,
   :mysqlSyncConfig {:initialSyncFlags [SyncFlags]},
   :migrationType string,
   :syncParallelLevel string}
  
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

(defn instances-startExternalSync$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/startExternalSync
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:syncMode string,
   :skipVerification boolean,
   :mysqlSyncConfig {:initialSyncFlags [SyncFlags]},
   :syncParallelLevel string,
   :migrationType string}
  
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

(defn instances-performDiskShrink$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/performDiskShrink
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {:targetSizeGb string}
  
  Perform Disk Shrink on primary instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/performDiskShrink"
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

(defn instances-getDiskShrinkConfig$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/getDiskShrinkConfig
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Get Disk Shrink Config for a given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/getDiskShrinkConfig"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn instances-resetReplicaSize$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/resetReplicaSize
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reset Replica Size to primary instance disk size."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/resetReplicaSize"
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

(defn instances-getLatestRecoveryTime$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/projects/instances/getLatestRecoveryTime
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Get Latest Recovery Time for a given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/getLatestRecoveryTime"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
