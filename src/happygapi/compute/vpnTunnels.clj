(ns happygapi.compute.vpnTunnels
  "Compute Engine API: vpnTunnels.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :peerIp string,
   :peerExternalGateway string,
   :targetVpnGateway string,
   :remoteTrafficSelector [string],
   :creationTimestamp string,
   :router string,
   :name string,
   :selfLink string,
   :ikeVersion integer,
   :detailedStatus string,
   :region string,
   :status string,
   :id string,
   :peerGcpGateway string,
   :kind string,
   :localTrafficSelector [string],
   :sharedSecret string,
   :sharedSecretHash string,
   :vpnGateway string,
   :vpnGatewayInterface integer,
   :peerExternalGatewayInterface integer}
  
  Creates a VpnTunnel resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/vpnTunnels"
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/get
  
  Required parameters: vpnTunnel, project, region
  
  Optional parameters: none
  
  Returns the specified VpnTunnel resource. Gets a list of available VPN tunnels by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :vpnTunnel :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/vpnTunnels/{vpnTunnel}"
     #{:region :vpnTunnel :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/delete
  
  Required parameters: vpnTunnel, project, region
  
  Optional parameters: requestId
  
  Deletes the specified VpnTunnel resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :vpnTunnel :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/vpnTunnels/{vpnTunnel}"
     #{:region :vpnTunnel :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/list
  
  Required parameters: project, region
  
  Optional parameters: maxResults, pageToken, returnPartialSuccess, orderBy, filter
  
  Retrieves a list of VpnTunnel resources contained in the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/vpnTunnels"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/aggregatedList
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, filter, includeAllScopes, pageToken, orderBy, maxResults
  
  Retrieves an aggregated list of VPN tunnels."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/vpnTunnels"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
