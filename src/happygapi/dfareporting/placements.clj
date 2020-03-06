(ns happygapi.dfareporting.placements
  "DCM/DFA Reporting And Trafficking API: placements.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generatetags$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/generatetags
  
  Required parameters: profileId
  
  Optional parameters: campaignId, placementIds, tagFormats
  Generates tags for a placement."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements/generatetags"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one placement by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements/{id}"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
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
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :etag string,
                                    :id string,
                                    :kind string,
                                    :matchType string,
                                    :value string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:companionSettings CompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SkippableSetting,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
     #{:profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, groupIds, pageToken, compatibilities, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, sizeIds, placementStrategyIds, directorySiteIds, maxStartDate, paymentSource, maxResults, siteIds
  Retrieves a list of placements, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
     #{:profileId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placements/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :etag string,
                                    :id string,
                                    :kind string,
                                    :matchType string,
                                    :value string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:companionSettings CompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SkippableSetting,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
     #{:id :profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
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
   :placementGroupIdDimensionValue {:dimensionName string,
                                    :etag string,
                                    :id string,
                                    :kind string,
                                    :matchType string,
                                    :value string},
   :keyName string,
   :primary boolean,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :additionalSizes [{:height integer,
                      :iab boolean,
                      :id string,
                      :kind string,
                      :width integer}],
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
   :adBlockingOptOut boolean,
   :compatibility string,
   :tagFormats [string],
   :vpaidAdapterChoice string,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :name string,
   :placementStrategyId string,
   :campaignId string,
   :createInfo {:time string},
   :videoActiveViewOptOut boolean,
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :placementGroupId string,
   :tagSetting {:additionalKeyValues string,
                :includeClickThroughUrls boolean,
                :includeClickTracking boolean,
                :keywordOption string},
   :contentCategoryId string,
   :videoSettings {:companionSettings CompanionSetting,
                   :kind string,
                   :orientation string,
                   :skippableSettings SkippableSetting,
                   :transcodeSettings TranscodeSetting},
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :status string,
   :sslRequired boolean,
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
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
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placements"
     #{:profileId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
