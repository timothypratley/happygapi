(ns happygapi.displayvideo.partners
  "Display & Video 360 API: partners.
  Display & Video 360 API allows users to manage and create campaigns and reports.
  See: https://developers.google.com/display-video/api/reference/rest/v1/partners"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/get
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Gets a partner."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}"
     #{:partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn bulkEditPartnerAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/bulkEditPartnerAssignedTargetingOptions
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:deleteRequests [{:assignedTargetingOptionIds [string],
                     :targetingType string}],
   :createRequests [{:assignedTargetingOptions [AssignedTargetingOption],
                     :targetingType string}]}
  
  Bulk edits targeting options under a single partner. The operation will delete the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.deleteRequests and then create the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.createRequests ."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}:bulkEditPartnerAssignedTargetingOptions"
     #{:partnerId}
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

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/list
  
  Required parameters: none
  
  Optional parameters: pageSize, orderBy, pageToken, filter
  
  Lists partners that are accessible to the current user. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: assignedTargetingOptionId, targetingType, partnerId
  
  Optional parameters: none
  
  Gets a single targeting option assigned to a partner."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId :targetingType :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :targetingType :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: partnerId, targetingType
  
  Optional parameters: filter, orderBy, pageToken, pageSize
  
  Lists the targeting options assigned to a partner."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetingType :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:targetingType :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: targetingType, partnerId
  
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
  
  Assigns a targeting option to a partner. Returns the assigned targeting option if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetingType :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
     #{:targetingType :partnerId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: partnerId, assignedTargetingOptionId, targetingType
  
  Optional parameters: none
  
  Deletes an assigned targeting option from a partner."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:assignedTargetingOptionId :targetingType :partnerId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :targetingType :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/patch
  
  Required parameters: partnerId, channelId
  
  Optional parameters: advertiserId, updateMask
  
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
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/channels/{channelId}"
     #{:channelId :partnerId}
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

(defn channels-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/create
  
  Required parameters: partnerId
  
  Optional parameters: advertiserId
  
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
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/channels"
     #{:partnerId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/list
  
  Required parameters: partnerId
  
  Optional parameters: pageToken, advertiserId, orderBy, pageSize, filter
  
  Lists channels for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/channels"
     #{:partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/get
  
  Required parameters: channelId, partnerId
  
  Optional parameters: advertiserId
  
  Gets a channel for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/channels/{+channelId}"
     #{:channelId :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/create
  
  Required parameters: channelId, partnerId
  
  Optional parameters: advertiserId
  
  Body: 
  
  {:name string, :urlOrAppId string}
  
  Creates a site in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{partnerId}/channels/{+channelId}/sites"
     #{:channelId :partnerId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/delete
  
  Required parameters: urlOrAppId, channelId, partnerId
  
  Optional parameters: advertiserId
  
  Deletes a site from a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:urlOrAppId :channelId :partnerId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{partnerId}/channels/{+channelId}/sites/{+urlOrAppId}"
     #{:urlOrAppId :channelId :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/list
  
  Required parameters: partnerId, channelId
  
  Optional parameters: pageToken, filter, pageSize, advertiserId, orderBy
  
  Lists sites in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{+partnerId}/channels/{+channelId}/sites"
     #{:channelId :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/bulkEdit
  
  Required parameters: partnerId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :createdSites [{:name string, :urlOrAppId string}],
   :partnerId string,
   :deletedSites [string]}
  
  Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{partnerId}/channels/{+channelId}/sites:bulkEdit"
     #{:channelId :partnerId}
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
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/replace
  
  Required parameters: partnerId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:advertiserId string,
   :newSites [{:name string, :urlOrAppId string}],
   :partnerId string}
  
  Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v1/partners/{partnerId}/channels/{+channelId}/sites:replace"
     #{:channelId :partnerId}
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
