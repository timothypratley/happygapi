(ns happygapi.adexchangebuyer2.accounts
  "Ad Exchange Buyer API II
  Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
  See: https://developers.google.com/authorized-buyers/apis/reference/rest/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "adexchangebuyer2_schema.edn"))))

(defn proposals-get$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Gets a proposal given its ID. The proposal is returned at its head
  revision."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-create$
  "Required parameters: accountId
  
  Optional parameters: none
  
  Create the given proposal. Each created proposal and any deals it contains
  are assigned a unique ID by the server."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-update$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Update the given proposal at the client known revision number. If the
  server revision has advanced since the passed-in
  `proposal.proposal_revision`, an `ABORTED` error message will be returned.
  Only the buyer-modifiable fields of the proposal will be updated.
  
  Note that the deals in the proposal will be updated to match the passed-in
  copy.
  If a passed-in deal does not have a `deal_id`, the server will assign a new
  unique ID and create the deal.
  If passed-in deal has a `deal_id`, it will be updated to match the
  passed-in copy.
  Any existing deals not present in the passed-in proposal will be deleted.
  It is an error to pass in a deal with a `deal_id` not present at head."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-completeSetup$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Update the given proposal to indicate that setup has been completed.
  This method is called by the buyer when the line items have been created
  on their end for a finalized proposal and all the required creatives
  have been uploaded using the creatives API. This call updates the
  `is_setup_completed` bit on the proposal and also notifies the seller.
  The server will advance the revision number of the most recent proposal."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:completeSetup"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-list$
  "Required parameters: accountId
  
  Optional parameters: filterSyntax, filter, pageToken, pageSize
  
  List proposals. A filter expression (PQL query) may be specified to
  filter the results. To retrieve all finalized proposals, regardless if a
  proposal is being renegotiated, see the FinalizedProposals resource.
  Note that Bidder/ChildSeat relationships differ from the usual behavior.
  A Bidder account can only see its child seats' proposals by specifying
  the ChildSeat's accountId in the request path."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-addNote$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Create a new note and attach it to the proposal. The note is assigned
  a unique ID by the server.
  The proposal revision number will not increase when associated with a
  new note."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:addNote"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-cancelNegotiation$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Cancel an ongoing negotiation on a proposal. This does not cancel or end
  serving for the deals if the proposal has been finalized, but only cancels
  a negotiation unilaterally."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:cancelNegotiation"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-pause$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Update the given proposal to pause serving.
  This method will set the
  `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to true for all
  deals in the proposal.
  
  It is a no-op to pause an already-paused proposal.
  It is an error to call PauseProposal for a proposal that is not
  finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:pause"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-resume$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Update the given proposal to resume serving.
  This method will set the
  `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to false for all
  deals in the proposal.
  
  Note that if the `has_seller_paused` bit is also set, serving will not
  resume until the seller also resumes.
  
  It is a no-op to resume an already-running proposal.
  It is an error to call ResumeProposal for a proposal that is not
  finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:resume"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn proposals-accept$
  "Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Mark the proposal as accepted at the given revision number. If the number
  does not match the server's revision number an `ABORTED` error message will
  be returned. This call updates the proposal_state from `PROPOSED` to
  `BUYER_ACCEPTED`, or from `SELLER_ACCEPTED` to `FINALIZED`."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "proposalId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:accept"
     #{"accountId" "proposalId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn clients-get$
  "Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Gets a client buyer with a given client account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}"
     #{"accountId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-list$
  "Required parameters: accountId
  
  Optional parameters: pageToken, partnerClientId, pageSize
  
  Lists all the clients for the current sponsor buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-update$
  "Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Updates an existing client buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}"
     #{"accountId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-create$
  "Required parameters: accountId
  
  Optional parameters: none
  
  Creates a new client buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn clients-invitations-get$
  "Required parameters: accountId, clientAccountId, invitationId
  
  Optional parameters: none
  
  Retrieves an existing client user invitation."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "clientAccountId" "invitationId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations/{invitationId}"
     #{"accountId" "clientAccountId" "invitationId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-invitations-list$
  "Required parameters: accountId, clientAccountId
  
  Optional parameters: pageToken, pageSize
  
  Lists all the client users invitations for a client
  with a given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations"
     #{"accountId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-invitations-create$
  "Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Creates and sends out an email invitation to access
  an Ad Exchange client buyer account."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations"
     #{"accountId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn clients-users-list$
  "Required parameters: accountId, clientAccountId
  
  Optional parameters: pageToken, pageSize
  
  Lists all the known client users for a specified
  sponsor buyer account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users"
     #{"accountId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-get$
  "Required parameters: userId, accountId, clientAccountId
  
  Optional parameters: none
  
  Retrieves an existing client user."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "userId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}"
     #{"accountId" "userId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-update$
  "Required parameters: userId, accountId, clientAccountId
  
  Optional parameters: none
  
  Updates an existing client user.
  Only the user status can be changed on update."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"accountId" "userId" "clientAccountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}"
     #{"accountId" "userId" "clientAccountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-get$
  "Required parameters: accountId, publisherProfileId
  
  Optional parameters: none
  
  Gets the requested publisher profile by id."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "publisherProfileId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/publisherProfiles/{publisherProfileId}"
     #{"accountId" "publisherProfileId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-list$
  "Required parameters: accountId
  
  Optional parameters: pageSize, pageToken
  
  List all publisher profiles visible to the buyer"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/publisherProfiles"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-list$
  "Required parameters: accountId
  
  Optional parameters: pageToken, pageSize, query
  
  Lists creatives."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-create$
  "Required parameters: accountId
  
  Optional parameters: duplicateIdMode
  
  Creates a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn creatives-stopWatching$
  "Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Stops watching a creative. Will stop push notifications being sent to the
  topics when the creative changes status."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}:stopWatching"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn creatives-get$
  "Required parameters: creativeId, accountId
  
  Optional parameters: none
  
  Gets a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-watch$
  "Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Watches a creative. Will result in push notifications being sent to the
  topic when the creative changes status."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}:watch"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn creatives-update$
  "Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Updates a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-dealAssociations-list$
  "Required parameters: accountId, creativeId
  
  Optional parameters: pageToken, pageSize, query
  
  List all creative-deal associations."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-dealAssociations-add$
  "Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Associate an existing deal with a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:add"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn creatives-dealAssociations-remove$
  "Required parameters: creativeId, accountId
  
  Optional parameters: none
  
  Remove the association between a deal and a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"accountId" "creativeId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:remove"
     #{"accountId" "creativeId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body body}
     auth))))

(defn products-get$
  "Required parameters: accountId, productId
  
  Optional parameters: none
  
  Gets the requested product by ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId" "productId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/products/{productId}"
     #{"accountId" "productId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn products-list$
  "Required parameters: accountId
  
  Optional parameters: pageSize, filter, pageToken
  
  List all products visible to the buyer (optionally filtered by the
  specified PQL query)."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/products"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn finalizedProposals-list$
  "Required parameters: accountId
  
  Optional parameters: filterSyntax, filter, pageToken, pageSize
  
  List finalized proposals, regardless if a proposal is being renegotiated.
  A filter expression (PQL query) may be specified to filter the results.
  The notes will not be returned."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth args]
  {:pre [(util/has-keys? args #{"accountId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/finalizedProposals"
     #{"accountId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
