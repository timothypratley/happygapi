(ns happygapi.sql.databases
  "Cloud SQL Admin API
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: database,instance,project
  
  Deletes a database from a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "database" "instance"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{"project" "database" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: instance,project
  
  Lists databases in the specified Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "instance"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases"
     #{"project" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: instance,project
  
  Inserts a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "instance"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases"
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

(defn get$
  "Required parameters: instance,project,database
  
  Retrieves a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "database" "instance"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{"project" "database" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: instance,project,database
  
  Partially updates a resource containing information about a database inside
  a Cloud SQL instance. This method supports patch semantics.
  <aside
  class=\"caution\"><strong>Caution:</strong> This is not a partial update, so
  you must include values for all the settings that you want to retain. For
  partial updates, use <a
  href=\"/sql/docs/db_path/admin-api/rest/v1beta4/instances/update\">update</a>.</aside>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "database" "instance"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{"project" "database" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: project,database,instance
  
  Updates a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "database" "instance"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{"project" "database" "instance"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
