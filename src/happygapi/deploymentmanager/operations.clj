(ns happygapi.deploymentmanager.operations
  "Cloud Deployment Manager V2 API: operations.
  The Google Cloud Deployment Manager v2 API provides services for configuring, deploying, and viewing Google Cloud services and APIs via templates which specify deployments of Cloud resources.
  See: https://cloud.google.com/deployment-managerapi/reference/rest/v2/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/operations/get
  
  Required parameters: operation, project
  
  Optional parameters: none
  
  Gets information about a specific operation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:operation :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/operations/{operation}"
     #{:operation :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/operations/list
  
  Required parameters: project
  
  Optional parameters: maxResults, filter, orderBy, pageToken
  
  Lists all operations for a project."
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
     "deploymentmanager/v2/projects/{project}/global/operations"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
