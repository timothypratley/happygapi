(ns happygapi.dfareporting.campaigns
  "DCM/DFA Reporting And Trafficking API: campaigns.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one campaign by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :creativeGroupIds [string],
   :additionalCreativeOptimizationConfigurations [{:id string,
                                                   :name string,
                                                   :optimizationActivitys [OptimizationActivity],
                                                   :optimizationModel string}],
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:enabled boolean, :id string}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:clickThroughUrl string,
                             :creativeBundleId string,
                             :enabled boolean,
                             :overrideClickThroughUrl boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:id string,
                                       :name string,
                                       :optimizationActivitys [OptimizationActivity],
                                       :optimizationModel string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:audienceSegments [AudienceSegment],
                            :id string,
                            :name string}],
   :nielsenOcrEnabled boolean}
  
  Inserts a new campaign."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns/list
  
  Required parameters: profileId
  
  Optional parameters: archived, atLeastOneOptimizationActivity, overriddenEventTagId, ids, searchString, advertiserGroupIds, pageToken, sortField, advertiserIds, sortOrder, subaccountId, maxResults, excludedIds
  
  Retrieves a list of campaigns, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :creativeGroupIds [string],
   :additionalCreativeOptimizationConfigurations [{:id string,
                                                   :name string,
                                                   :optimizationActivitys [OptimizationActivity],
                                                   :optimizationModel string}],
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:enabled boolean, :id string}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:clickThroughUrl string,
                             :creativeBundleId string,
                             :enabled boolean,
                             :overrideClickThroughUrl boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:id string,
                                       :name string,
                                       :optimizationActivitys [OptimizationActivity],
                                       :optimizationModel string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:audienceSegments [AudienceSegment],
                            :id string,
                            :name string}],
   :nielsenOcrEnabled boolean}
  
  Updates an existing campaign. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/campaigns/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :creativeGroupIds [string],
   :additionalCreativeOptimizationConfigurations [{:id string,
                                                   :name string,
                                                   :optimizationActivitys [OptimizationActivity],
                                                   :optimizationModel string}],
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:enabled boolean, :id string}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:clickThroughUrl string,
                             :creativeBundleId string,
                             :enabled boolean,
                             :overrideClickThroughUrl boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:id string,
                                       :name string,
                                       :optimizationActivitys [OptimizationActivity],
                                       :optimizationModel string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:audienceSegments [AudienceSegment],
                            :id string,
                            :name string}],
   :nielsenOcrEnabled boolean}
  
  Updates an existing campaign."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/campaigns"
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
