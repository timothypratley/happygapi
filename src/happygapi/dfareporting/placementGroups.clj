(ns happygapi.dfareporting.placementGroups
  "DCM/DFA Reporting And Trafficking API: placementGroups.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one placement group by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
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
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :etag string,
                                      :id string,
                                      :kind string,
                                      :matchType string,
                                      :value string},
   :accountId string}
  
  Inserts a new placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/list
  
  Required parameters: profileId
  
  Optional parameters: archived, pricingTypes, minEndDate, campaignIds, contentCategoryIds, ids, searchString, placementGroupType, pageToken, sortField, minStartDate, advertiserIds, maxEndDate, sortOrder, placementStrategyIds, directorySiteIds, maxStartDate, maxResults, siteIds
  Retrieves a list of placement groups, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
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
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :etag string,
                                      :id string,
                                      :kind string,
                                      :matchType string,
                                      :value string},
   :accountId string}
  
  Updates an existing placement group. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/placementGroups/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :directorySiteId string,
   :siteId string,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :pricingSchedule {:capCostOption string,
                     :endDate string,
                     :flighted boolean,
                     :floodlightActivityId string,
                     :pricingPeriods [PricingSchedulePricingPeriod],
                     :pricingType string,
                     :startDate string,
                     :testingStartDate string},
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
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :placementGroupType string,
   :contentCategoryId string,
   :primaryPlacementId string,
   :advertiserId string,
   :externalId string,
   :directorySiteIdDimensionValue {:dimensionName string,
                                   :etag string,
                                   :id string,
                                   :kind string,
                                   :matchType string,
                                   :value string},
   :id string,
   :siteIdDimensionValue {:dimensionName string,
                          :etag string,
                          :id string,
                          :kind string,
                          :matchType string,
                          :value string},
   :kind string,
   :comment string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :childPlacementIds [string],
   :primaryPlacementIdDimensionValue {:dimensionName string,
                                      :etag string,
                                      :id string,
                                      :kind string,
                                      :matchType string,
                                      :value string},
   :accountId string}
  
  Updates an existing placement group."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/placementGroups"
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
