(ns happygapi.adexchangebuyer.billingInfo
  "Ad Exchange Buyer API: billingInfo.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/billingInfo"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/billingInfo/get
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Returns the billing information for one account specified by account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo/{accountId}"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/billingInfo/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves a list of billing information for all accounts of the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "billinginfo"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
