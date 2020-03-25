(ns happygapi.sql.tiers
  "Cloud SQL Admin API: tiers.
  API for Cloud SQL database instance management
  See: https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/tiers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/cloud-sql/api/reference/rest/v1beta4/tiers/list
  
  Required parameters: project
  
  Optional parameters: none
  
  Lists all available machine types (tiers) for Cloud SQL, for example,
  db-n1-standard-1. For related information, see <a
  href=\"/sql/pricing\">Pricing</a>."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/sqlservice.admin"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://sqladmin.googleapis.com/"
     "sql/v1beta4/projects/{project}/tiers"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
