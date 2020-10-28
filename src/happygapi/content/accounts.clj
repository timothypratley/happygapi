(ns happygapi.content.accounts
  "Content API for Shopping: accounts.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/get
  
  Required parameters: accountId, merchantId
  
  Optional parameters: view
  
  Retrieves a Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}"
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
  
  {:websiteUrl string,
   :labelIds [string],
   :name string,
   :adsLinks [{:status string, :adsId string}],
   :businessInformation {:address AccountAddress,
                         :customerService AccountCustomerService,
                         :phoneNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :cssId string,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:status string,
                          :gmbEmail string,
                          :gmbAccountId string},
   :users [{:emailAddress string,
            :admin boolean,
            :paymentsManager boolean,
            :orderManager boolean,
            :paymentsAnalyst boolean}]}
  
  Creates a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts"
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
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/authinfo"
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
  
  Required parameters: accountId, merchantId
  
  Optional parameters: overwrite
  
  Claims the website of a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}/claimwebsite"
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
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}/updatelabels"
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
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:websiteUrl string,
   :labelIds [string],
   :name string,
   :adsLinks [{:status string, :adsId string}],
   :businessInformation {:address AccountAddress,
                         :customerService AccountCustomerService,
                         :phoneNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :cssId string,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:status string,
                          :gmbEmail string,
                          :gmbAccountId string},
   :users [{:emailAddress string,
            :admin boolean,
            :paymentsManager boolean,
            :orderManager boolean,
            :paymentsAnalyst boolean}]}
  
  Updates a Merchant Center account. Any fields that are not provided are deleted from the resource."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}"
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
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}"
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
  
  Optional parameters: label, maxResults, view, pageToken
  
  Lists the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts"
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
  
  {:linkType string,
   :linkedAccountId string,
   :action string,
   :services [string]}
  
  Performs an action on a link between two Merchant Center accounts, namely accountId and linkedAccountId."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}/link"
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
  
  Required parameters: accountId, merchantId
  
  Optional parameters: pageToken, maxResults
  
  Returns the list of accounts linked to your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/{merchantId}/accounts/{accountId}/listlinks"
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
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/batch"
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

(defn labels-list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/list
  
  Required parameters: accountId
  
  Optional parameters: pageToken, pageSize
  
  Lists the labels assigned to an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/{accountId}/labels"
     #{:accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn labels-patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/patch
  
  Required parameters: labelId, accountId
  
  Optional parameters: none
  
  Body: 
  
  {:labelId string,
   :description string,
   :accountId string,
   :name string}
  
  Updates a label."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:labelId :accountId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/{accountId}/labels/{labelId}"
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

(defn labels-create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/create
  
  Required parameters: accountId
  
  Optional parameters: none
  
  Body: 
  
  {:labelId string,
   :description string,
   :accountId string,
   :name string}
  
  Creates a new label, not assigned to any account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/{accountId}/labels"
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

(defn labels-delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/accounts/labels/delete
  
  Required parameters: labelId, accountId
  
  Optional parameters: none
  
  Deletes a label and removes it from all accounts to which it was assigned."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:labelId :accountId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/"
     "content/v2.1/accounts/{accountId}/labels/{labelId}"
     #{:labelId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
