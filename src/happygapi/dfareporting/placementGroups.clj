(ns happygapi.dfareporting.placementGroups
  "DCM/DFA Reporting And Trafficking API: placementGroups.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
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
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:etag string,
                                      :value string,
                                      :id string,
                                      :kind string,
                                      :dimensionName string,
                                      :matchType string},
   :accountId string}
  
  Updates an existing placement group. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, placementGroupType, pageToken, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, placementStrategyIds, directorySiteIds, maxStartDate, maxResults, siteIds
  
  Retrieves a list of placement groups, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
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
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:etag string,
                                      :value string,
                                      :id string,
                                      :kind string,
                                      :dimensionName string,
                                      :matchType string},
   :accountId string}
  
  Updates an existing placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :pricingSchedule {:testingStartDate string,
                     :pricingType string,
                     :capCostOption string,
                     :endDate string,
                     :startDate string,
                     :floodlightActivityId string,
                     :flighted boolean,
                     :pricingPeriods [PricingSchedulePricingPeriod]},
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
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:etag string,
                                   :value string,
                                   :id string,
                                   :kind string,
                                   :dimensionName string,
                                   :matchType string},
   :id string,
   :siteIdDimensionValue {:etag string,
                          :value string,
                          :id string,
                          :kind string,
                          :dimensionName string,
                          :matchType string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:etag string,
                                      :value string,
                                      :id string,
                                      :kind string,
                                      :dimensionName string,
                                      :matchType string},
   :accountId string}
  
  Inserts a new placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one placement group by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
