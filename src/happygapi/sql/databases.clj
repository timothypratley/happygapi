(ns happygapi.sql.databases
  "Cloud SQL Admin API: databases.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/insert
  
  Required parameters: instance, project
  
  Optional parameters: parent
  
  Body: 
  
  {:instance string,
   :name string,
   :selfLink string,
   :etag string,
   :collation string,
   :charset string,
   :project string,
   :kind string,
   :sqlserverDatabaseDetails {:recoveryModel string,
                              :compatibilityLevel integer}}
  
  Inserts a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases"
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
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/get
  
  Required parameters: instance, project, database
  
  Optional parameters: resourceName
  Retrieves a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :database})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/patch
  
  Required parameters: database, instance, project
  
  Optional parameters: resourceName
  
  Body: 
  
  {:instance string,
   :name string,
   :selfLink string,
   :etag string,
   :collation string,
   :charset string,
   :project string,
   :kind string,
   :sqlserverDatabaseDetails {:recoveryModel string,
                              :compatibilityLevel integer}}
  
  Partially updates a resource containing information about a database inside
  a Cloud SQL instance. This method supports patch semantics.
  <aside
  class=\"caution\"><strong>Caution:</strong> This is not a partial update, so
  you must include values for all the settings that you want to retain. For
  partial updates, use <a
  href=\"/sql/docs/db_path/admin-api/rest/v1beta4/instances/update\">update</a>.</aside>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project :database})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
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
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/update
  
  Required parameters: database, instance, project
  
  Optional parameters: resourceName
  
  Body: 
  
  {:instance string,
   :name string,
   :selfLink string,
   :etag string,
   :collation string,
   :charset string,
   :project string,
   :kind string,
   :sqlserverDatabaseDetails {:recoveryModel string,
                              :compatibilityLevel integer}}
  
  Updates a resource containing information about a database inside a Cloud
  SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:instance :project :database})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
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

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/delete
  
  Required parameters: instance, project, database
  
  Optional parameters: resourceName
  Deletes a database from a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project :database})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/databases/list
  
  Required parameters: instance, project
  
  Optional parameters: parent
  Lists databases in the specified Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/databases"
     #{:instance :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
