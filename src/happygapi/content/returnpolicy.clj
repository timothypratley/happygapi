(ns happygapi.content.returnpolicy
  "Content API for Shopping: returnpolicy.
  Manages product items, inventory, and Merchant Center accounts for Google Shopping.
  See: https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:batchId integer,
              :merchantId string,
              :method string,
              :returnPolicy ReturnPolicy,
              :returnPolicyId string}]}
  
  Batches multiple return policy related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "returnpolicy/batch"
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

(defn delete$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy/delete
  
  Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Deletes a return policy for the given Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnPolicyId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy/{returnPolicyId}"
     #{:returnPolicyId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy/get
  
  Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Gets a return policy of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnPolicyId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy/{returnPolicyId}"
     #{:returnPolicyId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:country string,
   :kind string,
   :label string,
   :name string,
   :nonFreeReturnReasons [string],
   :policy {:lastReturnDate string, :numberOfDays string, :type string},
   :returnPolicyId string,
   :seasonalOverrides [{:endDate string,
                        :name string,
                        :policy ReturnPolicyPolicy,
                        :startDate string}]}
  
  Inserts a return policy for the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy"
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

(defn list$
  "https://developers.google.com/shopping-contentapi/reference/rest/v2.1/returnpolicy/list
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Lists the return policies of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
