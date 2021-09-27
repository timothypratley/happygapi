(ns happygapi.dfareporting.campaigns
  "Campaign Manager 360 API: campaigns.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :creativeGroupIds [string],
   :measurementPartnerLink {:measurementPartner string,
                            :partnerCampaignId string,
                            :linkStatus string},
   :additionalCreativeOptimizationConfigurations [{:optimizationActivitys [OptimizationActivity],
                                                   :name string,
                                                   :optimizationModel string,
                                                   :id string}],
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:enabled boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:optimizationActivitys [OptimizationActivity],
                                       :name string,
                                       :optimizationModel string,
                                       :id string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:name string,
                            :id string,
                            :audienceSegments [AudienceSegment]}],
   :nielsenOcrEnabled boolean}
  
  Updates an existing campaign."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/campaigns"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one campaign by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/campaigns/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :creativeGroupIds [string],
   :measurementPartnerLink {:measurementPartner string,
                            :partnerCampaignId string,
                            :linkStatus string},
   :additionalCreativeOptimizationConfigurations [{:optimizationActivitys [OptimizationActivity],
                                                   :name string,
                                                   :optimizationModel string,
                                                   :id string}],
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:enabled boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:optimizationActivitys [OptimizationActivity],
                                       :name string,
                                       :optimizationModel string,
                                       :id string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:name string,
                            :id string,
                            :audienceSegments [AudienceSegment]}],
   :nielsenOcrEnabled boolean}
  
  Inserts a new campaign."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/campaigns"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns/list
  
  Required parameters: profileId
  
  Optional parameters: archived, atLeastOneOptimizationActivity, overriddenEventTagId, ids, searchString, advertiserGroupIds, pageToken, sortField, advertiserIds, sortOrder, subaccountId, maxResults, excludedIds
  
  Retrieves a list of campaigns, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/campaigns"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/campaigns/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :creativeGroupIds [string],
   :measurementPartnerLink {:measurementPartner string,
                            :partnerCampaignId string,
                            :linkStatus string},
   :additionalCreativeOptimizationConfigurations [{:optimizationActivitys [OptimizationActivity],
                                                   :name string,
                                                   :optimizationModel string,
                                                   :id string}],
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :traffickerEmails [string],
   :name string,
   :startDate string,
   :createInfo {:time string},
   :advertiserGroupId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :adBlockingConfiguration {:enabled boolean},
   :endDate string,
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :externalId string,
   :defaultLandingPageId string,
   :id string,
   :kind string,
   :comment string,
   :creativeOptimizationConfiguration {:optimizationActivitys [OptimizationActivity],
                                       :name string,
                                       :optimizationModel string,
                                       :id string},
   :billingInvoiceCode string,
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :audienceSegmentGroups [{:name string,
                            :id string,
                            :audienceSegments [AudienceSegment]}],
   :nielsenOcrEnabled boolean}
  
  Updates an existing campaign. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/campaigns"
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
