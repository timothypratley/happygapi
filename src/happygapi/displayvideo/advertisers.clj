(ns happygapi.displayvideo.advertisers
  "Display & Video 360 API: advertisers.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/api/reference/rest/v3/advertisers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/listAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists assigned targeting options of an advertiser across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}:listAssignedTargetingOptions"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn editAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/editAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:deleteRequests [{:targetingType string,
                     :assignedTargetingOptionIds [string]}],
   :createRequests [{:targetingType string,
                     :assignedTargetingOptions [AssignedTargetingOption]}]}
  
  Edits targeting options under a single advertiser. The operation will delete the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditAdvertiserAssignedTargetingOptionsRequest.create_requests ."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}:editAssignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/get
  
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
     "v3/advertisers/{+advertiserId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/list
  
  Required parameters: none
  
  Optional parameters: partnerId, pageSize, pageToken, orderBy, filter
  
  Lists advertisers that are accessible to the current user. The order is defined by the order_by parameter. A single partner_id is required. Cross-partner listing is not supported."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/create
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:creativeConfig {:iasClientId string,
                    :obaComplianceDisabled boolean,
                    :dynamicCreativeEnabled boolean,
                    :videoCreativeDataSharingAuthorized boolean},
   :dataAccessConfig {:sdfConfig AdvertiserSdfConfig},
   :displayName string,
   :name string,
   :billingConfig {:billingProfileId string},
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
                   :timeZone string,
                   :currencyCode string}}
  
  Creates a new advertiser. Returns the newly created advertiser if successful. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/patch
  
  Required parameters: advertiserId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:creativeConfig {:iasClientId string,
                    :obaComplianceDisabled boolean,
                    :dynamicCreativeEnabled boolean,
                    :videoCreativeDataSharingAuthorized boolean},
   :dataAccessConfig {:sdfConfig AdvertiserSdfConfig},
   :displayName string,
   :name string,
   :billingConfig {:billingProfileId string},
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
                   :timeZone string,
                   :currencyCode string}}
  
  Updates an existing advertiser. Returns the updated advertiser if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}"
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

(defn delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/delete
  
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
     "v3/advertisers/{+advertiserId}"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn audit$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/audit
  
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
     "v3/advertisers/{+advertiserId}:audit"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/invoices/list
  
  Required parameters: advertiserId
  
  Optional parameters: issueMonth, loiSapinInvoiceType, pageSize, pageToken
  
  Lists invoices posted for an advertiser in a given month. Invoices generated by billing profiles with a \"Partner\" invoice level are not retrievable through this method."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/invoices"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/invoices/lookupInvoiceCurrency
  
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
     "v3/advertisers/{+advertiserId}/invoices:lookupInvoiceCurrency"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/get
  
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
     "v3/advertisers/{+advertiserId}/locationLists/{+locationListId}"
     #{:locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists location lists based on a given advertiser id."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/locationLists"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :locationListId string,
   :displayName string,
   :locationType string,
   :advertiserId string}
  
  Creates a new location list. Returns the newly created location list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/locationLists"
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

(defn locationLists-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/patch
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :locationListId string,
   :displayName string,
   :locationType string,
   :advertiserId string}
  
  Updates a location list. Returns the updated location list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/locationLists/{locationListId}"
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

(defn locationLists-assignedLocations-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/assignedLocations/list
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists locations assigned to a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations"
     #{:locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-assignedLocations-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/assignedLocations/create
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :assignedLocationId string, :targetingOptionId string}
  
  Creates an assignment between a location and a location list."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/assignedLocations/delete
  
  Required parameters: advertiserId, locationListId, assignedLocationId
  
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
     "v3/advertisers/{advertiserId}/locationLists/{locationListId}/assignedLocations/{+assignedLocationId}"
     #{:assignedLocationId :locationListId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn locationLists-assignedLocations-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/locationLists/assignedLocations/bulkEdit
  
  Required parameters: advertiserId, locationListId
  
  Optional parameters: none
  
  Body: 
  
  {:deletedAssignedLocations [string],
   :createdAssignedLocations [{:name string,
                               :assignedLocationId string,
                               :targetingOptionId string}]}
  
  Bulk edits multiple assignments between locations and a single location list. The operation will delete the assigned locations provided in deletedAssignedLocations and then create the assigned locations provided in createdAssignedLocations."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:locationListId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{advertiserId}/locationLists/{+locationListId}/assignedLocations:bulkEdit"
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

(defn channels-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/get
  
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
     "v3/advertisers/{+advertiserId}/channels/{+channelId}"
     #{:channelId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/list
  
  Required parameters: advertiserId
  
  Optional parameters: partnerId, pageSize, pageToken, orderBy, filter
  
  Lists channels for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/channels"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/create
  
  Required parameters: advertiserId
  
  Optional parameters: partnerId
  
  Body: 
  
  {:name string,
   :channelId string,
   :displayName string,
   :partnerId string,
   :advertiserId string,
   :positivelyTargetedLineItemCount string,
   :negativelyTargetedLineItemCount string}
  
  Creates a new channel. Returns the newly created channel if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/channels"
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

(defn channels-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/patch
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: partnerId, updateMask
  
  Body: 
  
  {:name string,
   :channelId string,
   :displayName string,
   :partnerId string,
   :advertiserId string,
   :positivelyTargetedLineItemCount string,
   :negativelyTargetedLineItemCount string}
  
  Updates a channel. Returns the updated channel if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/channels/{channelId}"
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

(defn channels-sites-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/sites/list
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: partnerId, pageSize, pageToken, orderBy, filter
  
  Lists sites in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/channels/{+channelId}/sites"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/sites/create
  
  Required parameters: advertiserId, channelId
  
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
     "v3/advertisers/{advertiserId}/channels/{+channelId}/sites"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/sites/delete
  
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
     "v3/advertisers/{advertiserId}/channels/{+channelId}/sites/{+urlOrAppId}"
     #{:urlOrAppId :channelId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/sites/bulkEdit
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :deletedSites [string],
   :createdSites [{:name string, :urlOrAppId string}]}
  
  Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{advertiserId}/channels/{+channelId}/sites:bulkEdit"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/channels/sites/replace
  
  Required parameters: advertiserId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :newSites [{:name string, :urlOrAppId string}]}
  
  Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{advertiserId}/channels/{+channelId}/sites:replace"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/assets/upload
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:filename string}
  
  Uploads an asset. Returns the ID of the newly uploaded asset if successful. The asset file size should be no more than 10 MB for images, 200 MB for ZIP files, and 1 GB for videos. Must be used within the [multipart media upload process](/display-video/api/guides/how-tos/upload#multipart). Examples using provided client libraries can be found in our [Creating Creatives guide](/display-video/api/guides/creating-creatives/overview#upload_an_asset)."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/assets"
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

(defn negativeKeywordLists-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/get
  
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
     "v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken
  
  Lists negative keyword lists based on a given advertiser id."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/negativeKeywordLists"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :negativeKeywordListId string,
   :displayName string,
   :advertiserId string,
   :targetedLineItemCount string}
  
  Creates a new negative keyword list. Returns the newly created negative keyword list if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/negativeKeywordLists"
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

(defn negativeKeywordLists-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/patch
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :negativeKeywordListId string,
   :displayName string,
   :advertiserId string,
   :targetedLineItemCount string}
  
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
     "v3/advertisers/{+advertiserId}/negativeKeywordLists/{negativeKeywordListId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/delete
  
  Required parameters: advertiserId, negativeKeywordListId
  
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
     "v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-negativeKeywords-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/negativeKeywords/list
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
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
     "v3/advertisers/{+advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords"
     #{:advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-negativeKeywords-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/negativeKeywords/create
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :keywordValue string}
  
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
     "v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords"
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

(defn negativeKeywordLists-negativeKeywords-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/negativeKeywords/delete
  
  Required parameters: advertiserId, negativeKeywordListId, keywordValue
  
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
     "v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords/{+keywordValue}"
     #{:keywordValue :advertiserId :negativeKeywordListId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn negativeKeywordLists-negativeKeywords-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/negativeKeywords/bulkEdit
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:deletedNegativeKeywords [string],
   :createdNegativeKeywords [{:name string, :keywordValue string}]}
  
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
     "v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:bulkEdit"
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

(defn negativeKeywordLists-negativeKeywords-replace$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/negativeKeywordLists/negativeKeywords/replace
  
  Required parameters: advertiserId, negativeKeywordListId
  
  Optional parameters: none
  
  Body: 
  
  {:newNegativeKeywords [{:name string, :keywordValue string}]}
  
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
     "v3/advertisers/{advertiserId}/negativeKeywordLists/{+negativeKeywordListId}/negativeKeywords:replace"
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

(defn lineItems-duplicate$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/duplicate
  
  Required parameters: advertiserId, lineItemId
  
  Optional parameters: none
  
  Body: 
  
  {:targetDisplayName string}
  
  Duplicates a line item. Returns the ID of the created line item if successful. YouTube & Partners line items cannot be created or updated using the API. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}:duplicate"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/get
  
  Required parameters: advertiserId, lineItemId
  
  Optional parameters: none
  
  Gets a line item."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/generateDefault
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :displayName string,
   :lineItemType string,
   :mobileApp {:appId string,
               :platform string,
               :displayName string,
               :publisher string}}
  
  Creates a new line item with settings (including targeting) inherited from the insertion order and an `ENTITY_STATUS_DRAFT` entity_status. Returns the newly created line item if successful. There are default values based on the three fields: * The insertion order's insertion_order_type * The insertion order's automation_type * The given line_item_type YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems:generateDefault"
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

(defn lineItems-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/patch
  
  Required parameters: advertiserId, lineItemId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:insertionOrderId string,
   :targetingExpansion {:enableOptimizedTargeting boolean,
                        :audienceExpansionSeedListExcluded boolean,
                        :audienceExpansionLevel string},
   :lineItemType string,
   :partnerCosts [{:costType string,
                   :feeType string,
                   :feeAmount string,
                   :feePercentageMillis string,
                   :invoiceType string}],
   :bidStrategy {:fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy,
                 :performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :youtubeAndPartnersBid YoutubeAndPartnersBiddingStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:pacingPeriod string,
            :pacingType string,
            :dailyMaxMicros string,
            :dailyMaxImpressions string},
   :updateTime string,
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
   :warningMessages [string],
   :creativeIds [string],
   :lineItemId string,
   :advertiserId string,
   :youtubeAndPartnersSettings {:leadFormId string,
                                :videoAdSequenceSettings VideoAdSequenceSettings,
                                :inventorySourceSettings YoutubeAndPartnersInventorySourceConfig,
                                :viewFrequencyCap FrequencyCap,
                                :relatedVideoIds [string],
                                :linkedMerchantId string,
                                :contentCategory string,
                                :effectiveContentCategory string,
                                :targetFrequency TargetFrequency,
                                :thirdPartyMeasurementConfigs ThirdPartyMeasurementConfigs},
   :integrationDetails {:integrationCode string, :details string},
   :partnerRevenueModel {:markupType string, :markupAmount string},
   :conversionCounting {:postViewCountPercentageMillis string,
                        :floodlightActivityConfigs [TrackingFloodlightActivityConfig]},
   :budget {:budgetAllocationType string,
            :budgetUnit string,
            :maxAmount string},
   :mobileApp {:appId string,
               :platform string,
               :displayName string,
               :publisher string},
   :reservationType string,
   :flight {:flightDateType string, :dateRange DateRange},
   :excludeNewExchanges boolean,
   :entityStatus string}
  
  Updates an existing line item. Returns the updated line item if successful. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * BulkEditAssignedTargetingOptions * BulkUpdateLineItems * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :targetingExpansion {:enableOptimizedTargeting boolean,
                        :audienceExpansionSeedListExcluded boolean,
                        :audienceExpansionLevel string},
   :lineItemType string,
   :partnerCosts [{:costType string,
                   :feeType string,
                   :feeAmount string,
                   :feePercentageMillis string,
                   :invoiceType string}],
   :bidStrategy {:fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy,
                 :performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :youtubeAndPartnersBid YoutubeAndPartnersBiddingStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:pacingPeriod string,
            :pacingType string,
            :dailyMaxMicros string,
            :dailyMaxImpressions string},
   :updateTime string,
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
   :warningMessages [string],
   :creativeIds [string],
   :lineItemId string,
   :advertiserId string,
   :youtubeAndPartnersSettings {:leadFormId string,
                                :videoAdSequenceSettings VideoAdSequenceSettings,
                                :inventorySourceSettings YoutubeAndPartnersInventorySourceConfig,
                                :viewFrequencyCap FrequencyCap,
                                :relatedVideoIds [string],
                                :linkedMerchantId string,
                                :contentCategory string,
                                :effectiveContentCategory string,
                                :targetFrequency TargetFrequency,
                                :thirdPartyMeasurementConfigs ThirdPartyMeasurementConfigs},
   :integrationDetails {:integrationCode string, :details string},
   :partnerRevenueModel {:markupType string, :markupAmount string},
   :conversionCounting {:postViewCountPercentageMillis string,
                        :floodlightActivityConfigs [TrackingFloodlightActivityConfig]},
   :budget {:budgetAllocationType string,
            :budgetUnit string,
            :maxAmount string},
   :mobileApp {:appId string,
               :platform string,
               :displayName string,
               :publisher string},
   :reservationType string,
   :flight {:flightDateType string, :dateRange DateRange},
   :excludeNewExchanges boolean,
   :entityStatus string}
  
  Creates a new line item. Returns the newly created line item if successful. YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems"
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

(defn lineItems-bulkUpdate$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/bulkUpdate
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:lineItemIds [string],
   :targetLineItem {:insertionOrderId string,
                    :targetingExpansion TargetingExpansionConfig,
                    :lineItemType string,
                    :partnerCosts [PartnerCost],
                    :bidStrategy BiddingStrategy,
                    :displayName string,
                    :name string,
                    :campaignId string,
                    :pacing Pacing,
                    :updateTime string,
                    :frequencyCap FrequencyCap,
                    :warningMessages [string],
                    :creativeIds [string],
                    :lineItemId string,
                    :advertiserId string,
                    :youtubeAndPartnersSettings YoutubeAndPartnersSettings,
                    :integrationDetails IntegrationDetails,
                    :partnerRevenueModel PartnerRevenueModel,
                    :conversionCounting ConversionCountingConfig,
                    :budget LineItemBudget,
                    :mobileApp MobileApp,
                    :reservationType string,
                    :flight LineItemFlight,
                    :excludeNewExchanges boolean,
                    :entityStatus string},
   :updateMask string}
  
  Updates multiple line items. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * BulkEditAssignedTargetingOptions * UpdateLineItem * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems:bulkUpdate"
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

(defn lineItems-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/delete
  
  Required parameters: advertiserId, lineItemId
  
  Optional parameters: none
  
  Deletes a line item. Returns error code `NOT_FOUND` if the line item does not exist. The line item should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it. YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:lineItemId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}"
     #{:lineItemId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-bulkEditAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/bulkEditAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:lineItemIds [string],
   :deleteRequests [{:targetingType string,
                     :assignedTargetingOptionIds [string]}],
   :createRequests [{:targetingType string,
                     :assignedTargetingOptions [AssignedTargetingOption]}]}
  
  Bulk edits targeting options under multiple line items. The operation will delete the assigned targeting options provided in BulkEditAssignedTargetingOptionsRequest.delete_requests and then create the assigned targeting options provided in BulkEditAssignedTargetingOptionsRequest.create_requests. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkUpdate * lineItems.patch * assignedTargetingOptions.create * assignedTargetingOptions.delete YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems:bulkEditAssignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists line items in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, line items with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-bulkListAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/bulkListAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: lineItemIds, pageSize, pageToken, orderBy, filter
  
  Lists assigned targeting options for multiple line items across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems:bulkListAssignedTargetingOptions"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn lineItems-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, lineItemId, targetingType, assignedTargetingOptionId
  
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
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, lineItemId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
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
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: advertiserId, lineItemId, targetingType
  
  Optional parameters: none
  
  Body: 
  
  {:contentGenreDetails {:targetingOptionId string,
                         :displayName string,
                         :negative boolean},
   :negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:parentalStatus string},
   :geoRegionDetails {:displayName string,
                      :targetingOptionId string,
                      :geoRegionType string,
                      :negative boolean},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:displayName string,
                    :targetingOptionId string,
                    :negative boolean},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :nativeContentPositionDetails {:contentPosition string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :appCategoryDetails {:displayName string,
                        :targetingOptionId string,
                        :negative boolean},
   :contentInstreamPositionDetails {:contentInstreamPosition string,
                                    :adType string},
   :inventorySourceDetails {:inventorySourceId string},
   :audioContentTypeDetails {:audioContentType string},
   :thirdPartyVerifierDetails {:adloox Adloox,
                               :doubleVerify DoubleVerify,
                               :integralAdScience IntegralAdScience},
   :name string,
   :onScreenPositionDetails {:targetingOptionId string,
                             :onScreenPosition string,
                             :adType string},
   :videoPlayerSizeDetails {:videoPlayerSize string},
   :carrierAndIspDetails {:displayName string,
                          :targetingOptionId string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityLocationListId string,
                                  :proximityRadius number,
                                  :proximityRadiusUnit string},
   :contentStreamTypeDetails {:targetingOptionId string,
                              :contentStreamType string},
   :digitalContentLabelExclusionDetails {:excludedContentRatingTier string},
   :ageRangeDetails {:ageRange string},
   :deviceMakeModelDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :categoryDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :inheritance string,
   :businessChainDetails {:displayName string,
                          :targetingOptionId string,
                          :proximityRadiusAmount number,
                          :proximityRadiusUnit string},
   :audienceGroupDetails {:includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCustomListGroup CustomListGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :excludedGoogleAudienceGroup GoogleAudienceGroup},
   :channelDetails {:channelId string, :negative boolean},
   :contentDurationDetails {:targetingOptionId string,
                            :contentDuration string},
   :targetingType string,
   :environmentDetails {:environment string},
   :poiDetails {:displayName string,
                :targetingOptionId string,
                :latitude number,
                :longitude number,
                :proximityRadiusAmount number,
                :proximityRadiusUnit string},
   :sensitiveCategoryExclusionDetails {:excludedSensitiveCategory string},
   :youtubeVideoDetails {:videoId string, :negative boolean},
   :sessionPositionDetails {:sessionPosition string},
   :deviceTypeDetails {:deviceType string,
                       :youtubeAndPartnersBidMultiplier number},
   :appDetails {:appId string,
                :displayName string,
                :negative boolean,
                :appPlatform string},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string},
   :languageDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :viewabilityDetails {:viewability string},
   :assignedTargetingOptionIdAlias string,
   :keywordDetails {:keyword string, :negative boolean},
   :urlDetails {:url string, :negative boolean},
   :exchangeDetails {:exchange string},
   :dayAndTimeDetails {:dayOfWeek string,
                       :startHour integer,
                       :endHour integer,
                       :timeZoneResolution string},
   :householdIncomeDetails {:householdIncome string},
   :authorizedSellerStatusDetails {:authorizedSellerStatus string,
                                   :targetingOptionId string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :adType string},
   :youtubeChannelDetails {:channelId string, :negative boolean},
   :userRewardedContentDetails {:targetingOptionId string,
                                :userRewardedContent string},
   :omidDetails {:omid string}}
  
  Assigns a targeting option to a line item. Returns the assigned targeting option if successful. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkEditAssignedTargetingOptions * lineItems.bulkUpdate * lineItems.patch * DeleteLineItemAssignedTargetingOption YouTube & Partners line items cannot be created or updated using the API."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:lineItemId :advertiserId :targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
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

(defn lineItems-targetingTypes-assignedTargetingOptions-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/lineItems/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: advertiserId, lineItemId, targetingType, assignedTargetingOptionId
  
  Optional parameters: none
  
  Deletes an assigned targeting option from a line item. Requests to this endpoint cannot be made concurrently with the following requests updating the same line item: * lineItems.bulkEditAssignedTargetingOptions * lineItems.bulkUpdate * lineItems.patch * CreateLineItemAssignedTargetingOption YouTube & Partners line items cannot be created or updated using the API."
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
     "v3/advertisers/{+advertiserId}/lineItems/{+lineItemId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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

(defn campaigns-listAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/listAssignedTargetingOptions
  
  Required parameters: advertiserId, campaignId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists assigned targeting options of a campaign across targeting types."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}:listAssignedTargetingOptions"
     #{:campaignId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/get
  
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
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists campaigns in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, campaigns with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/campaigns"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:displayName string,
   :name string,
   :campaignGoal {:campaignGoalType string,
                  :performanceGoal PerformanceGoal},
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
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
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
     "v3/advertisers/{+advertiserId}/campaigns"
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

(defn campaigns-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/patch
  
  Required parameters: advertiserId, campaignId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :name string,
   :campaignGoal {:campaignGoalType string,
                  :performanceGoal PerformanceGoal},
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
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
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
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}"
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

(defn campaigns-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/delete
  
  Required parameters: advertiserId, campaignId
  
  Optional parameters: none
  
  Permanently deletes a campaign. A deleted campaign cannot be recovered. The campaign should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, to be able to delete it. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"
            "https://www.googleapis.com/auth/display-video-mediaplanning"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:campaignId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}"
     #{:campaignId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn campaigns-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, campaignId, targetingType, assignedTargetingOptionId
  
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
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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

(defn campaigns-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/campaigns/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, campaignId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
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
     "v3/advertisers/{+advertiserId}/campaigns/{+campaignId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:campaignId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroupAds-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroupAds/get
  
  Required parameters: advertiserId, adGroupAdId
  
  Optional parameters: none
  
  Gets an ad group ad."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adGroupAdId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroupAds/{+adGroupAdId}"
     #{:adGroupAdId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroupAds-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroupAds/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists ad group ads."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroupAds"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/creatives/get
  
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
     "v3/advertisers/{+advertiserId}/creatives/{+creativeId}"
     #{:creativeId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/creatives/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists creatives in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, creatives with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/creatives"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/creatives/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:requireMraid boolean,
   :skippable boolean,
   :reviewStatus {:approvalStatus string,
                  :creativeAndLandingPageReviewStatus string,
                  :contentAndPolicyReviewStatus string,
                  :exchangeReviewStatuses [ExchangeReviewStatus],
                  :publisherReviewStatuses [PublisherReviewStatus]},
   :creativeAttributes [string],
   :trackerUrls [string],
   :iasCampaignMonitoring boolean,
   :displayName string,
   :assets [{:asset Asset, :role string}],
   :skipOffset {:percentage string, :seconds string},
   :name string,
   :vpaid boolean,
   :universalAdId {:id string, :registry string},
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
   :thirdPartyUrls [{:type string, :url string}],
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
   :progressOffset {:percentage string, :seconds string},
   :requireHtml5 boolean,
   :obaIcon {:resourceUrl string,
             :resourceMimeType string,
             :position string,
             :dimensions Dimensions,
             :program string,
             :landingPageUrl string,
             :clickTrackingUrl string,
             :viewTrackingUrl string},
   :integrationCode string,
   :companionCreativeIds [string],
   :cmTrackingAd {:cmPlacementId string,
                  :cmCreativeId string,
                  :cmAdId string},
   :expandOnHover boolean,
   :hostingSource string,
   :timerEvents [{:name string, :reportingName string}],
   :cmPlacementId string,
   :mediaDuration string,
   :thirdPartyTag string,
   :exitEvents [{:type string,
                 :url string,
                 :name string,
                 :reportingName string}],
   :entityStatus string}
  
  Creates a new creative. Returns the newly created creative if successful. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/creatives"
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

(defn creatives-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/creatives/patch
  
  Required parameters: advertiserId, creativeId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:requireMraid boolean,
   :skippable boolean,
   :reviewStatus {:approvalStatus string,
                  :creativeAndLandingPageReviewStatus string,
                  :contentAndPolicyReviewStatus string,
                  :exchangeReviewStatuses [ExchangeReviewStatus],
                  :publisherReviewStatuses [PublisherReviewStatus]},
   :creativeAttributes [string],
   :trackerUrls [string],
   :iasCampaignMonitoring boolean,
   :displayName string,
   :assets [{:asset Asset, :role string}],
   :skipOffset {:percentage string, :seconds string},
   :name string,
   :vpaid boolean,
   :universalAdId {:id string, :registry string},
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
   :thirdPartyUrls [{:type string, :url string}],
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
   :progressOffset {:percentage string, :seconds string},
   :requireHtml5 boolean,
   :obaIcon {:resourceUrl string,
             :resourceMimeType string,
             :position string,
             :dimensions Dimensions,
             :program string,
             :landingPageUrl string,
             :clickTrackingUrl string,
             :viewTrackingUrl string},
   :integrationCode string,
   :companionCreativeIds [string],
   :cmTrackingAd {:cmPlacementId string,
                  :cmCreativeId string,
                  :cmAdId string},
   :expandOnHover boolean,
   :hostingSource string,
   :timerEvents [{:name string, :reportingName string}],
   :cmPlacementId string,
   :mediaDuration string,
   :thirdPartyTag string,
   :exitEvents [{:type string,
                 :url string,
                 :name string,
                 :reportingName string}],
   :entityStatus string}
  
  Updates an existing creative. Returns the updated creative if successful. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :advertiserId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/creatives/{+creativeId}"
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

(defn creatives-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/creatives/delete
  
  Required parameters: advertiserId, creativeId
  
  Optional parameters: none
  
  Deletes a creative. Returns error code `NOT_FOUND` if the creative does not exist. The creative should be archived first, i.e. set entity_status to `ENTITY_STATUS_ARCHIVED`, before it can be deleted. A [\"Standard\" user role](//support.google.com/displayvideo/answer/2723011) or greater for the parent advertiser or partner is required to make this request."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeId :advertiserId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/creatives/{+creativeId}"
     #{:creativeId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/targetingTypes/assignedTargetingOptions/get
  
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
     "v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists the targeting options assigned to an advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: advertiserId, targetingType
  
  Optional parameters: none
  
  Body: 
  
  {:contentGenreDetails {:targetingOptionId string,
                         :displayName string,
                         :negative boolean},
   :negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:parentalStatus string},
   :geoRegionDetails {:displayName string,
                      :targetingOptionId string,
                      :geoRegionType string,
                      :negative boolean},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:displayName string,
                    :targetingOptionId string,
                    :negative boolean},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :nativeContentPositionDetails {:contentPosition string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :appCategoryDetails {:displayName string,
                        :targetingOptionId string,
                        :negative boolean},
   :contentInstreamPositionDetails {:contentInstreamPosition string,
                                    :adType string},
   :inventorySourceDetails {:inventorySourceId string},
   :audioContentTypeDetails {:audioContentType string},
   :thirdPartyVerifierDetails {:adloox Adloox,
                               :doubleVerify DoubleVerify,
                               :integralAdScience IntegralAdScience},
   :name string,
   :onScreenPositionDetails {:targetingOptionId string,
                             :onScreenPosition string,
                             :adType string},
   :videoPlayerSizeDetails {:videoPlayerSize string},
   :carrierAndIspDetails {:displayName string,
                          :targetingOptionId string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityLocationListId string,
                                  :proximityRadius number,
                                  :proximityRadiusUnit string},
   :contentStreamTypeDetails {:targetingOptionId string,
                              :contentStreamType string},
   :digitalContentLabelExclusionDetails {:excludedContentRatingTier string},
   :ageRangeDetails {:ageRange string},
   :deviceMakeModelDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :categoryDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :inheritance string,
   :businessChainDetails {:displayName string,
                          :targetingOptionId string,
                          :proximityRadiusAmount number,
                          :proximityRadiusUnit string},
   :audienceGroupDetails {:includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCustomListGroup CustomListGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :excludedGoogleAudienceGroup GoogleAudienceGroup},
   :channelDetails {:channelId string, :negative boolean},
   :contentDurationDetails {:targetingOptionId string,
                            :contentDuration string},
   :targetingType string,
   :environmentDetails {:environment string},
   :poiDetails {:displayName string,
                :targetingOptionId string,
                :latitude number,
                :longitude number,
                :proximityRadiusAmount number,
                :proximityRadiusUnit string},
   :sensitiveCategoryExclusionDetails {:excludedSensitiveCategory string},
   :youtubeVideoDetails {:videoId string, :negative boolean},
   :sessionPositionDetails {:sessionPosition string},
   :deviceTypeDetails {:deviceType string,
                       :youtubeAndPartnersBidMultiplier number},
   :appDetails {:appId string,
                :displayName string,
                :negative boolean,
                :appPlatform string},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string},
   :languageDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :viewabilityDetails {:viewability string},
   :assignedTargetingOptionIdAlias string,
   :keywordDetails {:keyword string, :negative boolean},
   :urlDetails {:url string, :negative boolean},
   :exchangeDetails {:exchange string},
   :dayAndTimeDetails {:dayOfWeek string,
                       :startHour integer,
                       :endHour integer,
                       :timeZoneResolution string},
   :householdIncomeDetails {:householdIncome string},
   :authorizedSellerStatusDetails {:authorizedSellerStatus string,
                                   :targetingOptionId string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :adType string},
   :youtubeChannelDetails {:channelId string, :negative boolean},
   :userRewardedContentDetails {:targetingOptionId string,
                                :userRewardedContent string},
   :omidDetails {:omid string}}
  
  Assigns a targeting option to an advertiser. Returns the assigned targeting option if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:advertiserId :targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: advertiserId, targetingType, assignedTargetingOptionId
  
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
     "v3/advertisers/{+advertiserId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroups-bulkListAdGroupAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroups/bulkListAdGroupAssignedTargetingOptions
  
  Required parameters: advertiserId
  
  Optional parameters: adGroupIds, pageSize, pageToken, orderBy, filter
  
  Lists assigned targeting options for multiple ad groups across targeting types. Inherited assigned targeting options are not included."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroups:bulkListAdGroupAssignedTargetingOptions"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroups-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroups/get
  
  Required parameters: advertiserId, adGroupId
  
  Optional parameters: none
  
  Gets an ad group."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:adGroupId :advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}"
     #{:adGroupId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroups-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroups/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists ad groups."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroups"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn adGroups-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroups/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, adGroupId, targetingType, assignedTargetingOptionId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to an ad group. Inherited assigned targeting options are not included."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId
            :adGroupId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId
       :adGroupId
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

(defn adGroups-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/adGroups/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, adGroupId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists the targeting options assigned to an ad group. Inherited assigned targeting options are not included."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:adGroupId :advertiserId :targetingType})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/adGroups/{+adGroupId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:adGroupId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-listAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/listAssignedTargetingOptions
  
  Required parameters: advertiserId, insertionOrderId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}:listAssignedTargetingOptions"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/get
  
  Required parameters: advertiserId, insertionOrderId
  
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/list
  
  Required parameters: advertiserId
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists insertion orders in an advertiser. The order is defined by the order_by parameter. If a filter by entity_status is not specified, insertion orders with `ENTITY_STATUS_ARCHIVED` will not be included in the results."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:advertiserId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/insertionOrders"
     #{:advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/create
  
  Required parameters: advertiserId
  
  Optional parameters: none
  
  Body: 
  
  {:insertionOrderId string,
   :partnerCosts [{:costType string,
                   :feeType string,
                   :feeAmount string,
                   :feePercentageMillis string,
                   :invoiceType string}],
   :kpi {:kpiType string,
         :kpiAmountMicros string,
         :kpiPercentageMicros string,
         :kpiString string},
   :bidStrategy {:fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy,
                 :performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :youtubeAndPartnersBid YoutubeAndPartnersBiddingStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:pacingPeriod string,
            :pacingType string,
            :dailyMaxMicros string,
            :dailyMaxImpressions string},
   :updateTime string,
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :budget {:budgetUnit string,
            :automationType string,
            :budgetSegments [InsertionOrderBudgetSegment]},
   :reservationType string,
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
     "v3/advertisers/{+advertiserId}/insertionOrders"
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

(defn insertionOrders-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/patch
  
  Required parameters: advertiserId, insertionOrderId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:insertionOrderId string,
   :partnerCosts [{:costType string,
                   :feeType string,
                   :feeAmount string,
                   :feePercentageMillis string,
                   :invoiceType string}],
   :kpi {:kpiType string,
         :kpiAmountMicros string,
         :kpiPercentageMicros string,
         :kpiString string},
   :bidStrategy {:fixedBid FixedBidStrategy,
                 :maximizeSpendAutoBid MaximizeSpendBidStrategy,
                 :performanceGoalAutoBid PerformanceGoalBidStrategy,
                 :youtubeAndPartnersBid YoutubeAndPartnersBiddingStrategy},
   :displayName string,
   :name string,
   :campaignId string,
   :pacing {:pacingPeriod string,
            :pacingType string,
            :dailyMaxMicros string,
            :dailyMaxImpressions string},
   :updateTime string,
   :frequencyCap {:unlimited boolean,
                  :timeUnit string,
                  :timeUnitCount integer,
                  :maxImpressions integer,
                  :maxViews integer},
   :advertiserId string,
   :integrationDetails {:integrationCode string, :details string},
   :budget {:budgetUnit string,
            :automationType string,
            :budgetSegments [InsertionOrderBudgetSegment]},
   :reservationType string,
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
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

(defn insertionOrders-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/delete
  
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}"
     #{:insertionOrderId :advertiserId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: advertiserId, insertionOrderId, targetingType, assignedTargetingOptionId
  
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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

(defn insertionOrders-targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: advertiserId, insertionOrderId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
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
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:insertionOrderId :advertiserId :targetingType}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insertionOrders-targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: advertiserId, insertionOrderId, targetingType
  
  Optional parameters: none
  
  Body: 
  
  {:contentGenreDetails {:targetingOptionId string,
                         :displayName string,
                         :negative boolean},
   :negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:parentalStatus string},
   :geoRegionDetails {:displayName string,
                      :targetingOptionId string,
                      :geoRegionType string,
                      :negative boolean},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:displayName string,
                    :targetingOptionId string,
                    :negative boolean},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :nativeContentPositionDetails {:contentPosition string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :appCategoryDetails {:displayName string,
                        :targetingOptionId string,
                        :negative boolean},
   :contentInstreamPositionDetails {:contentInstreamPosition string,
                                    :adType string},
   :inventorySourceDetails {:inventorySourceId string},
   :audioContentTypeDetails {:audioContentType string},
   :thirdPartyVerifierDetails {:adloox Adloox,
                               :doubleVerify DoubleVerify,
                               :integralAdScience IntegralAdScience},
   :name string,
   :onScreenPositionDetails {:targetingOptionId string,
                             :onScreenPosition string,
                             :adType string},
   :videoPlayerSizeDetails {:videoPlayerSize string},
   :carrierAndIspDetails {:displayName string,
                          :targetingOptionId string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityLocationListId string,
                                  :proximityRadius number,
                                  :proximityRadiusUnit string},
   :contentStreamTypeDetails {:targetingOptionId string,
                              :contentStreamType string},
   :digitalContentLabelExclusionDetails {:excludedContentRatingTier string},
   :ageRangeDetails {:ageRange string},
   :deviceMakeModelDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :categoryDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :inheritance string,
   :businessChainDetails {:displayName string,
                          :targetingOptionId string,
                          :proximityRadiusAmount number,
                          :proximityRadiusUnit string},
   :audienceGroupDetails {:includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedCustomListGroup CustomListGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :excludedGoogleAudienceGroup GoogleAudienceGroup},
   :channelDetails {:channelId string, :negative boolean},
   :contentDurationDetails {:targetingOptionId string,
                            :contentDuration string},
   :targetingType string,
   :environmentDetails {:environment string},
   :poiDetails {:displayName string,
                :targetingOptionId string,
                :latitude number,
                :longitude number,
                :proximityRadiusAmount number,
                :proximityRadiusUnit string},
   :sensitiveCategoryExclusionDetails {:excludedSensitiveCategory string},
   :youtubeVideoDetails {:videoId string, :negative boolean},
   :sessionPositionDetails {:sessionPosition string},
   :deviceTypeDetails {:deviceType string,
                       :youtubeAndPartnersBidMultiplier number},
   :appDetails {:appId string,
                :displayName string,
                :negative boolean,
                :appPlatform string},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string},
   :languageDetails {:displayName string,
                     :targetingOptionId string,
                     :negative boolean},
   :viewabilityDetails {:viewability string},
   :assignedTargetingOptionIdAlias string,
   :keywordDetails {:keyword string, :negative boolean},
   :urlDetails {:url string, :negative boolean},
   :exchangeDetails {:exchange string},
   :dayAndTimeDetails {:dayOfWeek string,
                       :startHour integer,
                       :endHour integer,
                       :timeZoneResolution string},
   :householdIncomeDetails {:householdIncome string},
   :authorizedSellerStatusDetails {:authorizedSellerStatus string,
                                   :targetingOptionId string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :adType string},
   :youtubeChannelDetails {:channelId string, :negative boolean},
   :userRewardedContentDetails {:targetingOptionId string,
                                :userRewardedContent string},
   :omidDetails {:omid string}}
  
  Assigns a targeting option to an insertion order. Returns the assigned targeting option if successful. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId :advertiserId :targetingType})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:insertionOrderId :advertiserId :targetingType}
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

(defn insertionOrders-targetingTypes-assignedTargetingOptions-delete$
  "https://developers.google.com/display-video/api/reference/rest/v3/advertisers/insertionOrders/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: advertiserId, insertionOrderId, targetingType, assignedTargetingOptionId
  
  Optional parameters: none
  
  Deletes an assigned targeting option from an insertion order. Supported targeting types: * `TARGETING_TYPE_AGE_RANGE` * `TARGETING_TYPE_BROWSER` * `TARGETING_TYPE_CATEGORY` * `TARGETING_TYPE_CHANNEL` * `TARGETING_TYPE_DEVICE_MAKE_MODEL` * `TARGETING_TYPE_DIGITAL_CONTENT_LABEL_EXCLUSION` * `TARGETING_TYPE_ENVIRONMENT` * `TARGETING_TYPE_GENDER` * `TARGETING_TYPE_KEYWORD` * `TARGETING_TYPE_LANGUAGE` * `TARGETING_TYPE_NEGATIVE_KEYWORD_LIST` * `TARGETING_TYPE_OPERATING_SYSTEM` * `TARGETING_TYPE_PARENTAL_STATUS` * `TARGETING_TYPE_SENSITIVE_CATEGORY_EXCLUSION` * `TARGETING_TYPE_VIEWABILITY`"
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:insertionOrderId
            :assignedTargetingOptionId
            :advertiserId
            :targetingType})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/advertisers/{+advertiserId}/insertionOrders/{+insertionOrderId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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
