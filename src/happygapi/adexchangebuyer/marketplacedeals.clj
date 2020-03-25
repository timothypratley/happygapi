(ns happygapi.adexchangebuyer.marketplacedeals
  "Ad Exchange Buyer API: marketplacedeals.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacedeals"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacedeals/delete
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:dealIds [string],
   :proposalRevisionNumber string,
   :updateAction string}
  
  Delete the specified deals from the proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/delete"
     #{:proposalId}
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

(defn insert$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacedeals/insert
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:deals [{:syndicationProduct string,
            :isSetupComplete boolean,
            :terms DealTerms,
            :flightEndTimeMs string,
            :name string,
            :creativePreApprovalPolicy string,
            :isRfpTemplate boolean,
            :productId string,
            :dealServingMetadata DealServingMetadata,
            :lastUpdateTimeMs string,
            :creativeSafeFrameCompatibility string,
            :programmaticCreativeSource string,
            :flightStartTimeMs string,
            :webPropertyCode string,
            :kind string,
            :sharedTargetings [SharedTargeting],
            :creationTimeMs string,
            :buyerPrivateData PrivateData,
            :externalDealId string,
            :inventoryDescription string,
            :proposalId string,
            :productRevisionNumber string,
            :deliveryControl DeliveryControl,
            :sellerContacts [ContactInformation],
            :dealId string}],
   :proposalRevisionNumber string,
   :updateAction string}
  
  Add new deals for the specified proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/insert"
     #{:proposalId}
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

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacedeals/list
  
  Required parameters: proposalId
  
  Optional parameters: pqlQuery
  
  List all the deals for a given proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals"
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
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacedeals/update
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:deals [{:syndicationProduct string,
            :isSetupComplete boolean,
            :terms DealTerms,
            :flightEndTimeMs string,
            :name string,
            :creativePreApprovalPolicy string,
            :isRfpTemplate boolean,
            :productId string,
            :dealServingMetadata DealServingMetadata,
            :lastUpdateTimeMs string,
            :creativeSafeFrameCompatibility string,
            :programmaticCreativeSource string,
            :flightStartTimeMs string,
            :webPropertyCode string,
            :kind string,
            :sharedTargetings [SharedTargeting],
            :creationTimeMs string,
            :buyerPrivateData PrivateData,
            :externalDealId string,
            :inventoryDescription string,
            :proposalId string,
            :productRevisionNumber string,
            :deliveryControl DeliveryControl,
            :sellerContacts [ContactInformation],
            :dealId string}],
   :proposal {:hasBuyerSignedOff boolean,
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
              :isRenegotiating boolean},
   :proposalRevisionNumber string,
   :updateAction string}
  
  Replaces all the deals in the proposal with the passed in deals"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/deals/update"
     #{:proposalId}
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
