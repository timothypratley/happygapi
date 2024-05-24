(ns happygapi.analyticsdata.properties
  "Google Analytics Data API: properties.
  Accesses report data in Google Analytics. Warning: Creating multiple Customer Applications, Accounts, or Projects to simulate or act as a single Customer Application, Account, or Project (respectively) or to circumvent Service-specific usage limits or quotas is a direct violation of Google Cloud Platform Terms of Service as well as Google APIs Terms of Service. These actions can result in immediate termination of your GCP project(s) without any warning. 
  See: https://developers.google.com/analytics/devguides/reporting/data/v1/docs/reference/rest/v1beta/properties"
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
   :cohortSpec {:cohorts [Cohort],
                :cohortsRange CohortsRange,
                :cohortReportSettings CohortReportSettings},
   :dimensionFilter {:andGroup FilterExpressionList,
                     :orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:andGroup FilterExpressionList,
                  :orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :comparisons [{:name string,
                  :dimensionFilter FilterExpression,
                  :comparison string}],
   :dateRanges [{:startDate string, :endDate string, :name string}],
   :orderBys [{:metric MetricOrderBy,
               :dimension DimensionOrderBy,
               :pivot PivotOrderBy,
               :desc boolean}],
   :metrics [{:name string, :expression string, :invisible boolean}]}
  
  Returns a customized report of your Google Analytics event data. Reports contain statistics derived from data collected by the Google Analytics tracking code. The data returned from the API is as a table with columns for the requested dimensions and metrics. Metrics are individual measurements of user activity on your property, such as active users or event count. Dimensions break down metrics across some common criteria, such as country or event name. For a guide to constructing requests & understanding responses, see [Creating a Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics)."
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

(defn runPivotReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runPivotReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:property string,
   :cohortSpec {:cohorts [Cohort],
                :cohortsRange CohortsRange,
                :cohortReportSettings CohortReportSettings},
   :dimensionFilter {:andGroup FilterExpressionList,
                     :orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:andGroup FilterExpressionList,
                  :orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter},
   :returnPropertyQuota boolean,
   :keepEmptyRows boolean,
   :currencyCode string,
   :comparisons [{:name string,
                  :dimensionFilter FilterExpression,
                  :comparison string}],
   :pivots [{:fieldNames [string],
             :orderBys [OrderBy],
             :offset string,
             :limit string,
             :metricAggregations [string]}],
   :dateRanges [{:startDate string, :endDate string, :name string}],
   :metrics [{:name string, :expression string, :invisible boolean}]}
  
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
               :comparisons [Comparison],
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
               :comparisons [Comparison],
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

(defn runRealtimeReport$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/runRealtimeReport
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:limit string,
   :dimensionFilter {:andGroup FilterExpressionList,
                     :orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter},
   :dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metricFilter {:andGroup FilterExpressionList,
                  :orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter},
   :metricAggregations [string],
   :returnPropertyQuota boolean,
   :minuteRanges [{:startMinutesAgo integer,
                   :endMinutesAgo integer,
                   :name string}],
   :orderBys [{:metric MetricOrderBy,
               :dimension DimensionOrderBy,
               :pivot PivotOrderBy,
               :desc boolean}],
   :metrics [{:name string, :expression string, :invisible boolean}]}
  
  Returns a customized report of realtime event data for your property. Events appear in realtime reports seconds after they have been sent to the Google Analytics. Realtime reports show events and usage data for the periods of time ranging from the present moment to 30 minutes ago (up to 60 minutes for Google Analytics 360 properties). For a guide to constructing realtime requests & understanding responses, see [Creating a Realtime Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics)."
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

(defn checkCompatibility$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/checkCompatibility
  
  Required parameters: property
  
  Optional parameters: none
  
  Body: 
  
  {:dimensions [{:name string, :dimensionExpression DimensionExpression}],
   :metrics [{:name string, :expression string, :invisible boolean}],
   :dimensionFilter {:andGroup FilterExpressionList,
                     :orGroup FilterExpressionList,
                     :notExpression FilterExpression,
                     :filter Filter},
   :metricFilter {:andGroup FilterExpressionList,
                  :orGroup FilterExpressionList,
                  :notExpression FilterExpression,
                  :filter Filter},
   :compatibilityFilter string}
  
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

(defn audienceExports-create$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/audienceExports/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:audienceDisplayName string,
   :errorMessage string,
   :name string,
   :percentageCompleted number,
   :state string,
   :dimensions [{:dimensionName string}],
   :creationQuotaTokensCharged integer,
   :audience string,
   :rowCount integer,
   :beginCreatingTime string}
  
  Creates an audience export for later retrieval. This method quickly returns the audience export's resource name and initiates a long running asynchronous request to form an audience export. To export the users in an audience export, first create the audience export through this method and then send the audience resource name to the `QueryAudienceExport` method. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. An audience export is a snapshot of the users currently in the audience at the time of audience export creation. Creating audience exports for one audience on different days will return different results as users enter and exit the audience. Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each audience. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+parent}/audienceExports"
     #{:parent}
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

(defn audienceExports-query$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/audienceExports/query
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:offset string, :limit string}
  
  Retrieves an audience export of users. After creating an audience, the users are not immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to create an audience export of users, and then second, this method is used to retrieve the users in the audience export. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+name}:query"
     #{:name}
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

(defn audienceExports-get$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/audienceExports/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets configuration metadata about a specific audience export. This method can be used to understand an audience export after it has been created. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form."
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

(defn audienceExports-list$
  "https://developers.google.com/analytics/devguides/reporting/data/v1/api/reference/rest/v1beta/properties/audienceExports/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all audience exports for a property. This method can be used for you to find and reuse existing audience exports rather than creating unnecessary new audience exports. The same audience can have multiple audience exports that represent the export of users that were in an audience on different days. See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples. Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://analyticsdata.googleapis.com/"
     "v1beta/{+parent}/audienceExports"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
