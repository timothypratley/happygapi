(ns happygapi.adexchangebuyer.marketplacenotes
  "Ad Exchange Buyer API: marketplacenotes.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacenotes"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacenotes/insert
  
  Required parameters: proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:notes [{:creatorRole string,
            :dealId string,
            :kind string,
            :note string,
            :noteId string,
            :proposalId string,
            :proposalRevisionNumber string,
            :timestampMs string}]}
  
  Add notes to the proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:proposalId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/notes/insert"
     #{:proposalId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/marketplacenotes/list
  
  Required parameters: proposalId
  
  Optional parameters: pqlQuery
  Get all the notes associated with a proposal"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{:proposalId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "proposals/{proposalId}/notes"
     #{:proposalId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
