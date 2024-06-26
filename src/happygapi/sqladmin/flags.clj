(ns happygapi.sqladmin.flags
  "Cloud SQL Admin API: flags.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/docs/reference/rest/v1/flags"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1/flags/list
  
  Required parameters: none
  
  Optional parameters: databaseVersion
  
  Lists all available database flags for Cloud SQL instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "v1/flags"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
