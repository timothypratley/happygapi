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
  
  {:rangeReservation {:secondaryRangeIpPrefixLengths [integer],
                      :ipPrefixLength integer,
                      :requestedRanges [string],
                      :subnetworkCandidates [Subnetwork]},
   :validateNetwork boolean,
   :checkServiceNetworkingUsePermission boolean,
   :consumerProject {:projectNum string},
   :consumerNetwork string}
  
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

(defn addSubnetwork$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/addSubnetwork
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:role string,
   :description string,
   :consumer string,
   :consumerNetwork string,
   :purpose string,
   :privateIpv6GoogleAccess string,
   :internalRange string,
   :subnetworkUsers [string],
   :checkServiceNetworkingUsePermission boolean,
   :outsideAllocationPublicIpRange string,
   :useCustomComputeIdempotencyWindow boolean,
   :requestedAddress string,
   :region string,
   :ipPrefixLength integer,
   :allowSubnetCidrRoutesOverlap boolean,
   :computeIdempotencyWindow string,
   :requestedRanges [string],
   :secondaryIpRangeSpecs [{:requestedAddress string,
                            :ipPrefixLength integer,
                            :rangeName string,
                            :outsideAllocationPublicIpRange string}],
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

(defn connections-create$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:peering string,
   :service string,
   :reservedPeeringRanges [string],
   :network string}
  
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

(defn connections-patch$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/connections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, force
  
  Body: 
  
  {:peering string,
   :service string,
   :reservedPeeringRanges [string],
   :network string}
  
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

(defn roles-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/roles/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:policyBinding [{:member string, :role string}],
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

(defn dnsZones-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsZones/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dnsSuffix string, :name string, :consumerNetwork string}
  
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
  
  {:consumerNetwork string, :name string}
  
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

(defn projects-global-networks-getVpcServiceControls$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/getVpcServiceControls
  
  Required parameters: name
  
  Optional parameters: none
  
  Consumers use this method to find out the state of VPC Service Controls. The controls could be enabled or disabled for a connection."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+name}/vpcServiceControls"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-global-networks-get$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/get
  
  Required parameters: name
  
  Optional parameters: includeUsedIpRanges
  
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

(defn projects-global-networks-updateConsumerConfig$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/updateConsumerConfig
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:consumerConfig {:producerExportCustomRoutes boolean,
                    :producerImportSubnetRoutesWithPublicIp boolean,
                    :cloudsqlConfigs [CloudSQLConfig],
                    :producerNetwork string,
                    :consumerExportCustomRoutes boolean,
                    :producerExportSubnetRoutesWithPublicIp boolean,
                    :reservedRanges [GoogleCloudServicenetworkingV1ConsumerConfigReservedRange],
                    :vpcScReferenceArchitectureEnabled boolean,
                    :consumerImportSubnetRoutesWithPublicIp boolean,
                    :usedIpRanges [string],
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

(defn projects-global-networks-dnsZones-list$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/dnsZones/list
  
  Required parameters: parent
  
  Optional parameters: none
  
  * Service producers can use this method to retrieve a list of available DNS zones in the shared producer host project and the matching peering zones in the consumer project. *"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsZones:list"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn projects-global-networks-dnsZones-get$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/dnsZones/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Service producers can use this method to retrieve a DNS zone in the shared producer host project and the matching peering zones in consumer project"
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

(defn projects-global-networks-peeredDnsDomains-create$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/projects/global/networks/peeredDnsDomains/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dnsSuffix string, :name string}
  
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

(defn dnsRecordSets-remove$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/remove
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dnsRecordSet {:data [string],
                  :type string,
                  :domain string,
                  :ttl string},
   :consumerNetwork string,
   :zone string}
  
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

(defn dnsRecordSets-list$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/list
  
  Required parameters: parent
  
  Optional parameters: consumerNetwork, zone
  
  Producers can use this method to retrieve a list of available DNS RecordSets available inside the private zone on the tenant host project accessible from their network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsRecordSets:list"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dnsRecordSets-get$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/get
  
  Required parameters: parent
  
  Optional parameters: zone, domain, type, consumerNetwork
  
  Producers can use this method to retrieve information about the DNS record set added to the private zone inside the shared tenant host project associated with a consumer network."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/service.management"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://servicenetworking.googleapis.com/"
     "v1/{+parent}/dnsRecordSets:get"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn dnsRecordSets-add$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/add
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:dnsRecordSet {:data [string],
                  :type string,
                  :domain string,
                  :ttl string},
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

(defn dnsRecordSets-update$
  "https://cloud.google.com/service-infrastructure/docs/service-networking/getting-startedapi/reference/rest/v1/services/dnsRecordSets/update
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:zone string,
   :consumerNetwork string,
   :newDnsRecordSet {:data [string],
                     :type string,
                     :domain string,
                     :ttl string},
   :existingDnsRecordSet {:data [string],
                          :type string,
                          :domain string,
                          :ttl string}}
  
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
