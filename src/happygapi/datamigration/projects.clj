(ns happygapi.datamigration.projects
  "Database Migration API: projects.
  Manage Cloud Database Migration Service resources on Google Cloud Platform.
  See: https://cloud.google.com/database-migration/api/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Retrieve a list of all connection profiles in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/connectionProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connectionProfiles-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/create
  
  Required parameters: parent
  
  Optional parameters: connectionProfileId, requestId
  
  Body: 
  
  {:labels {},
   :postgresql {:passwordSet boolean,
                :password string,
                :ssl SslConfig,
                :username string,
                :cloudSqlId string,
                :host string,
                :port integer},
   :displayName string,
   :name string,
   :createTime string,
   :cloudsql {:privateIp string,
              :cloudSqlId string,
              :settings CloudSqlSettings,
              :publicIp string},
   :state string,
   :updateTime string,
   :error {:details [{}], :message string, :code integer},
   :provider string,
   :mysql {:port integer,
           :host string,
           :password string,
           :ssl SslConfig,
           :passwordSet boolean,
           :cloudSqlId string,
           :username string}}
  
  Creates a new connection profile in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/connectionProfiles"
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

(defn locations-connectionProfiles-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a single Database Migration Service connection profile. A connection profile can only be deleted if it is not in use by any active migration jobs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/testIamPermissions
  
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
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-patch$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/patch
  
  Required parameters: name
  
  Optional parameters: requestId, updateMask
  
  Body: 
  
  {:labels {},
   :postgresql {:passwordSet boolean,
                :password string,
                :ssl SslConfig,
                :username string,
                :cloudSqlId string,
                :host string,
                :port integer},
   :displayName string,
   :name string,
   :createTime string,
   :cloudsql {:privateIp string,
              :cloudSqlId string,
              :settings CloudSqlSettings,
              :publicIp string},
   :state string,
   :updateTime string,
   :error {:details [{}], :message string, :code integer},
   :provider string,
   :mysql {:port integer,
           :host string,
           :password string,
           :ssl SslConfig,
           :passwordSet boolean,
           :cloudSqlId string,
           :username string}}
  
  Update the configuration of a single connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-connectionProfiles-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/connectionProfiles/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets details of a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-setIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :policy {:etag string,
            :auditConfigs [AuditConfig],
            :bindings [Binding],
            :version integer}}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-restart$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/restart
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Restart a stopped or failed migration job, resetting the destination instance to its original state and starting the migration process from scratch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:restart"
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

(defn locations-migrationJobs-patch$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId
  
  Body: 
  
  {:labels {},
   :reverseSshConnectivity {:vmPort integer,
                            :vmIp string,
                            :vpc string,
                            :vm string},
   :destinationDatabase {:provider string, :engine string},
   :dumpPath string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :phase string,
   :type string,
   :staticIpConnectivity {},
   :duration string,
   :state string,
   :source string,
   :updateTime string,
   :error {:details [{}], :message string, :code integer},
   :sourceDatabase {:provider string, :engine string},
   :vpcPeeringConnectivity {:vpc string},
   :destination string}
  
  Updates the parameters of a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-testIamPermissions$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/testIamPermissions
  
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
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-generateSshScript$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/generateSshScript
  
  Required parameters: migrationJob
  
  Optional parameters: none
  
  Body: 
  
  {:vmSelectionConfig {:vmZone string},
   :vmPort integer,
   :vm string,
   :vmCreationConfig {:vmMachineType string,
                      :subnet string,
                      :vmZone string}}
  
  Generate a SSH configuration script to configure the reverse SSH connectivity."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:migrationJob})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+migrationJob}:generateSshScript"
     #{:migrationJob}
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

(defn locations-migrationJobs-create$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/create
  
  Required parameters: parent
  
  Optional parameters: migrationJobId, requestId
  
  Body: 
  
  {:labels {},
   :reverseSshConnectivity {:vmPort integer,
                            :vmIp string,
                            :vpc string,
                            :vm string},
   :destinationDatabase {:provider string, :engine string},
   :dumpPath string,
   :displayName string,
   :name string,
   :endTime string,
   :createTime string,
   :phase string,
   :type string,
   :staticIpConnectivity {},
   :duration string,
   :state string,
   :source string,
   :updateTime string,
   :error {:details [{}], :message string, :code integer},
   :sourceDatabase {:provider string, :engine string},
   :vpcPeeringConnectivity {:vpc string},
   :destination string}
  
  Creates a new migration job in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/migrationJobs"
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

(defn locations-migrationJobs-start$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/start
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Start an already created migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Deletes a single migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-getIamPolicy$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: options.requestedPolicyVersion
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-stop$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/stop
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops a running migration job."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-migrationJobs-list$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/list
  
  Required parameters: parent
  
  Optional parameters: orderBy, filter, pageToken, pageSize
  
  Lists migration jobs in a given project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+parent}/migrationJobs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-migrationJobs-verify$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/verify
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Verify a migration job, making sure the destination can reach the source and that all configuration and prerequisites are met."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:verify"
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

(defn locations-migrationJobs-resume$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resume a migration job that is currently stopped and is resumable (was stopped during CDC phase)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:resume"
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

(defn locations-migrationJobs-promote$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/migrationJobs/promote
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Promote a migration job, stopping replication to the destination and promoting the destination to be a standalone database."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datamigration.googleapis.com/"
     "v1/{+name}:promote"
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

(defn locations-operations-get$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datamigration.googleapis.com/"
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

(defn locations-operations-delete$
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datamigration.googleapis.com/"
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
  "https://cloud.google.com/database-migration/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://datamigration.googleapis.com/"
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
