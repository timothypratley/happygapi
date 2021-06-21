(ns happygapi.compute.publicDelegatedPrefixes
  "Compute Engine API: publicDelegatedPrefixes.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/delete
  
  Required parameters: publicDelegatedPrefix, region, project
  
  Optional parameters: requestId
  
  Deletes the specified PublicDelegatedPrefix in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/patch
  
  Required parameters: region, project, publicDelegatedPrefix
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :isLiveMigration boolean,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :parentPrefix string,
   :publicDelegatedSubPrefixs [{:delegateeProject string,
                                :isAddress boolean,
                                :status string,
                                :description string,
                                :region string,
                                :name string,
                                :ipCidrRange string}],
   :fingerprint string}
  
  Patches the specified PublicDelegatedPrefix resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :region :project}
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/get
  
  Required parameters: region, project, publicDelegatedPrefix
  
  Optional parameters: none
  
  Returns the specified PublicDelegatedPrefix resource in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :isLiveMigration boolean,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :region string,
   :status string,
   :id string,
   :kind string,
   :parentPrefix string,
   :publicDelegatedSubPrefixs [{:delegateeProject string,
                                :isAddress boolean,
                                :status string,
                                :description string,
                                :region string,
                                :name string,
                                :ipCidrRange string}],
   :fingerprint string}
  
  Creates a PublicDelegatedPrefix in the specified project in the given region using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/publicDelegatedPrefixes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/aggregatedList
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, pageToken, maxResults, filter, includeAllScopes, orderBy
  
  Lists all PublicDelegatedPrefix resources owned by the specific project across all scopes."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/publicDelegatedPrefixes"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/publicDelegatedPrefixes/list
  
  Required parameters: project, region
  
  Optional parameters: orderBy, returnPartialSuccess, filter, maxResults, pageToken
  
  Lists the PublicDelegatedPrefixes for a project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/publicDelegatedPrefixes"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
