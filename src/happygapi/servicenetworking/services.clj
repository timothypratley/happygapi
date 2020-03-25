(ns happygapi.servicenetworking.services
  "Service Networking API: services.
  Provides automatic management of network configurations necessary for certain services.
  See: https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn validate$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/validate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerNetwork string,
   :rangeReservation {:secondaryRangeIpPrefixLengths [integer],
                      :ipPrefixLength integer},
   :validateNetwork boolean,
   :consumerProject {:projectNum string}}
  
  Service producers use this method to validate if the consumer provided
  network, project and the requested range is valid. This allows them to use
  a fail-fast mechanism for consumer requests, and not have to wait for
  AddSubnetwork operation completion to determine if user request is invalid."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:validate"
     #{:parent}
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

(defn disableVpcServiceControls$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/disableVpcServiceControls
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerNetwork string}
  
  Disables VPC service controls for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:disableVpcServiceControls"
     #{:parent}
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

(defn addSubnetwork$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/addSubnetwork
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:description string,
   :consumer string,
   :consumerNetwork string,
   :privateIpv6GoogleAccess string,
   :subnetworkUsers [string],
   :requestedAddress string,
   :region string,
   :ipPrefixLength integer,
   :subnetwork string}
  
  For service producers, provisions a new subnet in a
  peered service's shared VPC network in the requested region and with the
  requested size that's expressed as a CIDR range (number of leading bits of
  ipV4 network mask). The method checks against the assigned allocated ranges
  to find a non-conflicting IP address range. The method will reuse a subnet
  if subsequent calls contain the same subnet name, region, and prefix
  length. This method will make producer's tenant project to be a shared VPC
  service project as needed. The response from the `get` operation will be of
  type `Subnetwork` if the operation successfully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:addSubnetwork"
     #{:parent}
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

(defn searchRange$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/searchRange
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:ipPrefixLength integer, :network string}
  
  Service producers can use this method to find a currently unused range
  within consumer allocated ranges.   This returned range is not reserved,
  and not guaranteed to remain unused.
  It will validate previously provided allocated ranges, find
  non-conflicting sub-range of requested size (expressed in
  number of leading bits of ipv4 network mask, as in CIDR range
  notation).
  Operation<response: Range>"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:searchRange"
     #{:parent}
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

(defn enableVpcServiceControls$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/enableVpcServiceControls
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerNetwork string}
  
  Enables VPC service controls for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:enableVpcServiceControls"
     #{:parent}
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

(defn roles-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/roles/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:policyBinding [{:member string, :role string}],
   :consumerNetwork string}
  
  Service producers can use this method to add roles in the shared VPC host
  project. Each role is bound to the provided member. Each role must be
  selected from within a whitelisted set of roles. Each role is applied at
  only the granularity specified in the whitelist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/roles:add"
     #{:parent}
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

(defn connections-list$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/list
  
  Required parameters: parent
  
  Optional parameters: network
  
  List the private connections that are configured in a service consumer's
  VPC network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/connections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn connections-patch$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, force
  
  Body: 
  
  {:reservedPeeringRanges [string],
   :service string,
   :network string,
   :peering string}
  
  Updates the allocated ranges that are assigned to a connection.
  The response from the `get` operation will be of type `Connection` if the
  operation successfully completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn connections-create$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:reservedPeeringRanges [string],
   :service string,
   :network string,
   :peering string}
  
  Creates a private connection that establishes a VPC Network Peering
  connection to a VPC network in the service producer's organization.
  The administrator of the service consumer's VPC network invokes this
  method. The administrator must assign one or more allocated IP ranges for
  provisioning subnetworks in the service producer's VPC network. This
  connection is used for all supported services in the service producer's
  organization, so it only needs to be invoked once. The response from the
  `get` operation will be of type `Connection` if the operation successfully
  completes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/connections"
     #{:parent}
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
