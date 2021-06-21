(ns happygapi.compute.regionHealthCheckServices
  "Compute Engine API: regionHealthCheckServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices/delete
  
  Required parameters: healthCheckService, region, project
  
  Optional parameters: requestId
  
  Deletes the specified regional HealthCheckService."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :healthCheckService})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}"
     #{:region :project :healthCheckService}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices/list
  
  Required parameters: region, project
  
  Optional parameters: maxResults, orderBy, filter, returnPartialSuccess, pageToken
  
  Lists all the HealthCheckService resources that have been configured for the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthCheckServices"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices/get
  
  Required parameters: healthCheckService, region, project
  
  Optional parameters: none
  
  Returns the specified regional HealthCheckService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :healthCheckService})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}"
     #{:region :project :healthCheckService}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices/patch
  
  Required parameters: project, healthCheckService, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthStatusAggregationPolicy string,
   :description string,
   :creationTimestamp string,
   :notificationEndpoints [string],
   :name string,
   :selfLink string,
   :healthChecks [string],
   :region string,
   :id string,
   :kind string,
   :networkEndpointGroups [string],
   :fingerprint string}
  
  Updates the specified regional HealthCheckService resource with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :healthCheckService})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthCheckServices/{healthCheckService}"
     #{:region :project :healthCheckService}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthCheckServices/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:healthStatusAggregationPolicy string,
   :description string,
   :creationTimestamp string,
   :notificationEndpoints [string],
   :name string,
   :selfLink string,
   :healthChecks [string],
   :region string,
   :id string,
   :kind string,
   :networkEndpointGroups [string],
   :fingerprint string}
  
  Creates a regional HealthCheckService resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthCheckServices"
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
