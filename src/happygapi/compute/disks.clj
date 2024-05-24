(ns happygapi.compute.disks
  "Compute Engine API: disks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/disks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/get
  
  Required parameters: disk, project, zone
  
  Optional parameters: none
  
  Returns the specified persistent disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}"
     #{:disk :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn stopAsyncReplication$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/stopAsyncReplication
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Stops asynchronous replication. Can be invoked either on the primary or on the secondary disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/stopAsyncReplication"
     #{:disk :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/setIamPolicy
  
  Required parameters: project, resource, zone
  
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
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{resource}/setIamPolicy"
     #{:zone :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/insert
  
  Required parameters: project, zone
  
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
  
  Creates a persistent disk in the specified project using the data in the request. You can create a disk from a source (sourceImage, sourceSnapshot, or sourceDisk) or create an empty 500 GB data disk by omitting all properties. You can also create a disk that is larger than the default size by specifying the sizeGb property."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks"
     #{:zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/startAsyncReplication
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:asyncSecondaryDisk string}
  
  Starts asynchronous replication. Must be invoked on the primary disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/startAsyncReplication"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/testIamPermissions
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{resource}/testIamPermissions"
     #{:zone :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/createSnapshot
  
  Required parameters: disk, project, zone
  
  Optional parameters: guestFlush, requestId
  
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
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/createSnapshot"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/setLabels
  
  Required parameters: project, resource, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:labels {}, :labelFingerprint string}
  
  Sets the labels on a disk. To learn more about labels, read the Labeling Resources documentation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{resource}/setLabels"
     #{:zone :project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/aggregatedList
  
  Required parameters: project
  
  Optional parameters: filter, includeAllScopes, maxResults, orderBy, pageToken, returnPartialSuccess, serviceProjectNumber
  
  Retrieves an aggregated list of persistent disks. To prevent failure, Google recommends that you set the `returnPartialSuccess` parameter to `true`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/aggregated/disks"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/removeResourcePolicies
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Removes resource policies from a disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/removeResourcePolicies"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/stopGroupAsyncReplication
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicy string}
  
  Stops asynchronous replication for a consistency group of disks. Can be invoked either in the primary or secondary scope."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/stopGroupAsyncReplication"
     #{:zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/update
  
  Required parameters: disk, project, zone
  
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
  
  Updates the specified disk with the data included in the request. The update is performed only on selected fields included as part of update-mask. Only the following fields can be modified: user_license."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/delete
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Deletes the specified persistent disk. Deleting a disk removes its data permanently and is irreversible. However, deleting a disk does not delete any snapshots previously made from the disk. You must separately delete snapshots."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}"
     #{:disk :zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn resize$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/resize
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:sizeGb string}
  
  Resizes the specified persistent disk. You can only increase the size of the disk."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/resize"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/getIamPolicy
  
  Required parameters: project, resource, zone
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{resource}/getIamPolicy"
     #{:zone :project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn addResourcePolicies$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/addResourcePolicies
  
  Required parameters: disk, project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:resourcePolicies [string]}
  
  Adds existing resource policies to a disk. You can only add one policy which will be applied to this disk for scheduling snapshot creation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:disk :zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/{disk}/addResourcePolicies"
     #{:disk :zone :project}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/list
  
  Required parameters: project, zone
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of persistent disks contained within the specified zone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks"
     #{:zone :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bulkInsert$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/bulkInsert
  
  Required parameters: project, zone
  
  Optional parameters: requestId
  
  Body: 
  
  {:sourceConsistencyGroupPolicy string}
  
  Bulk create a set of disks."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:zone :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/zones/{zone}/disks/bulkInsert"
     #{:zone :project}
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
