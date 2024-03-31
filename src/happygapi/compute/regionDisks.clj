(ns happygapi.compute.regionDisks
  "Compute Engine API: regionDisks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/regionDisks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/get
  
  Required parameters: disk, project, region
  
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

(defn stopAsyncReplication$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/stopAsyncReplication
  
  Required parameters: disk, project, region
  
  Optional parameters: requestId
  
  Stops asynchronous replication. Can be invoked either on the primary or on the secondary disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/stopAsyncReplication"
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
  
  Required parameters: project, region
  
  Optional parameters: requestId, sourceImage
  
  Body: 
  
  {:description string,
   :provisionedThroughput string,
   :labels {},
   :locationHint string,
   :sourceSnapshotEncryptionKey {:rawKey string,
                                 :rsaEncryptedKey string,
                                 :kmsKeyName string,
                                 :sha256 string,
                                 :kmsKeyServiceAccount string},
   :guestOsFeatures [{:type string}],
   :resourcePolicies [string],
   :sourceImage string,
   :sourceConsistencyGroupPolicyId string,
   :sourceDiskId string,
   :architecture string,
   :creationTimestamp string,
   :resourceStatus {:asyncPrimaryDisk DiskResourceStatusAsyncReplicationStatus,
                    :asyncSecondaryDisks {}},
   :satisfiesPzi boolean,
   :sourceImageEncryptionKey {:rawKey string,
                              :rsaEncryptedKey string,
                              :kmsKeyName string,
                              :sha256 string,
                              :kmsKeyServiceAccount string},
   :zone string,
   :name string,
   :sizeGb string,
   :storagePool string,
   :sourceDisk string,
   :physicalBlockSizeBytes string,
   :sourceImageId string,
   :lastDetachTimestamp string,
   :params {:resourceManagerTags {}},
   :licenses [string],
   :selfLink string,
   :type string,
   :sourceSnapshot string,
   :sourceInstantSnapshot string,
   :region string,
   :lastAttachTimestamp string,
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :asyncPrimaryDisk {:disk string,
                      :diskId string,
                      :consistencyGroupPolicy string,
                      :consistencyGroupPolicyId string},
   :sourceInstantSnapshotId string,
   :kind string,
   :sourceSnapshotId string,
   :sourceStorageObject string,
   :asyncSecondaryDisks {},
   :licenseCodes [string],
   :replicaZones [string],
   :options string,
   :diskEncryptionKey {:rawKey string,
                       :rsaEncryptedKey string,
                       :kmsKeyName string,
                       :sha256 string,
                       :kmsKeyServiceAccount string},
   :enableConfidentialCompute boolean,
   :sourceConsistencyGroupPolicy string,
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

(defn startAsyncReplication$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/startAsyncReplication
  
  Required parameters: disk, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:asyncSecondaryDisk string}
  
  Starts asynchronous replication. Must be invoked on the primary disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}/startAsyncReplication"
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/testIamPermissions
  
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
  
  Required parameters: disk, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :autoCreated boolean,
   :snapshotType string,
   :locationHint string,
   :guestOsFeatures [{:type string}],
   :sourceDiskId string,
   :architecture string,
   :downloadBytes string,
   :creationTimestamp string,
   :chainName string,
   :satisfiesPzi boolean,
   :name string,
   :sourceDiskForRecoveryCheckpoint string,
   :sourceDisk string,
   :sourceSnapshotSchedulePolicy string,
   :licenses [string],
   :selfLink string,
   :sourceInstantSnapshot string,
   :sourceDiskEncryptionKey {:rawKey string,
                             :rsaEncryptedKey string,
                             :kmsKeyName string,
                             :sha256 string,
                             :kmsKeyServiceAccount string},
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :sourceInstantSnapshotId string,
   :kind string,
   :sourceInstantSnapshotEncryptionKey {:rawKey string,
                                        :rsaEncryptedKey string,
                                        :kmsKeyName string,
                                        :sha256 string,
                                        :kmsKeyServiceAccount string},
   :diskSizeGb string,
   :licenseCodes [string],
   :storageBytesStatus string,
   :snapshotEncryptionKey {:rawKey string,
                           :rsaEncryptedKey string,
                           :kmsKeyName string,
                           :sha256 string,
                           :kmsKeyServiceAccount string},
   :creationSizeBytes string,
   :storageLocations [string],
   :storageBytes string,
   :enableConfidentialCompute boolean,
   :labelFingerprint string,
   :sourceSnapshotSchedulePolicyId string}
  
  Creates a snapshot of a specified persistent disk. For regular snapshot creation, consider using snapshots.insert instead, as that method supports more features, such as creating snapshots in a project different from the source disk project."
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
  
  {:labels {}, :labelFingerprint string}
  
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
  
  Required parameters: disk, project, region
  
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

(defn stopGroupAsyncReplication$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/stopGroupAsyncReplication
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicy string}
  
  Stops asynchronous replication for a consistency group of disks. Can be invoked either in the primary or secondary scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/stopGroupAsyncReplication"
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

(defn update$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/update
  
  Required parameters: disk, project, region
  
  Optional parameters: paths, requestId, updateMask
  
  Body: 
  
  {:description string,
   :provisionedThroughput string,
   :labels {},
   :locationHint string,
   :sourceSnapshotEncryptionKey {:rawKey string,
                                 :rsaEncryptedKey string,
                                 :kmsKeyName string,
                                 :sha256 string,
                                 :kmsKeyServiceAccount string},
   :guestOsFeatures [{:type string}],
   :resourcePolicies [string],
   :sourceImage string,
   :sourceConsistencyGroupPolicyId string,
   :sourceDiskId string,
   :architecture string,
   :creationTimestamp string,
   :resourceStatus {:asyncPrimaryDisk DiskResourceStatusAsyncReplicationStatus,
                    :asyncSecondaryDisks {}},
   :satisfiesPzi boolean,
   :sourceImageEncryptionKey {:rawKey string,
                              :rsaEncryptedKey string,
                              :kmsKeyName string,
                              :sha256 string,
                              :kmsKeyServiceAccount string},
   :zone string,
   :name string,
   :sizeGb string,
   :storagePool string,
   :sourceDisk string,
   :physicalBlockSizeBytes string,
   :sourceImageId string,
   :lastDetachTimestamp string,
   :params {:resourceManagerTags {}},
   :licenses [string],
   :selfLink string,
   :type string,
   :sourceSnapshot string,
   :sourceInstantSnapshot string,
   :region string,
   :lastAttachTimestamp string,
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :asyncPrimaryDisk {:disk string,
                      :diskId string,
                      :consistencyGroupPolicy string,
                      :consistencyGroupPolicyId string},
   :sourceInstantSnapshotId string,
   :kind string,
   :sourceSnapshotId string,
   :sourceStorageObject string,
   :asyncSecondaryDisks {},
   :licenseCodes [string],
   :replicaZones [string],
   :options string,
   :diskEncryptionKey {:rawKey string,
                       :rsaEncryptedKey string,
                       :kmsKeyName string,
                       :sha256 string,
                       :kmsKeyServiceAccount string},
   :enableConfidentialCompute boolean,
   :sourceConsistencyGroupPolicy string,
   :users [string],
   :labelFingerprint string,
   :provisionedIops string}
  
  Update the specified disk with the data included in the request. Update is performed only on selected fields included as part of update-mask. Only the following fields can be modified: user_license."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :region :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/{disk}"
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
  
  Required parameters: disk, project, region
  
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
  
  Required parameters: disk, project, region
  
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
  
  Required parameters: disk, project, region
  
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
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
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

(defn bulkInsert$
  "https://cloud.google.com/compute/api/reference/rest/v1/regionDisks/bulkInsert
  
  Required parameters: project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:sourceConsistencyGroupPolicy string}
  
  Bulk create a set of disks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/regions/{region}/disks/bulkInsert"
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
