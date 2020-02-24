(ns happygapi.alertcenter.v1beta1
  "G Suite Alert Center API
  Manages alerts on issues affecting your domain.
  See: https://developers.google.com/admin-sdk/alertcenter/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn $
  "Required parameters: none
  
  Returns customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn $
  "Required parameters: none
  
  Updates the customer-level settings."
  {:scopes ["https://www.googleapis.com/auth/apps.alerts"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://alertcenter.googleapis.com/"
     "v1beta1/settings"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
