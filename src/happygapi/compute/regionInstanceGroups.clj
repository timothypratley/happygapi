(ns happygapi.compute.regionInstanceGroups
  "Compute Engine API: regionInstanceGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroups/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of instance group resources contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroups"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroups/get
  
  Required parameters: instanceGroup, project, region
  
  Optional parameters: none
  
  Returns the specified instance group resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :instanceGroup})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroups/{instanceGroup}"
     #{:region :project :instanceGroup}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listInstances$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroups/listInstances
  
  Required parameters: instanceGroup, project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Body: 
  
  {:instanceState string, :portName string}
  
  Lists the instances in the specified instance group and displays information about the named ports. Depending on the specified options, this method can list all instances or only the instances that are running. The orderBy query parameter is not supported."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroups/{instanceGroup}/listInstances"
     #{:region :project :instanceGroup}
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

(defn setNamedPorts$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionInstanceGroups/setNamedPorts
  
  Required parameters: instanceGroup, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:namedPorts [{:name string, :port integer}], :fingerprint string}
  
  Sets the named ports for the specified regional instance group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :instanceGroup})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/instanceGroups/{instanceGroup}/setNamedPorts"
     #{:region :project :instanceGroup}
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
