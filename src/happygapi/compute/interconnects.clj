(ns happygapi.compute.interconnects
  "Compute Engine API: interconnects.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/interconnects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :macsecEnabled boolean,
   :provisionedLinkCount integer,
   :peerIpAddress string,
   :creationTimestamp string,
   :name string,
   :remoteLocation string,
   :customerName string,
   :interconnectAttachments [string],
   :selfLink string,
   :availableFeatures [string],
   :requestedLinkCount integer,
   :state string,
   :interconnectType string,
   :requestedFeatures [string],
   :satisfiesPzs boolean,
   :id string,
   :kind string,
   :nocContactEmail string,
   :expectedOutages [{:name string,
                      :description string,
                      :source string,
                      :state string,
                      :issueType string,
                      :affectedCircuits [string],
                      :startTime string,
                      :endTime string}],
   :adminEnabled boolean,
   :googleIpAddress string,
   :operationalStatus string,
   :circuitInfos [{:googleCircuitId string,
                   :googleDemarcId string,
                   :customerDemarcId string}],
   :location string,
   :googleReferenceId string,
   :macsec {:preSharedKeys [InterconnectMacsecPreSharedKey],
            :failOpen boolean},
   :linkType string,
   :labelFingerprint string}
  
  Creates an Interconnect in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects"
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of Interconnects available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getDiagnostics$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/getDiagnostics
  
  Required parameters: interconnect, project
  
  Optional parameters: none
  
  Returns the interconnectDiagnostics for the specified Interconnect. In the event of a global outage, do not use this API to make decisions about where to redirect your network traffic. Unlike a VLAN attachment, which is regional, a Cloud Interconnect connection is a global resource. A global outage can prevent this API from functioning properly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:interconnect :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{interconnect}/getDiagnostics"
     #{:interconnect :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getMacsecConfig$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/getMacsecConfig
  
  Required parameters: interconnect, project
  
  Optional parameters: none
  
  Returns the interconnectMacsecConfig for the specified Interconnect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:interconnect :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{interconnect}/getMacsecConfig"
     #{:interconnect :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/get
  
  Required parameters: interconnect, project
  
  Optional parameters: none
  
  Returns the specified Interconnect. Get a list of available Interconnects by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:interconnect :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{interconnect}"
     #{:interconnect :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/delete
  
  Required parameters: interconnect, project
  
  Optional parameters: requestId
  
  Deletes the specified Interconnect."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:interconnect :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{interconnect}"
     #{:interconnect :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/patch
  
  Required parameters: interconnect, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :macsecEnabled boolean,
   :provisionedLinkCount integer,
   :peerIpAddress string,
   :creationTimestamp string,
   :name string,
   :remoteLocation string,
   :customerName string,
   :interconnectAttachments [string],
   :selfLink string,
   :availableFeatures [string],
   :requestedLinkCount integer,
   :state string,
   :interconnectType string,
   :requestedFeatures [string],
   :satisfiesPzs boolean,
   :id string,
   :kind string,
   :nocContactEmail string,
   :expectedOutages [{:name string,
                      :description string,
                      :source string,
                      :state string,
                      :issueType string,
                      :affectedCircuits [string],
                      :startTime string,
                      :endTime string}],
   :adminEnabled boolean,
   :googleIpAddress string,
   :operationalStatus string,
   :circuitInfos [{:googleCircuitId string,
                   :googleDemarcId string,
                   :customerDemarcId string}],
   :location string,
   :googleReferenceId string,
   :macsec {:preSharedKeys [InterconnectMacsecPreSharedKey],
            :failOpen boolean},
   :linkType string,
   :labelFingerprint string}
  
  Updates the specified Interconnect with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:interconnect :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{interconnect}"
     #{:interconnect :project}
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

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/setLabels
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:labels {}, :labelFingerprint string}
  
  Sets the labels on an Interconnect. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/interconnects/{resource}/setLabels"
     #{:project :resource}
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
