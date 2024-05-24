(ns happygapi.discoveryengine.projects
  "Discovery Engine API: projects.
  Discovery Engine API.
  See: https://cloud.google.com/discovery-engine/docsdocs/reference/rest/v1/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn operations-cancel$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/operations/cancel
  
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
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataConnector-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataConnector/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataConnector-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataConnector/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-completeQuery$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/completeQuery
  
  Required parameters: dataStore
  
  Optional parameters: query, queryModel, userPseudoId, includeTailSuggestions
  
  Completes the specified user input with keyword suggestions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataStore})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+dataStore}:completeQuery"
     #{:dataStore}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/create
  
  Required parameters: parent
  
  Optional parameters: dataStoreId, createAdvancedSiteSearch
  
  Body: 
  
  {:displayName string,
   :defaultSchemaId string,
   :name string,
   :industryVertical string,
   :createTime string,
   :solutionTypes [string],
   :startingSchema {:structSchema {}, :jsonSchema string, :name string},
   :contentConfig string,
   :documentProcessingConfig {:name string,
                              :defaultParsingConfig GoogleCloudDiscoveryengineV1DocumentProcessingConfigParsingConfig,
                              :parsingConfigOverrides {}}}
  
  Creates a DataStore. DataStore is for storing Documents. To serve these documents for Search, or Recommendation use case, an Engine needs to be created separately."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/dataStores"
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

(defn locations-collections-dataStores-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all the DataStores associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/dataStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :defaultSchemaId string,
   :name string,
   :industryVertical string,
   :createTime string,
   :solutionTypes [string],
   :startingSchema {:structSchema {}, :jsonSchema string, :name string},
   :contentConfig string,
   :documentProcessingConfig {:name string,
                              :defaultParsingConfig GoogleCloudDiscoveryengineV1DocumentProcessingConfigParsingConfig,
                              :parsingConfigOverrides {}}}
  
  Updates a DataStore"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-getSiteSearchEngine$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/getSiteSearchEngine
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the SiteSearchEngine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-enableAdvancedSiteSearch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/enableAdvancedSiteSearch
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Upgrade from basic site search to advanced site search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:enableAdvancedSiteSearch"
     #{:siteSearchEngine}
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

(defn locations-collections-dataStores-siteSearchEngine-disableAdvancedSiteSearch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/disableAdvancedSiteSearch
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Downgrade from advanced site search to basic site search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:disableAdvancedSiteSearch"
     #{:siteSearchEngine}
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

(defn locations-collections-dataStores-siteSearchEngine-recrawlUris$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/recrawlUris
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {:uris [string]}
  
  Request on-demand recrawl for a list of URIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:recrawlUris"
     #{:siteSearchEngine}
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

(defn locations-collections-dataStores-siteSearchEngine-batchVerifyTargetSites$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/batchVerifyTargetSites
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Verify target sites' ownership and validity. This API sends all the target sites under site search engine for verification."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}:batchVerifyTargetSites"
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

(defn locations-collections-dataStores-siteSearchEngine-fetchDomainVerificationStatus$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/fetchDomainVerificationStatus
  
  Required parameters: siteSearchEngine
  
  Optional parameters: pageSize, pageToken
  
  Returns list of target sites with its domain verification status. This method can only be called under data store with BASIC_SITE_SEARCH state at the moment."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:fetchDomainVerificationStatus"
     #{:siteSearchEngine}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-siteSearchEngine-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:providedUriPattern string,
   :exactMatch boolean,
   :name string,
   :indexingStatus string,
   :rootDomainUri string,
   :type string,
   :updateTime string,
   :siteVerificationInfo {:siteVerificationState string,
                          :verifyTime string},
   :failureReason {:quotaFailure GoogleCloudDiscoveryengineV1TargetSiteFailureReasonQuotaFailure},
   :generatedUriPattern string}
  
  Creates a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-batchCreate$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string,
               :targetSite GoogleCloudDiscoveryengineV1TargetSite}]}
  
  Creates TargetSite in a batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites:batchCreate"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:providedUriPattern string,
   :exactMatch boolean,
   :name string,
   :indexingStatus string,
   :rootDomainUri string,
   :type string,
   :updateTime string,
   :siteVerificationInfo {:siteVerificationState string,
                          :verifyTime string},
   :failureReason {:quotaFailure GoogleCloudDiscoveryengineV1TargetSiteFailureReasonQuotaFailure},
   :generatedUriPattern string}
  
  Updates a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of TargetSites."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-siteSearchEngine-targetSites-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-siteSearchEngine-targetSites-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/siteSearchEngine/targetSites/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-conversations-converse$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/converse
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:query {:input string,
           :context GoogleCloudDiscoveryengineV1ConversationContext},
   :servingConfig string,
   :conversation {:name string,
                  :state string,
                  :userPseudoId string,
                  :messages [GoogleCloudDiscoveryengineV1ConversationMessage],
                  :startTime string,
                  :endTime string},
   :safeSearch boolean,
   :userLabels {},
   :summarySpec {:summaryResultCount integer,
                 :includeCitations boolean,
                 :ignoreAdversarialQuery boolean,
                 :ignoreNonSummarySeekingQuery boolean,
                 :modelPromptSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelPromptSpec,
                 :languageCode string,
                 :modelSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelSpec,
                 :useSemanticChunks boolean},
   :filter string,
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]}}
  
  Converses a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+name}:converse"
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

(defn locations-collections-dataStores-conversations-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
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

(defn locations-collections-dataStores-conversations-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-conversations-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-conversations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-conversations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/conversations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Conversations by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-userEvents-write$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventType string,
   :tagIds [string],
   :transactionInfo {:value number,
                     :currency string,
                     :transactionId string,
                     :tax number,
                     :cost number,
                     :discountValue number},
   :sessionId string,
   :searchInfo {:searchQuery string, :orderBy string, :offset integer},
   :userPseudoId string,
   :panel {:panelId string,
           :displayName string,
           :panelPosition integer,
           :totalPanels integer},
   :documents [{:id string,
                :name string,
                :uri string,
                :quantity integer,
                :promotionIds [string]}],
   :directUserRequest boolean,
   :filter string,
   :completionInfo {:selectedSuggestion string,
                    :selectedPosition integer},
   :mediaInfo {:mediaProgressDuration string,
               :mediaProgressPercentage number},
   :pageInfo {:pageviewId string,
              :pageCategory string,
              :uri string,
              :referrerUri string},
   :eventTime string,
   :promotionIds [string],
   :attributes {},
   :attributionToken string,
   :userInfo {:userId string, :userAgent string}}
  
  Writes a single user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:write"
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

(defn locations-collections-dataStores-userEvents-collect$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/userEvents/collect
  
  Required parameters: parent
  
  Optional parameters: userEvent, uri, ets
  
  Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a third-party domain. This method is used only by the Discovery Engine API JavaScript pixel and Google Tag Manager. Users should not call this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:collect"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-userEvents-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/userEvents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inlineSource {:userEvents [GoogleCloudDiscoveryengineV1UserEvent]},
   :gcsSource {:inputUris [string], :dataSchema string},
   :bigquerySource {:partitionDate GoogleTypeDate,
                    :projectId string,
                    :datasetId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :dataSchema string},
   :errorConfig {:gcsPrefix string}}
  
  Bulk import of user events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:import"
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

(defn locations-collections-dataStores-branches-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-operations-cancel$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/operations/cancel
  
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
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-documents-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-documents-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of Documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-branches-documents-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/create
  
  Required parameters: parent
  
  Optional parameters: documentId
  
  Body: 
  
  {:content {:rawBytes string, :uri string, :mimeType string},
   :parentDocumentId string,
   :name string,
   :indexTime string,
   :schemaId string,
   :structData {},
   :id string,
   :jsonData string,
   :derivedStructData {}}
  
  Creates a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents"
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

(defn locations-collections-dataStores-branches-documents-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/patch
  
  Required parameters: name
  
  Optional parameters: allowMissing, updateMask
  
  Body: 
  
  {:content {:rawBytes string, :uri string, :mimeType string},
   :parentDocumentId string,
   :name string,
   :indexTime string,
   :schemaId string,
   :structData {},
   :id string,
   :jsonData string,
   :derivedStructData {}}
  
  Updates a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-documents-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-branches-documents-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :autoGenerateIds boolean,
   :idField string,
   :bigquerySource {:partitionDate GoogleTypeDate,
                    :projectId string,
                    :datasetId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :dataSchema string},
   :spannerSource {:projectId string,
                   :instanceId string,
                   :databaseId string,
                   :tableId string,
                   :enableDataBoost boolean},
   :bigtableSource {:projectId string,
                    :instanceId string,
                    :tableId string,
                    :bigtableOptions GoogleCloudDiscoveryengineV1BigtableOptions},
   :firestoreSource {:projectId string,
                     :databaseId string,
                     :collectionId string,
                     :gcsStagingDir string},
   :reconciliationMode string,
   :cloudSqlSource {:projectId string,
                    :instanceId string,
                    :databaseId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :offload boolean},
   :errorConfig {:gcsPrefix string},
   :inlineSource {:documents [GoogleCloudDiscoveryengineV1Document]},
   :fhirStoreSource {:fhirStore string, :gcsStagingDir string},
   :gcsSource {:inputUris [string], :dataSchema string}}
  
  Bulk import of multiple Documents. Request processing may be synchronous. Non-existing items are created. Note: It is possible for a subset of the Documents to be successfully updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents:import"
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

(defn locations-collections-dataStores-branches-documents-purge$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/branches/documents/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Permanently deletes all selected Documents in a branch. This process is asynchronous. Depending on the number of Documents to be deleted, this operation can take hours to complete. Before the delete operation completes, some Documents might still be returned by DocumentService.GetDocument or DocumentService.ListDocuments. To get a list of the Documents to be deleted, set PurgeDocumentsRequest.force to false."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents:purge"
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

(defn locations-collections-dataStores-suggestionDenyListEntries-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/suggestionDenyListEntries/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inlineSource {:entries [GoogleCloudDiscoveryengineV1SuggestionDenyListEntry]},
   :gcsSource {:inputUris [string], :dataSchema string}}
  
  Imports all SuggestionDenyListEntry for a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/suggestionDenyListEntries:import"
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

(defn locations-collections-dataStores-suggestionDenyListEntries-purge$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/suggestionDenyListEntries/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Permanently deletes all SuggestionDenyListEntry for a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/suggestionDenyListEntries:purge"
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

(defn locations-collections-dataStores-models-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/models/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-models-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/models/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-schemas-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-schemas-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of Schemas."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/schemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-schemas-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/create
  
  Required parameters: parent
  
  Optional parameters: schemaId
  
  Body: 
  
  {:structSchema {}, :jsonSchema string, :name string}
  
  Creates a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/schemas"
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

(defn locations-collections-dataStores-schemas-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/patch
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Body: 
  
  {:structSchema {}, :jsonSchema string, :name string}
  
  Updates a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-schemas-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-schemas-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-schemas-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/schemas/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-servingConfigs-search$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/servingConfigs/search
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:canonicalFilter string,
   :contentSearchSpec {:snippetSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSnippetSpec,
                       :summarySpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpec,
                       :extractiveContentSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecExtractiveContentSpec},
   :offset integer,
   :imageQuery {:imageBytes string},
   :params {},
   :userPseudoId string,
   :safeSearch boolean,
   :pageToken string,
   :facetSpecs [{:facetKey GoogleCloudDiscoveryengineV1SearchRequestFacetSpecFacetKey,
                 :limit integer,
                 :excludedFilterKeys [string],
                 :enableDynamicPosition boolean}],
   :filter string,
   :pageSize integer,
   :query string,
   :branch string,
   :userLabels {},
   :dataStoreSpecs [{:dataStore string}],
   :queryExpansionSpec {:condition string,
                        :pinUnexpandedResults boolean},
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]},
   :spellCorrectionSpec {:mode string},
   :userInfo {:userId string, :userAgent string},
   :orderBy string}
  
  Performs a search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:search"
     #{:servingConfig}
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

(defn locations-collections-dataStores-servingConfigs-answer$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/servingConfigs/answer
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:relatedQuestionsSpec {:enable boolean},
   :safetySpec {:enable boolean},
   :queryUnderstandingSpec {:queryClassificationSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryClassificationSpec,
                            :queryRephraserSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryRephraserSpec},
   :userPseudoId string,
   :asynchronousMode boolean,
   :searchSpec {:searchParams GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchParams,
                :searchResultList GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultList},
   :query {:text string, :queryId string},
   :answerGenerationSpec {:modelSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecModelSpec,
                          :promptSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecPromptSpec,
                          :includeCitations boolean,
                          :answerLanguageCode string,
                          :ignoreAdversarialQuery boolean,
                          :ignoreNonAnswerSeekingQuery boolean},
   :session string}
  
  Answer query method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:answer"
     #{:servingConfig}
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

(defn locations-collections-dataStores-servingConfigs-recommend$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/servingConfigs/recommend
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:eventType string,
               :tagIds [string],
               :transactionInfo GoogleCloudDiscoveryengineV1TransactionInfo,
               :sessionId string,
               :searchInfo GoogleCloudDiscoveryengineV1SearchInfo,
               :userPseudoId string,
               :panel GoogleCloudDiscoveryengineV1PanelInfo,
               :documents [GoogleCloudDiscoveryengineV1DocumentInfo],
               :directUserRequest boolean,
               :filter string,
               :completionInfo GoogleCloudDiscoveryengineV1CompletionInfo,
               :mediaInfo GoogleCloudDiscoveryengineV1MediaInfo,
               :pageInfo GoogleCloudDiscoveryengineV1PageInfo,
               :eventTime string,
               :promotionIds [string],
               :attributes {},
               :attributionToken string,
               :userInfo GoogleCloudDiscoveryengineV1UserInfo},
   :pageSize integer,
   :filter string,
   :validateOnly boolean,
   :params {},
   :userLabels {}}
  
  Makes a recommendation, which requires a contextual user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:recommend"
     #{:servingConfig}
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

(defn locations-collections-dataStores-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-sessions-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
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

(defn locations-collections-dataStores-sessions-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-sessions-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-sessions-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-dataStores-sessions-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Sessions by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-dataStores-sessions-answers-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/dataStores/sessions/answers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Answer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/create
  
  Required parameters: parent
  
  Optional parameters: engineId
  
  Body: 
  
  {:solutionType string,
   :displayName string,
   :name string,
   :industryVertical string,
   :createTime string,
   :updateTime string,
   :dataStoreIds [string],
   :searchEngineConfig {:searchTier string, :searchAddOns [string]},
   :chatEngineMetadata {:dialogflowAgent string},
   :chatEngineConfig {:agentCreationConfig GoogleCloudDiscoveryengineV1EngineChatEngineConfigAgentCreationConfig,
                      :dialogflowAgentToLink string},
   :commonConfig {:companyName string}}
  
  Creates a Engine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/engines"
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

(defn locations-collections-engines-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Engine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:solutionType string,
   :displayName string,
   :name string,
   :industryVertical string,
   :createTime string,
   :updateTime string,
   :dataStoreIds [string],
   :searchEngineConfig {:searchTier string, :searchAddOns [string]},
   :chatEngineMetadata {:dialogflowAgent string},
   :chatEngineConfig {:agentCreationConfig GoogleCloudDiscoveryengineV1EngineChatEngineConfigAgentCreationConfig,
                      :dialogflowAgentToLink string},
   :commonConfig {:companyName string}}
  
  Updates an Engine"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Engine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all the Engines associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/engines"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-engines-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-servingConfigs-search$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/servingConfigs/search
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:canonicalFilter string,
   :contentSearchSpec {:snippetSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSnippetSpec,
                       :summarySpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpec,
                       :extractiveContentSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecExtractiveContentSpec},
   :offset integer,
   :imageQuery {:imageBytes string},
   :params {},
   :userPseudoId string,
   :safeSearch boolean,
   :pageToken string,
   :facetSpecs [{:facetKey GoogleCloudDiscoveryengineV1SearchRequestFacetSpecFacetKey,
                 :limit integer,
                 :excludedFilterKeys [string],
                 :enableDynamicPosition boolean}],
   :filter string,
   :pageSize integer,
   :query string,
   :branch string,
   :userLabels {},
   :dataStoreSpecs [{:dataStore string}],
   :queryExpansionSpec {:condition string,
                        :pinUnexpandedResults boolean},
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]},
   :spellCorrectionSpec {:mode string},
   :userInfo {:userId string, :userAgent string},
   :orderBy string}
  
  Performs a search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:search"
     #{:servingConfig}
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

(defn locations-collections-engines-servingConfigs-answer$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/servingConfigs/answer
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:relatedQuestionsSpec {:enable boolean},
   :safetySpec {:enable boolean},
   :queryUnderstandingSpec {:queryClassificationSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryClassificationSpec,
                            :queryRephraserSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryRephraserSpec},
   :userPseudoId string,
   :asynchronousMode boolean,
   :searchSpec {:searchParams GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchParams,
                :searchResultList GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultList},
   :query {:text string, :queryId string},
   :answerGenerationSpec {:modelSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecModelSpec,
                          :promptSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecPromptSpec,
                          :includeCitations boolean,
                          :answerLanguageCode string,
                          :ignoreAdversarialQuery boolean,
                          :ignoreNonAnswerSeekingQuery boolean},
   :session string}
  
  Answer query method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:answer"
     #{:servingConfig}
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

(defn locations-collections-engines-servingConfigs-recommend$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/servingConfigs/recommend
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:eventType string,
               :tagIds [string],
               :transactionInfo GoogleCloudDiscoveryengineV1TransactionInfo,
               :sessionId string,
               :searchInfo GoogleCloudDiscoveryengineV1SearchInfo,
               :userPseudoId string,
               :panel GoogleCloudDiscoveryengineV1PanelInfo,
               :documents [GoogleCloudDiscoveryengineV1DocumentInfo],
               :directUserRequest boolean,
               :filter string,
               :completionInfo GoogleCloudDiscoveryengineV1CompletionInfo,
               :mediaInfo GoogleCloudDiscoveryengineV1MediaInfo,
               :pageInfo GoogleCloudDiscoveryengineV1PageInfo,
               :eventTime string,
               :promotionIds [string],
               :attributes {},
               :attributionToken string,
               :userInfo GoogleCloudDiscoveryengineV1UserInfo},
   :pageSize integer,
   :filter string,
   :validateOnly boolean,
   :params {},
   :userLabels {}}
  
  Makes a recommendation, which requires a contextual user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:recommend"
     #{:servingConfig}
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

(defn locations-collections-engines-conversations-converse$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/converse
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:query {:input string,
           :context GoogleCloudDiscoveryengineV1ConversationContext},
   :servingConfig string,
   :conversation {:name string,
                  :state string,
                  :userPseudoId string,
                  :messages [GoogleCloudDiscoveryengineV1ConversationMessage],
                  :startTime string,
                  :endTime string},
   :safeSearch boolean,
   :userLabels {},
   :summarySpec {:summaryResultCount integer,
                 :includeCitations boolean,
                 :ignoreAdversarialQuery boolean,
                 :ignoreNonSummarySeekingQuery boolean,
                 :modelPromptSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelPromptSpec,
                 :languageCode string,
                 :modelSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelSpec,
                 :useSemanticChunks boolean},
   :filter string,
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]}}
  
  Converses a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+name}:converse"
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

(defn locations-collections-engines-conversations-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
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

(defn locations-collections-engines-conversations-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-conversations-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-conversations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-conversations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/conversations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Conversations by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-engines-sessions-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
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

(defn locations-collections-engines-sessions-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-sessions-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-sessions-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-collections-engines-sessions-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Sessions by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-collections-engines-sessions-answers-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/collections/engines/sessions/answers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Answer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-completeQuery$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/completeQuery
  
  Required parameters: dataStore
  
  Optional parameters: query, queryModel, userPseudoId, includeTailSuggestions
  
  Completes the specified user input with keyword suggestions."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:dataStore})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+dataStore}:completeQuery"
     #{:dataStore}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/create
  
  Required parameters: parent
  
  Optional parameters: dataStoreId, createAdvancedSiteSearch
  
  Body: 
  
  {:displayName string,
   :defaultSchemaId string,
   :name string,
   :industryVertical string,
   :createTime string,
   :solutionTypes [string],
   :startingSchema {:structSchema {}, :jsonSchema string, :name string},
   :contentConfig string,
   :documentProcessingConfig {:name string,
                              :defaultParsingConfig GoogleCloudDiscoveryengineV1DocumentProcessingConfigParsingConfig,
                              :parsingConfigOverrides {}}}
  
  Creates a DataStore. DataStore is for storing Documents. To serve these documents for Search, or Recommendation use case, an Engine needs to be created separately."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/dataStores"
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

(defn locations-dataStores-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all the DataStores associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/dataStores"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :defaultSchemaId string,
   :name string,
   :industryVertical string,
   :createTime string,
   :solutionTypes [string],
   :startingSchema {:structSchema {}, :jsonSchema string, :name string},
   :contentConfig string,
   :documentProcessingConfig {:name string,
                              :defaultParsingConfig GoogleCloudDiscoveryengineV1DocumentProcessingConfigParsingConfig,
                              :parsingConfigOverrides {}}}
  
  Updates a DataStore"
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-getSiteSearchEngine$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/getSiteSearchEngine
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the SiteSearchEngine."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-siteSearchEngine-enableAdvancedSiteSearch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/enableAdvancedSiteSearch
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Upgrade from basic site search to advanced site search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:enableAdvancedSiteSearch"
     #{:siteSearchEngine}
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

(defn locations-dataStores-siteSearchEngine-disableAdvancedSiteSearch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/disableAdvancedSiteSearch
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Downgrade from advanced site search to basic site search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:disableAdvancedSiteSearch"
     #{:siteSearchEngine}
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

(defn locations-dataStores-siteSearchEngine-recrawlUris$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/recrawlUris
  
  Required parameters: siteSearchEngine
  
  Optional parameters: none
  
  Body: 
  
  {:uris [string]}
  
  Request on-demand recrawl for a list of URIs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:siteSearchEngine})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+siteSearchEngine}:recrawlUris"
     #{:siteSearchEngine}
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

(defn locations-dataStores-siteSearchEngine-targetSites-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:providedUriPattern string,
   :exactMatch boolean,
   :name string,
   :indexingStatus string,
   :rootDomainUri string,
   :type string,
   :updateTime string,
   :siteVerificationInfo {:siteVerificationState string,
                          :verifyTime string},
   :failureReason {:quotaFailure GoogleCloudDiscoveryengineV1TargetSiteFailureReasonQuotaFailure},
   :generatedUriPattern string}
  
  Creates a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites"
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

(defn locations-dataStores-siteSearchEngine-targetSites-batchCreate$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/batchCreate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:parent string,
               :targetSite GoogleCloudDiscoveryengineV1TargetSite}]}
  
  Creates TargetSite in a batch."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites:batchCreate"
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

(defn locations-dataStores-siteSearchEngine-targetSites-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-siteSearchEngine-targetSites-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/patch
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:providedUriPattern string,
   :exactMatch boolean,
   :name string,
   :indexingStatus string,
   :rootDomainUri string,
   :type string,
   :updateTime string,
   :siteVerificationInfo {:siteVerificationState string,
                          :verifyTime string},
   :failureReason {:quotaFailure GoogleCloudDiscoveryengineV1TargetSiteFailureReasonQuotaFailure},
   :generatedUriPattern string}
  
  Updates a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-siteSearchEngine-targetSites-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a TargetSite."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-siteSearchEngine-targetSites-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/siteSearchEngine/targetSites/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of TargetSites."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/targetSites"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-conversations-converse$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/converse
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:query {:input string,
           :context GoogleCloudDiscoveryengineV1ConversationContext},
   :servingConfig string,
   :conversation {:name string,
                  :state string,
                  :userPseudoId string,
                  :messages [GoogleCloudDiscoveryengineV1ConversationMessage],
                  :startTime string,
                  :endTime string},
   :safeSearch boolean,
   :userLabels {},
   :summarySpec {:summaryResultCount integer,
                 :includeCitations boolean,
                 :ignoreAdversarialQuery boolean,
                 :ignoreNonSummarySeekingQuery boolean,
                 :modelPromptSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelPromptSpec,
                 :languageCode string,
                 :modelSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpecModelSpec,
                 :useSemanticChunks boolean},
   :filter string,
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]}}
  
  Converses a conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+name}:converse"
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

(defn locations-dataStores-conversations-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Creates a Conversation. If the Conversation to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
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

(defn locations-dataStores-conversations-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Conversation. If the Conversation to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-conversations-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :messages [{:userInput GoogleCloudDiscoveryengineV1TextInput,
               :reply GoogleCloudDiscoveryengineV1Reply,
               :createTime string}],
   :startTime string,
   :endTime string}
  
  Updates a Conversation. Conversation action type cannot be changed. If the Conversation to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-conversations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Conversation."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-conversations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/conversations/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Conversations by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/conversations"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-userEvents-write$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventType string,
   :tagIds [string],
   :transactionInfo {:value number,
                     :currency string,
                     :transactionId string,
                     :tax number,
                     :cost number,
                     :discountValue number},
   :sessionId string,
   :searchInfo {:searchQuery string, :orderBy string, :offset integer},
   :userPseudoId string,
   :panel {:panelId string,
           :displayName string,
           :panelPosition integer,
           :totalPanels integer},
   :documents [{:id string,
                :name string,
                :uri string,
                :quantity integer,
                :promotionIds [string]}],
   :directUserRequest boolean,
   :filter string,
   :completionInfo {:selectedSuggestion string,
                    :selectedPosition integer},
   :mediaInfo {:mediaProgressDuration string,
               :mediaProgressPercentage number},
   :pageInfo {:pageviewId string,
              :pageCategory string,
              :uri string,
              :referrerUri string},
   :eventTime string,
   :promotionIds [string],
   :attributes {},
   :attributionToken string,
   :userInfo {:userId string, :userAgent string}}
  
  Writes a single user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:write"
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

(defn locations-dataStores-userEvents-collect$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/userEvents/collect
  
  Required parameters: parent
  
  Optional parameters: userEvent, uri, ets
  
  Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a third-party domain. This method is used only by the Discovery Engine API JavaScript pixel and Google Tag Manager. Users should not call this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:collect"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-userEvents-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/userEvents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inlineSource {:userEvents [GoogleCloudDiscoveryengineV1UserEvent]},
   :gcsSource {:inputUris [string], :dataSchema string},
   :bigquerySource {:partitionDate GoogleTypeDate,
                    :projectId string,
                    :datasetId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :dataSchema string},
   :errorConfig {:gcsPrefix string}}
  
  Bulk import of user events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:import"
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

(defn locations-dataStores-branches-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-operations-cancel$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/operations/cancel
  
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
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-documents-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-documents-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of Documents."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-branches-documents-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/create
  
  Required parameters: parent
  
  Optional parameters: documentId
  
  Body: 
  
  {:content {:rawBytes string, :uri string, :mimeType string},
   :parentDocumentId string,
   :name string,
   :indexTime string,
   :schemaId string,
   :structData {},
   :id string,
   :jsonData string,
   :derivedStructData {}}
  
  Creates a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents"
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

(defn locations-dataStores-branches-documents-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/patch
  
  Required parameters: name
  
  Optional parameters: allowMissing, updateMask
  
  Body: 
  
  {:content {:rawBytes string, :uri string, :mimeType string},
   :parentDocumentId string,
   :name string,
   :indexTime string,
   :schemaId string,
   :structData {},
   :id string,
   :jsonData string,
   :derivedStructData {}}
  
  Updates a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-documents-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Document."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-branches-documents-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :autoGenerateIds boolean,
   :idField string,
   :bigquerySource {:partitionDate GoogleTypeDate,
                    :projectId string,
                    :datasetId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :dataSchema string},
   :spannerSource {:projectId string,
                   :instanceId string,
                   :databaseId string,
                   :tableId string,
                   :enableDataBoost boolean},
   :bigtableSource {:projectId string,
                    :instanceId string,
                    :tableId string,
                    :bigtableOptions GoogleCloudDiscoveryengineV1BigtableOptions},
   :firestoreSource {:projectId string,
                     :databaseId string,
                     :collectionId string,
                     :gcsStagingDir string},
   :reconciliationMode string,
   :cloudSqlSource {:projectId string,
                    :instanceId string,
                    :databaseId string,
                    :tableId string,
                    :gcsStagingDir string,
                    :offload boolean},
   :errorConfig {:gcsPrefix string},
   :inlineSource {:documents [GoogleCloudDiscoveryengineV1Document]},
   :fhirStoreSource {:fhirStore string, :gcsStagingDir string},
   :gcsSource {:inputUris [string], :dataSchema string}}
  
  Bulk import of multiple Documents. Request processing may be synchronous. Non-existing items are created. Note: It is possible for a subset of the Documents to be successfully updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents:import"
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

(defn locations-dataStores-branches-documents-purge$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/branches/documents/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Permanently deletes all selected Documents in a branch. This process is asynchronous. Depending on the number of Documents to be deleted, this operation can take hours to complete. Before the delete operation completes, some Documents might still be returned by DocumentService.GetDocument or DocumentService.ListDocuments. To get a list of the Documents to be deleted, set PurgeDocumentsRequest.force to false."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/documents:purge"
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

(defn locations-dataStores-suggestionDenyListEntries-import$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/suggestionDenyListEntries/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inlineSource {:entries [GoogleCloudDiscoveryengineV1SuggestionDenyListEntry]},
   :gcsSource {:inputUris [string], :dataSchema string}}
  
  Imports all SuggestionDenyListEntry for a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/suggestionDenyListEntries:import"
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

(defn locations-dataStores-suggestionDenyListEntries-purge$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/suggestionDenyListEntries/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Permanently deletes all SuggestionDenyListEntry for a DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/suggestionDenyListEntries:purge"
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

(defn locations-dataStores-models-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/models/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-models-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/models/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-schemas-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/schemas/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-schemas-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/schemas/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Gets a list of Schemas."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/schemas"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-schemas-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/schemas/create
  
  Required parameters: parent
  
  Optional parameters: schemaId
  
  Body: 
  
  {:structSchema {}, :jsonSchema string, :name string}
  
  Creates a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/schemas"
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

(defn locations-dataStores-schemas-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/schemas/patch
  
  Required parameters: name
  
  Optional parameters: allowMissing
  
  Body: 
  
  {:structSchema {}, :jsonSchema string, :name string}
  
  Updates a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-schemas-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/schemas/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Schema."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-servingConfigs-search$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/servingConfigs/search
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:canonicalFilter string,
   :contentSearchSpec {:snippetSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSnippetSpec,
                       :summarySpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecSummarySpec,
                       :extractiveContentSpec GoogleCloudDiscoveryengineV1SearchRequestContentSearchSpecExtractiveContentSpec},
   :offset integer,
   :imageQuery {:imageBytes string},
   :params {},
   :userPseudoId string,
   :safeSearch boolean,
   :pageToken string,
   :facetSpecs [{:facetKey GoogleCloudDiscoveryengineV1SearchRequestFacetSpecFacetKey,
                 :limit integer,
                 :excludedFilterKeys [string],
                 :enableDynamicPosition boolean}],
   :filter string,
   :pageSize integer,
   :query string,
   :branch string,
   :userLabels {},
   :dataStoreSpecs [{:dataStore string}],
   :queryExpansionSpec {:condition string,
                        :pinUnexpandedResults boolean},
   :boostSpec {:conditionBoostSpecs [GoogleCloudDiscoveryengineV1SearchRequestBoostSpecConditionBoostSpec]},
   :spellCorrectionSpec {:mode string},
   :userInfo {:userId string, :userAgent string},
   :orderBy string}
  
  Performs a search."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:search"
     #{:servingConfig}
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

(defn locations-dataStores-servingConfigs-answer$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/servingConfigs/answer
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:relatedQuestionsSpec {:enable boolean},
   :safetySpec {:enable boolean},
   :queryUnderstandingSpec {:queryClassificationSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryClassificationSpec,
                            :queryRephraserSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestQueryUnderstandingSpecQueryRephraserSpec},
   :userPseudoId string,
   :asynchronousMode boolean,
   :searchSpec {:searchParams GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchParams,
                :searchResultList GoogleCloudDiscoveryengineV1AnswerQueryRequestSearchSpecSearchResultList},
   :query {:text string, :queryId string},
   :answerGenerationSpec {:modelSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecModelSpec,
                          :promptSpec GoogleCloudDiscoveryengineV1AnswerQueryRequestAnswerGenerationSpecPromptSpec,
                          :includeCitations boolean,
                          :answerLanguageCode string,
                          :ignoreAdversarialQuery boolean,
                          :ignoreNonAnswerSeekingQuery boolean},
   :session string}
  
  Answer query method."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:answer"
     #{:servingConfig}
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

(defn locations-dataStores-servingConfigs-recommend$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/servingConfigs/recommend
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:eventType string,
               :tagIds [string],
               :transactionInfo GoogleCloudDiscoveryengineV1TransactionInfo,
               :sessionId string,
               :searchInfo GoogleCloudDiscoveryengineV1SearchInfo,
               :userPseudoId string,
               :panel GoogleCloudDiscoveryengineV1PanelInfo,
               :documents [GoogleCloudDiscoveryengineV1DocumentInfo],
               :directUserRequest boolean,
               :filter string,
               :completionInfo GoogleCloudDiscoveryengineV1CompletionInfo,
               :mediaInfo GoogleCloudDiscoveryengineV1MediaInfo,
               :pageInfo GoogleCloudDiscoveryengineV1PageInfo,
               :eventTime string,
               :promotionIds [string],
               :attributes {},
               :attributionToken string,
               :userInfo GoogleCloudDiscoveryengineV1UserInfo},
   :pageSize integer,
   :filter string,
   :validateOnly boolean,
   :params {},
   :userLabels {}}
  
  Makes a recommendation, which requires a contextual user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+servingConfig}:recommend"
     #{:servingConfig}
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

(defn locations-dataStores-operations-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-operations-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-sessions-create$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Creates a Session. If the Session to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
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

(defn locations-dataStores-sessions-delete$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Session. If the Session to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-sessions-patch$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :state string,
   :userPseudoId string,
   :turns [{:query GoogleCloudDiscoveryengineV1Query, :answer string}],
   :startTime string,
   :endTime string}
  
  Updates a Session. Session action type cannot be changed. If the Session to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-sessions-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Session."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-dataStores-sessions-list$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  Lists all Sessions by their parent DataStore."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/sessions"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-dataStores-sessions-answers-get$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/dataStores/sessions/answers/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Answer."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://discoveryengine.googleapis.com/"
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

(defn locations-groundingConfigs-check$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/groundingConfigs/check
  
  Required parameters: groundingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:answerCandidate string,
   :facts [{:factText string, :attributes {}}],
   :groundingSpec {:citationThreshold number},
   :userLabels {}}
  
  Performs a grounding check."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:groundingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+groundingConfig}:check"
     #{:groundingConfig}
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

(defn locations-rankingConfigs-rank$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/rankingConfigs/rank
  
  Required parameters: rankingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:model string,
   :topN integer,
   :query string,
   :records [{:id string, :title string, :content string, :score number}],
   :ignoreRecordDetailsInResponse boolean}
  
  Ranks a list of text records based on the given input query."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:rankingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+rankingConfig}:rank"
     #{:rankingConfig}
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

(defn locations-userEvents-write$
  "https://cloud.google.com/discovery-engine/docsapi/reference/rest/v1/projects/locations/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventType string,
   :tagIds [string],
   :transactionInfo {:value number,
                     :currency string,
                     :transactionId string,
                     :tax number,
                     :cost number,
                     :discountValue number},
   :sessionId string,
   :searchInfo {:searchQuery string, :orderBy string, :offset integer},
   :userPseudoId string,
   :panel {:panelId string,
           :displayName string,
           :panelPosition integer,
           :totalPanels integer},
   :documents [{:id string,
                :name string,
                :uri string,
                :quantity integer,
                :promotionIds [string]}],
   :directUserRequest boolean,
   :filter string,
   :completionInfo {:selectedSuggestion string,
                    :selectedPosition integer},
   :mediaInfo {:mediaProgressDuration string,
               :mediaProgressPercentage number},
   :pageInfo {:pageviewId string,
              :pageCategory string,
              :uri string,
              :referrerUri string},
   :eventTime string,
   :promotionIds [string],
   :attributes {},
   :attributionToken string,
   :userInfo {:userId string, :userAgent string}}
  
  Writes a single user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://discoveryengine.googleapis.com/"
     "v1/{+parent}/userEvents:write"
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
