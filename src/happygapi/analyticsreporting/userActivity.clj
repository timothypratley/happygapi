(ns happygapi.analyticsreporting.userActivity
  "Analytics Reporting API: userActivity.
  Accesses Analytics report data.
  See: https://developers.google.com/analytics/devguides/reporting/core/v4/api/reference/rest/v4/userActivity"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn search$
  "https://developers.google.com/analytics/devguides/reporting/core/v4/api/reference/rest/v4/userActivity/search
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:activityTypes [string],
   :pageToken string,
   :user {:userId string, :type string},
   :pageSize integer,
   :dateRange {:startDate string, :endDate string},
   :viewId string}
  
  Returns User Activity data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsreporting.googleapis.com/"
     "v4/userActivity:search"
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
