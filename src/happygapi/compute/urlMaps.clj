(ns happygapi.compute.urlMaps
  "Compute Engine API: urlMaps.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/urlMaps"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn invalidateCache$
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/invalidateCache
  
  Required parameters: project, urlMap
  
  Optional parameters: requestId
  
  Body: 
  
  {:path string, :host string}
  
  Initiates a cache invalidation operation, invalidating the specified path, scoped to the specified UrlMap. For more information, see [Invalidating cached content](/cdn/docs/invalidating-cached-content)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}/invalidateCache"
     #{:urlMap :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/get
  
  Required parameters: project, urlMap
  
  Optional parameters: none
  
  Returns the specified UrlMap resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}"
     #{:urlMap :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Creates a UrlMap resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps"
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

(defn validate$
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/validate
  
  Required parameters: project, urlMap
  
  Optional parameters: none
  
  Body: 
  
  {:resource {:description string,
              :pathMatchers [PathMatcher],
              :creationTimestamp string,
              :tests [UrlMapTest],
              :name string,
              :defaultUrlRedirect HttpRedirectAction,
              :selfLink string,
              :headerAction HttpHeaderAction,
              :region string,
              :defaultRouteAction HttpRouteAction,
              :defaultService string,
              :id string,
              :kind string,
              :hostRules [HostRule],
              :fingerprint string},
   :loadBalancingSchemes [string]}
  
  Runs static validation for the UrlMap. In particular, the tests of the provided UrlMap will be run. Calling this method does NOT create the UrlMap."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}/validate"
     #{:urlMap :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/patch
  
  Required parameters: project, urlMap
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Patches the specified UrlMap resource with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}"
     #{:urlMap :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves the list of all UrlMap resources, regional and global, available to the specified project. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/urlMaps"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/update
  
  Required parameters: project, urlMap
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :pathMatchers [{:name string,
                   :description string,
                   :defaultService string,
                   :defaultRouteAction HttpRouteAction,
                   :defaultUrlRedirect HttpRedirectAction,
                   :pathRules [PathRule],
                   :routeRules [HttpRouteRule],
                   :headerAction HttpHeaderAction}],
   :creationTimestamp string,
   :tests [{:description string,
            :host string,
            :path string,
            :headers [UrlMapTestHeader],
            :service string,
            :expectedOutputUrl string,
            :expectedRedirectResponseCode integer}],
   :name string,
   :defaultUrlRedirect {:hostRedirect string,
                        :pathRedirect string,
                        :prefixRedirect string,
                        :redirectResponseCode string,
                        :httpsRedirect boolean,
                        :stripQuery boolean},
   :selfLink string,
   :headerAction {:requestHeadersToRemove [string],
                  :requestHeadersToAdd [HttpHeaderOption],
                  :responseHeadersToRemove [string],
                  :responseHeadersToAdd [HttpHeaderOption]},
   :region string,
   :defaultRouteAction {:weightedBackendServices [WeightedBackendService],
                        :urlRewrite UrlRewrite,
                        :timeout Duration,
                        :retryPolicy HttpRetryPolicy,
                        :requestMirrorPolicy RequestMirrorPolicy,
                        :corsPolicy CorsPolicy,
                        :faultInjectionPolicy HttpFaultInjection,
                        :maxStreamDuration Duration},
   :defaultService string,
   :id string,
   :kind string,
   :hostRules [{:description string,
                :hosts [string],
                :pathMatcher string}],
   :fingerprint string}
  
  Updates the specified UrlMap resource with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}"
     #{:urlMap :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/delete
  
  Required parameters: project, urlMap
  
  Optional parameters: requestId
  
  Deletes the specified UrlMap resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:urlMap :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps/{urlMap}"
     #{:urlMap :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/urlMaps/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves the list of UrlMap resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/urlMaps"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
