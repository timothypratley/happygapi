(ns happygapi.dfareporting.ads
  "Campaign Manager 360 API: ads.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/docs/reference/rest/v4/ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/ads/get
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Gets one ad by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/ads/{+id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/ads/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :clickThroughUrl {:defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string,
                     :computedClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :creativeRotation {:type string,
                      :weightCalculationStrategy string,
                      :creativeOptimizationConfigurationId string,
                      :creativeAssignments [CreativeAssignment]},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
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
   :deliverySchedule {:hardCutoff boolean,
                      :priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementId string,
                           :active boolean,
                           :sslRequired boolean,
                           :placementIdDimensionValue DimensionValue}],
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
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/ads/list
  
  Required parameters: profileId
  
  Optional parameters: archived, dynamicClickTracker, creativeOptimizationConfigurationIds, compatibility, overriddenEventTagId, sslCompliant, campaignIds, audienceSegmentIds, ids, type, searchString, remarketingListIds, pageToken, sortField, creativeIds, advertiserId, sslRequired, active, sortOrder, placementIds, sizeIds, landingPageIds, maxResults
  
  Retrieves a list of ads, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/ads/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :clickThroughUrl {:defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string,
                     :computedClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :creativeRotation {:type string,
                      :weightCalculationStrategy string,
                      :creativeOptimizationConfigurationId string,
                      :creativeAssignments [CreativeAssignment]},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
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
   :deliverySchedule {:hardCutoff boolean,
                      :priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementId string,
                           :active boolean,
                           :sslRequired boolean,
                           :placementIdDimensionValue DimensionValue}],
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
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/ads/patch
  
  Required parameters: profileId, id
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:userLocalTime boolean,
                      :daysOfWeek [string],
                      :hoursOfDay [integer]},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:excludeCountries boolean,
                  :countries [Country],
                  :regions [Region],
                  :cities [City],
                  :metros [Metro],
                  :postalCodes [PostalCode]},
   :idDimensionValue {:dimensionName string,
                      :value string,
                      :id string,
                      :matchType string,
                      :kind string,
                      :etag string},
   :clickThroughUrl {:defaultLandingPage boolean,
                     :landingPageId string,
                     :customClickThroughUrl string,
                     :computedClickThroughUrl string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :value string,
                                :id string,
                                :matchType string,
                                :kind string,
                                :etag string},
   :name string,
   :creativeRotation {:type string,
                      :weightCalculationStrategy string,
                      :creativeOptimizationConfigurationId string,
                      :creativeAssignments [CreativeAssignment]},
   :campaignId string,
   :comments string,
   :endTime string,
   :type string,
   :createInfo {:time string},
   :audienceSegmentId string,
   :eventTagOverrides [{:id string, :enabled boolean}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :value string,
                              :id string,
                              :matchType string,
                              :kind string,
                              :etag string},
   :defaultClickThroughEventTagProperties {:overrideInheritedEventTag boolean,
                                           :defaultClickThroughEventTagId string},
   :size {:id string,
          :width integer,
          :height integer,
          :iab boolean,
          :kind string},
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
   :deliverySchedule {:hardCutoff boolean,
                      :priority string,
                      :impressionRatio string,
                      :frequencyCap FrequencyCap},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:placementId string,
                           :active boolean,
                           :sslRequired boolean,
                           :placementIdDimensionValue DimensionValue}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Updates an existing event tag. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
     "userprofiles/{+profileId}/ads"
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
