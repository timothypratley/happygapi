(ns happygapi.sqladmin.operations
  "Cloud SQL Admin API: operations.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/operations/list
  
  Required parameters: project
  
  Optional parameters: maxResults, instance, pageToken
  
  Lists all instance operations that have been performed on the given Cloud SQL instance in the reverse chronological order of the start time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/operations"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/operations/get
  
  Required parameters: operation, project
  
  Optional parameters: none
  
  Retrieves an instance operation that has been performed on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:operation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/operations/{operation}"
     #{:operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
