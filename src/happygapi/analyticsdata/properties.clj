(ns happygapi.analyticsdata.properties
  "Google Analytics Data API: properties.
  Accesses report data in Google Analytics.
  See: https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchRunReports$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/batchRunReports
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:limit string,
               :offset string,
               :property string,
               :cohortSpec CohortSpec,
               :dimensionFilter FilterExpression,
               :dimensions [Dimension],
               :metricFilter FilterExpression,
               :metricAggregations [string],
               :returnPropertyQuota boolean,
               :keepEmptyRows boolean,
               :currencyCode string,
               :dateRanges [DateRange],
               :orderBys [OrderBy],
               :metrics [Metric]}]}
  
  Returns multiple reports in a batch. All reports must be for the same GA4 Property."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:batchRunReports"
     #{:property}
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

(defn getMetadata$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/getMetadata
  
  Required parameters: name
  
  Optional parameters: none
  
  Returns metadata for dimensions and metrics available in reporting methods. Used to explore the dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified in the request, and the metadata response includes Custom dimensions and metrics as well as Universal metadata. For example if a custom metric with parameter name `levels_unlocked` is registered to a property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata are dimensions and metrics applicable to any property such as `country` and `totalUsers`."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn runPivotReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runPivotReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:property string,
   :cohortSpec {:cohorts [Cohort],
                :cohortReportSettings CohortReportSettings,
                :cohortsRange CohortsRange},
   :dimensionFilter {:notExpression FilterExpression,
                     :orGroup FilterExpressionList,
                     :andGroup FilterExpressionList,
                     :filter Filter},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:notExpression FilterExpression,
                  :orGroup FilterExpressionList,
                  :andGroup FilterExpressionList,
                  :filter Filter},
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :pivots [{:orderBys [OrderBy],
             :offset string,
             :fieldNames [string],
             :metricAggregations [string],
             :limit string}],
   :dateRanges [{:startDate string, :name string, :endDate string}],
   :metrics [{:invisible boolean, :name string, :expression string}]}
  
  Returns a customized pivot report of your Google Analytics event data. Pivot reports are more advanced and expressive formats than regular reports. In a pivot report, dimensions are only visible if they are included in a pivot. Multiple pivots can be specified to further dissect your data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:runPivotReport"
     #{:property}
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

(defn runReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:limit string,
   :offset string,
   :property string,
   :cohortSpec {:cohorts [Cohort],
                :cohortReportSettings CohortReportSettings,
                :cohortsRange CohortsRange},
   :dimensionFilter {:notExpression FilterExpression,
                     :orGroup FilterExpressionList,
                     :andGroup FilterExpressionList,
                     :filter Filter},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:notExpression FilterExpression,
                  :orGroup FilterExpressionList,
                  :andGroup FilterExpressionList,
                  :filter Filter},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :dateRanges [{:startDate string, :name string, :endDate string}],
   :orderBys [{:metric MetricOrderBy,
               :desc boolean,
               :dimension DimensionOrderBy,
               :pivot PivotOrderBy}],
   :metrics [{:invisible boolean, :name string, :expression string}]}
  
  Returns a customized report of your Google Analytics event data. Reports contain statistics derived from data collected by the Google Analytics tracking code. The data returned from the API is as a table with columns for the requested dimensions and metrics. Metrics are individual measurements of user activity on your property, such as active users or event count. Dimensions break down metrics across some common criteria, such as country or event name."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:runReport"
     #{:property}
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

(defn runRealtimeReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runRealtimeReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :limit string,
   :returnPropertyQuota boolean,
   :metricFilter {:notExpression FilterExpression,
                  :orGroup FilterExpressionList,
                  :andGroup FilterExpressionList,
                  :filter Filter},
   :metrics [{:invisible boolean, :name string, :expression string}],
   :metricAggregations [string],
   :orderBys [{:metric MetricOrderBy,
               :desc boolean,
               :dimension DimensionOrderBy,
               :pivot PivotOrderBy}],
   :dimensionFilter {:notExpression FilterExpression,
                     :orGroup FilterExpressionList,
                     :andGroup FilterExpressionList,
                     :filter Filter}}
  
  The Google Analytics Realtime API returns a customized report of realtime event data for your property. These reports show events and usage from the last 30 minutes."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:runRealtimeReport"
     #{:property}
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

(defn batchRunPivotReports$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/batchRunPivotReports
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:property string,
               :cohortSpec CohortSpec,
               :dimensionFilter FilterExpression,
               :dimensions [Dimension],
               :metricFilter FilterExpression,
               :returnPropertyQuota boolean,
               :keepEmptyRows boolean,
               :currencyCode string,
               :pivots [Pivot],
               :dateRanges [DateRange],
               :metrics [Metric]}]}
  
  Returns multiple pivot reports in a batch. All reports must be for the same GA4 Property."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:batchRunPivotReports"
     #{:property}
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
