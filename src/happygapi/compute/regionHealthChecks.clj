(ns happygapi.compute.regionHealthChecks
  "Compute Engine API: regionHealthChecks.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/delete
  
  Required parameters: healthCheck, project, region
  
  Optional parameters: requestId
  
  Deletes the specified HealthCheck resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/get
  
  Required parameters: healthCheck, project, region
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks/{healthCheck}"
     #{:region :project :healthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:host string,
                     :port integer,
                     :portName string,
                     :portSpecification string,
                     :proxyHeader string,
                     :requestPath string,
                     :response string},
   :sslHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :creationTimestamp string,
   :tcpHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :id string,
   :httpsHealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Creates a HealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks"
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

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of HealthCheck resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/patch
  
  Required parameters: healthCheck, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:host string,
                     :port integer,
                     :portName string,
                     :portSpecification string,
                     :proxyHeader string,
                     :requestPath string,
                     :response string},
   :sslHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :creationTimestamp string,
   :tcpHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :id string,
   :httpsHealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Updates a HealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks/{healthCheck}"
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

(defn update$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionHealthChecks/update
  
  Required parameters: healthCheck, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :httpHealthCheck {:host string,
                     :port integer,
                     :portName string,
                     :portSpecification string,
                     :proxyHeader string,
                     :requestPath string,
                     :response string},
   :sslHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :creationTimestamp string,
   :tcpHealthCheck {:port integer,
                    :portName string,
                    :portSpecification string,
                    :proxyHeader string,
                    :request string,
                    :response string},
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :type string,
   :region string,
   :http2HealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :id string,
   :httpsHealthCheck {:host string,
                      :port integer,
                      :portName string,
                      :portSpecification string,
                      :proxyHeader string,
                      :requestPath string,
                      :response string},
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Updates a HealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :healthCheck})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/healthChecks/{healthCheck}"
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
