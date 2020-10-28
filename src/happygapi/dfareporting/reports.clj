(ns happygapi.dfareporting.reports
  "DCM/DFA Reporting And Trafficking API: reports.
  Manage your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/get
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/list
  
  Required parameters: profileId
  
  Optional parameters: scope, sortField, pageToken, maxResults, sortOrder
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/run
  
  Required parameters: profileId, reportId
  
  Optional parameters: synchronous
  
  Runs a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/run"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/delete
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/patch
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:metricNames [string],
                        :floodlightConfigId {:etag string,
                                             :value string,
                                             :id string,
                                             :kind string,
                                             :dimensionName string,
                                             :matchType string},
                        :dimensionFilters [{:etag string,
                                            :value string,
                                            :id string,
                                            :kind string,
                                            :dimensionName string,
                                            :matchType string}],
                        :dateRange {:startDate string,
                                    :kind string,
                                    :endDate string,
                                    :relativeDateRange string},
                        :customRichMediaEvents [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean}},
   :schedule {:runsOnDayOfMonth string,
              :active boolean,
              :startDate string,
              :repeats string,
              :expirationDate string,
              :repeatsOnWeekDays [string],
              :every integer},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :dateRange {:startDate string,
                          :kind string,
                          :endDate string,
                          :relativeDateRange string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dimensionFilters [{:etag string,
                                  :value string,
                                  :id string,
                                  :kind string,
                                  :dimensionName string,
                                  :matchType string}],
              :activities {:kind string,
                           :filters [DimensionValue],
                           :metricNames [string]}},
   :delivery {:recipients [{:kind string,
                            :deliveryType string,
                            :email string}],
              :message string,
              :emailOwner boolean,
              :emailOwnerDeliveryType string},
   :type string,
   :etag string,
   :pathCriteria {:metricNames [string],
                  :activityFilters [{:etag string,
                                     :value string,
                                     :id string,
                                     :kind string,
                                     :dimensionName string,
                                     :matchType string}],
                  :floodlightConfigId {:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :dateRange {:startDate string,
                              :kind string,
                              :endDate string,
                              :relativeDateRange string},
                  :customChannelGrouping {:fallbackName string,
                                          :name string,
                                          :kind string,
                                          :rules [ChannelGroupingRule]},
                  :pathFilters [{:eventFilters [EventFilter],
                                 :kind string,
                                 :pathMatchPosition string}]},
   :reachCriteria {:enableAllDimensionCombinations boolean,
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :activities {:kind string,
                                :filters [DimensionValue],
                                :metricNames [string]},
                   :dateRange {:startDate string,
                               :kind string,
                               :endDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string}],
                   :reachByFrequencyMetricNames [string],
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :kind string,
                                          :endDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:etag string,
                                                       :value string,
                                                       :id string,
                                                       :kind string,
                                                       :dimensionName string,
                                                       :matchType string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:etag string,
                                                   :value string,
                                                   :id string,
                                                   :kind string,
                                                   :dimensionName string,
                                                   :matchType string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:fallbackName string,
                                                     :name string,
                                                     :kind string,
                                                     :rules [ChannelGroupingRule]},
                             :metricNames [string],
                             :activityFilters [{:etag string,
                                                :value string,
                                                :id string,
                                                :kind string,
                                                :dimensionName string,
                                                :matchType string}],
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:eventFilters [EventFilter],
                                            :kind string,
                                            :pathMatchPosition string}],
                             :dateRange {:startDate string,
                                         :kind string,
                                         :endDate string,
                                         :relativeDateRange string},
                             :floodlightConfigId {:etag string,
                                                  :value string,
                                                  :id string,
                                                  :kind string,
                                                  :dimensionName string,
                                                  :matchType string}},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dimensionFilters [{:etag string,
                                                     :value string,
                                                     :id string,
                                                     :kind string,
                                                     :dimensionName string,
                                                     :matchType string}],
                                 :overlapMetricNames [string],
                                 :pivoted boolean,
                                 :dateRange {:startDate string,
                                             :kind string,
                                             :endDate string,
                                             :relativeDateRange string}}}
  
  Updates an existing report. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:metricNames [string],
                        :floodlightConfigId {:etag string,
                                             :value string,
                                             :id string,
                                             :kind string,
                                             :dimensionName string,
                                             :matchType string},
                        :dimensionFilters [{:etag string,
                                            :value string,
                                            :id string,
                                            :kind string,
                                            :dimensionName string,
                                            :matchType string}],
                        :dateRange {:startDate string,
                                    :kind string,
                                    :endDate string,
                                    :relativeDateRange string},
                        :customRichMediaEvents [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean}},
   :schedule {:runsOnDayOfMonth string,
              :active boolean,
              :startDate string,
              :repeats string,
              :expirationDate string,
              :repeatsOnWeekDays [string],
              :every integer},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :dateRange {:startDate string,
                          :kind string,
                          :endDate string,
                          :relativeDateRange string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dimensionFilters [{:etag string,
                                  :value string,
                                  :id string,
                                  :kind string,
                                  :dimensionName string,
                                  :matchType string}],
              :activities {:kind string,
                           :filters [DimensionValue],
                           :metricNames [string]}},
   :delivery {:recipients [{:kind string,
                            :deliveryType string,
                            :email string}],
              :message string,
              :emailOwner boolean,
              :emailOwnerDeliveryType string},
   :type string,
   :etag string,
   :pathCriteria {:metricNames [string],
                  :activityFilters [{:etag string,
                                     :value string,
                                     :id string,
                                     :kind string,
                                     :dimensionName string,
                                     :matchType string}],
                  :floodlightConfigId {:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :dateRange {:startDate string,
                              :kind string,
                              :endDate string,
                              :relativeDateRange string},
                  :customChannelGrouping {:fallbackName string,
                                          :name string,
                                          :kind string,
                                          :rules [ChannelGroupingRule]},
                  :pathFilters [{:eventFilters [EventFilter],
                                 :kind string,
                                 :pathMatchPosition string}]},
   :reachCriteria {:enableAllDimensionCombinations boolean,
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :activities {:kind string,
                                :filters [DimensionValue],
                                :metricNames [string]},
                   :dateRange {:startDate string,
                               :kind string,
                               :endDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string}],
                   :reachByFrequencyMetricNames [string],
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :kind string,
                                          :endDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:etag string,
                                                       :value string,
                                                       :id string,
                                                       :kind string,
                                                       :dimensionName string,
                                                       :matchType string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:etag string,
                                                   :value string,
                                                   :id string,
                                                   :kind string,
                                                   :dimensionName string,
                                                   :matchType string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:fallbackName string,
                                                     :name string,
                                                     :kind string,
                                                     :rules [ChannelGroupingRule]},
                             :metricNames [string],
                             :activityFilters [{:etag string,
                                                :value string,
                                                :id string,
                                                :kind string,
                                                :dimensionName string,
                                                :matchType string}],
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:eventFilters [EventFilter],
                                            :kind string,
                                            :pathMatchPosition string}],
                             :dateRange {:startDate string,
                                         :kind string,
                                         :endDate string,
                                         :relativeDateRange string},
                             :floodlightConfigId {:etag string,
                                                  :value string,
                                                  :id string,
                                                  :kind string,
                                                  :dimensionName string,
                                                  :matchType string}},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dimensionFilters [{:etag string,
                                                     :value string,
                                                     :id string,
                                                     :kind string,
                                                     :dimensionName string,
                                                     :matchType string}],
                                 :overlapMetricNames [string],
                                 :pivoted boolean,
                                 :dateRange {:startDate string,
                                             :kind string,
                                             :endDate string,
                                             :relativeDateRange string}}}
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/update
  
  Required parameters: reportId, profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:metricNames [string],
                        :floodlightConfigId {:etag string,
                                             :value string,
                                             :id string,
                                             :kind string,
                                             :dimensionName string,
                                             :matchType string},
                        :dimensionFilters [{:etag string,
                                            :value string,
                                            :id string,
                                            :kind string,
                                            :dimensionName string,
                                            :matchType string}],
                        :dateRange {:startDate string,
                                    :kind string,
                                    :endDate string,
                                    :relativeDateRange string},
                        :customRichMediaEvents [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean}},
   :schedule {:runsOnDayOfMonth string,
              :active boolean,
              :startDate string,
              :repeats string,
              :expirationDate string,
              :repeatsOnWeekDays [string],
              :every integer},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :dateRange {:startDate string,
                          :kind string,
                          :endDate string,
                          :relativeDateRange string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dimensionFilters [{:etag string,
                                  :value string,
                                  :id string,
                                  :kind string,
                                  :dimensionName string,
                                  :matchType string}],
              :activities {:kind string,
                           :filters [DimensionValue],
                           :metricNames [string]}},
   :delivery {:recipients [{:kind string,
                            :deliveryType string,
                            :email string}],
              :message string,
              :emailOwner boolean,
              :emailOwnerDeliveryType string},
   :type string,
   :etag string,
   :pathCriteria {:metricNames [string],
                  :activityFilters [{:etag string,
                                     :value string,
                                     :id string,
                                     :kind string,
                                     :dimensionName string,
                                     :matchType string}],
                  :floodlightConfigId {:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :dateRange {:startDate string,
                              :kind string,
                              :endDate string,
                              :relativeDateRange string},
                  :customChannelGrouping {:fallbackName string,
                                          :name string,
                                          :kind string,
                                          :rules [ChannelGroupingRule]},
                  :pathFilters [{:eventFilters [EventFilter],
                                 :kind string,
                                 :pathMatchPosition string}]},
   :reachCriteria {:enableAllDimensionCombinations boolean,
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :activities {:kind string,
                                :filters [DimensionValue],
                                :metricNames [string]},
                   :dateRange {:startDate string,
                               :kind string,
                               :endDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string}],
                   :reachByFrequencyMetricNames [string],
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :kind string,
                                          :endDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:etag string,
                                                       :value string,
                                                       :id string,
                                                       :kind string,
                                                       :dimensionName string,
                                                       :matchType string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:etag string,
                                                   :value string,
                                                   :id string,
                                                   :kind string,
                                                   :dimensionName string,
                                                   :matchType string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:fallbackName string,
                                                     :name string,
                                                     :kind string,
                                                     :rules [ChannelGroupingRule]},
                             :metricNames [string],
                             :activityFilters [{:etag string,
                                                :value string,
                                                :id string,
                                                :kind string,
                                                :dimensionName string,
                                                :matchType string}],
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:eventFilters [EventFilter],
                                            :kind string,
                                            :pathMatchPosition string}],
                             :dateRange {:startDate string,
                                         :kind string,
                                         :endDate string,
                                         :relativeDateRange string},
                             :floodlightConfigId {:etag string,
                                                  :value string,
                                                  :id string,
                                                  :kind string,
                                                  :dimensionName string,
                                                  :matchType string}},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dimensionFilters [{:etag string,
                                                     :value string,
                                                     :id string,
                                                     :kind string,
                                                     :dimensionName string,
                                                     :matchType string}],
                                 :overlapMetricNames [string],
                                 :pivoted boolean,
                                 :dateRange {:startDate string,
                                             :kind string,
                                             :endDate string,
                                             :relativeDateRange string}}}
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}"
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

(defn files-get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/files/get
  
  Required parameters: profileId, reportId, fileId
  
  Optional parameters: none
  
  Retrieves a report file by its report ID and file ID. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/files/{fileId}"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/files/list
  
  Required parameters: profileId, reportId
  
  Optional parameters: pageToken, sortField, sortOrder, maxResults
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/{reportId}/files"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/compatibleFields/query
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:metricNames [string],
                        :floodlightConfigId {:etag string,
                                             :value string,
                                             :id string,
                                             :kind string,
                                             :dimensionName string,
                                             :matchType string},
                        :dimensionFilters [{:etag string,
                                            :value string,
                                            :id string,
                                            :kind string,
                                            :dimensionName string,
                                            :matchType string}],
                        :dateRange {:startDate string,
                                    :kind string,
                                    :endDate string,
                                    :relativeDateRange string},
                        :customRichMediaEvents [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean}},
   :schedule {:runsOnDayOfMonth string,
              :active boolean,
              :startDate string,
              :repeats string,
              :expirationDate string,
              :repeatsOnWeekDays [string],
              :every integer},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:metricNames [string],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :dateRange {:startDate string,
                          :kind string,
                          :endDate string,
                          :relativeDateRange string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dimensionFilters [{:etag string,
                                  :value string,
                                  :id string,
                                  :kind string,
                                  :dimensionName string,
                                  :matchType string}],
              :activities {:kind string,
                           :filters [DimensionValue],
                           :metricNames [string]}},
   :delivery {:recipients [{:kind string,
                            :deliveryType string,
                            :email string}],
              :message string,
              :emailOwner boolean,
              :emailOwnerDeliveryType string},
   :type string,
   :etag string,
   :pathCriteria {:metricNames [string],
                  :activityFilters [{:etag string,
                                     :value string,
                                     :id string,
                                     :kind string,
                                     :dimensionName string,
                                     :matchType string}],
                  :floodlightConfigId {:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string},
                  :dimensions [{:kind string,
                                :name string,
                                :sortOrder string}],
                  :dateRange {:startDate string,
                              :kind string,
                              :endDate string,
                              :relativeDateRange string},
                  :customChannelGrouping {:fallbackName string,
                                          :name string,
                                          :kind string,
                                          :rules [ChannelGroupingRule]},
                  :pathFilters [{:eventFilters [EventFilter],
                                 :kind string,
                                 :pathMatchPosition string}]},
   :reachCriteria {:enableAllDimensionCombinations boolean,
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :activities {:kind string,
                                :filters [DimensionValue],
                                :metricNames [string]},
                   :dateRange {:startDate string,
                               :kind string,
                               :endDate string,
                               :relativeDateRange string},
                   :dimensionFilters [{:etag string,
                                       :value string,
                                       :id string,
                                       :kind string,
                                       :dimensionName string,
                                       :matchType string}],
                   :reachByFrequencyMetricNames [string],
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :metricNames [string]},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :kind string,
                                          :endDate string,
                                          :relativeDateRange string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:etag string,
                                                       :value string,
                                                       :id string,
                                                       :kind string,
                                                       :dimensionName string,
                                                       :matchType string}],
                              :reportProperties {:maximumInteractionGap integer,
                                                 :includeAttributedIPConversions boolean,
                                                 :includeUnattributedIPConversions boolean,
                                                 :clicksLookbackWindow integer,
                                                 :includeUnattributedCookieConversions boolean,
                                                 :impressionsLookbackWindow integer,
                                                 :maximumClickInteractions integer,
                                                 :pivotOnInteractionPath boolean,
                                                 :maximumImpressionInteractions integer},
                              :activityFilters [{:etag string,
                                                 :value string,
                                                 :id string,
                                                 :kind string,
                                                 :dimensionName string,
                                                 :matchType string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:etag string,
                                                   :value string,
                                                   :id string,
                                                   :kind string,
                                                   :dimensionName string,
                                                   :matchType string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:customChannelGrouping {:fallbackName string,
                                                     :name string,
                                                     :kind string,
                                                     :rules [ChannelGroupingRule]},
                             :metricNames [string],
                             :activityFilters [{:etag string,
                                                :value string,
                                                :id string,
                                                :kind string,
                                                :dimensionName string,
                                                :matchType string}],
                             :dimensions [{:kind string,
                                           :name string,
                                           :sortOrder string}],
                             :pathFilters [{:eventFilters [EventFilter],
                                            :kind string,
                                            :pathMatchPosition string}],
                             :dateRange {:startDate string,
                                         :kind string,
                                         :endDate string,
                                         :relativeDateRange string},
                             :floodlightConfigId {:etag string,
                                                  :value string,
                                                  :id string,
                                                  :kind string,
                                                  :dimensionName string,
                                                  :matchType string}},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dimension string,
                                 :metricNames [string],
                                 :breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dimensionFilters [{:etag string,
                                                     :value string,
                                                     :id string,
                                                     :kind string,
                                                     :dimensionName string,
                                                     :matchType string}],
                                 :overlapMetricNames [string],
                                 :pivoted boolean,
                                 :dateRange {:startDate string,
                                             :kind string,
                                             :endDate string,
                                             :relativeDateRange string}}}
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v3.4/"
     "userprofiles/{profileId}/reports/compatiblefields/query"
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
