(ns happygapi.displayvideo.advertisers
  "Display & Video 360 API: advertisers.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/advertisers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn bulkEditAdvertiserAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/bulkEditAdvertiserAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:createRequests [{:assignedTargetingOptions [AssignedTargetingOption],
                     :targetingType string}],
   :deleteRequests [{:assignedTargetingOptionIds [string],
                     :targetingType string}]}
  
  Bulk edits targeting options under a single advertiser. The operation will delete the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.create_requests ."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}:bulkEditAdvertiserAssignedTargetingOptions"
     #{:advertiserId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/get
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Gets an advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/patch
  
  Required parameters: advertiserId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creativeConfig {:iasClientId string,
                    :obaComplianceDisabled boolean,
                    :videoCreativeDataSharingAuthorized boolean,
                    :dynamicCreativeEnabled boolean},
   :dataAccessConfig {:sdfConfig AdvertiserSdfConfig},
   :displayName string,
   :name string,
   :adServerConfig {:thirdPartyOnlyConfig ThirdPartyOnlyConfig,
                    :cmHybridConfig CmHybridConfig},
   :updateTime string,
   :advertiserId string,
   :servingConfig {:exemptTvFromViewabilityTargeting boolean},
   :integrationDetails {:integrationCode string, :details string},
   :prismaEnabled boolean,
   :partnerId string,
   :entityStatus string,
   :generalConfig {:domainUrl string,
                   :currencyCode string,
                   :timeZone string}}
  
  Updates an existing advertiser. Returns the updated advertiser if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}"
     #{:advertiserId}
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

(defn audit$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/audit
  
  Required parameters: advertiserId
  
  Optional parameters: readMask
  
  Audits an advertiser. Returns the counts of used entities per resource type under the advertiser provided. Used entities count towards their respective resource limit. See https://support.google.com/displayvideo/answer/6071450."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}:audit"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, partnerId, filter, orderBy
  
  Lists advertisers that are accessible to the current user. The order is defined by the order_by parameter. A single partner_id is required. Cross-partner listing is not supported."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bulkListAdvertiserAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/bulkListAdvertiserAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists assigned targeting options of an advertiser across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}:bulkListAdvertiserAssignedTargetingOptions"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:creativeConfig {:iasClientId string,
                    :obaComplianceDisabled boolean,
                    :videoCreativeDataSharingAuthorized boolean,
                    :dynamicCreativeEnabled boolean},
   :dataAccessConfig {:sdfConfig AdvertiserSdfConfig},
   :displayName string,
   :name string,
   :adServerConfig {:thirdPartyOnlyConfig ThirdPartyOnlyConfig,
                    :cmHybridConfig CmHybridConfig},
   :updateTime string,
   :advertiserId string,
   :servingConfig {:exemptTvFromViewabilityTargeting boolean},
   :integrationDetails {:integrationCode string, :details string},
   :prismaEnabled boolean,
   :partnerId string,
   :entityStatus string,
   :generalConfig {:domainUrl string,
                   :currencyCode string,
                   :timeZone string}}
  
  Creates a new advertiser. Returns the newly created advertiser if successful. This method can take up to 180 seconds to complete."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers"
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

(defn delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/delete
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Deletes an advertiser. Deleting an advertiser will delete all of its child resources, for example, campaigns, insertion orders and line items. A deleted advertiser cannot be recovered."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn invoices-lookupInvoiceCurrency$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/invoices/lookupInvoiceCurrency
  
  Required parameters: advertiserId
  
  Optional parameters: invoiceMonth
  
  Retrieves the invoice currency used by an advertiser in a given month."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/invoices:lookupInvoiceCurrency"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn invoices-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/invoices/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageToken, issueMonth, pageSize, loiSapinInvoiceType
  
  Lists invoices posted for an advertiser in a given month. Invoices generated by billing profiles with a \"Partner\" invoice level are not retrievable through this method."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/invoices"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/get
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: none
  
  Gets a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/locationLists/{+locationListId}"
     #{:locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :locationListId string,
   :locationType string,
   :advertiserId string,
   :displayName string}
  
  Creates a new location list. Returns the newly created location list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/locationLists"
     #{:advertiserId}
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

(defn locationLists-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/list
  
  Required parameters: advertiserId
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  
  Lists location lists based on a given advertiser id."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/locationLists"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/patch
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :locationListId string,
   :locationType string,
   :advertiserId string,
   :displayName string}
  
  Updates a location list. Returns the updated location list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/locationLists/{locationListId}"
     #{:locationListId :advertiserId}
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

(defn locationLists-assignedLocations-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/assignedLocations/create
  
  Required parameters: locationListId, advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:targetingOptionId string, :name string, :assignedLocationId string}
  
  Creates an assignment between a location and a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations"
     #{:locationListId :advertiserId}
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

(defn locationLists-assignedLocations-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/assignedLocations/delete
  
  Required parameters: locationListId, advertiserId, assignedLocationId
  
  Optional parameters: none
  
  Deletes the assignment between a location and a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedLocationId :locationListId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations/{+assignedLocationId}"
     #{:assignedLocationId :locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-assignedLocations-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/assignedLocations/list
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: pageSize, filter, pageToken, orderBy
  
  Lists locations assigned to a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations"
     #{:locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-assignedLocations-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/locationLists/assignedLocations/bulkEdit
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: none
  
  Body: 
  
  {:deletedAssignedLocations [string],
   :createdAssignedLocations [{:targetingOptionId string,
                               :name string,
                               :assignedLocationId string}]}
  
  Bulk edits multiple assignments between locations and a single location list. The operation will delete the assigned locations provided in BulkEditAssignedLocationsRequest.deleted_assigned_locations and then create the assigned locations provided in BulkEditAssignedLocationsRequest.created_assigned_locations."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/locationLists/{+locationListId}/assignedLocations:bulkEdit"
     #{:locationListId :advertiserId}
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

(defn channels-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/patch
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: updateMask, partnerId
  
  Body: 
  
  {:displayName string,
   :partnerId string,
   :name string,
   :advertiserId string,
   :positivelyTargetedLineItemCount string,
   :negativelyTargetedLineItemCount string,
   :channelId string}
  
  Updates a channel. Returns the updated channel if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/channels/{channelId}"
     #{:channelId :advertiserId}
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

(defn channels-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, orderBy, partnerId, pageToken, filter
  
  Lists channels for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/channels"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/get
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: partnerId
  
  Gets a channel for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/channels/{+channelId}"
     #{:channelId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/create
  
  Required parameters: advertiserId
  
  Optional parameters: partnerId
  
  Body: 
  
  {:displayName string,
   :partnerId string,
   :name string,
   :advertiserId string,
   :positivelyTargetedLineItemCount string,
   :negativelyTargetedLineItemCount string,
   :channelId string}
  
  Creates a new channel. Returns the newly created channel if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/channels"
     #{:advertiserId}
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

(defn channels-sites-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/sites/bulkEdit
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :createdSites [{:name string, :urlOrAppId string}],
   :partnerId string,
   :deletedSites [string]}
  
  Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/channels/{+channelId}/sites:bulkEdit"
     #{:channelId :advertiserId}
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

(defn channels-sites-replace$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/sites/replace
  
  Required parameters: channelId, advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :newSites [{:name string, :urlOrAppId string}],
   :partnerId string}
  
  Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/channels/{+channelId}/sites:replace"
     #{:channelId :advertiserId}
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

(defn channels-sites-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/sites/delete
  
  Required parameters: advertiserId, channelId, urlOrAppId
  
  Optional parameters: partnerId
  
  Deletes a site from a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:urlOrAppId :channelId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/channels/{+channelId}/sites/{+urlOrAppId}"
     #{:urlOrAppId :channelId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/sites/list
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: pageToken, pageSize, orderBy, partnerId, filter
  
  Lists sites in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/channels/{+channelId}/sites"
     #{:channelId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/channels/sites/create
  
  Required parameters: channelId, advertiserId
  
  Optional parameters: partnerId
  
  Body: 
  
  {:name string, :urlOrAppId string}
  
  Creates a site in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/channels/{+channelId}/sites"
     #{:channelId :advertiserId}
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

(defn assets-upload$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/assets/upload
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:filename string}
  
  Uploads an asset. Returns the ID of the newly uploaded asset if successful. The asset file size should be no more than 10 MB for images, 200 MB for ZIP files, and 1 GB for videos."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/assets"
     #{:advertiserId}
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

(defn negativeKeywordLists-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageToken, pageSize
  
  Lists negative keyword lists based on a given advertiser id."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/get
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Gets a negative keyword list given an advertiser ID and a negative keyword list ID."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/patch
  
  Required parameters: negativeKeywordListId, advertiserId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:advertiserId string,
   :targetedLineItemCount string,
   :displayName string,
   :negativeKeywordListId string,
   :name string}
  
  Updates a negative keyword list. Returns the updated negative keyword list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists/{negativeKeywordListId}"
     #{:advertiserId :negativeKeywordListId}
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

(defn negativeKeywordLists-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/delete
  
  Required parameters: negativeKeywordListId, advertiserId
  
  Optional parameters: none
  
  Deletes a negative keyword list given an advertiser ID and a negative keyword list ID."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :targetedLineItemCount string,
   :displayName string,
   :negativeKeywordListId string,
   :name string}
  
  Creates a new negative keyword list. Returns the newly created negative keyword list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists"
     #{:advertiserId}
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

(defn negativeKeywordLists-negativeKeywords-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/negativeKeywords/list
  
  Required parameters: negativeKeywordListId, advertiserId
  
  Optional parameters: filter, pageSize, orderBy, pageToken
  
  Lists negative keywords in a negative keyword list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-negativeKeywords-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/negativeKeywords/delete
  
  Required parameters: keywordValue, advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Deletes a negative keyword from a negative keyword list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:keywordValue :advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords/{+keywordValue}"
     #{:keywordValue :advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-negativeKeywords-replace$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/negativeKeywords/replace
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:newNegativeKeywords [{:keywordValue string, :name string}]}
  
  Replaces all negative keywords in a single negative keyword list. The operation will replace the keywords in a negative keyword list with keywords provided in ReplaceNegativeKeywordsRequest.new_negative_keywords."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:replace"
     #{:advertiserId :negativeKeywordListId}
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

(defn negativeKeywordLists-negativeKeywords-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/negativeKeywords/bulkEdit
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:deletedNegativeKeywords [string],
   :createdNegativeKeywords [{:keywordValue string, :name string}]}
  
  Bulk edits negative keywords in a single negative keyword list. The operation will delete the negative keywords provided in BulkEditNegativeKeywordsRequest.deleted_negative_keywords and then create the negative keywords provided in BulkEditNegativeKeywordsRequest.created_negative_keywords. This operation is guaranteed to be atomic and will never result in a partial success or partial failure."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:bulkEdit"
     #{:advertiserId :negativeKeywordListId}
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

(defn negativeKeywordLists-negativeKeywords-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/negativeKeywordLists/negativeKeywords/create
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:keywordValue string, :name string}
  
  Creates a negative keyword in a negative keyword list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:advertiserId :negativeKeywordListId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords"
     #{:advertiserId :negativeKeywordListId}
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

(defn lineItems-bulkListLineItemAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/bulkListLineItemAssignedTargetingOptions
  
  Required parameters: lineItemId, advertiserId
  
  Optional parameters: filter, pageSize, orderBy, pageToken
  
  Lists assigned targeting options of a line item across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}:bulkListLineItemAssignedTargetingOptions"
     #{:lineItemId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/patch
  
  Required parameters: advertiserId, lineItemId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:insertionOrderId string,
   :targetingExpansion {:targetingExpansionLevel string,
                        :excludeFirstPartyAudience boolean},
   :lineItemType string,
   :partnerCosts [{:costType string,
                   :feePercentageMillis string,
                   :feeAmount string,
                   :invoiceType string,
                   :feeType string}],
   :bidStrategy {:performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :inventorySourceIds [string],
   :pacing {:dailyMaxMicros string,
            :pacingPeriod string,
            :dailyMaxImpressions string,
            :pacingType string},
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :warningMessages [string],
   :creativeIds [string],
   :lineItemId string,
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :partnerRevenueModel {:markupAmount string, :markupType string},
   :conversionCounting {:postViewCountPercentageMillis string,
                        :floodlightActivityConfigs [TrackingFloodlightActivityConfig]},
   :budget {:budgetUnit string,
            :budgetAllocationType string,
            :maxAmount string},
   :mobileApp {:publisher string,
               :appId string,
               :platform string,
               :displayName string},
   :flight {:dateRange DateRange,
            :triggerId string,
            :flightDateType string},
   :entityStatus string}
  
  Updates an existing line item. Returns the updated line item if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
     #{:lineItemId :advertiserId}
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

(defn lineItems-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/get
  
  Required parameters: lineItemId, advertiserId
  
  Optional parameters: none
  
  Gets a line item."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
     #{:lineItemId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/delete
  
  Required parameters: lineItemId, advertiserId
  
  Optional parameters: none
  
  Deletes a line item. Returns error code `NOT_FOUND` if the line item does not exist. The line item should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
     #{:lineItemId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-generateDefault$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/generateDefault
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :mobileApp {:publisher string,
               :appId string,
               :platform string,
               :displayName string},
   :lineItemType string,
   :displayName string}
  
  Creates a new line item with settings (including targeting) inherited from the insertion order and an `ENTITY_STATUS_DRAFT` entity_status. Returns the newly created line item if successful. There are default values based on the three fields: * The insertion order's insertion_order_type * The insertion order's automation_type * The given line_item_type"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems:generateDefault"
     #{:advertiserId}
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

(defn lineItems-bulkEditLineItemAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/bulkEditLineItemAssignedTargetingOptions
  
  Required parameters: lineItemId, advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:createRequests [{:assignedTargetingOptions [AssignedTargetingOption],
                     :targetingType string}],
   :deleteRequests [{:assignedTargetingOptionIds [string],
                     :targetingType string}]}
  
  Bulk edits targeting options under a single line item. The operation will delete the assigned targeting options provided in BulkEditLineItemAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditLineItemAssignedTargetingOptionsRequest.create_requests ."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}:bulkEditLineItemAssignedTargetingOptions"
     #{:lineItemId :advertiserId}
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

(defn lineItems-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :targetingExpansion {:targetingExpansionLevel string,
                        :excludeFirstPartyAudience boolean},
   :lineItemType string,
   :partnerCosts [{:costType string,
                   :feePercentageMillis string,
                   :feeAmount string,
                   :invoiceType string,
                   :feeType string}],
   :bidStrategy {:performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :inventorySourceIds [string],
   :pacing {:dailyMaxMicros string,
            :pacingPeriod string,
            :dailyMaxImpressions string,
            :pacingType string},
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :warningMessages [string],
   :creativeIds [string],
   :lineItemId string,
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :partnerRevenueModel {:markupAmount string, :markupType string},
   :conversionCounting {:postViewCountPercentageMillis string,
                        :floodlightActivityConfigs [TrackingFloodlightActivityConfig]},
   :budget {:budgetUnit string,
            :budgetAllocationType string,
            :maxAmount string},
   :mobileApp {:publisher string,
               :appId string,
               :platform string,
               :displayName string},
   :flight {:dateRange DateRange,
            :triggerId string,
            :flightDateType string},
   :entityStatus string}
  
  Creates a new line item. Returns the newly created line item if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems"
     #{:advertiserId}
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

(defn lineItems-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/list
  
  Required parameters: advertiserId
  
  Optional parameters: filter, pageSize, pageToken, orderBy
  
  Lists line items in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, line items with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-targetingTypes-assignedTargetingOptions-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: advertiserId, lineItemId, assignedTargetingOptionId, targetingType
  
  Optional parameters: none
  
  Deletes an assigned targeting option from a line item."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId
            :lineItemId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId
       :lineItemId
       :advertiserId
       :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: targetingType, lineItemId, advertiserId
  
  Optional parameters: orderBy, pageSize, filter, pageToken
  
  Lists the targeting options assigned to a line item."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:lineItemId :advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:lineItemId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: lineItemId, targetingType, advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:parentalStatus string,
                           :targetingOptionId string},
   :geoRegionDetails {:displayName string,
                      :negative boolean,
                      :targetingOptionId string,
                      :geoRegionType string},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:targetingOptionId string,
                    :displayName string,
                    :negative boolean},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :nativeContentPositionDetails {:contentPosition string,
                                  :targetingOptionId string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:negative boolean,
                            :targetingOptionId string,
                            :displayName string},
   :appCategoryDetails {:targetingOptionId string,
                        :negative boolean,
                        :displayName string},
   :contentInstreamPositionDetails {:targetingOptionId string,
                                    :contentInstreamPosition string,
                                    :adType string},
   :inventorySourceDetails {:inventorySourceId string},
   :thirdPartyVerifierDetails {:integralAdScience IntegralAdScience,
                               :doubleVerify DoubleVerify,
                               :adloox Adloox},
   :name string,
   :onScreenPositionDetails {:adType string,
                             :onScreenPosition string,
                             :targetingOptionId string},
   :videoPlayerSizeDetails {:targetingOptionId string,
                            :videoPlayerSize string},
   :carrierAndIspDetails {:targetingOptionId string,
                          :displayName string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityRadiusRange string,
                                  :proximityLocationListId string},
   :digitalContentLabelExclusionDetails {:contentRatingTier string,
                                         :excludedTargetingOptionId string},
   :ageRangeDetails {:targetingOptionId string, :ageRange string},
   :deviceMakeModelDetails {:negative boolean,
                            :targetingOptionId string,
                            :displayName string},
   :categoryDetails {:targetingOptionId string,
                     :negative boolean,
                     :displayName string},
   :inheritance string,
   :audienceGroupDetails {:includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :excludedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCustomListGroup CustomListGroup},
   :channelDetails {:channelId string, :negative boolean},
   :targetingType string,
   :environmentDetails {:targetingOptionId string, :environment string},
   :sensitiveCategoryExclusionDetails {:excludedTargetingOptionId string,
                                       :sensitiveCategory string},
   :deviceTypeDetails {:targetingOptionId string, :deviceType string},
   :appDetails {:negative boolean,
                :appPlatform string,
                :appId string,
                :displayName string},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string, :targetingOptionId string},
   :languageDetails {:displayName string,
                     :negative boolean,
                     :targetingOptionId string},
   :viewabilityDetails {:viewability string, :targetingOptionId string},
   :keywordDetails {:negative boolean, :keyword string},
   :urlDetails {:negative boolean, :url string},
   :exchangeDetails {:targetingOptionId string},
   :dayAndTimeDetails {:timeZoneResolution string,
                       :endHour integer,
                       :dayOfWeek string,
                       :startHour integer},
   :householdIncomeDetails {:targetingOptionId string,
                            :householdIncome string},
   :authorizedSellerStatusDetails {:authorizedSellerStatus string,
                                   :targetingOptionId string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :targetingOptionId string,
                                     :adType string},
   :userRewardedContentDetails {:userRewardedContent string,
                                :targetingOptionId string}}
  
  Assigns a targeting option to a line item. Returns the assigned targeting option if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:lineItemId :advertiserId :targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:lineItemId :advertiserId :targetingType}
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

(defn lineItems-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/lineItems/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: lineItemId, targetingType, assignedTargetingOptionId, advertiserId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to a line item."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId
            :lineItemId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId
       :lineItemId
       :advertiserId
       :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/delete
  
  Required parameters: campaignId, advertiserId
  
  Optional parameters: none
  
  Permanently deletes a campaign. A deleted campaign cannot be recovered. The campaign should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}"
     #{:campaignId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/list
  
  Required parameters: advertiserId
  
  Optional parameters: filter, pageToken, pageSize, orderBy
  
  Lists campaigns in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, campaigns with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/patch
  
  Required parameters: advertiserId, campaignId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :name string,
   :campaignGoal {:performanceGoal PerformanceGoal,
                  :campaignGoalType string},
   :campaignId string,
   :campaignBudgets [{:dateRange DateRange,
                      :budgetUnit string,
                      :displayName string,
                      :prismaConfig PrismaConfig,
                      :budgetId string,
                      :invoiceGroupingId string,
                      :budgetAmountMicros string,
                      :externalBudgetId string,
                      :externalBudgetSource string}],
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :advertiserId string,
   :campaignFlight {:plannedSpendAmountMicros string,
                    :plannedDates DateRange},
   :entityStatus string}
  
  Updates an existing campaign. Returns the updated campaign if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}"
     #{:campaignId :advertiserId}
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

(defn campaigns-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/get
  
  Required parameters: advertiserId, campaignId
  
  Optional parameters: none
  
  Gets a campaign."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}"
     #{:campaignId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-bulkListCampaignAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/bulkListCampaignAssignedTargetingOptions
  
  Required parameters: campaignId, advertiserId
  
  Optional parameters: pageToken, pageSize, filter, orderBy
  
  Lists assigned targeting options of a campaign across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}:bulkListCampaignAssignedTargetingOptions"
     #{:campaignId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :campaignGoal {:performanceGoal PerformanceGoal,
                  :campaignGoalType string},
   :campaignId string,
   :campaignBudgets [{:dateRange DateRange,
                      :budgetUnit string,
                      :displayName string,
                      :prismaConfig PrismaConfig,
                      :budgetId string,
                      :invoiceGroupingId string,
                      :budgetAmountMicros string,
                      :externalBudgetId string,
                      :externalBudgetSource string}],
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :advertiserId string,
   :campaignFlight {:plannedSpendAmountMicros string,
                    :plannedDates DateRange},
   :entityStatus string}
  
  Creates a new campaign. Returns the newly created campaign if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns"
     #{:advertiserId}
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

(defn campaigns-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: targetingType, advertiserId, campaignId
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Lists the targeting options assigned to a campaign for a specified targeting type."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:campaignId :advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:campaignId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/campaigns/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, targetingType, assignedTargetingOptionId, campaignId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to a campaign."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId
            :campaignId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId
       :campaignId
       :advertiserId
       :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/creatives/patch
  
  Required parameters: creativeId, advertiserId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:requireMraid boolean,
   :skippable boolean,
   :reviewStatus {:contentAndPolicyReviewStatus string,
                  :approvalStatus string,
                  :exchangeReviewStatuses [ExchangeReviewStatus],
                  :creativeAndLandingPageReviewStatus string,
                  :publisherReviewStatuses [PublisherReviewStatus]},
   :creativeAttributes [string],
   :trackerUrls [string],
   :iasCampaignMonitoring boolean,
   :displayName string,
   :assets [{:asset Asset, :role string}],
   :skipOffset {:seconds string, :percentage string},
   :name string,
   :vpaid boolean,
   :universalAdId {:registry string, :id string},
   :createTime string,
   :creativeType string,
   :lineItemIds [string],
   :expandingDirection string,
   :mp3Audio boolean,
   :additionalDimensions [{:widthPixels integer, :heightPixels integer}],
   :html5Video boolean,
   :dimensions {:widthPixels integer, :heightPixels integer},
   :updateTime string,
   :jsTrackerUrl string,
   :thirdPartyUrls [{:url string, :type string}],
   :requirePingForAttribution boolean,
   :vastTagUrl string,
   :creativeId string,
   :counterEvents [{:name string, :reportingName string}],
   :dynamic boolean,
   :advertiserId string,
   :appendedTag string,
   :notes string,
   :transcodes [{:bitRateKbps string,
                 :audioBitRateKbps string,
                 :name string,
                 :frameRate number,
                 :transcoded boolean,
                 :dimensions Dimensions,
                 :audioSampleRateHz string,
                 :mimeType string,
                 :fileSizeBytes string}],
   :oggAudio boolean,
   :progressOffset {:seconds string, :percentage string},
   :requireHtml5 boolean,
   :obaIcon {:position string,
             :resourceMimeType string,
             :clickTrackingUrl string,
             :dimensions Dimensions,
             :resourceUrl string,
             :landingPageUrl string,
             :viewTrackingUrl string,
             :program string},
   :integrationCode string,
   :companionCreativeIds [string],
   :cmTrackingAd {:cmPlacementId string,
                  :cmCreativeId string,
                  :cmAdId string},
   :expandOnHover boolean,
   :hostingSource string,
   :timerEvents [{:reportingName string, :name string}],
   :cmPlacementId string,
   :mediaDuration string,
   :thirdPartyTag string,
   :exitEvents [{:reportingName string,
                 :name string,
                 :type string,
                 :url string}],
   :entityStatus string}
  
  Updates an existing creative. Returns the updated creative if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/creatives/{+creativeId}"
     #{:creativeId :advertiserId}
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

(defn creatives-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/creatives/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageToken, pageSize, orderBy, filter
  
  Lists creatives in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, creatives with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/creatives"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/creatives/delete
  
  Required parameters: creativeId, advertiserId
  
  Optional parameters: none
  
  Deletes a creative. Returns error code `NOT_FOUND` if the creative does not exist. The creative should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, before it can be deleted."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/creatives/{+creativeId}"
     #{:creativeId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/creatives/get
  
  Required parameters: advertiserId, creativeId
  
  Optional parameters: none
  
  Gets a creative."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/creatives/{+creativeId}"
     #{:creativeId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/creatives/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:requireMraid boolean,
   :skippable boolean,
   :reviewStatus {:contentAndPolicyReviewStatus string,
                  :approvalStatus string,
                  :exchangeReviewStatuses [ExchangeReviewStatus],
                  :creativeAndLandingPageReviewStatus string,
                  :publisherReviewStatuses [PublisherReviewStatus]},
   :creativeAttributes [string],
   :trackerUrls [string],
   :iasCampaignMonitoring boolean,
   :displayName string,
   :assets [{:asset Asset, :role string}],
   :skipOffset {:seconds string, :percentage string},
   :name string,
   :vpaid boolean,
   :universalAdId {:registry string, :id string},
   :createTime string,
   :creativeType string,
   :lineItemIds [string],
   :expandingDirection string,
   :mp3Audio boolean,
   :additionalDimensions [{:widthPixels integer, :heightPixels integer}],
   :html5Video boolean,
   :dimensions {:widthPixels integer, :heightPixels integer},
   :updateTime string,
   :jsTrackerUrl string,
   :thirdPartyUrls [{:url string, :type string}],
   :requirePingForAttribution boolean,
   :vastTagUrl string,
   :creativeId string,
   :counterEvents [{:name string, :reportingName string}],
   :dynamic boolean,
   :advertiserId string,
   :appendedTag string,
   :notes string,
   :transcodes [{:bitRateKbps string,
                 :audioBitRateKbps string,
                 :name string,
                 :frameRate number,
                 :transcoded boolean,
                 :dimensions Dimensions,
                 :audioSampleRateHz string,
                 :mimeType string,
                 :fileSizeBytes string}],
   :oggAudio boolean,
   :progressOffset {:seconds string, :percentage string},
   :requireHtml5 boolean,
   :obaIcon {:position string,
             :resourceMimeType string,
             :clickTrackingUrl string,
             :dimensions Dimensions,
             :resourceUrl string,
             :landingPageUrl string,
             :viewTrackingUrl string,
             :program string},
   :integrationCode string,
   :companionCreativeIds [string],
   :cmTrackingAd {:cmPlacementId string,
                  :cmCreativeId string,
                  :cmAdId string},
   :expandOnHover boolean,
   :hostingSource string,
   :timerEvents [{:reportingName string, :name string}],
   :cmPlacementId string,
   :mediaDuration string,
   :thirdPartyTag string,
   :exitEvents [{:reportingName string,
                 :name string,
                 :type string,
                 :url string}],
   :entityStatus string}
  
  Creates a new creative. Returns the newly created creative if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/creatives"
     #{:advertiserId}
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

(defn targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: advertiserId, targetingType
  
  Optional parameters: none
  
  Body: 
  
  {:negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:parentalStatus string,
                           :targetingOptionId string},
   :geoRegionDetails {:displayName string,
                      :negative boolean,
                      :targetingOptionId string,
                      :geoRegionType string},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:targetingOptionId string,
                    :displayName string,
                    :negative boolean},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :nativeContentPositionDetails {:contentPosition string,
                                  :targetingOptionId string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:negative boolean,
                            :targetingOptionId string,
                            :displayName string},
   :appCategoryDetails {:targetingOptionId string,
                        :negative boolean,
                        :displayName string},
   :contentInstreamPositionDetails {:targetingOptionId string,
                                    :contentInstreamPosition string,
                                    :adType string},
   :inventorySourceDetails {:inventorySourceId string},
   :thirdPartyVerifierDetails {:integralAdScience IntegralAdScience,
                               :doubleVerify DoubleVerify,
                               :adloox Adloox},
   :name string,
   :onScreenPositionDetails {:adType string,
                             :onScreenPosition string,
                             :targetingOptionId string},
   :videoPlayerSizeDetails {:targetingOptionId string,
                            :videoPlayerSize string},
   :carrierAndIspDetails {:targetingOptionId string,
                          :displayName string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityRadiusRange string,
                                  :proximityLocationListId string},
   :digitalContentLabelExclusionDetails {:contentRatingTier string,
                                         :excludedTargetingOptionId string},
   :ageRangeDetails {:targetingOptionId string, :ageRange string},
   :deviceMakeModelDetails {:negative boolean,
                            :targetingOptionId string,
                            :displayName string},
   :categoryDetails {:targetingOptionId string,
                     :negative boolean,
                     :displayName string},
   :inheritance string,
   :audienceGroupDetails {:includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :excludedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCustomListGroup CustomListGroup},
   :channelDetails {:channelId string, :negative boolean},
   :targetingType string,
   :environmentDetails {:targetingOptionId string, :environment string},
   :sensitiveCategoryExclusionDetails {:excludedTargetingOptionId string,
                                       :sensitiveCategory string},
   :deviceTypeDetails {:targetingOptionId string, :deviceType string},
   :appDetails {:negative boolean,
                :appPlatform string,
                :appId string,
                :displayName string},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string, :targetingOptionId string},
   :languageDetails {:displayName string,
                     :negative boolean,
                     :targetingOptionId string},
   :viewabilityDetails {:viewability string, :targetingOptionId string},
   :keywordDetails {:negative boolean, :keyword string},
   :urlDetails {:negative boolean, :url string},
   :exchangeDetails {:targetingOptionId string},
   :dayAndTimeDetails {:timeZoneResolution string,
                       :endHour integer,
                       :dayOfWeek string,
                       :startHour integer},
   :householdIncomeDetails {:targetingOptionId string,
                            :householdIncome string},
   :authorizedSellerStatusDetails {:authorizedSellerStatus string,
                                   :targetingOptionId string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :targetingOptionId string,
                                     :adType string},
   :userRewardedContentDetails {:userRewardedContent string,
                                :targetingOptionId string}}
  
  Assigns a targeting option to an advertiser. Returns the assigned targeting option if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId :targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:advertiserId :targetingType}
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

(defn targetingTypes-assignedTargetingOptions-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: advertiserId, assignedTargetingOptionId, targetingType
  
  Optional parameters: none
  
  Deletes an assigned targeting option from an advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId :advertiserId :targetingType})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, targetingType, assignedTargetingOptionId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to an advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId :advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, targetingType
  
  Optional parameters: pageToken, filter, orderBy, pageSize
  
  Lists the targeting options assigned to an advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-bulkListInsertionOrderAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/bulkListInsertionOrderAssignedTargetingOptions
  
  Required parameters: insertionOrderId, advertiserId
  
  Optional parameters: orderBy, pageSize, pageToken, filter
  
  Lists assigned targeting options of an insertion order across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}:bulkListInsertionOrderAssignedTargetingOptions"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/delete
  
  Required parameters: advertiserId, insertionOrderId
  
  Optional parameters: none
  
  Deletes an insertion order. Returns error code `NOT_FOUND` if the insertion order does not exist. The insertion order should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :partnerCosts [{:costType string,
                   :feePercentageMillis string,
                   :feeAmount string,
                   :invoiceType string,
                   :feeType string}],
   :bidStrategy {:performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:dailyMaxMicros string,
            :pacingPeriod string,
            :dailyMaxImpressions string,
            :pacingType string},
   :performanceGoal {:performanceGoalType string,
                     :performanceGoalPercentageMicros string,
                     :performanceGoalAmountMicros string,
                     :performanceGoalString string},
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :budget {:budgetUnit string,
            :automationType string,
            :budgetSegments [InsertionOrderBudgetSegment]},
   :entityStatus string,
   :insertionOrderType string}
  
  Creates a new insertion order. Returns the newly created insertion order if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders"
     #{:advertiserId}
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

(defn insertionOrders-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/list
  
  Required parameters: advertiserId
  
  Optional parameters: filter, pageSize, orderBy, pageToken
  
  Lists insertion orders in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, insertion orders with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/patch
  
  Required parameters: advertiserId, insertionOrderId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:insertionOrderId string,
   :partnerCosts [{:costType string,
                   :feePercentageMillis string,
                   :feeAmount string,
                   :invoiceType string,
                   :feeType string}],
   :bidStrategy {:performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:dailyMaxMicros string,
            :pacingPeriod string,
            :dailyMaxImpressions string,
            :pacingType string},
   :performanceGoal {:performanceGoalType string,
                     :performanceGoalPercentageMicros string,
                     :performanceGoalAmountMicros string,
                     :performanceGoalString string},
   :updateTime string,
   :frequencyCap {:timeUnitCount integer,
                  :timeUnit string,
                  :unlimited boolean,
                  :maxImpressions integer},
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :budget {:budgetUnit string,
            :automationType string,
            :budgetSegments [InsertionOrderBudgetSegment]},
   :entityStatus string,
   :insertionOrderType string}
  
  Updates an existing insertion order. Returns the updated insertion order if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
     #{:insertionOrderId :advertiserId}
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

(defn insertionOrders-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/get
  
  Required parameters: insertionOrderId, advertiserId
  
  Optional parameters: none
  
  Gets an insertion order. Returns error code `NOT_FOUND` if the insertion order does not exist."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, targetingType, insertionOrderId
  
  Optional parameters: pageToken, orderBy, pageSize, filter
  
  Lists the targeting options assigned to an insertion order."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:insertionOrderId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: insertionOrderId, targetingType, assignedTargetingOptionId, advertiserId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to an insertion order."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId
            :assignedTargetingOptionId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:insertionOrderId
       :assignedTargetingOptionId
       :advertiserId
       :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn manualTriggers-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :state string,
   :triggerId string,
   :name string,
   :displayName string,
   :activationDurationMinutes string,
   :latestActivationTime string}
  
  Creates a new manual trigger. Returns the newly created manual trigger if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers"
     #{:advertiserId}
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

(defn manualTriggers-deactivate$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/deactivate
  
  Required parameters: advertiserId, triggerId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deactivates a manual trigger."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:triggerId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers/{+triggerId}:deactivate"
     #{:triggerId :advertiserId}
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

(defn manualTriggers-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/list
  
  Required parameters: advertiserId
  
  Optional parameters: filter, pageToken, orderBy, pageSize
  
  Lists manual triggers that are accessible to the current user for a given advertiser ID. The order is defined by the order_by parameter. A single advertiser_id is required."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn manualTriggers-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/get
  
  Required parameters: advertiserId, triggerId
  
  Optional parameters: none
  
  Gets a manual trigger."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:triggerId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers/{+triggerId}"
     #{:triggerId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn manualTriggers-activate$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/activate
  
  Required parameters: advertiserId, triggerId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activates a manual trigger. Each activation of the manual trigger must be at least 5 minutes apart, otherwise an error will be returned."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:triggerId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers/{+triggerId}:activate"
     #{:triggerId :advertiserId}
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

(defn manualTriggers-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/advertisers/manualTriggers/patch
  
  Required parameters: advertiserId, triggerId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:advertiserId string,
   :state string,
   :triggerId string,
   :name string,
   :displayName string,
   :activationDurationMinutes string,
   :latestActivationTime string}
  
  Updates a manual trigger. Returns the updated manual trigger if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:triggerId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/advertisers/{+advertiserId}/manualTriggers/{+triggerId}"
     #{:triggerId :advertiserId}
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
