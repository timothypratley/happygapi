(ns happygapi.retail.projects
  "Retail API: projects.
  Cloud Retail service enables customers to build end-to-end personalized recommendation systems without requiring a high level of expertise in machine learning, recommendation system, or Google Cloud.
  See: https://cloud.google.com/recommendationsapi/reference/rest/v2/projects"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn locations-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/operations/list
  
  Required parameters: name
  
  Optional parameters: pageSize, filter, pageToken
  
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

(defn locations-catalogs-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :productLevelConfig {:ingestionProductType string,
                        :merchantCenterProductIdField string},
   :displayName string}
  
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

(defn locations-catalogs-userEvents-write$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/userEvents/write
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:eventType string,
   :cartId string,
   :pageViewId string,
   :productDetails [{:quantity integer,
                     :product GoogleCloudRetailV2Product}],
   :purchaseTransaction {:revenue number,
                         :currencyCode string,
                         :cost number,
                         :id string,
                         :tax number},
   :searchQuery string,
   :visitorId string,
   :referrerUri string,
   :pageCategories [string],
   :eventTime string,
   :uri string,
   :attributes {},
   :attributionToken string,
   :experimentIds [string],
   :userInfo {:userId string,
              :userAgent string,
              :ipAddress string,
              :directUserRequest boolean}}
  
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
  
  Optional parameters: userEvent, ets, uri
  
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
   :inputConfig {:gcsSource GoogleCloudRetailV2GcsSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource,
                 :userEventInlineSource GoogleCloudRetailV2UserEventInlineSource}}
  
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

(defn locations-catalogs-placements-predict$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/placements/predict
  
  Required parameters: placement
  
  Optional parameters: none
  
  Body: 
  
  {:validateOnly boolean,
   :labels {},
   :userEvent {:eventType string,
               :cartId string,
               :pageViewId string,
               :productDetails [GoogleCloudRetailV2ProductDetail],
               :purchaseTransaction GoogleCloudRetailV2PurchaseTransaction,
               :searchQuery string,
               :visitorId string,
               :referrerUri string,
               :pageCategories [string],
               :eventTime string,
               :uri string,
               :attributes {},
               :attributionToken string,
               :experimentIds [string],
               :userInfo GoogleCloudRetailV2UserInfo},
   :params {},
   :pageToken string,
   :pageSize integer,
   :filter string}
  
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

(defn locations-catalogs-branches-products-create$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/create
  
  Required parameters: parent
  
  Optional parameters: productId
  
  Body: 
  
  {:description string,
   :tags [string],
   :availableTime string,
   :availability string,
   :images [{:width integer, :uri string, :height integer}],
   :primaryProductId string,
   :name string,
   :availableQuantity integer,
   :type string,
   :title string,
   :priceInfo {:currencyCode string,
               :cost number,
               :originalPrice number,
               :price number},
   :categories [string],
   :id string,
   :uri string,
   :attributes {}}
  
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

(defn locations-catalogs-branches-products-import$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/import
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:updateMask string,
   :inputConfig {:productInlineSource GoogleCloudRetailV2ProductInlineSource,
                 :bigQuerySource GoogleCloudRetailV2BigQuerySource,
                 :gcsSource GoogleCloudRetailV2GcsSource},
   :errorsConfig {:gcsPrefix string}}
  
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

(defn locations-catalogs-branches-products-patch$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/branches/products/patch
  
  Required parameters: name
  
  Optional parameters: updateMask, allowMissing
  
  Body: 
  
  {:description string,
   :tags [string],
   :availableTime string,
   :availability string,
   :images [{:width integer, :uri string, :height integer}],
   :primaryProductId string,
   :name string,
   :availableQuantity integer,
   :type string,
   :title string,
   :priceInfo {:currencyCode string,
               :cost number,
               :originalPrice number,
               :price number},
   :categories [string],
   :id string,
   :uri string,
   :attributes {}}
  
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

(defn locations-catalogs-operations-list$
  "https://cloud.google.com/recommendationsapi/reference/rest/v2/projects/locations/catalogs/operations/list
  
  Required parameters: name
  
  Optional parameters: filter, pageSize, pageToken
  
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
