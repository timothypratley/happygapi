(ns happygapi.content.shoppingadsprogram
  "Content API for Shopping: shoppingadsprogram.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shoppingadsprogram"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shoppingadsprogram/get
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves the status and review eligibility for the Shopping Ads program. Returns errors and warnings if they require action to resolve, will become disapprovals, or impact impressions. Use `accountstatuses` to view all issues for an account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/shoppingadsprogram"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn requestreview$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/shoppingadsprogram/requestreview
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:regionCode string}
  
  Requests a review of Shopping ads in a specific region. This method deprecated. Use the `MerchantSupportService` to view product and account issues and request a review."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/shoppingadsprogram/requestreview"
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
