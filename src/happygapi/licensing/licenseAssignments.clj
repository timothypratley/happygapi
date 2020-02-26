(ns happygapi.licensing.licenseAssignments
  "Licensing API
  Licensing API to view and manage licenses for your domain
  See: https://developers.google.com/admin-sdk/licensing/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "licensing_schema.edn"))))

(defn delete$
  "Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Revoke a license."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "userId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{"productId" "userId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Get a specific user's license by product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "userId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{"productId" "userId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: productId, skuId
  
  Optional parameters: none
  
  Assign a license."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"productId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user"
     #{"productId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))

(defn listForProduct$
  "Required parameters: customerId, productId
  
  Optional parameters: maxResults, pageToken
  
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/users"
     #{"productId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn listForProductAndSku$
  "Required parameters: customerId, productId, skuId
  
  Optional parameters: maxResults, pageToken
  
  List all users assigned licenses for a specific product SKU."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "customerId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/users"
     #{"productId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn patch$
  "Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Reassign a user's product SKU with a different SKU in the same product. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "userId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{"productId" "userId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: productId, skuId, userId
  
  Optional parameters: none
  
  Reassign a user's product SKU with a different SKU in the same product."
  {:scopes ["https://www.googleapis.com/auth/apps.licensing"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"productId" "userId" "skuId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/apps/licensing/v1/product/"
     "{productId}/sku/{skuId}/user/{userId}"
     #{"productId" "userId" "skuId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json,
      :content-type :json,
      :body (json/generate-string body)}
     auth))))
