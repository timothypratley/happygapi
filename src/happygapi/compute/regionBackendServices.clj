(ns happygapi.compute.regionBackendServices
  "Compute Engine API: regionBackendServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/regionBackendServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn setSecurityPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/setSecurityPolicy
  
  Required parameters: backendService, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:securityPolicy string}
  
  Sets the Google Cloud Armor security policy for the specified backend service. For more information, see Google Cloud Armor Overview"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}/setSecurityPolicy"
     #{:backendService :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/getHealth
  
  Required parameters: backendService, project, region
  
  Optional parameters: none
  
  Body: 
  
  {:group string}
  
  Gets the most recent health check results for this regional BackendService."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}/getHealth"
     #{:backendService :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/get
  
  Required parameters: backendService, project, region
  
  Optional parameters: none
  
  Returns the specified regional BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/setIamPolicy
  
  Required parameters: project, region, resource
  
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
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{resource}/setIamPolicy"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/insert
  
  Required parameters: project, region
  
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
  
  Creates a regional BackendService resource in the specified project using the data included in the request. For more information, see Backend services overview."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/listUsable
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves an aggregated list of all usable backend services in the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/listUsable"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/patch
  
  Required parameters: backendService, project, region
  
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
  
  Updates the specified regional BackendService resource with the data included in the request. For more information, see Understanding backend services This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/testIamPermissions
  
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
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{resource}/testIamPermissions"
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

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/update
  
  Required parameters: backendService, project, region
  
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
  
  Updates the specified regional BackendService resource with the data included in the request. For more information, see Backend services overview ."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/delete
  
  Required parameters: backendService, project, region
  
  Optional parameters: requestId
  
  Deletes the specified regional BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:backendService :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/getIamPolicy
  
  Required parameters: project, region, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices/{resource}/getIamPolicy"
     #{:region :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of regional BackendService resources available to the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/backendServices"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
