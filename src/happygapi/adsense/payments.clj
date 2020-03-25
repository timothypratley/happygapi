(ns happygapi.adsense.payments
  "AdSense Management API: payments.
  Accesses AdSense publishers' inventory and generates performance reports.
  See: https://developers.google.com/adsense/management/api/reference/rest/v1.4/payments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/adsense/management/api/reference/rest/v1.4/payments/list
  
  Required parameters: none
  
  Optional parameters: none
  
  List the payments for this AdSense account."
  {:scopes ["https://www.googleapis.com/auth/adsense"
            "https://www.googleapis.com/auth/adsense.readonly"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adsense/v1.4/"
     "payments"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
