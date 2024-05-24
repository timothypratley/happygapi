(ns happygapi.integrations.connectorPlatformRegions
  "Application Integration API: connectorPlatformRegions.
  
  See: https://cloud.google.com/application-integrationdocs/reference/rest/v1/connectorPlatformRegions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn enumerate$
  "https://cloud.google.com/application-integrationapi/reference/rest/v1/connectorPlatformRegions/enumerate
  
  Required parameters: none
  
  Optional parameters: none
  
  Enumerates the regions for which Connector Platform is provisioned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://integrations.googleapis.com/"
     "v1/connectorPlatformRegions:enumerate"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
