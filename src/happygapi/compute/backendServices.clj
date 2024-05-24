(ns happygapi.compute.backendServices
  "Compute Engine API: backendServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/backendServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setSecurityPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/setSecurityPolicy
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:securityPolicy string}
  
  Sets the Google Cloud Armor security policy for the specified backend service. For more information, see Google Cloud Armor Overview"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}/setSecurityPolicy"
     #{:backendService :project}
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

(defn getHealth$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/getHealth
  
  Required parameters: backendService, project
  
  Optional parameters: none
  
  Body: 
  
  {:group string}
  
  Gets the most recent health check results for this BackendService. Example request body: { \"group\": \"/zones/us-east1-b/instanceGroups/lb-backend-example\" }"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}/getHealth"
     #{:backendService :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/get
  
  Required parameters: backendService, project
  
  Optional parameters: none
  
  Returns the specified BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}"
     #{:backendService :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/setIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :rules [Rule],
            :etag string},
   :bindings [{:role string,
               :members [string],
               :condition Expr,
               :bindingId string}],
   :etag string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{resource}/setIamPolicy"
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:clientTlsPolicy string,
                      :subjectAltNames [string],
                      :awsV4Authentication AWSV4Signature},
   :customResponseHeaders [string],
   :edgeSecurityPolicy string,
   :creationTimestamp string,
   :usedBy [{:reference string}],
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :subsetting {:policy string},
   :maxStreamDuration {:seconds string, :nanos integer},
   :serviceLbPolicy string,
   :portName string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendServiceCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendServiceCdnPolicyNegativeCachingPolicy],
               :cacheKeyPolicy CacheKeyPolicy,
               :clientTtl integer,
               :cacheMode string},
   :outlierDetection {:successRateStdevFactor integer,
                      :successRateMinimumHosts integer,
                      :enforcingSuccessRate integer,
                      :maxEjectionPercent integer,
                      :successRateRequestVolume integer,
                      :interval Duration,
                      :consecutiveGatewayFailure integer,
                      :baseEjectionTime Duration,
                      :enforcingConsecutiveGatewayFailure integer,
                      :consecutiveErrors integer,
                      :enforcingConsecutiveErrors integer},
   :selfLink string,
   :loadBalancingScheme string,
   :connectionTrackingPolicy {:trackingMode string,
                              :connectionPersistenceOnUnhealthyBackends string,
                              :idleTimeoutSec integer,
                              :enableStrongAffinity boolean},
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :compressionMode string,
   :localityLbPolicies [{:policy BackendServiceLocalityLoadBalancingPolicyConfigPolicy,
                         :customPolicy BackendServiceLocalityLoadBalancingPolicyConfigCustomPolicy}],
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:disableConnectionDrainOnFailover boolean,
                    :dropTrafficIfUnhealthy boolean,
                    :failoverRatio number},
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
               :failover boolean,
               :capacityScaler number,
               :group string,
               :maxRatePerInstance number,
               :maxConnectionsPerEndpoint integer,
               :balancingMode string,
               :maxConnections integer,
               :maxRatePerEndpoint number,
               :maxConnectionsPerInstance integer,
               :preference string,
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean,
               :sampleRate number,
               :optionalMode string,
               :optionalFields [string]},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :metadatas {},
   :securityPolicy string,
   :serviceBindings [string]}
  
  Creates a BackendService resource in the specified project using the data included in the request. For more information, see Backend services overview ."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices"
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

(defn listUsable$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/listUsable
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves an aggregated list of all usable backend services in the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/listUsable"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/patch
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:clientTlsPolicy string,
                      :subjectAltNames [string],
                      :awsV4Authentication AWSV4Signature},
   :customResponseHeaders [string],
   :edgeSecurityPolicy string,
   :creationTimestamp string,
   :usedBy [{:reference string}],
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :subsetting {:policy string},
   :maxStreamDuration {:seconds string, :nanos integer},
   :serviceLbPolicy string,
   :portName string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendServiceCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendServiceCdnPolicyNegativeCachingPolicy],
               :cacheKeyPolicy CacheKeyPolicy,
               :clientTtl integer,
               :cacheMode string},
   :outlierDetection {:successRateStdevFactor integer,
                      :successRateMinimumHosts integer,
                      :enforcingSuccessRate integer,
                      :maxEjectionPercent integer,
                      :successRateRequestVolume integer,
                      :interval Duration,
                      :consecutiveGatewayFailure integer,
                      :baseEjectionTime Duration,
                      :enforcingConsecutiveGatewayFailure integer,
                      :consecutiveErrors integer,
                      :enforcingConsecutiveErrors integer},
   :selfLink string,
   :loadBalancingScheme string,
   :connectionTrackingPolicy {:trackingMode string,
                              :connectionPersistenceOnUnhealthyBackends string,
                              :idleTimeoutSec integer,
                              :enableStrongAffinity boolean},
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :compressionMode string,
   :localityLbPolicies [{:policy BackendServiceLocalityLoadBalancingPolicyConfigPolicy,
                         :customPolicy BackendServiceLocalityLoadBalancingPolicyConfigCustomPolicy}],
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:disableConnectionDrainOnFailover boolean,
                    :dropTrafficIfUnhealthy boolean,
                    :failoverRatio number},
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
               :failover boolean,
               :capacityScaler number,
               :group string,
               :maxRatePerInstance number,
               :maxConnectionsPerEndpoint integer,
               :balancingMode string,
               :maxConnections integer,
               :maxRatePerEndpoint number,
               :maxConnectionsPerInstance integer,
               :preference string,
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean,
               :sampleRate number,
               :optionalMode string,
               :optionalFields [string]},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :metadatas {},
   :securityPolicy string,
   :serviceBindings [string]}
  
  Patches the specified BackendService resource with the data included in the request. For more information, see Backend services overview. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}"
     #{:backendService :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{resource}/testIamPermissions"
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of all BackendService resources, regional and global, available to the specified project. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/backendServices"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/update
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:clientTlsPolicy string,
                      :subjectAltNames [string],
                      :awsV4Authentication AWSV4Signature},
   :customResponseHeaders [string],
   :edgeSecurityPolicy string,
   :creationTimestamp string,
   :usedBy [{:reference string}],
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :subsetting {:policy string},
   :maxStreamDuration {:seconds string, :nanos integer},
   :serviceLbPolicy string,
   :portName string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendServiceCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendServiceCdnPolicyNegativeCachingPolicy],
               :cacheKeyPolicy CacheKeyPolicy,
               :clientTtl integer,
               :cacheMode string},
   :outlierDetection {:successRateStdevFactor integer,
                      :successRateMinimumHosts integer,
                      :enforcingSuccessRate integer,
                      :maxEjectionPercent integer,
                      :successRateRequestVolume integer,
                      :interval Duration,
                      :consecutiveGatewayFailure integer,
                      :baseEjectionTime Duration,
                      :enforcingConsecutiveGatewayFailure integer,
                      :consecutiveErrors integer,
                      :enforcingConsecutiveErrors integer},
   :selfLink string,
   :loadBalancingScheme string,
   :connectionTrackingPolicy {:trackingMode string,
                              :connectionPersistenceOnUnhealthyBackends string,
                              :idleTimeoutSec integer,
                              :enableStrongAffinity boolean},
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :compressionMode string,
   :localityLbPolicies [{:policy BackendServiceLocalityLoadBalancingPolicyConfigPolicy,
                         :customPolicy BackendServiceLocalityLoadBalancingPolicyConfigCustomPolicy}],
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:disableConnectionDrainOnFailover boolean,
                    :dropTrafficIfUnhealthy boolean,
                    :failoverRatio number},
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
               :failover boolean,
               :capacityScaler number,
               :group string,
               :maxRatePerInstance number,
               :maxConnectionsPerEndpoint integer,
               :balancingMode string,
               :maxConnections integer,
               :maxRatePerEndpoint number,
               :maxConnectionsPerInstance integer,
               :preference string,
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean,
               :sampleRate number,
               :optionalMode string,
               :optionalFields [string]},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :metadatas {},
   :securityPolicy string,
   :serviceBindings [string]}
  
  Updates the specified BackendService resource with the data included in the request. For more information, see Backend services overview."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}"
     #{:backendService :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/delete
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Deletes the specified BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}"
     #{:backendService :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{resource}/getIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of BackendService resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addSignedUrlKey$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/addSignedUrlKey
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:keyName string, :keyValue string}
  
  Adds a key for validating requests with signed URLs for this backend service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}/addSignedUrlKey"
     #{:backendService :project}
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

(defn deleteSignedUrlKey$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/deleteSignedUrlKey
  
  Required parameters: backendService, keyName, project
  
  Optional parameters: requestId
  
  Deletes a key for validating requests with signed URLs for this backend service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:keyName :backendService :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}/deleteSignedUrlKey"
     #{:keyName :backendService :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setEdgeSecurityPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/setEdgeSecurityPolicy
  
  Required parameters: backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:securityPolicy string}
  
  Sets the edge security policy for the specified backend service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendService :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendServices/{backendService}/setEdgeSecurityPolicy"
     #{:backendService :project}
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
