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

(defn list$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/list
  
  Required parameters: none
  
  Optional parameters: orderBy, pageSize, filter, pageToken
  
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

(defn bulkEditPartnerAssignedTargetingOptions$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/bulkEditPartnerAssignedTargetingOptions
  
  Required parameters: partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:createRequests [{:targetingType string,
                     :assignedTargetingOptions [AssignedTargetingOption]}],
   :deleteRequests [{:targetingType string,
                     :assignedTargetingOptionIds [string]}]}
  
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

(defn targetingTypes-assignedTargetingOptions-create$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/create
  
  Required parameters: targetingType, partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:negativeKeywordListDetails {:negativeKeywordListId string},
   :parentalStatusDetails {:targetingOptionId string,
                           :parentalStatus string},
   :geoRegionDetails {:geoRegionType string,
                      :displayName string,
                      :negative boolean,
                      :targetingOptionId string},
   :regionalLocationListDetails {:regionalLocationListId string,
                                 :negative boolean},
   :browserDetails {:displayName string,
                    :negative boolean,
                    :targetingOptionId string},
   :inventorySourceGroupDetails {:inventorySourceGroupId string},
   :assignedTargetingOptionId string,
   :operatingSystemDetails {:displayName string,
                            :targetingOptionId string,
                            :negative boolean},
   :appCategoryDetails {:targetingOptionId string,
                        :displayName string,
                        :negative boolean},
   :contentInstreamPositionDetails {:targetingOptionId string,
                                    :contentInstreamPosition string},
   :inventorySourceDetails {:inventorySourceId string},
   :thirdPartyVerifierDetails {:adloox Adloox,
                               :integralAdScience IntegralAdScience,
                               :doubleVerify DoubleVerify},
   :name string,
   :onScreenPositionDetails {:onScreenPosition string,
                             :targetingOptionId string},
   :videoPlayerSizeDetails {:videoPlayerSize string,
                            :targetingOptionId string},
   :carrierAndIspDetails {:displayName string,
                          :targetingOptionId string,
                          :negative boolean},
   :proximityLocationListDetails {:proximityLocationListId string,
                                  :proximityRadiusRange string},
   :digitalContentLabelExclusionDetails {:contentRatingTier string,
                                         :excludedTargetingOptionId string},
   :ageRangeDetails {:targetingOptionId string, :ageRange string},
   :deviceMakeModelDetails {:displayName string,
                            :negative boolean,
                            :targetingOptionId string},
   :categoryDetails {:displayName string,
                     :negative boolean,
                     :targetingOptionId string},
   :inheritance string,
   :audienceGroupDetails {:includedGoogleAudienceGroup GoogleAudienceGroup,
                          :includedFirstAndThirdPartyAudienceGroups [FirstAndThirdPartyAudienceGroup],
                          :includedCustomListGroup CustomListGroup,
                          :excludedFirstAndThirdPartyAudienceGroup FirstAndThirdPartyAudienceGroup,
                          :includedCombinedAudienceGroup CombinedAudienceGroup,
                          :excludedGoogleAudienceGroup GoogleAudienceGroup},
   :channelDetails {:channelId string, :negative boolean},
   :targetingType string,
   :environmentDetails {:targetingOptionId string, :environment string},
   :sensitiveCategoryExclusionDetails {:sensitiveCategory string,
                                       :excludedTargetingOptionId string},
   :deviceTypeDetails {:deviceType string, :targetingOptionId string},
   :appDetails {:displayName string, :appId string, :negative boolean},
   :subExchangeDetails {:targetingOptionId string},
   :genderDetails {:gender string, :targetingOptionId string},
   :languageDetails {:targetingOptionId string,
                     :negative boolean,
                     :displayName string},
   :viewabilityDetails {:targetingOptionId string, :viewability string},
   :keywordDetails {:negative boolean, :keyword string},
   :urlDetails {:url string, :negative boolean},
   :exchangeDetails {:targetingOptionId string},
   :dayAndTimeDetails {:endHour integer,
                       :dayOfWeek string,
                       :timeZoneResolution string,
                       :startHour integer},
   :householdIncomeDetails {:targetingOptionId string,
                            :householdIncome string},
   :authorizedSellerStatusDetails {:targetingOptionId string,
                                   :authorizedSellerStatus string},
   :contentOutstreamPositionDetails {:contentOutstreamPosition string,
                                     :targetingOptionId string},
   :userRewardedContentDetails {:targetingOptionId string,
                                :userRewardedContent string}}
  
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

(defn targetingTypes-assignedTargetingOptions-get$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/get
  
  Required parameters: assignedTargetingOptionId, partnerId, targetingType
  
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
  
  Required parameters: targetingType, partnerId
  
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

(defn targetingTypes-assignedTargetingOptions-delete$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/targetingTypes/assignedTargetingOptions/delete
  
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

(defn channels-patch$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/patch
  
  Required parameters: channelId, partnerId
  
  Optional parameters: updateMask, advertiserId
  
  Body: 
  
  {:name string,
   :partnerId string,
   :channelId string,
   :advertiserId string,
   :displayName string}
  
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
  
  {:name string,
   :partnerId string,
   :channelId string,
   :advertiserId string,
   :displayName string}
  
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
  
  Optional parameters: pageSize, advertiserId, pageToken, orderBy, filter
  
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

(defn channels-sites-list$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/list
  
  Required parameters: channelId, partnerId
  
  Optional parameters: orderBy, pageToken, advertiserId, pageSize, filter
  
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
  
  Required parameters: urlOrAppId, partnerId, channelId
  
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

(defn channels-sites-bulkEdit$
  "https://developers.google.com/display-video/api/reference/rest/v1/partners/channels/sites/bulkEdit
  
  Required parameters: channelId, partnerId
  
  Optional parameters: none
  
  Body: 
  
  {:partnerId string,
   :createdSites [{:name string, :urlOrAppId string}],
   :deletedSites [string],
   :advertiserId string}
  
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
