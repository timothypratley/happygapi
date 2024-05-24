(ns happygapi.logging.monitoredResourceDescriptors
  "Cloud Logging API: monitoredResourceDescriptors.
  Writes log entries and manages your Cloud Logging configuration.
  See: https://cloud.google.com/logging/docs/docs/reference/rest/v2/monitoredResourceDescriptors"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/logging/docs/api/reference/rest/v2/monitoredResourceDescriptors/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken
  
  Lists the descriptors for monitored resource types used by Logging."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/logging.admin"
            "https://www.googleapis.com/auth/logging.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://logging.googleapis.com/"
     "v2/monitoredResourceDescriptors"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
