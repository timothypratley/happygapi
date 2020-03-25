(ns happygapi.compute.regionDisks
  "Compute Engine API: regionDisks.
  Creates and runs virtual machines on Google Cloud Platform.
  See: https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/get
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}"
     #{:disk :region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/insert
  
  Required parameters: project, region
  
  Optional parameters: requestId, sourceImage
  
  Body: 
  
  {:description string,
   :labels {},
   :sourceSnapshotEncryptionKey {:kmsKeyName string,
                                 :kmsKeyServiceAccount string,
                                 :rawKey string,
                                 :sha256 string},
   :guestOsFeatures [{:type string}],
   :resourcePolicies [string],
   :sourceImage string,
   :creationTimestamp string,
   :sourceImageEncryptionKey {:kmsKeyName string,
                              :kmsKeyServiceAccount string,
                              :rawKey string,
                              :sha256 string},
   :zone string,
   :name string,
   :sizeGb string,
   :physicalBlockSizeBytes string,
   :sourceImageId string,
   :lastDetachTimestamp string,
   :licenses [string],
   :selfLink string,
   :type string,
   :sourceSnapshot string,
   :region string,
   :lastAttachTimestamp string,
   :status string,
   :id string,
   :kind string,
   :sourceSnapshotId string,
   :licenseCodes [string],
   :replicaZones [string],
   :options string,
   :diskEncryptionKey {:kmsKeyName string,
                       :kmsKeyServiceAccount string,
                       :rawKey string,
                       :sha256 string},
   :users [string],
   :labelFingerprint string}
  
  Creates a persistent regional disk in the specified project using the data included in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/testIamPermissions
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{resource}/testIamPermissions"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/createSnapshot
  
  Required parameters: disk, project, region
  
  Optional parameters: requestId
  
  Body: 
  
  {:description string,
   :labels {},
   :autoCreated boolean,
   :sourceDiskId string,
   :downloadBytes string,
   :creationTimestamp string,
   :name string,
   :sourceDisk string,
   :licenses [string],
   :selfLink string,
   :sourceDiskEncryptionKey {:kmsKeyName string,
                             :kmsKeyServiceAccount string,
                             :rawKey string,
                             :sha256 string},
   :status string,
   :id string,
   :kind string,
   :diskSizeGb string,
   :licenseCodes [string],
   :storageBytesStatus string,
   :snapshotEncryptionKey {:kmsKeyName string,
                           :kmsKeyServiceAccount string,
                           :rawKey string,
                           :sha256 string},
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}/createSnapshot"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/setLabels
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{resource}/setLabels"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/removeResourcePolicies
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}/removeResourcePolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/delete
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/resize
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}/resize"
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

(defn addResourcePolicies$
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/addResourcePolicies
  
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
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks/{disk}/addResourcePolicies"
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
  "https://developers.google.com/compute/docs/reference/latest/api/reference/rest/v1/regionDisks/list
  
  Required parameters: project, region
  
  Optional parameters: filter, maxResults, orderBy, pageToken
  
  Retrieves the list of persistent disks contained within the specified region."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:region :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/projects/"
     "{project}/regions/{region}/disks"
     #{:region :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
