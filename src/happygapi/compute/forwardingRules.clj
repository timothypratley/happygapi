(ns happygapi.compute.forwardingRules
  "Compute Engine API: forwardingRules.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/patch
  
  Required parameters: region, forwardingRule, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :creationTimestamp string,
   :name string,
   :IPProtocol string,
   :pscConnectionId string,
   :allowGlobalAccess boolean,
   :backendService string,
   :selfLink string,
   :loadBalancingScheme string,
   :ipVersion string,
   :region string,
   :serviceLabel string,
   :ports [string],
   :serviceDirectoryRegistrations [{:service string,
                                    :namespace string,
                                    :serviceDirectoryRegion string}],
   :id string,
   :kind string,
   :metadataFilters [{:filterMatchCriteria string,
                      :filterLabels [MetadataFilterLabelMatch]}],
   :networkTier string,
   :isMirroringCollector boolean,
   :allPorts boolean,
   :pscConnectionStatus string,
   :portRange string,
   :network string,
   :target string,
   :serviceName string,
   :IPAddress string,
   :fingerprint string,
   :subnetwork string,
   :labelFingerprint string}
  
  Updates the specified forwarding rule with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently, you can only patch the network_tier field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :forwardingRule})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :creationTimestamp string,
   :name string,
   :IPProtocol string,
   :pscConnectionId string,
   :allowGlobalAccess boolean,
   :backendService string,
   :selfLink string,
   :loadBalancingScheme string,
   :ipVersion string,
   :region string,
   :serviceLabel string,
   :ports [string],
   :serviceDirectoryRegistrations [{:service string,
                                    :namespace string,
                                    :serviceDirectoryRegion string}],
   :id string,
   :kind string,
   :metadataFilters [{:filterMatchCriteria string,
                      :filterLabels [MetadataFilterLabelMatch]}],
   :networkTier string,
   :isMirroringCollector boolean,
   :allPorts boolean,
   :pscConnectionStatus string,
   :portRange string,
   :network string,
   :target string,
   :serviceName string,
   :IPAddress string,
   :fingerprint string,
   :subnetwork string,
   :labelFingerprint string}
  
  Creates a ForwardingRule resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/aggregatedList
  
  Required parameters: project
  
  Optional parameters: orderBy, maxResults, filter, pageToken, returnPartialSuccess, includeAllScopes
  
  Retrieves an aggregated list of forwarding rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/forwardingRules"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/delete
  
  Required parameters: region, forwardingRule, project
  
  Optional parameters: requestId
  
  Deletes the specified ForwardingRule resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :forwardingRule})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/get
  
  Required parameters: project, region, forwardingRule
  
  Optional parameters: none
  
  Returns the specified ForwardingRule resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :forwardingRule})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setTarget$
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/setTarget
  
  Required parameters: region, forwardingRule, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:target string}
  
  Changes target URL for forwarding rule. The new target should be of the same type as the old target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:region :project :forwardingRule})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules/{forwardingRule}/setTarget"
     #{:region :project :forwardingRule}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/list
  
  Required parameters: project, region
  
  Optional parameters: returnPartialSuccess, orderBy, pageToken, filter, maxResults
  
  Retrieves a list of ForwardingRule resources available to the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/forwardingRules/setLabels
  
  Required parameters: region, resource, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets the labels on the specified resource. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/forwardingRules/{resource}/setLabels"
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
