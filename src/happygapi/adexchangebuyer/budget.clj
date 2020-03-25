(ns happygapi.adexchangebuyer.budget
  "Ad Exchange Buyer API: budget.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/budget"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/budget/get
  
  Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Returns the budget information for the adgroup specified by the accountId and billingId."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:billingId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{:billingId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/budget/patch
  
  Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :billingId string,
   :budgetAmount string,
   :currencyCode string,
   :id string,
   :kind string}
  
  Updates the budget amount for the budget of the adgroup specified by the accountId and billingId, with the budget amount in the request. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:billingId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{:billingId :accountId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/budget/update
  
  Required parameters: accountId, billingId
  
  Optional parameters: none
  
  Body: 
  
  {:accountId string,
   :billingId string,
   :budgetAmount string,
   :currencyCode string,
   :id string,
   :kind string}
  
  Updates the budget amount for the budget of the adgroup specified by the accountId and billingId, with the budget amount in the request."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:billingId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}/{billingId}"
     #{:billingId :accountId}
     parameters)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
