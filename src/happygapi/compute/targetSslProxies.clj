(ns happygapi.compute.targetSslProxies
  "Compute Engine API: targetSslProxies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/list
  
  Required parameters: project
  
  Optional parameters: maxResults, orderBy, pageToken, filter, returnPartialSuccess
  
  Retrieves the list of TargetSslProxy resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/get
  
  Required parameters: targetSslProxy, project
  
  Optional parameters: none
  
  Returns the specified TargetSslProxy resource. Gets a list of available target SSL proxies by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}"
     #{:targetSslProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setProxyHeader$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/setProxyHeader
  
  Required parameters: project, targetSslProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:proxyHeader string}
  
  Changes the ProxyHeaderType for TargetSslProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}/setProxyHeader"
     #{:targetSslProxy :project}
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

(defn setBackendService$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/setBackendService
  
  Required parameters: project, targetSslProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:service string}
  
  Changes the BackendService for TargetSslProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}/setBackendService"
     #{:targetSslProxy :project}
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

(defn setSslCertificates$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/setSslCertificates
  
  Required parameters: project, targetSslProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:sslCertificates [string]}
  
  Changes SslCertificates for TargetSslProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslCertificates"
     #{:targetSslProxy :project}
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

(defn setSslPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/setSslPolicy
  
  Required parameters: targetSslProxy, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:sslPolicy string}
  
  Sets the SSL policy for TargetSslProxy. The SSL policy specifies the server-side support for SSL features. This affects connections between clients and the SSL proxy load balancer. They do not affect the connection between the load balancer and the backends."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}/setSslPolicy"
     #{:targetSslProxy :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :service string,
   :proxyHeader string,
   :creationTimestamp string,
   :name string,
   :selfLink string,
   :id string,
   :kind string,
   :sslPolicy string,
   :sslCertificates [string]}
  
  Creates a TargetSslProxy resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies"
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetSslProxies/delete
  
  Required parameters: project, targetSslProxy
  
  Optional parameters: requestId
  
  Deletes the specified TargetSslProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetSslProxy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetSslProxies/{targetSslProxy}"
     #{:targetSslProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
