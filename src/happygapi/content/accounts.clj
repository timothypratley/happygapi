(ns happygapi.content.accounts
  "Content API for Shopping: accounts.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/get
  
  Required parameters: merchantId, accountId
  
  Optional parameters: view
  
  Retrieves a Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:businessIdentity {:blackOwned AccountIdentityType,
                      :womenOwned AccountIdentityType,
                      :veteranOwned AccountIdentityType,
                      :latinoOwned AccountIdentityType,
                      :smallBusiness AccountIdentityType,
                      :includeForPromotions boolean},
   :websiteUrl string,
   :labelIds [string],
   :name string,
   :adsLinks [{:adsId string, :status string}],
   :conversionSettings {:freeListingsAutoTaggingEnabled boolean},
   :automaticImprovements {:itemUpdates AccountItemUpdates,
                           :imageImprovements AccountImageImprovements,
                           :shippingImprovements AccountShippingImprovements},
   :businessInformation {:address AccountAddress,
                         :phoneNumber string,
                         :phoneVerificationStatus string,
                         :customerService AccountCustomerService,
                         :koreanBusinessRegistrationNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :cssId string,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:gmbEmail string,
                          :status string,
                          :gmbAccountId string},
   :automaticLabelIds [string],
   :users [{:emailAddress string,
            :admin boolean,
            :orderManager boolean,
            :paymentsManager boolean,
            :paymentsAnalyst boolean,
            :reportingManager boolean}],
   :accountManagement string}
  
  Creates a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts"
     #{:merchantId}
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

(defn authinfo$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/authinfo
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns information about the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/authinfo"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn claimwebsite$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/claimwebsite
  
  Required parameters: merchantId, accountId
  
  Optional parameters: overwrite
  
  Claims the website of a Merchant Center sub-account. Merchant accounts with approved third-party CSSs aren't required to claim a website."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/claimwebsite"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn updatelabels$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/updatelabels
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:labelIds [string]}
  
  Updates labels that are assigned to the Merchant Center account by CSS user."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/updatelabels"
     #{:accountId :merchantId}
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

(defn update$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/update
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:businessIdentity {:blackOwned AccountIdentityType,
                      :womenOwned AccountIdentityType,
                      :veteranOwned AccountIdentityType,
                      :latinoOwned AccountIdentityType,
                      :smallBusiness AccountIdentityType,
                      :includeForPromotions boolean},
   :websiteUrl string,
   :labelIds [string],
   :name string,
   :adsLinks [{:adsId string, :status string}],
   :conversionSettings {:freeListingsAutoTaggingEnabled boolean},
   :automaticImprovements {:itemUpdates AccountItemUpdates,
                           :imageImprovements AccountImageImprovements,
                           :shippingImprovements AccountShippingImprovements},
   :businessInformation {:address AccountAddress,
                         :phoneNumber string,
                         :phoneVerificationStatus string,
                         :customerService AccountCustomerService,
                         :koreanBusinessRegistrationNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :cssId string,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:gmbEmail string,
                          :status string,
                          :gmbAccountId string},
   :automaticLabelIds [string],
   :users [{:emailAddress string,
            :admin boolean,
            :orderManager boolean,
            :paymentsManager boolean,
            :paymentsAnalyst boolean,
            :reportingManager boolean}],
   :accountManagement string}
  
  Updates a Merchant Center account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}"
     #{:accountId :merchantId}
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/delete
  
  Required parameters: merchantId, accountId
  
  Optional parameters: force
  
  Deletes a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken, view, label, name
  
  Lists the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn link$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/link
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:action string,
   :linkedAccountId string,
   :linkType string,
   :services [string],
   :paymentServiceProviderLinkInfo {:externalAccountId string,
                                    :externalAccountBusinessCountry string},
   :eCommercePlatformLinkInfo {:externalAccountId string}}
  
  Performs an action on a link between two Merchant Center accounts, namely accountId and linkedAccountId."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/link"
     #{:accountId :merchantId}
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

(defn verifyphonenumber$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/verifyphonenumber
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:verificationId string,
   :verificationCode string,
   :phoneVerificationMethod string}
  
  Validates verification code to verify phone number for the account. If successful this will overwrite the value of `accounts.businessinformation.phoneNumber`. Only verified phone number will replace an existing verified phone number."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/verifyphonenumber"
     #{:accountId :merchantId}
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

(defn requestphoneverification$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/requestphoneverification
  
  Required parameters: merchantId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:phoneRegionCode string,
   :phoneNumber string,
   :phoneVerificationMethod string,
   :languageCode string}
  
  Request verification code to start phone verification."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/requestphoneverification"
     #{:accountId :merchantId}
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

(defn listlinks$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/listlinks
  
  Required parameters: merchantId, accountId
  
  Optional parameters: maxResults, pageToken
  
  Returns the list of accounts linked to your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/accounts/{accountId}/listlinks"
     #{:accountId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:force boolean,
              :method string,
              :labelIds [string],
              :linkRequest AccountsCustomBatchRequestEntryLinkRequest,
              :account Account,
              :overwrite boolean,
              :batchId integer,
              :accountId string,
              :merchantId string,
              :view string}]}
  
  Retrieves, inserts, updates, and deletes multiple Merchant Center (sub-)accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/batch"
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

(defn credentials-create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/credentials/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:purpose string, :accessToken string, :expiresIn string}
  
  Uploads credentials for the Merchant Center account. If credentials already exist for this Merchant Center account and purpose, this method updates them."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/credentials"
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

(defn labels-list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/list
  
  Required parameters: accountId
  
  Optional parameters: pageSize, pageToken
  
  Lists the labels assigned to an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/labels"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn labels-create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:labelId string,
   :accountId string,
   :name string,
   :description string,
   :labelType string}
  
  Creates a new label, not assigned to any account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/labels"
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

(defn labels-patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/patch
  
  Required parameters: accountId, labelId
  
  Optional parameters: none
  
  Body: 
  
  {:labelId string,
   :accountId string,
   :name string,
   :description string,
   :labelType string}
  
  Updates a label."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:labelId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/labels/{labelId}"
     #{:labelId :accountId}
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

(defn labels-delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/delete
  
  Required parameters: accountId, labelId
  
  Optional parameters: none
  
  Deletes a label and removes it from all accounts to which it was assigned."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:labelId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/labels/{labelId}"
     #{:labelId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn returncarrier-create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/returncarrier/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:carrierAccountId string,
   :carrierAccountNumber string,
   :carrierAccountName string,
   :carrierCode string}
  
  Links return carrier to a merchant account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/returncarrier"
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

(defn returncarrier-patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/returncarrier/patch
  
  Required parameters: accountId, carrierAccountId
  
  Optional parameters: none
  
  Body: 
  
  {:carrierAccountId string,
   :carrierAccountNumber string,
   :carrierAccountName string,
   :carrierCode string}
  
  Updates a return carrier in the merchant account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:carrierAccountId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/returncarrier/{carrierAccountId}"
     #{:carrierAccountId :accountId}
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

(defn returncarrier-delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/returncarrier/delete
  
  Required parameters: accountId, carrierAccountId
  
  Optional parameters: none
  
  Delete a return carrier in the merchant account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:carrierAccountId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/returncarrier/{carrierAccountId}"
     #{:carrierAccountId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn returncarrier-list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/returncarrier/list
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Lists available return carriers in the merchant account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "accounts/{accountId}/returncarrier"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
