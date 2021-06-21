(ns happygapi.content.returnaddress
  "Content API for Shopping: returnaddress.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn custombatch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress/custombatch
  
  Required parameters: none
  
  Optional parameters: none
  
  Body: 
  
  {:entries [{:method string,
              :returnAddress ReturnAddress,
              :batchId integer,
              :returnAddressId string,
              :merchantId string}]}
  
  Batches multiple return address related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "returnaddress/batch"
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

(defn list$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress/list
  
  Required parameters: merchantId
  
  Optional parameters: pageToken, country, maxResults
  
  Lists the return addresses of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnaddress"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress/insert
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:country string,
   :returnAddressId string,
   :phoneNumber string,
   :label string,
   :address {:region string,
             :country string,
             :streetAddress [string],
             :recipientName string,
             :locality string,
             :postalCode string},
   :kind string}
  
  Inserts a return address for the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnaddress"
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

(defn delete$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress/delete
  
  Required parameters: merchantId, returnAddressId
  
  Optional parameters: none
  
  Deletes a return address for the given Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnAddressId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnaddress/{returnAddressId}"
     #{:returnAddressId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnaddress/get
  
  Required parameters: merchantId, returnAddressId
  
  Optional parameters: none
  
  Gets a return address of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnAddressId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnaddress/{returnAddressId}"
     #{:returnAddressId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
