(ns happygapi.adexchangebuyer.performanceReport
  "Ad Exchange Buyer API
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-rest"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adexchangebuyer_schema.edn"))))

(defn list$
  "Required parameters: accountId, endDateTime, startDateTime
  
  Optional parameters: maxResults, pageToken
  
  Retrieves the authenticated user's list of performance metrics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"endDateTime" "accountId" "startDateTime"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "performancereport"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
