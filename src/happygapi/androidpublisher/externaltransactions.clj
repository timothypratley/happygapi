(ns happygapi.androidpublisher.externaltransactions
  "Google Play Android Developer API: externaltransactions.
  Lets Android application developers access their Google Play accounts. At a high level, the expected workflow is to \"insert\" an Edit, make changes as necessary, and then \"commit\" it. 
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/externaltransactions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn createexternaltransaction$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/externaltransactions/createexternaltransaction
  
  Required parameters: parent
  
  Optional parameters: externalTransactionId
  
  Body: 
  
  {:packageName string,
   :currentPreTaxAmount {:priceMicros string, :currency string},
   :oneTimeTransaction {:externalTransactionToken string},
   :currentTaxAmount {:priceMicros string, :currency string},
   :transactionTime string,
   :createTime string,
   :externalTransactionId string,
   :transactionState string,
   :originalTaxAmount {:priceMicros string, :currency string},
   :originalPreTaxAmount {:priceMicros string, :currency string},
   :testPurchase {},
   :userTaxAddress {:regionCode string, :administrativeArea string},
   :recurringTransaction {:initialExternalTransactionId string,
                          :externalTransactionToken string,
                          :migratedTransactionProgram string,
                          :externalSubscription ExternalSubscription}}
  
  Creates a new external transaction."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:parent})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+parent}/externalTransactions"
     #{:parent}
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

(defn refundexternaltransaction$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/externaltransactions/refundexternaltransaction
  
  Required parameters: name
  
  Optional parameters: none
  
  Body: 
  
  {:partialRefund {:refundId string, :refundPreTaxAmount Price},
   :fullRefund {},
   :refundTime string}
  
  Refunds or partially refunds an existing external transaction."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+name}:refund"
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

(defn getexternaltransaction$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/externaltransactions/getexternaltransaction
  
  Required parameters: name
  
  Optional parameters: none
  
  Gets an existing external transaction."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:name})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://androidpublisher.googleapis.com/"
     "androidpublisher/v3/{+name}"
     #{:name}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
