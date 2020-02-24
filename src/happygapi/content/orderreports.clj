(ns happygapi.content.orderreports
  "Content API for Shopping
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-content"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn listdisbursements$
  "Required parameters: disbursementStartDate,merchantId
  
  Retrieves a report for disbursements from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"disbursementStartDate" "merchantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements"
     #{"merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listtransactions$
  "Required parameters: disbursementId,merchantId,transactionStartDate
  
  Retrieves a list of transactions for a disbursement from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"transactionStartDate" "disbursementId" "merchantId"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/orderreports/disbursements/{disbursementId}/transactions"
     #{"disbursementId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
