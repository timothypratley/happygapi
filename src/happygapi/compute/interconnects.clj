(ns happygapi.compute.interconnects
  "Compute Engine API: interconnects.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/interconnects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/get
  
  Required parameters: project, interconnect
  
  Optional parameters: none
  
  Returns the specified interconnect. Get a list of available interconnects by making a list() request."
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
  
  Deletes the specified interconnect."
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
  
  Required parameters: project, interconnect
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :provisionedLinkCount integer,
   :peerIpAddress string,
   :creationTimestamp string,
   :name string,
   :customerName string,
   :interconnectAttachments [string],
   :selfLink string,
   :requestedLinkCount integer,
   :state string,
   :interconnectType string,
   :id string,
   :kind string,
   :nocContactEmail string,
   :expectedOutages [{:endTime string,
                      :description string,
                      :state string,
                      :affectedCircuits [string],
                      :issueType string,
                      :source string,
                      :name string,
                      :startTime string}],
   :adminEnabled boolean,
   :googleIpAddress string,
   :operationalStatus string,
   :circuitInfos [{:googleDemarcId string,
                   :customerDemarcId string,
                   :googleCircuitId string}],
   :location string,
   :googleReferenceId string,
   :linkType string}
  
  Updates the specified interconnect with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/list
  
  Required parameters: project
  
  Optional parameters: orderBy, returnPartialSuccess, maxResults, pageToken, filter
  
  Retrieves the list of interconnect available to the specified project."
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :provisionedLinkCount integer,
   :peerIpAddress string,
   :creationTimestamp string,
   :name string,
   :customerName string,
   :interconnectAttachments [string],
   :selfLink string,
   :requestedLinkCount integer,
   :state string,
   :interconnectType string,
   :id string,
   :kind string,
   :nocContactEmail string,
   :expectedOutages [{:endTime string,
                      :description string,
                      :state string,
                      :affectedCircuits [string],
                      :issueType string,
                      :source string,
                      :name string,
                      :startTime string}],
   :adminEnabled boolean,
   :googleIpAddress string,
   :operationalStatus string,
   :circuitInfos [{:googleDemarcId string,
                   :customerDemarcId string,
                   :googleCircuitId string}],
   :location string,
   :googleReferenceId string,
   :linkType string}
  
  Creates a Interconnect in the specified project using the data included in the request."
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

(defn getDiagnostics$
  "https://cloud.google.com/compute/api/reference/rest/v1/interconnects/getDiagnostics
  
  Required parameters: project, interconnect
  
  Optional parameters: none
  
  Returns the interconnectDiagnostics for the specified interconnect."
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
