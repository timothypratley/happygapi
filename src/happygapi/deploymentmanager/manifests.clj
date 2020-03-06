(ns happygapi.deploymentmanager.manifests
  "Google Cloud Deployment Manager API: manifests.
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/api/reference/rest/v2/manifests"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/manifests/get
  
  Required parameters: deployment, manifest, project
  
  Optional parameters: none
  Gets information about a specific manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:manifest :project :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/manifests/{manifest}"
     #{:manifest :project :deployment}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/manifests/list
  
  Required parameters: deployment, project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Lists all manifests for a given deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/manifests"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
