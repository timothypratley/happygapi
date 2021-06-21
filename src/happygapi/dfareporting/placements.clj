(ns happygapi.dfareporting.placements
  "Campaign Manager 360 API: placements.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :kind string,
                                    :matchType string,
                                    :id string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:tagWrappingMode string,
                         :linkStatus string,
                         :measurementPartner string,
                         :wrappedTag string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :placementGroupId string,
   :tagSetting {:keywordOption string,
                :includeClickTracking boolean,
                :additionalKeyValues string,
                :includeClickThroughUrls boolean},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :companionSettings CompanionSetting,
                   :durationSeconds integer,
                   :obaEnabled boolean,
                   :kind string,
                   :orientation string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Updates an existing placement. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements"
     #{:id :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one placement by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :kind string,
                                    :matchType string,
                                    :id string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:tagWrappingMode string,
                         :linkStatus string,
                         :measurementPartner string,
                         :wrappedTag string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :placementGroupId string,
   :tagSetting {:keywordOption string,
                :includeClickTracking boolean,
                :additionalKeyValues string,
                :includeClickThroughUrls boolean},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :companionSettings CompanionSetting,
                   :durationSeconds integer,
                   :obaEnabled boolean,
                   :kind string,
                   :orientation string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Inserts a new placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements"
     #{:profileId}
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :value string,
                                    :kind string,
                                    :matchType string,
                                    :id string,
                                    :etag string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :kind string,
                      :matchType string,
                      :id string,
                      :etag string},
   :additionalSizes [{:kind string,
                      :iab boolean,
                      :height integer,
                      :width integer,
                      :id string}],
   :wrappingOptOut boolean,
   :pricingSchedule {:testingStartDate string,
                     :flighted boolean,
                     :startDate string,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :endDate string,
                     :capCostOption string,
                     :pricingType string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :kind string,
                                :matchType string,
                                :id string,
                                :etag string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :partnerWrappingData {:tagWrappingMode string,
                         :linkStatus string,
                         :measurementPartner string,
                         :wrappedTag string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :kind string,
                              :matchType string,
                              :id string,
                              :etag string},
   :size {:kind string,
          :iab boolean,
          :height integer,
          :width integer,
          :id string},
   :placementGroupId string,
   :tagSetting {:keywordOption string,
                :includeClickTracking boolean,
                :additionalKeyValues string,
                :includeClickThroughUrls boolean},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :companionSettings CompanionSetting,
                   :durationSeconds integer,
                   :obaEnabled boolean,
                   :kind string,
                   :orientation string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :value string,
                                   :kind string,
                                   :matchType string,
                                   :id string,
                                   :etag string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :value string,
                          :kind string,
                          :matchType string,
                          :id string,
                          :etag string},
   :kind string,
   :comment string,
   :lookbackConfiguration {:clickDuration integer,
                           :postImpressionActivitiesDuration integer},
   :lastModifiedInfo {:time string},
   :publisherUpdateInfo {:time string},
   :subaccountId string,
   :paymentApproved boolean,
   :accountId string,
   :paymentSource string}
  
  Updates an existing placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements"
     #{:profileId}
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

(defn generatetags$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/generatetags
  
  Required parameters: profileId
  
  Optional parameters: tagFormats, placementIds, campaignId
  
  Generates tags for a placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements/generatetags"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/placements/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, groupIds, pageToken, compatibilities, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, sizeIds, placementStrategyIds, directorySiteIds, maxStartDate, paymentSource, maxResults, siteIds
  
  Retrieves a list of placements, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/placements"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
