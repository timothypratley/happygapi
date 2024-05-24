(ns happygapi.monitoring.uptimeCheckIps
  "Cloud Monitoring API: uptimeCheckIps.
  Manages your Cloud Monitoring data and configurations.
  See: https://cloud.google.com/monitoring/api/docs/reference/rest/v3/uptimeCheckIps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/uptimeCheckIps/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Returns the list of IP addresses that checkers run from"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/uptimeCheckIps"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
