(ns happygapi.monitoring.folders
  "Cloud Monitoring API: folders.
  Manages your Cloud Monitoring data and configurations.
  See: https://cloud.google.com/monitoring/api/docs/reference/rest/v3/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn timeSeries-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/folders/timeSeries/list
  
  Required parameters: name
  
  Optional parameters: aggregation.perSeriesAligner, interval.startTime, secondaryAggregation.alignmentPeriod, aggregation.alignmentPeriod, secondaryAggregation.groupByFields, pageToken, aggregation.crossSeriesReducer, interval.endTime, filter, pageSize, aggregation.groupByFields, secondaryAggregation.crossSeriesReducer, secondaryAggregation.perSeriesAligner, view, orderBy
  
  Lists time series that match a filter."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/monitoring"
            "https://www.googleapis.com/auth/monitoring.read"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://monitoring.googleapis.com/"
     "v3/{+name}/timeSeries"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
