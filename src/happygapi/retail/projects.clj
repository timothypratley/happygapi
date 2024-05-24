(ns happygapi.retail.projects
  "Vertex AI Search for Retail API: projects.
  Vertex AI Search for Retail API is made up of Retail Search, Browse and Recommendations. These discovery AI solutions help you implement personalized search, browse and recommendations, based on machine learning models, across your websites and mobile applications.
  See: https://cloud.google.com/recommendationsdocs/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}/operations"
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
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :displayName string,
   :productLevelConfig {:ingestionProductType string,
                        :merchantCenterProductIdField string}}
  
  Updates the Catalogs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-getCompletionConfig$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/getCompletionConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a CompletionConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-updateAttributesConfig$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/updateAttributesConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string, :catalogAttributes {}, :attributeConfigLevel string}
  
  Updates the AttributesConfig. The catalog attributes in the request will be updated in the catalog, or inserted if they do not exist. Existing catalog attributes not included in the request will remain unchanged. Attributes that are assigned to products, but do not exist at the catalog level, are always included in the response. The product attribute is assigned default values for missing catalog attribute fields, e.g., searchable and dynamic facetable options."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-completeQuery$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/completeQuery
  
  Required parameters: catalog
  
  Optional parameters: languageCodes, maxSuggestions, visitorId, enableAttributeSuggestions, deviceType, query, entity, dataset
  
  Completes the specified prefix with keyword suggestions. This feature is only available for users who have Retail Search enabled. Enable Retail Search on Cloud Console before using this feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:catalog})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+catalog}:completeQuery"
     #{:catalog}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all the Catalogs associated with the project."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/catalogs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-updateCompletionConfig$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/updateCompletionConfig
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:minPrefixLength integer,
   :maxSuggestions integer,
   :name string,
   :matchingOrder string,
   :denylistInputConfig {:bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :lastSuggestionsImportOperation string,
   :lastDenylistImportOperation string,
   :autoLearning boolean,
   :lastAllowlistImportOperation string,
   :suggestionsInputConfig {:bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :allowlistInputConfig {:bigQuerySource GoogleCloudRetailV2BigQuerySource}}
  
  Updates the CompletionConfigs."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-setDefaultBranch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/setDefaultBranch
  
  Required parameters: catalog
  
  Optional parameters: none
  
  Body: 
  
  {:branchId string, :note string, :force boolean}
  
  Set a specified branch id as default branch. API methods such as SearchService.Search, ProductService.GetProduct, ProductService.ListProducts will treat requests using \"default_branch\" to the actual branch id set as default. For example, if `projects/*/locations/*/catalogs/*/branches/1` is set as default, setting SearchRequest.branch to `projects/*/locations/*/catalogs/*/branches/default_branch` is equivalent to setting SearchRequest.branch to `projects/*/locations/*/catalogs/*/branches/1`. Using multiple branches can be useful when developers would like to have a staging branch to test and verify for future usage. When it becomes ready, developers switch on the staging branch using this API while keeping using `projects/*/locations/*/catalogs/*/branches/default_branch` as SearchRequest.branch to route the traffic to this staging branch. CAUTION: If you have live predict/search traffic, switching the default branch could potentially cause outages if the ID space of the new branch is very different from the old one. More specifically: * PredictionService will only return product IDs from branch {newBranch}. * SearchService will only return product IDs from branch {newBranch} (if branch is not explicitly set). * UserEventService will only join events with products from branch {newBranch}."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:catalog})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+catalog}:setDefaultBranch"
     #{:catalog}
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

(defn locations-catalogs-getDefaultBranch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/getDefaultBranch
  
  Required parameters: catalog
  
  Optional parameters: none
  
  Get which branch is currently default branch set by CatalogService.SetDefaultBranch method under a specified parent catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:catalog})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+catalog}:getDefaultBranch"
     #{:catalog}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-exportAnalyticsMetrics$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/exportAnalyticsMetrics
  
  Required parameters: catalog
  
  Optional parameters: none
  
  Body: 
  
  {:outputConfig {:gcsDestination GoogleCloudRetailV2OutputConfigGcsDestination,
                  :bigqueryDestination GoogleCloudRetailV2OutputConfigBigQueryDestination},
   :filter string}
  
  Exports analytics metrics. `Operation.response` is of type `ExportAnalyticsMetricsResponse`. `Operation.metadata` is of type `ExportMetadata`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:catalog})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+catalog}:exportAnalyticsMetrics"
     #{:catalog}
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

(defn locations-catalogs-getAttributesConfig$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/getAttributesConfig
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an AttributesConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-userEvents-write$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: writeAsync
  
  Body: 
  
  {:completionDetail {:completionAttributionToken string,
                      :selectedSuggestion string,
                      :selectedPosition integer},
   :eventType string,
   :cartId string,
   :pageViewId string,
   :sessionId string,
   :offset integer,
   :productDetails [{:product GoogleCloudRetailV2Product,
                     :quantity integer}],
   :purchaseTransaction {:id string,
                         :revenue number,
                         :tax number,
                         :cost number,
                         :currencyCode string},
   :searchQuery string,
   :filter string,
   :visitorId string,
   :referrerUri string,
   :pageCategories [string],
   :eventTime string,
   :uri string,
   :attributes {},
   :entity string,
   :attributionToken string,
   :experimentIds [string],
   :userInfo {:userId string,
              :ipAddress string,
              :userAgent string,
              :directUserRequest boolean},
   :orderBy string}
  
  Writes a single user event."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/userEvents:write"
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

(defn locations-catalogs-userEvents-collect$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/collect
  
  Required parameters: parent
  
  Optional parameters: prebuiltRule, userEvent, uri, ets, rawJson
  
  Writes a single user event from the browser. This uses a GET request to due to browser restriction of POST-ing to a 3rd party domain. This method is used only by the Retail API JavaScript pixel and Google Tag Manager. Users should not call this method directly."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/userEvents:collect"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-userEvents-purge$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Deletes permanently all user events specified by the filter provided. Depending on the number of events specified by the filter, this operation could take hours or days to complete. To test a filter, use the list command first."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/userEvents:purge"
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

(defn locations-catalogs-userEvents-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:userEventInlineSource GoogleCloudRetailV2UserEventInlineSource,
                 :gcsSource GoogleCloudRetailV2GcsSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :errorsConfig {:gcsPrefix string}}
  
  Bulk import of User events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. `Operation.response` is of type `ImportResponse`. Note that it is possible for a subset of the items to be successfully inserted. `Operation.metadata` is of type `ImportMetadata`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/userEvents:import"
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

(defn locations-catalogs-userEvents-rejoin$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/rejoin
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:userEventRejoinScope string}
  
  Starts a user-event rejoin operation with latest product catalog. Events are not annotated with detailed product information for products that are missing from the catalog when the user event is ingested. These events are stored as unjoined events with limited usage on training and serving. You can use this method to start a join operation on specified events with the latest version of product catalog. You can also use this method to correct events joined with the wrong product catalog. A rejoin operation can take hours or days to complete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/userEvents:rejoin"
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

(defn locations-catalogs-attributesConfig-addCatalogAttribute$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/attributesConfig/addCatalogAttribute
  
  Required parameters: attributesConfig
  
  Optional parameters: none
  
  Body: 
  
  {:catalogAttribute {:indexableOption string,
                      :key string,
                      :dynamicFacetableOption string,
                      :type string,
                      :searchableOption string,
                      :inUse boolean,
                      :facetConfig GoogleCloudRetailV2CatalogAttributeFacetConfig,
                      :exactSearchableOption string,
                      :retrievableOption string}}
  
  Adds the specified CatalogAttribute to the AttributesConfig. If the CatalogAttribute to add already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:attributesConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+attributesConfig}:addCatalogAttribute"
     #{:attributesConfig}
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

(defn locations-catalogs-attributesConfig-removeCatalogAttribute$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/attributesConfig/removeCatalogAttribute
  
  Required parameters: attributesConfig
  
  Optional parameters: none
  
  Body: 
  
  {:key string}
  
  Removes the specified CatalogAttribute from the AttributesConfig. If the CatalogAttribute to remove does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:attributesConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+attributesConfig}:removeCatalogAttribute"
     #{:attributesConfig}
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

(defn locations-catalogs-attributesConfig-replaceCatalogAttribute$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/attributesConfig/replaceCatalogAttribute
  
  Required parameters: attributesConfig
  
  Optional parameters: none
  
  Body: 
  
  {:catalogAttribute {:indexableOption string,
                      :key string,
                      :dynamicFacetableOption string,
                      :type string,
                      :searchableOption string,
                      :inUse boolean,
                      :facetConfig GoogleCloudRetailV2CatalogAttributeFacetConfig,
                      :exactSearchableOption string,
                      :retrievableOption string},
   :updateMask string}
  
  Replaces the specified CatalogAttribute in the AttributesConfig by updating the catalog attribute with the same CatalogAttribute.key. If the CatalogAttribute to replace does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:attributesConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+attributesConfig}:replaceCatalogAttribute"
     #{:attributesConfig}
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

(defn locations-catalogs-completionData-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/completionData/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :notificationPubsubTopic string}
  
  Bulk import of processed completion dataset. Request processing is asynchronous. Partial updating is not supported. The operation is successfully finished only after the imported suggestions are indexed successfully and ready for serving. The process takes hours. This feature is only available for users who have Retail Search enabled. Enable Retail Search on Cloud Console before using this feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/completionData:import"
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

(defn locations-catalogs-placements-search$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/placements/search
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:dynamicFacetSpec {:mode string},
   :labels {},
   :searchMode string,
   :canonicalFilter string,
   :offset integer,
   :pageToken string,
   :facetSpecs [{:facetKey GoogleCloudRetailV2SearchRequestFacetSpecFacetKey,
                 :limit integer,
                 :excludedFilterKeys [string],
                 :enableDynamicPosition boolean}],
   :filter string,
   :pageSize integer,
   :visitorId string,
   :pageCategories [string],
   :variantRollupKeys [string],
   :query string,
   :branch string,
   :entity string,
   :queryExpansionSpec {:condition string,
                        :pinUnexpandedResults boolean},
   :boostSpec {:conditionBoostSpecs [GoogleCloudRetailV2SearchRequestBoostSpecConditionBoostSpec],
               :skipBoostSpecValidation boolean},
   :spellCorrectionSpec {:mode string},
   :userInfo {:userId string,
              :ipAddress string,
              :userAgent string,
              :directUserRequest boolean},
   :orderBy string,
   :personalizationSpec {:mode string}}
  
  Performs a search. This feature is only available for users who have Retail Search enabled. Enable Retail Search on Cloud Console before using this feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:placement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+placement}:search"
     #{:placement}
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

(defn locations-catalogs-placements-predict$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/placements/predict
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:completionDetail GoogleCloudRetailV2CompletionDetail,
               :eventType string,
               :cartId string,
               :pageViewId string,
               :sessionId string,
               :offset integer,
               :productDetails [GoogleCloudRetailV2ProductDetail],
               :purchaseTransaction GoogleCloudRetailV2PurchaseTransaction,
               :searchQuery string,
               :filter string,
               :visitorId string,
               :referrerUri string,
               :pageCategories [string],
               :eventTime string,
               :uri string,
               :attributes {},
               :entity string,
               :attributionToken string,
               :experimentIds [string],
               :userInfo GoogleCloudRetailV2UserInfo,
               :orderBy string},
   :pageSize integer,
   :pageToken string,
   :filter string,
   :validateOnly boolean,
   :params {},
   :labels {}}
  
  Makes a recommendation prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:placement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+placement}:predict"
     #{:placement}
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

(defn locations-catalogs-branches-operations-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-branches-products-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-branches-products-setInventory$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/setInventory
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:inventory {:promotions [GoogleCloudRetailV2Promotion],
               :description string,
               :tags [string],
               :availableTime string,
               :availability string,
               :sizes [string],
               :variants [GoogleCloudRetailV2Product],
               :localInventories [GoogleCloudRetailV2LocalInventory],
               :publishTime string,
               :retrievableFields string,
               :images [GoogleCloudRetailV2Image],
               :colorInfo GoogleCloudRetailV2ColorInfo,
               :primaryProductId string,
               :patterns [string],
               :name string,
               :availableQuantity integer,
               :collectionMemberIds [string],
               :type string,
               :title string,
               :priceInfo GoogleCloudRetailV2PriceInfo,
               :ttl string,
               :categories [string],
               :languageCode string,
               :conditions [string],
               :fulfillmentInfo [GoogleCloudRetailV2FulfillmentInfo],
               :id string,
               :audience GoogleCloudRetailV2Audience,
               :materials [string],
               :expireTime string,
               :uri string,
               :gtin string,
               :attributes {},
               :rating GoogleCloudRetailV2Rating,
               :brands [string]},
   :setMask string,
   :setTime string,
   :allowMissing boolean}
  
  Updates inventory information for a Product while respecting the last update timestamps of each inventory field. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update is enqueued and processed downstream. As a consequence, when a response is returned, updates are not immediately manifested in the Product queried by ProductService.GetProduct or ProductService.ListProducts. When inventory is updated with ProductService.CreateProduct and ProductService.UpdateProduct, the specified inventory field value(s) overwrite any existing value(s) while ignoring the last update time for this field. Furthermore, the last update times for the specified inventory fields are overwritten by the times of the ProductService.CreateProduct or ProductService.UpdateProduct request. If no inventory fields are set in CreateProductRequest.product, then any pre-existing inventory information for this product is used. If no inventory fields are set in SetInventoryRequest.set_mask, then any existing inventory information is preserved. Pre-existing inventory information can only be updated with ProductService.SetInventory, ProductService.AddFulfillmentPlaces, and ProductService.RemoveFulfillmentPlaces. The returned Operations is obsolete after one day, and the GetOperation API returns `NOT_FOUND` afterwards. If conflicting updates are issued, the Operations associated with the stale updates are not marked as done until they are obsolete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}:setInventory"
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

(defn locations-catalogs-branches-products-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:promotions [{:promotionId string}],
   :description string,
   :tags [string],
   :availableTime string,
   :availability string,
   :sizes [string],
   :variants [{:promotions [GoogleCloudRetailV2Promotion],
               :description string,
               :tags [string],
               :availableTime string,
               :availability string,
               :sizes [string],
               :variants [GoogleCloudRetailV2Product],
               :localInventories [GoogleCloudRetailV2LocalInventory],
               :publishTime string,
               :retrievableFields string,
               :images [GoogleCloudRetailV2Image],
               :colorInfo GoogleCloudRetailV2ColorInfo,
               :primaryProductId string,
               :patterns [string],
               :name string,
               :availableQuantity integer,
               :collectionMemberIds [string],
               :type string,
               :title string,
               :priceInfo GoogleCloudRetailV2PriceInfo,
               :ttl string,
               :categories [string],
               :languageCode string,
               :conditions [string],
               :fulfillmentInfo [GoogleCloudRetailV2FulfillmentInfo],
               :id string,
               :audience GoogleCloudRetailV2Audience,
               :materials [string],
               :expireTime string,
               :uri string,
               :gtin string,
               :attributes {},
               :rating GoogleCloudRetailV2Rating,
               :brands [string]}],
   :localInventories [{:placeId string,
                       :priceInfo GoogleCloudRetailV2PriceInfo,
                       :attributes {},
                       :fulfillmentTypes [string]}],
   :publishTime string,
   :retrievableFields string,
   :images [{:uri string, :height integer, :width integer}],
   :colorInfo {:colorFamilies [string], :colors [string]},
   :primaryProductId string,
   :patterns [string],
   :name string,
   :availableQuantity integer,
   :collectionMemberIds [string],
   :type string,
   :title string,
   :priceInfo {:currencyCode string,
               :price number,
               :originalPrice number,
               :cost number,
               :priceEffectiveTime string,
               :priceExpireTime string,
               :priceRange GoogleCloudRetailV2PriceInfoPriceRange},
   :ttl string,
   :categories [string],
   :languageCode string,
   :conditions [string],
   :fulfillmentInfo [{:type string, :placeIds [string]}],
   :id string,
   :audience {:genders [string], :ageGroups [string]},
   :materials [string],
   :expireTime string,
   :uri string,
   :gtin string,
   :attributes {},
   :rating {:ratingCount integer,
            :averageRating number,
            :ratingHistogram [integer]},
   :brands [string]}
  
  Updates a Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-branches-products-create$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/create
  
  Required parameters: parent
  
  Optional parameters: productId
  
  Body: 
  
  {:promotions [{:promotionId string}],
   :description string,
   :tags [string],
   :availableTime string,
   :availability string,
   :sizes [string],
   :variants [{:promotions [GoogleCloudRetailV2Promotion],
               :description string,
               :tags [string],
               :availableTime string,
               :availability string,
               :sizes [string],
               :variants [GoogleCloudRetailV2Product],
               :localInventories [GoogleCloudRetailV2LocalInventory],
               :publishTime string,
               :retrievableFields string,
               :images [GoogleCloudRetailV2Image],
               :colorInfo GoogleCloudRetailV2ColorInfo,
               :primaryProductId string,
               :patterns [string],
               :name string,
               :availableQuantity integer,
               :collectionMemberIds [string],
               :type string,
               :title string,
               :priceInfo GoogleCloudRetailV2PriceInfo,
               :ttl string,
               :categories [string],
               :languageCode string,
               :conditions [string],
               :fulfillmentInfo [GoogleCloudRetailV2FulfillmentInfo],
               :id string,
               :audience GoogleCloudRetailV2Audience,
               :materials [string],
               :expireTime string,
               :uri string,
               :gtin string,
               :attributes {},
               :rating GoogleCloudRetailV2Rating,
               :brands [string]}],
   :localInventories [{:placeId string,
                       :priceInfo GoogleCloudRetailV2PriceInfo,
                       :attributes {},
                       :fulfillmentTypes [string]}],
   :publishTime string,
   :retrievableFields string,
   :images [{:uri string, :height integer, :width integer}],
   :colorInfo {:colorFamilies [string], :colors [string]},
   :primaryProductId string,
   :patterns [string],
   :name string,
   :availableQuantity integer,
   :collectionMemberIds [string],
   :type string,
   :title string,
   :priceInfo {:currencyCode string,
               :price number,
               :originalPrice number,
               :cost number,
               :priceEffectiveTime string,
               :priceExpireTime string,
               :priceRange GoogleCloudRetailV2PriceInfoPriceRange},
   :ttl string,
   :categories [string],
   :languageCode string,
   :conditions [string],
   :fulfillmentInfo [{:type string, :placeIds [string]}],
   :id string,
   :audience {:genders [string], :ageGroups [string]},
   :materials [string],
   :expireTime string,
   :uri string,
   :gtin string,
   :attributes {},
   :rating {:ratingCount integer,
            :averageRating number,
            :ratingHistogram [integer]},
   :brands [string]}
  
  Creates a Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/products"
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

(defn locations-catalogs-branches-products-addFulfillmentPlaces$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/addFulfillmentPlaces
  
  Required parameters: product
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :placeIds [string],
   :addTime string,
   :allowMissing boolean}
  
  We recommend that you use the ProductService.AddLocalInventories method instead of the ProductService.AddFulfillmentPlaces method. ProductService.AddLocalInventories achieves the same results but provides more fine-grained control over ingesting local inventory data. Incrementally adds place IDs to Product.fulfillment_info.place_ids. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, the added place IDs are not immediately manifested in the Product queried by ProductService.GetProduct or ProductService.ListProducts. The returned Operations will be obsolete after 1 day, and GetOperation API will return NOT_FOUND afterwards. If conflicting updates are issued, the Operations associated with the stale updates will not be marked as done until being obsolete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:product})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+product}:addFulfillmentPlaces"
     #{:product}
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

(defn locations-catalogs-branches-products-delete$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Product."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-branches-products-removeFulfillmentPlaces$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/removeFulfillmentPlaces
  
  Required parameters: product
  
  Optional parameters: none
  
  Body: 
  
  {:type string,
   :placeIds [string],
   :removeTime string,
   :allowMissing boolean}
  
  We recommend that you use the ProductService.RemoveLocalInventories method instead of the ProductService.RemoveFulfillmentPlaces method. ProductService.RemoveLocalInventories achieves the same results but provides more fine-grained control over ingesting local inventory data. Incrementally removes place IDs from a Product.fulfillment_info.place_ids. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, the removed place IDs are not immediately manifested in the Product queried by ProductService.GetProduct or ProductService.ListProducts. The returned Operations will be obsolete after 1 day, and GetOperation API will return NOT_FOUND afterwards. If conflicting updates are issued, the Operations associated with the stale updates will not be marked as done until being obsolete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:product})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+product}:removeFulfillmentPlaces"
     #{:product}
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

(defn locations-catalogs-branches-products-addLocalInventories$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/addLocalInventories
  
  Required parameters: product
  
  Optional parameters: none
  
  Body: 
  
  {:localInventories [{:placeId string,
                       :priceInfo GoogleCloudRetailV2PriceInfo,
                       :attributes {},
                       :fulfillmentTypes [string]}],
   :addMask string,
   :addTime string,
   :allowMissing boolean}
  
  Updates local inventory information for a Product at a list of places, while respecting the last update timestamps of each inventory field. This process is asynchronous and does not require the Product to exist before updating inventory information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, updates are not immediately manifested in the Product queried by ProductService.GetProduct or ProductService.ListProducts. Local inventory information can only be modified using this method. ProductService.CreateProduct and ProductService.UpdateProduct has no effect on local inventories. The returned Operations will be obsolete after 1 day, and GetOperation API will return NOT_FOUND afterwards. If conflicting updates are issued, the Operations associated with the stale updates will not be marked as done until being obsolete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:product})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+product}:addLocalInventories"
     #{:product}
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

(defn locations-catalogs-branches-products-removeLocalInventories$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/removeLocalInventories
  
  Required parameters: product
  
  Optional parameters: none
  
  Body: 
  
  {:placeIds [string], :removeTime string, :allowMissing boolean}
  
  Remove local inventory information for a Product at a list of places at a removal timestamp. This process is asynchronous. If the request is valid, the removal will be enqueued and processed downstream. As a consequence, when a response is returned, removals are not immediately manifested in the Product queried by ProductService.GetProduct or ProductService.ListProducts. Local inventory information can only be removed using this method. ProductService.CreateProduct and ProductService.UpdateProduct has no effect on local inventories. The returned Operations will be obsolete after 1 day, and GetOperation API will return NOT_FOUND afterwards. If conflicting updates are issued, the Operations associated with the stale updates will not be marked as done until being obsolete."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:product})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+product}:removeLocalInventories"
     #{:product}
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

(defn locations-catalogs-branches-products-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, readMask
  
  Gets a list of Products."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/products"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-branches-products-purge$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/purge
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:filter string, :force boolean}
  
  Permanently deletes all selected Products under a branch. This process is asynchronous. If the request is valid, the removal will be enqueued and processed offline. Depending on the number of Products, this operation could take hours to complete. Before the operation completes, some Products may still be returned by ProductService.GetProduct or ProductService.ListProducts. Depending on the number of Products, this operation could take hours to complete. To get a sample of Products that would be deleted, set PurgeProductsRequest.force to false."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/products:purge"
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

(defn locations-catalogs-branches-products-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requestId string,
   :inputConfig {:productInlineSource GoogleCloudRetailV2ProductInlineSource,
                 :gcsSource GoogleCloudRetailV2GcsSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :errorsConfig {:gcsPrefix string},
   :updateMask string,
   :reconciliationMode string,
   :notificationPubsubTopic string}
  
  Bulk import of multiple Products. Request processing may be synchronous. Non-existing items are created. Note that it is possible for a subset of the Products to be successfully updated."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/products:import"
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

(defn locations-catalogs-controls-create$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/controls/create
  
  Required parameters: parent
  
  Optional parameters: controlId
  
  Body: 
  
  {:rule {:ignoreAction GoogleCloudRetailV2RuleIgnoreAction,
          :doNotAssociateAction GoogleCloudRetailV2RuleDoNotAssociateAction,
          :twowaySynonymsAction GoogleCloudRetailV2RuleTwowaySynonymsAction,
          :forceReturnFacetAction GoogleCloudRetailV2RuleForceReturnFacetAction,
          :redirectAction GoogleCloudRetailV2RuleRedirectAction,
          :condition GoogleCloudRetailV2Condition,
          :onewaySynonymsAction GoogleCloudRetailV2RuleOnewaySynonymsAction,
          :replacementAction GoogleCloudRetailV2RuleReplacementAction,
          :removeFacetAction GoogleCloudRetailV2RuleRemoveFacetAction,
          :boostAction GoogleCloudRetailV2RuleBoostAction,
          :filterAction GoogleCloudRetailV2RuleFilterAction},
   :name string,
   :displayName string,
   :associatedServingConfigIds [string],
   :solutionTypes [string],
   :searchSolutionUseCase [string]}
  
  Creates a Control. If the Control to create already exists, an ALREADY_EXISTS error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/controls"
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

(defn locations-catalogs-controls-delete$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/controls/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a Control. If the Control to delete does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-controls-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/controls/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:rule {:ignoreAction GoogleCloudRetailV2RuleIgnoreAction,
          :doNotAssociateAction GoogleCloudRetailV2RuleDoNotAssociateAction,
          :twowaySynonymsAction GoogleCloudRetailV2RuleTwowaySynonymsAction,
          :forceReturnFacetAction GoogleCloudRetailV2RuleForceReturnFacetAction,
          :redirectAction GoogleCloudRetailV2RuleRedirectAction,
          :condition GoogleCloudRetailV2Condition,
          :onewaySynonymsAction GoogleCloudRetailV2RuleOnewaySynonymsAction,
          :replacementAction GoogleCloudRetailV2RuleReplacementAction,
          :removeFacetAction GoogleCloudRetailV2RuleRemoveFacetAction,
          :boostAction GoogleCloudRetailV2RuleBoostAction,
          :filterAction GoogleCloudRetailV2RuleFilterAction},
   :name string,
   :displayName string,
   :associatedServingConfigIds [string],
   :solutionTypes [string],
   :searchSolutionUseCase [string]}
  
  Updates a Control. Control cannot be set to a different oneof field, if so an INVALID_ARGUMENT is returned. If the Control to update does not exist, a NOT_FOUND error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-controls-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/controls/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a Control."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-controls-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/controls/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all Controls by their parent Catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/controls"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-models-create$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/create
  
  Required parameters: parent
  
  Optional parameters: dryRun
  
  Body: 
  
  {:servingState string,
   :displayName string,
   :tuningOperation string,
   :name string,
   :servingConfigLists [{:servingConfigIds [string]}],
   :createTime string,
   :dataState string,
   :type string,
   :periodicTuningState string,
   :updateTime string,
   :optimizationObjective string,
   :trainingState string,
   :modelFeaturesConfig {:frequentlyBoughtTogetherConfig GoogleCloudRetailV2ModelFrequentlyBoughtTogetherFeaturesConfig},
   :filteringOption string,
   :lastTuneTime string}
  
  Creates a new model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/models"
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

(defn locations-catalogs-models-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-models-pause$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses the training of an existing model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}:pause"
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

(defn locations-catalogs-models-resume$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes the training of an existing model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}:resume"
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

(defn locations-catalogs-models-delete$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-models-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all the models linked to this event store."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/models"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-models-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:servingState string,
   :displayName string,
   :tuningOperation string,
   :name string,
   :servingConfigLists [{:servingConfigIds [string]}],
   :createTime string,
   :dataState string,
   :type string,
   :periodicTuningState string,
   :updateTime string,
   :optimizationObjective string,
   :trainingState string,
   :modelFeaturesConfig {:frequentlyBoughtTogetherConfig GoogleCloudRetailV2ModelFrequentlyBoughtTogetherFeaturesConfig},
   :filteringOption string,
   :lastTuneTime string}
  
  Update of model metadata. Only fields that currently can be updated are: `filtering_option` and `periodic_tuning_state`. If other values are provided, this API method ignores them."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-models-tune$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/models/tune
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Tunes an existing model."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}:tune"
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

(defn locations-catalogs-servingConfigs-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a ServingConfig. Returns a NotFound error if the ServingConfig does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-servingConfigs-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:dynamicFacetSpec {:mode string},
   :onewaySynonymsControlIds [string],
   :displayName string,
   :filterControlIds [string],
   :name string,
   :diversityLevel string,
   :modelId string,
   :facetControlIds [string],
   :solutionTypes [string],
   :doNotAssociateControlIds [string],
   :ignoreRecsDenylist boolean,
   :enableCategoryFilterLevel string,
   :priceRerankingLevel string,
   :diversityType string,
   :redirectControlIds [string],
   :twowaySynonymsControlIds [string],
   :ignoreControlIds [string],
   :replacementControlIds [string],
   :boostControlIds [string],
   :personalizationSpec {:mode string}}
  
  Updates a ServingConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-servingConfigs-create$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/create
  
  Required parameters: parent
  
  Optional parameters: servingConfigId
  
  Body: 
  
  {:dynamicFacetSpec {:mode string},
   :onewaySynonymsControlIds [string],
   :displayName string,
   :filterControlIds [string],
   :name string,
   :diversityLevel string,
   :modelId string,
   :facetControlIds [string],
   :solutionTypes [string],
   :doNotAssociateControlIds [string],
   :ignoreRecsDenylist boolean,
   :enableCategoryFilterLevel string,
   :priceRerankingLevel string,
   :diversityType string,
   :redirectControlIds [string],
   :twowaySynonymsControlIds [string],
   :ignoreControlIds [string],
   :replacementControlIds [string],
   :boostControlIds [string],
   :personalizationSpec {:mode string}}
  
  Creates a ServingConfig. A maximum of 100 ServingConfigs are allowed in a Catalog, otherwise a FAILED_PRECONDITION error is returned."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/servingConfigs"
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

(defn locations-catalogs-servingConfigs-addControl$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/addControl
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:controlId string}
  
  Enables a Control on the specified ServingConfig. The control is added in the last position of the list of controls it belongs to (e.g. if it's a facet spec control it will be applied in the last position of servingConfig.facetSpecIds) Returns a ALREADY_EXISTS error if the control has already been applied. Returns a FAILED_PRECONDITION error if the addition could exceed maximum number of control allowed for that type of control."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+servingConfig}:addControl"
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

(defn locations-catalogs-servingConfigs-delete$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes a ServingConfig. Returns a NotFound error if the ServingConfig does not exist."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn locations-catalogs-servingConfigs-removeControl$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/removeControl
  
  Required parameters: servingConfig
  
  Optional parameters: none
  
  Body: 
  
  {:controlId string}
  
  Disables a Control on the specified ServingConfig. The control is removed from the ServingConfig. Returns a NOT_FOUND error if the Control is not enabled for the ServingConfig."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:servingConfig})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+servingConfig}:removeControl"
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

(defn locations-catalogs-servingConfigs-search$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/search
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:dynamicFacetSpec {:mode string},
   :labels {},
   :searchMode string,
   :canonicalFilter string,
   :offset integer,
   :pageToken string,
   :facetSpecs [{:facetKey GoogleCloudRetailV2SearchRequestFacetSpecFacetKey,
                 :limit integer,
                 :excludedFilterKeys [string],
                 :enableDynamicPosition boolean}],
   :filter string,
   :pageSize integer,
   :visitorId string,
   :pageCategories [string],
   :variantRollupKeys [string],
   :query string,
   :branch string,
   :entity string,
   :queryExpansionSpec {:condition string,
                        :pinUnexpandedResults boolean},
   :boostSpec {:conditionBoostSpecs [GoogleCloudRetailV2SearchRequestBoostSpecConditionBoostSpec],
               :skipBoostSpecValidation boolean},
   :spellCorrectionSpec {:mode string},
   :userInfo {:userId string,
              :ipAddress string,
              :userAgent string,
              :directUserRequest boolean},
   :orderBy string,
   :personalizationSpec {:mode string}}
  
  Performs a search. This feature is only available for users who have Retail Search enabled. Enable Retail Search on Cloud Console before using this feature."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:placement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+placement}:search"
     #{:placement}
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

(defn locations-catalogs-servingConfigs-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all ServingConfigs linked to this catalog."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+parent}/servingConfigs"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-servingConfigs-predict$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/servingConfigs/predict
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:userEvent {:completionDetail GoogleCloudRetailV2CompletionDetail,
               :eventType string,
               :cartId string,
               :pageViewId string,
               :sessionId string,
               :offset integer,
               :productDetails [GoogleCloudRetailV2ProductDetail],
               :purchaseTransaction GoogleCloudRetailV2PurchaseTransaction,
               :searchQuery string,
               :filter string,
               :visitorId string,
               :referrerUri string,
               :pageCategories [string],
               :eventTime string,
               :uri string,
               :attributes {},
               :entity string,
               :attributionToken string,
               :experimentIds [string],
               :userInfo GoogleCloudRetailV2UserInfo,
               :orderBy string},
   :pageSize integer,
   :pageToken string,
   :filter string,
   :validateOnly boolean,
   :params {},
   :labels {}}
  
  Makes a recommendation prediction."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:placement})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+placement}:predict"
     #{:placement}
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

(defn locations-catalogs-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}/operations"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locations-catalogs-operations-get$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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

(defn operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
     "v2/{+name}/operations"
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
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/operations/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the latest state of a long-running operation. Clients can use this method to poll the operation result at intervals as recommended by the API service."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://retail.googleapis.com/"
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
