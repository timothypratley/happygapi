(ns happygapi.compute.globalNetworkEndpointGroups
  "Compute Engine API: globalNetworkEndpointGroups.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/globalNetworkEndpointGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of network endpoint groups that are located in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/get
  
  Required parameters: networkEndpointGroup, project
  
  Optional parameters: none
  
  Returns the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:networkEndpointGroup :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}"
     #{:networkEndpointGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/insert
  
  Required parameters: project
  
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
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups"
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/delete
  
  Required parameters: networkEndpointGroup, project
  
  Optional parameters: requestId
  
  Deletes the specified network endpoint group.Note that the NEG cannot be deleted if there are backend services referencing it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:networkEndpointGroup :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}"
     #{:networkEndpointGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn attachNetworkEndpoints$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/attachNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkEndpoints [{:ipAddress string,
                       :fqdn string,
                       :port integer,
                       :instance string,
                       :annotations {}}]}
  
  Attach a network endpoint to the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/attachNetworkEndpoints"
     #{:networkEndpointGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/detachNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project
  
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
  {:pre [(util/has-keys? parameters #{:networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/detachNetworkEndpoints"
     #{:networkEndpointGroup :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalNetworkEndpointGroups/listNetworkEndpoints
  
  Required parameters: networkEndpointGroup, project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Lists the network endpoints in the specified network endpoint group."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:networkEndpointGroup :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networkEndpointGroups/{networkEndpointGroup}/listNetworkEndpoints"
     #{:networkEndpointGroup :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
