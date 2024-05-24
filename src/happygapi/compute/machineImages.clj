(ns happygapi.compute.machineImages
  "Compute Engine API: machineImages.
  Creates and runs virtual machines on Google Cloud Platform. 
  See: https://cloud.google.com/compute/docs/reference/rest/v1/machineImages"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/list
  
  Required parameters: project
  
  Optional parameters: filter, maxResults, orderBy, pageToken, returnPartialSuccess
  
  Retrieves a list of machine images that are contained within the specified project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages"
     #{:project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/get
  
  Required parameters: machineImage, project
  
  Optional parameters: none
  
  Returns the specified machine image."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:machineImage :project})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages/{machineImage}"
     #{:machineImage :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/insert
  
  Required parameters: project
  
  Optional parameters: requestId, sourceInstance
  
  Body: 
  
  {:description string,
   :sourceInstanceProperties {:description string,
                              :tags Tags,
                              :labels {},
                              :scheduling Scheduling,
                              :canIpForward boolean,
                              :guestAccelerators [AcceleratorConfig],
                              :machineType string,
                              :keyRevocationActionType string,
                              :disks [SavedAttachedDisk],
                              :networkInterfaces [NetworkInterface],
                              :deletionProtection boolean,
                              :metadata Metadata,
                              :serviceAccounts [ServiceAccount],
                              :minCpuPlatform string},
   :sourceInstance string,
   :totalStorageBytes string,
   :creationTimestamp string,
   :guestFlush boolean,
   :satisfiesPzi boolean,
   :instanceProperties {:description string,
                        :tags Tags,
                        :labels {},
                        :shieldedInstanceConfig ShieldedInstanceConfig,
                        :scheduling Scheduling,
                        :resourcePolicies [string],
                        :privateIpv6GoogleAccess string,
                        :canIpForward boolean,
                        :resourceManagerTags {},
                        :guestAccelerators [AcceleratorConfig],
                        :networkPerformanceConfig NetworkPerformanceConfig,
                        :machineType string,
                        :confidentialInstanceConfig ConfidentialInstanceConfig,
                        :keyRevocationActionType string,
                        :advancedMachineFeatures AdvancedMachineFeatures,
                        :disks [AttachedDisk],
                        :reservationAffinity ReservationAffinity,
                        :networkInterfaces [NetworkInterface],
                        :metadata Metadata,
                        :serviceAccounts [ServiceAccount],
                        :minCpuPlatform string},
   :name string,
   :savedDisks [{:kind string,
                 :sourceDisk string,
                 :storageBytes string,
                 :storageBytesStatus string,
                 :architecture string}],
   :selfLink string,
   :machineImageEncryptionKey {:rawKey string,
                               :rsaEncryptedKey string,
                               :kmsKeyName string,
                               :sha256 string,
                               :kmsKeyServiceAccount string},
   :satisfiesPzs boolean,
   :status string,
   :id string,
   :kind string,
   :storageLocations [string],
   :sourceDiskEncryptionKeys [{:sourceDisk string,
                               :diskEncryptionKey CustomerEncryptionKey}]}
  
  Creates a machine image in the specified project using the data that is included in the request. If you are creating a new machine image to update an existing instance, your new machine image should use the same network or, if applicable, the same subnetwork as the original instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages"
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

(defn delete$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/delete
  
  Required parameters: machineImage, project
  
  Optional parameters: requestId
  
  Deletes the specified machine image. Deleting a machine image is permanent and cannot be undone."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:machineImage :project})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages/{machineImage}"
     #{:machineImage :project}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/getIamPolicy
  
  Required parameters: project, resource
  
  Optional parameters: optionsRequestedPolicyVersion
  
  Gets the access control policy for a resource. May be empty if no such policy or resource exists."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages/{resource}/getIamPolicy"
     #{:project :resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setIamPolicy$
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/setIamPolicy
  
  Required parameters: project, resource
  
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
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages/{resource}/setIamPolicy"
     #{:project :resource}
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
  "https://cloud.google.com/compute/api/reference/rest/v1/machineImages/testIamPermissions
  
  Required parameters: project, resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/compute"
            "https://www.googleapis.com/auth/compute.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:project :resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://compute.googleapis.com/compute/v1/"
     "projects/{project}/global/machineImages/{resource}/testIamPermissions"
     #{:project :resource}
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
