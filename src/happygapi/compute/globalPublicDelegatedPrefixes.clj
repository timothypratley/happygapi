(ns happygapi.compute.globalPublicDelegatedPrefixes
  "Compute Engine API: globalPublicDelegatedPrefixes.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes/get
  
  Required parameters: publicDelegatedPrefix, project
  
  Optional parameters: none
  
  Returns the specified global PublicDelegatedPrefix resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes/list
  
  Required parameters: project
  
  Optional parameters: orderBy, filter, pageToken, maxResults, returnPartialSuccess
  
  Lists the global PublicDelegatedPrefixes for a project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes/insert
  
  Required parameters: project
  
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
   :publicDelegatedSubPrefixs [{:name string,
                                :delegateeProject string,
                                :isAddress boolean,
                                :region string,
                                :ipCidrRange string,
                                :description string,
                                :status string}],
   :fingerprint string}
  
  Creates a global PublicDelegatedPrefix in the specified project using the parameters that are included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes"
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes/patch
  
  Required parameters: publicDelegatedPrefix, project
  
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
   :publicDelegatedSubPrefixs [{:name string,
                                :delegateeProject string,
                                :isAddress boolean,
                                :region string,
                                :ipCidrRange string,
                                :description string,
                                :status string}],
   :fingerprint string}
  
  Patches the specified global PublicDelegatedPrefix resource with the data included in the request. This method supports PATCH semantics and uses JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalPublicDelegatedPrefixes/delete
  
  Required parameters: publicDelegatedPrefix, project
  
  Optional parameters: requestId
  
  Deletes the specified global PublicDelegatedPrefix."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:publicDelegatedPrefix :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/publicDelegatedPrefixes/{publicDelegatedPrefix}"
     #{:publicDelegatedPrefix :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
