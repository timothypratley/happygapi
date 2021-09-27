(ns happygapi.content.freelistingsprogram
  "Content API for Shopping: freelistingsprogram.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/freelistingsprogram"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn requestreview$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/freelistingsprogram/requestreview
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:regionCode string}
  
  Requests a review for Free Listings program in the provided region. Important: This method is only whitelisted for selected merchants."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/freelistingsprogram/requestreview"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/freelistingsprogram/get
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Retrieves the status and review eligibility for the free listing program."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/freelistingsprogram"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
