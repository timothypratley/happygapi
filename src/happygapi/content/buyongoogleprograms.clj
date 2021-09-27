(ns happygapi.content.buyongoogleprograms
  "Content API for Shopping: buyongoogleprograms.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn activate$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/activate
  
  Required parameters: merchantId, regionCode
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Reactivates the BoG program in your Merchant Center account. Moves the program to the active state when allowed, e.g. when paused. Important: This method is only whitelisted for selected merchants."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}/activate"
     #{:regionCode :merchantId}
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

(defn requestreview$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/requestreview
  
  Required parameters: merchantId, regionCode
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Requests review and then activates the BoG program in your Merchant Center account for the first time. Moves the program to the REVIEW_PENDING state. Important: This method is only whitelisted for selected merchants."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}/requestreview"
     #{:regionCode :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/get
  
  Required parameters: merchantId, regionCode
  
  Optional parameters: none
  
  Retrieves a status of the BoG program for your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}"
     #{:regionCode :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/patch
  
  Required parameters: regionCode, merchantId
  
  Optional parameters: updateMask
  
  Body: 
  
  {:customerServicePendingPhoneRegionCode string,
   :participationStage string,
   :customerServiceVerifiedEmail string,
   :customerServiceVerifiedPhoneNumber string,
   :customerServiceVerifiedPhoneRegionCode string,
   :onlineSalesChannel string,
   :customerServicePendingPhoneNumber string,
   :customerServicePendingEmail string,
   :businessModel [string]}
  
  Updates the status of the BoG program for your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}"
     #{:regionCode :merchantId}
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

(defn onboard$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/onboard
  
  Required parameters: regionCode, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:customerServiceEmail string}
  
  Onboards the BoG program in your Merchant Center account. By using this method, you agree to the [Terms of Service](https://merchants.google.com/mc/termsofservice/transactions/US/latest). Calling this method is only possible if the authenticated account is the same as the merchant id in the request. Calling this method multiple times will only accept Terms of Service if the latest version is not currently signed."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}/onboard"
     #{:regionCode :merchantId}
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

(defn pause$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/buyongoogleprograms/pause
  
  Required parameters: regionCode, merchantId
  
  Optional parameters: none
  
  Body: 
  
  {}
  
  Pauses the BoG program in your Merchant Center account. Important: This method is only whitelisted for selected merchants."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:regionCode :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/buyongoogleprograms/{regionCode}/pause"
     #{:regionCode :merchantId}
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
