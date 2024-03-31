(ns happygapi.authorizedbuyersmarketplace.buyers
  "Authorized Buyers Marketplace API: buyers.
  The Authorized Buyers Marketplace API lets buyers programmatically discover inventory; propose, retrieve and negotiate deals with publishers.
  See: https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn auctionPackages-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an auction package given its name."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn auctionPackages-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List the auction packages subscribed by a buyer and its clients."
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

(defn auctionPackages-subscribe$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/subscribe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Subscribe to the auction package for the specified buyer. Once subscribed, the bidder will receive a call out for inventory matching the auction package targeting criteria with the auction package deal ID and the specified buyer."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:subscribe"
     #{:name}
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

(defn auctionPackages-unsubscribe$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/unsubscribe
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Unsubscribe from the auction package for the specified buyer. Once unsubscribed, the bidder will no longer receive a call out for the auction package deal ID and the specified buyer."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:unsubscribe"
     #{:name}
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

(defn auctionPackages-subscribeClients$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/subscribeClients
  
  Required parameters: auctionPackage
  
  Optional parameters: none
  
  Body: 
  
  {:clients [string]}
  
  Subscribe the specified clients of the buyer to the auction package. If a client in the list does not belong to the buyer, an error response will be returned, and all of the following clients in the list will not be subscribed. Subscribing an already subscribed client will have no effect."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:auctionPackage})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+auctionPackage}:subscribeClients"
     #{:auctionPackage}
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

(defn auctionPackages-unsubscribeClients$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/auctionPackages/unsubscribeClients
  
  Required parameters: auctionPackage
  
  Optional parameters: none
  
  Body: 
  
  {:clients [string]}
  
  Unsubscribe from the auction package for the specified clients of the buyer. Unsubscribing a client that is not subscribed will have no effect."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:auctionPackage})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+auctionPackage}:unsubscribeClients"
     #{:auctionPackage}
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

(defn clients-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a client with a given resource name."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists all the clients for the current buyer."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/clients"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-create$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :role string,
   :state string,
   :displayName string,
   :sellerVisible boolean,
   :partnerClientId string}
  
  Creates a new client."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/clients"
     #{:parent}
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

(defn clients-patch$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:name string,
   :role string,
   :state string,
   :displayName string,
   :sellerVisible boolean,
   :partnerClientId string}
  
  Updates an existing client."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn clients-activate$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activates an existing client. The state of the client will be updated to \"ACTIVE\". This method has no effect if the client is already in \"ACTIVE\" state."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:activate"
     #{:name}
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

(defn clients-deactivate$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/deactivate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deactivates an existing client. The state of the client will be updated to \"INACTIVE\". This method has no effect if the client is already in \"INACTIVE\" state."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:deactivate"
     #{:name}
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

(defn clients-users-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Retrieves an existing client user."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all client users for a specified client."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/users"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-create$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/create
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:name string, :state string, :email string}
  
  Creates a new client user in \"INVITED\" state. An email invitation will be sent to the new user, once accepted the user will become active."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/users"
     #{:parent}
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

(defn clients-users-delete$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/delete
  
  Required parameters: name
  
  Optional parameters: none
  
  Deletes an existing client user. The client user will lose access to the Authorized Buyers UI. Note that if a client user is deleted, the user's access to the UI can't be restored unless a new client user is created and activated."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-activate$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/activate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Activates an existing client user. The state of the client user will be updated from \"INACTIVE\" to \"ACTIVE\". This method has no effect if the client user is already in \"ACTIVE\" state. An error will be returned if the client user to activate is still in \"INVITED\" state."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:activate"
     #{:name}
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

(defn clients-users-deactivate$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/clients/users/deactivate
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Deactivates an existing client user. The state of the client user will be updated from \"ACTIVE\" to \"INACTIVE\". This method has no effect if the client user is already in \"INACTIVE\" state. An error will be returned if the client user to deactivate is still in \"INVITED\" state."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:deactivate"
     #{:name}
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

(defn finalizedDeals-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a finalized deal given its name."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn finalizedDeals-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/list
  
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

(defn finalizedDeals-pause$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/pause
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:reason string}
  
  Pauses serving of the given finalized deal. This call only pauses the serving status, and does not affect other fields of the finalized deal. Calling this method for an already paused deal has no effect. This method only applies to programmatic guaranteed deals."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:pause"
     #{:name}
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

(defn finalizedDeals-resume$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/resume
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Resumes serving of the given finalized deal. Calling this method for an running deal has no effect. If a deal is initially paused by the seller, calling this method will not resume serving of the deal until the seller also resumes the deal. This method only applies to programmatic guaranteed deals."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:resume"
     #{:name}
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

(defn finalizedDeals-addCreative$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/addCreative
  
  Required parameters: deal
  
  Optional parameters: none
  
  Body: 
  
  {:creative string}
  
  Add creative to be used in the bidding process for a finalized deal. For programmatic guaranteed deals, it's recommended that you associate at least one approved creative with the deal before calling SetReadyToServe, to help reduce the number of bid responses filtered because they don't contain approved creatives. Creatives successfully added to a deal can be found in the Realtime-bidding Creatives API creative.deal_ids. This method only applies to programmatic guaranteed deals. Maximum number of 1000 creatives can be added to a finalized deal."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:deal})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+deal}:addCreative"
     #{:deal}
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

(defn finalizedDeals-setReadyToServe$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/finalizedDeals/setReadyToServe
  
  Required parameters: deal
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Sets the given finalized deal as ready to serve. By default, deals are set as ready to serve as soon as they're finalized. If you want to opt out of the default behavior, and manually indicate that deals are ready to serve, ask your Technical Account Manager to add you to the allowlist. If you choose to use this method, finalized deals belonging to the bidder and its child seats don't start serving until after you call `setReadyToServe`, and after the deals become active. For example, you can use this method to delay receiving bid requests until your creative is ready. This method only applies to programmatic guaranteed deals."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:deal})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+deal}:setReadyToServe"
     #{:deal}
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

(defn proposals-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a proposal using its resource name. The proposal is returned at the latest revision."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-patch$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:displayName string,
   :billedBuyer string,
   :proposalRevision string,
   :name string,
   :client string,
   :originatorRole string,
   :state string,
   :dealType string,
   :publisherProfile string,
   :updateTime string,
   :pausingConsented boolean,
   :notes [{:createTime string, :creatorRole string, :note string}],
   :termsAndConditions string,
   :lastUpdaterOrCommentorRole string,
   :buyerPrivateData {:referenceId string},
   :buyerContacts [{:email string, :displayName string}],
   :buyer string,
   :sellerContacts [{:email string, :displayName string}],
   :isRenegotiating boolean}
  
  Updates the proposal at the given revision number. If the revision number in the request is behind the latest one kept in the server, an error message will be returned. See FieldMask for how to use FieldMask. Only fields specified in the UpdateProposalRequest.update_mask will be updated; Fields noted as 'Immutable' or 'Output only' yet specified in the UpdateProposalRequest.update_mask will be ignored and left unchanged. Updating a private auction proposal is not allowed and will result in an error."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn proposals-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/list
  
  Required parameters: parent
  
  Optional parameters: filter, pageSize, pageToken
  
  Lists proposals. A filter expression using [Cloud API list filtering syntax](https://developers.google.com/authorized-buyers/apis/guides/list-filters) may be specified to filter the results."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/proposals"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-cancelNegotiation$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/cancelNegotiation
  
  Required parameters: proposal
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancels an ongoing negotiation on a proposal. This does not cancel or end serving for the deals if the proposal has been finalized. If the proposal has not been finalized before, calling this method will set the Proposal.state to `TERMINATED` and increment the Proposal.proposal_revision. If the proposal has been finalized before and is under renegotiation now, calling this method will reset the Proposal.state to `FINALIZED` and increment the Proposal.proposal_revision. This method does not support private auction proposals whose Proposal.deal_type is 'PRIVATE_AUCTION'."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposal})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+proposal}:cancelNegotiation"
     #{:proposal}
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

(defn proposals-accept$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/accept
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:proposalRevision string}
  
  Accepts the proposal at the given revision number. If the revision number in the request is behind the latest from the server, an error message will be returned. This call updates the Proposal.state from `BUYER_ACCEPTANCE_REQUESTED` to `FINALIZED`; it has no side effect if the Proposal.state is already `FINALIZED` and throws exception if the Proposal.state is not either `BUYER_ACCEPTANCE_REQUESTED` or `FINALIZED`. Accepting a proposal means the buyer understands and accepts the Proposal.terms_and_conditions proposed by the seller."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}:accept"
     #{:name}
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

(defn proposals-addNote$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/addNote
  
  Required parameters: proposal
  
  Optional parameters: none
  
  Body: 
  
  {:note {:createTime string, :creatorRole string, :note string}}
  
  Creates a note for this proposal and sends to the seller."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposal})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+proposal}:addNote"
     #{:proposal}
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

(defn proposals-sendRfp$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/sendRfp
  
  Required parameters: buyer
  
  Optional parameters: none
  
  Body: 
  
  {:flightStartTime string,
   :geoTargeting {:targetedCriteriaIds [string],
                  :excludedCriteriaIds [string]},
   :preferredDealTerms {:fixedPrice Price},
   :displayName string,
   :estimatedGrossSpend {:currencyCode string,
                         :units string,
                         :nanos integer},
   :client string,
   :programmaticGuaranteedTerms {:guaranteedLooks string,
                                 :fixedPrice Price,
                                 :minimumDailyLooks string,
                                 :reservationType string,
                                 :impressionCap string,
                                 :percentShareOfVoice string},
   :publisherProfile string,
   :note string,
   :buyerContacts [{:email string, :displayName string}],
   :flightEndTime string,
   :inventorySizeTargeting {:targetedInventorySizes [AdSize],
                            :excludedInventorySizes [AdSize]}}
  
  Sends a request for proposal (RFP) to a publisher to initiate the negotiation regarding certain inventory. In the RFP, buyers can specify the deal type, deal terms, start and end dates, targeting, and a message to the publisher. Once the RFP is sent, a proposal in `SELLER_REVIEW_REQUESTED` state will be created and returned in the response. The publisher may review your request and respond with detailed deals in the proposal."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:buyer})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+buyer}/proposals:sendRfp"
     #{:buyer}
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

(defn proposals-deals-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/deals/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets a deal given its name. The deal is returned at its head revision."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-deals-patch$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/deals/patch
  
  Required parameters: name
  
  Optional parameters: updateMask
  
  Body: 
  
  {:description string,
   :flightStartTime string,
   :sellerTimeZone {:id string, :version string},
   :preferredDealTerms {:fixedPrice Price},
   :displayName string,
   :billedBuyer string,
   :proposalRevision string,
   :name string,
   :estimatedGrossSpend {:currencyCode string,
                         :units string,
                         :nanos integer},
   :client string,
   :createTime string,
   :mediaPlanner {:accountId string},
   :dealType string,
   :programmaticGuaranteedTerms {:guaranteedLooks string,
                                 :fixedPrice Price,
                                 :minimumDailyLooks string,
                                 :reservationType string,
                                 :impressionCap string,
                                 :percentShareOfVoice string},
   :publisherProfile string,
   :updateTime string,
   :eligibleSeatIds [string],
   :privateAuctionTerms {:floorPrice Price, :openAuctionAllowed boolean},
   :creativeRequirements {:creativePreApprovalPolicy string,
                          :creativeSafeFrameCompatibility string,
                          :programmaticCreativeSource string,
                          :creativeFormat string,
                          :skippableAdType string,
                          :maxAdDurationMs string},
   :buyer string,
   :flightEndTime string,
   :deliveryControl {:deliveryRateType string,
                     :frequencyCap [FrequencyCap],
                     :roadblockingType string,
                     :companionDeliveryType string,
                     :creativeRotationType string},
   :targeting {:geoTargeting CriteriaTargeting,
               :inventorySizeTargeting InventorySizeTargeting,
               :technologyTargeting TechnologyTargeting,
               :placementTargeting PlacementTargeting,
               :videoTargeting VideoTargeting,
               :userListTargeting CriteriaTargeting,
               :daypartTargeting DayPartTargeting,
               :inventoryTypeTargeting InventoryTypeTargeting}}
  
  Updates the given deal at the buyer known revision number. If the server revision has advanced since the passed-in proposal.proposal_revision an ABORTED error message will be returned. The revision number is incremented by the server whenever the proposal or its constituent deals are updated. Note: The revision number is kept at a proposal level. The buyer of the API is expected to keep track of the revision number after the last update operation and send it in as part of the next update request. This way, if there are further changes on the server (for example, seller making new updates), then the server can detect conflicts and reject the proposed changes."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
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

(defn proposals-deals-batchUpdate$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/deals/batchUpdate
  
  Required parameters: parent
  
  Optional parameters: none
  
  Body: 
  
  {:requests [{:deal Deal, :updateMask string}]}
  
  Batch updates multiple deals in the same proposal."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/deals:batchUpdate"
     #{:parent}
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

(defn proposals-deals-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/proposals/deals/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  Lists all deals in a proposal. To retrieve only the finalized revision deals regardless if a deal is being renegotiated, see the FinalizedDeals resource."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/deals"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-get$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/publisherProfiles/get
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the requested publisher profile by name."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-list$
  "https://developers.google.com/authorized-buyers/apis/marketplace/reference/rest/api/reference/rest/v1/buyers/publisherProfiles/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken, filter
  
  Lists publisher profiles. The returned publisher profiles aren't in any defined order. The order of the results might change. A new publisher profile can appear in any place in the list of returned results."
  {:scopes ["https://www.googleapis.com/auth/authorized-buyers-marketplace"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://authorizedbuyersmarketplace.googleapis.com/"
     "v1/{+parent}/publisherProfiles"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
