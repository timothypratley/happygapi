(ns happygapi.datastream.projects
  "Datastream API: projects.
  
  See: https://cloud.google.com/datastream/docs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-fetchStaticIps$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/fetchStaticIps
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken
  
  The FetchStaticIps API call exposes the static IP addresses used by Datastream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+name}:fetchStaticIps"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists information about the supported locations for this service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets information about a location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/operations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a long-running operation. This method indicates that the client is no longer interested in the operation result. It does not cancel the operation. If the server doesn't support this method, it returns `google.rpc.Code.UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastream.googleapis.com/"
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
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/operations/cancel
  
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
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Use this method to list connection profiles created in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-get$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Use this method to get details about a connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-create$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/create
  
  Required parameters: parent
  
  Optional parameters: connectionProfileId, requestId, validateOnly, force
  
  Body: 
  
  {:labels {},
   :privateConnectivity {:privateConnection string},
   :bigqueryProfile {},
   :displayName string,
   :name string,
   :createTime string,
   :gcsProfile {:bucket string, :rootPath string},
   :forwardSshConnectivity {:hostname string,
                            :username string,
                            :port integer,
                            :password string,
                            :privateKey string},
   :mysqlProfile {:hostname string,
                  :port integer,
                  :username string,
                  :password string,
                  :sslConfig MysqlSslConfig},
   :updateTime string,
   :oracleProfile {:hostname string,
                   :port integer,
                   :username string,
                   :password string,
                   :databaseService string,
                   :connectionAttributes {},
                   :oracleSslConfig OracleSslConfig},
   :staticServiceIpConnectivity {},
   :sqlServerProfile {:hostname string,
                      :port integer,
                      :username string,
                      :password string,
                      :database string},
   :postgresqlProfile {:hostname string,
                       :port integer,
                       :username string,
                       :password string,
                       :database string}}
  
  Use this method to create a connection profile in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-patch$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, force
  
  Body: 
  
  {:labels {},
   :privateConnectivity {:privateConnection string},
   :bigqueryProfile {},
   :displayName string,
   :name string,
   :createTime string,
   :gcsProfile {:bucket string, :rootPath string},
   :forwardSshConnectivity {:hostname string,
                            :username string,
                            :port integer,
                            :password string,
                            :privateKey string},
   :mysqlProfile {:hostname string,
                  :port integer,
                  :username string,
                  :password string,
                  :sslConfig MysqlSslConfig},
   :updateTime string,
   :oracleProfile {:hostname string,
                   :port integer,
                   :username string,
                   :password string,
                   :databaseService string,
                   :connectionAttributes {},
                   :oracleSslConfig OracleSslConfig},
   :staticServiceIpConnectivity {},
   :sqlServerProfile {:hostname string,
                      :port integer,
                      :username string,
                      :password string,
                      :database string},
   :postgresqlProfile {:hostname string,
                       :port integer,
                       :username string,
                       :password string,
                       :database string}}
  
  Use this method to update the parameters of a connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-delete$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Use this method to delete a connection profile."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-connectionProfiles-discover$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/connectionProfiles/discover
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:connectionProfile {:labels {},
                       :privateConnectivity PrivateConnectivity,
                       :bigqueryProfile BigQueryProfile,
                       :displayName string,
                       :name string,
                       :createTime string,
                       :gcsProfile GcsProfile,
                       :forwardSshConnectivity ForwardSshTunnelConnectivity,
                       :mysqlProfile MysqlProfile,
                       :updateTime string,
                       :oracleProfile OracleProfile,
                       :staticServiceIpConnectivity StaticServiceIpConnectivity,
                       :sqlServerProfile SqlServerProfile,
                       :postgresqlProfile PostgresqlProfile},
   :connectionProfileName string,
   :fullHierarchy boolean,
   :hierarchyDepth integer,
   :oracleRdbms {:oracleSchemas [OracleSchema]},
   :mysqlRdbms {:mysqlDatabases [MysqlDatabase]},
   :postgresqlRdbms {:postgresqlSchemas [PostgresqlSchema]}}
  
  Use this method to discover a connection profile. The discover API call exposes the data objects and metadata belonging to the profile. Typically, a request returns children data objects of a parent data object that's optionally supplied in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/connectionProfiles:discover"
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

(defn locations-streams-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Use this method to list streams in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/streams"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-streams-get$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Use this method to get details about a stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-streams-create$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/create
  
  Required parameters: parent
  
  Optional parameters: streamId, requestId, validateOnly, force
  
  Body: 
  
  {:labels {},
   :errors [{:reason string,
             :errorUuid string,
             :message string,
             :errorTime string,
             :details {}}],
   :lastRecoveryTime string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :backfillNone {},
   :customerManagedEncryptionKey string,
   :backfillAll {:oracleExcludedObjects OracleRdbms,
                 :mysqlExcludedObjects MysqlRdbms,
                 :postgresqlExcludedObjects PostgresqlRdbms,
                 :sqlServerExcludedObjects SqlServerRdbms},
   :sourceConfig {:sourceConnectionProfile string,
                  :oracleSourceConfig OracleSourceConfig,
                  :mysqlSourceConfig MysqlSourceConfig,
                  :postgresqlSourceConfig PostgresqlSourceConfig,
                  :sqlServerSourceConfig SqlServerSourceConfig},
   :destinationConfig {:destinationConnectionProfile string,
                       :gcsDestinationConfig GcsDestinationConfig,
                       :bigqueryDestinationConfig BigQueryDestinationConfig}}
  
  Use this method to create a stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/streams"
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

(defn locations-streams-patch$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, requestId, validateOnly, force
  
  Body: 
  
  {:labels {},
   :errors [{:reason string,
             :errorUuid string,
             :message string,
             :errorTime string,
             :details {}}],
   :lastRecoveryTime string,
   :displayName string,
   :name string,
   :createTime string,
   :state string,
   :updateTime string,
   :backfillNone {},
   :customerManagedEncryptionKey string,
   :backfillAll {:oracleExcludedObjects OracleRdbms,
                 :mysqlExcludedObjects MysqlRdbms,
                 :postgresqlExcludedObjects PostgresqlRdbms,
                 :sqlServerExcludedObjects SqlServerRdbms},
   :sourceConfig {:sourceConnectionProfile string,
                  :oracleSourceConfig OracleSourceConfig,
                  :mysqlSourceConfig MysqlSourceConfig,
                  :postgresqlSourceConfig PostgresqlSourceConfig,
                  :sqlServerSourceConfig SqlServerSourceConfig},
   :destinationConfig {:destinationConnectionProfile string,
                       :gcsDestinationConfig GcsDestinationConfig,
                       :bigqueryDestinationConfig BigQueryDestinationConfig}}
  
  Use this method to update the configuration of a stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-streams-delete$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Use this method to delete a stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-streams-run$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/run
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:cdcStrategy {:mostRecentStartPosition MostRecentStartPosition,
                 :nextAvailableStartPosition NextAvailableStartPosition,
                 :specificStartPosition SpecificStartPosition}}
  
  Use this method to start, resume or recover a stream with a non default CDC strategy. NOTE: This feature is currently experimental."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+name}:run"
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

(defn locations-streams-objects-get$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/objects/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Use this method to get details about a stream object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-streams-objects-lookup$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/objects/lookup
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:sourceObjectIdentifier {:oracleIdentifier OracleObjectIdentifier,
                            :mysqlIdentifier MysqlObjectIdentifier,
                            :postgresqlIdentifier PostgresqlObjectIdentifier,
                            :sqlServerIdentifier SqlServerObjectIdentifier}}
  
  Use this method to look up a stream object by its source object identifier."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/objects:lookup"
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

(defn locations-streams-objects-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/objects/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Use this method to list the objects of a specific stream."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/objects"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-streams-objects-startBackfillJob$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/objects/startBackfillJob
  
  Required parameters: object
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Use this method to start a backfill job for the specified stream object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+object}:startBackfillJob"
     #{:object}
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

(defn locations-streams-objects-stopBackfillJob$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/streams/objects/stopBackfillJob
  
  Required parameters: object
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Use this method to stop a backfill job for the specified stream object."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:object})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+object}:stopBackfillJob"
     #{:object}
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

(defn locations-privateConnections-create$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/create
  
  Required parameters: parent
  
  Optional parameters: privateConnectionId, requestId, force
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :displayName string,
   :state string,
   :error {:reason string,
           :errorUuid string,
           :message string,
           :errorTime string,
           :details {}},
   :vpcPeeringConfig {:vpc string, :subnet string}}
  
  Use this method to create a private connectivity configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/privateConnections"
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

(defn locations-privateConnections-get$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Use this method to get details about a private connectivity configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-privateConnections-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Use this method to list private connectivity configurations in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/privateConnections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateConnections-delete$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/delete
  
  Required parameters: name
  
  Optional parameters: requestId, force
  
  Use this method to delete a private connectivity configuration."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-privateConnections-routes-create$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/routes/create
  
  Required parameters: parent
  
  Optional parameters: routeId, requestId
  
  Body: 
  
  {:name string,
   :createTime string,
   :updateTime string,
   :labels {},
   :displayName string,
   :destinationAddress string,
   :destinationPort integer}
  
  Use this method to create a route for a private connectivity configuration in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/routes"
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

(defn locations-privateConnections-routes-get$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/routes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Use this method to get details about a route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
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

(defn locations-privateConnections-routes-list$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/routes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Use this method to list routes created for a private connectivity configuration in a project and location."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://datastream.googleapis.com/"
     "v1/{+parent}/routes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-privateConnections-routes-delete$
  "https://cloud.google.com/datastream/api/reference/rest/v1/projects/locations/privateConnections/routes/delete
  
  Required parameters: name
  
  Optional parameters: requestId
  
  Use this method to delete a route."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://datastream.googleapis.com/"
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
