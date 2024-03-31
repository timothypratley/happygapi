(ns happygapi.deploymentmanager.types
  "Cloud Deployment Manager V2 API: types.
  The Google Cloud Deployment Manager v2 API provides services for configuring, deploying, and viewing Google Cloud services and APIs via templates which specify deployments of Cloud resources.
  See: https://cloud.google.com/deployment-managerapi/reference/rest/v2/types"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/types/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, filter, orderBy
  
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
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/types"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
