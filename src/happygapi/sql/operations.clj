(ns happygapi.sql.operations
  "Cloud SQL Admin API
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: operation,project
  
  Retrieves an instance operation that has been performed on an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "operation"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/operations/{operation}"
     #{"project" "operation"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: project
  
  Lists all instance operations that have been performed on the given Cloud
  SQL instance in the reverse chronological order of the start time."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/operations"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
