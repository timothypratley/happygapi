(ns happygapi.analyticshub.organizations
  "Analytics Hub API: organizations.
  Exchange data and analytics assets securely and efficiently.
  See: https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/organizations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-dataExchanges-list$
  "https://cloud.google.com/bigquery/docs/analytics-hub-introductionapi/reference/rest/v1/organizations/locations/dataExchanges/list
  
  Required parameters: organization
  
  Optional parameters: pageSize, pageToken
  
  Lists all data exchanges from projects in a given organization and location."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:organization})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticshub.googleapis.com/"
     "v1/{+organization}/dataExchanges"
     #{:organization}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
