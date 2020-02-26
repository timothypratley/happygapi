(ns happygapi.content.productstatuses
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

(defn custombatch$
  "Required parameters: none
  
  Optional parameters: none
  
  Gets the statuses of multiple products in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "productstatuses/batch"
     #{}
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

(defn get$
  "Required parameters: merchantId, productId
  
  Optional parameters: destinations
  
  Gets the status of a product from your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"productId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/productstatuses/{productId}"
     #{"productId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "Required parameters: merchantId
  
  Optional parameters: destinations, maxResults, pageToken
  
  Lists the statuses of the products in your Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/productstatuses"
     #{"merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
