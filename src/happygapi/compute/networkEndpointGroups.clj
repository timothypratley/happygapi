(ns happygapi.compute.networkEndpointGroups
  "Compute Engine API: networkEndpointGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/get
  
  Required parameters: zone, networkEndpointGroup, project
  
  Optional parameters: none
  
  Returns the specified network endpoint group. Gets a list of available network endpoint groups by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :networkEndpointGroup :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}"
     #{:zone :networkEndpointGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/insert
  
  Required parameters: zone, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :networkEndpointType string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :cloudFunction {:function string, :urlMask string},
   :selfLink string,
   :cloudRun {:urlMask string, :tag string, :service string},
   :size integer,
   :region string,
   :id string,
   :kind string,
   :appEngine {:version string, :urlMask string, :service string},
   :annotations {},
   :network string,
   :defaultPort integer,
   :subnetwork string}
  
  Creates a network endpoint group in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups"
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/testIamPermissions
  
  Required parameters: zone, resource, project
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{resource}/testIamPermissions"
     #{:zone :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/aggregatedList
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, includeAllScopes, returnPartialSuccess, filter, orderBy
  
  Retrieves the list of network endpoint groups and sorts them by zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/networkEndpointGroups"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/attachNetworkEndpoints
  
  Required parameters: project, networkEndpointGroup, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkEndpoints [{:fqdn string,
                       :instance string,
                       :annotations {},
                       :ipAddress string,
                       :port integer}]}
  
  Attach a list of network endpoints to the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints"
     #{:zone :networkEndpointGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/delete
  
  Required parameters: zone, project, networkEndpointGroup
  
  Optional parameters: requestId
  
  Deletes the specified network endpoint group. The network endpoints in the NEG and the VM instances they belong to are not terminated when the NEG is deleted. Note that the NEG cannot be deleted if there are backend services referencing it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:zone :networkEndpointGroup :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}"
     #{:zone :networkEndpointGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/list
  
  Required parameters: zone, project
  
  Optional parameters: pageToken, returnPartialSuccess, orderBy, filter, maxResults
  
  Retrieves the list of network endpoint groups that are located in the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/listNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project, zone
  
  Optional parameters: pageToken, maxResults, orderBy, returnPartialSuccess, filter
  
  Body: 
  
  {:healthStatus string}
  
  Lists the network endpoints in the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints"
     #{:zone :networkEndpointGroup :project}
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

(defn detachNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/networkEndpointGroups/detachNetworkEndpoints
  
  Required parameters: zone, project, networkEndpointGroup
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkEndpoints [{:fqdn string,
                       :instance string,
                       :annotations {},
                       :ipAddress string,
                       :port integer}]}
  
  Detach a list of network endpoints from the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:zone :networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints"
     #{:zone :networkEndpointGroup :project}
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
