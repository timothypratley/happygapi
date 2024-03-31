(ns happygapi.adexchangebuyer2.accounts
  "Ad Exchange Buyer API II: accounts.
  Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
  See: https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn creatives-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/create
  
  Required parameters: accountId
  
  Optional parameters: duplicateIdMode
  
  Body: 
  
  {:video {:videoUrl string, :videoVastXml string},
   :detectedProductCategories [integer],
   :servingRestrictions [{:status string,
                          :contexts [ServingContext],
                          :disapprovalReasons [Disapproval],
                          :disapproval Disapproval}],
   :declaredClickThroughUrls [string],
   :advertiserName string,
   :adTechnologyProviders {:detectedProviderIds [string],
                           :hasUnidentifiedProvider boolean},
   :adChoicesDestinationUrl string,
   :impressionTrackingUrls [string],
   :dealsStatus string,
   :apiUpdateTime string,
   :detectedSensitiveCategories [integer],
   :openAuctionStatus string,
   :restrictedCategories [string],
   :corrections [{:type string,
                  :details [string],
                  :contexts [ServingContext]}],
   :detectedDomains [string],
   :detectedLanguages [string],
   :creativeId string,
   :native {:clickLinkUrl string,
            :headline string,
            :starRating number,
            :storeUrl string,
            :logo Image,
            :advertiserName string,
            :appIcon Image,
            :priceDisplayText string,
            :callToAction string,
            :clickTrackingUrl string,
            :videoUrl string,
            :image Image,
            :body string},
   :detectedAdvertiserIds [string],
   :vendorIds [integer],
   :agencyId string,
   :version integer,
   :attributes [string],
   :accountId string,
   :clickThroughUrls [string],
   :html {:snippet string, :width integer, :height integer}}
  
  Creates a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives"
     #{:accountId}
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

(defn creatives-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/update
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:video {:videoUrl string, :videoVastXml string},
   :detectedProductCategories [integer],
   :servingRestrictions [{:status string,
                          :contexts [ServingContext],
                          :disapprovalReasons [Disapproval],
                          :disapproval Disapproval}],
   :declaredClickThroughUrls [string],
   :advertiserName string,
   :adTechnologyProviders {:detectedProviderIds [string],
                           :hasUnidentifiedProvider boolean},
   :adChoicesDestinationUrl string,
   :impressionTrackingUrls [string],
   :dealsStatus string,
   :apiUpdateTime string,
   :detectedSensitiveCategories [integer],
   :openAuctionStatus string,
   :restrictedCategories [string],
   :corrections [{:type string,
                  :details [string],
                  :contexts [ServingContext]}],
   :detectedDomains [string],
   :detectedLanguages [string],
   :creativeId string,
   :native {:clickLinkUrl string,
            :headline string,
            :starRating number,
            :storeUrl string,
            :logo Image,
            :advertiserName string,
            :appIcon Image,
            :priceDisplayText string,
            :callToAction string,
            :clickTrackingUrl string,
            :videoUrl string,
            :image Image,
            :body string},
   :detectedAdvertiserIds [string],
   :vendorIds [integer],
   :agencyId string,
   :version integer,
   :attributes [string],
   :accountId string,
   :clickThroughUrls [string],
   :html {:snippet string, :width integer, :height integer}}
  
  Updates a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}"
     #{:creativeId :accountId}
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

(defn creatives-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/get
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Gets a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}"
     #{:creativeId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/list
  
  Required parameters: accountId
  
  Optional parameters: pageSize, pageToken, query
  
  Lists creatives."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn creatives-watch$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/watch
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:topic string}
  
  Watches a creative. Will result in push notifications being sent to the topic when the creative changes status."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}:watch"
     #{:creativeId :accountId}
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

(defn creatives-stopWatching$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/stopWatching
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Stops watching a creative. Will stop push notifications being sent to the topics when the creative changes status."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}:stopWatching"
     #{:creativeId :accountId}
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

(defn creatives-dealAssociations-add$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/dealAssociations/add
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:association {:accountId string, :creativeId string, :dealsId string}}
  
  Associate an existing deal with a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:add"
     #{:creativeId :accountId}
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

(defn creatives-dealAssociations-remove$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/dealAssociations/remove
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:association {:accountId string, :creativeId string, :dealsId string}}
  
  Remove the association between a deal and a creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations:remove"
     #{:creativeId :accountId}
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

(defn creatives-dealAssociations-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/dealAssociations/list
  
  Required parameters: accountId, creativeId
  
  Optional parameters: pageSize, pageToken, query
  
  List all creative-deal associations."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:creativeId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/creatives/{creativeId}/dealAssociations"
     #{:creativeId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/get
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Gets a client buyer with a given client account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:clientAccountId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}"
     #{:clientAccountId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/list
  
  Required parameters: accountId
  
  Optional parameters: pageSize, pageToken, partnerClientId
  
  Lists all the clients for the current sponsor buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:role string,
   :entityName string,
   :partnerClientId string,
   :clientAccountId string,
   :visibleToSeller boolean,
   :status string,
   :entityId string,
   :entityType string,
   :clientName string}
  
  Creates a new client buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients"
     #{:accountId}
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

(defn clients-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/update
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Body: 
  
  {:role string,
   :entityName string,
   :partnerClientId string,
   :clientAccountId string,
   :visibleToSeller boolean,
   :status string,
   :entityId string,
   :entityType string,
   :clientName string}
  
  Updates an existing client buyer."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:clientAccountId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}"
     #{:clientAccountId :accountId}
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

(defn clients-users-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/list
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: pageSize, pageToken
  
  Lists all the known client users for a specified sponsor buyer account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:clientAccountId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users"
     #{:clientAccountId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-users-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/update
  
  Required parameters: accountId, clientAccountId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:userId string,
   :clientAccountId string,
   :status string,
   :email string}
  
  Updates an existing client user. Only the user status can be changed on update."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:clientAccountId :userId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}"
     #{:clientAccountId :userId :accountId}
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
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/get
  
  Required parameters: accountId, clientAccountId, userId
  
  Optional parameters: none
  
  Retrieves an existing client user."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:clientAccountId :userId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/users/{userId}"
     #{:clientAccountId :userId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-invitations-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/create
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Body: 
  
  {:invitationId string, :email string, :clientAccountId string}
  
  Creates and sends out an email invitation to access an Ad Exchange client buyer account."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:clientAccountId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations"
     #{:clientAccountId :accountId}
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

(defn clients-invitations-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/get
  
  Required parameters: accountId, clientAccountId, invitationId
  
  Optional parameters: none
  
  Retrieves an existing client user invitation."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:clientAccountId :invitationId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations/{invitationId}"
     #{:clientAccountId :invitationId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn clients-invitations-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/list
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: pageSize, pageToken
  
  Lists all the client users invitations for a client with a given account ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:clientAccountId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/clients/{clientAccountId}/invitations"
     #{:clientAccountId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/get
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Gets a proposal given its ID. The proposal is returned at its head revision."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}"
     #{:proposalId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:isSetupComplete boolean,
   :displayName string,
   :billedBuyer {:accountId string},
   :proposalRevision string,
   :originatorRole string,
   :updateTime string,
   :proposalState string,
   :notes [{:proposalRevision string,
            :noteId string,
            :createTime string,
            :creatorRole string,
            :note string}],
   :termsAndConditions string,
   :lastUpdaterOrCommentorRole string,
   :deals [{:syndicationProduct string,
            :description string,
            :createProductRevision string,
            :isSetupComplete boolean,
            :displayName string,
            :creativePreApprovalPolicy string,
            :createTime string,
            :targetingCriterion [TargetingCriteria],
            :dealServingMetadata DealServingMetadata,
            :updateTime string,
            :creativeSafeFrameCompatibility string,
            :programmaticCreativeSource string,
            :webPropertyCode string,
            :createProductId string,
            :buyerPrivateData PrivateData,
            :externalDealId string,
            :creativeRestrictions CreativeRestrictions,
            :proposalId string,
            :deliveryControl DeliveryControl,
            :availableStartTime string,
            :sellerContacts [ContactInformation],
            :dealTerms DealTerms,
            :dealId string,
            :targeting MarketplaceTargeting,
            :availableEndTime string}],
   :buyerPrivateData {:referenceId string},
   :buyerContacts [{:email string, :name string}],
   :proposalId string,
   :buyer {:accountId string},
   :sellerContacts [{:email string, :name string}],
   :privateAuctionId string,
   :seller {:accountId string, :subAccountId string},
   :isRenegotiating boolean}
  
  Create the given proposal. Each created proposal and any deals it contains are assigned a unique ID by the server."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals"
     #{:accountId}
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

(defn proposals-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/update
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:isSetupComplete boolean,
   :displayName string,
   :billedBuyer {:accountId string},
   :proposalRevision string,
   :originatorRole string,
   :updateTime string,
   :proposalState string,
   :notes [{:proposalRevision string,
            :noteId string,
            :createTime string,
            :creatorRole string,
            :note string}],
   :termsAndConditions string,
   :lastUpdaterOrCommentorRole string,
   :deals [{:syndicationProduct string,
            :description string,
            :createProductRevision string,
            :isSetupComplete boolean,
            :displayName string,
            :creativePreApprovalPolicy string,
            :createTime string,
            :targetingCriterion [TargetingCriteria],
            :dealServingMetadata DealServingMetadata,
            :updateTime string,
            :creativeSafeFrameCompatibility string,
            :programmaticCreativeSource string,
            :webPropertyCode string,
            :createProductId string,
            :buyerPrivateData PrivateData,
            :externalDealId string,
            :creativeRestrictions CreativeRestrictions,
            :proposalId string,
            :deliveryControl DeliveryControl,
            :availableStartTime string,
            :sellerContacts [ContactInformation],
            :dealTerms DealTerms,
            :dealId string,
            :targeting MarketplaceTargeting,
            :availableEndTime string}],
   :buyerPrivateData {:referenceId string},
   :buyerContacts [{:email string, :name string}],
   :proposalId string,
   :buyer {:accountId string},
   :sellerContacts [{:email string, :name string}],
   :privateAuctionId string,
   :seller {:accountId string, :subAccountId string},
   :isRenegotiating boolean}
  
  Update the given proposal at the client known revision number. If the server revision has advanced since the passed-in `proposal.proposal_revision`, an `ABORTED` error message will be returned. Only the buyer-modifiable fields of the proposal will be updated. Note that the deals in the proposal will be updated to match the passed-in copy. If a passed-in deal does not have a `deal_id`, the server will assign a new unique ID and create the deal. If passed-in deal has a `deal_id`, it will be updated to match the passed-in copy. Any existing deals not present in the passed-in proposal will be deleted. It is an error to pass in a deal with a `deal_id` not present at head."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}"
     #{:proposalId :accountId}
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

(defn proposals-completeSetup$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/completeSetup
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  You can opt-in to manually update proposals to indicate that setup is complete. By default, proposal setup is automatically completed after their deals are finalized. Contact your Technical Account Manager to opt in. Buyers can call this method when the proposal has been finalized, and all the required creatives have been uploaded using the Creatives API. This call updates the `is_setup_completed` field on the deals in the proposal, and notifies the seller. The server then advances the revision number of the most recent proposal. To mark an individual deal as ready to serve, call `buyers.finalizedDeals.setReadyToServe` in the Marketplace API."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:completeSetup"
     #{:proposalId :accountId}
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
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/list
  
  Required parameters: accountId
  
  Optional parameters: filter, pageSize, pageToken, filterSyntax
  
  List proposals. A filter expression (PQL query) may be specified to filter the results. To retrieve all finalized proposals, regardless if a proposal is being renegotiated, see the FinalizedProposals resource. Note that Bidder/ChildSeat relationships differ from the usual behavior. A Bidder account can only see its child seats' proposals by specifying the ChildSeat's accountId in the request path."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn proposals-addNote$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/addNote
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:note {:proposalRevision string,
          :noteId string,
          :createTime string,
          :creatorRole string,
          :note string}}
  
  Create a new note and attach it to the proposal. The note is assigned a unique ID by the server. The proposal revision number will not increase when associated with a new note."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:addNote"
     #{:proposalId :accountId}
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

(defn proposals-cancelNegotiation$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/cancelNegotiation
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Cancel an ongoing negotiation on a proposal. This does not cancel or end serving for the deals if the proposal has been finalized, but only cancels a negotiation unilaterally."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:cancelNegotiation"
     #{:proposalId :accountId}
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

(defn proposals-pause$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/pause
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:reason string}
  
  Update the given proposal to pause serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to true for all deals in the proposal. It is a no-op to pause an already-paused proposal. It is an error to call PauseProposal for a proposal that is not finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:pause"
     #{:proposalId :accountId}
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

(defn proposals-resume$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/resume
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Update the given proposal to resume serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to false for all deals in the proposal. Note that if the `has_seller_paused` bit is also set, serving will not resume until the seller also resumes. It is a no-op to resume an already-running proposal. It is an error to call ResumeProposal for a proposal that is not finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:resume"
     #{:proposalId :accountId}
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
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/proposals/accept
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:proposalRevision string}
  
  Mark the proposal as accepted at the given revision number. If the number does not match the server's revision number an `ABORTED` error message will be returned. This call updates the proposal_state from `PROPOSED` to `BUYER_ACCEPTED`, or from `SELLER_ACCEPTED` to `FINALIZED`. Upon calling this endpoint, the buyer implicitly agrees to the terms and conditions optionally set within the proposal by the publisher."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/proposals/{proposalId}:accept"
     #{:proposalId :accountId}
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

(defn finalizedProposals-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/finalizedProposals/list
  
  Required parameters: accountId
  
  Optional parameters: filter, pageSize, pageToken, filterSyntax
  
  List finalized proposals, regardless if a proposal is being renegotiated. A filter expression (PQL query) may be specified to filter the results. The notes will not be returned."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/finalizedProposals"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn finalizedProposals-pause$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/finalizedProposals/pause
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:externalDealIds [string], :reason string}
  
  Update given deals to pause serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to true for all listed deals in the request. Currently, this method only applies to PG and PD deals. For PA deals, call accounts.proposals.pause endpoint. It is a no-op to pause already-paused deals. It is an error to call PauseProposalDeals for deals which are not part of the proposal of proposal_id or which are not finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/finalizedProposals/{proposalId}:pause"
     #{:proposalId :accountId}
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

(defn finalizedProposals-resume$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/finalizedProposals/resume
  
  Required parameters: accountId, proposalId
  
  Optional parameters: none
  
  Body: 
  
  {:externalDealIds [string]}
  
  Update given deals to resume serving. This method will set the `DealServingMetadata.DealPauseStatus.has_buyer_paused` bit to false for all listed deals in the request. Currently, this method only applies to PG and PD deals. For PA deals, call accounts.proposals.resume endpoint. It is a no-op to resume running deals or deals paused by the other party. It is an error to call ResumeProposalDeals for deals which are not part of the proposal of proposal_id or which are not finalized or renegotiating."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:proposalId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/finalizedProposals/{proposalId}:resume"
     #{:proposalId :accountId}
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

(defn products-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/products/get
  
  Required parameters: accountId, productId
  
  Optional parameters: none
  
  Gets the requested product by ID."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/products/{productId}"
     #{:productId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn products-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/products/list
  
  Required parameters: accountId
  
  Optional parameters: filter, pageSize, pageToken
  
  List all products visible to the buyer (optionally filtered by the specified PQL query)."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/products"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/publisherProfiles/get
  
  Required parameters: accountId, publisherProfileId
  
  Optional parameters: none
  
  Gets the requested publisher profile by id."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:publisherProfileId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/publisherProfiles/{publisherProfileId}"
     #{:publisherProfileId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn publisherProfiles-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/publisherProfiles/list
  
  Required parameters: accountId
  
  Optional parameters: pageSize, pageToken
  
  List all publisher profiles visible to the buyer"
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://adexchangebuyer.googleapis.com/"
     "v2beta1/accounts/{accountId}/publisherProfiles"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
