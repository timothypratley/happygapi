(ns happygapi.walletobjects.smarttap
  "Google Wallet API: smarttap.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesapi/reference/rest/v1/smarttap"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/smarttap/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:id string,
   :infos [{:signUpInfo SignUpInfo,
            :action string,
            :url string,
            :value string}],
   :kind string,
   :merchantId string}
  
  Inserts the smart tap."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/smartTap"
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
