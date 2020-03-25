(ns happygapi.storage.objects
  "Cloud Storage JSON API: objects.
  Stores and retrieves potentially large, immutable data objects.
  See: https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn compose$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/compose
  
  Required parameters: destinationBucket, destinationObject
  
  Optional parameters: destinationPredefinedAcl, ifGenerationMatch, ifMetagenerationMatch, kmsKeyName, provisionalUserProject, userProject
  
  Body: 
  
  {:destination {:contentDisposition string,
                 :storageClass string,
                 :contentEncoding string,
                 :generation string,
                 :timeCreated string,
                 :temporaryHold boolean,
                 :eventBasedHold boolean,
                 :updated string,
                 :name string,
                 :retentionExpirationTime string,
                 :selfLink string,
                 :contentLanguage string,
                 :etag string,
                 :size string,
                 :md5Hash string,
                 :cacheControl string,
                 :timeStorageClassUpdated string,
                 :timeDeleted string,
                 :id string,
                 :kind string,
                 :mediaLink string,
                 :kmsKeyName string,
                 :componentCount integer,
                 :acl [ObjectAccessControl],
                 :customerEncryption {:encryptionAlgorithm string,
                                      :keySha256 string},
                 :contentType string,
                 :metadata {},
                 :crc32c string,
                 :owner {:entity string, :entityId string},
                 :bucket string,
                 :metageneration string},
   :kind string,
   :sourceObjects [{:generation string,
                    :name string,
                    :objectPreconditions {:ifGenerationMatch string}}]}
  
  Concatenates a list of existing objects into a new object in the same bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:destinationBucket :destinationObject})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{destinationBucket}/o/{destinationObject}/compose"
     #{:destinationBucket :destinationObject}
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

(defn watchAll$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/watchAll
  
  Required parameters: bucket
  
  Optional parameters: startOffset, endOffset, prefix, pageToken, delimiter, userProject, includeTrailingDelimiter, provisionalUserProject, versions, projection, maxResults
  
  Body: 
  
  {:address string,
   :resourceUri string,
   :payload boolean,
   :expiration string,
   :params {},
   :type string,
   :resourceId string,
   :token string,
   :id string,
   :kind string}
  
  Watch for changes on all objects in a bucket."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/watch"
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

(defn get$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/get
  
  Required parameters: object, bucket
  
  Optional parameters: generation, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Retrieves an object or its metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{:object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn copy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/copy
  
  Required parameters: destinationBucket, sourceBucket, destinationObject, sourceObject
  
  Optional parameters: ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, destinationPredefinedAcl, userProject, provisionalUserProject, ifSourceMetagenerationNotMatch, sourceGeneration, ifSourceGenerationMatch, projection, ifSourceGenerationNotMatch, ifSourceMetagenerationMatch
  
  Body: 
  
  {:contentDisposition string,
   :storageClass string,
   :contentEncoding string,
   :generation string,
   :timeCreated string,
   :temporaryHold boolean,
   :eventBasedHold boolean,
   :updated string,
   :name string,
   :retentionExpirationTime string,
   :selfLink string,
   :contentLanguage string,
   :etag string,
   :size string,
   :md5Hash string,
   :cacheControl string,
   :timeStorageClassUpdated string,
   :timeDeleted string,
   :id string,
   :kind string,
   :mediaLink string,
   :kmsKeyName string,
   :componentCount integer,
   :acl [{:role string,
          :email string,
          :generation string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :object string,
          :bucket string}],
   :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
   :contentType string,
   :metadata {},
   :crc32c string,
   :owner {:entity string, :entityId string},
   :bucket string,
   :metageneration string}
  
  Copies a source object to a destination object. Optionally overrides metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:destinationBucket
            :sourceBucket
            :destinationObject
            :sourceObject})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{sourceBucket}/o/{sourceObject}/copyTo/b/{destinationBucket}/o/{destinationObject}"
     #{:destinationBucket
       :sourceBucket
       :destinationObject
       :sourceObject}
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

(defn setIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/setIamPolicy
  
  Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
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
  
  Updates an IAM policy for the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam"
     #{:object :bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/insert
  
  Required parameters: bucket
  
  Optional parameters: contentEncoding, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, name, ifGenerationNotMatch, ifMetagenerationMatch, kmsKeyName, userProject, provisionalUserProject, projection
  
  Body: 
  
  {:contentDisposition string,
   :storageClass string,
   :contentEncoding string,
   :generation string,
   :timeCreated string,
   :temporaryHold boolean,
   :eventBasedHold boolean,
   :updated string,
   :name string,
   :retentionExpirationTime string,
   :selfLink string,
   :contentLanguage string,
   :etag string,
   :size string,
   :md5Hash string,
   :cacheControl string,
   :timeStorageClassUpdated string,
   :timeDeleted string,
   :id string,
   :kind string,
   :mediaLink string,
   :kmsKeyName string,
   :componentCount integer,
   :acl [{:role string,
          :email string,
          :generation string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :object string,
          :bucket string}],
   :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
   :contentType string,
   :metadata {},
   :crc32c string,
   :owner {:entity string, :entityId string},
   :bucket string,
   :metageneration string}
  
  Stores a new object and metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:bucket})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o"
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

(defn patch$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/patch
  
  Required parameters: object, bucket
  
  Optional parameters: generation, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Body: 
  
  {:contentDisposition string,
   :storageClass string,
   :contentEncoding string,
   :generation string,
   :timeCreated string,
   :temporaryHold boolean,
   :eventBasedHold boolean,
   :updated string,
   :name string,
   :retentionExpirationTime string,
   :selfLink string,
   :contentLanguage string,
   :etag string,
   :size string,
   :md5Hash string,
   :cacheControl string,
   :timeStorageClassUpdated string,
   :timeDeleted string,
   :id string,
   :kind string,
   :mediaLink string,
   :kmsKeyName string,
   :componentCount integer,
   :acl [{:role string,
          :email string,
          :generation string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :object string,
          :bucket string}],
   :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
   :contentType string,
   :metadata {},
   :crc32c string,
   :owner {:entity string, :entityId string},
   :bucket string,
   :metageneration string}
  
  Patches an object's metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{:object :bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/testIamPermissions
  
  Required parameters: bucket, object, permissions
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Tests a set of permissions on the given object to see which, if any, are held by the caller."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:permissions :object :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam/testPermissions"
     #{:permissions :object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/update
  
  Required parameters: object, bucket
  
  Optional parameters: generation, predefinedAcl, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject, projection
  
  Body: 
  
  {:contentDisposition string,
   :storageClass string,
   :contentEncoding string,
   :generation string,
   :timeCreated string,
   :temporaryHold boolean,
   :eventBasedHold boolean,
   :updated string,
   :name string,
   :retentionExpirationTime string,
   :selfLink string,
   :contentLanguage string,
   :etag string,
   :size string,
   :md5Hash string,
   :cacheControl string,
   :timeStorageClassUpdated string,
   :timeDeleted string,
   :id string,
   :kind string,
   :mediaLink string,
   :kmsKeyName string,
   :componentCount integer,
   :acl [{:role string,
          :email string,
          :generation string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :object string,
          :bucket string}],
   :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
   :contentType string,
   :metadata {},
   :crc32c string,
   :owner {:entity string, :entityId string},
   :bucket string,
   :metageneration string}
  
  Updates an object's metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{:object :bucket}
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
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/delete
  
  Required parameters: object, bucket
  
  Optional parameters: generation, ifGenerationMatch, ifMetagenerationNotMatch, ifGenerationNotMatch, ifMetagenerationMatch, userProject, provisionalUserProject
  
  Deletes an object and its metadata. Deletions are permanent if versioning is not enabled for the bucket, or if the generation parameter is used."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}"
     #{:object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/getIamPolicy
  
  Required parameters: bucket, object
  
  Optional parameters: generation, provisionalUserProject, userProject
  
  Returns an IAM policy for the specified object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/cloud-platform.read-only"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_only"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:object :bucket})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{bucket}/o/{object}/iam"
     #{:object :bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/list
  
  Required parameters: bucket
  
  Optional parameters: startOffset, endOffset, prefix, pageToken, delimiter, userProject, includeTrailingDelimiter, provisionalUserProject, versions, projection, maxResults
  
  Retrieves a list of objects matching the criteria."
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
     "b/{bucket}/o"
     #{:bucket}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn rewrite$
  "https://developers.google.com/storage/docs/json_api/api/reference/rest/v1/objects/rewrite
  
  Required parameters: destinationBucket, sourceBucket, destinationObject, sourceObject
  
  Optional parameters: ifGenerationMatch, maxBytesRewrittenPerCall, ifMetagenerationNotMatch, rewriteToken, ifGenerationNotMatch, ifMetagenerationMatch, destinationPredefinedAcl, userProject, provisionalUserProject, ifSourceMetagenerationNotMatch, destinationKmsKeyName, sourceGeneration, ifSourceGenerationMatch, projection, ifSourceGenerationNotMatch, ifSourceMetagenerationMatch
  
  Body: 
  
  {:contentDisposition string,
   :storageClass string,
   :contentEncoding string,
   :generation string,
   :timeCreated string,
   :temporaryHold boolean,
   :eventBasedHold boolean,
   :updated string,
   :name string,
   :retentionExpirationTime string,
   :selfLink string,
   :contentLanguage string,
   :etag string,
   :size string,
   :md5Hash string,
   :cacheControl string,
   :timeStorageClassUpdated string,
   :timeDeleted string,
   :id string,
   :kind string,
   :mediaLink string,
   :kmsKeyName string,
   :componentCount integer,
   :acl [{:role string,
          :email string,
          :generation string,
          :projectTeam {:projectNumber string, :team string},
          :selfLink string,
          :etag string,
          :id string,
          :kind string,
          :domain string,
          :entity string,
          :entityId string,
          :object string,
          :bucket string}],
   :customerEncryption {:encryptionAlgorithm string, :keySha256 string},
   :contentType string,
   :metadata {},
   :crc32c string,
   :owner {:entity string, :entityId string},
   :bucket string,
   :metageneration string}
  
  Rewrites a source object to a destination object. Optionally overrides metadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/devstorage.full_control"
            "https://www.googleapis.com/auth/devstorage.read_write"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:destinationBucket
            :sourceBucket
            :destinationObject
            :sourceObject})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://storage.googleapis.com/storage/v1/"
     "b/{sourceBucket}/o/{sourceObject}/rewriteTo/b/{destinationBucket}/o/{destinationObject}"
     #{:destinationBucket
       :sourceBucket
       :destinationObject
       :sourceObject}
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
