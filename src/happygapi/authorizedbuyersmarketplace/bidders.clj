(ns happygapi.authorizedbuyersmarketplace.bidders
  "Authorized Buyers Marketplace API: bidders.
  The Authorized Buyers Marketplace API lets buyers programmatically discover inventory; propose, retrieve and negotiate deals with publishers.
  See: https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/docs/reference/rest/v1/bidders"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn auctionPackages-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/bidders/auctionPackages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter, orderBy
  
  List the auction packages. Buyers can use the URL path \"/v1/buyers/{accountId}/auctionPackages\" to list auction packages for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/auctionPackages\" to list auction packages for the bidder, its media planners, its buyers, and all their clients."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/auctionPackages"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn finalizedDeals-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/bidders/finalizedDeals/list
  
  Required parameters: parent
  
  Optional parameters: filter, orderBy, pageSize, pageToken
  
  Lists finalized deals. Use the URL path \"/v1/buyers/{accountId}/finalizedDeals\" to list finalized deals for the current buyer and its clients. Bidders can use the URL path \"/v1/bidders/{accountId}/finalizedDeals\" to list finalized deals for the bidder, its buyers and all their clients."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/finalizedDeals"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
