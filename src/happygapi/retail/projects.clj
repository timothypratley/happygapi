(ns happygapi.retail.projects
  "Retail API: projects.
  Cloud Retail service enables customers to build end-to-end personalized recommendation systems without requiring a high level of expertise in machine learning, recommendation system, or Google Cloud.
  See: https://cloud.google.com/recommendationsapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

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

(defn locations-catalogs-completeQuery$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/completeQuery
  
  Required parameters: catalog
  
  Optional parameters: languageCodes, maxSuggestions, query, visitorId, dataset, deviceType
  
  Completes the specified prefix with keyword suggestions. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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

(defn locations-catalogs-getDefaultBranch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/getDefaultBranch
  
  Required parameters: catalog
  
  Optional parameters: none
  
  Get which branch is currently default branch set by CatalogService.SetDefaultBranch method under a specified parent catalog. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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

(defn locations-catalogs-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :productLevelConfig {:merchantCenterProductIdField string,
                        :ingestionProductType string},
   :name string}
  
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

(defn locations-catalogs-setDefaultBranch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/setDefaultBranch
  
  Required parameters: catalog
  
  Optional parameters: none
  
  Body: 
  
  {:note string, :branchId string}
  
  Set a specified branch id as default branch. API methods such as SearchService.Search, ProductService.GetProduct, ProductService.ListProducts will treat requests using \"default_branch\" to the actual branch id set as default. For example, if `projects/*/locations/*/catalogs/*/branches/1` is set as default, setting SearchRequest.branch to `projects/*/locations/*/catalogs/*/branches/default_branch` is equivalent to setting SearchRequest.branch to `projects/*/locations/*/catalogs/*/branches/1`. Using multiple branches can be useful when developers would like to have a staging branch to test and verify for future usage. When it becomes ready, developers switch on the staging branch using this API while keeping using `projects/*/locations/*/catalogs/*/branches/default_branch` as SearchRequest.branch to route the traffic to this staging branch. CAUTION: If you have live predict/search traffic, switching the default branch could potentially cause outages if the ID space of the new branch is very different from the old one. More specifically: * PredictionService will only return product IDs from branch {newBranch}. * SearchService will only return product IDs from branch {newBranch} (if branch is not explicitly set). * UserEventService will only join events with products from branch {newBranch}. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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

(defn locations-catalogs-completionData-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/completionData/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:inputConfig {:bigQuerySource GoogleCloudRetailV2BigQuerySource},
   :notificationPubsubTopic string}
  
  Bulk import of processed completion dataset. Request processing may be synchronous. Partial updating is not supported. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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

(defn locations-catalogs-userEvents-rejoin$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/rejoin
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:userEventRejoinScope string}
  
  Triggers a user event rejoin operation with latest product catalog. Events will not be annotated with detailed product information if product is missing from the catalog at the time the user event is ingested, and these events are stored as unjoined events with a limited usage on training and serving. This API can be used to trigger a 'join' operation on specified events with latest version of product catalog. It can also be used to correct events joined with wrong product catalog."
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

(defn locations-catalogs-userEvents-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:errorsConfig {:gcsPrefix string},
   :inputConfig {:userEventInlineSource GoogleCloudRetailV2UserEventInlineSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource,
                 :gcsSource GoogleCloudRetailV2GcsSource}}
  
  Bulk import of User events. Request processing might be synchronous. Events that already exist are skipped. Use this method for backfilling historical user events. Operation.response is of type ImportResponse. Note that it is possible for a subset of the items to be successfully inserted. Operation.metadata is of type ImportMetadata."
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

(defn locations-catalogs-userEvents-collect$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/collect
  
  Required parameters: parent
  
  Optional parameters: uri, ets, userEvent
  
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

(defn locations-catalogs-userEvents-write$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:completionDetail {:selectedSuggestion string,
                      :completionAttributionToken string,
                      :selectedPosition integer},
   :eventType string,
   :cartId string,
   :pageViewId string,
   :sessionId string,
   :offset integer,
   :productDetails [{:product GoogleCloudRetailV2Product,
                     :quantity integer}],
   :purchaseTransaction {:tax number,
                         :id string,
                         :currencyCode string,
                         :cost number,
                         :revenue number},
   :searchQuery string,
   :filter string,
   :visitorId string,
   :referrerUri string,
   :pageCategories [string],
   :eventTime string,
   :uri string,
   :attributes {},
   :attributionToken string,
   :experimentIds [string],
   :userInfo {:userAgent string,
              :ipAddress string,
              :directUserRequest boolean,
              :userId string},
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

(defn locations-catalogs-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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

(defn locations-catalogs-placements-predict$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/placements/predict
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:pageSize integer,
   :labels {},
   :validateOnly boolean,
   :pageToken string,
   :userEvent {:completionDetail GoogleCloudRetailV2CompletionDetail,
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
               :attributionToken string,
               :experimentIds [string],
               :userInfo GoogleCloudRetailV2UserInfo,
               :orderBy string},
   :filter string,
   :params {}}
  
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

(defn locations-catalogs-placements-search$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/placements/search
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:dynamicFacetSpec {:mode string},
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
   :queryExpansionSpec {:pinUnexpandedResults boolean,
                        :condition string},
   :boostSpec {:conditionBoostSpecs [GoogleCloudRetailV2SearchRequestBoostSpecConditionBoostSpec]},
   :userInfo {:userAgent string,
              :ipAddress string,
              :directUserRequest boolean,
              :userId string},
   :orderBy string}
  
  Performs a search. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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
  
  {:setTime string,
   :allowMissing boolean,
   :inventory {:promotions [GoogleCloudRetailV2Promotion],
               :description string,
               :tags [string],
               :availableTime string,
               :availability string,
               :sizes [string],
               :variants [GoogleCloudRetailV2Product],
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
   :setMask string}
  
  Updates inventory information for a Product while respecting the last update timestamps of each inventory field. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, updates are not immediately manifested in the Product queried by GetProduct or ListProducts. When inventory is updated with CreateProduct and UpdateProduct, the specified inventory field value(s) will overwrite any existing value(s) while ignoring the last update time for this field. Furthermore, the last update time for the specified inventory fields will be overwritten to the time of the CreateProduct or UpdateProduct request. If no inventory fields are set in CreateProductRequest.product, then any pre-existing inventory information for this product will be used. If no inventory fields are set in UpdateProductRequest.set_mask, then any existing inventory information will be preserved. Pre-existing inventory information can only be updated with SetInventory, AddFulfillmentPlaces, and RemoveFulfillmentPlaces. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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
   :publishTime string,
   :retrievableFields string,
   :images [{:height integer, :width integer, :uri string}],
   :colorInfo {:colorFamilies [string], :colors [string]},
   :primaryProductId string,
   :patterns [string],
   :name string,
   :availableQuantity integer,
   :collectionMemberIds [string],
   :type string,
   :title string,
   :priceInfo {:cost number,
               :priceRange GoogleCloudRetailV2PriceInfoPriceRange,
               :price number,
               :currencyCode string,
               :priceEffectiveTime string,
               :priceExpireTime string,
               :originalPrice number},
   :ttl string,
   :categories [string],
   :languageCode string,
   :conditions [string],
   :fulfillmentInfo [{:placeIds [string], :type string}],
   :id string,
   :audience {:ageGroups [string], :genders [string]},
   :materials [string],
   :expireTime string,
   :uri string,
   :gtin string,
   :attributes {},
   :rating {:ratingHistogram [integer],
            :averageRating number,
            :ratingCount integer},
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
   :publishTime string,
   :retrievableFields string,
   :images [{:height integer, :width integer, :uri string}],
   :colorInfo {:colorFamilies [string], :colors [string]},
   :primaryProductId string,
   :patterns [string],
   :name string,
   :availableQuantity integer,
   :collectionMemberIds [string],
   :type string,
   :title string,
   :priceInfo {:cost number,
               :priceRange GoogleCloudRetailV2PriceInfoPriceRange,
               :price number,
               :currencyCode string,
               :priceEffectiveTime string,
               :priceExpireTime string,
               :originalPrice number},
   :ttl string,
   :categories [string],
   :languageCode string,
   :conditions [string],
   :fulfillmentInfo [{:placeIds [string], :type string}],
   :id string,
   :audience {:ageGroups [string], :genders [string]},
   :materials [string],
   :expireTime string,
   :uri string,
   :gtin string,
   :attributes {},
   :rating {:ratingHistogram [integer],
            :averageRating number,
            :ratingCount integer},
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
  
  Incrementally adds place IDs to Product.fulfillment_info.place_ids. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, the added place IDs are not immediately manifested in the Product queried by GetProduct or ListProducts. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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
  
  {:allowMissing boolean,
   :type string,
   :removeTime string,
   :placeIds [string]}
  
  Incrementally removes place IDs from a Product.fulfillment_info.place_ids. This process is asynchronous and does not require the Product to exist before updating fulfillment information. If the request is valid, the update will be enqueued and processed downstream. As a consequence, when a response is returned, the removed place IDs are not immediately manifested in the Product queried by GetProduct or ListProducts. This feature is only available for users who have Retail Search enabled. Please submit a form [here](https://cloud.google.com/contact) to contact cloud sales if you are interested in using Retail Search."
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

(defn locations-catalogs-branches-products-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageToken, pageSize, readMask
  
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

(defn locations-catalogs-branches-products-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:notificationPubsubTopic string,
   :updateMask string,
   :requestId string,
   :errorsConfig {:gcsPrefix string},
   :inputConfig {:gcsSource GoogleCloudRetailV2GcsSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource,
                 :productInlineSource GoogleCloudRetailV2ProductInlineSource},
   :reconciliationMode string}
  
  Bulk import of multiple Products. Request processing may be synchronous. No partial updating is supported. Non-existing items are created. Note that it is possible for a subset of the Products to be successfully updated."
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

(defn locations-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists operations that match the specified filter in the request. If the server doesn't support this method, it returns `UNIMPLEMENTED`. NOTE: the `name` binding allows API services to override the binding to use different resource name schemes, such as `users/*/operations`. To override the binding, API services can add a binding such as `\"/v1/{name=users/*}/operations\"` to their service configuration. For backwards compatibility, the default name includes the operations collection id, however overriding users must ensure the name binding is the parent resource, without the operations collection id."
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
