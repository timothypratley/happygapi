(ns happygapi.mybusinessverifications.locations
  "My Business Verifications API: locations.
  The My Business Verifications API provides an interface for taking verifications related actions for locations.
  See: https://developers.google.com/my-business/api/reference/rest/v1/locations"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn getVoiceOfMerchantState$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/getVoiceOfMerchantState
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets the VoiceOfMerchant state."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/{+name}/VoiceOfMerchantState"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn fetchVerificationOptions$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/fetchVerificationOptions
  
  Required parameters: location
  
  Optional parameters: none
  
  Body: 
  
  {:languageCode string, :context {:address PostalAddress}}
  
  Reports all eligible verification options for a location in a specific language."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:location})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/{+location}:fetchVerificationOptions"
     #{:location}
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

(defn verify$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/verify
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:method string,
   :languageCode string,
   :emailAddress string,
   :mailerContact string,
   :phoneNumber string,
   :token {:tokenString string},
   :context {:address PostalAddress}}
  
  Starts the verification process for a location."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/{+name}:verify"
     #{:name}
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

(defn verifications-complete$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/verifications/complete
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:pin string}
  
  Completes a `PENDING` verification. It is only necessary for non `AUTO` verification methods. `AUTO` verification request is instantly `VERIFIED` upon creation."
  {:scopes nil}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/{+name}:complete"
     #{:name}
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

(defn verifications-list$
  "https://developers.google.com/my-business/api/reference/rest/v1/locations/verifications/list
  
  Required parameters: parent
  
  Optional parameters: pageSize, pageToken
  
  List verifications of a location, ordered by create time."
  {:scopes nil}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://mybusinessverifications.googleapis.com/"
     "v1/{+parent}/verifications"
     #{:parent}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
