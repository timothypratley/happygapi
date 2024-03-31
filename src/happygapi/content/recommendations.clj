(ns happygapi.content.recommendations
  "Content API for Shopping: recommendations.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/recommendations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn generate$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/recommendations/generate
  
  Required parameters: merchantId
  
  Optional parameters: languageCode, allowedTag
  
  Generates recommendations for a merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/recommendations/generate"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn reportInteraction$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/recommendations/reportInteraction
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:interactionType string,
   :responseToken string,
   :type string,
   :subtype string}
  
  Reports an interaction on a recommendation for a merchant."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/recommendations/reportInteraction"
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
