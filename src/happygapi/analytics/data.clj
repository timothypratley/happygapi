(ns happygapi.analytics.data
  "Google Analytics API: data.
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/api/reference/rest/v3/data"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn ga-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/data/ga/get
  
  Required parameters: end-date, ids, start-date, metrics
  
  Optional parameters: start-index, include-empty-rows, filters, max-results, output, dimensions, segment, samplingLevel, sort
  
  Returns Analytics data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:end-date :ids :start-date :metrics})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/ga"
     #{:end-date :ids :start-date :metrics}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn mcf-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/data/mcf/get
  
  Required parameters: end-date, ids, start-date, metrics
  
  Optional parameters: start-index, filters, max-results, dimensions, samplingLevel, sort
  
  Returns Analytics Multi-Channel Funnels data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:end-date :ids :start-date :metrics})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/mcf"
     #{:end-date :ids :start-date :metrics}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn realtime-get$
  "https://developers.google.com/analytics/api/reference/rest/v3/data/realtime/get
  
  Required parameters: ids, metrics
  
  Optional parameters: max-results, sort, dimensions, filters
  
  Returns real time data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:ids :metrics})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/realtime"
     #{:ids :metrics}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
