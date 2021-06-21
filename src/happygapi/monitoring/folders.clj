(ns happygapi.monitoring.folders
  "Cloud Monitoring API: folders.
  Manages your Cloud Monitoring data and configurations. Most projects must be associated with a Workspace, with a few exceptions as noted on the individual method pages. The table entries below are presented in alphabetical order, not in order of common use. For explanations of the concepts found in the table entries, read the Cloud Monitoring documentation.
  See: https://cloud.google.com/monitoring/api/api/reference/rest/v3/folders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn timeSeries-list$
  "https://cloud.google.com/monitoring/api/api/reference/rest/v3/folders/timeSeries/list
  
  Required parameters: name
  
  Optional parameters: aggregation.perSeriesAligner, interval.startTime, secondaryAggregation.alignmentPeriod, aggregation.alignmentPeriod, secondaryAggregation.groupByFields, pageToken, aggregation.crossSeriesReducer, interval.endTime, filter, pageSize, aggregation.groupByFields, secondaryAggregation.crossSeriesReducer, secondaryAggregation.perSeriesAligner, view, orderBy
  
  Lists time series that match a filter. This method does not require a Workspace."
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
