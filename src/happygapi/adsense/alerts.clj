(ns happygapi.adsense.alerts
  "AdSense Management API
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn delete$
  "Required parameters: alertId
  
  Dismiss (delete) the specified alert from the publisher's AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"]}
  [auth args]
  {:pre [(util/has-keys? args #{"alertId"})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "alerts/{alertId}"
     #{"alertId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: none
  
  List the alerts for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "alerts"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
