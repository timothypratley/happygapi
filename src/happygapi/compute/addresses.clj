(ns happygapi.compute.addresses
  "Compute Engine API: addresses.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of addresses."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/addresses"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses/delete
  
  Required parameters: address, project, region
  
  Optional parameters: requestId
  
  Deletes the specified address resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:address :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/addresses/{address}"
     #{:address :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses/get
  
  Required parameters: address, project, region
  
  Optional parameters: none
  
  Returns the specified address resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:address :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/addresses/{address}"
     #{:address :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :address string,
   :creationTimestamp string,
   :purpose string,
   :name string,
   :selfLink string,
   :ipVersion string,
   :region string,
   :prefixLength integer,
   :status string,
   :id string,
   :kind string,
   :networkTier string,
   :network string,
   :addressType string,
   :subnetwork string,
   :users [string]}
  
  Creates an address resource in the specified project by using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/addresses"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/addresses/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of addresses contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/addresses"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
