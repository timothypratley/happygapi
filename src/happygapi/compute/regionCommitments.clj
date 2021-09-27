(ns happygapi.compute.regionCommitments
  "Compute Engine API: regionCommitments.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/list
  
  Required parameters: region, project
  
  Optional parameters: filter, maxResults, pageToken, returnPartialSuccess, orderBy
  
  Retrieves a list of commitments contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/commitments"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :category string,
   :creationTimestamp string,
   :name string,
   :statusMessage string,
   :endTimestamp string,
   :selfLink string,
   :type string,
   :licenseResource {:amount string,
                     :license string,
                     :coresPerLicense string},
   :region string,
   :status string,
   :id string,
   :kind string,
   :startTimestamp string,
   :resources [{:acceleratorType string, :amount string, :type string}],
   :reservations [{:description string,
                   :creationTimestamp string,
                   :zone string,
                   :name string,
                   :specificReservationRequired boolean,
                   :commitment string,
                   :selfLink string,
                   :satisfiesPzs boolean,
                   :specificReservation AllocationSpecificSKUReservation,
                   :status string,
                   :id string,
                   :kind string}],
   :plan string}
  
  Creates a commitment in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/commitments"
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/aggregatedList
  
  Required parameters: project
  
  Optional parameters: maxResults, orderBy, pageToken, filter, includeAllScopes, returnPartialSuccess
  
  Retrieves an aggregated list of commitments by region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/commitments"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/get
  
  Required parameters: project, region, commitment
  
  Optional parameters: none
  
  Returns the specified commitment resource. Gets a list of available commitments by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:commitment :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/commitments/{commitment}"
     #{:commitment :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
