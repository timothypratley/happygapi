(ns happygapi.content.accounts
  "Content API for Shopping: accounts.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/get
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Retrieves a Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:websiteUrl string,
   :name string,
   :adsLinks [{:adsId string, :status string}],
   :businessInformation {:address AccountAddress,
                         :customerService AccountCustomerService,
                         :phoneNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:gmbEmail string, :status string},
   :users [{:admin boolean,
            :emailAddress string,
            :orderManager boolean,
            :paymentsAnalyst boolean,
            :paymentsManager boolean}]}
  
  Creates a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/authinfo
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns information about the authenticated user."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/claimwebsite
  
  Required parameters: accountId, merchantId
  
  Optional parameters: overwrite
  
  Claims the website of a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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

(defn update$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/update
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:websiteUrl string,
   :name string,
   :adsLinks [{:adsId string, :status string}],
   :businessInformation {:address AccountAddress,
                         :customerService AccountCustomerService,
                         :phoneNumber string},
   :id string,
   :kind string,
   :sellerId string,
   :adultContent boolean,
   :youtubeChannelLinks [{:channelId string, :status string}],
   :googleMyBusinessLink {:gmbEmail string, :status string},
   :users [{:admin boolean,
            :emailAddress string,
            :orderManager boolean,
            :paymentsAnalyst boolean,
            :paymentsManager boolean}]}
  
  Updates a Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/delete
  
  Required parameters: accountId, merchantId
  
  Optional parameters: force
  
  Deletes a Merchant Center sub-account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/list
  
  Required parameters: merchantId
  
  Optional parameters: maxResults, pageToken
  
  Lists the sub-accounts in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/link
  
  Required parameters: accountId, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:action string,
   :linkType string,
   :linkedAccountId string,
   :services [string]}
  
  Performs an action on a link between two Merchant Center accounts, namely accountId and linkedAccountId."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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

(defn listlinks$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/listlinks
  
  Required parameters: accountId, merchantId
  
  Optional parameters: maxResults, pageToken
  
  Returns the list of accounts linked to your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:accountId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/accounts/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:account Account,
              :accountId string,
              :batchId integer,
              :force boolean,
              :linkRequest AccountsCustomBatchRequestEntryLinkRequest,
              :merchantId string,
              :method string,
              :overwrite boolean}]}
  
  Retrieves, inserts, updates, and deletes multiple Merchant Center (sub-)accounts in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
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
