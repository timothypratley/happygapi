(ns happygapi.compute.targetHttpsProxies
  "Compute Engine API: targetHttpsProxies.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/get
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: none
  
  Returns the specified TargetHttpsProxy resource. Gets a list of available target HTTPS proxies by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :quicOverride string,
   :selfLink string,
   :region string,
   :id string,
   :kind string,
   :sslPolicy string,
   :sslCertificates [string]}
  
  Creates a TargetHttpsProxy resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies"
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

(defn setQuicOverride$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/setQuicOverride
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:quicOverride string}
  
  Sets the QUIC override policy for TargetHttpsProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies/{targetHttpsProxy}/setQuicOverride"
     #{:targetHttpsProxy :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/setSslPolicy
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:sslPolicy string}
  
  Sets the SSL policy for TargetHttpsProxy. The SSL policy specifies the server-side support for SSL features. This affects connections between clients and the HTTPS proxy load balancer. They do not affect the connection between the load balancer and the backends."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies/{targetHttpsProxy}/setSslPolicy"
     #{:targetHttpsProxy :project}
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

(defn setUrlMap$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/setUrlMap
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:urlMap string}
  
  Changes the URL map for TargetHttpsProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap"
     #{:targetHttpsProxy :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves the list of all TargetHttpsProxy resources, regional and global, available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/targetHttpsProxies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setSslCertificates$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/setSslCertificates
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:sslCertificates [string]}
  
  Replaces SslCertificates for TargetHttpsProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates"
     #{:targetHttpsProxy :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/delete
  
  Required parameters: project, targetHttpsProxy
  
  Optional parameters: requestId
  
  Deletes the specified TargetHttpsProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetHttpsProxy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetHttpsProxies/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of TargetHttpsProxy resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/global/targetHttpsProxies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
