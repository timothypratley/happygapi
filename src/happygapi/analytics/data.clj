(ns happygapi.analytics.data
  "Google Analytics API
  Views and manages your Google Analytics data.
  See: https://developers.google.com/analytics/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn ga-get$
  "Required parameters: end-date,ids,start-date,metrics
  
  Returns Analytics data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"end-date" "ids" "start-date" "metrics"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/ga"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn mcf-get$
  "Required parameters: end-date,ids,start-date,metrics
  
  Returns Analytics Multi-Channel Funnels data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"end-date" "ids" "start-date" "metrics"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/mcf"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn realtime-get$
  "Required parameters: ids,metrics
  
  Returns real time data for a view (profile)."
  {:scopes ["https://www.googleapis.com/auth/analytics"
            "https://www.googleapis.com/auth/analytics.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"ids" "metrics"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/analytics/v3/"
     "data/realtime"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
