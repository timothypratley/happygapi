(ns happygapi.deploymentmanager.resources
  "Google Cloud Deployment Manager API: resources.
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/api/reference/rest/v2/resources"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/resources/get
  
  Required parameters: deployment, project, resource
  
  Optional parameters: none
  
  Gets information about a single resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/resources/{resource}"
     #{:project :resource :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/resources/list
  
  Required parameters: deployment, project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Lists all resources in a given deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/resources"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
