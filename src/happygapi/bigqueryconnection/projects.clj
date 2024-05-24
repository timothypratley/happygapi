(ns happygapi.bigqueryconnection.projects
  "BigQuery Connection API: projects.
  Allows users to manage BigQuery connections to external data sources.
  See: https://cloud.google.com/bigquery/docs/connections-api-introdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-connections-create$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/create
  
  Required parameters: parent
  
  Optional parameters: connectionId
  
  Body: 
  
  {:creationTime string,
   :description string,
   :aws {:accessRole AwsAccessRole},
   :cloudResource {:serviceAccountId string},
   :hasCredential boolean,
   :cloudSpanner {:database string,
                  :useParallelism boolean,
                  :maxParallelism integer,
                  :useServerlessAnalytics boolean,
                  :useDataBoost boolean,
                  :databaseRole string},
   :name string,
   :lastModifiedTime string,
   :friendlyName string,
   :kmsKeyName string,
   :azure {:application string,
           :clientId string,
           :objectId string,
           :customerTenantId string,
           :redirectUri string,
           :federatedApplicationClientId string,
           :identity string},
   :configuration {:connectorId string,
                   :endpoint ConnectorConfigurationEndpoint,
                   :authentication ConnectorConfigurationAuthentication,
                   :network ConnectorConfigurationNetwork,
                   :asset ConnectorConfigurationAsset},
   :salesforceDataCloud {:instanceUri string,
                         :identity string,
                         :tenantId string},
   :spark {:serviceAccountId string,
           :metastoreServiceConfig MetastoreServiceConfig,
           :sparkHistoryServerConfig SparkHistoryServerConfig},
   :cloudSql {:instanceId string,
              :database string,
              :type string,
              :credential CloudSqlCredential,
              :serviceAccountId string}}
  
  Creates a new connection."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
     "v1/{+parent}/connections"
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

(defn locations-connections-get$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns specified connection."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
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

(defn locations-connections-list$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Returns a list of connections in the given project."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
     "v1/{+parent}/connections"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-patch$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creationTime string,
   :description string,
   :aws {:accessRole AwsAccessRole},
   :cloudResource {:serviceAccountId string},
   :hasCredential boolean,
   :cloudSpanner {:database string,
                  :useParallelism boolean,
                  :maxParallelism integer,
                  :useServerlessAnalytics boolean,
                  :useDataBoost boolean,
                  :databaseRole string},
   :name string,
   :lastModifiedTime string,
   :friendlyName string,
   :kmsKeyName string,
   :azure {:application string,
           :clientId string,
           :objectId string,
           :customerTenantId string,
           :redirectUri string,
           :federatedApplicationClientId string,
           :identity string},
   :configuration {:connectorId string,
                   :endpoint ConnectorConfigurationEndpoint,
                   :authentication ConnectorConfigurationAuthentication,
                   :network ConnectorConfigurationNetwork,
                   :asset ConnectorConfigurationAsset},
   :salesforceDataCloud {:instanceUri string,
                         :identity string,
                         :tenantId string},
   :spark {:serviceAccountId string,
           :metastoreServiceConfig MetastoreServiceConfig,
           :sparkHistoryServerConfig SparkHistoryServerConfig},
   :cloudSql {:instanceId string,
              :database string,
              :type string,
              :credential CloudSqlCredential,
              :serviceAccountId string}}
  
  Updates the specified connection. For security reasons, also resets credential if connection properties are in the update field mask."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
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

(defn locations-connections-delete$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes connection and associated credential."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
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

(defn locations-connections-getIamPolicy$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/getIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:options {:requestedPolicyVersion integer}}
  
  Gets the access control policy for a resource. Returns an empty policy if the resource exists and does not have a policy set."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
     "v1/{+resource}:getIamPolicy"
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

(defn locations-connections-setIamPolicy$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/setIamPolicy
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:policy {:version integer,
            :bindings [Binding],
            :auditConfigs [AuditConfig],
            :etag string},
   :updateMask string}
  
  Sets the access control policy on the specified resource. Replaces any existing policy. Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED` errors."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
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

(defn locations-connections-testIamPermissions$
  "https://cloud.google.com/bigquery/docs/connections-api-introapi/reference/rest/v1/projects/locations/connections/testIamPermissions
  
  Required parameters: resource
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [string]}
  
  Returns permissions that a caller has on the specified resource. If the resource does not exist, this will return an empty set of permissions, not a `NOT_FOUND` error. Note: This operation is designed to be used for building permission-aware UIs and command-line tools, not for authorization checking. This operation may \"fail open\" without warning."
  {:scopes ["https://www.googleapis.com/auth/bigquery"
            "https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resource})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://bigqueryconnection.googleapis.com/"
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
