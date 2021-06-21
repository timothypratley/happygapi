(ns happygapi.compute.disks
  "Compute Engine API: disks.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/api/reference/rest/v1/disks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/get
  
  Required parameters: disk, project, zone
  
  Optional parameters: none
  
  Returns a specified persistent disk. Gets a list of available persistent disks by making a list() request."
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

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/setIamPolicy
  
  Required parameters: project, resource, zone
  
  Optional parameters: none
  
  Body: 
  
  {:etag string,
   :policy {:rules [Rule],
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :iamOwned boolean,
            :version integer,
            :etag string},
   :bindings [{:condition Expr,
               :members [string],
               :bindingId string,
               :role string}]}
  
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
  
  Optional parameters: sourceImage, requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :locationHint string,
   :sourceSnapshotEncryptionKey {:kmsKeyName string,
                                 :rawKey string,
                                 :kmsKeyServiceAccount string,
                                 :sha256 string},
   :guestOsFeatures [{:type string}],
   :resourcePolicies [string],
   :sourceImage string,
   :sourceDiskId string,
   :creationTimestamp string,
   :sourceImageEncryptionKey {:kmsKeyName string,
                              :rawKey string,
                              :kmsKeyServiceAccount string,
                              :sha256 string},
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
                       :rawKey string,
                       :kmsKeyServiceAccount string,
                       :sha256 string},
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

(defn testIamPermissions$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/testIamPermissions
  
  Required parameters: zone, resource, project
  
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
  
  Required parameters: zone, project, disk
  
  Optional parameters: requestId, guestFlush
  
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
                             :rawKey string,
                             :kmsKeyServiceAccount string,
                             :sha256 string},
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :kind string,
   :diskSizeGb string,
   :licenseCodes [string],
   :storageBytesStatus string,
   :snapshotEncryptionKey {:kmsKeyName string,
                           :rawKey string,
                           :kmsKeyServiceAccount string,
                           :sha256 string},
   :storageLocations [string],
   :storageBytes string,
   :labelFingerprint string}
  
  Creates a snapshot of a specified persistent disk."
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
  
  Required parameters: project, zone, resource
  
  Optional parameters: requestId
  
  Body: 
  
  {:labelFingerprint string, :labels {}}
  
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
  
  Optional parameters: includeAllScopes, orderBy, returnPartialSuccess, filter, maxResults, pageToken
  
  Retrieves an aggregated list of persistent disks."
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
  
  Required parameters: disk, zone, project
  
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/disks/delete
  
  Required parameters: project, disk, zone
  
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
  
  Required parameters: zone, resource, project
  
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
  
  Required parameters: project, disk, zone
  
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
  
  Optional parameters: maxResults, orderBy, filter, pageToken, returnPartialSuccess
  
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
