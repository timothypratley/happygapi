(ns happygapi.adexchangebuyer.performanceReport
  "Ad Exchange Buyer API: performanceReport.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/performanceReport"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/performanceReport/list
  
  Required parameters: accountId, endDateTime, startDateTime
  
  Optional parameters: maxResults, pageToken
  Retrieves the authenticated user's list of performance metrics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:startDateTime :endDateTime :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "performancereport"
     #{:startDateTime :endDateTime :accountId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
