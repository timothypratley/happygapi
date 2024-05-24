(ns happygapi.displayvideo.partners
  "Display & Video 360 API: partners.
  Display & Video 360 API allows users to automate complex Display & Video 360 workflows, such as creating insertion orders and setting targeting options for individual line items.
  See: https://developers.google.com/display-video/docs/reference/rest/v3/partners"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn editAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/editAssignedTargetingOptions
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:deleteRequests [{:targetingType string,
                     :assignedTargetingOptionIds [string]}],
   :createRequests [{:targetingType string,
                     :assignedTargetingOptions [AssignedTargetingOption]}]}
  
  Edits targeting options under a single partner. The operation will delete the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.deleteRequests and then create the assigned targeting options provided in BulkEditPartnerAssignedTargetingOptionsRequest.createRequests ."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}:editAssignedTargetingOptions"
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

(defn get$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/get
  
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
     "v3/partners/{+partnerId}"
     #{:partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/list
  
  Required parameters: none
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists partners that are accessible to the current user. The order is defined by the order_by parameter."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/get
  
  Required parameters: partnerId, channelId
  
  Optional parameters: advertiserId
  
  Gets a channel for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/channels/{+channelId}"
     #{:channelId :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/list
  
  Required parameters: partnerId
  
  Optional parameters: advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists channels for a partner or advertiser."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/channels"
     #{:partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-create$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/create
  
  Required parameters: partnerId
  
  Optional parameters: advertiserId
  
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
  {:pre [(util/has-keys? parameters #{:partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/channels"
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

(defn channels-patch$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/patch
  
  Required parameters: partnerId, channelId
  
  Optional parameters: advertiserId, updateMask
  
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
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/channels/{channelId}"
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

(defn channels-sites-list$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/sites/list
  
  Required parameters: partnerId, channelId
  
  Optional parameters: advertiserId, pageSize, pageToken, orderBy, filter
  
  Lists sites in a channel."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/channels/{+channelId}/sites"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/sites/create
  
  Required parameters: partnerId, channelId
  
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
     "v3/partners/{partnerId}/channels/{+channelId}/sites"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/sites/delete
  
  Required parameters: partnerId, channelId, urlOrAppId
  
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
     "v3/partners/{partnerId}/channels/{+channelId}/sites/{+urlOrAppId}"
     #{:urlOrAppId :channelId :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn channels-sites-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/sites/bulkEdit
  
  Required parameters: partnerId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :deletedSites [string],
   :createdSites [{:name string, :urlOrAppId string}]}
  
  Bulk edits sites under a single channel. The operation will delete the sites provided in BulkEditSitesRequest.deleted_sites and then create the sites provided in BulkEditSitesRequest.created_sites."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{partnerId}/channels/{+channelId}/sites:bulkEdit"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/channels/sites/replace
  
  Required parameters: partnerId, channelId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :advertiserId string,
   :newSites [{:name string, :urlOrAppId string}]}
  
  Replaces all of the sites under a single channel. The operation will replace the sites under a channel with the sites provided in ReplaceSitesRequest.new_sites. **This method regularly experiences high latency.** We recommend [increasing your default timeout](/display-video/api/guides/best-practices/timeouts#client_library_timeout) to avoid errors."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:channelId :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{partnerId}/channels/{+channelId}/sites:replace"
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

(defn targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: partnerId, targetingType, assignedTargetingOptionId
  
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
     "v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/targetingTypes/assignedTargetingOptions/list
  
  Required parameters: partnerId, targetingType
  
  Optional parameters: pageSize, pageToken, orderBy, filter
  
  Lists the targeting options assigned to a partner."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:targetingType :partnerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: partnerId, targetingType
  
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
  
  Assigns a targeting option to a partner. Returns the assigned targeting option if successful."
  {:scopes ["https://www.googleapis.com/auth/display-video"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:targetingType :partnerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://displayvideo.googleapis.com/"
     "v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions"
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
  "https://developers.google.com/display-video/api/reference/rest/v3/partners/targetingTypes/assignedTargetingOptions/delete
  
  Required parameters: partnerId, targetingType, assignedTargetingOptionId
  
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
     "v3/partners/{+partnerId}/targetingTypes/{+targetingType}/assignedTargetingOptions/{+assignedTargetingOptionId}"
     #{:assignedTargetingOptionId :targetingType :partnerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
