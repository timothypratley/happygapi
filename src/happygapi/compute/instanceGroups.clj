(ns happygapi.compute.instanceGroups
  "Compute Engine API: instanceGroups.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/get
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: none
  Returns the specified instance group. Gets a list of available instance groups by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{:zone :project :instanceGroup}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/insert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :selfLink string,
   :size integer,
   :region string,
   :id string,
   :kind string,
   :network string,
   :fingerprint string,
   :subnetwork string,
   :namedPorts [{:name string, :port integer}]}
  
  Creates an instance group in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups"
     #{:zone :project}
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

(defn addInstances$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/addInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Adds a list of instances to the specified instance group. All of the instances in the instance group must be in the same network/subnetwork. Read  Adding instances for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/addInstances"
     #{:zone :project :instanceGroup}
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

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves the list of instance groups and sorts them by zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/instanceGroups"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/delete
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  Deletes the specified instance group. The instances in the group are not deleted. Note that instance group must not belong to a backend service. Read  Deleting an instance group for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}"
     #{:zone :project :instanceGroup}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setNamedPorts$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/setNamedPorts
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:fingerprint string, :namedPorts [{:name string, :port integer}]}
  
  Sets the named ports for the specified instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/setNamedPorts"
     #{:zone :project :instanceGroup}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves the list of instance groups that are located in the specified project and zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups"
     #{:zone :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listInstances$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/listInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Body: 
  
  {:instanceState string}
  
  Lists the instances in the specified instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/listInstances"
     #{:zone :project :instanceGroup}
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

(defn removeInstances$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/instanceGroups/removeInstances
  
  Required parameters: instanceGroup, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:instances [{:instance string}]}
  
  Removes one or more instances from the specified instance group, but does not delete those instances.
  
  If the group is part of a backend service that has enabled connection draining, it can take up to 60 seconds after the connection draining duration before the VM instance is removed or deleted."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:zone :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/zones/{zone}/instanceGroups/{instanceGroup}/removeInstances"
     #{:zone :project :instanceGroup}
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
