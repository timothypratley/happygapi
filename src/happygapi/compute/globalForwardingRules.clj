(ns happygapi.compute.globalForwardingRules
  "Compute Engine API: globalForwardingRules.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/patch
  
  Required parameters: forwardingRule, project
  
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
   :serviceDirectoryRegistrations [{:namespace string,
                                    :serviceDirectoryRegion string,
                                    :service string}],
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
   :subnetwork string,
   :labelFingerprint string}
  
  Updates the specified forwarding rule with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules. Currently, you can only patch the network_tier field."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :forwardingRule})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules/{forwardingRule}"
     #{:project :forwardingRule}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/delete
  
  Required parameters: forwardingRule, project
  
  Optional parameters: requestId
  
  Deletes the specified GlobalForwardingRule resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :forwardingRule})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules/{forwardingRule}"
     #{:project :forwardingRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/get
  
  Required parameters: project, forwardingRule
  
  Optional parameters: none
  
  Returns the specified GlobalForwardingRule resource. Gets a list of available forwarding rules by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :forwardingRule})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules/{forwardingRule}"
     #{:project :forwardingRule}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/list
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, filter, pageToken, maxResults, orderBy
  
  Retrieves a list of GlobalForwardingRule resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/insert
  
  Required parameters: project
  
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
   :serviceDirectoryRegistrations [{:namespace string,
                                    :serviceDirectoryRegion string,
                                    :service string}],
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
   :subnetwork string,
   :labelFingerprint string}
  
  Creates a GlobalForwardingRule resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules"
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

(defn setTarget$
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/setTarget
  
  Required parameters: forwardingRule, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:target string}
  
  Changes target URL for the GlobalForwardingRule resource. The new target should be of the same type as the old target."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :forwardingRule})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules/{forwardingRule}/setTarget"
     #{:project :forwardingRule}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/globalForwardingRules/setLabels
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets the labels on the specified resource. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/forwardingRules/{resource}/setLabels"
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
