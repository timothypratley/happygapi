(ns happygapi.compute.regionTargetHttpsProxies
  "Compute Engine API: regionTargetHttpsProxies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionTargetHttpsProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of TargetHttpsProxy resources available to the specified project in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/get
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: none
  
  Returns the specified TargetHttpsProxy resource in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpsProxy :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :httpKeepAliveTimeoutSec integer,
   :quicOverride string,
   :selfLink string,
   :serverTlsPolicy string,
   :region string,
   :certificateMap string,
   :id string,
   :kind string,
   :sslPolicy string,
   :sslCertificates [string],
   :authorizationPolicy string,
   :fingerprint string,
   :proxyBind boolean}
  
  Creates a TargetHttpsProxy resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/delete
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: requestId
  
  Deletes the specified TargetHttpsProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpsProxy :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/patch
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :httpKeepAliveTimeoutSec integer,
   :quicOverride string,
   :selfLink string,
   :serverTlsPolicy string,
   :region string,
   :certificateMap string,
   :id string,
   :kind string,
   :sslPolicy string,
   :sslCertificates [string],
   :authorizationPolicy string,
   :fingerprint string,
   :proxyBind boolean}
  
  Patches the specified regional TargetHttpsProxy resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpsProxy :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/setUrlMap
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:urlMap string}
  
  Changes the URL map for TargetHttpsProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpsProxy :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap"
     #{:targetHttpsProxy :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionTargetHttpsProxies/setSslCertificates
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:sslCertificates [string]}
  
  Replaces SslCertificates for TargetHttpsProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:targetHttpsProxy :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates"
     #{:targetHttpsProxy :region :project}
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
