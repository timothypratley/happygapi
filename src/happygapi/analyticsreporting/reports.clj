(ns happygapi.analyticsreporting.reports
  "Analytics Reporting API: reports.
  Accesses Analytics report data.
  See: https://developers.google.com/analytics/devguides/reporting/core/v4/api/reference/rest/v4/reports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn batchGet$
  "https://developers.google.com/analytics/devguides/reporting/core/v4/api/reference/rest/v4/reports/batchGet
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:reportRequests [{:filtersExpression string,
                     :hideTotals boolean,
                     :viewId string,
                     :dimensionFilterClauses [DimensionFilterClause],
                     :cohortGroup CohortGroup,
                     :segments [Segment],
                     :dimensions [Dimension],
                     :pageToken string,
                     :hideValueRanges boolean,
                     :pageSize integer,
                     :metricFilterClauses [MetricFilterClause],
                     :includeEmptyRows boolean,
                     :samplingLevel string,
                     :pivots [Pivot],
                     :dateRanges [DateRange],
                     :orderBys [OrderBy],
                     :metrics [Metric]}],
   :useResourceQuotas boolean}
  
  Returns the Analytics data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsreporting.googleapis.com/"
     "v4/reports:batchGet"
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
