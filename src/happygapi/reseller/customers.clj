(ns happygapi.reseller.customers
  "Enterprise Apps Reseller API
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "reseller_schema.edn"))))

(defn get$
  "Required parameters: customerId
  
  Optional parameters: none
  
  Get a customer account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{"customerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: none
  
  Optional parameters: customerAuthToken
  
  Order a new customer's account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers"
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

(defn patch$
  "Required parameters: customerId
  
  Optional parameters: none
  
  Update a customer account's settings. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/patch
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{"customerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn update$
  "Required parameters: customerId
  
  Optional parameters: none
  
  Update a customer account's settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/put
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}"
     #{"customerId"}
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
