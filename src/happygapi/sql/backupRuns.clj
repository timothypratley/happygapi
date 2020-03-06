(ns happygapi.sql.backupRuns
  "Cloud SQL Admin API: backupRuns.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/backupRuns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/backupRuns/delete
  
  Required parameters: project, id, instance
  
  Optional parameters: resourceName
  Deletes the backup taken by a backup run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :id})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/backupRuns/{id}"
     #{:instance :project :id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/backupRuns/insert
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:description string,
   :diskEncryptionConfiguration {:kind string, :kmsKeyName string},
   :instance string,
   :startTime string,
   :windowStartTime string,
   :endTime string,
   :enqueuedTime string,
   :selfLink string,
   :type string,
   :diskEncryptionStatus {:kmsKeyVersionName string, :kind string},
   :status string,
   :id string,
   :kind string,
   :error {:message string, :kind string, :code string},
   :location string}
  
  Creates a new backup run on demand. This method is applicable only to
  Second Generation instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/backupRuns"
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

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/backupRuns/get
  
  Required parameters: project, id, instance
  
  Optional parameters: resourceName
  Retrieves a resource containing information about a backup run."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/backupRuns/{id}"
     #{:instance :project :id}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/backupRuns/list
  
  Required parameters: instance, project
  
  Optional parameters: pageToken, maxResults, parent
  Lists all backup runs associated with a given instance and configuration in
  the reverse chronological order of the backup initiation time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/backupRuns"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
