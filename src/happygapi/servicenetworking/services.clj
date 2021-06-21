(ns happygapi.servicenetworking.services
  "Service Networking API: services.
  Provides automatic management of network configurations necessary for certain services.
  See: https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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
   :subnetworkUsers [string],
   :requestedAddress string,
   :region string,
   :ipPrefixLength integer,
   :requestedRanges [string],
   :secondaryIpRangeSpecs [{:rangeName string,
                            :ipPrefixLength integer,
                            :requestedAddress string}],
   :subnetwork string}
  
  For service producers, provisions a new subnet in a peered service's shared VPC network in the requested region and with the requested size that's expressed as a CIDR range (number of leading bits of ipV4 network mask). The method checks against the assigned allocated ranges to find a non-conflicting IP address range. The method will reuse a subnet if subsequent calls contain the same subnet name, region, and prefix length. This method will make producer's tenant project to be a shared VPC service project as needed."
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

(defn validate$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/validate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerNetwork string,
   :consumerProject {:projectNum string},
   :rangeReservation {:secondaryRangeIpPrefixLengths [integer],
                      :subnetworkCandidates [Subnetwork],
                      :ipPrefixLength integer,
                      :requestedRanges [string]},
   :validateNetwork boolean}
  
  Service producers use this method to validate if the consumer provided network, project and requested range are valid. This allows them to use a fail-fast mechanism for consumer requests, and not have to wait for AddSubnetwork operation completion to determine if user request is invalid."
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

(defn searchRange$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/searchRange
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:ipPrefixLength integer, :network string}
  
  Service producers can use this method to find a currently unused range within consumer allocated ranges. This returned range is not reserved, and not guaranteed to remain unused. It will validate previously provided allocated ranges, find non-conflicting sub-range of requested size (expressed in number of leading bits of ipv4 network mask, as in CIDR range notation)."
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

(defn connections-deleteConnection$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/deleteConnection
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:consumerNetwork string}
  
  Deletes a private service access connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
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

(defn connections-patch$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, force
  
  Body: 
  
  {:network string,
   :service string,
   :reservedPeeringRanges [string],
   :peering string}
  
  Updates the allocated ranges that are assigned to a connection."
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

(defn connections-list$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/list
  
  Required parameters: parent
  
  Optional parameters: network
  
  List the private connections that are configured in a service consumer's VPC network."
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

(defn connections-create$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:network string,
   :service string,
   :reservedPeeringRanges [string],
   :peering string}
  
  Creates a private connection that establishes a VPC Network Peering connection to a VPC network in the service producer's organization. The administrator of the service consumer's VPC network invokes this method. The administrator must assign one or more allocated IP ranges for provisioning subnetworks in the service producer's VPC network. This connection is used for all supported services in the service producer's organization, so it only needs to be invoked once."
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

(defn projects-global-networks-updateConsumerConfig$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/updateConsumerConfig
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerConfig {:producerExportCustomRoutes boolean,
                    :producerImportSubnetRoutesWithPublicIp boolean,
                    :producerNetwork string,
                    :consumerExportCustomRoutes boolean,
                    :producerExportSubnetRoutesWithPublicIp boolean,
                    :reservedRanges [GoogleCloudServicenetworkingV1ConsumerConfigReservedRange],
                    :vpcScReferenceArchitectureEnabled boolean,
                    :consumerImportSubnetRoutesWithPublicIp boolean,
                    :consumerImportCustomRoutes boolean,
                    :consumerExportSubnetRoutesWithPublicIp boolean,
                    :producerImportCustomRoutes boolean}}
  
  Service producers use this method to update the configuration of their connection including the import/export of custom routes and subnetwork routes with public IP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}:updateConsumerConfig"
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

(defn projects-global-networks-get$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Service producers use this method to get the configuration of their connection including the import/export of custom routes and subnetwork routes with public IP."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-global-networks-peeredDnsDomains-delete$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/peeredDnsDomains/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a peered DNS domain."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-global-networks-peeredDnsDomains-list$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/peeredDnsDomains/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  Lists peered DNS domains for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/peeredDnsDomains"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-global-networks-peeredDnsDomains-create$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/peeredDnsDomains/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :dnsSuffix string}
  
  Creates a peered DNS domain which sends requests for records in given namespace originating in the service producer VPC network to the consumer VPC network to be resolved."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/peeredDnsDomains"
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

(defn dnsZones-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsZones/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :dnsSuffix string, :consumerNetwork string}
  
  Service producers can use this method to add private DNS zones in the shared producer host project and matching peering zones in the consumer project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsZones:add"
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

(defn dnsZones-remove$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsZones/remove
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :consumerNetwork string}
  
  Service producers can use this method to remove private DNS zones in the shared producer host project and matching peering zones in the consumer project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsZones:remove"
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

(defn dnsRecordSets-update$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/update
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:newDnsRecordSet {:ttl string,
                     :type string,
                     :data [string],
                     :domain string},
   :consumerNetwork string,
   :zone string,
   :existingDnsRecordSet {:ttl string,
                          :type string,
                          :data [string],
                          :domain string}}
  
  Service producers can use this method to update DNS record sets from private DNS zones in the shared producer host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsRecordSets:update"
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

(defn dnsRecordSets-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dnsRecordSet {:ttl string,
                  :type string,
                  :data [string],
                  :domain string},
   :consumerNetwork string,
   :zone string}
  
  Service producers can use this method to add DNS record sets to private DNS zones in the shared producer host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsRecordSets:add"
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

(defn dnsRecordSets-remove$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/remove
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :consumerNetwork string,
   :dnsRecordSet {:ttl string,
                  :type string,
                  :data [string],
                  :domain string}}
  
  Service producers can use this method to remove DNS record sets from private DNS zones in the shared producer host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsRecordSets:remove"
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
  
  {:policyBinding [{:role string, :member string}],
   :consumerNetwork string}
  
  Service producers can use this method to add roles in the shared VPC host project. Each role is bound to the provided member. Each role must be selected from within an allowlisted set of roles. Each role is applied at only the granularity specified in the allowlist."
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
