(ns happygapi.adexchangebuyer.proposals
  "Ad Exchange Buyer API: proposals.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/get
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Get a proposal given its id"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}"
     #{:proposalId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:proposals [{:hasBuyerSignedOff boolean,
                :labels [MarketplaceLabel],
                :isSetupComplete boolean,
                :billedBuyer Buyer,
                :revisionNumber string,
                :name string,
                :originatorRole string,
                :negotiationId string,
                :dbmAdvertiserIds [string],
                :proposalState string,
                :kind string,
                :lastUpdaterOrCommentorRole string,
                :inventorySource string,
                :buyerPrivateData PrivateData,
                :buyerContacts [ContactInformation],
                :proposalId string,
                :hasSellerSignedOff boolean,
                :revisionTimeMs string,
                :buyer Buyer,
                :sellerContacts [ContactInformation],
                :privateAuctionId string,
                :seller Seller,
                :isRenegotiating boolean}],
   :webPropertyCode string}
  
  Create the given list of proposals"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/insert"
     #{}
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

(defn patch$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/patch
  
  Required parameters: proposalId, revisionNumber, updateAction
  
  Optional parameters: none
  
  Body: 
  
  {:hasBuyerSignedOff boolean,
   :labels [{:accountId string,
             :createTimeMs string,
             :deprecatedMarketplaceDealParty MarketplaceDealParty,
             :label string}],
   :isSetupComplete boolean,
   :billedBuyer {:accountId string},
   :revisionNumber string,
   :name string,
   :originatorRole string,
   :negotiationId string,
   :dbmAdvertiserIds [string],
   :proposalState string,
   :kind string,
   :lastUpdaterOrCommentorRole string,
   :inventorySource string,
   :buyerPrivateData {:referenceId string, :referencePayload string},
   :buyerContacts [{:email string, :name string}],
   :proposalId string,
   :hasSellerSignedOff boolean,
   :revisionTimeMs string,
   :buyer {:accountId string},
   :sellerContacts [{:email string, :name string}],
   :privateAuctionId string,
   :seller {:accountId string, :subAccountId string},
   :isRenegotiating boolean}
  
  Update the given proposal. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:revisionNumber :updateAction :proposalId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/{revisionNumber}/{updateAction}"
     #{:revisionNumber :updateAction :proposalId}
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

(defn search$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/search
  
  Required parameters: none
  
  Optional parameters: pqlQuery
  
  Search for proposals using pql query"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/search"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn setupcomplete$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/setupcomplete
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Update the given proposal to indicate that setup has been completed."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/setupcomplete"
     #{:proposalId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/proposals/update
  
  Required parameters: proposalId, revisionNumber, updateAction
  
  Optional parameters: none
  
  Body: 
  
  {:hasBuyerSignedOff boolean,
   :labels [{:accountId string,
             :createTimeMs string,
             :deprecatedMarketplaceDealParty MarketplaceDealParty,
             :label string}],
   :isSetupComplete boolean,
   :billedBuyer {:accountId string},
   :revisionNumber string,
   :name string,
   :originatorRole string,
   :negotiationId string,
   :dbmAdvertiserIds [string],
   :proposalState string,
   :kind string,
   :lastUpdaterOrCommentorRole string,
   :inventorySource string,
   :buyerPrivateData {:referenceId string, :referencePayload string},
   :buyerContacts [{:email string, :name string}],
   :proposalId string,
   :hasSellerSignedOff boolean,
   :revisionTimeMs string,
   :buyer {:accountId string},
   :sellerContacts [{:email string, :name string}],
   :privateAuctionId string,
   :seller {:accountId string, :subAccountId string},
   :isRenegotiating boolean}
  
  Update the given proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:revisionNumber :updateAction :proposalId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/{revisionNumber}/{updateAction}"
     #{:revisionNumber :updateAction :proposalId}
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
