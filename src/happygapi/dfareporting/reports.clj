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
  
  {:floodlightCriteria {:floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                        :reportProperties {:includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean},
                        :metricNames [string],
                        :dateRange {:startDate string,
                                    :relativeDateRange string,
                                    :endDate string,
                                    :kind string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :kind string,
                                            :matchType string,
                                            :id string,
                                            :etag string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}]},
   :schedule {:repeats string,
              :active boolean,
              :every integer,
              :expirationDate string,
              :startDate string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :dateRange {:startDate string,
                          :relativeDateRange string,
                          :endDate string,
                          :kind string},
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :kind string,
                                  :matchType string,
                                  :id string,
                                  :etag string}]},
   :delivery {:emailOwner boolean,
              :message string,
              :emailOwnerDeliveryType string,
              :recipients [{:kind string,
                            :email string,
                            :deliveryType string}]},
   :type string,
   :etag string,
   :pathCriteria {:floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :kind string,
                                     :matchType string,
                                     :id string,
                                     :etag string}],
                  :customChannelGrouping {:kind string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule],
                                          :name string},
                  :dateRange {:startDate string,
                              :relativeDateRange string,
                              :endDate string,
                              :kind string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :pathFilters [{:pathMatchPosition string,
                                 :kind string,
                                 :eventFilters [EventFilter]}],
                  :metricNames [string]},
   :reachCriteria {:reachByFrequencyMetricNames [string],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :enableAllDimensionCombinations boolean,
                   :dateRange {:startDate string,
                               :relativeDateRange string,
                               :endDate string,
                               :kind string}},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :relativeDateRange string,
                                          :endDate string,
                                          :kind string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :kind string,
                                                       :matchType string,
                                                       :id string,
                                                       :etag string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :kind string,
                                                   :matchType string,
                                                   :id string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:activityFilters [{:dimensionName string,
                                                :value string,
                                                :kind string,
                                                :matchType string,
                                                :id string,
                                                :etag string}],
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :kind string,
                                                  :matchType string,
                                                  :id string,
                                                  :etag string},
                             :customChannelGrouping {:kind string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule],
                                                     :name string},
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:pathMatchPosition string,
                                            :kind string,
                                            :eventFilters [EventFilter]}],
                             :dateRange {:startDate string,
                                         :relativeDateRange string,
                                         :endDate string,
                                         :kind string},
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:pivoted boolean,
                                 :dateRange {:startDate string,
                                             :relativeDateRange string,
                                             :endDate string,
                                             :kind string},
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :kind string,
                                                     :matchType string,
                                                     :id string,
                                                     :etag string}],
                                 :dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :overlapMetricNames [string]}}
  
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/update
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                        :reportProperties {:includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean},
                        :metricNames [string],
                        :dateRange {:startDate string,
                                    :relativeDateRange string,
                                    :endDate string,
                                    :kind string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :kind string,
                                            :matchType string,
                                            :id string,
                                            :etag string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}]},
   :schedule {:repeats string,
              :active boolean,
              :every integer,
              :expirationDate string,
              :startDate string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :dateRange {:startDate string,
                          :relativeDateRange string,
                          :endDate string,
                          :kind string},
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :kind string,
                                  :matchType string,
                                  :id string,
                                  :etag string}]},
   :delivery {:emailOwner boolean,
              :message string,
              :emailOwnerDeliveryType string,
              :recipients [{:kind string,
                            :email string,
                            :deliveryType string}]},
   :type string,
   :etag string,
   :pathCriteria {:floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :kind string,
                                     :matchType string,
                                     :id string,
                                     :etag string}],
                  :customChannelGrouping {:kind string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule],
                                          :name string},
                  :dateRange {:startDate string,
                              :relativeDateRange string,
                              :endDate string,
                              :kind string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :pathFilters [{:pathMatchPosition string,
                                 :kind string,
                                 :eventFilters [EventFilter]}],
                  :metricNames [string]},
   :reachCriteria {:reachByFrequencyMetricNames [string],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :enableAllDimensionCombinations boolean,
                   :dateRange {:startDate string,
                               :relativeDateRange string,
                               :endDate string,
                               :kind string}},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :relativeDateRange string,
                                          :endDate string,
                                          :kind string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :kind string,
                                                       :matchType string,
                                                       :id string,
                                                       :etag string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :kind string,
                                                   :matchType string,
                                                   :id string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:activityFilters [{:dimensionName string,
                                                :value string,
                                                :kind string,
                                                :matchType string,
                                                :id string,
                                                :etag string}],
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :kind string,
                                                  :matchType string,
                                                  :id string,
                                                  :etag string},
                             :customChannelGrouping {:kind string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule],
                                                     :name string},
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:pathMatchPosition string,
                                            :kind string,
                                            :eventFilters [EventFilter]}],
                             :dateRange {:startDate string,
                                         :relativeDateRange string,
                                         :endDate string,
                                         :kind string},
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:pivoted boolean,
                                 :dateRange {:startDate string,
                                             :relativeDateRange string,
                                             :endDate string,
                                             :kind string},
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :kind string,
                                                     :matchType string,
                                                     :id string,
                                                     :etag string}],
                                 :dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :overlapMetricNames [string]}}
  
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

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/delete
  
  Required parameters: reportId, profileId
  
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/list
  
  Required parameters: profileId
  
  Optional parameters: pageToken, scope, sortField, maxResults, sortOrder
  
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/patch
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                        :reportProperties {:includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean},
                        :metricNames [string],
                        :dateRange {:startDate string,
                                    :relativeDateRange string,
                                    :endDate string,
                                    :kind string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :kind string,
                                            :matchType string,
                                            :id string,
                                            :etag string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}]},
   :schedule {:repeats string,
              :active boolean,
              :every integer,
              :expirationDate string,
              :startDate string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :dateRange {:startDate string,
                          :relativeDateRange string,
                          :endDate string,
                          :kind string},
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :kind string,
                                  :matchType string,
                                  :id string,
                                  :etag string}]},
   :delivery {:emailOwner boolean,
              :message string,
              :emailOwnerDeliveryType string,
              :recipients [{:kind string,
                            :email string,
                            :deliveryType string}]},
   :type string,
   :etag string,
   :pathCriteria {:floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :kind string,
                                     :matchType string,
                                     :id string,
                                     :etag string}],
                  :customChannelGrouping {:kind string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule],
                                          :name string},
                  :dateRange {:startDate string,
                              :relativeDateRange string,
                              :endDate string,
                              :kind string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :pathFilters [{:pathMatchPosition string,
                                 :kind string,
                                 :eventFilters [EventFilter]}],
                  :metricNames [string]},
   :reachCriteria {:reachByFrequencyMetricNames [string],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :enableAllDimensionCombinations boolean,
                   :dateRange {:startDate string,
                               :relativeDateRange string,
                               :endDate string,
                               :kind string}},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :relativeDateRange string,
                                          :endDate string,
                                          :kind string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :kind string,
                                                       :matchType string,
                                                       :id string,
                                                       :etag string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :kind string,
                                                   :matchType string,
                                                   :id string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:activityFilters [{:dimensionName string,
                                                :value string,
                                                :kind string,
                                                :matchType string,
                                                :id string,
                                                :etag string}],
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :kind string,
                                                  :matchType string,
                                                  :id string,
                                                  :etag string},
                             :customChannelGrouping {:kind string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule],
                                                     :name string},
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:pathMatchPosition string,
                                            :kind string,
                                            :eventFilters [EventFilter]}],
                             :dateRange {:startDate string,
                                         :relativeDateRange string,
                                         :endDate string,
                                         :kind string},
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:pivoted boolean,
                                 :dateRange {:startDate string,
                                             :relativeDateRange string,
                                             :endDate string,
                                             :kind string},
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :kind string,
                                                     :matchType string,
                                                     :id string,
                                                     :etag string}],
                                 :dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :overlapMetricNames [string]}}
  
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

(defn files-list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/files/list
  
  Required parameters: reportId, profileId
  
  Optional parameters: maxResults, sortOrder, pageToken, sortField
  
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

(defn files-get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/files/get
  
  Required parameters: fileId, reportId, profileId
  
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

(defn compatibleFields-query$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.5/reports/compatibleFields/query
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :kind string,
                                             :matchType string,
                                             :id string,
                                             :etag string},
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                        :reportProperties {:includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeAttributedIPConversions boolean},
                        :metricNames [string],
                        :dateRange {:startDate string,
                                    :relativeDateRange string,
                                    :endDate string,
                                    :kind string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :kind string,
                                            :matchType string,
                                            :id string,
                                            :etag string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}]},
   :schedule {:repeats string,
              :active boolean,
              :every integer,
              :expirationDate string,
              :startDate string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :dateRange {:startDate string,
                          :relativeDateRange string,
                          :endDate string,
                          :kind string},
              :customRichMediaEvents {:kind string,
                                      :filteredEventIds [DimensionValue]},
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :kind string,
                                  :matchType string,
                                  :id string,
                                  :etag string}]},
   :delivery {:emailOwner boolean,
              :message string,
              :emailOwnerDeliveryType string,
              :recipients [{:kind string,
                            :email string,
                            :deliveryType string}]},
   :type string,
   :etag string,
   :pathCriteria {:floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :kind string,
                                     :matchType string,
                                     :id string,
                                     :etag string}],
                  :customChannelGrouping {:kind string,
                                          :fallbackName string,
                                          :rules [ChannelGroupingRule],
                                          :name string},
                  :dateRange {:startDate string,
                              :relativeDateRange string,
                              :endDate string,
                              :kind string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :pathFilters [{:pathMatchPosition string,
                                 :kind string,
                                 :eventFilters [EventFilter]}],
                  :metricNames [string]},
   :reachCriteria {:reachByFrequencyMetricNames [string],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :kind string,
                                       :matchType string,
                                       :id string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :customRichMediaEvents {:kind string,
                                           :filteredEventIds [DimensionValue]},
                   :enableAllDimensionCombinations boolean,
                   :dateRange {:startDate string,
                               :relativeDateRange string,
                               :endDate string,
                               :kind string}},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :relativeDateRange string,
                                          :endDate string,
                                          :kind string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :kind string,
                                                       :matchType string,
                                                       :id string,
                                                       :etag string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:dimensionName string,
                                                 :value string,
                                                 :kind string,
                                                 :matchType string,
                                                 :id string,
                                                 :etag string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :kind string,
                                                   :matchType string,
                                                   :id string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:activityFilters [{:dimensionName string,
                                                :value string,
                                                :kind string,
                                                :matchType string,
                                                :id string,
                                                :etag string}],
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :kind string,
                                                  :matchType string,
                                                  :id string,
                                                  :etag string},
                             :customChannelGrouping {:kind string,
                                                     :fallbackName string,
                                                     :rules [ChannelGroupingRule],
                                                     :name string},
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:pathMatchPosition string,
                                            :kind string,
                                            :eventFilters [EventFilter]}],
                             :dateRange {:startDate string,
                                         :relativeDateRange string,
                                         :endDate string,
                                         :kind string},
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:pivoted boolean,
                                 :dateRange {:startDate string,
                                             :relativeDateRange string,
                                             :endDate string,
                                             :kind string},
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :kind string,
                                                     :matchType string,
                                                     :id string,
                                                     :etag string}],
                                 :dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :overlapMetricNames [string]}}
  
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
