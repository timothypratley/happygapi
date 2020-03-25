(ns happygapi.content.orderreports
  "Content API for Shopping: orderreports.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreports"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn listdisbursements$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreports/listdisbursements
  
  Required parameters: disbursementStartDate, merchantId
  
  Optional parameters: disbursementEndDate, maxResults, pageToken
  
  Retrieves a report for disbursements from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:disbursementStartDate :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements"
     #{:disbursementStartDate :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listtransactions$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/orderreports/listtransactions
  
  Required parameters: disbursementId, merchantId, transactionStartDate
  
  Optional parameters: maxResults, pageToken, transactionEndDate
  
  Retrieves a list of transactions for a disbursement from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:transactionStartDate :disbursementId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements/{disbursementId}/transactions"
     #{:transactionStartDate :disbursementId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
