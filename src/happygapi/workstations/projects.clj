(ns happygapi.workstations.projects
  "Cloud Workstations API: projects.
  Allows administrators to create managed developer environments in the cloud. 
  See: https://cloud.google.com/workstationsapi/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workstations.googleapis.com/"
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
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-get$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested workstation cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-list$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all workstation clusters in the specified location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstationClusters"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workstationClusters-create$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/create
  
  Required parameters: parent
  
  Optional parameters: workstationClusterId, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :controlPlaneIp string,
   :displayName string,
   :privateClusterConfig {:enablePrivateEndpoint boolean,
                          :clusterHostname string,
                          :serviceAttachmentUri string,
                          :allowedProjects [string]},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :domainConfig {:domain string},
   :conditions [{:code integer, :message string, :details [{}]}],
   :degraded boolean,
   :annotations {},
   :network string,
   :subnetwork string}
  
  Creates a new workstation cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstationClusters"
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

(defn locations-workstationClusters-patch$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly, allowMissing
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :controlPlaneIp string,
   :displayName string,
   :privateClusterConfig {:enablePrivateEndpoint boolean,
                          :clusterHostname string,
                          :serviceAttachmentUri string,
                          :allowedProjects [string]},
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :domainConfig {:domain string},
   :conditions [{:code integer, :message string, :details [{}]}],
   :degraded boolean,
   :annotations {},
   :network string,
   :subnetwork string}
  
  Updates an existing workstation cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-delete$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag, force
  
  Deletes the specified workstation cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-get$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested workstation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-setIamPolicy$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/setIamPolicy
  
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
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-listUsable$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/listUsable
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all workstation configurations in the specified cluster on which the caller has the \"workstations.workstation.create\" permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstationConfigs:listUsable"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workstationClusters-workstationConfigs-patch$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly, allowMissing
  
  Body: 
  
  {:runningTimeout string,
   :labels {},
   :deleteTime string,
   :persistentDirectories [{:gcePd GceRegionalPersistentDisk,
                            :mountPath string}],
   :ephemeralDirectories [{:gcePd GcePersistentDisk, :mountPath string}],
   :displayName string,
   :enableAuditAgent boolean,
   :uid string,
   :name string,
   :disableTcpConnections boolean,
   :encryptionKey {:kmsKey string, :kmsKeyServiceAccount string},
   :readinessChecks [{:path string, :port integer}],
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :host {:gceInstance GceInstance},
   :idleTimeout string,
   :conditions [{:code integer, :message string, :details [{}]}],
   :degraded boolean,
   :container {:image string,
               :command [string],
               :args [string],
               :env {},
               :workingDir string,
               :runAsUser integer},
   :annotations {},
   :replicaZones [string]}
  
  Updates an existing workstation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-testIamPermissions$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/testIamPermissions
  
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
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-create$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/create
  
  Required parameters: parent
  
  Optional parameters: workstationConfigId, validateOnly
  
  Body: 
  
  {:runningTimeout string,
   :labels {},
   :deleteTime string,
   :persistentDirectories [{:gcePd GceRegionalPersistentDisk,
                            :mountPath string}],
   :ephemeralDirectories [{:gcePd GcePersistentDisk, :mountPath string}],
   :displayName string,
   :enableAuditAgent boolean,
   :uid string,
   :name string,
   :disableTcpConnections boolean,
   :encryptionKey {:kmsKey string, :kmsKeyServiceAccount string},
   :readinessChecks [{:path string, :port integer}],
   :createTime string,
   :etag string,
   :updateTime string,
   :reconciling boolean,
   :host {:gceInstance GceInstance},
   :idleTimeout string,
   :conditions [{:code integer, :message string, :details [{}]}],
   :degraded boolean,
   :container {:image string,
               :command [string],
               :args [string],
               :env {},
               :workingDir string,
               :runAsUser integer},
   :annotations {},
   :replicaZones [string]}
  
  Creates a new workstation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstationConfigs"
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

(defn locations-workstationClusters-workstationConfigs-delete$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag, force
  
  Deletes the specified workstation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-getIamPolicy$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-list$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all workstation configurations in the specified cluster."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstationConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workstationClusters-workstationConfigs-workstations-get$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns the requested workstation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-setIamPolicy$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/setIamPolicy
  
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
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-listUsable$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/listUsable
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all workstations using the specified workstation configuration on which the caller has the \"workstations.workstations.use\" permission."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstations:listUsable"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-workstationClusters-workstationConfigs-workstations-patch$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, validateOnly, allowMissing
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :startTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :env {},
   :updateTime string,
   :reconciling boolean,
   :host string,
   :kmsKey string,
   :annotations {}}
  
  Updates an existing workstation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-testIamPermissions$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/testIamPermissions
  
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
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-create$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/create
  
  Required parameters: parent
  
  Optional parameters: workstationId, validateOnly
  
  Body: 
  
  {:labels {},
   :deleteTime string,
   :startTime string,
   :displayName string,
   :uid string,
   :name string,
   :createTime string,
   :etag string,
   :state string,
   :env {},
   :updateTime string,
   :reconciling boolean,
   :host string,
   :kmsKey string,
   :annotations {}}
  
  Creates a new workstation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstations"
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

(defn locations-workstationClusters-workstationConfigs-workstations-start$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean, :etag string}
  
  Starts running a workstation so that users can connect to it."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+name}:start"
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

(defn locations-workstationClusters-workstationConfigs-workstations-delete$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/delete
  
  Required parameters: name
  
  Optional parameters: validateOnly, etag
  
  Deletes the specified workstation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-generateAccessToken$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/generateAccessToken
  
  Required parameters: workstation
  
  Optional parameters: none
  
  Body: 
  
  {:expireTime string, :ttl string}
  
  Returns a short-lived credential that can be used to send authenticated and authorized traffic to a workstation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:workstation})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+workstation}:generateAccessToken"
     #{:workstation}
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

(defn locations-workstationClusters-workstationConfigs-workstations-getIamPolicy$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
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

(defn locations-workstationClusters-workstationConfigs-workstations-stop$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean, :etag string}
  
  Stops running a workstation, reducing costs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+name}:stop"
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

(defn locations-workstationClusters-workstationConfigs-workstations-list$
  "https://cloud.google.com/workstationsapi/reference/rest/v1/projects/locations/workstationClusters/workstationConfigs/workstations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns all Workstations using the specified workstation configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://workstations.googleapis.com/"
     "v1/{+parent}/workstations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
