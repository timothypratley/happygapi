(ns happygapi.content.returnpolicyonline
  "Content API for Shopping: returnpolicyonline.
  Manage your product listings and accounts for Google Shopping
  See: https://developers.google.com/shopping-content/v2/docs/reference/rest/v2.1/returnpolicyonline"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnpolicyonline/get
  
  Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Gets an existing return policy."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnPolicyId :merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicyonline/{returnPolicyId}"
     #{:returnPolicyId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn create$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnpolicyonline/create
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :returnPolicyUri string,
   :itemConditions [string],
   :countries [string],
   :policy {:type string, :days string},
   :returnPolicyId string,
   :returnReasonCategoryInfo [{:returnReasonCategory string,
                               :returnLabelSource string,
                               :returnShippingFee ReturnPolicyOnlineReturnShippingFee}],
   :returnMethods [string],
   :label string,
   :restockingFee {:fixedFee PriceAmount, :microPercent integer}}
  
  Creates a new return policy."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicyonline"
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnpolicyonline/delete
  
  Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Deletes an existing return policy."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:returnPolicyId :merchantId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicyonline/{returnPolicyId}"
     #{:returnPolicyId :merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnpolicyonline/patch
  
  Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Body: 
  
  {:name string,
   :returnPolicyUri string,
   :itemConditions [string],
   :countries [string],
   :policy {:type string, :days string},
   :returnPolicyId string,
   :returnReasonCategoryInfo [{:returnReasonCategory string,
                               :returnLabelSource string,
                               :returnShippingFee ReturnPolicyOnlineReturnShippingFee}],
   :returnMethods [string],
   :label string,
   :restockingFee {:fixedFee PriceAmount, :microPercent integer}}
  
  Updates an existing return policy."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:returnPolicyId :merchantId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicyonline/{returnPolicyId}"
     #{:returnPolicyId :merchantId}
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
  "https://developers.google.com/shopping-content/v2/api/reference/rest/v2.1/returnpolicyonline/list
  
  Required parameters: merchantId
  
  Optional parameters: none
  
  Lists all existing return policies."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:merchantId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://shoppingcontent.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicyonline"
     #{:merchantId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
