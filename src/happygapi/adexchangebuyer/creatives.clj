(ns happygapi.adexchangebuyer.creatives
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

(defn addDeal$
  "Required parameters: accountId, buyerCreativeId, dealId
  
  Optional parameters: none
  
  Add a deal id association for the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "buyerCreativeId" "dealId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/addDeal/{dealId}"
     #{"accountId" "buyerCreativeId" "dealId"}
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

(defn get$
  "Required parameters: accountId, buyerCreativeId
  
  Optional parameters: none
  
  Gets the status for a single creative. A creative will be available 30-40 minutes after submission."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "buyerCreativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}"
     #{"accountId" "buyerCreativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Optional parameters: none
  
  Submit a new creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives"
     #{}
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

(defn list$
  "Required parameters: none
  
  Optional parameters: accountId, buyerCreativeId, dealsStatusFilter, maxResults, openAuctionStatusFilter, pageToken
  
  Retrieves a list of the authenticated user's active creatives. A creative will be available 30-40 minutes after submission."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listDeals$
  "Required parameters: accountId, buyerCreativeId
  
  Optional parameters: none
  
  Lists the external deal ids associated with the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "buyerCreativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/listDeals"
     #{"accountId" "buyerCreativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn removeDeal$
  "Required parameters: accountId, buyerCreativeId, dealId
  
  Optional parameters: none
  
  Remove a deal id associated with the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"accountId" "buyerCreativeId" "dealId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/removeDeal/{dealId}"
     #{"accountId" "buyerCreativeId" "dealId"}
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
