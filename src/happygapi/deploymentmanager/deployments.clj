(ns happygapi.deploymentmanager.deployments
  "Google Cloud Deployment Manager API
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn cancelPreview$
  "Required parameters: deployment,project
  
  Cancels and removes the preview currently associated with the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/cancelPreview"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn get$
  "Required parameters: deployment,project
  
  Gets information about a specific deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "Required parameters: project,resource
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/setIamPolicy"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn insert$
  "Required parameters: project
  
  Creates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn patch$
  "Required parameters: deployment,project
  
  Updates a deployment and all of the resources described by the deployment manifest. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "Required parameters: project,resource
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/testIamPermissions"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn update$
  "Required parameters: deployment,project
  
  Updates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "Required parameters: deployment,project
  
  Deletes a deployment and all of the resources in the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "Required parameters: project,resource
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{"resource" "project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/getIamPolicy"
     #{"resource" "project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn stop$
  "Required parameters: deployment,project
  
  Stops an ongoing operation. This does not roll back any work that has already been completed, but prevents any new work from being started."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"project" "deployment"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/stop"
     #{"project" "deployment"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn list$
  "Required parameters: project
  
  Lists all deployments for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"project"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments"
     #{"project"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
