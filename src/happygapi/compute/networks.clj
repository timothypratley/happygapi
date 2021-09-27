(ns happygapi.compute.networks
  "Compute Engine API: networks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/networks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/get
  
  Required parameters: network, project
  
  Optional parameters: none
  
  Returns the specified network. Gets a list of available networks by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}"
     #{:project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :peerings [{:exportCustomRoutes boolean,
               :peerMtu integer,
               :importSubnetRoutesWithPublicIp boolean,
               :name string,
               :exchangeSubnetRoutes boolean,
               :state string,
               :stateDetails string,
               :autoCreateRoutes boolean,
               :network string,
               :exportSubnetRoutesWithPublicIp boolean,
               :importCustomRoutes boolean}],
   :creationTimestamp string,
   :mtu integer,
   :name string,
   :gatewayIPv4 string,
   :routingConfig {:routingMode string},
   :selfLink string,
   :autoCreateSubnetworks boolean,
   :id string,
   :subnetworks [string],
   :kind string,
   :IPv4Range string}
  
  Creates a network in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks"
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

(defn getEffectiveFirewalls$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/getEffectiveFirewalls
  
  Required parameters: project, network
  
  Optional parameters: none
  
  Returns the effective firewalls on a given network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/getEffectiveFirewalls"
     #{:project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/patch
  
  Required parameters: network, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :peerings [{:exportCustomRoutes boolean,
               :peerMtu integer,
               :importSubnetRoutesWithPublicIp boolean,
               :name string,
               :exchangeSubnetRoutes boolean,
               :state string,
               :stateDetails string,
               :autoCreateRoutes boolean,
               :network string,
               :exportSubnetRoutesWithPublicIp boolean,
               :importCustomRoutes boolean}],
   :creationTimestamp string,
   :mtu integer,
   :name string,
   :gatewayIPv4 string,
   :routingConfig {:routingMode string},
   :selfLink string,
   :autoCreateSubnetworks boolean,
   :id string,
   :subnetworks [string],
   :kind string,
   :IPv4Range string}
  
  Patches the specified network with the data included in the request. Only the following fields can be modified: routingConfig.routingMode."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}"
     #{:project :network}
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

(defn listPeeringRoutes$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/listPeeringRoutes
  
  Required parameters: project, network
  
  Optional parameters: returnPartialSuccess, pageToken, region, filter, peeringName, direction, maxResults, orderBy
  
  Lists the peering routes exchanged over peering connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/listPeeringRoutes"
     #{:project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removePeering$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/removePeering
  
  Required parameters: project, network
  
  Optional parameters: requestId
  
  Body: 
  
  {:name string}
  
  Removes a peering from the specified network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/removePeering"
     #{:project :network}
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

(defn addPeering$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/addPeering
  
  Required parameters: project, network
  
  Optional parameters: requestId
  
  Body: 
  
  {:name string,
   :autoCreateRoutes boolean,
   :networkPeering {:exportCustomRoutes boolean,
                    :peerMtu integer,
                    :importSubnetRoutesWithPublicIp boolean,
                    :name string,
                    :exchangeSubnetRoutes boolean,
                    :state string,
                    :stateDetails string,
                    :autoCreateRoutes boolean,
                    :network string,
                    :exportSubnetRoutesWithPublicIp boolean,
                    :importCustomRoutes boolean},
   :peerNetwork string}
  
  Adds a peering to the specified network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/addPeering"
     #{:project :network}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/delete
  
  Required parameters: network, project
  
  Optional parameters: requestId
  
  Deletes the specified network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}"
     #{:project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/list
  
  Required parameters: project
  
  Optional parameters: pageToken, orderBy, returnPartialSuccess, maxResults, filter
  
  Retrieves the list of networks available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn switchToCustomMode$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/switchToCustomMode
  
  Required parameters: project, network
  
  Optional parameters: requestId
  
  Switches the network mode from auto subnet mode to custom subnet mode."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/switchToCustomMode"
     #{:project :network}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updatePeering$
  "https://cloud.google.com/compute/api/reference/rest/v1/networks/updatePeering
  
  Required parameters: project, network
  
  Optional parameters: requestId
  
  Body: 
  
  {:networkPeering {:exportCustomRoutes boolean,
                    :peerMtu integer,
                    :importSubnetRoutesWithPublicIp boolean,
                    :name string,
                    :exchangeSubnetRoutes boolean,
                    :state string,
                    :stateDetails string,
                    :autoCreateRoutes boolean,
                    :network string,
                    :exportSubnetRoutesWithPublicIp boolean,
                    :importCustomRoutes boolean}}
  
  Updates the specified network peering with the data included in the request. You can only modify the NetworkPeering.export_custom_routes field and the NetworkPeering.import_custom_routes field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :network})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/networks/{network}/updatePeering"
     #{:project :network}
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
