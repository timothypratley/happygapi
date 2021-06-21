(ns happygapi.monitoring.uptimeCheckIps
  "Cloud Monitoring API: uptimeCheckIps.
  Manages your Cloud Monitoring data and configurations. Most projects must be associated with a Workspace, with a few exceptions as noted on the individual method pages. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the Cloud Monitoring documentation.
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/uptimeCheckIps"
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
