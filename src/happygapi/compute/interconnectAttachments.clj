(ns happygapi.compute.interconnectAttachments
  "Compute Engine API: interconnectAttachments.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves an aggregated list of interconnect attachments."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/interconnectAttachments"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/delete
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
     #{:interconnectAttachment :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/get
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId, validateOnly
  
  Body: 
  
  {:candidateSubnets [string],
   :description string,
   :creationTimestamp string,
   :router string,
   :customerRouterIpAddress string,
   :name string,
   :interconnect string,
   :selfLink string,
   :type string,
   :vlanTag8021q integer,
   :state string,
   :region string,
   :pairingKey string,
   :bandwidth string,
   :id string,
   :kind string,
   :partnerAsn string,
   :adminEnabled boolean,
   :operationalStatus string,
   :partnerMetadata {:interconnectName string,
                     :partnerName string,
                     :portalUrl string},
   :cloudRouterIpAddress string,
   :googleReferenceId string,
   :edgeAvailabilityDomain string,
   :privateInterconnectInfo {:tag8021q integer}}
  
  Creates an InterconnectAttachment in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/interconnectAttachments"
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

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/list
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/interconnectAttachments"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/interconnectAttachments/patch
  
  Required parameters: interconnectAttachment, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:candidateSubnets [string],
   :description string,
   :creationTimestamp string,
   :router string,
   :customerRouterIpAddress string,
   :name string,
   :interconnect string,
   :selfLink string,
   :type string,
   :vlanTag8021q integer,
   :state string,
   :region string,
   :pairingKey string,
   :bandwidth string,
   :id string,
   :kind string,
   :partnerAsn string,
   :adminEnabled boolean,
   :operationalStatus string,
   :partnerMetadata {:interconnectName string,
                     :partnerName string,
                     :portalUrl string},
   :cloudRouterIpAddress string,
   :googleReferenceId string,
   :edgeAvailabilityDomain string,
   :privateInterconnectInfo {:tag8021q integer}}
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/interconnectAttachments/{interconnectAttachment}"
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
