(ns happygapi.businessprofileperformance.locations
  "Business Profile Performance API: locations.
  The Business Profile Performance API allows merchants to fetch performance reports about their business profile on Google. Note - If you have a quota of 0 after enabling the API, please request for GBP API access.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getDailyMetricsTimeSeries$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/getDailyMetricsTimeSeries
  
  Required parameters: name
  
  Optional parameters: dailyRange.endDate.year, dailySubEntityType.timeOfDay.hours, dailySubEntityType.timeOfDay.nanos, dailyRange.startDate.month, dailyRange.startDate.day, dailySubEntityType.timeOfDay.minutes, dailyMetric, dailySubEntityType.timeOfDay.seconds, dailyRange.endDate.month, dailySubEntityType.dayOfWeek, dailyRange.startDate.year, dailyRange.endDate.day
  
   Returns the values for each date from a given time range that are associated with the specific daily metric. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345:getDailyMetricsTimeSeries?dailyMetric=WEBSITE_CLICKS&daily_range.start_date.year=2022&daily_range.start_date.month=1&daily_range.start_date.day=1&daily_range.end_date.year=2022&daily_range.end_date.month=3&daily_range.end_date.day=31`"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://businessprofileperformance.googleapis.com/"
     "v1/{+name}:getDailyMetricsTimeSeries"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn fetchMultiDailyMetricsTimeSeries$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/fetchMultiDailyMetricsTimeSeries
  
  Required parameters: location
  
  Optional parameters: dailyMetrics, dailyRange.startDate.year, dailyRange.startDate.month, dailyRange.startDate.day, dailyRange.endDate.year, dailyRange.endDate.month, dailyRange.endDate.day
  
   Returns the values for each date from a given time range and optionally the sub entity type, where applicable, that are associated with the specific daily metrics. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345:fetchMultiDailyMetricsTimeSeries?dailyMetrics=WEBSITE_CLICKS&dailyMetrics=CALL_CLICKS&daily_range.start_date.year=2022&daily_range.start_date.month=1&daily_range.start_date.day=1&daily_range.end_date.year=2022&daily_range.end_date.month=3&daily_range.end_date.day=31`"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://businessprofileperformance.googleapis.com/"
     "v1/{+location}:fetchMultiDailyMetricsTimeSeries"
     #{:location}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn searchkeywords-impressions-monthly-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/searchkeywords/impressions/monthly/list
  
  Required parameters: parent
  
  Optional parameters: monthlyRange.startMonth.day, monthlyRange.endMonth.day, monthlyRange.startMonth.year, monthlyRange.startMonth.month, pageToken, pageSize, monthlyRange.endMonth.year, monthlyRange.endMonth.month
  
  Returns the search keywords used to find a business in search or maps. Each search keyword is accompanied by impressions which are aggregated on a monthly basis. Example request: `GET https://businessprofileperformance.googleapis.com/v1/locations/12345/searchkeywords/impressions/monthly?monthly_range.start_month.year=2022&monthly_range.start_month.month=1&monthly_range.end_month.year=2022&monthly_range.end_month.month=3`"
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://businessprofileperformance.googleapis.com/"
     "v1/{+parent}/searchkeywords/impressions/monthly"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
