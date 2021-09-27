(ns happygapi.compute.regionDisks
  "Compute Engine API: regionDisks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionDisks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/get
  
  Required parameters: region, project, disk
  
  Optional parameters: none
  
  Returns a specified regional persistent disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}"
     #{:disk :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/setIamPolicy
  
  Required parameters: resource, region, project
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :bindings [{:members [string],
               :condition Expr,
               :bindingId string,
               :role string}],
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :rules [Rule],
            :bindings [Binding]}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{resource}/setIamPolicy"
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/insert
  
  Required parameters: region, project
  
  Optional parameters: requestId, sourceImage
  
  Body: 
  
  {:description string,
   :labels {},
   :locationHint string,
   :sourceSnapshotEncryptionKey {:kmsKeyName string,
                                 :kmsKeyServiceAccount string,
                                 :sha256 string,
                                 :rawKey string,
                                 :rsaEncryptedKey string},
   :guestOsFeatures [{:type string}],
   :resourcePolicies [string],
   :sourceImage string,
   :sourceDiskId string,
   :creationTimestamp string,
   :sourceImageEncryptionKey {:kmsKeyName string,
                              :kmsKeyServiceAccount string,
                              :sha256 string,
                              :rawKey string,
                              :rsaEncryptedKey string},
   :zone string,
   :name string,
   :sizeGb string,
   :sourceDisk string,
   :physicalBlockSizeBytes string,
   :sourceImageId string,
   :lastDetachTimestamp string,
   :licenses [string],
   :selfLink string,
   :type string,
   :sourceSnapshot string,
   :region string,
   :lastAttachTimestamp string,
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :kind string,
   :sourceSnapshotId string,
   :sourceStorageObject string,
   :licenseCodes [string],
   :replicaZones [string],
   :options string,
   :diskEncryptionKey {:kmsKeyName string,
                       :kmsKeyServiceAccount string,
                       :sha256 string,
                       :rawKey string,
                       :rsaEncryptedKey string},
   :users [string],
   :labelFingerprint string,
   :provisionedIops string}
  
  Creates a persistent regional disk in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks"
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/testIamPermissions
  
  Required parameters: project, resource, region
  
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
     "projects/{project}/regions/{region}/disks/{resource}/testIamPermissions"
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

(defn createSnapshot$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/createSnapshot
  
  Required parameters: project, region, disk
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :autoCreated boolean,
   :locationHint string,
   :sourceDiskId string,
   :downloadBytes string,
   :creationTimestamp string,
   :chainName string,
   :name string,
   :sourceDisk string,
   :licenses [string],
   :selfLink string,
   :sourceDiskEncryptionKey {:kmsKeyName string,
                             :kmsKeyServiceAccount string,
                             :sha256 string,
                             :rawKey string,
                             :rsaEncryptedKey string},
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :kind string,
   :diskSizeGb string,
   :licenseCodes [string],
   :storageBytesStatus string,
   :snapshotEncryptionKey {:kmsKeyName string,
                           :kmsKeyServiceAccount string,
                           :sha256 string,
                           :rawKey string,
                           :rsaEncryptedKey string},
   :storageLocations [string],
   :storageBytes string,
   :labelFingerprint string}
  
  Creates a snapshot of this regional disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/createSnapshot"
     #{:disk :region :project}
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

(defn setLabels$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/setLabels
  
  Required parameters: project, region, resource
  
  Optional parameters: requestId
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
  Sets the labels on the target regional disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{resource}/setLabels"
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

(defn removeResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/removeResourcePolicies
  
  Required parameters: project, disk, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Removes resource policies from a regional disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/removeResourcePolicies"
     #{:disk :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/delete
  
  Required parameters: region, project, disk
  
  Optional parameters: requestId
  
  Deletes the specified regional persistent disk. Deleting a regional disk removes all the replicas of its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}"
     #{:disk :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/resize
  
  Required parameters: region, disk, project
  
  Optional parameters: requestId
  
  Body: 
  
  {:sizeGb string}
  
  Resizes the specified regional persistent disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/resize"
     #{:disk :region :project}
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

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/getIamPolicy
  
  Required parameters: project, resource, region
  
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
     "projects/{project}/regions/{region}/disks/{resource}/getIamPolicy"
     #{:region :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/addResourcePolicies
  
  Required parameters: project, region, disk
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Adds existing resource policies to a regional disk. You can only add one policy which will be applied to this disk for scheduling snapshot creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/addResourcePolicies"
     #{:disk :region :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/list
  
  Required parameters: region, project
  
  Optional parameters: maxResults, orderBy, pageToken, filter, returnPartialSuccess
  
  Retrieves the list of persistent disks contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
