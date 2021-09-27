(ns happygapi.compute.regionHealthChecks
  "Compute Engine API: regionHealthChecks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/get
  
  Required parameters: region, project, healthCheck
  
  Optional parameters: none
  
  Returns the specified HealthCheck resource. Gets a list of available health checks by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/update
  
  Required parameters: healthCheck, region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:proxyHeader string,
                     :response string,
                     :port integer,
                     :host string,
                     :portSpecification string,
                     :requestPath string,
                     :portName string},
   :sslHealthCheck {:portName string,
                    :port integer,
                    :response string,
                    :proxyHeader string,
                    :portSpecification string,
                    :request string},
   :creationTimestamp string,
   :tcpHealthCheck {:request string,
                    :portSpecification string,
                    :response string,
                    :port integer,
                    :portName string,
                    :proxyHeader string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:requestPath string,
                      :port integer,
                      :portName string,
                      :host string,
                      :portSpecification string,
                      :response string,
                      :proxyHeader string},
   :id string,
   :httpsHealthCheck {:portName string,
                      :port integer,
                      :host string,
                      :response string,
                      :proxyHeader string,
                      :portSpecification string,
                      :requestPath string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer,
   :grpcHealthCheck {:grpcServiceName string,
                     :portSpecification string,
                     :portName string,
                     :port integer},
   :logConfig {:enable boolean}}
  
  Updates a HealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/list
  
  Required parameters: region, project
  
  Optional parameters: orderBy, returnPartialSuccess, filter, pageToken, maxResults
  
  Retrieves the list of HealthCheck resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:proxyHeader string,
                     :response string,
                     :port integer,
                     :host string,
                     :portSpecification string,
                     :requestPath string,
                     :portName string},
   :sslHealthCheck {:portName string,
                    :port integer,
                    :response string,
                    :proxyHeader string,
                    :portSpecification string,
                    :request string},
   :creationTimestamp string,
   :tcpHealthCheck {:request string,
                    :portSpecification string,
                    :response string,
                    :port integer,
                    :portName string,
                    :proxyHeader string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:requestPath string,
                      :port integer,
                      :portName string,
                      :host string,
                      :portSpecification string,
                      :response string,
                      :proxyHeader string},
   :id string,
   :httpsHealthCheck {:portName string,
                      :port integer,
                      :host string,
                      :response string,
                      :proxyHeader string,
                      :portSpecification string,
                      :requestPath string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer,
   :grpcHealthCheck {:grpcServiceName string,
                     :portSpecification string,
                     :portName string,
                     :port integer},
   :logConfig {:enable boolean}}
  
  Creates a HealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks"
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/delete
  
  Required parameters: project, healthCheck, region
  
  Optional parameters: requestId
  
  Deletes the specified HealthCheck resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionHealthChecks/patch
  
  Required parameters: region, healthCheck, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:proxyHeader string,
                     :response string,
                     :port integer,
                     :host string,
                     :portSpecification string,
                     :requestPath string,
                     :portName string},
   :sslHealthCheck {:portName string,
                    :port integer,
                    :response string,
                    :proxyHeader string,
                    :portSpecification string,
                    :request string},
   :creationTimestamp string,
   :tcpHealthCheck {:request string,
                    :portSpecification string,
                    :response string,
                    :port integer,
                    :portName string,
                    :proxyHeader string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:requestPath string,
                      :port integer,
                      :portName string,
                      :host string,
                      :portSpecification string,
                      :response string,
                      :proxyHeader string},
   :id string,
   :httpsHealthCheck {:portName string,
                      :port integer,
                      :host string,
                      :response string,
                      :proxyHeader string,
                      :portSpecification string,
                      :requestPath string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer,
   :grpcHealthCheck {:grpcServiceName string,
                     :portSpecification string,
                     :portName string,
                     :port integer},
   :logConfig {:enable boolean}}
  
  Updates a HealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
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
