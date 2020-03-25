(ns happygapi.compute.targetInstances
  "Compute Engine API: targetInstances.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of target instances."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/targetInstances"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances/delete
  
  Required parameters: project, targetInstance, zone
  
  Optional parameters: requestId
  
  Deletes the specified TargetInstance resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :targetInstance :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/targetInstances/{targetInstance}"
     #{:zone :targetInstance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances/get
  
  Required parameters: project, targetInstance, zone
  
  Optional parameters: none
  
  Returns the specified TargetInstance resource. Gets a list of available target instances by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :targetInstance :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/targetInstances/{targetInstance}"
     #{:zone :targetInstance :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :instance string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :id string,
   :kind string,
   :natPolicy string}
  
  Creates a TargetInstance resource in the specified project and zone using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/targetInstances"
     #{:zone :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/targetInstances/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of TargetInstance resources available to the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/targetInstances"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
