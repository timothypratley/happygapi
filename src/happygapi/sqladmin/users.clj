(ns happygapi.sqladmin.users
  "Cloud SQL Admin API: users.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/users"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/users/delete
  
  Required parameters: project, instance
  
  Optional parameters: host, name
  
  Deletes a user from a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/users"
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
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/users/insert
  
  Required parameters: instance, project
  
  Optional parameters: none
  
  Body: 
  
  {:instance string,
   :password string,
   :name string,
   :type string,
   :etag string,
   :sqlserverUserDetails {:serverRoles [string], :disabled boolean},
   :host string,
   :project string,
   :kind string}
  
  Creates a new user in a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/users"
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

(defn update$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/users/update
  
  Required parameters: instance, project
  
  Optional parameters: host, name
  
  Body: 
  
  {:instance string,
   :password string,
   :name string,
   :type string,
   :etag string,
   :sqlserverUserDetails {:serverRoles [string], :disabled boolean},
   :host string,
   :project string,
   :kind string}
  
  Updates an existing user in a Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/users"
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

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/users/list
  
  Required parameters: project, instance
  
  Optional parameters: none
  
  Lists users in the specified Cloud SQL instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:instance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/instances/{instance}/users"
     #{:instance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
