(ns happygapi.androidpublisher.purchases
  "Google Play Developer API: purchases.
  Accesses Android application developers' Google Play accounts.
  See: https://developers.google.com/android-publisherapi/reference/rest/v3/purchases"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn products-acknowledge$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/products/acknowledge
  
  Required parameters: packageName, productId, token
  
  Optional parameters: none
  
  Body: 
  
  {:developerPayload string}
  
  Acknowledges a purchase of an inapp item."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys? parameters #{:packageName :productId :token})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/products/{productId}/tokens/{token}:acknowledge"
     #{:packageName :productId :token}
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

(defn products-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/products/get
  
  Required parameters: packageName, productId, token
  
  Optional parameters: none
  
  Checks the purchase and consumption status of an inapp item."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName :productId :token})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/products/{productId}/tokens/{token}"
     #{:packageName :productId :token}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-acknowledge$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/acknowledge
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Body: 
  
  {:developerPayload string}
  
  Acknowledges a subscription purchase."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:acknowledge"
     #{:packageName :token :subscriptionId}
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

(defn subscriptions-cancel$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/cancel
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Cancels a user's subscription purchase. The subscription remains valid until its expiration time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:cancel"
     #{:packageName :token :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-defer$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/defer
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Body: 
  
  {:deferralInfo {:desiredExpiryTimeMillis string,
                  :expectedExpiryTimeMillis string}}
  
  Defers a user's subscription purchase until a specified future expiration time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters body]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:defer"
     #{:packageName :token :subscriptionId}
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

(defn subscriptions-get$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/get
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Checks whether a user's subscription purchase is valid and returns its expiry time."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}"
     #{:packageName :token :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-refund$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/refund
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Refunds a user's subscription purchase, but the subscription remains valid until its expiration time and it will continue to recur."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:refund"
     #{:packageName :token :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn subscriptions-revoke$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/subscriptions/revoke
  
  Required parameters: packageName, subscriptionId, token
  
  Optional parameters: none
  
  Refunds and immediately revokes a user's subscription purchase. Access to the subscription will be terminated immediately and it will stop recurring."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys?
          parameters
          #{:packageName :token :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/subscriptions/{subscriptionId}/tokens/{token}:revoke"
     #{:packageName :token :subscriptionId}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))

(defn voidedpurchases-list$
  "https://developers.google.com/android-publisherapi/reference/rest/v3/purchases/voidedpurchases/list
  
  Required parameters: packageName
  
  Optional parameters: endTime, maxResults, startIndex, startTime, token, type
  
  Lists the purchases that were canceled, refunded or charged-back."
  {:scopes ["https://www.googleapis.com/auth/androidpublisher"]}
  [auth parameters]
  {:pre [(util/has-keys? parameters #{:packageName})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/androidpublisher/v3/applications/"
     "{packageName}/purchases/voidedpurchases"
     #{:packageName}
     parameters)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params parameters,
      :accept :json,
      :as :json}
     auth))))
