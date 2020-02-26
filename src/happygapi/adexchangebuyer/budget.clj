(ns happygapi.adexchangebuyer.budget
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

(defn get$
  "Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Returns the budget information for the adgroup specified by the accountId and billingId."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"billingId" "accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{"billingId" "accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Updates the budget amount for the budget of the adgroup specified by the accountId and billingId, with the budget amount in the request. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"billingId" "accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{"billingId" "accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Updates the budget amount for the budget of the adgroup specified by the accountId and billingId, with the budget amount in the request."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"billingId" "accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{"billingId" "accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
