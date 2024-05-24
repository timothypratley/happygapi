(ns happygapi.compute.regionCommitments
  "Compute Engine API: regionCommitments.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionCommitments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of commitments by region. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
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
  
  Required parameters: commitment, project, region
  
  Optional parameters: none
  
  Returns the specified commitment resource."
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:existingReservations [string],
   :description string,
   :category string,
   :creationTimestamp string,
   :name string,
   :mergeSourceCommitments [string],
   :statusMessage string,
   :endTimestamp string,
   :selfLink string,
   :type string,
   :licenseResource {:license string,
                     :amount string,
                     :coresPerLicense string},
   :splitSourceCommitment string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :startTimestamp string,
   :resources [{:type string, :amount string, :acceleratorType string}],
   :reservations [{:description string,
                   :resourcePolicies {},
                   :creationTimestamp string,
                   :resourceStatus AllocationResourceStatus,
                   :zone string,
                   :name string,
                   :shareSettings ShareSettings,
                   :specificReservationRequired boolean,
                   :commitment string,
                   :selfLink string,
                   :satisfiesPzs boolean,
                   :specificReservation AllocationSpecificSKUReservation,
                   :status string,
                   :id string,
                   :kind string,
                   :aggregateReservation AllocationAggregateReservation}],
   :plan string,
   :autoRenew boolean}
  
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

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionCommitments/update
  
  Required parameters: commitment, project, region
  
  Optional parameters: paths, requestId, updateMask
  
  Body: 
  
  {:existingReservations [string],
   :description string,
   :category string,
   :creationTimestamp string,
   :name string,
   :mergeSourceCommitments [string],
   :statusMessage string,
   :endTimestamp string,
   :selfLink string,
   :type string,
   :licenseResource {:license string,
                     :amount string,
                     :coresPerLicense string},
   :splitSourceCommitment string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :startTimestamp string,
   :resources [{:type string, :amount string, :acceleratorType string}],
   :reservations [{:description string,
                   :resourcePolicies {},
                   :creationTimestamp string,
                   :resourceStatus AllocationResourceStatus,
                   :zone string,
                   :name string,
                   :shareSettings ShareSettings,
                   :specificReservationRequired boolean,
                   :commitment string,
                   :selfLink string,
                   :satisfiesPzs boolean,
                   :specificReservation AllocationSpecificSKUReservation,
                   :status string,
                   :id string,
                   :kind string,
                   :aggregateReservation AllocationAggregateReservation}],
   :plan string,
   :autoRenew boolean}
  
  Updates the specified commitment with the data included in the request. Update is performed only on selected fields included as part of update-mask. Only the following fields can be modified: auto_renew."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:commitment :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/commitments/{commitment}"
     #{:commitment :region :project}
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
