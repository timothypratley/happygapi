(ns happygapi.file.projects
  "Cloud Filestore API: projects.
  The Cloud Filestore API is used for creating and managing cloud file servers.
  See: https://cloud.google.com/filestore/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, includeUnrevealedLocations, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://file.googleapis.com/"
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
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://file.googleapis.com/"
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

(defn locations-instances-list$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists all instances in a project for either a specified location or for all locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+parent}/instances"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-get$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a specific instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-instances-create$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/create
  
  Required parameters: parent
  
  Optional parameters: instanceId
  
  Body: 
  
  {:description string,
   :labels {},
   :tier string,
   :fileShares [{:name string,
                 :capacityGb string,
                 :sourceBackup string,
                 :nfsExportOptions [NfsExportOptions]}],
   :satisfiesPzi boolean,
   :name string,
   :statusMessage string,
   :createTime string,
   :etag string,
   :state string,
   :suspensionReasons [string],
   :networks [{:network string,
               :modes [string],
               :reservedIpRange string,
               :ipAddresses [string],
               :connectMode string}],
   :satisfiesPzs boolean,
   :kmsKeyName string}
  
  Creates an instance. When creating from a backup, the capacity of the new instance needs to be equal to or larger than the capacity of the backup (and also equal to or larger than the minimum capacity of the tier)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+parent}/instances"
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

(defn locations-instances-patch$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :tier string,
   :fileShares [{:name string,
                 :capacityGb string,
                 :sourceBackup string,
                 :nfsExportOptions [NfsExportOptions]}],
   :satisfiesPzi boolean,
   :name string,
   :statusMessage string,
   :createTime string,
   :etag string,
   :state string,
   :suspensionReasons [string],
   :networks [{:network string,
               :modes [string],
               :reservedIpRange string,
               :ipAddresses [string],
               :connectMode string}],
   :satisfiesPzs boolean,
   :kmsKeyName string}
  
  Updates the settings of a specific instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-instances-restore$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/restore
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:fileShare string, :sourceBackup string}
  
  Restores an existing instance's file share from a backup. The capacity of the instance needs to be equal to or larger than the capacity of the backup (and also equal to or larger than the minimum capacity of the tier)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+name}:restore"
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

(defn locations-instances-revert$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/revert
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:targetSnapshotId string}
  
  Revert an existing instance's file system to a specified snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+name}:revert"
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

(defn locations-instances-delete$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/delete
  
  Required parameters: name
  
  Optional parameters: force
  
  Deletes an instance."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-instances-snapshots-list$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/snapshots/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists all snapshots in a project for either a specified location or for all locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+parent}/snapshots"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-instances-snapshots-get$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/snapshots/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a specific snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-instances-snapshots-create$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/snapshots/create
  
  Required parameters: parent
  
  Optional parameters: snapshotId
  
  Body: 
  
  {:name string,
   :description string,
   :state string,
   :createTime string,
   :labels {},
   :filesystemUsedBytes string}
  
  Creates a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://file.googleapis.com/"
     "v1/{+parent}/snapshots"
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

(defn locations-instances-snapshots-delete$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/snapshots/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-instances-snapshots-patch$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/instances/snapshots/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :description string,
   :state string,
   :createTime string,
   :labels {},
   :filesystemUsedBytes string}
  
  Updates the settings of a specific snapshot."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-backups-list$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/backups/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists all backups in a project for either a specified location or for all locations."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-backups-get$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/backups/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the details of a specific backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-backups-create$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/backups/create
  
  Required parameters: parent
  
  Optional parameters: backupId
  
  Body: 
  
  {:description string,
   :labels {},
   :sourceInstance string,
   :downloadBytes string,
   :satisfiesPzi boolean,
   :name string,
   :createTime string,
   :state string,
   :satisfiesPzs boolean,
   :sourceInstanceTier string,
   :sourceFileShare string,
   :kmsKey string,
   :storageBytes string,
   :capacityGb string}
  
  Creates a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-backups-delete$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/backups/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://file.googleapis.com/"
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

(defn locations-backups-patch$
  "https://cloud.google.com/filestore/api/reference/rest/v1/projects/locations/backups/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :labels {},
   :sourceInstance string,
   :downloadBytes string,
   :satisfiesPzi boolean,
   :name string,
   :createTime string,
   :state string,
   :satisfiesPzs boolean,
   :sourceInstanceTier string,
   :sourceFileShare string,
   :kmsKey string,
   :storageBytes string,
   :capacityGb string}
  
  Updates the settings of a specific backup."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://file.googleapis.com/"
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
