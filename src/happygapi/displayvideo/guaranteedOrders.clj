(ns happygapi.displayvideo.guaranteedOrders
  "Display & Video 360 API: guaranteedOrders.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/guaranteedOrders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v3/guaranteedOrders/create
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:guaranteedOrderId string,
   :defaultAdvertiserId string,
   :readAccessInherited boolean,
   :displayName string,
   :readAdvertiserIds [string],
   :name string,
   :readWritePartnerId string,
   :updateTime string,
   :publisherName string,
   :status {:entityStatus string,
            :entityPauseReason string,
            :configStatus string},
   :readWriteAdvertiserId string,
   :exchange string,
   :legacyGuaranteedOrderId string,
   :defaultCampaignId string}
  
  Creates a new guaranteed order. Returns the newly created guaranteed order if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/guaranteedOrders"
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

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/guaranteedOrders/get
  
  Required parameters: guaranteedOrderId
  
  Optional parameters: partnerId, advertiserId
  
  Gets a guaranteed order."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:guaranteedOrderId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/guaranteedOrders/{+guaranteedOrderId}"
     #{:guaranteedOrderId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/guaranteedOrders/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists guaranteed orders that are accessible to the current user. The order is defined by the order_by parameter. If a filter by entity_status is not specified, guaranteed orders with entity status `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/guaranteedOrders"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/guaranteedOrders/patch
  
  Required parameters: guaranteedOrderId
  
  Optional parameters: updateMask, partnerId, advertiserId
  
  Body: 
  
  {:guaranteedOrderId string,
   :defaultAdvertiserId string,
   :readAccessInherited boolean,
   :displayName string,
   :readAdvertiserIds [string],
   :name string,
   :readWritePartnerId string,
   :updateTime string,
   :publisherName string,
   :status {:entityStatus string,
            :entityPauseReason string,
            :configStatus string},
   :readWriteAdvertiserId string,
   :exchange string,
   :legacyGuaranteedOrderId string,
   :defaultCampaignId string}
  
  Updates an existing guaranteed order. Returns the updated guaranteed order if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:guaranteedOrderId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/guaranteedOrders/{+guaranteedOrderId}"
     #{:guaranteedOrderId}
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

(defn editGuaranteedOrderReadAccessors$
  "https://developers.google.com/display-video/api/reference/rest/v3/guaranteedOrders/editGuaranteedOrderReadAccessors
  
  Required parameters: guaranteedOrderId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :readAccessInherited boolean,
   :addedAdvertisers [string],
   :removedAdvertisers [string]}
  
  Edits read advertisers of a guaranteed order."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:guaranteedOrderId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/guaranteedOrders/{+guaranteedOrderId}:editGuaranteedOrderReadAccessors"
     #{:guaranteedOrderId}
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
