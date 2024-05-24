(ns happygapi.addressvalidation.v1
  "Address Validation API: v1.
  The Address Validation API allows developers to verify the accuracy of addresses. Given an address, it returns information about the correctness of the components of the parsed address, a geocode, and a verdict on the deliverability of the parsed address.
  See: https://developers.google.com/maps/documentation/addressvalidationdocs/reference/rest/v1/v1"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn $
  "https://developers.google.com/maps/documentation/addressvalidationapi/reference/rest/v1/provideValidationFeedback
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:responseId string, :conclusion string}
  
  Feedback about the outcome of the sequence of validation attempts. This should be the last call made after a sequence of validation calls for the same address, and should be called once the transaction is concluded. This should only be sent once for the sequence of `ValidateAddress` requests needed to validate an address fully."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.addressvalidation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://addressvalidation.googleapis.com/"
     "v1:provideValidationFeedback"
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

(defn $
  "https://developers.google.com/maps/documentation/addressvalidationapi/reference/rest/v1/validateAddress
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:previousResponseId string,
   :enableUspsCass boolean,
   :address {:sortingCode string,
             :locality string,
             :revision integer,
             :administrativeArea string,
             :addressLines [string],
             :organization string,
             :recipients [string],
             :languageCode string,
             :regionCode string,
             :postalCode string,
             :sublocality string},
   :sessionToken string,
   :languageOptions {:returnEnglishLatinAddress boolean}}
  
  Validates an address."
  {:scopes ["https://www.googleapis.com/auth/cloud-platform"
            "https://www.googleapis.com/auth/maps-platform.addressvalidation"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://addressvalidation.googleapis.com/"
     "v1:validateAddress"
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
