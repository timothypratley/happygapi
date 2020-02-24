(ns happygapi.analyticsreporting.reports
  "Analytics Reporting API
  Accesses Analytics report data.
  See: https://developers.google.com/analytics/devguides/reporting/core/v4/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn batchGet$
  "Required parameters: none
  
  Returns the Analytics data."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://analyticsreporting.googleapis.com/"
     "v4/reports:batchGet"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
