(ns happygapi.licensing.licenseAssignments
  "Licensing API: licenseAssignments.
  Licensing API to view and manage licenses for your domain
  See: https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn delete$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/delete
  
  Required parameters: productId, skuId, userId
  
  Optional parameters: none
  Revoke a license."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:productId :skuId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/get
  
  Required parameters: productId, skuId, userId
  
  Optional parameters: none
  Get a specific user's license by product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:productId :skuId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/insert
  
  Required parameters: productId, skuId
  
  Optional parameters: none
  
  Body: 
  
  {:userId string}
  
  Assign a license."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:productId :skuId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user"
     #{:productId :skuId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listForProduct$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/listForProduct
  
  Required parameters: customerId, productId
  
  Optional parameters: maxResults, pageToken
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:productId :customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/users"
     #{:productId :customerId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listForProductAndSku$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/listForProductAndSku
  
  Required parameters: customerId, productId, skuId
  
  Optional parameters: maxResults, pageToken
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{:productId :customerId :skuId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/users"
     #{:productId :customerId :skuId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/patch
  
  Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:etags string,
   :kind string,
   :productId string,
   :productName string,
   :selfLink string,
   :skuId string,
   :skuName string,
   :userId string}
  
  Reassign a user's product SKU with a different SKU in the same product. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:productId :skuId :userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/update
  
  Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Body: 
  
  {:etags string,
   :kind string,
   :productId string,
   :productName string,
   :selfLink string,
   :skuId string,
   :skuName string,
   :userId string}
  
  Reassign a user's product SKU with a different SKU in the same product."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:productId :skuId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     args)
    (merge-with
     merge
     {:content-type :json,
      :body (json/generate-string body),
      :throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
