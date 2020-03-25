(ns happygapi.adexchangebuyer.products
  "Ad Exchange Buyer API: products.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/products"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/products/get
  
  Required parameters: productId
  
  Optional parameters: none
  
  Gets the requested product by id."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "products/{productId}"
     #{:productId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn search$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/products/search
  
  Required parameters: none
  
  Optional parameters: pqlQuery
  
  Gets the requested product."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "products/search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
