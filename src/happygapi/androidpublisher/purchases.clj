(ns happygapi.androidpublisher.purchases
  "Google Play Developer API
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisher"
  (:require [happygapi.util :as util]
            [clj-http.client :as http]
            [cheshire.core]))

(defn products-acknowledge$
  "Required parameters: packageName,productId,token
  
  Acknowledges a purchase of an inapp item."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys? args #{"token" "productId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/products/{productId}/tokens/{token}:acknowledge"
     #{"token" "productId" "packageName"}
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

(defn products-get$
  "Required parameters: packageName,productId,token
  
  Checks the purchase and consumption status of an inapp item."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"token" "productId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/products/{productId}/tokens/{token}"
     #{"token" "productId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-acknowledge$
  "Required parameters: packageName,subscriptionId,token
  
  Acknowledges a subscription purchase."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:acknowledge"
     #{"token" "subscriptionId" "packageName"}
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

(defn subscriptions-cancel$
  "Required parameters: packageName,subscriptionId,token
  
  Cancels a user's subscription purchase. The subscription remains valid until its expiration time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:cancel"
     #{"token" "subscriptionId" "packageName"}
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

(defn subscriptions-defer$
  "Required parameters: packageName,subscriptionId,token
  
  Defers a user's subscription purchase until a specified future expiration time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:defer"
     #{"token" "subscriptionId" "packageName"}
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

(defn subscriptions-get$
  "Required parameters: packageName,subscriptionId,token
  
  Checks whether a user's subscription purchase is valid and returns its expiry time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}"
     #{"token" "subscriptionId" "packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-refund$
  "Required parameters: packageName,subscriptionId,token
  
  Refunds a user's subscription purchase, but the subscription remains valid until its expiration time and it will continue to recur."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:refund"
     #{"token" "subscriptionId" "packageName"}
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

(defn subscriptions-revoke$
  "Required parameters: packageName,subscriptionId,token
  
  Refunds and immediately revokes a user's subscription purchase. Access to the subscription will be terminated immediately and it will stop recurring."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args body]
  {:pre [(util/has-keys?
          args
          #{"token" "subscriptionId" "packageName"})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:revoke"
     #{"token" "subscriptionId" "packageName"}
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

(defn voidedpurchases-list$
  "Required parameters: packageName
  
  Lists the purchases that were canceled, refunded or charged-back."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth args]
  {:pre [(util/has-keys? args #{"packageName"})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/voidedpurchases"
     #{"packageName"}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
