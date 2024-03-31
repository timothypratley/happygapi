(ns happygapi.content.promotions
  "Content API for Shopping: promotions.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/promotions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/promotions/create
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:minimumPurchaseAmount {:value string, :currency string},
   :freeGiftValue {:value string, :currency string},
   :promotionStatus {:destinationStatuses [PromotionPromotionStatusDestinationStatus],
                     :promotionIssue [PromotionPromotionStatusPromotionIssue],
                     :creationDate string,
                     :lastUpdateDate string},
   :itemGroupIdExclusion [string],
   :freeGiftDescription string,
   :promotionUrl string,
   :offerType string,
   :promotionDisplayTimePeriod {:startTime string, :endTime string},
   :orderLimit integer,
   :itemIdExclusion [string],
   :couponValueType string,
   :redemptionChannel [string],
   :limitQuantity integer,
   :brandExclusion [string],
   :moneyBudget {:value string, :currency string},
   :promotionEffectiveDates string,
   :productTypeExclusion [string],
   :moneyOffAmount {:value string, :currency string},
   :freeGiftItemId string,
   :contentLanguage string,
   :promotionEffectiveTimePeriod {:startTime string, :endTime string},
   :promotionDisplayDates string,
   :shippingServiceNames [string],
   :brand [string],
   :limitValue {:value string, :currency string},
   :genericRedemptionCode string,
   :itemGroupId [string],
   :productApplicability string,
   :productType [string],
   :minimumPurchaseQuantity integer,
   :id string,
   :storeApplicability string,
   :longTitle string,
   :promotionDestinationIds [string],
   :storeCode [string],
   :getThisQuantityDiscounted integer,
   :targetCountry string,
   :promotionId string,
   :percentOff integer,
   :itemId [string],
   :storeCodeExclusion [string]}
  
  Inserts a promotion for your Merchant Center account. If the promotion already exists, then it updates the promotion instead. To [end or delete] (https://developers.google.com/shopping-content/guides/promotions#end_a_promotion) a promotion update the time period of the promotion to a time that has already passed."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/promotions"
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

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/promotions/get
  
  Required parameters: merchantId, id
  
  Optional parameters: none
  
  Retrieves a promotion from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:id :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/promotions/{id}"
     #{:id :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/promotions/list
  
  Required parameters: merchantId
  
  Optional parameters: pageSize, pageToken, countryCode, languageCode
  
  List all promotions from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/promotions"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
