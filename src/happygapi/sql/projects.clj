(ns happygapi.sql.projects
  "Cloud SQL Admin API
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn instances-verifyExternalSyncSettings$
  "Required parameters: instance,project
  
  Verify External master external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/verifyExternalSyncSettings"
     #{"project" "instance"}
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

(defn instances-rescheduleMaintenance$
  "Required parameters: project,instance
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/rescheduleMaintenance"
     #{"project" "instance"}
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

(defn instances-startExternalSync$
  "Required parameters: instance,project
  
  Start External master migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/startExternalSync"
     #{"project" "instance"}
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

(defn locations-instances-startExternalSync$
  "Required parameters: parent
  
  Start External master migration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/startExternalSync"
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

(defn locations-instances-verifyExternalSyncSettings$
  "Required parameters: parent
  
  Verify External master external sync settings."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/verifyExternalSyncSettings"
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

(defn locations-instances-rescheduleMaintenance$
  "Required parameters: parent
  
  Reschedules the maintenance on the given instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"parent"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/{+parent}/rescheduleMaintenance"
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
