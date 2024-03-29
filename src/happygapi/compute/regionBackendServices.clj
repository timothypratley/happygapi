(ns happygapi.compute.regionBackendServices
  "Compute Engine API: regionBackendServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/update
  
  Required parameters: project, region, backendService
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:subjectAltNames [string],
                      :clientTlsPolicy string},
   :customResponseHeaders [string],
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :maxStreamDuration {:seconds string, :nanos integer},
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
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRetries integer,
                     :maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxRequests integer,
                     :maxPendingRequests integer},
   :iap {:enabled boolean,
         :oauth2ClientSecretSha256 string,
         :oauth2ClientId string,
         :oauth2ClientSecret string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:failoverRatio number,
                    :dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean},
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/get
  
  Required parameters: region, backendService, project
  
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/delete
  
  Required parameters: region, backendService, project
  
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/patch
  
  Required parameters: region, backendService, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:subjectAltNames [string],
                      :clientTlsPolicy string},
   :customResponseHeaders [string],
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :maxStreamDuration {:seconds string, :nanos integer},
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
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRetries integer,
                     :maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxRequests integer,
                     :maxPendingRequests integer},
   :iap {:enabled boolean,
         :oauth2ClientSecretSha256 string,
         :oauth2ClientId string,
         :oauth2ClientSecret string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:failoverRatio number,
                    :dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean},
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :securitySettings {:subjectAltNames [string],
                      :clientTlsPolicy string},
   :customResponseHeaders [string],
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :maxStreamDuration {:seconds string, :nanos integer},
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
   :consistentHash {:httpCookie ConsistentHashLoadBalancerSettingsHttpCookie,
                    :httpHeaderName string,
                    :minimumRingSize string},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxRetries integer,
                     :maxRequestsPerConnection integer,
                     :maxConnections integer,
                     :maxRequests integer,
                     :maxPendingRequests integer},
   :iap {:enabled boolean,
         :oauth2ClientSecretSha256 string,
         :oauth2ClientId string,
         :oauth2ClientSecret string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:failoverRatio number,
                    :dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean},
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/list
  
  Required parameters: region, project
  
  Optional parameters: filter, orderBy, maxResults, returnPartialSuccess, pageToken
  
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

(defn getHealth$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionBackendServices/getHealth
  
  Required parameters: region, backendService, project
  
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
