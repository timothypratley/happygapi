(ns happygapi.compute.routers
  "Compute Engine API: routers.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/get
  
  Required parameters: project, region, router
  
  Optional parameters: none
  
  Returns the specified Router resource. Gets a list of available routers by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}"
     #{:router :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :interfaces [{:ipRange string,
                 :linkedInterconnectAttachment string,
                 :linkedVpnTunnel string,
                 :managementType string,
                 :name string}],
   :creationTimestamp string,
   :nats [{:minPortsPerVm integer,
           :name string,
           :sourceSubnetworkIpRangesToNat string,
           :tcpTransitoryIdleTimeoutSec integer,
           :natIpAllocateOption string,
           :udpIdleTimeoutSec integer,
           :subnetworks [RouterNatSubnetworkToNat],
           :natIps [string],
           :icmpIdleTimeoutSec integer,
           :tcpEstablishedIdleTimeoutSec integer,
           :drainNatIps [string],
           :logConfig RouterNatLogConfig}],
   :name string,
   :bgpPeers [{:peerIpAddress string,
               :name string,
               :advertisedIpRanges [RouterAdvertisedIpRange],
               :advertisedGroups [string],
               :managementType string,
               :advertiseMode string,
               :peerAsn integer,
               :interfaceName string,
               :ipAddress string,
               :advertisedRoutePriority integer}],
   :selfLink string,
   :bgp {:advertiseMode string,
         :advertisedGroups [string],
         :advertisedIpRanges [RouterAdvertisedIpRange],
         :asn integer},
   :region string,
   :id string,
   :kind string,
   :network string}
  
  Creates a Router resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers"
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

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/patch
  
  Required parameters: project, region, router
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :interfaces [{:ipRange string,
                 :linkedInterconnectAttachment string,
                 :linkedVpnTunnel string,
                 :managementType string,
                 :name string}],
   :creationTimestamp string,
   :nats [{:minPortsPerVm integer,
           :name string,
           :sourceSubnetworkIpRangesToNat string,
           :tcpTransitoryIdleTimeoutSec integer,
           :natIpAllocateOption string,
           :udpIdleTimeoutSec integer,
           :subnetworks [RouterNatSubnetworkToNat],
           :natIps [string],
           :icmpIdleTimeoutSec integer,
           :tcpEstablishedIdleTimeoutSec integer,
           :drainNatIps [string],
           :logConfig RouterNatLogConfig}],
   :name string,
   :bgpPeers [{:peerIpAddress string,
               :name string,
               :advertisedIpRanges [RouterAdvertisedIpRange],
               :advertisedGroups [string],
               :managementType string,
               :advertiseMode string,
               :peerAsn integer,
               :interfaceName string,
               :ipAddress string,
               :advertisedRoutePriority integer}],
   :selfLink string,
   :bgp {:advertiseMode string,
         :advertisedGroups [string],
         :advertisedIpRanges [RouterAdvertisedIpRange],
         :asn integer},
   :region string,
   :id string,
   :kind string,
   :network string}
  
  Patches the specified Router resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}"
     #{:router :region :project}
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

(defn getRouterStatus$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/getRouterStatus
  
  Required parameters: project, region, router
  
  Optional parameters: none
  
  Retrieves runtime information of the specified router."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}/getRouterStatus"
     #{:router :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of routers."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/routers"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/update
  
  Required parameters: project, region, router
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :interfaces [{:ipRange string,
                 :linkedInterconnectAttachment string,
                 :linkedVpnTunnel string,
                 :managementType string,
                 :name string}],
   :creationTimestamp string,
   :nats [{:minPortsPerVm integer,
           :name string,
           :sourceSubnetworkIpRangesToNat string,
           :tcpTransitoryIdleTimeoutSec integer,
           :natIpAllocateOption string,
           :udpIdleTimeoutSec integer,
           :subnetworks [RouterNatSubnetworkToNat],
           :natIps [string],
           :icmpIdleTimeoutSec integer,
           :tcpEstablishedIdleTimeoutSec integer,
           :drainNatIps [string],
           :logConfig RouterNatLogConfig}],
   :name string,
   :bgpPeers [{:peerIpAddress string,
               :name string,
               :advertisedIpRanges [RouterAdvertisedIpRange],
               :advertisedGroups [string],
               :managementType string,
               :advertiseMode string,
               :peerAsn integer,
               :interfaceName string,
               :ipAddress string,
               :advertisedRoutePriority integer}],
   :selfLink string,
   :bgp {:advertiseMode string,
         :advertisedGroups [string],
         :advertisedIpRanges [RouterAdvertisedIpRange],
         :asn integer},
   :region string,
   :id string,
   :kind string,
   :network string}
  
  Updates the specified Router resource with the data included in the request. This method conforms to PUT semantics, which requests that the state of the target resource be created or replaced with the state defined by the representation enclosed in the request message payload."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}"
     #{:router :region :project}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/delete
  
  Required parameters: project, region, router
  
  Optional parameters: requestId
  
  Deletes the specified Router resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}"
     #{:router :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn preview$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/preview
  
  Required parameters: project, region, router
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :interfaces [{:ipRange string,
                 :linkedInterconnectAttachment string,
                 :linkedVpnTunnel string,
                 :managementType string,
                 :name string}],
   :creationTimestamp string,
   :nats [{:minPortsPerVm integer,
           :name string,
           :sourceSubnetworkIpRangesToNat string,
           :tcpTransitoryIdleTimeoutSec integer,
           :natIpAllocateOption string,
           :udpIdleTimeoutSec integer,
           :subnetworks [RouterNatSubnetworkToNat],
           :natIps [string],
           :icmpIdleTimeoutSec integer,
           :tcpEstablishedIdleTimeoutSec integer,
           :drainNatIps [string],
           :logConfig RouterNatLogConfig}],
   :name string,
   :bgpPeers [{:peerIpAddress string,
               :name string,
               :advertisedIpRanges [RouterAdvertisedIpRange],
               :advertisedGroups [string],
               :managementType string,
               :advertiseMode string,
               :peerAsn integer,
               :interfaceName string,
               :ipAddress string,
               :advertisedRoutePriority integer}],
   :selfLink string,
   :bgp {:advertiseMode string,
         :advertisedGroups [string],
         :advertisedIpRanges [RouterAdvertisedIpRange],
         :asn integer},
   :region string,
   :id string,
   :kind string,
   :network string}
  
  Preview fields auto-generated during router create and update operations. Calling this method does NOT create or update the router."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}/preview"
     #{:router :region :project}
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

(defn getNatMappingInfo$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/getNatMappingInfo
  
  Required parameters: project, region, router
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves runtime Nat mapping information of VM endpoints."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:router :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers/{router}/getNatMappingInfo"
     #{:router :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/routers/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of Router resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/routers"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
