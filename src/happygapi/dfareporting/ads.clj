(ns happygapi.dfareporting.ads
  "DCM/DFA Reporting And Trafficking API: ads.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/get
  
  Required parameters: id, profileId
  
  Optional parameters: none
  Gets one ad by ID."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads/{id}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :customClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
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
   :eventTagOverrides [{:enabled boolean, :id string}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:frequencyCap FrequencyCap,
                      :hardCutoff boolean,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:active boolean,
                           :placementId string,
                           :placementIdDimensionValue DimensionValue,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Inserts a new ad."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/list
  
  Required parameters: profileId
  
  Optional parameters: archived, dynamicClickTracker, creativeOptimizationConfigurationIds, compatibility, overriddenEventTagId, sslCompliant, campaignIds, audienceSegmentIds, ids, type, searchString, remarketingListIds, pageToken, sortField, creativeIds, advertiserId, sslRequired, active, sortOrder, placementIds, sizeIds, landingPageIds, maxResults
  Retrieves a list of ads, possibly filtered. This method supports paging."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/patch
  
  Required parameters: id, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :customClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
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
   :eventTagOverrides [{:enabled boolean, :id string}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:frequencyCap FrequencyCap,
                      :hardCutoff boolean,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:active boolean,
                           :placementId string,
                           :placementIdDimensionValue DimensionValue,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Updates an existing ad. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:id :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/ads/update
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:archived boolean,
   :dynamicClickTracker boolean,
   :dayPartTargeting {:daysOfWeek [string],
                      :hoursOfDay [integer],
                      :userLocalTime boolean},
   :languageTargeting {:languages [Language]},
   :geoTargeting {:cities [City],
                  :countries [Country],
                  :excludeCountries boolean,
                  :metros [Metro],
                  :postalCodes [PostalCode],
                  :regions [Region]},
   :idDimensionValue {:dimensionName string,
                      :etag string,
                      :id string,
                      :kind string,
                      :matchType string,
                      :value string},
   :clickThroughUrl {:computedClickThroughUrl string,
                     :customClickThroughUrl string,
                     :defaultLandingPage boolean,
                     :landingPageId string},
   :startTime string,
   :compatibility string,
   :sslCompliant boolean,
   :advertiserIdDimensionValue {:dimensionName string,
                                :etag string,
                                :id string,
                                :kind string,
                                :matchType string,
                                :value string},
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
   :eventTagOverrides [{:enabled boolean, :id string}],
   :remarketingListExpression {:expression string},
   :campaignIdDimensionValue {:dimensionName string,
                              :etag string,
                              :id string,
                              :kind string,
                              :matchType string,
                              :value string},
   :defaultClickThroughEventTagProperties {:defaultClickThroughEventTagId string,
                                           :overrideInheritedEventTag boolean},
   :size {:height integer,
          :iab boolean,
          :id string,
          :kind string,
          :width integer},
   :clickThroughUrlSuffixProperties {:clickThroughUrlSuffix string,
                                     :overrideInheritedSuffix boolean},
   :advertiserId string,
   :keyValueTargetingExpression {:expression string},
   :technologyTargeting {:browsers [Browser],
                         :connectionTypes [ConnectionType],
                         :mobileCarriers [MobileCarrier],
                         :operatingSystemVersions [OperatingSystemVersion],
                         :operatingSystems [OperatingSystem],
                         :platformTypes [PlatformType]},
   :sslRequired boolean,
   :active boolean,
   :id string,
   :kind string,
   :deliverySchedule {:frequencyCap FrequencyCap,
                      :hardCutoff boolean,
                      :impressionRatio string,
                      :priority string},
   :creativeGroupAssignments [{:creativeGroupId string,
                               :creativeGroupNumber string}],
   :placementAssignments [{:active boolean,
                           :placementId string,
                           :placementIdDimensionValue DimensionValue,
                           :sslRequired boolean}],
   :lastModifiedInfo {:time string},
   :subaccountId string,
   :accountId string,
   :targetingTemplateId string}
  
  Updates an existing ad."
  {:scopes ["https://www.googleapis.com/auth/dfatrafficking"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/ads"
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
