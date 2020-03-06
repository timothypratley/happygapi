(ns happygapi.compute.targetPools
  "Compute Engine API: targetPools.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getHealth$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/getHealth
  
  Required parameters: project, region, targetPool
  
  Optional parameters: none
  
  Body: 
  
  {:instance string}
  
  Gets the most recent health check results for each IP for the instance that is referenced by the given target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/getHealth"
     #{:region :project :targetPool}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/get
  
  Required parameters: project, region, targetPool
  
  Optional parameters: none
  Returns the specified target pool. Gets a list of available target pools by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}"
     #{:region :project :targetPool}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/insert
  
  Required parameters: project, region
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools"
     #{:region :project}
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

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves an aggregated list of target pools."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/targetPools"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setBackup$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/setBackup
  
  Required parameters: project, region, targetPool
  
  Optional parameters: failoverRatio, requestId
  
  Body: 
  
  {:target string}
  
  Changes a backup target pool's configurations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/setBackup"
     #{:region :project :targetPool}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/delete
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  Deletes the specified target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}"
     #{:region :project :targetPool}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn removeInstance$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/removeInstance
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Removes instance URL from a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/removeInstance"
     #{:region :project :targetPool}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves a list of target pools available to the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools"
     #{:region :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn removeHealthCheck$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/removeHealthCheck
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthChecks [{:healthCheck string}]}
  
  Removes health check URL from a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/removeHealthCheck"
     #{:region :project :targetPool}
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

(defn addInstance$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/addInstance
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Adds an instance to a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/addInstance"
     #{:region :project :targetPool}
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

(defn addHealthCheck$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetPools/addHealthCheck
  
  Required parameters: project, region, targetPool
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthChecks [{:healthCheck string}]}
  
  Adds health check URLs to a target pool."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :targetPool})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetPools/{targetPool}/addHealthCheck"
     #{:region :project :targetPool}
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
