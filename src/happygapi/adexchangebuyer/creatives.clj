(ns happygapi.adexchangebuyer.creatives
  "Ad Exchange Buyer API: creatives.
  Accesses your bidding-account information, submits creatives for validation, finds available direct deals, and retrieves performance reports.
  See: https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn addDeal$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/addDeal
  
  Required parameters: accountId, buyerCreativeId, dealId
  
  Optional parameters: none
  
  Add a deal id association for the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:buyerCreativeId :dealId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/addDeal/{dealId}"
     #{:buyerCreativeId :dealId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/get
  
  Required parameters: accountId, buyerCreativeId
  
  Optional parameters: none
  
  Gets the status for a single creative. A creative will be available 30-40 minutes after submission."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:buyerCreativeId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}"
     #{:buyerCreativeId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:attribute [integer],
   :servingRestrictions [{:contexts [{:auctionType [string],
                                      :contextType string,
                                      :geoCriteriaId [integer],
                                      :platform [string]}],
                          :disapprovalReasons [{:details [string],
                                                :reason string}],
                          :reason string}],
   :clickThroughUrl [string],
   :buyerCreativeId string,
   :advertiserName string,
   :adTechnologyProviders {:detectedProviderIds [string],
                           :hasUnidentifiedProvider boolean},
   :adChoicesDestinationUrl string,
   :sensitiveCategories [integer],
   :dealsStatus string,
   :width integer,
   :openAuctionStatus string,
   :restrictedCategories [integer],
   :corrections [{:contexts [{:auctionType [string],
                              :contextType string,
                              :geoCriteriaId [integer],
                              :platform [string]}],
                  :details [string],
                  :reason string}],
   :videoVastXML string,
   :detectedDomains [string],
   :advertiserId [string],
   :productCategories [integer],
   :kind string,
   :agencyId string,
   :apiUploadTimestamp string,
   :videoURL string,
   :creativeStatusIdentityType string,
   :version integer,
   :languages [string],
   :accountId integer,
   :vendorType [integer],
   :HTMLSnippet string,
   :filteringReasons {:date string,
                      :reasons [{:filteringCount string,
                                 :filteringStatus integer}]},
   :impressionTrackingUrl [string],
   :height integer,
   :nativeAd {:clickLinkUrl string,
              :headline string,
              :starRating number,
              :advertiser string,
              :logo {:height integer, :url string, :width integer},
              :appIcon {:height integer, :url string, :width integer},
              :callToAction string,
              :clickTrackingUrl string,
              :image {:height integer, :url string, :width integer},
              :videoURL string,
              :body string,
              :price string,
              :impressionTrackingUrl [string]}}
  
  Submit a new creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives"
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

(defn list$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/list
  
  Required parameters: none
  
  Optional parameters: accountId, buyerCreativeId, dealsStatusFilter, maxResults, openAuctionStatusFilter, pageToken
  
  Retrieves a list of the authenticated user's active creatives. A creative will be available 30-40 minutes after submission."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listDeals$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/listDeals
  
  Required parameters: accountId, buyerCreativeId
  
  Optional parameters: none
  
  Lists the external deal ids associated with the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:buyerCreativeId :accountId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/listDeals"
     #{:buyerCreativeId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn removeDeal$
  "https://developers.google.com/ad-exchange/buyer-restapi/reference/rest/v1.4/creatives/removeDeal
  
  Required parameters: accountId, buyerCreativeId, dealId
  
  Optional parameters: none
  
  Remove a deal id associated with the creative."
  {:scopes ["https://www.googleapis.com/auth/adexchange.buyer"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:buyerCreativeId :dealId :accountId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/adexchangebuyer/v1.4/"
     "creatives/{accountId}/{buyerCreativeId}/removeDeal/{dealId}"
     #{:buyerCreativeId :dealId :accountId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
