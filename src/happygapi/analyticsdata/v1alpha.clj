(ns happygapi.analyticsdata.v1alpha
  "Google Analytics Data API: v1alpha.
  Accesses report data in Google Analytics.
  See: https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/v1alpha"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/batchRunReports
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:limit string,
               :offset string,
               :cohortSpec CohortSpec,
               :dimensionFilter FilterExpression,
               :dimensions [Dimension],
               :metricFilter FilterExpression,
               :metricAggregations [string],
               :returnPropertyQuota boolean,
               :keepEmptyRows boolean,
               :currencyCode string,
               :dateRanges [DateRange],
               :entity Entity,
               :orderBys [OrderBy],
               :metrics [Metric]}],
   :entity {:propertyId string}}
  
  Returns multiple reports in a batch. All reports must be for the same Entity."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1alpha:batchRunReports"
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

(defn $
  "https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/batchRunPivotReports
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:cohortSpec CohortSpec,
               :dimensionFilter FilterExpression,
               :dimensions [Dimension],
               :metricFilter FilterExpression,
               :returnPropertyQuota boolean,
               :keepEmptyRows boolean,
               :currencyCode string,
               :pivots [Pivot],
               :dateRanges [DateRange],
               :entity Entity,
               :metrics [Metric]}],
   :entity {:propertyId string}}
  
  Returns multiple pivot reports in a batch. All reports must be for the same Entity."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1alpha:batchRunPivotReports"
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

(defn $
  "https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/getUniversalMetadata
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns metadata for dimensions and metrics available in reporting methods. Used to explore the dimensions and metrics. Dimensions and metrics will be mostly added over time, but renames and deletions may occur. This method returns Universal Metadata. Universal Metadata are dimensions and metrics applicable to any property such as `country` and `totalUsers`."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1alpha/universalMetadata"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/runPivotReport
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:cohortSpec {:cohortsRange CohortsRange,
                :cohortReportSettings CohortReportSettings,
                :cohorts [Cohort]},
   :dimensionFilter {:filter Filter,
                     :orGroup FilterExpressionList,
                     :andGroup FilterExpressionList,
                     :notExpression FilterExpression},
   :dimensions [{:dimensionExpression DimensionExpression, :name string}],
   :metricFilter {:filter Filter,
                  :orGroup FilterExpressionList,
                  :andGroup FilterExpressionList,
                  :notExpression FilterExpression},
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :pivots [{:limit string,
             :offset string,
             :fieldNames [string],
             :metricAggregations [string],
             :orderBys [OrderBy]}],
   :dateRanges [{:name string, :endDate string, :startDate string}],
   :entity {:propertyId string},
   :metrics [{:name string, :expression string, :invisible boolean}]}
  
  Returns a customized pivot report of your Google Analytics event data. Pivot reports are more advanced and expressive formats than regular reports. In a pivot report, dimensions are only visible if they are included in a pivot. Multiple pivots can be specified to further dissect your data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1alpha:runPivotReport"
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

(defn $
  "https://developers.google.com/analytics/trusted-testing/analytics-data/api/reference/rest/v1alpha/runReport
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:limit string,
   :offset string,
   :cohortSpec {:cohortsRange CohortsRange,
                :cohortReportSettings CohortReportSettings,
                :cohorts [Cohort]},
   :dimensionFilter {:filter Filter,
                     :orGroup FilterExpressionList,
                     :andGroup FilterExpressionList,
                     :notExpression FilterExpression},
   :dimensions [{:dimensionExpression DimensionExpression, :name string}],
   :metricFilter {:filter Filter,
                  :orGroup FilterExpressionList,
                  :andGroup FilterExpressionList,
                  :notExpression FilterExpression},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :dateRanges [{:name string, :endDate string, :startDate string}],
   :entity {:propertyId string},
   :orderBys [{:desc boolean,
               :pivot PivotOrderBy,
               :dimension DimensionOrderBy,
               :metric MetricOrderBy}],
   :metrics [{:name string, :expression string, :invisible boolean}]}
  
  Returns a customized report of your Google Analytics event data. Reports contain statistics derived from data collected by the Google Analytics tracking code. The data returned from the API is as a table with columns for the requested dimensions and metrics. Metrics are individual measurements of user activity on your property, such as active users or event count. Dimensions break down metrics across some common criteria, such as country or event name."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1alpha:runReport"
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
