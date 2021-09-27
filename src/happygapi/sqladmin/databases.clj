(ns happygapi.sqladmin.databases
  "Cloud SQL Admin API: databases.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1/databases"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/get
  
  Required parameters: project, database, instance
  
  Optional parameters: none
  
  Retrieves a resource containing information about a database inside a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project :database})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/patch
  
  Required parameters: database, project, instance
  
  Optional parameters: none
  
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
  
  Partially updates a resource containing information about a database inside a Cloud SQL instance. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project :database})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
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

(defn update$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/update
  
  Required parameters: database, project, instance
  
  Optional parameters: none
  
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
  
  Updates a resource containing information about a database inside a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project :database})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
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

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/list
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Lists databases in the specified Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/insert
  
  Required parameters: instance, project
  
  Optional parameters: none
  
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
  
  Inserts a resource containing information about a database inside a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases"
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

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/databases/delete
  
  Required parameters: instance, project, database
  
  Optional parameters: none
  
  Deletes a database from a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project :database})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/projects/{project}/instances/{instance}/databases/{database}"
     #{:instance :project :database}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
