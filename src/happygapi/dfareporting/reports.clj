(ns happygapi.dfareporting.reports
  "DCM/DFA Reporting And Trafficking API: reports.
  Manages your DoubleClick Campaign Manager ad campaigns and reports.
  See: https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/delete
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Deletes a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/get
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Retrieves a report by its ID."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/insert
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:customRichMediaEvents [{:dimensionName string,
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                        :dateRange {:endDate string,
                                    :kind string,
                                    :relativeDateRange string,
                                    :startDate string},
                        :dimensionFilters [{:dimensionName string,
                                            :etag string,
                                            :id string,
                                            :kind string,
                                            :matchType string,
                                            :value string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :floodlightConfigId {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
                        :metricNames [string],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :every integer,
              :expirationDate string,
              :repeats string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string,
              :startDate string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:filters [DimensionValue],
                           :kind string,
                           :metricNames [string]},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dateRange {:endDate string,
                          :kind string,
                          :relativeDateRange string,
                          :startDate string},
              :dimensionFilters [{:dimensionName string,
                                  :etag string,
                                  :id string,
                                  :kind string,
                                  :matchType string,
                                  :value string}],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :metricNames [string]},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:deliveryType string,
                            :email string,
                            :kind string}]},
   :type string,
   :etag string,
   :reachCriteria {:activities {:filters [DimensionValue],
                                :kind string,
                                :metricNames [string]},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :dateRange {:endDate string,
                               :kind string,
                               :relativeDateRange string,
                               :startDate string},
                   :dimensionFilters [{:dimensionName string,
                                       :etag string,
                                       :id string,
                                       :kind string,
                                       :matchType string,
                                       :value string}],
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :enableAllDimensionCombinations boolean,
                   :metricNames [string],
                   :reachByFrequencyMetricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :relativeDateRange string,
                                          :startDate string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :etag string,
                                                       :id string,
                                                       :kind string,
                                                       :matchType string,
                                                       :value string}],
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
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :etag string,
                                                   :id string,
                                                   :kind string,
                                                   :matchType string,
                                                   :value string}},
   :lastModifiedTime string,
   :id string,
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :relativeDateRange string,
                                             :startDate string},
                                 :dimension string,
                                 :dimensionFilters [{:dimensionName string,
                                                     :etag string,
                                                     :id string,
                                                     :kind string,
                                                     :matchType string,
                                                     :value string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string],
                                 :pivoted boolean}}
  
  Creates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/list
  
  Required parameters: profileId
  
  Optional parameters: maxResults, pageToken, scope, sortField, sortOrder
  
  Retrieves list of reports."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
     "https://www.googleapis.com/dfareporting/v3.4/"
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
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/update
  
  Required parameters: profileId, reportId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:customRichMediaEvents [{:dimensionName string,
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                        :dateRange {:endDate string,
                                    :kind string,
                                    :relativeDateRange string,
                                    :startDate string},
                        :dimensionFilters [{:dimensionName string,
                                            :etag string,
                                            :id string,
                                            :kind string,
                                            :matchType string,
                                            :value string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :floodlightConfigId {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
                        :metricNames [string],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :every integer,
              :expirationDate string,
              :repeats string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string,
              :startDate string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:filters [DimensionValue],
                           :kind string,
                           :metricNames [string]},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dateRange {:endDate string,
                          :kind string,
                          :relativeDateRange string,
                          :startDate string},
              :dimensionFilters [{:dimensionName string,
                                  :etag string,
                                  :id string,
                                  :kind string,
                                  :matchType string,
                                  :value string}],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :metricNames [string]},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:deliveryType string,
                            :email string,
                            :kind string}]},
   :type string,
   :etag string,
   :reachCriteria {:activities {:filters [DimensionValue],
                                :kind string,
                                :metricNames [string]},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :dateRange {:endDate string,
                               :kind string,
                               :relativeDateRange string,
                               :startDate string},
                   :dimensionFilters [{:dimensionName string,
                                       :etag string,
                                       :id string,
                                       :kind string,
                                       :matchType string,
                                       :value string}],
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :enableAllDimensionCombinations boolean,
                   :metricNames [string],
                   :reachByFrequencyMetricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :relativeDateRange string,
                                          :startDate string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :etag string,
                                                       :id string,
                                                       :kind string,
                                                       :matchType string,
                                                       :value string}],
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
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :etag string,
                                                   :id string,
                                                   :kind string,
                                                   :matchType string,
                                                   :value string}},
   :lastModifiedTime string,
   :id string,
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :relativeDateRange string,
                                             :startDate string},
                                 :dimension string,
                                 :dimensionFilters [{:dimensionName string,
                                                     :etag string,
                                                     :id string,
                                                     :kind string,
                                                     :matchType string,
                                                     :value string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string],
                                 :pivoted boolean}}
  
  Updates a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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

(defn compatibleFields-query$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/compatibleFields/query
  
  Required parameters: profileId
  
  Optional parameters: none
  
  Body: 
  
  {:floodlightCriteria {:customRichMediaEvents [{:dimensionName string,
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                        :dateRange {:endDate string,
                                    :kind string,
                                    :relativeDateRange string,
                                    :startDate string},
                        :dimensionFilters [{:dimensionName string,
                                            :etag string,
                                            :id string,
                                            :kind string,
                                            :matchType string,
                                            :value string}],
                        :dimensions [{:kind string,
                                      :name string,
                                      :sortOrder string}],
                        :floodlightConfigId {:dimensionName string,
                                             :etag string,
                                             :id string,
                                             :kind string,
                                             :matchType string,
                                             :value string},
                        :metricNames [string],
                        :reportProperties {:includeAttributedIPConversions boolean,
                                           :includeUnattributedCookieConversions boolean,
                                           :includeUnattributedIPConversions boolean}},
   :schedule {:active boolean,
              :every integer,
              :expirationDate string,
              :repeats string,
              :repeatsOnWeekDays [string],
              :runsOnDayOfMonth string,
              :startDate string},
   :format string,
   :subAccountId string,
   :name string,
   :fileName string,
   :criteria {:activities {:filters [DimensionValue],
                           :kind string,
                           :metricNames [string]},
              :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                      :kind string},
              :dateRange {:endDate string,
                          :kind string,
                          :relativeDateRange string,
                          :startDate string},
              :dimensionFilters [{:dimensionName string,
                                  :etag string,
                                  :id string,
                                  :kind string,
                                  :matchType string,
                                  :value string}],
              :dimensions [{:kind string,
                            :name string,
                            :sortOrder string}],
              :metricNames [string]},
   :delivery {:emailOwner boolean,
              :emailOwnerDeliveryType string,
              :message string,
              :recipients [{:deliveryType string,
                            :email string,
                            :kind string}]},
   :type string,
   :etag string,
   :reachCriteria {:activities {:filters [DimensionValue],
                                :kind string,
                                :metricNames [string]},
                   :customRichMediaEvents {:filteredEventIds [DimensionValue],
                                           :kind string},
                   :dateRange {:endDate string,
                               :kind string,
                               :relativeDateRange string,
                               :startDate string},
                   :dimensionFilters [{:dimensionName string,
                                       :etag string,
                                       :id string,
                                       :kind string,
                                       :matchType string,
                                       :value string}],
                   :dimensions [{:kind string,
                                 :name string,
                                 :sortOrder string}],
                   :enableAllDimensionCombinations boolean,
                   :metricNames [string],
                   :reachByFrequencyMetricNames [string]},
   :pathToConversionCriteria {:dateRange {:endDate string,
                                          :kind string,
                                          :relativeDateRange string,
                                          :startDate string},
                              :conversionDimensions [{:kind string,
                                                      :name string,
                                                      :sortOrder string}],
                              :customRichMediaEvents [{:dimensionName string,
                                                       :etag string,
                                                       :id string,
                                                       :kind string,
                                                       :matchType string,
                                                       :value string}],
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
                                                 :etag string,
                                                 :id string,
                                                 :kind string,
                                                 :matchType string,
                                                 :value string}],
                              :customFloodlightVariables [{:kind string,
                                                           :name string,
                                                           :sortOrder string}],
                              :perInteractionDimensions [{:kind string,
                                                          :name string,
                                                          :sortOrder string}],
                              :metricNames [string],
                              :floodlightConfigId {:dimensionName string,
                                                   :etag string,
                                                   :id string,
                                                   :kind string,
                                                   :matchType string,
                                                   :value string}},
   :lastModifiedTime string,
   :id string,
   :kind string,
   :ownerProfileId string,
   :accountId string,
   :crossDimensionReachCriteria {:breakdown [{:kind string,
                                              :name string,
                                              :sortOrder string}],
                                 :dateRange {:endDate string,
                                             :kind string,
                                             :relativeDateRange string,
                                             :startDate string},
                                 :dimension string,
                                 :dimensionFilters [{:dimensionName string,
                                                     :etag string,
                                                     :id string,
                                                     :kind string,
                                                     :matchType string,
                                                     :value string}],
                                 :metricNames [string],
                                 :overlapMetricNames [string],
                                 :pivoted boolean}}
  
  Returns the fields that are compatible to be selected in the respective sections of a report criteria, given the fields already selected in the input report and user permissions."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:profileId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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

(defn files-get$
  "https://developers.google.com/doubleclick-advertisers/api/reference/rest/v3.4/reports/files/get
  
  Required parameters: fileId, profileId, reportId
  
  Optional parameters: none
  
  Retrieves a report file. This method supports media download."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId :fileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
  
  Optional parameters: maxResults, pageToken, sortField, sortOrder
  
  Lists files for a report."
  {:scopes ["https://www.googleapis.com/auth/dfareporting"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId :profileId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/dfareporting/v3.4/"
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
