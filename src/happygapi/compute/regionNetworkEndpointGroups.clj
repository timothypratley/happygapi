(ns happygapi.compute.regionNetworkEndpointGroups
  "Compute Engine API: regionNetworkEndpointGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of regional network endpoint groups available to the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/get
  
  Required parameters: networkEndpointGroup, project, region
  
  Optional parameters: none
  
  Returns the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:networkEndpointGroup :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}"
     #{:networkEndpointGroup :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :networkEndpointType string,
   :creationTimestamp string,
   :zone string,
   :name string,
   :cloudFunction {:function string, :urlMask string},
   :selfLink string,
   :pscTargetService string,
   :cloudRun {:service string, :tag string, :urlMask string},
   :size integer,
   :region string,
   :pscData {:consumerPscAddress string,
             :pscConnectionId string,
             :pscConnectionStatus string},
   :id string,
   :kind string,
   :appEngine {:service string, :version string, :urlMask string},
   :annotations {},
   :network string,
   :defaultPort integer,
   :subnetwork string}
  
  Creates a network endpoint group in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/delete
  
  Required parameters: networkEndpointGroup, project, region
  
  Optional parameters: requestId
  
  Deletes the specified network endpoint group. Note that the NEG cannot be deleted if it is configured as a backend of a backend service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:networkEndpointGroup :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}"
     #{:networkEndpointGroup :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/attachNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkEndpoints [{:ipAddress string,
                       :fqdn string,
                       :port integer,
                       :instance string,
                       :annotations {}}]}
  
  Attach a list of network endpoints to the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:networkEndpointGroup :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints"
     #{:networkEndpointGroup :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/detachNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkEndpoints [{:ipAddress string,
                       :fqdn string,
                       :port integer,
                       :instance string,
                       :annotations {}}]}
  
  Detach the network endpoint from the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:networkEndpointGroup :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints"
     #{:networkEndpointGroup :region :project}
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

(defn listNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionNetworkEndpointGroups/listNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the network endpoints in the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:networkEndpointGroup :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints"
     #{:networkEndpointGroup :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
