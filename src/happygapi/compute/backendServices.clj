(ns happygapi.compute.backendServices
  "Compute Engine API: backendServices.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/backendServices"
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
  
  Required parameters: project, backendService
  
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
  
  Required parameters: project, backendService
  
  Optional parameters: none
  
  Returns the specified BackendService resource. Gets a list of available backend services."
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

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/insert
  
  Required parameters: project
  
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
   :consistentHash {:minimumRingSize string,
                    :httpHeaderName string,
                    :httpCookie ConsistentHashLoadBalancerSettingsHttpCookie},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:oauth2ClientSecretSha256 string,
         :oauth2ClientSecret string,
         :oauth2ClientId string,
         :enabled boolean},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean,
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/patch
  
  Required parameters: project, backendService
  
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
   :consistentHash {:minimumRingSize string,
                    :httpHeaderName string,
                    :httpCookie ConsistentHashLoadBalancerSettingsHttpCookie},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:oauth2ClientSecretSha256 string,
         :oauth2ClientSecret string,
         :oauth2ClientId string,
         :enabled boolean},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean,
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn aggregatedList$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/aggregatedList
  
  Required parameters: project
  
  Optional parameters: returnPartialSuccess, maxResults, pageToken, includeAllScopes, orderBy, filter
  
  Retrieves the list of all BackendService resources, regional and global, available to the specified project."
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
  
  Required parameters: project, backendService
  
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
   :consistentHash {:minimumRingSize string,
                    :httpHeaderName string,
                    :httpCookie ConsistentHashLoadBalancerSettingsHttpCookie},
   :port integer,
   :healthChecks [string],
   :region string,
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:oauth2ClientSecretSha256 string,
         :oauth2ClientSecret string,
         :oauth2ClientId string,
         :enabled boolean},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :failoverPolicy {:dropTrafficIfUnhealthy boolean,
                    :disableConnectionDrainOnFailover boolean,
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
               :maxUtilization number,
               :maxRate integer}],
   :customRequestHeaders [string],
   :logConfig {:enable boolean, :sampleRate number},
   :fingerprint string,
   :affinityCookieTtlSec integer,
   :securityPolicy string}
  
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendServices/list
  
  Required parameters: project
  
  Optional parameters: maxResults, returnPartialSuccess, pageToken, orderBy, filter
  
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
  
  Required parameters: project, keyName, backendService
  
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
