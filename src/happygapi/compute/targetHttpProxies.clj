(ns happygapi.compute.targetHttpProxies
  "Compute Engine API: targetHttpProxies.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setUrlMap$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/setUrlMap
  
  Required parameters: targetHttpProxy, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:urlMap string}
  
  Changes the URL map for TargetHttpProxy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpProxy :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/targetHttpProxies/{targetHttpProxy}/setUrlMap"
     #{:targetHttpProxy :project}
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/get
  
  Required parameters: project, targetHttpProxy
  
  Optional parameters: none
  
  Returns the specified TargetHttpProxy resource. Gets a list of available target HTTP proxies by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetHttpProxy :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetHttpProxies/{targetHttpProxy}"
     #{:targetHttpProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/aggregatedList
  
  Required parameters: project
  
  Optional parameters: pageToken, orderBy, maxResults, includeAllScopes, filter, returnPartialSuccess
  
  Retrieves the list of all TargetHttpProxy resources, regional and global, available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/targetHttpProxies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/delete
  
  Required parameters: project, targetHttpProxy
  
  Optional parameters: requestId
  
  Deletes the specified TargetHttpProxy resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetHttpProxy :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetHttpProxies/{targetHttpProxy}"
     #{:targetHttpProxy :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/list
  
  Required parameters: project
  
  Optional parameters: pageToken, filter, maxResults, orderBy, returnPartialSuccess
  
  Retrieves the list of TargetHttpProxy resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetHttpProxies"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :selfLink string,
   :region string,
   :id string,
   :kind string,
   :fingerprint string,
   :proxyBind boolean}
  
  Creates a TargetHttpProxy resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetHttpProxies"
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/targetHttpProxies/patch
  
  Required parameters: project, targetHttpProxy
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :urlMap string,
   :name string,
   :selfLink string,
   :region string,
   :id string,
   :kind string,
   :fingerprint string,
   :proxyBind boolean}
  
  Patches the specified TargetHttpProxy resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetHttpProxy :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/targetHttpProxies/{targetHttpProxy}"
     #{:targetHttpProxy :project}
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
