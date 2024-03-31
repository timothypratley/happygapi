(ns happygapi.connectors.projects
  "Connectors API: projects.
  Enables users to create and manage connections to Google Cloud services and third-party business applications using the Connectors interface.
  See: https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-connections-checkStatus$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/checkStatus
  
  Required parameters: name
  
  Optional parameters: none
  
  Reports the status of the connection. Note that when the connection is in a state that is not ACTIVE, the implementation of this RPC method must return a Status with the corresponding State instead of returning a gRPC status code that is not \"OK\", which indicates that ConnectionStatus itself, not the connection, failed."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}:checkStatus"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-checkReadiness$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/checkReadiness
  
  Required parameters: name
  
  Optional parameters: none
  
  Reports readiness status of the connector. Similar logic to GetStatus but modified for kubernetes health check to understand."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}:checkReadiness"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-exchangeAuthCode$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/exchangeAuthCode
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  ExchangeAuthCode exchanges the OAuth authorization code (and other necessary data) for an access token (and associated credentials)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}:exchangeAuthCode"
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

(defn locations-connections-refreshAccessToken$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/refreshAccessToken
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  RefreshAccessToken exchanges the OAuth refresh token (and other necessary data) for a new access token (and new associated credentials)."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}:refreshAccessToken"
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

(defn locations-connections-executeSqlQuery$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/executeSqlQuery
  
  Required parameters: connection
  
  Optional parameters: none
  
  Body: 
  
  {:query {:query string,
           :timeout string,
           :maxRows string,
           :queryParameters [QueryParameter]}}
  
  Executes a SQL statement specified in the body of the request. An example of this SQL statement in the case of Salesforce connector would be 'select * from Account a, Order o where a.Id = o.AccountId'."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:connection})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+connection}:executeSqlQuery"
     #{:connection}
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

(defn locations-connections-actions-execute$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/actions/execute
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:parameters {}}
  
  Executes an action with the name specified in the request. The input parameters for executing the action are passed through the body of the ExecuteAction request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}:execute"
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

(defn locations-connections-actions-list$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/actions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Gets the schema of all the actions supported by the connector."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+parent}/actions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-actions-get$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/actions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the schema of the given action."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-get$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets metadata of given entity type"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-list$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, view
  
  Lists metadata related to all entity types present in the external system."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+parent}/entityTypes"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-entities-list$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, sortBy, conditions
  
  Lists entity rows of a particular entity type contained in the request. Note: 1. Currently, only max of one 'sort_by' column is supported. 2. If no 'sort_by' column is provided, the primary key of the table is used. If zero or more than one primary key is available, we default to the unpaginated list entities logic which only returns the first page. 3. The values of the 'sort_by' columns must uniquely identify an entity row, otherwise undefined behaviors may be observed during pagination. 4. Since transactions are not supported, any updates, inserts or deletes during pagination can lead to stale data being returned or other unexpected behaviors."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+parent}/entities"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-entities-get$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a single entity row matching the entity type and entity id specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-entities-create$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :fields {}}
  
  Creates a new entity row of the specified entity type in the external system. The field values for creating the row are contained in the body of the request. The response message contains a `Entity` message object returned as a response by the external system."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+parent}/entities"
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

(defn locations-connections-entityTypes-entities-patch$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :fields {}}
  
  Updates an existing entity row matching the entity type and entity id specified in the request. The fields in the entity row that need to be modified are contained in the body of the request. All unspecified fields are left unchanged. The response message contains a `Entity` message object returned as a response by the external system."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}"
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

(defn locations-connections-entityTypes-entities-updateEntitiesWithConditions$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/updateEntitiesWithConditions
  
  Required parameters: entityType
  
  Optional parameters: conditions
  
  Body: 
  
  {:name string, :fields {}}
  
  Updates entities based on conditions specified in the request and not on entity id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+entityType}/entities:updateEntitiesWithConditions"
     #{:entityType}
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

(defn locations-connections-entityTypes-entities-delete$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing entity row matching the entity type and entity id specified in the request."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-connections-entityTypes-entities-deleteEntitiesWithConditions$
  "https://cloud.google.com/apigee/docs/api-platform/connectors/about-connectorsapi/reference/rest/v2/projects/locations/connections/entityTypes/entities/deleteEntitiesWithConditions
  
  Required parameters: entityType
  
  Optional parameters: conditions
  
  Deletes entities based on conditions specified in the request and not on entity id."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:entityType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://connectors.googleapis.com/"
     "v2/{+entityType}/entities:deleteEntitiesWithConditions"
     #{:entityType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
