(ns happygapi.doubleclicksearch.reports
  "Search Ads 360 API: reports.
  Reports and modifies your advertising data in DoubleClick Search (for example, campaigns, ad groups, keywords, and conversions).
  See: https://developers.google.com/doubleclick-search/api/reference/rest/v2/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/reports/generate
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeRange {:changedAttributesSinceTimestamp string,
               :changedMetricsSinceTimestamp string,
               :endDate string,
               :startDate string},
   :filters [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :operator string,
              :values [any]}],
   :columns [{:productReportPerspective string,
              :customMetricName string,
              :startDate string,
              :headerText string,
              :endDate string,
              :groupByColumn boolean,
              :platformSource string,
              :customDimensionName string,
              :savedColumnName string,
              :columnName string}],
   :includeRemovedEntities boolean,
   :verifySingleTimeZone boolean,
   :includeDeletedEntities boolean,
   :statisticsCurrency string,
   :reportScope {:adGroupId string,
                 :adId string,
                 :advertiserId string,
                 :agencyId string,
                 :campaignId string,
                 :engineAccountId string,
                 :keywordId string},
   :reportType string,
   :startRow integer,
   :maxRowsPerFile integer,
   :rowCount integer,
   :downloadFormat string,
   :orderBy [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :sortOrder string}]}
  
  Generates and returns a report immediately."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/generate"
     #{}
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
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/reports/get
  
  Required parameters: reportId
  
  Optional parameters: none
  
  Polls for the status of a report request."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/{reportId}"
     #{:reportId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn getFile$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/reports/getFile
  
  Required parameters: reportFragment, reportId
  
  Optional parameters: none
  
  Downloads a report file encoded in UTF-8."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:reportFragment :reportId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports/{reportId}/files/{reportFragment}"
     #{:reportFragment :reportId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn request$
  "https://developers.google.com/doubleclick-search/api/reference/rest/v2/reports/request
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:timeRange {:changedAttributesSinceTimestamp string,
               :changedMetricsSinceTimestamp string,
               :endDate string,
               :startDate string},
   :filters [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :operator string,
              :values [any]}],
   :columns [{:productReportPerspective string,
              :customMetricName string,
              :startDate string,
              :headerText string,
              :endDate string,
              :groupByColumn boolean,
              :platformSource string,
              :customDimensionName string,
              :savedColumnName string,
              :columnName string}],
   :includeRemovedEntities boolean,
   :verifySingleTimeZone boolean,
   :includeDeletedEntities boolean,
   :statisticsCurrency string,
   :reportScope {:adGroupId string,
                 :adId string,
                 :advertiserId string,
                 :agencyId string,
                 :campaignId string,
                 :engineAccountId string,
                 :keywordId string},
   :reportType string,
   :startRow integer,
   :maxRowsPerFile integer,
   :rowCount integer,
   :downloadFormat string,
   :orderBy [{:column {:productReportPerspective string,
                       :customMetricName string,
                       :startDate string,
                       :headerText string,
                       :endDate string,
                       :groupByColumn boolean,
                       :platformSource string,
                       :customDimensionName string,
                       :savedColumnName string,
                       :columnName string},
              :sortOrder string}]}
  
  Inserts a report request into the reporting system."
  {:scopes ["https://www.googleapis.com/auth/doubleclicksearch"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/doubleclicksearch/v2/"
     "reports"
     #{}
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
