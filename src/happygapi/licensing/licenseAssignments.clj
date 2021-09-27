(ns happygapi.licensing.licenseAssignments
  "Enterprise License Manager API: licenseAssignments.
  The Google Enterprise License Manager API's allows you to license apps for all the users of a domain managed by you.
  See: https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn update$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/update
  
  Required parameters: userId, productId, skuId
  
  Optional parameters: none
  
  Body: 
  
  {:productName string,
   :kind string,
   :userId string,
   :skuName string,
   :etags string,
   :productId string,
   :skuId string,
   :selfLink string}
  
  Reassign a user's product SKU with a different SKU in the same product."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :skuId :userId})]}
  (util/get-response
   (http/put
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
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

(defn get$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/get
  
  Required parameters: skuId, userId, productId
  
  Optional parameters: none
  
  Get a specific user's license by product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :skuId :userId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn listForProductAndSku$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/listForProductAndSku
  
  Required parameters: productId, skuId, customerId
  
  Optional parameters: pageToken, maxResults
  
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :customerId :skuId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/users"
     #{:productId :customerId :skuId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
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
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :skuId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/user"
     #{:productId :skuId}
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
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/delete
  
  Required parameters: skuId, userId, productId
  
  Optional parameters: none
  
  Revoke a license."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :skuId :userId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/patch
  
  Required parameters: productId, userId, skuId
  
  Optional parameters: none
  
  Body: 
  
  {:productName string,
   :kind string,
   :userId string,
   :skuName string,
   :etags string,
   :productId string,
   :skuId string,
   :selfLink string}
  
  Reassign a user's product SKU with a different SKU in the same product. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:productId :skuId :userId})]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/sku/{skuId}/user/{userId}"
     #{:productId :skuId :userId}
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

(defn listForProduct$
  "https://developers.google.com/admin-sdk/licensing/api/reference/rest/v1/licenseAssignments/listForProduct
  
  Required parameters: customerId, productId
  
  Optional parameters: pageToken, maxResults
  
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:productId :customerId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://licensing.googleapis.com/"
     "apps/licensing/v1/product/{productId}/users"
     #{:productId :customerId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
