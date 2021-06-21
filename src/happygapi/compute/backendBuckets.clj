(ns happygapi.compute.backendBuckets
  "Compute Engine API: backendBuckets.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/patch
  
  Required parameters: backendBucket, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :customResponseHeaders [string],
   :creationTimestamp string,
   :name string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendBucketCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendBucketCdnPolicyNegativeCachingPolicy],
               :clientTtl integer,
               :cacheMode string},
   :selfLink string,
   :enableCdn boolean,
   :id string,
   :kind string,
   :bucketName string}
  
  Updates the specified BackendBucket resource with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendBucket :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}"
     #{:backendBucket :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/get
  
  Required parameters: project, backendBucket
  
  Optional parameters: none
  
  Returns the specified BackendBucket resource. Gets a list of available backend buckets by making a list() request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:backendBucket :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}"
     #{:backendBucket :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/insert
  
  Required parameters: project
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :customResponseHeaders [string],
   :creationTimestamp string,
   :name string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendBucketCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendBucketCdnPolicyNegativeCachingPolicy],
               :clientTtl integer,
               :cacheMode string},
   :selfLink string,
   :enableCdn boolean,
   :id string,
   :kind string,
   :bucketName string}
  
  Creates a BackendBucket resource in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets"
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

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/list
  
  Required parameters: project
  
  Optional parameters: pageToken, maxResults, returnPartialSuccess, orderBy, filter
  
  Retrieves the list of BackendBucket resources available to the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/update
  
  Required parameters: project, backendBucket
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :customResponseHeaders [string],
   :creationTimestamp string,
   :name string,
   :cdnPolicy {:defaultTtl integer,
               :serveWhileStale integer,
               :signedUrlKeyNames [string],
               :maxTtl integer,
               :signedUrlCacheMaxAgeSec string,
               :requestCoalescing boolean,
               :negativeCaching boolean,
               :bypassCacheOnRequestHeaders [BackendBucketCdnPolicyBypassCacheOnRequestHeader],
               :negativeCachingPolicy [BackendBucketCdnPolicyNegativeCachingPolicy],
               :clientTtl integer,
               :cacheMode string},
   :selfLink string,
   :enableCdn boolean,
   :id string,
   :kind string,
   :bucketName string}
  
  Updates the specified BackendBucket resource with the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendBucket :project})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}"
     #{:backendBucket :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/deleteSignedUrlKey
  
  Required parameters: project, backendBucket, keyName
  
  Optional parameters: requestId
  
  Deletes a key for validating requests with signed URLs for this backend bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:keyName :backendBucket :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}/deleteSignedUrlKey"
     #{:keyName :backendBucket :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addSignedUrlKey$
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/addSignedUrlKey
  
  Required parameters: backendBucket, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:keyName string, :keyValue string}
  
  Adds a key for validating requests with signed URLs for this backend bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:backendBucket :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}/addSignedUrlKey"
     #{:backendBucket :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/backendBuckets/delete
  
  Required parameters: backendBucket, project
  
  Optional parameters: requestId
  
  Deletes the specified BackendBucket resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:backendBucket :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/backendBuckets/{backendBucket}"
     #{:backendBucket :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
