(ns happygapi.content.returnpolicy
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
  
  Batches multiple return policy related calls in a single request."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "returnpolicy/batch"
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

(defn delete$
  "Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Deletes a return policy for the given Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"returnPolicyId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy/{returnPolicyId}"
     #{"returnPolicyId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn get$
  "Required parameters: merchantId, returnPolicyId
  
  Optional parameters: none
  
  Gets a return policy of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"returnPolicyId" "merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy/{returnPolicyId}"
     #{"returnPolicyId" "merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: merchantId
  
  Optional parameters: none
  
  Inserts a return policy for the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy"
     #{"merchantId"}
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

(defn list$
  "Required parameters: merchantId
  
  Optional parameters: none
  
  Lists the return policies of the Merchant Center account."
  {:scopes ["https://www.googleapis.com/auth/content"]}
  [auth args]
  {:pre [(util/has-keys? args #{"merchantId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/content/v2.1/"
     "{merchantId}/returnpolicy"
     #{"merchantId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
