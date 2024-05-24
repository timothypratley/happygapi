(ns happygapi.walletobjects.permissions
  "Google Wallet API: permissions.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/permissions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/permissions/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:permissions [{:role string, :emailAddress string}],
   :issuerId string}
  
  Updates the permissions for the given issuer."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/permissions/{resourceId}"
     #{:resourceId}
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
  "https://developers.google.com/pay/passesapi/reference/rest/v1/permissions/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the permissions for the given issuer id."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/permissions/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
