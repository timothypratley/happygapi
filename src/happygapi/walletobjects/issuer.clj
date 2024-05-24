(ns happygapi.walletobjects.issuer
  "Google Wallet API: issuer.
  API for issuers to save and manage Google Wallet Objects.
  See: https://developers.google.com/pay/passesdocs/reference/rest/v1/issuer"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/issuer/get
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Returns the issuer with the given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/issuer/{resourceId}"
     #{:resourceId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/issuer/list
  
  Required parameters: none
  
  Optional parameters: none
  
  Returns a list of all issuers shared to the caller."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/issuer"
     #{}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/issuer/patch
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:homepageUrl string,
   :smartTapMerchantData {:smartTapMerchantId string,
                          :authenticationKeys [AuthenticationKey]},
   :name string,
   :issuerId string,
   :contactInfo {:phone string,
                 :alertsEmails [string],
                 :name string,
                 :email string},
   :callbackOptions {:updateRequestUrl string, :url string}}
  
  Updates the issuer referenced by the given issuer ID. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/issuer/{resourceId}"
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

(defn insert$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/issuer/insert
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:homepageUrl string,
   :smartTapMerchantData {:smartTapMerchantId string,
                          :authenticationKeys [AuthenticationKey]},
   :name string,
   :issuerId string,
   :contactInfo {:phone string,
                 :alertsEmails [string],
                 :name string,
                 :email string},
   :callbackOptions {:updateRequestUrl string, :url string}}
  
  Inserts an issuer with the given ID and properties."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/issuer"
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

(defn update$
  "https://developers.google.com/pay/passesapi/reference/rest/v1/issuer/update
  
  Required parameters: resourceId
  
  Optional parameters: none
  
  Body: 
  
  {:homepageUrl string,
   :smartTapMerchantData {:smartTapMerchantId string,
                          :authenticationKeys [AuthenticationKey]},
   :name string,
   :issuerId string,
   :contactInfo {:phone string,
                 :alertsEmails [string],
                 :name string,
                 :email string},
   :callbackOptions {:updateRequestUrl string, :url string}}
  
  Updates the issuer referenced by the given issuer ID."
  {:scopes ["https://www.googleapis.com/auth/wallet_object.issuer"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:resourceId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://walletobjects.googleapis.com/"
     "walletobjects/v1/issuer/{resourceId}"
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
