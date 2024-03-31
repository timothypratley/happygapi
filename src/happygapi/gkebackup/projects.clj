(ns happygapi.gkebackup.projects
  "Backup for GKE API: projects.
  Backup for GKE is a managed Kubernetes workload backup and restore service for GKE clusters.
  See: https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}/locations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-delete$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-operations-cancel$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/operations/cancel
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Starts asynchronous cancellation on a long-running operation. The server makes a best effort to cancel the operation, but success is not guaranteed. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`. Clients can use Operations.GetOperation or other methods to check whether the cancellation succeeded or whether the operation completed despite cancellation. On successful cancellation, the operation is not deleted; instead, it becomes an operation with an Operation.error value with a google.rpc.Status.code of 1, corresponding to `Code.CANCELLED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}:cancel"
     #{:name}
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

(defn locations-backupPlans-create$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/create
  
  Required parameters: parent
  
  Optional parameters: backupPlanId
  
  Body: 
  
  {:description string,
   :backupSchedule {:cronSchedule string, :paused boolean},
   :labels {},
   :stateReason string,
   :deactivated boolean,
   :cluster string,
   :uid string,
   :name string,
   :protectedPodCount integer,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :backupConfig {:allNamespaces boolean,
                  :selectedNamespaces Namespaces,
                  :selectedApplications NamespacedNames,
                  :includeVolumeData boolean,
                  :includeSecrets boolean,
                  :encryptionKey EncryptionKey},
   :retentionPolicy {:backupDeleteLockDays integer,
                     :backupRetainDays integer,
                     :locked boolean}}
  
  Creates a new BackupPlan in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/backupPlans"
     #{:parent}
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

(defn locations-backupPlans-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists BackupPlans in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/backupPlans"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve the details of a single BackupPlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-patch$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :backupSchedule {:cronSchedule string, :paused boolean},
   :labels {},
   :stateReason string,
   :deactivated boolean,
   :cluster string,
   :uid string,
   :name string,
   :protectedPodCount integer,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :backupConfig {:allNamespaces boolean,
                  :selectedNamespaces Namespaces,
                  :selectedApplications NamespacedNames,
                  :includeVolumeData boolean,
                  :includeSecrets boolean,
                  :encryptionKey EncryptionKey},
   :retentionPolicy {:backupDeleteLockDays integer,
                     :backupRetainDays integer,
                     :locked boolean}}
  
  Update a BackupPlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-backupPlans-delete$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/delete
  
  Required parameters: name
  
  Optional parameters: etag
  
  Deletes an existing BackupPlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-backupPlans-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-backupPlans-backups-create$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId
  
  Body: 
  
  {:description string,
   :labels {},
   :stateReason string,
   :retainExpireTime string,
   :volumeCount integer,
   :containsVolumeData boolean,
   :podCount integer,
   :configBackupSizeBytes string,
   :uid string,
   :name string,
   :encryptionKey {:gcpKmsEncryptionKey string},
   :sizeBytes string,
   :clusterMetadata {:cluster string,
                     :k8sVersion string,
                     :backupCrdVersions {},
                     :gkeVersion string,
                     :anthosVersion string},
   :createTime string,
   :etag string,
   :state string,
   :resourceCount integer,
   :retainDays integer,
   :allNamespaces boolean,
   :deleteLockDays integer,
   :updateTime string,
   :manual boolean,
   :selectedApplications {:namespacedNames [NamespacedName]},
   :completeTime string,
   :selectedNamespaces {:namespaces [string]},
   :deleteLockExpireTime string,
   :containsSecrets boolean}
  
  Creates a Backup for the given BackupPlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/backups"
     #{:parent}
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

(defn locations-backupPlans-backups-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the Backups for a given BackupPlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/backups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve the details of a single Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-patch$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :stateReason string,
   :retainExpireTime string,
   :volumeCount integer,
   :containsVolumeData boolean,
   :podCount integer,
   :configBackupSizeBytes string,
   :uid string,
   :name string,
   :encryptionKey {:gcpKmsEncryptionKey string},
   :sizeBytes string,
   :clusterMetadata {:cluster string,
                     :k8sVersion string,
                     :backupCrdVersions {},
                     :gkeVersion string,
                     :anthosVersion string},
   :createTime string,
   :etag string,
   :state string,
   :resourceCount integer,
   :retainDays integer,
   :allNamespaces boolean,
   :deleteLockDays integer,
   :updateTime string,
   :manual boolean,
   :selectedApplications {:namespacedNames [NamespacedName]},
   :completeTime string,
   :selectedNamespaces {:namespaces [string]},
   :deleteLockExpireTime string,
   :containsSecrets boolean}
  
  Update a Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-backupPlans-backups-delete$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/delete
  
  Required parameters: name
  
  Optional parameters: etag, force
  
  Deletes an existing Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-backupPlans-backups-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-backupPlans-backups-volumeBackups-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/volumeBackups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the VolumeBackups for a given Backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/volumeBackups"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-volumeBackups-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/volumeBackups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve the details of a single VolumeBackup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-volumeBackups-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/volumeBackups/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-backupPlans-backups-volumeBackups-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/volumeBackups/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-backupPlans-backups-volumeBackups-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/backupPlans/backups/volumeBackups/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-restorePlans-create$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/create
  
  Required parameters: parent
  
  Optional parameters: restorePlanId
  
  Body: 
  
  {:description string,
   :labels {},
   :stateReason string,
   :cluster string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :backupPlan string,
   :restoreConfig {:substitutionRules [SubstitutionRule],
                   :clusterResourceRestoreScope ClusterResourceRestoreScope,
                   :noNamespaces boolean,
                   :namespacedResourceRestoreMode string,
                   :volumeDataRestorePolicy string,
                   :excludedNamespaces Namespaces,
                   :allNamespaces boolean,
                   :selectedApplications NamespacedNames,
                   :clusterResourceConflictPolicy string,
                   :transformationRules [TransformationRule],
                   :selectedNamespaces Namespaces}}
  
  Creates a new RestorePlan in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/restorePlans"
     #{:parent}
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

(defn locations-restorePlans-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists RestorePlans in a given location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/restorePlans"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve the details of a single RestorePlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-patch$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :stateReason string,
   :cluster string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :backupPlan string,
   :restoreConfig {:substitutionRules [SubstitutionRule],
                   :clusterResourceRestoreScope ClusterResourceRestoreScope,
                   :noNamespaces boolean,
                   :namespacedResourceRestoreMode string,
                   :volumeDataRestorePolicy string,
                   :excludedNamespaces Namespaces,
                   :allNamespaces boolean,
                   :selectedApplications NamespacedNames,
                   :clusterResourceConflictPolicy string,
                   :transformationRules [TransformationRule],
                   :selectedNamespaces Namespaces}}
  
  Update a RestorePlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-restorePlans-delete$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/delete
  
  Required parameters: name
  
  Optional parameters: etag, force
  
  Deletes an existing RestorePlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-restorePlans-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-restorePlans-restores-create$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/create
  
  Required parameters: parent
  
  Optional parameters: restoreId
  
  Body: 
  
  {:description string,
   :resourcesExcludedCount integer,
   :labels {},
   :stateReason string,
   :backup string,
   :resourcesRestoredCount integer,
   :cluster string,
   :volumesRestoredCount integer,
   :resourcesFailedCount integer,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :restoreConfig {:substitutionRules [SubstitutionRule],
                   :clusterResourceRestoreScope ClusterResourceRestoreScope,
                   :noNamespaces boolean,
                   :namespacedResourceRestoreMode string,
                   :volumeDataRestorePolicy string,
                   :excludedNamespaces Namespaces,
                   :allNamespaces boolean,
                   :selectedApplications NamespacedNames,
                   :clusterResourceConflictPolicy string,
                   :transformationRules [TransformationRule],
                   :selectedNamespaces Namespaces},
   :completeTime string}
  
  Creates a new Restore for the given RestorePlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/restores"
     #{:parent}
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

(defn locations-restorePlans-restores-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the Restores for a given RestorePlan."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/restores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves the details of a single Restore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-patch$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :resourcesExcludedCount integer,
   :labels {},
   :stateReason string,
   :backup string,
   :resourcesRestoredCount integer,
   :cluster string,
   :volumesRestoredCount integer,
   :resourcesFailedCount integer,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :updateTime string,
   :restoreConfig {:substitutionRules [SubstitutionRule],
                   :clusterResourceRestoreScope ClusterResourceRestoreScope,
                   :noNamespaces boolean,
                   :namespacedResourceRestoreMode string,
                   :volumeDataRestorePolicy string,
                   :excludedNamespaces Namespaces,
                   :allNamespaces boolean,
                   :selectedApplications NamespacedNames,
                   :clusterResourceConflictPolicy string,
                   :transformationRules [TransformationRule],
                   :selectedNamespaces Namespaces},
   :completeTime string}
  
  Update a Restore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn locations-restorePlans-restores-delete$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/delete
  
  Required parameters: name
  
  Optional parameters: etag, force
  
  Deletes an existing Restore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-restorePlans-restores-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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

(defn locations-restorePlans-restores-volumeRestores-list$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/volumeRestores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists the VolumeRestores for a given Restore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+parent}/volumeRestores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-volumeRestores-get$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/volumeRestores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieve the details of a single VolumeRestore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-volumeRestores-setIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/volumeRestores/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:setIamPolicy"
     #{:resource}
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

(defn locations-restorePlans-restores-volumeRestores-getIamPolicy$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/volumeRestores/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
     #{:resource}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-restorePlans-restores-volumeRestores-testIamPermissions$
  "https://cloud.google.com/kubernetes-engine/docs/add-on/backup-for-gkeapi/reference/rest/v1/projects/locations/restorePlans/restores/volumeRestores/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://gkebackup.googleapis.com/"
     "v1/{+resource}:testIamPermissions"
     #{:resource}
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
