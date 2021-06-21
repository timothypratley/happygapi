(ns happygapi.compute.httpsHealthChecks
  "Compute Engine API: httpsHealthChecks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/get
  
  Required parameters: project, httpsHealthCheck
  
  Optional parameters: none
  
  Returns the specified HttpsHealthCheck resource. Gets a list of available HTTPS health checks by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :httpsHealthCheck})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}"
     #{:project :httpsHealthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :port integer,
   :host string,
   :requestPath string,
   :id string,
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Creates a HttpsHealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks"
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/list
  
  Required parameters: project
  
  Optional parameters: orderBy, maxResults, filter, returnPartialSuccess, pageToken
  
  Retrieves the list of HttpsHealthCheck resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/patch
  
  Required parameters: httpsHealthCheck, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :port integer,
   :host string,
   :requestPath string,
   :id string,
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Updates a HttpsHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :httpsHealthCheck})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}"
     #{:project :httpsHealthCheck}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/update
  
  Required parameters: project, httpsHealthCheck
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :healthyThreshold integer,
   :name string,
   :selfLink string,
   :port integer,
   :host string,
   :requestPath string,
   :id string,
   :kind string,
   :checkIntervalSec integer,
   :timeoutSec integer,
   :unhealthyThreshold integer}
  
  Updates a HttpsHealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :httpsHealthCheck})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}"
     #{:project :httpsHealthCheck}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/httpsHealthChecks/delete
  
  Required parameters: httpsHealthCheck, project
  
  Optional parameters: requestId
  
  Deletes the specified HttpsHealthCheck resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :httpsHealthCheck})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/httpsHealthChecks/{httpsHealthCheck}"
     #{:project :httpsHealthCheck}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
