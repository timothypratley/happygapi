(ns happygapi.analyticsdata.properties
  "Google Analytics Data API: properties.
  Accesses report data in Google Analytics.
  See: https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn runReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:limit string,
   :offset string,
   :property string,
   :cohortSpec {:cohortReportSettings CohortReportSettings,
                :cohorts [Cohort],
                :cohortsRange CohortsRange},
   :dimensionFilter {:orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter,
                     :andGroup FilterExpressionList},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter,
                  :andGroup FilterExpressionList},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :dateRanges [{:name string, :startDate string, :endDate string}],
   :orderBys [{:pivot PivotOrderBy,
               :desc boolean,
               :dimension DimensionOrderBy,
               :metric MetricOrderBy}],
   :metrics [{:expression string, :name string, :invisible boolean}]}
  
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

(defn checkCompatibility$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/checkCompatibility
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:metrics [{:expression string, :name string, :invisible boolean}],
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :compatibilityFilter string,
   :metricFilter {:orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter,
                  :andGroup FilterExpressionList},
   :dimensionFilter {:orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter,
                     :andGroup FilterExpressionList}}
  
  This compatibility method lists dimensions and metrics that can be added to a report request and maintain compatibility. This method fails if the request's dimensions and metrics are incompatible. In Google Analytics, reports fail if they request incompatible dimensions and/or metrics; in that case, you will need to remove dimensions and/or metrics from the incompatible report until the report is compatible. The Realtime and Core reports have different compatibility rules. This method checks compatibility for Core reports."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:property})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+property}:checkCompatibility"
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
  
  {:limit string,
   :dimensionFilter {:orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter,
                     :andGroup FilterExpressionList},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter,
                  :andGroup FilterExpressionList},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :minuteRanges [{:startMinutesAgo integer,
                   :endMinutesAgo integer,
                   :name string}],
   :orderBys [{:pivot PivotOrderBy,
               :desc boolean,
               :dimension DimensionOrderBy,
               :metric MetricOrderBy}],
   :metrics [{:expression string, :name string, :invisible boolean}]}
  
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

(defn runPivotReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runPivotReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:property string,
   :cohortSpec {:cohortReportSettings CohortReportSettings,
                :cohorts [Cohort],
                :cohortsRange CohortsRange},
   :dimensionFilter {:orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter,
                     :andGroup FilterExpressionList},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter,
                  :andGroup FilterExpressionList},
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :pivots [{:offset string,
             :limit string,
             :metricAggregations [string],
             :fieldNames [string],
             :orderBys [OrderBy]}],
   :dateRanges [{:name string, :startDate string, :endDate string}],
   :metrics [{:expression string, :name string, :invisible boolean}]}
  
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
