(ns happygapi.compute.vpnTunnels
  "Compute Engine API: vpnTunnels.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
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
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of VPN tunnels. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/get
  
  Required parameters: project, region, vpnTunnel
  
  Optional parameters: none
  
  Returns the specified VpnTunnel resource."
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :peerIp string,
   :labels {},
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
   :peerExternalGatewayInterface integer,
   :labelFingerprint string}
  
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/delete
  
  Required parameters: project, region, vpnTunnel
  
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

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/vpnTunnels/setLabels
  
  Required parameters: project, region, resource
  
  Optional parameters: requestId
  
  Body: 
  
  {:labels {}, :labelFingerprint string}
  
  Sets the labels on a VpnTunnel. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/vpnTunnels/{resource}/setLabels"
     #{:region :project :resource}
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
