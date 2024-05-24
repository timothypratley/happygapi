(ns happygapi.content.merchantsupport
  "Content API for Shopping: merchantsupport.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/merchantsupport"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn renderaccountissues$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/merchantsupport/renderaccountissues
  
  Required parameters: merchantId
  
  Optional parameters: languageCode, timeZone
  
  Body: 
  
  {:contentOption string, :userInputActionOption string}
  
  Provide a list of merchant's issues with a support content and available actions. This content and actions are meant to be rendered and shown in third-party applications."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/merchantsupport/renderaccountissues"
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

(defn renderproductissues$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/merchantsupport/renderproductissues
  
  Required parameters: merchantId, productId
  
  Optional parameters: languageCode, timeZone
  
  Body: 
  
  {:contentOption string, :userInputActionOption string}
  
  Provide a list of issues for merchant's product with a support content and available actions. This content and actions are meant to be rendered and shown in third-party applications."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/merchantsupport/renderproductissues/{productId}"
     #{:productId :merchantId}
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

(defn triggeraction$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/merchantsupport/triggeraction
  
  Required parameters: merchantId
  
  Optional parameters: languageCode
  
  Body: 
  
  {:actionContext string,
   :actionInput {:actionFlowId string, :inputValues [InputValue]}}
  
  Start an action. The action can be requested by merchants in third-party application. Before merchants can request the action, the third-party application needs to show them action specific content and display a user input form. The action can be successfully started only once all `required` inputs are provided. If any `required` input is missing, or invalid value was provided, the service will return 400 error. Validation errors will contain Ids for all problematic field together with translated, human readable error messages that can be shown to the user."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/merchantsupport/triggeraction"
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
