(ns happygapi.storage.buckets
  "Cloud Storage JSON API: buckets.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/docs/reference/rest/v1/buckets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/get
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, projection, userProject
  
  Returns metadata for the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/setIamPolicy
  
  Required parameters: bucket
  
  Optional parameters: userProject
  
  Body: 
  
  {:bindings [{:condition {:description string,
                           :expression string,
                           :location string,
                           :title string},
               :members [string],
               :role string}],
   :etag string,
   :kind string,
   :resourceId string,
   :version integer}
  
  Updates an IAM policy for the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam"
     #{:bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/insert
  
  Required parameters: project
  
  Optional parameters: predefinedAcl, predefinedDefaultObjectAcl, projection, userProject, enableObjectRetention
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :rpo string,
   :customPlacementConfig {:dataLocations [string]},
   :storageClass string,
   :timeCreated string,
   :autoclass {:enabled boolean,
               :toggleTime string,
               :terminalStorageClass string,
               :terminalStorageClassUpdateTime string},
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :hierarchicalNamespace {:enabled boolean},
   :selfLink string,
   :etag string,
   :objectRetention {:mode string},
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:customTimeBefore string,
                                   :age integer,
                                   :createdBefore string,
                                   :daysSinceNoncurrentTime integer,
                                   :matchesSuffix [string],
                                   :numNewerVersions integer,
                                   :matchesStorageClass [string],
                                   :matchesPattern string,
                                   :matchesPrefix [string],
                                   :noncurrentTimeBefore string,
                                   :isLive boolean,
                                   :daysSinceCustomTime integer}}]},
   :logging {:logBucket string, :logObjectPrefix string},
   :projectNumber string,
   :encryption {:defaultKmsKeyName string},
   :defaultObjectAcl [{:role string,
                       :email string,
                       :generation string,
                       :projectTeam {:projectNumber string,
                                     :team string},
                       :selfLink string,
                       :etag string,
                       :id string,
                       :kind string,
                       :domain string,
                       :entity string,
                       :entityId string,
                       :object string,
                       :bucket string}],
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :retentionPolicy {:effectiveTime string,
                     :isLocked boolean,
                     :retentionPeriod string},
   :website {:mainPageSuffix string, :notFoundPage string},
   :acl [{:role string,
          :email string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :bucket string}],
   :locationType string,
   :softDeletePolicy {:retentionDurationSeconds string,
                      :effectiveTime string},
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string},
                      :publicAccessPrevention string},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Creates a new bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b"
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/patch
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, predefinedAcl, predefinedDefaultObjectAcl, projection, userProject
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :rpo string,
   :customPlacementConfig {:dataLocations [string]},
   :storageClass string,
   :timeCreated string,
   :autoclass {:enabled boolean,
               :toggleTime string,
               :terminalStorageClass string,
               :terminalStorageClassUpdateTime string},
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :hierarchicalNamespace {:enabled boolean},
   :selfLink string,
   :etag string,
   :objectRetention {:mode string},
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:customTimeBefore string,
                                   :age integer,
                                   :createdBefore string,
                                   :daysSinceNoncurrentTime integer,
                                   :matchesSuffix [string],
                                   :numNewerVersions integer,
                                   :matchesStorageClass [string],
                                   :matchesPattern string,
                                   :matchesPrefix [string],
                                   :noncurrentTimeBefore string,
                                   :isLive boolean,
                                   :daysSinceCustomTime integer}}]},
   :logging {:logBucket string, :logObjectPrefix string},
   :projectNumber string,
   :encryption {:defaultKmsKeyName string},
   :defaultObjectAcl [{:role string,
                       :email string,
                       :generation string,
                       :projectTeam {:projectNumber string,
                                     :team string},
                       :selfLink string,
                       :etag string,
                       :id string,
                       :kind string,
                       :domain string,
                       :entity string,
                       :entityId string,
                       :object string,
                       :bucket string}],
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :retentionPolicy {:effectiveTime string,
                     :isLocked boolean,
                     :retentionPeriod string},
   :website {:mainPageSuffix string, :notFoundPage string},
   :acl [{:role string,
          :email string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :bucket string}],
   :locationType string,
   :softDeletePolicy {:retentionDurationSeconds string,
                      :effectiveTime string},
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string},
                      :publicAccessPrevention string},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Patches a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/testIamPermissions
  
  Required parameters: bucket, permissions
  
  Optional parameters: userProject
  
  Tests a set of permissions on the given bucket to see which, if any, are held by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:permissions :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam/testPermissions"
     #{:permissions :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/update
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, predefinedAcl, predefinedDefaultObjectAcl, projection, userProject
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :rpo string,
   :customPlacementConfig {:dataLocations [string]},
   :storageClass string,
   :timeCreated string,
   :autoclass {:enabled boolean,
               :toggleTime string,
               :terminalStorageClass string,
               :terminalStorageClassUpdateTime string},
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :hierarchicalNamespace {:enabled boolean},
   :selfLink string,
   :etag string,
   :objectRetention {:mode string},
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:customTimeBefore string,
                                   :age integer,
                                   :createdBefore string,
                                   :daysSinceNoncurrentTime integer,
                                   :matchesSuffix [string],
                                   :numNewerVersions integer,
                                   :matchesStorageClass [string],
                                   :matchesPattern string,
                                   :matchesPrefix [string],
                                   :noncurrentTimeBefore string,
                                   :isLive boolean,
                                   :daysSinceCustomTime integer}}]},
   :logging {:logBucket string, :logObjectPrefix string},
   :projectNumber string,
   :encryption {:defaultKmsKeyName string},
   :defaultObjectAcl [{:role string,
                       :email string,
                       :generation string,
                       :projectTeam {:projectNumber string,
                                     :team string},
                       :selfLink string,
                       :etag string,
                       :id string,
                       :kind string,
                       :domain string,
                       :entity string,
                       :entityId string,
                       :object string,
                       :bucket string}],
   :satisfiesPZS boolean,
   :id string,
   :kind string,
   :retentionPolicy {:effectiveTime string,
                     :isLocked boolean,
                     :retentionPeriod string},
   :website {:mainPageSuffix string, :notFoundPage string},
   :acl [{:role string,
          :email string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :bucket string}],
   :locationType string,
   :softDeletePolicy {:retentionDurationSeconds string,
                      :effectiveTime string},
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string},
                      :publicAccessPrevention string},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Updates a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/delete
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, userProject
  
  Permanently deletes an empty bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/getIamPolicy
  
  Required parameters: bucket
  
  Optional parameters: optionsRequestedPolicyVersion, userProject
  
  Returns an IAM policy for the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, prefix, projection, userProject
  
  Retrieves a list of buckets for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lockRetentionPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/lockRetentionPolicy
  
  Required parameters: bucket, ifMetagenerationMatch
  
  Optional parameters: userProject
  
  Locks retention policy on a bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ifMetagenerationMatch :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/lockRetentionPolicy"
     #{:ifMetagenerationMatch :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
