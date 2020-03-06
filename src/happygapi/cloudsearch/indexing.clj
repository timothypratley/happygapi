(ns happygapi.cloudsearch.indexing
  "Cloud Search API: indexing.
  Cloud Search provides cloud-based search capabilities over G Suite data.  The Cloud Search API allows indexing of non-G Suite data into Cloud Search.
  See: https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn datasources-getSchema$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/getSchema
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  Gets the schema of a data source.
  
  **Note:** This API requires an admin or service account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/schema"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-updateSchema$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/updateSchema
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:debugOptions {:enableDebugging boolean},
   :validateOnly boolean,
   :schema {:operationIds [string],
            :objectDefinitions [ObjectDefinition]}}
  
  Updates the schema of a data source. This method does not perform
  incremental updates to the schema. Instead, this method updates the schema
  by overwriting the entire schema.
  
  **Note:** This API requires an admin or service account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/schema"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-deleteSchema$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/deleteSchema
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging
  Deletes the schema of a data source.
  
  **Note:** This API requires an admin or service account to execute."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.settings"
            "https://www.googleapis.com/auth/cloud_search.settings.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/schema"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-get$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/get
  
  Required parameters: name
  
  Optional parameters: connectorName, debugOptions.enableDebugging
  Gets Item resource by item name.
  
  This API requires an admin or service account to execute.  The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-push$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/push
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:debugOptions {:enableDebugging boolean},
   :item {:payload string,
          :repositoryError RepositoryError,
          :type string,
          :queue string,
          :structuredDataHash string,
          :contentHash string,
          :metadataHash string},
   :connectorName string}
  
  Pushes an item onto a queue for later polling and updating.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}:push"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-index$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/index
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:mode string,
   :debugOptions {:enableDebugging boolean},
   :item {:payload string,
          :queue string,
          :content ItemContent,
          :name string,
          :status ItemStatus,
          :acl ItemAcl,
          :itemType string,
          :version string,
          :structuredData ItemStructuredData,
          :metadata ItemMetadata},
   :connectorName string,
   :indexItemOptions {:allowUnknownGsuitePrincipals boolean}}
  
  Updates Item ACL, metadata, and
  content. It will insert the Item if it
  does not exist.
  This method does not support partial updates.  Fields with no provided
  values are cleared out in the Cloud Search index.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}:index"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-delete$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/delete
  
  Required parameters: name
  
  Optional parameters: mode, connectorName, version, debugOptions.enableDebugging
  Deletes Item resource for the
  specified resource name. This API requires an admin or service account
  to execute. The service account used is the one whitelisted in the
  corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-deleteQueueItems$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/deleteQueueItems
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:debugOptions {:enableDebugging boolean},
   :connectorName string,
   :queue string}
  
  Deletes all items in a queue. This method is useful for deleting stale
  items.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/items:deleteQueueItems"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-poll$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/poll
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:limit integer,
   :statusCodes [string],
   :debugOptions {:enableDebugging boolean},
   :connectorName string,
   :queue string}
  
  Polls for unreserved items from the indexing queue and marks a
  set as reserved, starting with items that have
  the oldest timestamp from the highest priority
  ItemStatus.
  The priority order is as follows: <br />
  ERROR
  <br />
  MODIFIED
  <br />
  NEW_ITEM
  <br />
  ACCEPTED
  <br />
  Reserving items ensures that polling from other threads
  cannot create overlapping sets.
  
  After handling the reserved items, the client should put items back
  into the unreserved state, either by calling
  index,
  or by calling
  push with
  the type REQUEUE.
  
  Items automatically become available (unreserved) after 4 hours even if no
  update or push method is called.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/items:poll"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-list$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/list
  
  Required parameters: name
  
  Optional parameters: debugOptions.enableDebugging, connectorName, brief, pageToken, pageSize
  Lists all or a subset of Item resources.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/items"
     #{:name}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-unreserve$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/unreserve
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:connectorName string,
   :queue string,
   :debugOptions {:enableDebugging boolean}}
  
  Unreserves all items from a queue, making them all eligible to be
  polled.  This method is useful for resetting the indexing queue
  after a connector has been restarted.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}/items:unreserve"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn datasources-items-upload$
  "https://developers.google.com/cloud-search/docs/guides/api/reference/rest/v1/indexing/datasources/items/upload
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:connectorName string, :debugOptions {:enableDebugging boolean}}
  
  Creates an upload session for uploading item content. For items smaller
  than 100 KB, it's easier to embed the content
  inline within
  an index request.
  
  This API requires an admin or service account to execute. The service
  account used is the one whitelisted in the corresponding data source."
  {:scopes ["https://www.googleapis.com/auth/cloud_search"
            "https://www.googleapis.com/auth/cloud_search.indexing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://cloudsearch.googleapis.com/"
     "v1/indexing/{+name}:upload"
     #{:name}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
