(ns happygapi.reseller.subscriptions
  "Enterprise Apps Reseller API: subscriptions.
  Creates and manages your customers and their subscriptions.
  See: https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions"
  (:require [cheshire.core :as json]
            [clj-http.client :as http]
            [happy.util :as util]))

(defn get$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/get
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  Get a specific subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/get
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}"
     #{:customerId :subscriptionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn insert$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/insert
  
  Required parameters: customerId
  
  Optional parameters: customerAuthToken
  
  Body: 
  
  {:skuName string,
   :creationTime string,
   :purchaseOrderId string,
   :billingMethod string,
   :trialSettings {:isInTrial boolean, :trialEndTime string},
   :suspensionReasons [string],
   :resourceUiUrl string,
   :customerId string,
   :transferInfo {:minimumTransferableSeats integer,
                  :transferabilityExpirationTime string},
   :customerDomain string,
   :status string,
   :kind string,
   :skuId string,
   :seats {:kind string,
           :licensedNumberOfSeats integer,
           :maximumNumberOfSeats integer,
           :numberOfSeats integer},
   :plan {:commitmentInterval {:endTime string, :startTime string},
          :isCommitmentPlan boolean,
          :planName string},
   :renewalSettings {:kind string, :renewalType string},
   :dealCode string,
   :subscriptionId string}
  
  Create or transfer a subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions"
     #{:customerId}
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

(defn changeRenewalSettings$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changeRenewalSettings
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string, :renewalType string}
  
  Update a user license's renewal settings. This is applicable for accounts with annual commitment plans only."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changeRenewalSettings"
     #{:customerId :subscriptionId}
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

(defn delete$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/delete
  
  Required parameters: customerId, deletionType, subscriptionId
  
  Optional parameters: none
  Cancel, suspend, or transfer a subscription to direct."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys?
          args
          #{:customerId :deletionType :subscriptionId})]}
  (util/get-response
   (http/delete
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}"
     #{:customerId :deletionType :subscriptionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn suspend$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/suspend
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  Suspends an active subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/suspend"
     #{:customerId :subscriptionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn list$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/list
  
  Required parameters: none
  
  Optional parameters: customerAuthToken, customerId, customerNamePrefix, maxResults, pageToken
  List of subscriptions managed by the reseller. The list can be all subscriptions, all of a customer's subscriptions, or all of a customer's transferable subscriptions."
  {:scopes ["https://www.googleapis.com/auth/apps.order"
            "https://www.googleapis.com/auth/apps.order.readonly"]}
  [auth args]
  {:pre [(util/has-keys? args #{})]}
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
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changePlan
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:dealCode string,
   :kind string,
   :planName string,
   :purchaseOrderId string,
   :seats {:kind string,
           :licensedNumberOfSeats integer,
           :maximumNumberOfSeats integer,
           :numberOfSeats integer}}
  
  Update a subscription plan. Use this method to update a plan for a 30-day trial or a flexible plan subscription to an annual commitment plan with monthly or yearly payments."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changePlan"
     #{:customerId :subscriptionId}
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

(defn changeSeats$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/changeSeats
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  
  Body: 
  
  {:kind string,
   :licensedNumberOfSeats integer,
   :maximumNumberOfSeats integer,
   :numberOfSeats integer}
  
  Update a subscription's user license settings."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args body]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/changeSeats"
     #{:customerId :subscriptionId}
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

(defn activate$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/activate
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  Activates a subscription previously suspended by the reseller"
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/activate"
     #{:customerId :subscriptionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))

(defn startPaidService$
  "https://developers.google.com/google-apps/reseller/api/reference/rest/v1/subscriptions/startPaidService
  
  Required parameters: customerId, subscriptionId
  
  Optional parameters: none
  Immediately move a 30-day free trial subscription to a paid service subscription."
  {:scopes ["https://www.googleapis.com/auth/apps.order"]}
  [auth args]
  {:pre [(util/has-keys? args #{:customerId :subscriptionId})]}
  (util/get-response
   (http/post
    (util/get-url
     "https://www.googleapis.com/apps/reseller/v1/"
     "customers/{customerId}/subscriptions/{subscriptionId}/startPaidService"
     #{:customerId :subscriptionId}
     args)
    (merge-with
     merge
     {:throw-exceptions false,
      :query-params args,
      :accept :json,
      :as :json}
     auth))))
