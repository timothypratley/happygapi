(ns happygapi.compute.subnetworks
  "Compute Engine API: subnetworks.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/get
  
  Required parameters: project, region, subnetwork
  
  Optional parameters: none
  
  Returns the specified subnetwork. Gets a list of available subnetworks list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :subnetwork})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{subnetwork}"
     #{:region :project :subnetwork}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/setIamPolicy
  
  Required parameters: project, region, resource
  
  Optional parameters: none
  
  Body: 
  
  {:bindings [{:condition Expr, :members [string], :role string}],
   :etag string,
   :policy {:auditConfigs [AuditConfig],
            :bindings [Binding],
            :etag string,
            :iamOwned boolean,
            :rules [Rule],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{resource}/setIamPolicy"
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

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:role string,
   :description string,
   :privateIpGoogleAccess boolean,
   :creationTimestamp string,
   :purpose string,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :state string,
   :region string,
   :gatewayAddress string,
   :id string,
   :kind string,
   :enableFlowLogs boolean,
   :network string,
   :secondaryIpRanges [{:ipCidrRange string, :rangeName string}],
   :logConfig {:aggregationInterval string,
               :enable boolean,
               :filterExpr string,
               :flowSampling number,
               :metadata string,
               :metadataFields [string]},
   :fingerprint string}
  
  Creates a subnetwork in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks"
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

(defn listUsable$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/listUsable
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of all usable subnetworks in the project. The list contains all of the subnetworks in the project and the subnetworks that were shared by a Shared VPC host project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/subnetworks/listUsable"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/patch
  
  Required parameters: project, region, subnetwork
  
  Optional parameters: drainTimeoutSeconds, requestId
  
  Body: 
  
  {:role string,
   :description string,
   :privateIpGoogleAccess boolean,
   :creationTimestamp string,
   :purpose string,
   :name string,
   :ipCidrRange string,
   :selfLink string,
   :state string,
   :region string,
   :gatewayAddress string,
   :id string,
   :kind string,
   :enableFlowLogs boolean,
   :network string,
   :secondaryIpRanges [{:ipCidrRange string, :rangeName string}],
   :logConfig {:aggregationInterval string,
               :enable boolean,
               :filterExpr string,
               :flowSampling number,
               :metadata string,
               :metadataFields [string]},
   :fingerprint string}
  
  Patches the specified subnetwork with the data included in the request. Only certain fields can up updated with a patch request as indicated in the field descriptions. You must specify the current fingeprint of the subnetwork resource being patched."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :subnetwork})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{subnetwork}"
     #{:region :project :subnetwork}
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

(defn testIamPermissions$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/testIamPermissions
  
  Required parameters: project, region, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{resource}/testIamPermissions"
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

(defn aggregatedList$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken
  
  Retrieves an aggregated list of subnetworks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/aggregated/subnetworks"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/delete
  
  Required parameters: project, region, subnetwork
  
  Optional parameters: requestId
  
  Deletes the specified subnetwork."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :subnetwork})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{subnetwork}"
     #{:region :project :subnetwork}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setPrivateIpGoogleAccess$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/setPrivateIpGoogleAccess
  
  Required parameters: project, region, subnetwork
  
  Optional parameters: requestId
  
  Body: 
  
  {:privateIpGoogleAccess boolean}
  
  Set whether VMs in this subnet can access Google services without assigning external IP addresses through Private Google Access."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :subnetwork})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{subnetwork}/setPrivateIpGoogleAccess"
     #{:region :project :subnetwork}
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

(defn getIamPolicy$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/getIamPolicy
  
  Required parameters: project, region, resource
  
  Optional parameters: none
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{resource}/getIamPolicy"
     #{:region :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn expandIpCidrRange$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/expandIpCidrRange
  
  Required parameters: project, region, subnetwork
  
  Optional parameters: requestId
  
  Body: 
  
  {:ipCidrRange string}
  
  Expands the IP CIDR range of the subnetwork to a specified value."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :subnetwork})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks/{subnetwork}/expandIpCidrRange"
     #{:region :project :subnetwork}
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/subnetworks/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves a list of subnetworks available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/subnetworks"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
