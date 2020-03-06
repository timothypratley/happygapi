(ns happygapi.deploymentmanager.deployments
  "Google Cloud Deployment Manager API: deployments.
  Declares, configures, and deploys complex solutions on Google Cloud Platform.
  See: https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cancelPreview$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/cancelPreview
  
  Required parameters: deployment, project
  
  Optional parameters: none
  
  Body: 
  
  {:fingerprint string}
  
  Cancels and removes the preview currently associated with the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/cancelPreview"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/get
  
  Required parameters: deployment, project
  
  Optional parameters: none
  Gets information about a specific deployment."
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
     "{project}/global/deployments/{deployment}"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/setIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:condition Expr, :members [string], :role string}],
   :etag string,
   :policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :iamOwned boolean,
            :rules [Rule],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/setIamPolicy"
     #{:project :resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/insert
  
  Required parameters: project
  
  Optional parameters: createPolicy, preview
  
  Body: 
  
  {:description string,
   :labels [{:key string, :value string}],
   :name string,
   :operation {:description string,
               :creationTimestamp string,
               :startTime string,
               :zone string,
               :name string,
               :targetId string,
               :endTime string,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :data [{:key string, :value string}],
                           :message string}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:description string,
            :labels [DeploymentUpdateLabelEntry],
            :manifest string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Creates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments"
     #{:project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/patch
  
  Required parameters: deployment, project
  
  Optional parameters: createPolicy, deletePolicy, preview
  
  Body: 
  
  {:description string,
   :labels [{:key string, :value string}],
   :name string,
   :operation {:description string,
               :creationTimestamp string,
               :startTime string,
               :zone string,
               :name string,
               :targetId string,
               :endTime string,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :data [{:key string, :value string}],
                           :message string}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:description string,
            :labels [DeploymentUpdateLabelEntry],
            :manifest string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Updates a deployment and all of the resources described by the deployment manifest. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/testIamPermissions"
     #{:project :resource}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/update
  
  Required parameters: deployment, project
  
  Optional parameters: createPolicy, deletePolicy, preview
  
  Body: 
  
  {:description string,
   :labels [{:key string, :value string}],
   :name string,
   :operation {:description string,
               :creationTimestamp string,
               :startTime string,
               :zone string,
               :name string,
               :targetId string,
               :endTime string,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :data [{:key string, :value string}],
                           :message string}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:description string,
            :labels [DeploymentUpdateLabelEntry],
            :manifest string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Updates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/delete
  
  Required parameters: deployment, project
  
  Optional parameters: deletePolicy
  Deletes a deployment and all of the resources in the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{resource}/getIamPolicy"
     #{:project :resource}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn stop$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/stop
  
  Required parameters: deployment, project
  
  Optional parameters: none
  
  Body: 
  
  {:fingerprint string}
  
  Stops an ongoing operation. This does not roll back any work that has already been completed, but prevents any new work from being started."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project :deployment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments/{deployment}/stop"
     #{:project :deployment}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-manager/api/reference/rest/v2/deployments/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Lists all deployments for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/deploymentmanager/v2/projects/"
     "{project}/global/deployments"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
