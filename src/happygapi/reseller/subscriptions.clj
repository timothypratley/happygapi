(ns happygapi.reseller.subscriptions
  "Enterprise Apps Reseller API
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/"
  (:require [cheshire.core]
            [clj-http.client :as http]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [happy.util :as util]
            [json-schema.core :as json-schema]))

(def schemas
  (edn/read-string (slurp (io/resource "reseller_schema.edn"))))

(defn get$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Get a specific subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}"
     #{"subscriptionId" "customerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "Required parameters: customerId
  
  Optional parameters: customerAuthToken
  
  Create or transfer a subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions"
     #{"customerId"}
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

(defn changeRenewalSettings$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Update a user license's renewal settings. This is applicable for accounts with annual commitment plans only."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changeRenewalSettings"
     #{"subscriptionId" "customerId"}
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

(defn delete$
  "Required parameters: customerId, deletionType, subscriptionId
  
  Optional parameters: none
  
  Cancel, suspend, or transfer a subscription to direct."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"deletionType" "subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}"
     #{"subscriptionId" "customerId"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn suspend$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Suspends an active subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/suspend"
     #{"subscriptionId" "customerId"}
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

(defn list$
  "Required parameters: none
  
  Optional parameters: customerAuthToken, customerId, customerNamePrefix, maxResults, pageToken
  
  List of subscriptions managed by the reseller. The list can be all subscriptions, all of a customer's subscriptions, or all of a customer's transferable subscriptions."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "subscriptions"
     #{}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn changePlan$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Update a subscription plan. Use this method to update a plan for a 30-day trial or a flexible plan subscription to an annual commitment plan with monthly or yearly payments."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changePlan"
     #{"subscriptionId" "customerId"}
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

(defn changeSeats$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Update a subscription's user license settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changeSeats"
     #{"subscriptionId" "customerId"}
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

(defn activate$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Activates a subscription previously suspended by the reseller"
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/activate"
     #{"subscriptionId" "customerId"}
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

(defn startPaidService$
  "Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Immediately move a 30-day free trial subscription to a paid service subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"subscriptionId" "customerId"})
         (json-schema/validate schemas args)]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/startPaidService"
     #{"subscriptionId" "customerId"}
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
