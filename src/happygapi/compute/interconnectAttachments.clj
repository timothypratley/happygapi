(ns happygapi.compute.interconnectAttachments
  "Compute Engine API: interconnectAttachments.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of interconnect attachments contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of interconnect attachments. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/interconnectAttachments"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/get
  
  Required parameters: interconnectAttachment, project, region
  
  Optional parameters: none
  
  Returns the specified interconnect attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:interconnectAttachment :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
     #{:interconnectAttachment :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId, validateOnly
  
  Body: 
  
  {:candidateSubnets [string],
   :description string,
   :subnetLength integer,
   :labels {},
   :dataplaneVersion integer,
   :ipsecInternalAddresses [string],
   :creationTimestamp string,
   :mtu integer,
   :router string,
   :customerRouterIpAddress string,
   :candidateIpv6Subnets [string],
   :stackType string,
   :cloudRouterIpv6InterfaceId string,
   :name string,
   :interconnect string,
   :selfLink string,
   :type string,
   :vlanTag8021q integer,
   :state string,
   :cloudRouterIpv6Address string,
   :region string,
   :pairingKey string,
   :encryption string,
   :bandwidth string,
   :customerRouterIpv6Address string,
   :satisfiesPzs boolean,
   :id string,
   :kind string,
   :partnerAsn string,
   :adminEnabled boolean,
   :customerRouterIpv6InterfaceId string,
   :operationalStatus string,
   :configurationConstraints {:bgpMd5 string,
                              :bgpPeerAsnRanges [InterconnectAttachmentConfigurationConstraintsBgpPeerASNRange]},
   :partnerMetadata {:partnerName string,
                     :interconnectName string,
                     :portalUrl string},
   :cloudRouterIpAddress string,
   :remoteService string,
   :googleReferenceId string,
   :edgeAvailabilityDomain string,
   :privateInterconnectInfo {:tag8021q integer},
   :labelFingerprint string}
  
  Creates an InterconnectAttachment in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/patch
  
  Required parameters: interconnectAttachment, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:candidateSubnets [string],
   :description string,
   :subnetLength integer,
   :labels {},
   :dataplaneVersion integer,
   :ipsecInternalAddresses [string],
   :creationTimestamp string,
   :mtu integer,
   :router string,
   :customerRouterIpAddress string,
   :candidateIpv6Subnets [string],
   :stackType string,
   :cloudRouterIpv6InterfaceId string,
   :name string,
   :interconnect string,
   :selfLink string,
   :type string,
   :vlanTag8021q integer,
   :state string,
   :cloudRouterIpv6Address string,
   :region string,
   :pairingKey string,
   :encryption string,
   :bandwidth string,
   :customerRouterIpv6Address string,
   :satisfiesPzs boolean,
   :id string,
   :kind string,
   :partnerAsn string,
   :adminEnabled boolean,
   :customerRouterIpv6InterfaceId string,
   :operationalStatus string,
   :configurationConstraints {:bgpMd5 string,
                              :bgpPeerAsnRanges [InterconnectAttachmentConfigurationConstraintsBgpPeerASNRange]},
   :partnerMetadata {:partnerName string,
                     :interconnectName string,
                     :portalUrl string},
   :cloudRouterIpAddress string,
   :remoteService string,
   :googleReferenceId string,
   :edgeAvailabilityDomain string,
   :privateInterconnectInfo {:tag8021q integer},
   :labelFingerprint string}
  
  Updates the specified interconnect attachment with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:interconnectAttachment :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
     #{:interconnectAttachment :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/delete
  
  Required parameters: interconnectAttachment, project, region
  
  Optional parameters: requestId
  
  Deletes the specified interconnect attachment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:interconnectAttachment :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
     #{:interconnectAttachment :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnectAttachments/setLabels
  
  Required parameters: project, region, resource
  
  Optional parameters: requestId
  
  Body: 
  
  {:labels {}, :labelFingerprint string}
  
  Sets the labels on an InterconnectAttachment. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/interconnectAttachments/{resource}/setLabels"
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
