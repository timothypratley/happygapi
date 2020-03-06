(ns happygapi.compute.targetTcpProxies
  "Compute Engine API: targetTcpProxies.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/delete
  
  Required parameters: project, targetTcpProxy
  
  Optional parameters: requestId
  Deletes the specified TargetTcpProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:targetTcpProxy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies/{targetTcpProxy}"
     #{:targetTcpProxy :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/get
  
  Required parameters: project, targetTcpProxy
  
  Optional parameters: none
  Returns the specified TargetTcpProxy resource. Gets a list of available target TCP proxies by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:targetTcpProxy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies/{targetTcpProxy}"
     #{:targetTcpProxy :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:creationTimestamp string,
   :description string,
   :id string,
   :kind string,
   :name string,
   :proxyHeader string,
   :selfLink string,
   :service string}
  
  Creates a TargetTcpProxy resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies"
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

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves the list of TargetTcpProxy resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setBackendService$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/setBackendService
  
  Required parameters: project, targetTcpProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:service string}
  
  Changes the BackendService for TargetTcpProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:targetTcpProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies/{targetTcpProxy}/setBackendService"
     #{:targetTcpProxy :project}
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

(defn setProxyHeader$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetTcpProxies/setProxyHeader
  
  Required parameters: project, targetTcpProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:proxyHeader string}
  
  Changes the ProxyHeaderType for TargetTcpProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:targetTcpProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetTcpProxies/{targetTcpProxy}/setProxyHeader"
     #{:targetTcpProxy :project}
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
