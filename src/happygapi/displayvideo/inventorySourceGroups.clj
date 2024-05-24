(ns happygapi.displayvideo.inventorySourceGroups
  "Display & Video 360 API: inventorySourceGroups.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/inventorySourceGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/get
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: partnerId, advertiserId
  
  Gets an inventory source group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}"
     #{:inventorySourceGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/list
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists inventory source groups that are accessible to the current user. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/create
  
  Required parameters: none
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:name string, :inventorySourceGroupId string, :displayName string}
  
  Creates a new inventory source group. Returns the newly created inventory source group if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/patch
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: partnerId, advertiserId, updateMask
  
  Body: 
  
  {:name string, :inventorySourceGroupId string, :displayName string}
  
  Updates an inventory source group. Returns the updated inventory source group if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{inventorySourceGroupId}"
     #{:inventorySourceGroupId}
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

(defn delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/delete
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: partnerId, advertiserId
  
  Deletes an inventory source group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}"
     #{:inventorySourceGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assignedInventorySources-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/assignedInventorySources/list
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: partnerId, advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists inventory sources assigned to an inventory source group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources"
     #{:inventorySourceGroupId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assignedInventorySources-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/assignedInventorySources/create
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: partnerId, advertiserId
  
  Body: 
  
  {:name string,
   :assignedInventorySourceId string,
   :inventorySourceId string}
  
  Creates an assignment between an inventory source and an inventory source group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources"
     #{:inventorySourceGroupId}
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

(defn assignedInventorySources-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/assignedInventorySources/delete
  
  Required parameters: inventorySourceGroupId, assignedInventorySourceId
  
  Optional parameters: partnerId, advertiserId
  
  Deletes the assignment between an inventory source and an inventory source group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:inventorySourceGroupId :assignedInventorySourceId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources/{+assignedInventorySourceId}"
     #{:inventorySourceGroupId :assignedInventorySourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn assignedInventorySources-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v3/inventorySourceGroups/assignedInventorySources/bulkEdit
  
  Required parameters: inventorySourceGroupId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :deletedAssignedInventorySources [string],
   :createdAssignedInventorySources [{:name string,
                                      :assignedInventorySourceId string,
                                      :inventorySourceId string}]}
  
  Bulk edits multiple assignments between inventory sources and a single inventory source group. The operation will delete the assigned inventory sources provided in BulkEditAssignedInventorySourcesRequest.deleted_assigned_inventory_sources and then create the assigned inventory sources provided in BulkEditAssignedInventorySourcesRequest.created_assigned_inventory_sources."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:inventorySourceGroupId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/inventorySourceGroups/{+inventorySourceGroupId}/assignedInventorySources:bulkEdit"
     #{:inventorySourceGroupId}
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
