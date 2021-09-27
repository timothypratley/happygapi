(ns happygapi.dfareporting.ads
  "Campaign Manager 360 API: ads.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :hoursOfDay [integer],
                      :daysOfWeek [string]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :metros [Metro],
                  :regions [Region],
                  :postalCodes [PostalCode],
                  :cities [City],
                  :excludeCountries boolean},
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :creativeRotation {:type string,
                      :creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:width integer,
          :kind string,
          :height integer,
          :iab boolean,
          :id string},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :mobileCarriers [MobileCarrier],
                         :platformTypes [PlatformType],
                         :browsers [Browser],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :connectionTypes [ConnectionType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:hardCutoff boolean,
                      :frequencyCap FrequencyCap,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupNumber string,
                               :creativeGroupId string}],
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
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/ads"
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :hoursOfDay [integer],
                      :daysOfWeek [string]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :metros [Metro],
                  :regions [Region],
                  :postalCodes [PostalCode],
                  :cities [City],
                  :excludeCountries boolean},
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :creativeRotation {:type string,
                      :creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:width integer,
          :kind string,
          :height integer,
          :iab boolean,
          :id string},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :mobileCarriers [MobileCarrier],
                         :platformTypes [PlatformType],
                         :browsers [Browser],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :connectionTypes [ConnectionType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:hardCutoff boolean,
                      :frequencyCap FrequencyCap,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupNumber string,
                               :creativeGroupId string}],
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
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads/list
  
  Required parameters: profileId
  
  Optional parameters: archived, dynamicClickTracker, creativeOptimizationConfigurationIds, compatibility, overriddenEventTagId, sslCompliant, campaignIds, audienceSegmentIds, ids, type, searchString, remarketingListIds, pageToken, sortField, creativeIds, advertiserId, sslRequired, active, sortOrder, placementIds, sizeIds, landingPageIds, maxResults
  
  Retrieves a list of ads, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/ads"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Gets one ad by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/ads/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/ads/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :hoursOfDay [integer],
                      :daysOfWeek [string]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:countries [Country],
                  :metros [Metro],
                  :regions [Region],
                  :postalCodes [PostalCode],
                  :cities [City],
                  :excludeCountries boolean},
   :idDimensionValue {:kind string,
                      :dimensionName string,
                      :matchType string,
                      :value string,
                      :etag string,
                      :id string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:kind string,
                                :dimensionName string,
                                :matchType string,
                                :value string,
                                :etag string,
                                :id string},
   :name string,
   :creativeRotation {:type string,
                      :creativeAssignments [CreativeAssignment],
                      :creativeOptimizationConfigurationId string,
                      :weightCalculationStrategy string},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:kind string,
                              :dimensionName string,
                              :matchType string,
                              :value string,
                              :etag string,
                              :id string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:width integer,
          :kind string,
          :height integer,
          :iab boolean,
          :id string},
   :clickThroughUrlSuffixProperties {:overrideInheritedSuffix boolean,
                                     :clickThroughUrlSuffix string},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:operatingSystems [OperatingSystem],
                         :mobileCarriers [MobileCarrier],
                         :platformTypes [PlatformType],
                         :browsers [Browser],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :connectionTypes [ConnectionType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:hardCutoff boolean,
                      :frequencyCap FrequencyCap,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupNumber string,
                               :creativeGroupId string}],
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
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/ads"
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
