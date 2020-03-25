(ns happygapi.adexchangebuyer.marketplaceprivateauction
  "Ad Exchange Buyer API: marketplaceprivateauction.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplaceprivateauction"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn updateproposal$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplaceprivateauction/updateproposal
  
  Required parameters: privateAuctionId
  
  Optional parameters: none
  
  Body: 
  
  {:externalDealId string,
   :note {:creatorRole string,
          :dealId string,
          :kind string,
          :note string,
          :noteId string,
          :proposalId string,
          :proposalRevisionNumber string,
          :timestampMs string},
   :proposalRevisionNumber string,
   :updateAction string}
  
  Update a given private auction proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:privateAuctionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "privateauction/{privateAuctionId}/updateproposal"
     #{:privateAuctionId}
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
