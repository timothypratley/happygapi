(ns happygapi.adexchangebuyer2.accounts
  "Ad Exchange Buyer API II: accounts.
  Accesses the latest features for managing Authorized Buyers accounts, Real-Time Bidding configurations and auction metrics, and Marketplace programmatic deals.
  See: https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn creatives-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/update
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:video {:videoVastXml string, :videoUrl string},
   :detectedProductCategories [integer],
   :servingRestrictions [{:disapprovalReasons [Disapproval],
                          :contexts [ServingContext],
                          :disapproval Disapproval,
                          :status string}],
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
   :corrections [{:contexts [ServingContext],
                  :type string,
                  :details [string]}],
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
   :html {:height integer, :width integer, :snippet string}}
  
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

(defn creatives-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/create
  
  Required parameters: accountId
  
  Optional parameters: duplicateIdMode
  
  Body: 
  
  {:video {:videoVastXml string, :videoUrl string},
   :detectedProductCategories [integer],
   :servingRestrictions [{:disapprovalReasons [Disapproval],
                          :contexts [ServingContext],
                          :disapproval Disapproval,
                          :status string}],
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
   :corrections [{:contexts [ServingContext],
                  :type string,
                  :details [string]}],
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
   :html {:height integer, :width integer, :snippet string}}
  
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

(defn creatives-stopWatching$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/stopWatching
  
  Required parameters: creativeId, accountId
  
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

(defn creatives-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/get
  
  Required parameters: creativeId, accountId
  
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

(defn creatives-dealAssociations-remove$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/dealAssociations/remove
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:association {:accountId string, :dealsId string, :creativeId string}}
  
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

(defn creatives-dealAssociations-add$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/creatives/dealAssociations/add
  
  Required parameters: accountId, creativeId
  
  Optional parameters: none
  
  Body: 
  
  {:association {:accountId string, :dealsId string, :creativeId string}}
  
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

(defn finalizedProposals-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/finalizedProposals/list
  
  Required parameters: accountId
  
  Optional parameters: filterSyntax, pageToken, filter, pageSize
  
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

(defn products-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/products/list
  
  Required parameters: accountId
  
  Optional parameters: pageToken, pageSize, filter
  
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

(defn products-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/products/get
  
  Required parameters: productId, accountId
  
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
  
  Required parameters: clientAccountId, accountId
  
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

(defn clients-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/list
  
  Required parameters: accountId
  
  Optional parameters: pageToken, partnerClientId, pageSize
  
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

(defn clients-invitations-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/get
  
  Required parameters: accountId, invitationId, clientAccountId
  
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

(defn clients-invitations-create$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/create
  
  Required parameters: accountId, clientAccountId
  
  Optional parameters: none
  
  Body: 
  
  {:email string, :invitationId string, :clientAccountId string}
  
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

(defn clients-invitations-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/invitations/list
  
  Required parameters: clientAccountId, accountId
  
  Optional parameters: pageToken, pageSize
  
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

(defn clients-users-update$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/update
  
  Required parameters: clientAccountId, accountId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:clientAccountId string,
   :userId string,
   :email string,
   :status string}
  
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

(defn clients-users-list$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/list
  
  Required parameters: clientAccountId, accountId
  
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

(defn clients-users-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/clients/users/get
  
  Required parameters: accountId, userId, clientAccountId
  
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
   :notes [{:note string,
            :noteId string,
            :creatorRole string,
            :createTime string,
            :proposalRevision string}],
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
   :buyerContacts [{:name string, :email string}],
   :proposalId string,
   :buyer {:accountId string},
   :sellerContacts [{:name string, :email string}],
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
  
  Required parameters: proposalId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:isSetupComplete boolean,
   :displayName string,
   :billedBuyer {:accountId string},
   :proposalRevision string,
   :originatorRole string,
   :updateTime string,
   :proposalState string,
   :notes [{:note string,
            :noteId string,
            :creatorRole string,
            :createTime string,
            :proposalRevision string}],
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
   :buyerContacts [{:name string, :email string}],
   :proposalId string,
   :buyer {:accountId string},
   :sellerContacts [{:name string, :email string}],
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
  
  Update the given proposal to indicate that setup has been completed. This method is called by the buyer when the line items have been created on their end for a finalized proposal and all the required creatives have been uploaded using the creatives API. This call updates the `is_setup_completed` bit on the proposal and also notifies the seller. The server will advance the revision number of the most recent proposal."
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
  
  Optional parameters: filter, pageToken, filterSyntax, pageSize
  
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
  
  Required parameters: proposalId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:note {:note string,
          :noteId string,
          :creatorRole string,
          :createTime string,
          :proposalRevision string}}
  
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
  
  Required parameters: proposalId, accountId
  
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
  
  Mark the proposal as accepted at the given revision number. If the number does not match the server's revision number an `ABORTED` error message will be returned. This call updates the proposal_state from `PROPOSED` to `BUYER_ACCEPTED`, or from `SELLER_ACCEPTED` to `FINALIZED`."
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

(defn publisherProfiles-get$
  "https://developers.google.com/authorized-buyers/apis/reference/rest/api/reference/rest/v2beta1/accounts/publisherProfiles/get
  
  Required parameters: publisherProfileId, accountId
  
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
