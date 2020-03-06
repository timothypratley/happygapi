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
  
  {:viewId string,
   :user {:userId string, :type string},
   :activityTypes [string],
   :pageToken string,
   :dateRange {:endDate string, :startDate string},
   :pageSize integer}
  
  Returns User Activity data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsreporting.googleapis.com/"
     "v4/userActivity:search"
     #{}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
