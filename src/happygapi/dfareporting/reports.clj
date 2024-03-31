(ns happygapi.dfareporting.reports
  "Campaign Manager 360 API: reports.
  Build applications to efficiently manage large or complex trafficking, reporting, and attribution workflows for Campaign Manager 360.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/delete
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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

(defn get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/get
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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

(defn insert$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:startDate string,
                                    :endDate string,
                                    :relativeDateRange string,
                                    :kind string},
                        :floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :id string,
                                            :matchType string,
                                            :kind string,
                                            :etag string}],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :metricNames [string],
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :repeats string,
              :repeatsOnWeekDays [string],
              :every integer,
              :startDate string,
              :expirationDate string,
              :runsOnDayOfMonth string,
              :timezone string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:dateRange {:startDate string,
                          :endDate string,
                          :relativeDateRange string,
                          :kind string},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :metricNames [string],
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :id string,
                                  :matchType string,
                                  :kind string,
                                  :etag string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string}},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:email string,
                            :deliveryType string,
                            :kind string}]},
   :type string,
   :etag string,
   :pathCriteria {:dateRange {:startDate string,
                              :endDate string,
                              :relativeDateRange string,
                              :kind string},
                  :floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :id string,
                                     :matchType string,
                                     :kind string,
                                     :etag string}],
                  :customChannelGrouping {:name string,
                                          :rules [ChannelGroupingRule],
                                          :fallbackName string,
                                          :kind string},
                  :pathFilters [{:kind string,
                                 :pathMatchPosition string,
                                 :eventFilters [EventFilter]}],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :metricNames [string]},
   :reachCriteria {:dateRange {:startDate string,
                               :endDate string,
                               :relativeDateRange string,
                               :kind string},
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :reachByFrequencyMetricNames [string],
                   :enableAllDimensionCombinations boolean},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :endDate string,
                                          :relativeDateRange string,
                                          :kind string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :id string,
                                                       :matchType string,
                                                       :kind string,
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
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :id string,
                                                   :matchType string,
                                                   :kind string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:dateRange {:startDate string,
                                         :endDate string,
                                         :relativeDateRange string,
                                         :kind string},
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :id string,
                                                  :matchType string,
                                                  :kind string,
                                                  :etag string},
                             :activityFilters [{:dimensionName string,
                                                :value string,
                                                :id string,
                                                :matchType string,
                                                :kind string,
                                                :etag string}],
                             :customChannelGrouping {:name string,
                                                     :rules [ChannelGroupingRule],
                                                     :fallbackName string,
                                                     :kind string},
                             :pathFilters [{:kind string,
                                            :pathMatchPosition string,
                                            :eventFilters [EventFilter]}],
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dateRange {:startDate string,
                                             :endDate string,
                                             :relativeDateRange string,
                                             :kind string},
                                 :dimension string,
                                 :pivoted boolean,
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :id string,
                                                     :matchType string,
                                                     :kind string,
                                                     :etag string}],
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string]}}
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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

(defn list$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/list
  
  Required parameters: profileId
  
  Optional parameters: maxResults, pageToken, scope, sortField, sortOrder
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/run
  
  Required parameters: profileId, reportId
  
  Optional parameters: synchronous
  
  Runs a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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

(defn update$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/update
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:startDate string,
                                    :endDate string,
                                    :relativeDateRange string,
                                    :kind string},
                        :floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :id string,
                                            :matchType string,
                                            :kind string,
                                            :etag string}],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :metricNames [string],
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :repeats string,
              :repeatsOnWeekDays [string],
              :every integer,
              :startDate string,
              :expirationDate string,
              :runsOnDayOfMonth string,
              :timezone string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:dateRange {:startDate string,
                          :endDate string,
                          :relativeDateRange string,
                          :kind string},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :metricNames [string],
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :id string,
                                  :matchType string,
                                  :kind string,
                                  :etag string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string}},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:email string,
                            :deliveryType string,
                            :kind string}]},
   :type string,
   :etag string,
   :pathCriteria {:dateRange {:startDate string,
                              :endDate string,
                              :relativeDateRange string,
                              :kind string},
                  :floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :id string,
                                     :matchType string,
                                     :kind string,
                                     :etag string}],
                  :customChannelGrouping {:name string,
                                          :rules [ChannelGroupingRule],
                                          :fallbackName string,
                                          :kind string},
                  :pathFilters [{:kind string,
                                 :pathMatchPosition string,
                                 :eventFilters [EventFilter]}],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :metricNames [string]},
   :reachCriteria {:dateRange {:startDate string,
                               :endDate string,
                               :relativeDateRange string,
                               :kind string},
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :reachByFrequencyMetricNames [string],
                   :enableAllDimensionCombinations boolean},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :endDate string,
                                          :relativeDateRange string,
                                          :kind string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :id string,
                                                       :matchType string,
                                                       :kind string,
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
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :id string,
                                                   :matchType string,
                                                   :kind string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:dateRange {:startDate string,
                                         :endDate string,
                                         :relativeDateRange string,
                                         :kind string},
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :id string,
                                                  :matchType string,
                                                  :kind string,
                                                  :etag string},
                             :activityFilters [{:dimensionName string,
                                                :value string,
                                                :id string,
                                                :matchType string,
                                                :kind string,
                                                :etag string}],
                             :customChannelGrouping {:name string,
                                                     :rules [ChannelGroupingRule],
                                                     :fallbackName string,
                                                     :kind string},
                             :pathFilters [{:kind string,
                                            :pathMatchPosition string,
                                            :eventFilters [EventFilter]}],
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dateRange {:startDate string,
                                             :endDate string,
                                             :relativeDateRange string,
                                             :kind string},
                                 :dimension string,
                                 :pivoted boolean,
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :id string,
                                                     :matchType string,
                                                     :kind string,
                                                     :etag string}],
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string]}}
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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

(defn patch$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/patch
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:startDate string,
                                    :endDate string,
                                    :relativeDateRange string,
                                    :kind string},
                        :floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :id string,
                                            :matchType string,
                                            :kind string,
                                            :etag string}],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :metricNames [string],
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :repeats string,
              :repeatsOnWeekDays [string],
              :every integer,
              :startDate string,
              :expirationDate string,
              :runsOnDayOfMonth string,
              :timezone string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:dateRange {:startDate string,
                          :endDate string,
                          :relativeDateRange string,
                          :kind string},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :metricNames [string],
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :id string,
                                  :matchType string,
                                  :kind string,
                                  :etag string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string}},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:email string,
                            :deliveryType string,
                            :kind string}]},
   :type string,
   :etag string,
   :pathCriteria {:dateRange {:startDate string,
                              :endDate string,
                              :relativeDateRange string,
                              :kind string},
                  :floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :id string,
                                     :matchType string,
                                     :kind string,
                                     :etag string}],
                  :customChannelGrouping {:name string,
                                          :rules [ChannelGroupingRule],
                                          :fallbackName string,
                                          :kind string},
                  :pathFilters [{:kind string,
                                 :pathMatchPosition string,
                                 :eventFilters [EventFilter]}],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :metricNames [string]},
   :reachCriteria {:dateRange {:startDate string,
                               :endDate string,
                               :relativeDateRange string,
                               :kind string},
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :reachByFrequencyMetricNames [string],
                   :enableAllDimensionCombinations boolean},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :endDate string,
                                          :relativeDateRange string,
                                          :kind string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :id string,
                                                       :matchType string,
                                                       :kind string,
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
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :id string,
                                                   :matchType string,
                                                   :kind string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:dateRange {:startDate string,
                                         :endDate string,
                                         :relativeDateRange string,
                                         :kind string},
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :id string,
                                                  :matchType string,
                                                  :kind string,
                                                  :etag string},
                             :activityFilters [{:dimensionName string,
                                                :value string,
                                                :id string,
                                                :matchType string,
                                                :kind string,
                                                :etag string}],
                             :customChannelGrouping {:name string,
                                                     :rules [ChannelGroupingRule],
                                                     :fallbackName string,
                                                     :kind string},
                             :pathFilters [{:kind string,
                                            :pathMatchPosition string,
                                            :eventFilters [EventFilter]}],
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dateRange {:startDate string,
                                             :endDate string,
                                             :relativeDateRange string,
                                             :kind string},
                                 :dimension string,
                                 :pivoted boolean,
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :id string,
                                                     :matchType string,
                                                     :kind string,
                                                     :etag string}],
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string]}}
  
  Updates an existing report. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/files/get
  
  Required parameters: profileId, reportId, fileId
  
  Optional parameters: none
  
  Retrieves a report file by its report ID and file ID. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/files/list
  
  Required parameters: profileId, reportId
  
  Optional parameters: sortField, sortOrder, maxResults, pageToken
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v4/reports/compatibleFields/query
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:dateRange {:startDate string,
                                    :endDate string,
                                    :relativeDateRange string,
                                    :kind string},
                        :floodlightConfigId {:dimensionName string,
                                             :value string,
                                             :id string,
                                             :matchType string,
                                             :kind string,
                                             :etag string},
                        :dimensionFilters [{:dimensionName string,
                                            :value string,
                                            :id string,
                                            :matchType string,
                                            :kind string,
                                            :etag string}],
                        :dimensions [{:name string,
                                      :sortOrder string,
                                      :kind string}],
                        :metricNames [string],
                        :customRichMediaEvents [{:dimensionName string,
                                                 :value string,
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :repeats string,
              :repeatsOnWeekDays [string],
              :every integer,
              :startDate string,
              :expirationDate string,
              :runsOnDayOfMonth string,
              :timezone string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:dateRange {:startDate string,
                          :endDate string,
                          :relativeDateRange string,
                          :kind string},
              :dimensions [{:name string,
                            :sortOrder string,
                            :kind string}],
              :metricNames [string],
              :dimensionFilters [{:dimensionName string,
                                  :value string,
                                  :id string,
                                  :matchType string,
                                  :kind string,
                                  :etag string}],
              :activities {:filters [DimensionValue],
                           :metricNames [string],
                           :kind string},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string}},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:email string,
                            :deliveryType string,
                            :kind string}]},
   :type string,
   :etag string,
   :pathCriteria {:dateRange {:startDate string,
                              :endDate string,
                              :relativeDateRange string,
                              :kind string},
                  :floodlightConfigId {:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string},
                  :activityFilters [{:dimensionName string,
                                     :value string,
                                     :id string,
                                     :matchType string,
                                     :kind string,
                                     :etag string}],
                  :customChannelGrouping {:name string,
                                          :rules [ChannelGroupingRule],
                                          :fallbackName string,
                                          :kind string},
                  :pathFilters [{:kind string,
                                 :pathMatchPosition string,
                                 :eventFilters [EventFilter]}],
                  :dimensions [{:name string,
                                :sortOrder string,
                                :kind string}],
                  :metricNames [string]},
   :reachCriteria {:dateRange {:startDate string,
                               :endDate string,
                               :relativeDateRange string,
                               :kind string},
                   :dimensions [{:name string,
                                 :sortOrder string,
                                 :kind string}],
                   :metricNames [string],
                   :dimensionFilters [{:dimensionName string,
                                       :value string,
                                       :id string,
                                       :matchType string,
                                       :kind string,
                                       :etag string}],
                   :activities {:filters [DimensionValue],
                                :metricNames [string],
                                :kind string},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :reachByFrequencyMetricNames [string],
                   :enableAllDimensionCombinations boolean},
   :pathToConversionCriteria {:dateRange {:startDate string,
                                          :endDate string,
                                          :relativeDateRange string,
                                          :kind string},
                              :conversionDimensions [{:name string,
                                                      :sortOrder string,
                                                      :kind string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :value string,
                                                       :id string,
                                                       :matchType string,
                                                       :kind string,
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
                                                 :id string,
                                                 :matchType string,
                                                 :kind string,
                                                 :etag string}],
                              :customFloodlightVariables [{:name string,
                                                           :sortOrder string,
                                                           :kind string}],
                              :perInteractionDimensions [{:name string,
                                                          :sortOrder string,
                                                          :kind string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :value string,
                                                   :id string,
                                                   :matchType string,
                                                   :kind string,
                                                   :etag string}},
   :lastModifiedTime string,
   :id string,
   :pathAttributionCriteria {:dateRange {:startDate string,
                                         :endDate string,
                                         :relativeDateRange string,
                                         :kind string},
                             :floodlightConfigId {:dimensionName string,
                                                  :value string,
                                                  :id string,
                                                  :matchType string,
                                                  :kind string,
                                                  :etag string},
                             :activityFilters [{:dimensionName string,
                                                :value string,
                                                :id string,
                                                :matchType string,
                                                :kind string,
                                                :etag string}],
                             :customChannelGrouping {:name string,
                                                     :rules [ChannelGroupingRule],
                                                     :fallbackName string,
                                                     :kind string},
                             :pathFilters [{:kind string,
                                            :pathMatchPosition string,
                                            :eventFilters [EventFilter]}],
                             :dimensions [{:name string,
                                           :sortOrder string,
                                           :kind string}],
                             :metricNames [string]},
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:dateRange {:startDate string,
                                             :endDate string,
                                             :relativeDateRange string,
                                             :kind string},
                                 :dimension string,
                                 :pivoted boolean,
                                 :dimensionFilters [{:dimensionName string,
                                                     :value string,
                                                     :id string,
                                                     :matchType string,
                                                     :kind string,
                                                     :etag string}],
                                 :breakdown [{:name string,
                                              :sortOrder string,
                                              :kind string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string]}}
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://dfareporting.googleapis.com/dfareporting/v4/"
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
