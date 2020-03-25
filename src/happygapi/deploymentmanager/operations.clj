(ns happygapi.deploymentmanager.operations
  "Google Cloud Deployment Manager API: operations.
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/api/reference/rest/v2/operations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/operations/get
  
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
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/operations/{operation}"
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
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/operations/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
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
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/operations"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
