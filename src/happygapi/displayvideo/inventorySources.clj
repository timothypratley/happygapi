(ns happygapi.displayvideo.inventorySources
  "Display & Video 360 API: inventorySources.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/inventorySources"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySources/get
  
  Required parameters: inventorySourceId
  
  Optional parameters: partnerId, advertiserId
  
  Gets an inventory source."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:inventorySourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySources/{+inventorySourceId}"
     #{:inventorySourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySources/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists inventory sources that are accessible to the current user. The order is defined by the order_by parameter. If a filter by entity_status is not specified, inventory sources with entity status `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySources"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySources/create
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:guaranteedOrderId string,
   :timeRange {:startTime string, :endTime string},
   :displayName string,
   :readAdvertiserIds [string],
   :name string,
   :inventorySourceType string,
   :commitment string,
   :rateDetails {:inventorySourceRateType string,
                 :rate Money,
                 :unitsPurchased string,
                 :minimumSpend Money},
   :updateTime string,
   :deliveryMethod string,
   :publisherName string,
   :status {:entityStatus string,
            :entityPauseReason string,
            :sellerStatus string,
            :sellerPauseReason string,
            :configStatus string},
   :readWriteAccessors {:partner InventorySourceAccessorsPartnerAccessor,
                        :advertisers InventorySourceAccessorsAdvertiserAccessors},
   :inventorySourceId string,
   :exchange string,
   :dealId string,
   :creativeConfigs [{:creativeType string,
                      :displayCreativeConfig InventorySourceDisplayCreativeConfig,
                      :videoCreativeConfig InventorySourceVideoCreativeConfig}],
   :inventorySourceProductType string,
   :readPartnerIds [string]}
  
  Creates a new inventory source. Returns the newly created inventory source if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySources"
     #{}
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

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySources/patch
  
  Required parameters: inventorySourceId
  
  Optional parameters: updateMask, partnerId, advertiserId
  
  Body: 
  
  {:guaranteedOrderId string,
   :timeRange {:startTime string, :endTime string},
   :displayName string,
   :readAdvertiserIds [string],
   :name string,
   :inventorySourceType string,
   :commitment string,
   :rateDetails {:inventorySourceRateType string,
                 :rate Money,
                 :unitsPurchased string,
                 :minimumSpend Money},
   :updateTime string,
   :deliveryMethod string,
   :publisherName string,
   :status {:entityStatus string,
            :entityPauseReason string,
            :sellerStatus string,
            :sellerPauseReason string,
            :configStatus string},
   :readWriteAccessors {:partner InventorySourceAccessorsPartnerAccessor,
                        :advertisers InventorySourceAccessorsAdvertiserAccessors},
   :inventorySourceId string,
   :exchange string,
   :dealId string,
   :creativeConfigs [{:creativeType string,
                      :displayCreativeConfig InventorySourceDisplayCreativeConfig,
                      :videoCreativeConfig InventorySourceVideoCreativeConfig}],
   :inventorySourceProductType string,
   :readPartnerIds [string]}
  
  Updates an existing inventory source. Returns the updated inventory source if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:inventorySourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySources/{+inventorySourceId}"
     #{:inventorySourceId}
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

(defn editInventorySourceReadWriteAccessors$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySources/editInventorySourceReadWriteAccessors
  
  Required parameters: inventorySourceId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :assignPartner boolean,
   :advertisersUpdate {:addedAdvertisers [string],
                       :removedAdvertisers [string]}}
  
  Edits read/write accessors of an inventory source. Returns the updated read_write_accessors for the inventory source."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:inventorySourceId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySources/{+inventorySourceId}:editInventorySourceReadWriteAccessors"
     #{:inventorySourceId}
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
