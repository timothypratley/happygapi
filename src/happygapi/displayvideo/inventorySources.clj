(ns happygapi.displayvideo.inventorySources
  "Display & Video 360 API: inventorySources.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/inventorySources"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v1/inventorySources/get
  
  Required parameters: inventorySourceId
  
  Optional parameters: partnerId
  
  Gets an inventory source."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:inventorySourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/inventorySources/{+inventorySourceId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v1/inventorySources/list
  
  Required parameters: none
  
  Optional parameters: advertiserId, filter, orderBy, pageSize, partnerId, pageToken
  
  Lists inventory sources that are accessible to the current user. The order is defined by the order_by parameter. If a filter by entity_status is not specified, inventory sources with entity status `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/inventorySources"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
