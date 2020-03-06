(ns happygapi.compute.forwardingRules
  "Compute Engine API: forwardingRules.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves an aggregated list of forwarding rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/forwardingRules"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/delete
  
  Required parameters: forwardingRule, project, region
  
  Optional parameters: requestId
  Deletes the specified ForwardingRule resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project :forwardingRule})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/get
  
  Required parameters: forwardingRule, project, region
  
  Optional parameters: none
  Returns the specified ForwardingRule resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project :forwardingRule})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :IPProtocol string,
   :allowGlobalAccess boolean,
   :backendService string,
   :selfLink string,
   :loadBalancingScheme string,
   :ipVersion string,
   :region string,
   :serviceLabel string,
   :ports [string],
   :id string,
   :kind string,
   :metadataFilters [{:filterLabels [MetadataFilterLabelMatch],
                      :filterMatchCriteria string}],
   :networkTier string,
   :isMirroringCollector boolean,
   :allPorts boolean,
   :portRange string,
   :network string,
   :target string,
   :serviceName string,
   :IPAddress string,
   :fingerprint string,
   :subnetwork string}
  
  Creates a ForwardingRule resource in the specified project and region using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules"
     #{:region :project}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves a list of ForwardingRule resources available to the specified project and region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules"
     #{:region :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/patch
  
  Required parameters: forwardingRule, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :name string,
   :IPProtocol string,
   :allowGlobalAccess boolean,
   :backendService string,
   :selfLink string,
   :loadBalancingScheme string,
   :ipVersion string,
   :region string,
   :serviceLabel string,
   :ports [string],
   :id string,
   :kind string,
   :metadataFilters [{:filterLabels [MetadataFilterLabelMatch],
                      :filterMatchCriteria string}],
   :networkTier string,
   :isMirroringCollector boolean,
   :allPorts boolean,
   :portRange string,
   :network string,
   :target string,
   :serviceName string,
   :IPAddress string,
   :fingerprint string,
   :subnetwork string}
  
  Updates the specified forwarding rule with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently, you can only patch the network_tier field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :forwardingRule})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules/{forwardingRule}"
     #{:region :project :forwardingRule}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setTarget$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/forwardingRules/setTarget
  
  Required parameters: forwardingRule, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:target string}
  
  Changes target URL for forwarding rule. The new target should be of the same type as the old target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project :forwardingRule})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/forwardingRules/{forwardingRule}/setTarget"
     #{:region :project :forwardingRule}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
