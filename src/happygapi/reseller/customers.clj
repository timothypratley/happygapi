(ns happygapi.reseller.customers
  "Enterprise Apps Reseller API
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn get$
  "Required parameters: customerId
  
  Get a customer account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customerId"})]}
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
  
  Order a new customer's account."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{})]}
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
      :body body}
     auth))))

(defn patch$
  "Required parameters: customerId
  
  Update a customer account's settings. This method supports patch semantics."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customerId"})]}
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
  
  Update a customer account's settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{"customerId"})]}
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
      :as :json}
     auth))))
