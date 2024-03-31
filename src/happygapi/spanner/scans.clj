(ns happygapi.spanner.scans
  "Cloud Spanner API: scans.
  Cloud Spanner is a managed, mission-critical, globally consistent and scalable relational database service.
  See: https://cloud.google.com/spanner/api/reference/rest/v1/scans"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/spanner/api/reference/rest/v1/scans/list
  
  Required parameters: parent
  
  Optional parameters: view, filter, pageSize, pageToken
  
  Return available scans given a Database-specific resource name."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/spanner.data"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://spanner.googleapis.com/"
     "v1/{+parent}"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
