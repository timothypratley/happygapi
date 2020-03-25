(ns happygapi.adexchangebuyer.accounts
  "Ad Exchange Buyer API: accounts.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/accounts/get
  
  Required parameters: id
  
  Optional parameters: none
  
  Gets one account by ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "accounts/{id}"
     #{:id}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/accounts/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Retrieves the authenticated user's list of accounts."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "accounts"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/accounts/patch
  
  Required parameters: id
  
  Optional parameters: confirmUnsafeAccountChange
  
  Body: 
  
  {:cookieMatchingNid string,
   :maximumTotalQps integer,
   :applyPretargetingToNonGuaranteedDeals boolean,
   :cookieMatchingUrl string,
   :maximumActiveCreatives integer,
   :bidderLocation [{:bidProtocol string,
                     :maximumQps integer,
                     :region string,
                     :url string}],
   :id integer,
   :kind string,
   :numberActiveCreatives integer}
  
  Updates an existing account. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "accounts/{id}"
     #{:id}
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
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/accounts/update
  
  Required parameters: id
  
  Optional parameters: confirmUnsafeAccountChange
  
  Body: 
  
  {:cookieMatchingNid string,
   :maximumTotalQps integer,
   :applyPretargetingToNonGuaranteedDeals boolean,
   :cookieMatchingUrl string,
   :maximumActiveCreatives integer,
   :bidderLocation [{:bidProtocol string,
                     :maximumQps integer,
                     :region string,
                     :url string}],
   :id integer,
   :kind string,
   :numberActiveCreatives integer}
  
  Updates an existing account."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:id})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "accounts/{id}"
     #{:id}
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
