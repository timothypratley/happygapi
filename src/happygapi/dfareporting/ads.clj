(ns happygapi.dfareporting.ads
  "DCM/DFA Reporting And Trafficking API: ads.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :userLocalTime boolean,
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :excludeCountries boolean,
                  :postalCodes [PostalCode],
                  :cities [City],
                  :regions [Region],
                  :metros [Metro]},
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :clickThroughUrl {:landingPageId string,
                     :defaultLandingPage boolean,
                     :computedClickThroughUrl string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :creativeRotation {:creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :type string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap,
                      :hardCutoff boolean},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementIdDimensionValue DimensionValue,
                           :active boolean,
                           :placementId string,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Inserts a new ad."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/list
  
  Required parameters: profileId
  
  Optional parameters: archived, dynamicClickTracker, creativeOptimizationConfigurationIds, compatibility, overriddenEventTagId, sslCompliant, campaignIds, audienceSegmentIds, ids, type, searchString, remarketingListIds, pageToken, sortField, creativeIds, advertiserId, sslRequired, active, sortOrder, placementIds, sizeIds, landingPageIds, maxResults
  
  Retrieves a list of ads, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :userLocalTime boolean,
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :excludeCountries boolean,
                  :postalCodes [PostalCode],
                  :cities [City],
                  :regions [Region],
                  :metros [Metro]},
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :clickThroughUrl {:landingPageId string,
                     :defaultLandingPage boolean,
                     :computedClickThroughUrl string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :creativeRotation {:creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :type string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap,
                      :hardCutoff boolean},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementIdDimensionValue DimensionValue,
                           :active boolean,
                           :placementId string,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Updates an existing ad. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one ad by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads/{id}"
     #{:id :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :userLocalTime boolean,
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :excludeCountries boolean,
                  :postalCodes [PostalCode],
                  :cities [City],
                  :regions [Region],
                  :metros [Metro]},
   :idDimensionValue {:etag string,
                      :value string,
                      :id string,
                      :kind string,
                      :dimensionName string,
                      :matchType string},
   :clickThroughUrl {:landingPageId string,
                     :defaultLandingPage boolean,
                     :computedClickThroughUrl string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:etag string,
                                :value string,
                                :id string,
                                :kind string,
                                :dimensionName string,
                                :matchType string},
   :name string,
   :creativeRotation {:creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :type string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:etag string,
                              :value string,
                              :id string,
                              :kind string,
                              :dimensionName string,
                              :matchType string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:width integer,
          :kind string,
          :height integer,
          :id string,
          :iab boolean},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :browsers [Browser],
                         :platformTypes [PlatformType],
                         :mobileCarriers [MobileCarrier],
                         :connectionTypes [ConnectionType],
                         :operatingSystemVersions [OperatingSystemVersion]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap,
                      :hardCutoff boolean},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementIdDimensionValue DimensionValue,
                           :active boolean,
                           :placementId string,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Updates an existing ad."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
