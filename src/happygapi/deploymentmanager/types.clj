(ns happygapi.deploymentmanager.types
  "Google Cloud Deployment Manager API: types.
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/api/reference/rest/v2/types"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/types/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Lists all resource types for Deployment Manager."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/types"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
