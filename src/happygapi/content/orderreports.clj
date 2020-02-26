(ns happygapi.content.orderreports
  "Content API for Shopping
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-content"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "content_schema.edn"))))

(defn listdisbursements$
  "Required parameters: disbursementStartDate, merchantId
  
  Optional parameters: disbursementEndDate, maxResults, pageToken
  
  Retrieves a report for disbursements from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"disbursementStartDate" "merchantId"})
         (json-schema/validate schemas args)]}
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
  "Required parameters: disbursementId, merchantId, transactionStartDate
  
  Optional parameters: maxResults, pageToken, transactionEndDate
  
  Retrieves a list of transactions for a disbursement from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"transactionStartDate" "disbursementId" "merchantId"})
         (json-schema/validate schemas args)]}
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
