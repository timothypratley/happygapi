(ns happygapi.analyticsreporting.userActivity
  "Analytics Reporting API
  Accesses Analytics report data.
  See: https://developers.google.com/analytics/devguides/reporting/core/v4/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn search$
  "Required parameters: none
  
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
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))
