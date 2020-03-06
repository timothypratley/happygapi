(ns happygapi.storage.buckets
  "Cloud Storage JSON API: buckets.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/get
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, projection, provisionalUserProject, userProject
  Returns metadata for the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/setIamPolicy
  
  Required parameters: bucket
  
  Optional parameters: provisionalUserProject, userProject
  
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
  [auth args body]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam"
     #{:bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/insert
  
  Required parameters: project
  
  Optional parameters: predefinedAcl, predefinedDefaultObjectAcl, projection, provisionalUserProject, userProject
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :storageClass string,
   :timeCreated string,
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :selfLink string,
   :etag string,
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:age integer,
                                   :createdBefore string,
                                   :isLive boolean,
                                   :matchesPattern string,
                                   :matchesStorageClass [string],
                                   :numNewerVersions integer}}]},
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
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string}},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Creates a new bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b"
     #{:project}
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

(defn patch$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/patch
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, predefinedAcl, predefinedDefaultObjectAcl, projection, provisionalUserProject, userProject
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :storageClass string,
   :timeCreated string,
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :selfLink string,
   :etag string,
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:age integer,
                                   :createdBefore string,
                                   :isLive boolean,
                                   :matchesPattern string,
                                   :matchesStorageClass [string],
                                   :numNewerVersions integer}}]},
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
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string}},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Patches a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
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

(defn testIamPermissions$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/testIamPermissions
  
  Required parameters: bucket, permissions
  
  Optional parameters: provisionalUserProject, userProject
  Tests a set of permissions on the given bucket to see which, if any, are held by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{:permissions :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam/testPermissions"
     #{:permissions :bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/update
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, predefinedAcl, predefinedDefaultObjectAcl, projection, provisionalUserProject, userProject
  
  Body: 
  
  {:cors [{:maxAgeSeconds integer,
           :method [string],
           :origin [string],
           :responseHeader [string]}],
   :labels {},
   :storageClass string,
   :timeCreated string,
   :updated string,
   :name string,
   :billing {:requesterPays boolean},
   :selfLink string,
   :etag string,
   :lifecycle {:rule [{:action {:storageClass string, :type string},
                       :condition {:age integer,
                                   :createdBefore string,
                                   :isLive boolean,
                                   :matchesPattern string,
                                   :matchesStorageClass [string],
                                   :numNewerVersions integer}}]},
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
   :iamConfiguration {:bucketPolicyOnly {:enabled boolean,
                                         :lockedTime string},
                      :uniformBucketLevelAccess {:enabled boolean,
                                                 :lockedTime string}},
   :defaultEventBasedHold boolean,
   :versioning {:enabled boolean},
   :location string,
   :owner {:entity string, :entityId string},
   :metageneration string}
  
  Updates a bucket. Changes to the bucket will be readable immediately after writing, but configuration changes may take time to propagate."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
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

(defn delete$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/delete
  
  Required parameters: bucket
  
  Optional parameters: ifMetagenerationMatch, ifMetagenerationNotMatch, provisionalUserProject, userProject
  Permanently deletes an empty bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}"
     #{:bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/getIamPolicy
  
  Required parameters: bucket
  
  Optional parameters: optionsRequestedPolicyVersion, provisionalUserProject, userProject
  Returns an IAM policy for the specified bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth args]
  {:pre [(util/has-keys? args #{:bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/iam"
     #{:bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/list
  
  Required parameters: project
  
  Optional parameters: maxResults, pageToken, prefix, projection, provisionalUserProject, userProject
  Retrieves a list of buckets for a given project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b"
     #{:project}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn lockRetentionPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/buckets/lockRetentionPolicy
  
  Required parameters: bucket, ifMetagenerationMatch
  
  Optional parameters: provisionalUserProject, userProject
  Locks retention policy on a bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth args]
  {:pre [(util/has-keys? args #{:ifMetagenerationMatch :bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/lockRetentionPolicy"
     #{:ifMetagenerationMatch :bucket}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
