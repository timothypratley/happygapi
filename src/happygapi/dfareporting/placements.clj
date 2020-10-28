(ns happygapi.dfareporting.placements
  "DCM/DFA Reporting And Trafficking API: placements.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one placement by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn generatetags$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/generatetags
  
  Required parameters: profileId
  
  Optional parameters: campaignId, tagFormats, placementIds
  
  Generates tags for a placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements/generatetags"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, groupIds, pageToken, compatibilities, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, sizeIds, placementStrategyIds, directorySiteIds, maxStartDate, paymentSource, maxResults, siteIds
  
  Retrieves a list of placements, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:etag string,
                                    :value string,
                                    :id string,
                                    :kind string,
                                    :dimensionName string,
                                    :matchType string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :additionalSizes [{:width integer,
                      :kind string,
                      :height integer,
                      :id string,
                      :iab boolean}],
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting,
                   :companionSettings CompanionSetting,
                   :orientation string,
                   :obaEnabled boolean},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
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
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:etag string,
                                    :value string,
                                    :id string,
                                    :kind string,
                                    :dimensionName string,
                                    :matchType string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :additionalSizes [{:width integer,
                      :kind string,
                      :height integer,
                      :id string,
                      :iab boolean}],
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting,
                   :companionSettings CompanionSetting,
                   :orientation string,
                   :obaEnabled boolean},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
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
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:etag string,
                                    :value string,
                                    :id string,
                                    :kind string,
                                    :dimensionName string,
                                    :matchType string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :additionalSizes [{:width integer,
                      :kind string,
                      :height integer,
                      :id string,
                      :iab boolean}],
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:skippableSettings SkippableSetting,
                   :kind string,
                   :obaSettings ObaIcon,
                   :transcodeSettings TranscodeSetting,
                   :companionSettings CompanionSetting,
                   :orientation string,
                   :obaEnabled boolean},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
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
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
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
