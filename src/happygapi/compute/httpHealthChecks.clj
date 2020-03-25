(ns happygapi.compute.httpHealthChecks
  "Compute Engine API: httpHealthChecks.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/delete
  
  Required parameters: httpHealthCheck, project
  
  Optional parameters: requestId
  
  Deletes the specified HttpHealthCheck resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:httpHealthCheck :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks/{httpHealthCheck}"
     #{:httpHealthCheck :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/get
  
  Required parameters: httpHealthCheck, project
  
  Optional parameters: none
  
  Returns the specified HttpHealthCheck resource. Gets a list of available HTTP health checks by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:httpHealthCheck :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks/{httpHealthCheck}"
     #{:httpHealthCheck :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/insert
  
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
  
  Creates a HttpHealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of HttpHealthCheck resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/patch
  
  Required parameters: httpHealthCheck, project
  
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
  
  Updates a HttpHealthCheck resource in the specified project using the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:httpHealthCheck :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks/{httpHealthCheck}"
     #{:httpHealthCheck :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/httpHealthChecks/update
  
  Required parameters: httpHealthCheck, project
  
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
  
  Updates a HttpHealthCheck resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:httpHealthCheck :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/httpHealthChecks/{httpHealthCheck}"
     #{:httpHealthCheck :project}
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
