(ns happygapi.compute.regionBackendServices
  "Compute Engine API: regionBackendServices.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/delete
  
  Required parameters: backendService, project, region
  
  Optional parameters: requestId
  Deletes the specified regional BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args]
  {:pre [(util/has-keys? args #{:backendService :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/get
  
  Required parameters: backendService, project, region
  
  Optional parameters: none
  Returns the specified regional BackendService resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:backendService :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getHealth$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/getHealth
  
  Required parameters: backendService, project, region
  
  Optional parameters: none
  
  Body: 
  
  {:group string}
  
  Gets the most recent health check results for this regional BackendService."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:backendService :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices/{backendService}/getHealth"
     #{:backendService :region :project}
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

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :portName string,
   :cdnPolicy {:cacheKeyPolicy CacheKeyPolicy,
               :signedUrlCacheMaxAgeSec string,
               :signedUrlKeyNames [string]},
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
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
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
  
  Creates a regional BackendService resource in the specified project using the data included in the request. There are several restrictions and guidelines to keep in mind when creating a regional backend service. Read  Restrictions and Guidelines for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  Retrieves the list of regional BackendService resources available to the specified project in the given region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/patch
  
  Required parameters: backendService, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :portName string,
   :cdnPolicy {:cacheKeyPolicy CacheKeyPolicy,
               :signedUrlCacheMaxAgeSec string,
               :signedUrlKeyNames [string]},
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
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
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
  
  Updates the specified regional BackendService resource with the data included in the request. There are several restrictions and guidelines to keep in mind when updating a backend service. Read  Restrictions and Guidelines for more information. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:backendService :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
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

(defn update$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionBackendServices/update
  
  Required parameters: backendService, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :creationTimestamp string,
   :protocol string,
   :enableCDN boolean,
   :connectionDraining {:drainingTimeoutSec integer},
   :name string,
   :portName string,
   :cdnPolicy {:cacheKeyPolicy CacheKeyPolicy,
               :signedUrlCacheMaxAgeSec string,
               :signedUrlKeyNames [string]},
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
   :circuitBreakers {:maxConnections integer,
                     :maxPendingRequests integer,
                     :maxRequests integer,
                     :maxRequestsPerConnection integer,
                     :maxRetries integer},
   :iap {:enabled boolean,
         :oauth2ClientId string,
         :oauth2ClientSecret string,
         :oauth2ClientSecretSha256 string},
   :id string,
   :kind string,
   :localityLbPolicy string,
   :sessionAffinity string,
   :timeoutSec integer,
   :network string,
   :backends [{:description string,
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
  
  Updates the specified regional BackendService resource with the data included in the request. There are several restrictions and guidelines to keep in mind when updating a backend service. Read  Restrictions and Guidelines for more information."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:backendService :region :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/backendServices/{backendService}"
     #{:backendService :region :project}
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
