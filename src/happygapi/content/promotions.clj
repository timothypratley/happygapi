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
   :itemGroupIdExclusion [string],
   :freeGiftDescription string,
   :offerType string,
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
   :longTitle string,
   :promotionDestinationIds [string],
   :getThisQuantityDiscounted integer,
   :targetCountry string,
   :promotionId string,
   :percentOff integer,
   :itemId [string]}
  
  Inserts a promotion for your Merchant Center account. If the promotion already exists, then it will update the promotion instead."
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
