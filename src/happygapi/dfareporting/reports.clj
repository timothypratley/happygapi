(ns happygapi.dfareporting.reports
  "Campaign Manager 360 API: reports.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:endDate string,
                                    :kind string,
                                    :startDate string,
                                    :relativeDateRange string},
                        :reportProperties {:includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean},
                        :metricNames [string],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :customRichMediaEvents [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                        :floodlightConfigId {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
                        :dimensionFilters [{:kind string,
                                            :dimensionName string,
                                            :matchType string,
                                            :value string,
                                            :etag string,
                                            :id string}]},
   :schedule {:every integer,
              :active boolean,
              :repeatsOnWeekDays [string],
              :expirationDate string,
              :startDate string,
              :repeats string,
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:metricNames [string],
                           :filters [DimensionValue],
                           :kind string},
              :metricNames [string],
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :dateRange {:endDate string,
                          :kind string,
                          :startDate string,
                          :relativeDateRange string},
              :dimensionFilters [{:kind string,
                                  :dimensionName string,
                                  :matchType string,
                                  :value string,
                                  :etag string,
                                  :id string}]},
   :delivery {:emailOwner boolean,
              :recipients [{:deliveryType string,
                            :kind string,
                            :email string}],
              :emailOwnerDeliveryType string,
              :message string},
   :type string,
   :etag string,
   :pathCriteria {:activityFilters [{:kind string,
                                     :dimensionName string,
                                     :matchType string,
                                     :value string,
                                     :etag string,
                                     :id string}],
                  :pathFilters [{:eventFilters [EventFilter],
                                 :pathMatchPosition string,
                                 :kind string}],
                  :customChannelGrouping {:kind string,
                                          :name string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule]},
                  :metricNames [string],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :dateRange {:endDate string,
                              :kind string,
                              :startDate string,
                              :relativeDateRange string},
                  :floodlightConfigId {:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}},
   :reachCriteria {:dateRange {:endDate string,
                               :kind string,
                               :startDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}],
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :activities {:metricNames [string],
                                :filters [DimensionValue],
                                :kind string},
                   :enableAllDimensionCombinations boolean,
                   :reachByFrequencyMetricNames [string],
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :startDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:kind string,
                                                       :dimensionName string,
                                                       :matchType string,
                                                       :value string,
                                                       :etag string,
                                                       :id string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:kind string,
                                                   :dimensionName string,
                                                   :matchType string,
                                                   :value string,
                                                   :etag string,
                                                   :id string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:kind string,
                                                     :name string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule]},
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :floodlightConfigId {:kind string,
                                                  :dimensionName string,
                                                  :matchType string,
                                                  :value string,
                                                  :etag string,
                                                  :id string},
                             :pathFilters [{:eventFilters [EventFilter],
                                            :pathMatchPosition string,
                                            :kind string}],
                             :dateRange {:endDate string,
                                         :kind string,
                                         :startDate string,
                                         :relativeDateRange string},
                             :activityFilters [{:kind string,
                                                :dimensionName string,
                                                :matchType string,
                                                :value string,
                                                :etag string,
                                                :id string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:overlapMetricNames [string],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :startDate string,
                                             :relativeDateRange string},
                                 :pivoted boolean,
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :dimensionFilters [{:kind string,
                                                     :dimensionName string,
                                                     :matchType string,
                                                     :value string,
                                                     :etag string,
                                                     :id string}],
                                 :dimension string,
                                 :metricNames [string]}}
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports"
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

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/delete
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}"
     #{:reportId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/update
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:endDate string,
                                    :kind string,
                                    :startDate string,
                                    :relativeDateRange string},
                        :reportProperties {:includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean},
                        :metricNames [string],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :customRichMediaEvents [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                        :floodlightConfigId {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
                        :dimensionFilters [{:kind string,
                                            :dimensionName string,
                                            :matchType string,
                                            :value string,
                                            :etag string,
                                            :id string}]},
   :schedule {:every integer,
              :active boolean,
              :repeatsOnWeekDays [string],
              :expirationDate string,
              :startDate string,
              :repeats string,
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:metricNames [string],
                           :filters [DimensionValue],
                           :kind string},
              :metricNames [string],
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :dateRange {:endDate string,
                          :kind string,
                          :startDate string,
                          :relativeDateRange string},
              :dimensionFilters [{:kind string,
                                  :dimensionName string,
                                  :matchType string,
                                  :value string,
                                  :etag string,
                                  :id string}]},
   :delivery {:emailOwner boolean,
              :recipients [{:deliveryType string,
                            :kind string,
                            :email string}],
              :emailOwnerDeliveryType string,
              :message string},
   :type string,
   :etag string,
   :pathCriteria {:activityFilters [{:kind string,
                                     :dimensionName string,
                                     :matchType string,
                                     :value string,
                                     :etag string,
                                     :id string}],
                  :pathFilters [{:eventFilters [EventFilter],
                                 :pathMatchPosition string,
                                 :kind string}],
                  :customChannelGrouping {:kind string,
                                          :name string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule]},
                  :metricNames [string],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :dateRange {:endDate string,
                              :kind string,
                              :startDate string,
                              :relativeDateRange string},
                  :floodlightConfigId {:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}},
   :reachCriteria {:dateRange {:endDate string,
                               :kind string,
                               :startDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}],
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :activities {:metricNames [string],
                                :filters [DimensionValue],
                                :kind string},
                   :enableAllDimensionCombinations boolean,
                   :reachByFrequencyMetricNames [string],
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :startDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:kind string,
                                                       :dimensionName string,
                                                       :matchType string,
                                                       :value string,
                                                       :etag string,
                                                       :id string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:kind string,
                                                   :dimensionName string,
                                                   :matchType string,
                                                   :value string,
                                                   :etag string,
                                                   :id string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:kind string,
                                                     :name string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule]},
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :floodlightConfigId {:kind string,
                                                  :dimensionName string,
                                                  :matchType string,
                                                  :value string,
                                                  :etag string,
                                                  :id string},
                             :pathFilters [{:eventFilters [EventFilter],
                                            :pathMatchPosition string,
                                            :kind string}],
                             :dateRange {:endDate string,
                                         :kind string,
                                         :startDate string,
                                         :relativeDateRange string},
                             :activityFilters [{:kind string,
                                                :dimensionName string,
                                                :matchType string,
                                                :value string,
                                                :etag string,
                                                :id string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:overlapMetricNames [string],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :startDate string,
                                             :relativeDateRange string},
                                 :pivoted boolean,
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :dimensionFilters [{:kind string,
                                                     :dimensionName string,
                                                     :matchType string,
                                                     :value string,
                                                     :etag string,
                                                     :id string}],
                                 :dimension string,
                                 :metricNames [string]}}
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}"
     #{:reportId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/get
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}"
     #{:reportId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/patch
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:endDate string,
                                    :kind string,
                                    :startDate string,
                                    :relativeDateRange string},
                        :reportProperties {:includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean},
                        :metricNames [string],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :customRichMediaEvents [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                        :floodlightConfigId {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
                        :dimensionFilters [{:kind string,
                                            :dimensionName string,
                                            :matchType string,
                                            :value string,
                                            :etag string,
                                            :id string}]},
   :schedule {:every integer,
              :active boolean,
              :repeatsOnWeekDays [string],
              :expirationDate string,
              :startDate string,
              :repeats string,
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:metricNames [string],
                           :filters [DimensionValue],
                           :kind string},
              :metricNames [string],
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :dateRange {:endDate string,
                          :kind string,
                          :startDate string,
                          :relativeDateRange string},
              :dimensionFilters [{:kind string,
                                  :dimensionName string,
                                  :matchType string,
                                  :value string,
                                  :etag string,
                                  :id string}]},
   :delivery {:emailOwner boolean,
              :recipients [{:deliveryType string,
                            :kind string,
                            :email string}],
              :emailOwnerDeliveryType string,
              :message string},
   :type string,
   :etag string,
   :pathCriteria {:activityFilters [{:kind string,
                                     :dimensionName string,
                                     :matchType string,
                                     :value string,
                                     :etag string,
                                     :id string}],
                  :pathFilters [{:eventFilters [EventFilter],
                                 :pathMatchPosition string,
                                 :kind string}],
                  :customChannelGrouping {:kind string,
                                          :name string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule]},
                  :metricNames [string],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :dateRange {:endDate string,
                              :kind string,
                              :startDate string,
                              :relativeDateRange string},
                  :floodlightConfigId {:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}},
   :reachCriteria {:dateRange {:endDate string,
                               :kind string,
                               :startDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}],
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :activities {:metricNames [string],
                                :filters [DimensionValue],
                                :kind string},
                   :enableAllDimensionCombinations boolean,
                   :reachByFrequencyMetricNames [string],
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :startDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:kind string,
                                                       :dimensionName string,
                                                       :matchType string,
                                                       :value string,
                                                       :etag string,
                                                       :id string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:kind string,
                                                   :dimensionName string,
                                                   :matchType string,
                                                   :value string,
                                                   :etag string,
                                                   :id string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:kind string,
                                                     :name string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule]},
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :floodlightConfigId {:kind string,
                                                  :dimensionName string,
                                                  :matchType string,
                                                  :value string,
                                                  :etag string,
                                                  :id string},
                             :pathFilters [{:eventFilters [EventFilter],
                                            :pathMatchPosition string,
                                            :kind string}],
                             :dateRange {:endDate string,
                                         :kind string,
                                         :startDate string,
                                         :relativeDateRange string},
                             :activityFilters [{:kind string,
                                                :dimensionName string,
                                                :matchType string,
                                                :value string,
                                                :etag string,
                                                :id string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:overlapMetricNames [string],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :startDate string,
                                             :relativeDateRange string},
                                 :pivoted boolean,
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :dimensionFilters [{:kind string,
                                                     :dimensionName string,
                                                     :matchType string,
                                                     :value string,
                                                     :etag string,
                                                     :id string}],
                                 :dimension string,
                                 :metricNames [string]}}
  
  Updates an existing report. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}"
     #{:reportId :profileId}
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/list
  
  Required parameters: profileId
  
  Optional parameters: sortOrder, scope, pageToken, maxResults, sortField
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports"
     #{:profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn run$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/run
  
  Required parameters: profileId, reportId
  
  Optional parameters: synchronous
  
  Runs a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}/run"
     #{:reportId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn files-get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/files/get
  
  Required parameters: profileId, reportId, fileId
  
  Optional parameters: none
  
  Retrieves a report file by its report ID and file ID. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}/files/{fileId}"
     #{:reportId :profileId :fileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn files-list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/files/list
  
  Required parameters: profileId, reportId
  
  Optional parameters: maxResults, sortField, pageToken, sortOrder
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/{reportId}/files"
     #{:reportId :profileId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn compatibleFields-query$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/compatibleFields/query
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:endDate string,
                                    :kind string,
                                    :startDate string,
                                    :relativeDateRange string},
                        :reportProperties {:includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean},
                        :metricNames [string],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :customRichMediaEvents [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                        :floodlightConfigId {:kind string,
                                             :dimensionName string,
                                             :matchType string,
                                             :value string,
                                             :etag string,
                                             :id string},
                        :dimensionFilters [{:kind string,
                                            :dimensionName string,
                                            :matchType string,
                                            :value string,
                                            :etag string,
                                            :id string}]},
   :schedule {:every integer,
              :active boolean,
              :repeatsOnWeekDays [string],
              :expirationDate string,
              :startDate string,
              :repeats string,
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:metricNames [string],
                           :filters [DimensionValue],
                           :kind string},
              :metricNames [string],
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :dateRange {:endDate string,
                          :kind string,
                          :startDate string,
                          :relativeDateRange string},
              :dimensionFilters [{:kind string,
                                  :dimensionName string,
                                  :matchType string,
                                  :value string,
                                  :etag string,
                                  :id string}]},
   :delivery {:emailOwner boolean,
              :recipients [{:deliveryType string,
                            :kind string,
                            :email string}],
              :emailOwnerDeliveryType string,
              :message string},
   :type string,
   :etag string,
   :pathCriteria {:activityFilters [{:kind string,
                                     :dimensionName string,
                                     :matchType string,
                                     :value string,
                                     :etag string,
                                     :id string}],
                  :pathFilters [{:eventFilters [EventFilter],
                                 :pathMatchPosition string,
                                 :kind string}],
                  :customChannelGrouping {:kind string,
                                          :name string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule]},
                  :metricNames [string],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :dateRange {:endDate string,
                              :kind string,
                              :startDate string,
                              :relativeDateRange string},
                  :floodlightConfigId {:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}},
   :reachCriteria {:dateRange {:endDate string,
                               :kind string,
                               :startDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:kind string,
                                       :dimensionName string,
                                       :matchType string,
                                       :value string,
                                       :etag string,
                                       :id string}],
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :activities {:metricNames [string],
                                :filters [DimensionValue],
                                :kind string},
                   :enableAllDimensionCombinations boolean,
                   :reachByFrequencyMetricNames [string],
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :startDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:kind string,
                                                       :dimensionName string,
                                                       :matchType string,
                                                       :value string,
                                                       :etag string,
                                                       :id string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:kind string,
                                                 :dimensionName string,
                                                 :matchType string,
                                                 :value string,
                                                 :etag string,
                                                 :id string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:kind string,
                                                   :dimensionName string,
                                                   :matchType string,
                                                   :value string,
                                                   :etag string,
                                                   :id string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:kind string,
                                                     :name string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule]},
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :floodlightConfigId {:kind string,
                                                  :dimensionName string,
                                                  :matchType string,
                                                  :value string,
                                                  :etag string,
                                                  :id string},
                             :pathFilters [{:eventFilters [EventFilter],
                                            :pathMatchPosition string,
                                            :kind string}],
                             :dateRange {:endDate string,
                                         :kind string,
                                         :startDate string,
                                         :relativeDateRange string},
                             :activityFilters [{:kind string,
                                                :dimensionName string,
                                                :matchType string,
                                                :value string,
                                                :etag string,
                                                :id string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:overlapMetricNames [string],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :startDate string,
                                             :relativeDateRange string},
                                 :pivoted boolean,
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :dimensionFilters [{:kind string,
                                                     :dimensionName string,
                                                     :matchType string,
                                                     :value string,
                                                     :etag string,
                                                     :id string}],
                                 :dimension string,
                                 :metricNames [string]}}
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/"
     "dfareporting/v3.5/userprofiles/{profileId}/reports/compatiblefields/query"
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
