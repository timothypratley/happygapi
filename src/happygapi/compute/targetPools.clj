(ns happygapi.compute.targetPools
  "Compute Engine API: targetPools.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/targetPools"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getHealth$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/getHealth
  
  Required parameters: project, region, targetPool
  
  Optional parameters: none
  
  Body: 
  
  {:instance string}
  
  Gets the most recent health check results for each IP for the instance that is referenced by the given target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/getHealth"
     #{:region :project :targetPool}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/get
  
  Required parameters: project, targetPool, region
  
  Optional parameters: none
  
  Returns the specified target pool. Gets a list of available target pools by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}"
     #{:region :project :targetPool}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :failoverRatio number,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :healthChecks [string],
   :region string,
   :instances [string],
   :id string,
   :kind string,
   :backupPool string,
   :sessionAffinity string}
  
  Creates a target pool in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools"
     #{:region :project}
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/aggregatedList
  
  Required parameters: project
  
  Optional parameters: maxResults, filter, orderBy, returnPartialSuccess, pageToken, includeAllScopes
  
  Retrieves an aggregated list of target pools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/targetPools"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setBackup$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/setBackup
  
  Required parameters: project, targetPool, region
  
  Optional parameters: requestId, failoverRatio
  
  Body: 
  
  {:target string}
  
  Changes a backup target pool's configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/setBackup"
     #{:region :project :targetPool}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/delete
  
  Required parameters: targetPool, region, project
  
  Optional parameters: requestId
  
  Deletes the specified target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}"
     #{:region :project :targetPool}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeInstance$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/removeInstance
  
  Required parameters: project, targetPool, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Removes instance URL from a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/removeInstance"
     #{:region :project :targetPool}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/list
  
  Required parameters: project, region
  
  Optional parameters: returnPartialSuccess, maxResults, filter, orderBy, pageToken
  
  Retrieves a list of target pools available to the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeHealthCheck$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/removeHealthCheck
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthChecks [{:healthCheck string}]}
  
  Removes health check URL from a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/removeHealthCheck"
     #{:region :project :targetPool}
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

(defn addInstance$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/addInstance
  
  Required parameters: region, targetPool, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Adds an instance to a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/addInstance"
     #{:region :project :targetPool}
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

(defn addHealthCheck$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetPools/addHealthCheck
  
  Required parameters: region, project, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthChecks [{:healthCheck string}]}
  
  Adds health check URLs to a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetPools/{targetPool}/addHealthCheck"
     #{:region :project :targetPool}
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
