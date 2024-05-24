(ns happygapi.deploymentmanager.deployments
  "Cloud Deployment Manager V2 API: deployments.
  The Google Cloud Deployment Manager v2 API provides services for configuring, deploying, and viewing Google Cloud services and APIs via templates which specify deployments of Cloud resources.
  See: https://cloud.google.com/deployment-managerdocs/reference/rest/v2/deployments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn cancelPreview$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/cancelPreview
  
  Required parameters: project, deployment
  
  Optional parameters: none
  
  Body: 
  
  {:fingerprint string}
  
  Cancels and removes the preview currently associated with the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/cancelPreview"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/get
  
  Required parameters: project, deployment
  
  Optional parameters: none
  
  Gets information about a specific deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/ndev.cloudman"
            "https://www.googleapis.com/auth/ndev.cloudman.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/setIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :bindings [{:role string, :members [string], :condition Expr}],
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{resource}/setIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/insert
  
  Required parameters: project
  
  Optional parameters: preview, createPolicy
  
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
               :instancesBulkInsertOperationMetadata InstancesBulkInsertOperationMetadata,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :message string,
                           :data [{:key string, :value string}]}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :operationGroupId string,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :setCommonInstanceMetadataOperationMetadata SetCommonInstanceMetadataOperationMetadata,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:manifest string,
            :labels [DeploymentUpdateLabelEntry],
            :description string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Creates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments"
     #{:project}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/patch
  
  Required parameters: project, deployment
  
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
               :instancesBulkInsertOperationMetadata InstancesBulkInsertOperationMetadata,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :message string,
                           :data [{:key string, :value string}]}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :operationGroupId string,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :setCommonInstanceMetadataOperationMetadata SetCommonInstanceMetadataOperationMetadata,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:manifest string,
            :labels [DeploymentUpdateLabelEntry],
            :description string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Patches a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn testIamPermissions$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{resource}/testIamPermissions"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/update
  
  Required parameters: project, deployment
  
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
               :instancesBulkInsertOperationMetadata InstancesBulkInsertOperationMetadata,
               :statusMessage string,
               :selfLink string,
               :warnings [{:code string,
                           :message string,
                           :data [{:key string, :value string}]}],
               :clientOperationId string,
               :region string,
               :httpErrorStatusCode integer,
               :operationGroupId string,
               :status string,
               :targetLink string,
               :id string,
               :insertTime string,
               :kind string,
               :setCommonInstanceMetadataOperationMetadata SetCommonInstanceMetadataOperationMetadata,
               :error {:errors [{:code string,
                                 :location string,
                                 :message string}]},
               :progress integer,
               :user string,
               :httpErrorMessage string,
               :operationType string},
   :selfLink string,
   :update {:manifest string,
            :labels [DeploymentUpdateLabelEntry],
            :description string},
   :manifest string,
   :updateTime string,
   :id string,
   :insertTime string,
   :target {:config ConfigFile, :imports [ImportFile]},
   :fingerprint string}
  
  Updates a deployment and all of the resources described by the deployment manifest."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/delete
  
  Required parameters: project, deployment
  
  Optional parameters: deletePolicy
  
  Deletes a deployment and all of the resources in the deployment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{resource}/getIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn stop$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/stop
  
  Required parameters: project, deployment
  
  Optional parameters: none
  
  Body: 
  
  {:fingerprint string}
  
  Stops an ongoing operation. This does not roll back any work that has already been completed, but prevents any new work from being started."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/ndev.cloudman"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :deployment})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://deploymentmanager.googleapis.com/"
     "deploymentmanager/v2/projects/{project}/global/deployments/{deployment}/stop"
     #{:project :deployment}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/deployment-managerapi/reference/rest/v2/deployments/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, filter, orderBy
  
  Lists all deployments for a given project."
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
     "deploymentmanager/v2/projects/{project}/global/deployments"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
