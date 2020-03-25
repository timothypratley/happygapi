(ns happygapi.compute.regionTargetHttpsProxies
  "Compute Engine API: regionTargetHttpsProxies.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/delete
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"
     #{:targetHttpsProxy :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/get
  
  Required parameters: project, region, targetHttpsProxy
  
  Optional parameters: none
  
  Returns the specified TargetHttpsProxy resource in the specified region. Gets a list of available target HTTP proxies by making a list() request."
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/insert
  
  Required parameters: project, region
  
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
  
  Creates a TargetHttpsProxy resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of TargetHttpsProxy resources available to the specified project in the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setSslCertificates$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/setSslCertificates
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setSslCertificates"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionTargetHttpsProxies/setUrlMap
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/targetHttpsProxies/{targetHttpsProxy}/setUrlMap"
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
